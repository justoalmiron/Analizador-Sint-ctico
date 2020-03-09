
import java.util.ArrayList;
import py.una.pol.par.parusrmcs.model.entity.User;
import py.una.pol.par.parusrmcs.repository.InMemUserRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mauricio
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InMemUserRepository imur = new InMemUserRepository();
        User u = new User();
        u.setNombre("Mauricio");
        u.setApellido("Machuca");
        u.setId(1);
        imur.add(u);
        
        
        ArrayList<User> users = (ArrayList<User>) imur.getAll();
        for (User user : users) {
            System.out.println("Usuario: " + user);
        }
        
    }
    
}
