create table pagos (
 id int not null auto_increment primary key,
 referencia_pago varchar(4) not null,
 id_cliente  int not null ,
 descuento varchar(5) not null,
 valor_base dec(7,0) not null,
 valor_total dec(7,0) not null,
 fecha_registro datetime not null,
 fecha_proximo_pago datetime not null
);
