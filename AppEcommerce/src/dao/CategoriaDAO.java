/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.ICategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Categoria;

/**
 *
 * @author yzeballos
 */
public class CategoriaDAO implements ICategoria {

    Connection cn = Conexion.getInstance().Conectar();
    @Override
    public boolean Agregar(Categoria categoria) {
        boolean esValido= false;
        String query="INSERT INTO TCategoria VALUES(?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, categoria.getCodigo());
            ps.setString(2, categoria.getDescripcion());
            
            esValido = ps.executeUpdate() > 0 ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return esValido;
    }

    @Override
    public boolean Actualizar(Categoria categoria) {
       
        boolean esValido= false;
        String query="UPDATE TCategoria SET descripcion = ? where cod_categoria = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(2, categoria.getCodigo());
            ps.setString(1, categoria.getDescripcion());
            
            esValido = ps.executeUpdate() > 0 ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return esValido;
    }

    @Override
    public boolean Eliminar(String codigo) {
        
        boolean esValido= false;
        String query="DELETE FROM TCategoria  where cod_categoria = ?";
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
    public List<Categoria> Listar() {
        List<Categoria> lista = new ArrayList<>();
        Categoria categoria;
        
        try {
            String query="SELECT cod_categoria , descripcion FROM TCategoria";
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                categoria =  new Categoria();
                categoria.setCodigo(rs.getString(1));
                categoria.setDescripcion(rs.getString(2));
                lista.add(categoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }

    @Override
    public Categoria Buscar(String codigo) {
        
        Categoria categoria = null;
        
        try {
            String query="SELECT * FROM TCategoria where COD_CATEGORIA = ?" ;
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, codigo);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                categoria =  new Categoria();
                categoria.setCodigo(rs.getString(1));
                categoria.setDescripcion(rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return categoria;
    }
    
     @Override
     public List<Categoria> Listar(String codigo) {
        List<Categoria> lista = new ArrayList<>();
        Categoria categoria;
        
        try {
            String query="SELECT * FROM TCategoria where cod_categoria like '%"+codigo+"%'";
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                categoria =  new Categoria();
                categoria.setCodigo(rs.getString(1));
                categoria.setDescripcion(rs.getString(2));
                lista.add(categoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
    
}
