package no.westerdals.restApi.dto;

import io.swagger.annotations.ApiModelProperty;
import no.westerdals.quiz.entity.RootCategory;

import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
public class QuizDto {
    @ApiModelProperty("The name  of the category")
    public Long quizId;

    @ApiModelProperty("The level the quiz question belongs to")
    public RootCategory rootCategory;

    @ApiModelProperty("The quiz question")
    public String question;

    @ApiModelProperty("The list of incorrent possible answers")
    public List<String> answers;

    @ApiModelProperty("The correct answer to the question")
    public String correctAnswer;

    @ApiModelProperty("Boolean tracker of wether or not the quiz is answered correctly")
    public boolean isCorrectAnswer;

    public QuizDto(){}

    public QuizDto(Long quizId, RootCategory rootCategory, String question, List<String> answers, String correctAnswer, boolean isCorrectAnswer) {
        this.quizId = quizId;
        this.rootCategory = rootCategory;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.isCorrectAnswer = isCorrectAnswer;
    }
}
