package no.westerdals.restApi.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import no.westerdals.restApi.dto.CategoryDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @ApiOperation("Get all the categories")
    @GET
    List<CategoryDto> get();
}
