/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.IUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.HashSalt;
import modelo.Usuario;
import util.PasswordUtil;

/**
 *
 * @author Yovanny
 */
public class UsuarioDAO implements IUsuario{
    
    Connection cn = Conexion.getInstance().Conectar();
    HashSalt hs ;

    @Override
    public boolean Agregar(Usuario usuario) throws Exception {
        boolean esValido= false;
        String query="INSERT INTO tbl_usuarios(Id_Perfil, IdentificadorUsuario, ContraseniaUsuario,Salt, NombreUsuario, Estado) VALUES(?,?,?,?,?,?)";
        hs = PasswordUtil.getHash(usuario.getContrasena());
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setInt(1, usuario.getPerfil().getId());
        ps.setString(2, usuario.getUserName());
        ps.setString(3, hs.getHash());
        ps.setString(4, hs.getSalt());
        ps.setString(5, usuario.getNombre());
        ps.setBoolean(6, true);
        esValido = ps.executeUpdate() > 0 ;
        
        return esValido;
    }

    @Override
    public boolean Actualizar(Usuario usuario,boolean editarContrasena) throws Exception {
        boolean esValido= false;
        String query;
        PreparedStatement ps;
        if(editarContrasena){
            query="update tbl_usuarios  set  Id_Perfil = ?, "
                                             + "IdentificadorUsuario = ?, "
                                             + "ContraseniaUsuario = ?,"
                                             + "Salt = ? ,"
                                             + "NombreUsuario = ? "
                                             + "where Id_Usuario  = ?";
            
            hs = PasswordUtil.getHash(usuario.getContrasena());
            ps = cn.prepareStatement(query);
            ps.setInt(1, usuario.getPerfil().getId());
            ps.setString(2, usuario.getUserName());
            ps.setString(3, hs.getHash());
            ps.setString(4, hs.getSalt());
            ps.setString(5, usuario.getNombre());
            ps.setInt(6, usuario.getId());
        }else{
            query="update tbl_usuarios  set  Id_Perfil = ?, "
                                             + "IdentificadorUsuario = ?, "
                                             + "NombreUsuario = ? "
                                             + "where Id_Usuario  = ?";
            
            ps = cn.prepareStatement(query);
            ps.setInt(1, usuario.getPerfil().getId());
            ps.setString(2, usuario.getUserName());
            ps.setString(3, usuario.getNombre());
            ps.setInt(4, usuario.getId());
        }
        
        esValido = ps.executeUpdate() > 0 ;
        
        return esValido;
    }

    @Override
    public boolean Eliminar(int codigo) throws Exception {
        boolean esValido= false;
        String query="update tbl_usuarios  set  Estado = ? "
                                             + "where Id_Usuario  = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setBoolean(1, false);
        ps.setInt(2, codigo);
        esValido = ps.executeUpdate() > 0 ;
        
        return esValido;
    }

    @Override
    public List<Usuario> Listar() throws Exception {
        List<Usuario> lista = new ArrayList<>();
        Usuario usuario;
        PerfilDAO perfilDao= new PerfilDAO();

        String query="SELECT * FROM tbl_usuarios where estado = 1";
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(query);
        while(rs.next()){
            usuario =  new Usuario();
            usuario.setId(rs.getInt(1));
            usuario.setPerfil(perfilDao.Buscar(rs.getInt(2)));
            usuario.setUserName(rs.getString(3));
            hs = new HashSalt(rs.getString(4), rs.getString(5));
            usuario.setNombre(rs.getString(6));
            usuario.setEstado(rs.getBoolean(7));
            
            lista.add(usuario);
        }

        return lista;
    }

    @Override
    public Usuario Buscar(int codigo) throws Exception {
        
        Usuario usuario = null;
        PerfilDAO perfilDao= new PerfilDAO();

        String query="SELECT * FROM tbl_usuarios where estado = 1 and id_usuario="+codigo;
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(query);
        while(rs.next()){
            usuario =  new Usuario();
            usuario.setId(rs.getInt(1));
            usuario.setPerfil(perfilDao.Buscar(rs.getInt(2)));
            usuario.setUserName(rs.getString(3));
            usuario.setContrasena(rs.getString(4));
            usuario.setSalt(rs.getString(5));
            hs = new HashSalt(rs.getString(4), rs.getString(5));
            usuario.setNombre(rs.getString(6));
            usuario.setEstado(rs.getBoolean(7));
        }

        return usuario;
    }

    @Override
    public List<Usuario> Listar(int codigo) throws Exception {
        List<Usuario> lista = new ArrayList<>();
        Usuario usuario;
        PerfilDAO perfilDao= new PerfilDAO();
        
        String query="SELECT * FROM tbl_usuarios where estado = 1 and id_usuario like '%"+codigo+"%'";
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(query);
        while(rs.next()){
            usuario =  new Usuario();
            usuario.setId(rs.getInt(1));
            usuario.setPerfil(perfilDao.Buscar(rs.getInt(2)));
            usuario.setUserName(rs.getString(3));
            hs = new HashSalt(rs.getString(4), rs.getString(5));
            usuario.setNombre(rs.getString(6));
            usuario.setEstado(rs.getBoolean(7));
            
            lista.add(usuario);
        }

        return lista;
    }
    
     public Usuario BuscarUsername(String username) throws Exception {
        
        Usuario usuario = null;
        PerfilDAO perfilDao= new PerfilDAO();

        String query="SELECT * FROM tbl_usuarios where estado = 1 and IdentificadorUsuario='"+username+"'";
        Statement st = cn.createStatement();
        ResultSet rs =st.executeQuery(query);
        while(rs.next()){
            usuario =  new Usuario();
            usuario.setId(rs.getInt(1));
            usuario.setPerfil(perfilDao.Buscar(rs.getInt(2)));
            usuario.setUserName(rs.getString(3));
            usuario.setContrasena(rs.getString(4));
            usuario.setSalt(rs.getString(5));
            hs = new HashSalt(rs.getString(4), rs.getString(5));
            usuario.setNombre(rs.getString(6));
            usuario.setEstado(rs.getBoolean(7));
        }

        return usuario;
    }
    
    
    /*
    Ejemplo de comousar hash
     HashSalt hs = PasswordUtil.getHash("miPassword");
	System.out.println(hs.getHash()); // bWlQYXNzd29yZA==
	System.out.println(hs.getSalt()); // SMB6x5uRy4kIPYN512ibug==
	
	boolean isValid = PasswordUtil.ValidatePass("miPassword2", hs.getHash(), hs.getSalt());
	System.out.println(isValid ? "válida" : "no válida"); 
    
    
    */
    
}
