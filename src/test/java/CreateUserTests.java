import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

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
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("Tenali Ramakrishna").gender("male").email(email).status("active").build();

        // 2.Act
        usersClient.createUser(requestBody)
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
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().name("Aditi Ramakrishna").gender("female").email(email).status("active").build();

        // 2.Act
        usersClient.createUser(requestBody)
                .then()
                .log().body()
        // 3.Assert
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email));
    }

}
