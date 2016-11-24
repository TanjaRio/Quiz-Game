package no.westerdals.restApi;

import no.westerdals.quiz.entity.SubCategory;
import no.westerdals.restApi.api.Formats;
import no.westerdals.restApi.dto.CategoryDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

/**
 * Created by Bruker on 14.11.2016.
 */
public class CategoryRestIT {
    @Test
    public void testCreateAndGetWithNewFormat() {

        String categoryName = "Computer Science";
        List<SubCategory> subcategories = new ArrayList<>();
        CategoryDto dto = new CategoryDto(categoryName, subcategories);

        //no news
        given().contentType(Formats.V1_NEWS_JSON)
                .get()
                .then()
                .statusCode(200)
                .body("size()", is(0));

        //create a news
        String id = given().contentType(Formats.V1_NEWS_JSON)
                .body(dto)
                .post()
                .then()
                .statusCode(200)
                .extract().asString();

        //should be 1 news now
        given().contentType(Formats.V1_NEWS_JSON)
                .get()
                .then()
                .statusCode(200)
                .body("size()", is(1));

        //1 news with same data as the POST
        given().accept(Formats.V1_NEWS_JSON)
                .pathParam("id", id)
                .get("/{id}")
                .then()
                .statusCode(200)
                .body("newsId", is(id))
                .body("authorId", is(author))
                .body("text", is(text))
                .body("country", is(country));
    }

    @Test
    public void testDoubleDelete(){

        NewsDto dto = new NewsDto(null, "author", "text", "Norway", null);

        //create a news
        String id = given().contentType(Formats.V1_NEWS_JSON)
                .body(dto)
                .post()
                .then()
                .statusCode(200)
                .extract().asString();

        delete("/"+id).then().statusCode(204);

        //delete again
        delete("/"+id).then().statusCode(404); //note the change from 204 to 404
    }

}
