package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {

    @Override
    public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre=resultSet.getString("nombre");
        String tipoIdentificacion=resultSet.getString("tipo_identificacion");
        String numeroIdentificacion=resultSet.getString("numero_identificacion");
        return new DtoCliente(id,nombre,tipoIdentificacion,numeroIdentificacion);
    }

}


