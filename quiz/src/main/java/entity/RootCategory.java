package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany
    List<SubCategory> subCategoryList;

}
