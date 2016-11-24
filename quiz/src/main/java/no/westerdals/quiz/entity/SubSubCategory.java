package no.westerdals.quiz.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */

@Entity
public class SubSubCategory {
    @Id @GeneratedValue
    private Long id;

    @NotNull
    private String subSubCategoryName;

    @ManyToOne
    private SubCategory subCategory;

    @OneToMany//(mappedBy = "subSubCategory")
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

    public List<QuizEntity> getQuizEntities() {
        return quizEntities;
    }

    public void setQuizEntities(List<QuizEntity> quizEntities) {
        this.quizEntities = quizEntities;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
