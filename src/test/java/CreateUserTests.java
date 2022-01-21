import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import java.util.UUID;

public class CreateUserTests {

    // Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreateMaleUser() {

        // 1.Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "    \"name\":\"Tenali Ramakrishna\",\n" +
                "    \"gender\":\"male\",\n" +
                "    \"email\":\"%s\",\n" +
                "    \"status\":\"active\"\n" +
                "}", email);

        // 2.Act
        usersClient.createUser(body)
                .then()
                .log().body()
        // 3.Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email));
    }

    @Test
    public void shouldCreateFemaleUser() {

        // 1.Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "    \"name\":\"Aditi Ramakrishna\",\n" +
                "    \"gender\":\"female\",\n" +
                "    \"email\":\"%s\",\n" +
                "    \"status\":\"active\"\n" +
                "}", email);

        // 2.Act
        usersClient.createUser(body)
                .then()
                .log().body()
        // 3.Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email));
    }

}
