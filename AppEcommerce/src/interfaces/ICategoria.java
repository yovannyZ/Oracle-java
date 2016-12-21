/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Categoria;

/**
 *
 * @author yzeballos
 */
public interface ICategoria {
    
    boolean Agregar(Categoria categoria);
    
    boolean Actualizar(Categoria categoria);
    
    boolean Eliminar(String codigo);
    
    List<Categoria> Listar();
    
    Categoria Buscar(String codigo);
    
    List<Categoria> Listar(String codigo);
    
}
