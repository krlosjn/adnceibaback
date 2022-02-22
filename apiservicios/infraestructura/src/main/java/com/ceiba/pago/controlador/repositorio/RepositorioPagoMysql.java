package com.ceiba.pago.controlador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPagoMysql implements RepositorioPago {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pagos", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="pagos", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="pagos", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="pagos", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioPagoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Pago pago) {

        String sql  = sqlCrear;
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("referenciaPago",pago.getReferenciaPago());
        parameterSource.addValue("idCliente",pago.getCliente().getId());
        parameterSource.addValue("aplicaDescuento",pago.isAplicaDescuento());
        parameterSource.addValue("valorBase",pago.getValorBase());
        parameterSource.addValue("valorTotal",pago.getValorTotal());
        parameterSource.addValue("fechaRegistro",pago.getFechaRegistro());
        parameterSource.addValue("fechaProximoPago",pago.getFechaProximoPago());

        KeyHolder keyHolder= new GeneratedKeyHolder();

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sql,parameterSource,keyHolder,new String[] {"id"});

        return  keyHolder.getKey().longValue();


    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
