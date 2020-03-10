/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.pol.par.parusrmcs.model.entity;

import java.util.ArrayList;

/**
 *
 * @author justo
 */
public class CarritoCompras {

    ArrayList<Product> compras;
    int cantidadTotal;
    int precioTotal;

    public CarritoCompras() {
        this.cantidadTotal = 0;
        this.precioTotal = 0;
    }

    public int getCantidadTotal() {
        int i = 0;
        while (i < compras.size()) {
            cantidadTotal = cantidadTotal + compras.get(i).getCantidad();
            i++;
        }
        return cantidadTotal;

    }

    public int getPrecioTotal() {
        int i = 0;
        while (i < compras.size()) {
            precioTotal = precioTotal + compras.get(i).getCantidad()*compras.get(i).getPriceUnit();
            i++;
        }

        return precioTotal;
    }

}
