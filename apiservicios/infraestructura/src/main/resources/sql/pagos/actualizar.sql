update pagos
set refencia_pago = :referenciaPago,
	fecha_registro = :fechaRegistro
where id = :id