/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import modelo.Producto;

/**
 *
 * @author yzeballos
 */
public interface IProducto {
    
     boolean Agregar(Producto producto);
    
    boolean Actualizar(Producto producto);
    
    boolean Eliminar(String codigo);
    
    List<Producto> Listar();
    
    Producto Buscar(String codigo);
    
    List<Producto> Listar(String codigo);
    
}
