package no.westerdals.restApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import no.westerdals.restApi.dto.CategoryDto;
import no.westerdals.utils.web.JBossUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.http.ContentType;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.get;
import static org.hamcrest.core.Is.is;


    public class CategoryRestTestBase {

        @BeforeClass
        public static void initClass() {
            JBossUtil.waitForJBoss(10);

            // RestAssured configs shared by all the tests
            RestAssured.baseURI = "http://localhost";
            RestAssured.port = 8080;
            RestAssured.basePath = "/restApi/api/categories";
            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        }


        @Before
        @After
        public void clean() {

        /*
           Recall, as Wildfly is running as a separated process, changed
           in the database will impact all the tests.
           Here, we read each resource (GET), and then delete them
           one by one (DELETE)
         */
            List<CategoryDto> list = Arrays.asList(given().accept(ContentType.JSON).get()
                    .then()
                    .statusCode(200)
                    .extract().as(CategoryDto[].class));


        /*
            Code 204: "No Content". The server has successfully processed the request,
            but the return HTTP response will have no body.
         */
            list.stream().forEach(dto ->
                    given().pathParam("id", dto.id)
                            .delete("/{id}")
                            .then().statusCode(204));

            get().then().statusCode(200).body("size()", is(0));
        }
}
