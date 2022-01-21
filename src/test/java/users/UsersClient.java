package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response createUser(CreateUserRequestBody body) {
        return given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer f783ed5aa518e9ec9e4e7febbf943956672c09233e3f819c1cf2fa2ba45a6a31")
                    .body(body)
                .when()
                    .post("https://gorest.co.in/public/v1/users");
    }

    public Response getAllUsers() {
        return given()
                .when()
                    .get("https://gorest.co.in/public/v1/users");
    }

}
