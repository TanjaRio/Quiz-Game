package no.westerdals.restApi.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Created by Tanja Guntvedt Rio
 * PG5100 - Enterprise Programmering 1
 * Westerdals Oslo ACT
 */
@Api(value = "/subsubcategories" , description = "Handling of creating and retrieving subsubcategories")
@Path("/subsubcategories")
@Produces({
        Formats.V1_NEWS_JSON, //custom Json with versioning
        Formats.BASE_JSON //old format
})
public class SubsubcategoriesRestApi {

    @ApiOperation("Get all the news")
    @GET
    List<NewsDto> get(
            @ApiParam("The country name")
            @QueryParam("country")
            String country,
            //
            @ApiParam("The id of the author who wrote the news")
            @QueryParam("authorId")
            String authorId
    );
}
