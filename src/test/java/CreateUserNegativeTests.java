import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

public class CreateUserNegativeTests {

    // Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail() {
        // 1.Arrange
        String name = "Aditi Ramakrishna";
        String gender = "female";
        String email = "aditi.ramakrishna3anymail.com";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, gender, email, status);

        // 2.Act
        usersClient.createUser(requestBody)
                .then()
                .log().body()
        // 3.Act
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }

}
