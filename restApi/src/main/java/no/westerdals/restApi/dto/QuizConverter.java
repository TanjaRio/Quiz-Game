package no.westerdals.restApi.dto;

import no.westerdals.quiz.entity.QuizEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
public class QuizConverter {
    public static QuizDto transform(QuizEntity entity){
        Objects.requireNonNull(entity);

        QuizDto quizDto = new QuizDto();
        quizDto.quizId = entity.getQuizId();
        quizDto.question = entity.getQuestion();
        quizDto.answers = entity.getAnswers();
        quizDto.correctAnswer = entity.getCorrectAnswer();
        quizDto.isCorrectAnswer = entity.isCorrectAnswer();
        return quizDto;
    }

    public static List<QuizDto> transform(List<QuizDto entities){
        Objects.requireNonNull(entities);

        return entities.stream()
                .map(QuizDto::transform)
                .collect(Collectors.toList());
    }
}
