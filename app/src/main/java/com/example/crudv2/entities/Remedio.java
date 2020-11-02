package com.example.crudv2.entities;

import java.util.Date;

public class Remedio {

    private Integer id;
    private String nombre;
    private int cantidad;
    private String fec_vencimiento;
    private int mg;
    private String presentacion;
    private String descripcion;


    public Remedio(Integer id, String nombre, int cantidad, String fec_vencimiento, int mg, String presentacion, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fec_vencimiento = fec_vencimiento;
        this.mg = mg;
        this.presentacion = presentacion;
        this.descripcion = descripcion;
    }

    public Remedio() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFec_vencimiento() {
        return fec_vencimiento;
    }

    public void setFec_vencimiento(String fec_vencimiento) {
        this.fec_vencimiento = fec_vencimiento;
    }

    public int getMg() {
        return mg;
    }

    public void setMg(int mg) {
        this.mg = mg;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
