/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.IPerfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Perfil;

/**
 *
 * @author yzeballos
 */
public class PerfilDAO implements IPerfil{
    
     Connection cn = Conexion.getInstance().Conectar();
     
    @Override
    public boolean Agregar(Perfil perfil) throws Exception {
        boolean esValido= false;
        String query="INSERT INTO tbl_perfiles(NombrePerfil, DescripcionPerfil, Estado) VALUES(?,?,?)";
        
        PreparedStatement ps = cn.prepareStatement(query);
        
        ps.setString(1, perfil.getNombrePerfil());
        ps.setString(2, perfil.getDescripcion());
        ps.setBoolean(3, true);
        esValido = ps.executeUpdate() > 0 ;
        
        return esValido;
    }

    @Override
    public boolean Actualizar(Perfil perfil) throws Exception {
       
        boolean esValido= false;
        String query="UPDATE tbl_perfiles SET NombrePerfil = ? , "
                                            + " DescripcionPerfil = ?"
                                            + " where Id_perfil = ?";

        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, perfil.getNombrePerfil());
        ps.setString(2, perfil.getDescripcion());
        ps.setInt(3, perfil.getId());

        esValido = ps.executeUpdate() > 0 ;
        
        return esValido;
    }

    @Override
    public boolean Eliminar(int codigo) throws Exception {
        
        boolean esValido= false;
        String query="update   tbl_perfiles set estado = ?  where id_perfil = ?";
        
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setBoolean(1, false);
        ps.setInt(2, codigo);

        esValido = ps.executeUpdate() > 0 ;
            
        return esValido;
    }

    @Override
    public List<Perfil> Listar() throws Exception {
        List<Perfil> lista = new ArrayList<>();
        Perfil perfil;
        
        String query="SELECT * FROM tbl_perfiles where estado = 1";
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(query);
        while(rs.next()){
            perfil =  new Perfil();
            perfil.setId(rs.getInt(1));
            perfil.setNombrePerfil(rs.getString(2));
            perfil.setDescripcion(rs.getString(3));
            perfil.setEstado(rs.getBoolean(4));
            lista.add(perfil);
        }
        return lista;
    }

    @Override
    public Perfil Buscar(int codigo) throws Exception {
      
        Perfil perfil = null;
        
        String query="SELECT * FROM tbl_perfiles where id_perfil =" + codigo+" and estado = 1" ;
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(query);
        while(rs.next()){
            perfil =  new Perfil();
            perfil.setId(rs.getInt(1));
            perfil.setNombrePerfil(rs.getString(2));
            perfil.setDescripcion(rs.getString(3));
            perfil.setEstado(rs.getBoolean(4));
        }
      
        return perfil;
    }
    
     @Override
     public List<Perfil> Listar(int codigo) throws Exception {
        List<Perfil> lista = new ArrayList<>();
        Perfil perfil;
        
        String query="SELECT * FROM tbl_perfiles where id_perfil=" + codigo +" and estado = 1";
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(query);
        while(rs.next()){
            perfil =  new Perfil();
            perfil.setId(rs.getInt(1));
            perfil.setNombrePerfil(rs.getString(2));
            perfil.setDescripcion(rs.getString(3));
            perfil.setEstado(rs.getBoolean(4));
            lista.add(perfil);
        }
       
        
        return lista;
    }
    
}
