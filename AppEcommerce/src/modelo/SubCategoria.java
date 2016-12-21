/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author yzeballos
 */
public class SubCategoria {
    private String codigo;
    private String nombre;
    private Categoria categoria;

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public SubCategoria() {
    }

    public SubCategoria(String codigo, String nombre, Categoria categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
    }
    
    
    
    
    
}
