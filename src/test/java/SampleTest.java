import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTest {

    @Test
    public void shouldGetAllUsers() {
        // AAA

        given()
            .when()
                .get("https://gorest.co.in/public/v1/users")
            .then()
                .statusCode(200)
                .body("data", Matchers.hasSize(20))
                .body("data", Matchers.hasItem(Matchers.hasEntry("gender", "male")))
                .log().body();
    }

    @Test
    public void shouldCreateUser() {
        // AAA

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer f783ed5aa518e9ec9e4e7febbf943956672c09233e3f819c1cf2fa2ba45a6a31")
                .body("{\n" +
                        "    \"name\":\"Tenali Ramakrishna\",\n" +
                        "    \"gender\":\"male\",\n" +
                        "    \"email\":\"tenali.ramakrishna2@anymail.com\",\n" +
                        "    \"status\":\"active\"\n" +
                        "}")
            .when()
                .post("https://gorest.co.in/public/v1/users")
            .then()
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.ramakrishna2@anymail.com"));
    }

}
