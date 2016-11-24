package no.westerdals.quiz.ejb;

import no.westerdals.quiz.entity.QuizEntity;
import no.westerdals.quiz.entity.SubCategory;
import no.westerdals.quiz.entity.SubSubCategory;

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

    public Long createSubSubCategory(String subSubCategoryName, Long subCategoryId) {
        SubCategory subCategory = subCategoryEJB.findSubCategory(subCategoryId);
        SubSubCategory subSubCategory = new SubSubCategory();
        subSubCategory.setSubSubCategoryName(subSubCategoryName);
        subSubCategory.setSubCategory(subCategory);
        em.persist(subSubCategory);

        subCategory.getSubSubCategoryList().add(subSubCategory);
        return subCategory.getId();
    }

    public List<QuizEntity> getQuizQuestions() {
        Query query = em.createQuery("select s from SubSubCategory s");
        return query.getResultList();
    }

    public List<SubSubCategory> getAll(){
        Query query = em.createQuery("select s from SubSubCategory s");
        return query.getResultList();
    }

    public boolean deleteSubSubCategory(Long id){
        SubSubCategory subSubCategory = em.find(SubSubCategory.class, id);
        if(subSubCategory != null){
            em.remove(subSubCategory);
            return true;
        }
        return false;
    }

    public SubSubCategory findSubSubCategory(Long categoryId) {
        SubSubCategory subSubCategory = em.find(SubSubCategory.class, categoryId);
        return subSubCategory;
    }

    public  List<SubSubCategory> getSubSubCategoriesWithQuizzes() {
        Query query = em.createQuery("select s from SubSubCategory s WHERE" +
                " s.quizEntities.size > 0");
        return  query.getResultList();
    }
}
