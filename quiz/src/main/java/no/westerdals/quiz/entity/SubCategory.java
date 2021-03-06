package no.westerdals.quiz.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Entity
public class SubCategory {

    @Id @GeneratedValue
    private Long id;

    @NotNull
    private String subCategoryName;

    @ManyToOne
    private RootCategory rootCategory;

    @OneToMany//(mappedBy = "subCategory")
    private List<SubSubCategory> subSubCategoryList;

    public SubCategory() {}

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public RootCategory getRootCategory() {
        return rootCategory;
    }

    public void setRootCategory(RootCategory rootCategory) {
        this.rootCategory = rootCategory;
    }

    public List<SubSubCategory> getSubSubCategoryList() {
        return subSubCategoryList;
    }

    public void setSubSubCategoryList(List<SubSubCategory> subSubCategoryList) {
        this.subSubCategoryList = subSubCategoryList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
