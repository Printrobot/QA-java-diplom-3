import POM.HomePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.*;

public class RegistrationTest {
    private User user;
    private HomePage homePage;
    private String accessToken;
    private ValidatableResponse response;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        user = User.getNewUser();
        homePage = open(HomePage.URL, HomePage.class);
    }
    @After
    public void clearState() {
        Selenide.clearBrowserLocalStorage();
        user = null;
    }
    @Test
    @DisplayName("Успешная регистрация")
    public void registerUserByValidCredentials() {
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), user.getPassword())
                .clickRegisterButton(Condition.hidden);
        assertFalse(isDisplayed);
        response = user.loginUser(user);
        accessToken = response.extract().path("accessToken");
        user.deleteUser(StringUtils.substringAfter(accessToken, " "));
    }
    @Test
    @DisplayName("Регистрация. Ошибка для некорректного пароля < 6 символов")
    public void registerUserByInvalidPassword() {
        final String password = RandomStringUtils.randomAlphabetic(5);
        boolean isDisplayed = homePage.clickLoginButton()
                .clickRegisterLink()
                .fillRegisterForm(user.getName(), user.getEmail(), password)
                .clickRegisterButton(Condition.visible);
        if(isDisplayed){
            }
            else{
            response = user.loginUser(user);
            accessToken = response.extract().path("accessToken");
            user.deleteUser(StringUtils.substringAfter(accessToken, " "));
        }
    }
}
