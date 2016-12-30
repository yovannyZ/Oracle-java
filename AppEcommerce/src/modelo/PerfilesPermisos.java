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
public class PerfilesPermisos {
    
    private int id;
    private Perfil perfil;
    private Menu menu;
    private boolean activado;
    private boolean lectura;
    private boolean escritura;
    private boolean eliminacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    public boolean isLectura() {
        return lectura;
    }

    public void setLectura(boolean lectura) {
        this.lectura = lectura;
    }

    public boolean isEscritura() {
        return escritura;
    }

    public void setEscritura(boolean escritura) {
        this.escritura = escritura;
    }

    public boolean isEliminacion() {
        return eliminacion;
    }

    public void setEliminacion(boolean eliminacion) {
        this.eliminacion = eliminacion;
    }

    public PerfilesPermisos() {
    }

    public PerfilesPermisos(int id, Perfil perfil, Menu menu, boolean activado, boolean lectura, boolean escritura, boolean eliminacion) {
        this.id = id;
        this.perfil = perfil;
        this.menu = menu;
        this.activado = activado;
        this.lectura = lectura;
        this.escritura = escritura;
        this.eliminacion = eliminacion;
    }
    
    
    
}
