/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.parusrmcs.model.entity;

import py.una.pol.par.commons.entity.BaseEntity;

/**
 *
 * @author justo
 */
public class Category extends BaseEntity<Integer> {
    String description;

    public Category(Integer id, String description) {
        super(id, description);   
    }
    public Category() {
        super(0, "");   
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" + "description=" + description + '}';
    }

    
    
    
    
    
}
