package com.ceiba.configuracion;

import com.ceiba.pago.puerto.repositorio.RepositorioPago;
import com.ceiba.pago.servicio.ServicioCrearPago;
import com.ceiba.pago.servicio.ServicioEliminarPago;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BeanServicio {

    @Bean
    public ServicioCrearPago servicioCrearPago(RepositorioPago repositorioPago) {
        return new ServicioCrearPago(repositorioPago);
    }

    @Bean
    public ServicioEliminarPago servicioEliminarPago(RepositorioPago repositorioPago) {
        return new ServicioEliminarPago(repositorioPago);
    }
}
