package com.ceiba.pago.modelo.entidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pago.servicio.excepcionesservicio.ExcepcionDiaNoValido;
import lombok.Getter;
import java.time.DayOfWeek;
import java.time.LocalDate;


import static com.ceiba.dominio.ValidadorArgumento.*;


@Getter
public class Pago {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_REGISTRO = "Se debe ingresar la fecha de registro";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_VENCIMIENTO = "Se debe ingresar la fecha de vencimiento";
    private static final String SE_DEBE_INGRESAR_VALOR_BASE="Se debe ingresar el valor del servicio";
    private static final String SE_DEBE_INGRESAR_REFERENCIA_PAGO="Se debe ingresar referencia de pago";
    private static final String SE_DEBE_INGRESAR_VALOR_MAYOR_CERO="Se debe ingresar un valor mayor a cero";
    private static final String NOMBRE_LONGITUD_MAXIMA="El nombre sólo puedo contener m+aximo 15 carácteres";
    public static final int NUMERO_DIAS_PROXIMO_PAGO = 20;
    public static final double PORCENTAJE_DESCUENTO = 0.15;
    public static final String DIA_NO_VALIDO="No se puede pagar este día";
    public static final String REFERENCIA_PAGO_VALIDA_DIGITOS = "La referencia de pago debe tener 4 dígitos";
    public static final String VALOR_BASE = "El valor debe estar entre 100000 y 1000000";
    public static final int VALOR_MINIMO_PAGO = 100000;
    public static final int VALOR_MAXIMO_PAGO = 1000000;
    public static final int REFERENCIA_PAGO_LONGITUD = 4;

    private Long id;
    private String referenciaPago;
    private Long cliente;
    private boolean aplicaDescuento;
    private double valorBase;
    private double valorTotal;
    private LocalDate fechaRegistro;
    private LocalDate fechaProximoPago;

    public Pago( Long id,String referenciaPago, Long cliente, boolean aplicaDescuento, double valorBase, LocalDate fechaRegistro) {
        validandoArgumentos(referenciaPago, valorBase, fechaRegistro);
        this.id = id;
        this.referenciaPago =referenciaPago;
        this.cliente=cliente;
        this.aplicaDescuento=aplicaDescuento;
        this.valorBase=valorBase;
        this.fechaRegistro = fechaRegistro;
        validaDiaPagoNoFinSemana(fechaRegistro);
        generarFechaProximoPago(fechaRegistro,NUMERO_DIAS_PROXIMO_PAGO);
        generaDescuento(valorBase);
    }


    private void validandoArgumentos(String referenciaPago, double valorBase, LocalDate fechaRegistro) {
        validarObligatorio(referenciaPago, SE_DEBE_INGRESAR_REFERENCIA_PAGO);
        validaCantidadCaracteresReferenciaPago(referenciaPago, REFERENCIA_PAGO_VALIDA_DIGITOS);
        validarObligatorio(valorBase,SE_DEBE_INGRESAR_VALOR_BASE);
        validarPositivo(valorBase,SE_DEBE_INGRESAR_VALOR_MAYOR_CERO);
        validaMontoPagar(valorBase, VALOR_BASE);
        validarObligatorio(fechaRegistro, SE_DEBE_INGRESAR_LA_FECHA_DE_REGISTRO);
    }

    private void generarFechaProximoPago(LocalDate fechaRegistro,int numeroDiasProximoPago){
        int incrementoDias = 0;
        while (incrementoDias < numeroDiasProximoPago) {
            fechaRegistro = fechaRegistro.plusDays(1);
            if (DayOfWeek.SATURDAY != fechaRegistro.getDayOfWeek()
                    && DayOfWeek.SUNDAY != fechaRegistro.getDayOfWeek()) {
                incrementoDias++;
            }
        }
        this.fechaProximoPago =fechaRegistro;
    }

    public void generaDescuento(double valorBase){
        double valorDescuento= valorBase* PORCENTAJE_DESCUENTO;
        if(this.aplicaDescuento){
            this.valorTotal=this.valorBase-valorDescuento;
        }else{
            this.valorTotal=this.valorBase;
        }
    }

    public void validaDiaPagoNoFinSemana(LocalDate fechaRegistro){
        if(fechaRegistro.getDayOfWeek().equals(DayOfWeek.SATURDAY)|| fechaRegistro.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            throw new ExcepcionDiaNoValido(DIA_NO_VALIDO);
        }
    }

    public void validaCantidadCaracteresReferenciaPago(String referenciaPago,String mensaje){
       if(referenciaPago.length()> REFERENCIA_PAGO_LONGITUD || referenciaPago.length()<REFERENCIA_PAGO_LONGITUD) {
           throw new ExcepcionValorInvalido(mensaje);
       }
    }

    public void validaMontoPagar(double valorBase,String mensaje){
        if(valorBase< VALOR_MINIMO_PAGO || valorBase> VALOR_MAXIMO_PAGO){
            throw  new ExcepcionValorInvalido(mensaje);
        }
    }

}
