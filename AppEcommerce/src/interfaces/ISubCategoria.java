/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.SubCategoria;

/**
 *
 * @author yzeballos
 */
public interface ISubCategoria {
    
    boolean Agregar(SubCategoria subCategoria);
    
    boolean Actualizar(SubCategoria subCategoria);
    
    boolean Eliminar(String codigo);
    
    List<SubCategoria> Listar();
    
    SubCategoria Buscar(String codigo);
    
    List<SubCategoria> Listar(String codigo);
}
