/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Menu;

/**
 *
 * @author yzeballos
 */
public class MenuDAO {
    
    Connection cn = Conexion.getInstance().Conectar();
    
     public List<Menu> Listar() throws Exception{
         List<Menu> lista = new ArrayList<Menu>();
         Menu menu;
        
        String query="select * from  tbl_menus where id_menuPadre <> 0 ";
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(query);
        while(rs.next()){
            menu =  new Menu();
            menu.setId(rs.getInt(1));
            menu.setIdMenuPadre(rs.getInt(2));
            menu.setDescripcion(rs.getString(3));
            menu.setPosicionMenu(rs.getInt(4));
            menu.setHabilitado(rs.getBoolean(5));
            menu.setUrlMenu(rs.getString(6));
            menu.setFormularioAsociado(rs.getBoolean(7));
            menu.setHabilitado(false);
            menu.setLectura(false);
            menu.setEscritura(false);
            menu.setEliminacion(false);
            
            lista.add(menu);
            
         }
        return lista;
    }
     
     public Menu Buscar(int id) throws Exception{
         
         Menu menu =  null;
        
        String query="select * from  tbl_menus where id_menu =" + id;
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(query);
        while(rs.next()){
            menu =  new Menu();
            menu.setId(rs.getInt(1));
            menu.setIdMenuPadre(rs.getInt(2));
            menu.setDescripcion(rs.getString(3));
            menu.setPosicionMenu(rs.getInt(4));
            menu.setHabilitado(rs.getBoolean(5));
            menu.setUrlMenu(rs.getString(6));
            menu.setFormularioAsociado(rs.getBoolean(7));
            menu.setHabilitado(false);
            menu.setLectura(false);
            menu.setEscritura(false);
            menu.setEliminacion(false);
            
         }
        return menu;
    }
     
     
}
