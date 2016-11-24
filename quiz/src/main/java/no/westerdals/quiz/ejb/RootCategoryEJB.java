package no.westerdals.quiz.ejb;

import no.westerdals.quiz.entity.RootCategory;

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

    public Long createRootCategory(String categoryName) {
        RootCategory rootCategory = new RootCategory(categoryName);
        em.persist(rootCategory);
        return rootCategory.getId();
    }

    public RootCategory findRootCategory(Long rootCategoryId) {
        RootCategory rootCategory = em.find(RootCategory.class, rootCategoryId);
        return rootCategory;
    }

    public List<RootCategory> getAll(){
        Query query = em.createQuery("select s from RootCategory s");
        return query.getResultList();
    }

    public boolean deleteRootCategory(Long id){
        RootCategory rootCategory = em.find(RootCategory.class, id);
        if(rootCategory != null){
            em.remove(rootCategory);
            return true;
        }
        return false;
    }

    public  List<RootCategory> getCategoriesWithQuizzes() {
        Query query = em.createQuery("select r from RootCategory r JOIN r.subCategoryList s JOIN s.subSubCategoryList u WHERE" +
                " u.quizEntities.size > 0");
        return  query.getResultList();
    }
}
