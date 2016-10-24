package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Entity
public class QuizEntity {
    @Id @GeneratedValue
    private Long quizId;

    @ManyToOne
    private SubSubCategory subSubCategory;

    private String question;

    private List<String> answers;
}
