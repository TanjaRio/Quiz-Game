package ejb;

import entity.QuizEntity;
import entity.SubSubCategory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Stateless
public class QuizEJB {
    @Inject
    private SubSubCategoryEJB subSubCategoryEJB;

    @PersistenceContext
    private EntityManager em;

    private Long createQuiz(String question, List<String> answers, String correctAnswer) {
        QuizEntity quiz = new QuizEntity();
        quiz.setQuestion(question);
        quiz.setAnswers(answers);
        quiz.setCorrectAnswer(correctAnswer);
        em.persist(quiz);
        return quiz.getQuizId();
    }

    private boolean isCorrectAnswer(String answer, Long quizId) {
        QuizEntity quizEntity = em.find(QuizEntity.class, quizId);
        if (answer == quizEntity.getCorrectAnswer()) {
            return true;
        }

        return false;
    }
}
