package ejb;

import entity.QuizEntity;
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
public class SubSubCategoryEJB {
    @Inject
    private SubCategoryEJB subCategoryEJB;

    @PersistenceContext
    private EntityManager em;

    public String createSubSubCategory(String subSubCategoryName, String subCategoryName) {
        SubCategory subCategory = subCategoryEJB.findSubCategory(subCategoryName);
        SubSubCategory subSubCategory = new SubSubCategory();
        subSubCategory.setSubSubCategoryName(subSubCategoryName);
        subSubCategory.setSubCategory(subCategory);
        em.persist(subSubCategory);

        subCategory.getSubSubCategoryList().add(subSubCategory);
        return subCategory.getSubCategoryName();
    }

    public List<QuizEntity> getQuizQuestions() {
        Query query = em.createQuery("select s from SubSubCategory s");
        return query.getResultList();
    }

    public List<SubSubCategory> getAll(){
        Query query = em.createQuery("select s from SubSubCategory s");
        return query.getResultList();
    }

    public boolean deleteSubSubCategory(String categoryName){
        SubSubCategory subSubCategory = em.find(SubSubCategory.class, categoryName);
        if(subSubCategory != null){
            em.remove(subSubCategory);
            return true;
        }
        return false;
    }

    public SubSubCategory findSubSubCategory(String categoryId) {
        SubSubCategory subSubCategory = em.find(SubSubCategory.class, categoryId);
        return subSubCategory;
    }
}
