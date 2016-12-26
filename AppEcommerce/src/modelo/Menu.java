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
public class Menu {
    
    private String Descripcion;
    private boolean FormularioAsociado;
    private int IdMenu;
    private int IdMenuPadre;
    private int PosicionMenu;
    private boolean Habilitado;
    private String UrlMenu;
    private int IdPerfil;
    private boolean Lectura;
    private boolean Escritura;
    private boolean Eliminacion;

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public boolean isFormularioAsociado() {
        return FormularioAsociado;
    }

    public void setFormularioAsociado(boolean FormularioAsociado) {
        this.FormularioAsociado = FormularioAsociado;
    }

   

    public int getIdMenu() {
        return IdMenu;
    }

    public void setIdMenu(int IdMenu) {
        this.IdMenu = IdMenu;
    }

    public int getIdMenuPadre() {
        return IdMenuPadre;
    }

    public void setIdMenuPadre(int IdMenuPadre) {
        this.IdMenuPadre = IdMenuPadre;
    }

    public int getPosicionMenu() {
        return PosicionMenu;
    }

    public void setPosicionMenu(int PosicionMenu) {
        this.PosicionMenu = PosicionMenu;
    }

    public boolean isHabilitado() {
        return Habilitado;
    }

    public void setHabilitado(boolean Habilitado) {
        this.Habilitado = Habilitado;
    }

    public String getUrlMenu() {
        return UrlMenu;
    }

    public void setUrlMenu(String UrlMenu) {
        this.UrlMenu = UrlMenu;
    }

    public int getIdPerfil() {
        return IdPerfil;
    }

    public void setIdPerfil(int IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public boolean isLectura() {
        return Lectura;
    }

    public void setLectura(boolean Lectura) {
        this.Lectura = Lectura;
    }

    public boolean isEscritura() {
        return Escritura;
    }

    public void setEscritura(boolean Escritura) {
        this.Escritura = Escritura;
    }

    public boolean isEliminacion() {
        return Eliminacion;
    }

    public void setEliminacion(boolean Eliminacion) {
        this.Eliminacion = Eliminacion;
    }

    public Menu() {
    }


    
    
    

    
}
