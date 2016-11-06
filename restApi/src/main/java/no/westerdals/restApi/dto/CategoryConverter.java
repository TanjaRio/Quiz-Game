package no.westerdals.restApi.dto;

import no.westerdals.quiz.entity.RootCategory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
public class CategoryConverter {
    public static CategoryDto transform(RootCategory entity){
        Objects.requireNonNull(entity);

        CategoryDto dto = new CategoryDto();
        dto.categoryName = entity.getCategoryName();
        dto.subCategoryList = entity.getSubCategoryList();
        return dto;
    }

    public static List<CategoryDto> transform(List<CategoryDto> entities){
        Objects.requireNonNull(entities);

        return entities.stream()
                .map(CategoryDto::transform)
                .collect(Collectors.toList());
    }
}
