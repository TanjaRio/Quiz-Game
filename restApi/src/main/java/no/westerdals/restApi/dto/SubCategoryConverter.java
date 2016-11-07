package no.westerdals.restApi.dto;

import no.westerdals.quiz.entity.RootCategory;
import no.westerdals.quiz.entity.SubCategory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
public class SubCategoryConverter {
    public static SubCategoryDto transform(SubCategory entity){
        Objects.requireNonNull(entity);

        SubCategoryDto dto = new SubCategoryDto();
        dto.subCategoryName = entity.getSubCategoryName();
        dto.rootCategory = entity.getRootCategory();
        dto.subSubCategoryList = entity.getSubSubCategoryList();
        return dto;
    }

    public static List<CategoryDto> transform(List<CategoryDto> entities){
        Objects.requireNonNull(entities);

        return entities.stream()
                .map(CategoryDto::transform)
                .collect(Collectors.toList());
    }
}
