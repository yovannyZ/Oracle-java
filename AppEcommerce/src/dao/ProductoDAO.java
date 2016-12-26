
package dao;

import interfaces.IProducto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import modelo.Producto;
import modelo.SubCategoria;

/**
 *
 * @author yzeballos
 */
public class ProductoDAO implements IProducto{

    Connection cn = Conexion.getInstance().Conectar();
    
    @Override
    public boolean Agregar(Producto producto) {
        boolean esValido= false;
        String query="INSERT INTO TProducto VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getDescripcion());
            ps.setString(4, producto.getEspecificacion());
            ps.setDouble(5, producto.getPeso());
            ps.setDouble(6, producto.getLongitud());
            ps.setDouble(7, producto.getAlto());
            ps.setDouble(8, producto.getAncho());
            ps.setDouble(9, producto.getDiametro());
            ps.setDouble(10, producto.getPrecio());
            ps.setBytes(11, producto.getFoto());
            ps.setString(12, producto.getSubcategoria().getCodigo());
         
            esValido = ps.executeUpdate() > 0 ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return esValido;
    }

    @Override
    public boolean Actualizar(Producto producto) {
        boolean esValido= false;
        String query="UPDATE  TProducto SET NOMBRE=?,"
                                      + "DESCRIPCION=?,"
                                      + "ESPECIFICACION=?,"
                                      + "PESO=?,"
                                      + "LONGITUD=?,"
                                      + "ALTO=?,"
                                      + "ANCHO=?,"
                                      + "DIAMETRO=?,"
                                      + "PRECIO=?,"
                                      + "FOTO=?,"
                                      + "COD_SUB_CATEGORIA=? "
                                      + "WHERE COD_PRODUCTO = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getEspecificacion());
            ps.setDouble(4, producto.getPeso());
            ps.setDouble(5, producto.getLongitud());
            ps.setDouble(6, producto.getAlto());
            ps.setDouble(7, producto.getAncho());
            ps.setDouble(8, producto.getDiametro());
            ps.setDouble(9, producto.getPrecio());
            ps.setBytes(10, producto.getFoto());
            ps.setString(11, producto.getSubcategoria().getCodigo());
            ps.setString(12, producto.getCodigo());
         
            esValido = ps.executeUpdate() > 0 ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return esValido;
    }

    @Override
    public boolean Eliminar(String codigo) {
          boolean esValido= false;
        String query="DELETE FROM  TProducto WHERE COD_PRODUCTO = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1 , codigo);
         
            esValido = ps.executeUpdate() > 0 ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return esValido;
    }

    @Override
    public List<Producto> Listar() {
         List<Producto> lista = new ArrayList<Producto>();
         Producto producto;
         SubCategoriaDAO subCategoriaDao= new SubCategoriaDAO();
        
        try {
            String query="SELECT * FROM TProducto";
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                producto =  new Producto();
                producto.setCodigo(rs.getString(1));
                producto.setNombre(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setEspecificacion(rs.getString(4));
                producto.setPeso(rs.getDouble(5));
                producto.setLongitud(rs.getDouble(6));
                producto.setAlto(rs.getDouble(7));
                producto.setAncho(rs.getDouble(8));
                producto.setDiametro(rs.getDouble(9));
                producto.setPrecio(rs.getDouble(10));
                producto.setFoto(rs.getBytes(11));
                producto.setSubcategoria(subCategoriaDao.Buscar(rs.getString(12)));
                
                lista.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }

    @Override
    public Producto Buscar(String codigo) {
       
         Producto producto =  null;
         SubCategoriaDAO subCategoriaDao= new SubCategoriaDAO();
        
        try {
            String query="SELECT * FROM TProducto WHERE cod_producto= '"+codigo+"' ";
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                producto =  new Producto();
                producto.setCodigo(rs.getString(1));
                producto.setNombre(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setEspecificacion(rs.getString(4));
                producto.setPeso(rs.getDouble(5));
                producto.setLongitud(rs.getDouble(6));
                producto.setAlto(rs.getDouble(7));
                producto.setAncho(rs.getDouble(8));
                producto.setDiametro(rs.getDouble(9));
                producto.setPrecio(rs.getDouble(10));
                producto.setFoto(rs.getBytes(11));
                producto.setSubcategoria(subCategoriaDao.Buscar(rs.getString(12)));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return producto;
    }

    @Override
    public List<Producto> Listar(String codigo) {
        
         List<Producto> lista = new ArrayList<Producto>();
         Producto producto;
         SubCategoriaDAO subCategoriaDao= new SubCategoriaDAO();
        
        try {
            String query="SELECT * FROM TProducto WHERE = '"+codigo+"' ";
            Statement st = cn.createStatement();
            ResultSet rs =st.executeQuery(query);
            while(rs.next()){
                producto =  new Producto();
                producto.setCodigo(rs.getString(1));
                producto.setNombre(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setEspecificacion(rs.getString(4));
                producto.setPeso(rs.getDouble(5));
                producto.setLongitud(rs.getDouble(6));
                producto.setAlto(rs.getDouble(7));
                producto.setAncho(rs.getDouble(8));
                producto.setDiametro(rs.getDouble(9));
                producto.setPrecio(rs.getDouble(10));
                producto.setFoto(rs.getBytes(11));
                producto.setSubcategoria(subCategoriaDao.Buscar(rs.getString(12)));
                
                lista.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }
    
}
