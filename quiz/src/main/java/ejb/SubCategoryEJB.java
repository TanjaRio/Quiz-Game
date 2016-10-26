package ejb;

import entity.RootCategory;
import entity.SubCategory;
import entity.SubSubCategory;

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

    public String createSubCategory(String categoryName, String rootCategoryName) {
        RootCategory rootCategory = rootCategoryEJB.findRootCategory(rootCategoryName);
        SubCategory subCategory = new SubCategory();
        subCategory.setSubCategoryName(categoryName);
        subCategory.setRootCategory(rootCategory);
        em.persist(subCategory);
        rootCategory.getSubCategoryList().add(subCategory);
        return subCategory.getSubCategoryName();
    }

    public SubCategory findSubCategory(String subCategoryName) {
        SubCategory subCategory = em.find(SubCategory.class, subCategoryName);
        return subCategory;
    }

    public List<SubCategory> getAll(){
        Query query = em.createQuery("select s from SubCategory s");
        return query.getResultList();
    }

    public boolean deleteSubCategory(String categoryName){
        SubCategory subCategory = em.find(SubCategory.class, categoryName);
        if(subCategory != null){
            em.remove(subCategory);
            return true;
        }
        return false;
    }
}
