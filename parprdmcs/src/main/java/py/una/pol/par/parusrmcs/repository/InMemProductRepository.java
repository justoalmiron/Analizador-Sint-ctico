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
public class InMemProductRepository implements ProductRepository<User, Integer>{
    
    private ArrayList<User> users = new ArrayList<>();

    @Override
    public boolean containsNombreApellido(String nombre, String apellido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<User> findByNombreApellido(String nombre, String apellido) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsLoginName(String loginName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<User> findByLoginName(String loginName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User login(String loginName, String passwd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(User entity) {
        users.add(entity);
    }

    @Override
    public void remove(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User entity) {
        User retValue = null;
        for (User user : users) {
            if (user.getId() == entity.getId()) {
                //
            }
        }
    }

    @Override
    public boolean contains(Integer id) {
        boolean retValue = false;
        for (User user : users) {
            if (user.getId() == id) {
                retValue = true;
            }
        }
        return retValue;
    }

    @Override
    public Entity get(Integer id) {
        User retValue = null;
        for (User user : users) {
            if (user.getId() == id) {
                retValue = user;
            }
        }
        return retValue;
    }

    @Override
    public Collection<User> getAll() {
        return users;
    }
    
}
