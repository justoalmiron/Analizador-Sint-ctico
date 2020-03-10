/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.parusrmcs.repository;

import java.util.ArrayList;
import java.util.Collection;
import py.una.pol.par.commons.entity.Entity;
import py.una.pol.par.parusrmcs.model.entity.Product;

/**
 *
 * @author mauricio
 */
public class InMemProductRepository implements ProductRepository<Product, Integer>{
    
    private ArrayList<Product> productos = new ArrayList<>();

    @Override
    public Product buscarProducto(String descripcion) {
        int i = 0;

        while (i < productos.size()) {
            if (productos.get(i).getDescription() == descripcion) {
                break;
            }
            i++;
        }
        if (i >= productos.size()) {
            System.out.println("Producto no encontrado");
            return null;
        } else {
            System.out.println(productos.get(i));
            return productos.get(i);
        }

    }

    
    //
    @Override
    public ArrayList<Product> listarCategorias(String descripcion, int numero) {
        int i = numero;
        ArrayList<Product> productosCategoria = new ArrayList<Product>();
        while (i < productos.size()) {
            if (productos.get(i).getCategory().getDescription() == descripcion) {
                productosCategoria.add(productos.get(i));             
            }
            i++;
        }
        if(productosCategoria.size()==0){
            System.out.println("No se encontro la categoria");
            return null;
        }else{
        i=0;
        while (i < productosCategoria.size()) {

                System.out.println(productosCategoria.get(i));           

            i++;
        }
        return productosCategoria;
        }  
    }

  

    @Override
    public void añadirCarrito() {
      
        
        
        
        
     
    }

    @Override
    public void add(Product entity) {
        productos.add(entity);
    }

    @Override
    public void remove(Integer id) {
        int i = 0;
        while (i < productos.size()) {
            if (productos.get(i).getId() == id) {
                break;
            }
            i++;
        }
        if (i >= productos.size()) {
            System.out.println("Producto no encontrado");

        } else {
            System.out.println(productos.get(i) + " eliminado con exito ");
            productos.remove(i);
        }


        
    }

//    @Override
//    public void update(Product entity) {
//         int i = 0;
//
//        while (i < productos.size()) {
//            if (productos.get(i).getId() == entity.getId()) {
//                productos.get(i) = entity.get();
//                break;
//            }
//            i++;
//        }
//        if (i >= productos.size()) {
//            System.out.println("Producto no encontrado no se pudo actualizar");
//            
//        } else {
//            System.out.println("producto actualizado");
//           
//        }
//    }
    @Override
    public void update(Product entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public boolean contains(Integer id) {
        int i = 0;
        while (i < productos.size()) {
            if (productos.get(i).getId() == id) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public Entity get(Integer id) {
        int i = 0;

        while (i < productos.size()) {
            if (productos.get(i).getId() == id) {
                break;
            }
            i++;
        }
        if (i >= productos.size()) {
            System.out.println("Producto no encontrado");
            return null;
        } else {
            System.out.println(productos.get(i));
            return productos.get(i);
        }
    }

    @Override
    public Collection<Product> getAll() {
        return productos;
    }

    



   

    
}
