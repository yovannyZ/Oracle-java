/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.PerfilesPer;
import modelo.PerfilesPermisos;

/**
 *
 * @author yzeballos
 */
public class PermisosPerfilesDAO {
    
    Connection cn = Conexion.getInstance().Conectar();
   
     public List<PerfilesPermisos> Listar(int perfil) throws  Exception{
         List<PerfilesPermisos> lista = new ArrayList<PerfilesPermisos>();
         PerfilesPermisos perfilesPermisos;
         PerfilDAO perfilDao = new PerfilDAO();
         MenuDAO menuDao = new MenuDAO();
        
        
        String query="select * from  TBL_PerfilesPermisos where  id_perfil = "+ perfil;
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(query);
        while(rs.next()){
            perfilesPermisos =  new PerfilesPermisos();
            perfilesPermisos.setId(rs.getInt(1));
            perfilesPermisos.setPerfil(perfilDao.Buscar(rs.getInt(2)));
            perfilesPermisos.setMenu(menuDao.Buscar(rs.getInt(3)));
            perfilesPermisos.setActivado(rs.getBoolean(4));
            perfilesPermisos.setLectura(rs.getBoolean(5));
            perfilesPermisos.setEscritura(rs.getBoolean(6));
            perfilesPermisos.setEliminacion(rs.getBoolean(7));
            lista.add(perfilesPermisos);
        }
      
        
        return lista;
    }
     
     
     public boolean Insertar(PerfilesPermisos perfilesPermisos) throws  Exception{
         
        boolean esValido= false;
        String query="INSERT INTO TBL_PerfilesPermisos VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setInt(1, perfilesPermisos.getId());
        ps.setInt(2, perfilesPermisos.getPerfil().getId());
        ps.setInt(3, perfilesPermisos.getMenu().getId());
        ps.setBoolean(4, perfilesPermisos.isActivado());
        ps.setBoolean(5, perfilesPermisos.isLectura());
        ps.setBoolean(6, perfilesPermisos.isEscritura());
        ps.setBoolean(7, perfilesPermisos.isEliminacion());
      
        esValido = ps.executeUpdate() > 0 ;
        
        return esValido;
     }
     
     public boolean Eliminar(int idPerfil) throws  Exception{
         
        boolean esValido= false;
        String query="DELLETE TBL_PerfilesPermisos WHERE id_perfil = "+ idPerfil;
        PreparedStatement ps = cn.prepareStatement(query);
        esValido = ps.executeUpdate() > 0 ;
        return esValido;
     }
 
}
