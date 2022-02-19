package com.ceiba.pago.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pago.modelo.dto.DtoPago;
import org.springframework.jdbc.core.RowMapper;

public class MapeoPago implements RowMapper<DtoPago>, MapperResult {

    @Override
    public DtoPago mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String referenciaPago = resultSet.getString("referencia_pago");
        String aplicaDescuento=resultSet.getString("descuento");
        double valorBase=resultSet.getDouble("valor_base");
        double valorTotal=resultSet.getDouble("valor_total");
        LocalDate fechaRegistro = extraerLocalDate(resultSet, "fecha_registro");
        LocalDate fechaProximoPago= extraerLocalDate(resultSet, "fecha_proximo_pago");
        return new DtoPago(id,referenciaPago,aplicaDescuento,valorBase,valorTotal,fechaRegistro,fechaProximoPago);
    }

}


