/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Perfil;

/**
 *
 * @author yzeballos
 */
public interface IPerfil {
    
     boolean Agregar(Perfil perfil) throws Exception;
    
    boolean Actualizar(Perfil perfil) throws Exception;
    
    boolean Eliminar(int codigo) throws Exception;
    
    List<Perfil> Listar() throws Exception;
    
    Perfil Buscar(int codigo) throws Exception;
    
    List<Perfil> Listar(int codigo) throws Exception;
}
