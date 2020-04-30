package com.example.formativa_2;

public class Usuario {

    public String nombre;
    public String identificacion;
    public String apto;
    public String tipo;
    public String fecha;
    public String hora;

    public Usuario (String nombre, String identificacion, String apto, String tipo, String fecha, String hora){
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.apto = apto;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", apto='" + apto + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
