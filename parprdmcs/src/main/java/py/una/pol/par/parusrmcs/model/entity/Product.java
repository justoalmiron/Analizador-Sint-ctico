/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.parusrmcs.model.entity;

import py.una.pol.par.commons.entity.BaseEntity;

/**
 *
 * @author mauricio
 */
public class Product extends BaseEntity<Integer> {
    
    private String description;
    private int priceUnit;
    private int cantidad;
    private Category category;
    
    public Product() {
        super(0,"");
    }

    
    
    
    
    public Product(Integer id, String description) {
        super(id, description);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripcion) {
        this.description = descripcion;
    }

    public int getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(int precioUnit) {
        this.priceUnit = precioUnit;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
    
    
    /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(this.getId()).append(", descripcion: ")
                .append(this.getDescription())
                .append(", price unit: ").append(getPriceUnit())
                .append(", cantidad : ").append(getCantidad())
                .append(", category: ").append(getCategory().getDescription()).append("}").toString();
    }
}
