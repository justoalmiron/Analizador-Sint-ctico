package py.una.pol.par.commons.repository;

import java.util.Collection;
import py.una.pol.par.commons.entity.Entity;


/**
 *
 * @author Sourabh Sharma
 * @param <TE>
 * @param <T>
 */
public interface ReadOnlyRepository<TE, T> {

    //long Count;
    /**
     *
     * @param id
     * @return
     */
    boolean contains(T id);

    /**
     *
     * @param id
     * @return
     */
    Entity get(T id);

    /**
     *
     * @return
     */
    Collection<TE> getAll();
}
