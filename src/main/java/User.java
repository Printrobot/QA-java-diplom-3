import io.qameta.allure.Allure;
import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import static io.restassured.RestAssured.given;

@Data
@AllArgsConstructor
public class User extends BaseAPI {
    private String email;
    private String password;
    private String name;
    public static User getNewUser() {
        String name = RandomStringUtils.randomAlphabetic(10);
        String email = name.toLowerCase() + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        Allure.addAttachment("Email : ", email);
        Allure.addAttachment("Password : ", password);
        Allure.addAttachment("Name : ", name);
        return new User(email, password, name);
    }
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .spec(getSpecification())
                .auth().oauth2(accessToken)
                .log().all()
                .delete("/api/auth/user")
                .then()
                .log().all();
    }
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getSpecification())
                .body(user)
                .log().all()
                .post("/api/auth/register")
                .then()
                .log().all();
    }
    public ValidatableResponse loginUser(User user) {
        return given()
                .spec(getSpecification())
                .body(user)
                .log().all()
                .post("/api/auth/login")
                .then()
                .log().all();
    }
}