/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Yovanny
 */
public interface IUsuario {
    
    boolean Agregar(Usuario usuario) throws Exception;
    
    boolean Actualizar(Usuario usuario) throws Exception;
    
    boolean Eliminar(int codigo) throws Exception;
    
    List<Usuario> Listar() throws Exception;
    
    Usuario Buscar(int codigo) throws Exception;
    
    List<Usuario> Listar(int codigo) throws Exception;
}
