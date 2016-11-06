package no.westerdals.restApi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import no.westerdals.quiz.entity.SubCategory;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@ApiModel("A category")
public class CategoryDto {

    @ApiModelProperty("The name  of the category")
    public String categoryName;

    @ApiModelProperty("The subcategories of the root category")
    public List<SubCategory> subCategoryList;

    public CategoryDto(){}

    public CategoryDto(String categoryName, List<SubCategory> subCategoryList) {
        this.categoryName = categoryName;
        this.subCategoryList = subCategoryList;
    }


}
