package no.westerdals.restApi.api;

import io.swagger.annotations.*;
import no.westerdals.restApi.dto.CategoryDto;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Api(value = "/categories" , description = "Handling of creating and retrieving categories")
@Path("/categories")
@Produces({
        Formats.V1_NEWS_JSON, //custom Json with versioning
        Formats.BASE_JSON //old format
})
public interface CategoriesRestApi {
    String ID_PARAM ="The numeric id of the news";

    @ApiOperation("Get all the categories")
    @GET
    List<CategoryDto> get();

    @ApiOperation("Create a category")
    @POST
    @Consumes({Formats.V1_NEWS_JSON, Formats.BASE_JSON})
    @Produces(Formats.BASE_JSON)
    @ApiResponse(code = 200, message = "The id of newly created category")
    Long createCategory(
            @ApiParam("The name of the category, along with a list of subcategories belonging to it")
                    CategoryDto dto);

    @ApiOperation("Get a single category specified by id")
    @GET
    @Path("/{id}")
    CategoryDto getCategory(
            @ApiParam(ID_PARAM)
            @PathParam("id")
                    Long id);

    //Deprecated version
    @ApiOperation("Deprecated. Use \"/{id}\" instead")
    @ApiResponses({
            @ApiResponse(code = 301, message = "Deprecated URI. Moved permanently.")
    })
    @Path("/id/{id}")
    @GET
    @Deprecated
    Response deprecatedGetById(
            @ApiParam(ID_PARAM)
            @PathParam("id")
                    Long id);

    @ApiOperation("Get a single category specified by id")
    @GET
    @Path("/withQuizzes")
    List <CategoryDto> getCategoriesWithQuizzes();
}
