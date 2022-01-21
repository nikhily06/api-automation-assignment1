import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserNegativeTests {

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail() {
        // AAA

        // Arrange
        String body = "{\n" +
                "    \"name\":\"Aditi Ramakrishna\",\n" +
                "    \"gender\":\"female\",\n" +
                "    \"email\":\"aditi.ramakrishna3anymail.com\",\n" +
                "    \"status\":\"active\"\n" +
                "}";

        // Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
                // Act
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }

}
