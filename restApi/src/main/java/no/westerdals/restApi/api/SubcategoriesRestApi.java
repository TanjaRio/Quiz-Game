package no.westerdals.restApi.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import no.westerdals.restApi.dto.CategoryDto;
import no.westerdals.restApi.dto.SubCategoryDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Api(value = "/subcategories" , description = "Handling of creating and retrieving subcategories")
@Path("/subcategories")
@Produces({
        Formats.V1_NEWS_JSON, //custom Json with versioning
        Formats.BASE_JSON //old format
})
public interface SubcategoriesRestApi {
    String ID_PARAM ="The numeric id of the subcategory";

    @ApiOperation("Get all the subcategories")
    @GET
    List<SubCategoryDto> get();

    @ApiOperation("Get a single category specified by id")
    @GET
    @Path("/{id}")
    CategoryDto getCategory(
            @ApiParam(ID_PARAM)
            @PathParam("id")
                    Long id);


}


