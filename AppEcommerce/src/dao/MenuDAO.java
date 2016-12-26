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
    
     public List<Menu> ListarMenus(int perfil) {
         List<Menu> lista = new ArrayList<Menu>();
         Menu menu;
        
        try {
            String query="select * from  [Qry_PerfilesPermisos] where id_perfil = "+ perfil;
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                menu =  new Menu();
                menu.setDescripcion(rs.getString(1));
                menu.setFormularioAsociado(rs.getBoolean(2));
                menu.setIdMenu(rs.getInt(3));
                menu.setIdMenuPadre(rs.getInt(4));
                menu.setPosicionMenu(rs.getInt(5));
                menu.setHabilitado(rs.getBoolean(6));
                menu.setUrlMenu(rs.getString(7));
                menu.setIdPerfil(rs.getInt(8));
                menu.setLectura(rs.getBoolean(9));
                menu.setEscritura(rs.getBoolean(10));
                menu.setEliminacion(rs.getBoolean(11));
               
                lista.add(menu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
     
    
}
