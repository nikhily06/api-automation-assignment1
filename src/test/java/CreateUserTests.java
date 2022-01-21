import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUserTests {

    @Test
    public void shouldCreateMaleUser() {
        // AAA

        // Arrange
        String body = "{\n" +
                "    \"name\":\"Tenali Ramakrishna\",\n" +
                "    \"gender\":\"male\",\n" +
                "    \"email\":\"tenali.ramakrishna3@anymail.com\",\n" +
                "    \"status\":\"active\"\n" +
                "}";

        // Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
        // Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.ramakrishna3@anymail.com"));
    }

    @Test
    public void shouldCreateFemaleUser() {
        // AAA

        // Arrange
        String body = "{\n" +
                "    \"name\":\"Aditi Ramakrishna\",\n" +
                "    \"gender\":\"female\",\n" +
                "    \"email\":\"aditi.ramakrishna3@anymail.com\",\n" +
                "    \"status\":\"active\"\n" +
                "}";

        // Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
        // Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("aditi.ramakrishna3@anymail.com"));
    }

}
