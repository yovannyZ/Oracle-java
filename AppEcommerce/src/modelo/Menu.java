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
     //Id_Menu, Id_MenuPadre, DescripcionMenu, PosicionMenu, HabilitadoMenu, UrlMenu, FormularioAsociado
    private int Id;
    private int IdMenuPadre;
    private String Descripcion;
    private int PosicionMenu;
    private boolean Habilitado;
    private String UrlMenu;
    private boolean FormularioAsociado;
    
    private boolean Lectura;
    private boolean Escritura;
    private boolean Eliminacion;
    private boolean Activado;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdMenuPadre() {
        return IdMenuPadre;
    }

    public void setIdMenuPadre(int IdMenuPadre) {
        this.IdMenuPadre = IdMenuPadre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
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

    public boolean isFormularioAsociado() {
        return FormularioAsociado;
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

    public boolean isActivado() {
        return Activado;
    }

    public void setActivado(boolean Activado) {
        this.Activado = Activado;
    }
    


    public void setFormularioAsociado(boolean FormularioAsociado) {
        this.FormularioAsociado = FormularioAsociado;
    }    
}
