/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Image;
import java.io.FileInputStream;

/**
 *
 * @author yzeballos
 */
public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private String especificacion;
    private double peso;
    private double longitud;
    private double alto;
    private double ancho;
    private double diametro;
    private double precio;
    private Image foto;
    private int fotoLenght;
    private SubCategoria subcategoria;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public SubCategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(SubCategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public int getFotoLenght() {
        return fotoLenght;
    }

    public void setFotoLenght(int fotoLenght) {
        this.fotoLenght = fotoLenght;
    }
    

    public Producto() {
    }

    public Producto(String codigo, String nombre, String descripcion, String especificacion, double peso, double longitud, double alto, double ancho, double diametro, double precio, Image foto, int fotoLenght, SubCategoria subcategoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.especificacion = especificacion;
        this.peso = peso;
        this.longitud = longitud;
        this.alto = alto;
        this.ancho = ancho;
        this.diametro = diametro;
        this.precio = precio;
        this.foto = foto;
        this.fotoLenght = fotoLenght;
        this.subcategoria = subcategoria;
    }

  
    
    
}
