package no.westerdals.quiz.entity;

import javax.persistence.*;
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

    @ElementCollection
    private List<String> answers;

    private String correctAnswer;

    private boolean isCorrectAnswer;

    public QuizEntity() {}

    public QuizEntity(String question, List<String> answers, String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.isCorrectAnswer = false;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public SubSubCategory getSubSubCategory() {
        return subSubCategory;
    }

    public void setSubSubCategory(SubSubCategory subSubCategory) {
        this.subSubCategory = subSubCategory;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        isCorrectAnswer = correctAnswer;
    }
}
