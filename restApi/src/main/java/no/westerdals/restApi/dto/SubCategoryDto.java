package no.westerdals.restApi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import no.westerdals.quiz.entity.RootCategory;
import no.westerdals.quiz.entity.SubCategory;
import no.westerdals.quiz.entity.SubSubCategory;

import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@ApiModel("A subcategory")
public class SubCategoryDto {
    @ApiModelProperty("The name  of the category")
    public String subCategoryName;

    @ApiModelProperty("The root category of the subcategory")
    public RootCategory rootCategory;

    @ApiModelProperty("The subsubcategories of the subcategory")
    public List<SubSubCategory> subSubCategoryList;


    public SubCategoryDto(){}

    public SubCategoryDto(String subCategoryName, RootCategory rootCategory, List<SubSubCategory> subSubCategoryList) {
        this.subCategoryName = subCategoryName;
        this.rootCategory = rootCategory;
        this.subSubCategoryList = subSubCategoryList;
    }
}
