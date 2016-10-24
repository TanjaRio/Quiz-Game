package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */

@Entity
public class SubSubCategory {
    @Id
    private String subSubCategoryName;

    @ManyToOne
    private SubSubCategory subCategory;

    @OneToMany
    private List<QuizEntity> quizEntities;

    public SubSubCategory() {}

    public SubSubCategory(String subSubCategoryName) {
        this.subSubCategoryName = subSubCategoryName;
        this.quizEntities = new ArrayList<>();
    }

    public String getSubSubCategoryName() {
        return subSubCategoryName;
    }

    public void setSubSubCategoryName(String subSubCategoryName) {
        this.subSubCategoryName = subSubCategoryName;
    }

    public SubSubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubSubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public List<QuizEntity> getQuizEntities() {
        return quizEntities;
    }

    public void setQuizEntities(List<QuizEntity> quizEntities) {
        this.quizEntities = quizEntities;
    }
}
