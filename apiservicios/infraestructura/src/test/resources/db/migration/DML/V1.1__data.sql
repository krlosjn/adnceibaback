insert into clientes(
nombre,
tipo_identificacion,
numero_identificacion)
values(
'Carlos',
'CC',
'1152205388');


insert into pagos(
referencia_pago,
id_cliente,
descuento,
valor_base,
valor_total,
fecha_registro,
fecha_proximo_pago)
values (
'1111',
1,
'true',
200000,
200000,
now(),
now());


