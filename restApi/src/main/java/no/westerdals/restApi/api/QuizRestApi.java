package no.westerdals.restApi.api;

/**
 * Created by Bruker on 21.11.2016.
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import no.westerdals.restApi.dto.QuizDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Api(value = "/quizzes" , description = "Handling of creating and retrieving quizzes")
@Path("/quizzes")
@Produces({
        Formats.V1_NEWS_JSON, //custom Json with versioning
        Formats.BASE_JSON //old format
})
public interface QuizRestApi {

    @Path("/randomQuiz")
    @ApiOperation("Get a random quiz")
    @GET
    QuizDto getRandomQuiz(
            @ApiParam("The country name")
            @QueryParam("country")
                    String country,
            //
            @ApiParam("The id of the author who wrote the news")
            @QueryParam("authorId")
                    String authorId
    );

    @Path("/randomQuizzes")
    @ApiOperation("Get random quizzes")
    @GET
    QuizDto getRandomQuiz(
                    @ApiParam("The country name")
                    @QueryParam("n")
                            int n,
                    //
                    @ApiParam("The id of the author who wrote the news")
                    @QueryParam("authorId")
                            String authorId
            )

    ///randomQuiz?filter=x

    ///randomQuizzes?n=y&filter=x
}
