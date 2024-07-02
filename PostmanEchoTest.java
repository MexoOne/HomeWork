import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Автотесты для методов из папки Request Methods коллекции Postman Echo")
public class PostmanEchoTest {
    final static String BASE_URL="https://postman-echo.com";

    @DisplayName("GET")
    @Test
    public void testGet(){
        final String[] par={"foo1", "foo2"};
        final String[] val={"bar1", "bar2"};

        given()
                .baseUri(BASE_URL)
                .queryParam(par[0], val[0])
                .queryParam(par[1], val[1]).
        when()
                .get("/get").
        then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("args."+par[0], equalTo(val[0]))
                .and().body("args."+par[1], equalTo(val[1]));
    }

    @DisplayName("POST RAW")
    @Test
    public void testPostRaw(){
        final String text="This is expected to be sent back as part of response body.";

        given()
                .baseUri(BASE_URL)
                .body(text).
        when()
                .post("/post").
        then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(text));
    }

    @DisplayName("POST FORM")
    @Test
    public void testPostForm(){
        final String[] par={"foo1", "foo2"};
        final String[] val={"bar1", "bar2"};

        given()
                .baseUri(BASE_URL)
                .contentType("application/x-www-form-urlencoded; charset=utf-8") //без этого 500 с уточнением Unsupported charset
                .formParam(par[0], val[0])
                .formParam(par[1], val[1]).
        when()
                .post("/post").
        then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("form."+par[0], equalTo(val[0]))
                .and().body("form."+par[1], equalTo(val[1]));
    }

    @DisplayName("PUT")
    @Test
    public void testPut(){
        final String text="This is expected to be sent back as part of response body.";

        given()
                .baseUri(BASE_URL)
                .body(text).
        when()
                .put("/put").
        then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(text));
    }

    @DisplayName("Patch")
    @Test
    public void testPatch(){
        final String text="This is expected to be sent back as part of response body.";

        given()
                .baseUri(BASE_URL)
                .body(text).
        when()
                .patch("/patch").
        then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(text));
    }

    @DisplayName("DELETE")
    @Test
    public void testDelete(){
        final String text="This is expected to be sent back as part of response body.";

        given()
                .baseUri(BASE_URL)
                .body(text).
        when()
                .delete("/delete").
        then()
                .statusCode(HttpStatus.SC_OK)
                .and().body("data", equalTo(text));
    }
}