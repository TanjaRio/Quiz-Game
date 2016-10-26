package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Entity
public class RootCategory {
    @Id
    private String categoryName;

    @OneToMany//(mappedBy = "rootCategory")
    Collection<SubCategory> subCategoryList;

    public RootCategory() {}

    public RootCategory(String categoryName) {
        this.categoryName = categoryName;
        subCategoryList = new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Collection<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(Collection<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
