package no.westerdals.restApi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import no.westerdals.quiz.entity.QuizEntity;
import no.westerdals.quiz.entity.SubCategory;

import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@ApiModel("A subsubcategory")
public class SubSubCategoryDto {
    @ApiModelProperty("The id of the subsubcategory")
    public Long id;

    @ApiModelProperty("The name  of the subsubcategory")
    public String subSubCategoryName;

    @ApiModelProperty("The name  of the subcategory the subsubcategory belongs to")
    public SubCategory subCategory;

    @ApiModelProperty("The list of quiz questions of the subsubcategory")
    public List<QuizEntity> quizEntities;

    public SubSubCategoryDto(){}

    public SubSubCategoryDto(String subSubCategoryName, SubCategory subCategory, List<QuizEntity> quizEntities) {
        this.subSubCategoryName = subSubCategoryName;
        this.subCategory = subCategory;
        this.quizEntities = quizEntities;
    }
}
