package no.westerdals.quiz.ejb;

import no.westerdals.quiz.entity.RootCategory;
import no.westerdals.quiz.entity.SubCategory;

import javax.ejb.Stateless;
import javax.inject.Inject;
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
public class SubCategoryEJB {

    @Inject
    private RootCategoryEJB rootCategoryEJB;

    @PersistenceContext
    private EntityManager em;

    public Long createSubCategory(String categoryName, Long rootCategoryId) {
        RootCategory rootCategory = rootCategoryEJB.findRootCategory(rootCategoryId);
        SubCategory subCategory = new SubCategory();
        subCategory.setSubCategoryName(categoryName);
        subCategory.setRootCategory(rootCategory);
        em.persist(subCategory);
        rootCategory.getSubCategoryList().add(subCategory);
        return subCategory.getId();
    }

    public SubCategory findSubCategory(Long subCategoryId) {
        SubCategory subCategory = em.find(SubCategory.class, subCategoryId);
        return subCategory;
    }

    public List<SubCategory> getAll(){
        Query query = em.createQuery("select s from SubCategory s");
        return query.getResultList();
    }

    public boolean deleteSubCategory(Long id){
        SubCategory subCategory = em.find(SubCategory.class, id);
        if(subCategory != null){
            em.remove(subCategory);
            return true;
        }
        return false;
    }
}
