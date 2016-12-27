/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.IUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    @Override
    public boolean Agregar(Usuario usuario) throws Exception {
        boolean esValido= false;
        String query="INSERT INTO tbl_usuarios(Id_Perfil, IdentificadorUsuario, ContraseniaUsuario, NombreUsuario, Estado) VALUES(?,?,?,?,?)";
        HashSalt hs = PasswordUtil.getHash(usuario.getContrasena());
        PreparedStatement ps = cn.prepareStatement(query);
        
        ps.setInt(1, usuario.getPerfil().getId());
        ps.setString(2, usuario.getUserName());
        ps.setString(3, hs.getHash());
        ps.setString(4, usuario.getNombre());
        ps.setBoolean(5, true);
        esValido = ps.executeUpdate() > 0 ;
        
        return esValido;
    }

    @Override
    public boolean Actualizar(Usuario usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Eliminar(int codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> Listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario Buscar(int codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> Listar(int codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
