create table clientes(
id int  auto_increment primary key,
nombre varchar(30) not null,
tipo_identificacion varchar(20) not null,
numero_identificacion varchar(10) not null
);


create table pagos (
 id int  auto_increment primary key,
 referencia_pago varchar(4) not null,
 id_cliente  int not null ,
 descuento varchar(5) not null,
 valor_base dec(7,0) not null,
 valor_total dec(7,0) not null,
 fecha_registro datetime not null,
 fecha_proximo_pago datetime not null,
 CONSTRAINT FK_ide_cliente FOREIGN KEY(id_cliente) REFERENCES clientes(id) ON DELETE CASCADE
);

