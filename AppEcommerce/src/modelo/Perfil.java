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
public class Perfil {
    
    private int Id;
    private String NombrePerfil;
    private String Descripcion;
    private boolean Estado;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombrePerfil() {
        return NombrePerfil;
    }

    public void setNombrePerfil(String NombrePerfil) {
        this.NombrePerfil = NombrePerfil;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public Perfil() {
    }

    public Perfil(int Id, String NombrePerfil, String Descripcion) {
        this.Id = Id;
        this.NombrePerfil = NombrePerfil;
        this.Descripcion = Descripcion;
     
    }
    
    
   @Override
   public String toString(){
       return this.NombrePerfil;
   }
    
    
    
}
