package no.westerdals.restApi.dto;

import no.westerdals.quiz.entity.RootCategory;
import no.westerdals.quiz.entity.SubSubCategory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
public class SubSubCategoryConverter {
    public static SubSubCategoryDto transform(SubSubCategory entity){
        Objects.requireNonNull(entity);

        SubSubCategoryDto dto = new SubSubCategoryDto();
        dto.subSubCategoryName = entity.getSubSubCategoryName();
        dto.subCategory = entity.getSubCategory();
        dto.quizEntities = entity.getQuizEntities();
        return dto;
    }

    public static List<CategoryDto> transform(List<CategoryDto> entities){
        Objects.requireNonNull(entities);

        return entities.stream()
                .map(CategoryDto::transform)
                .collect(Collectors.toList());
    }
}
