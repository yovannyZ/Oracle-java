/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.ISubCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import modelo.SubCategoria;

/**
 *
 * @author yzeballos
 */
public class SubCategoriaDAO implements ISubCategoria{

    Connection cn = Conexion.getInstance().Conectar();
    
    @Override
    public boolean Agregar(SubCategoria subCategoria) {
         boolean esValido= false;
        String query="INSERT INTO TSub_Categoria VALUES(?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, subCategoria.getCodigo());
            ps.setString(2, subCategoria.getNombre());
            ps.setString(3, subCategoria.getCategoria().getCodigo());
            
            esValido = ps.executeUpdate() > 0 ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return esValido;
    }

    @Override
    public boolean Actualizar(SubCategoria subCategoria) {
        
        boolean esValido= false;
        String query="UPDATE TSub_Categoria SET nombre = ? ,cod_categoria = ? where cod_sub_categoria = ?";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, subCategoria.getNombre());
            ps.setString(2, subCategoria.getCategoria().getCodigo());
            ps.setString(3, subCategoria.getCodigo());
            
            esValido = ps.executeUpdate() > 0 ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return esValido;
    }

    @Override
    public boolean Eliminar(String codigo) {
        
       boolean esValido= false;
        String query="DELETE FROM TSub_Categoria  where cod_sub_categoria = ?";
        
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, codigo);
            
            esValido = ps.executeUpdate() > 0 ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return esValido;
    }

    @Override
    public List<SubCategoria> Listar() {
         List<SubCategoria> lista = new ArrayList<>();
         SubCategoria subCategoria;
         CategoriaDAO categoriaDao= new CategoriaDAO();
        
        try {
            String query="SELECT * FROM TSub_Categoria";
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                subCategoria =  new SubCategoria();
                subCategoria.setCodigo(rs.getString(1));
                subCategoria.setNombre(rs.getString(2));
                subCategoria.setCategoria(categoriaDao.Buscar(rs.getString(3)));
                lista.add(subCategoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }

    @Override
    public SubCategoria Buscar(String codigo) {
         SubCategoria subCategoria = null;
         CategoriaDAO categoriaDao= new CategoriaDAO();
        
        try {
            String query="SELECT * FROM TSub_Categoria where cod_sub_categoria='"+codigo+"'";
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                subCategoria =  new SubCategoria();
                subCategoria.setCodigo(rs.getString(1));
                subCategoria.setNombre(rs.getString(2));
                subCategoria.setCategoria(categoriaDao.Buscar(rs.getString(3)));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return subCategoria;
    }
    
    @Override
    public List<SubCategoria> Listar(String codigo) {
         List<SubCategoria> lista = new ArrayList<>();
         SubCategoria subCategoria;
         CategoriaDAO categoriaDao= new CategoriaDAO();
        
        try {
            String query="SELECT * FROM TSub_Categoria where cod_sub_categoria like '%"+codigo+"%'";
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                subCategoria =  new SubCategoria();
                subCategoria.setCodigo(rs.getString(1));
                subCategoria.setNombre(rs.getString(2));
                subCategoria.setCategoria(categoriaDao.Buscar(rs.getString(3)));
                lista.add(subCategoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
    
}
