package py.una.pol.par.parusrmcs.repository;

import java.util.ArrayList;
import java.util.Collection;
import py.una.pol.par.commons.repository.Repository;
import py.una.pol.par.parusrmcs.model.entity.Product;

/**
 *
 * @author Sourabh Sharma
 * @param <User>
 * @param <Integer>
 */
public interface ProductRepository<User, Integer> extends Repository<User, Integer> {

    /**
     *
     * @param nombre
     * @param apellido
     * @return
     */
    public Product buscarProducto(String descripcion);
    
    public ArrayList<Product> listarCategorias(String descripcion,int numero);
    
    
   
    public void añadirCarrito();
    
   
    
    
    
}
