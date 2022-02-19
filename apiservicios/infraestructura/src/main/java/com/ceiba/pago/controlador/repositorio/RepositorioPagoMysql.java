package com.ceiba.pago.controlador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pago.modelo.entidad.pago.Pago;
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

    @SqlStatement(namespace="pagos", value="actualizar")
    private static String sqlActualizar;

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

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id",pago.getId());
        parameterSource.addValue("referencia_pago",pago.getReferenciaPago());
        parameterSource.addValue("id_cliente",pago.getCliente().getId());
        parameterSource.addValue("descuento",pago.isAplicaDescuento());
        parameterSource.addValue("valor_base",pago.getFechaRegistro());
        parameterSource.addValue("fecha_registro",pago.getFechaRegistro());
        parameterSource.addValue("fecha_proximo_pago",pago.getFechaProximoPago());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        return this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String referenciaPago) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("referencia_pago", referenciaPago);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Pago usuario) {
        this.customNamedParameterJdbcTemplate.actualizar(usuario, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
