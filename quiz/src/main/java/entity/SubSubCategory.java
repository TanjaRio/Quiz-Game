package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
}
