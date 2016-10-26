package ejb;

import entity.RootCategory;
import entity.SubCategory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Stateless
public class RootCategoryEJB {

    @PersistenceContext
    private EntityManager em;

    public String createRootCategory(String categoryName) {
        RootCategory rootCategory = new RootCategory(categoryName);
        em.persist(rootCategory);
        return rootCategory.getCategoryName();
    }

    public RootCategory findRootCategory(String rootCategoryId) {
        RootCategory rootCategory = em.find(RootCategory.class, rootCategoryId);
        return rootCategory;
    }

    public List<RootCategory> getAll(){
        Query query = em.createQuery("select s from RootCategory s");
        return query.getResultList();
    }

    public boolean deleteRootCategory(String categoryName){
        RootCategory rootCategory = em.find(RootCategory.class, categoryName);
        if(rootCategory != null){
            em.remove(rootCategory);
            return true;
        }
        return false;
    }
}
