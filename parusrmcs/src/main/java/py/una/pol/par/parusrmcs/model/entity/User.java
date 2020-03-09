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
public class User extends BaseEntity<Integer> {
    
    private String apellido;
    private String email;
    private String loginName;
    private String passwd;
    private int tipoCliente;
    
    public User() {
        super(0,"");
    }
    
    public User(Integer id, String nombre) {
        super(id, nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(this.getId()).append(", nombre: ")
                .append(this.getNombre()).append(", apellido: ").append(apellido)
                .append(", email: ").append(email)
                .append(", loginName: ").append(loginName)
                .append(", passwd: ").append(passwd)
                .append(", tipoCliente: ").append(tipoCliente).append("}").toString();
    }
}
