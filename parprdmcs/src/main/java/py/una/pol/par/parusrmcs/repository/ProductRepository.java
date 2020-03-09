package py.una.pol.par.parusrmcs.repository;

import java.util.Collection;
import py.una.pol.par.commons.repository.Repository;

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
    boolean containsNombreApellido(String nombre, String apellido);

    /**
     *
     * @param nombre
     * @param apellido
     * @return
     * @throws Exception
     */
    public Collection<User> findByNombreApellido(String nombre, String apellido) throws Exception;
    
    /**
     *
     * @param loginName
     * @return
     */
    boolean containsLoginName(String loginName);

    /**
     *
     * @param loginName
     * @return
     * @throws Exception
     */
    public Collection<User> findByLoginName(String loginName) throws Exception;
    
    /**
     * Metodo para realizar el login en el sistema
     * @param loginName
     * @param passwd
     * @return 
     */
    public User login(String loginName, String passwd);
}
