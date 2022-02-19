package com.ceiba.pago.modelo.entidad.cliente;

public enum TipoIdentificacion {

        CEDULA("CC"),CEDULA_EXTRAJERIA("CE"),PASAPORTE("PS");
        private String identificacionTipo;
        public String getIdentificacionTipo(){
            return this.identificacionTipo;
        }

        TipoIdentificacion(String identificacionTipo) {
            this.identificacionTipo =identificacionTipo;
        }
}
