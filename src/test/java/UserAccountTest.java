import pom.HomePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserAccountTest {
    private User user;
    private HomePage homePage;
    private  String accessToken;
    private  ValidatableResponse response;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        user = User.getNewUser();
        response = user.createUser(user);
        accessToken = response.extract().path("accessToken");
    }

    @After
    public void clearState() {
        user.deleteUser(StringUtils.substringAfter(accessToken, " "));
        Selenide.clearBrowserLocalStorage();
        user = null;
    }

    @Test
    @DisplayName("Переход по клику на Личный кабинет")
    public void transitionToLK() {
        homePage = open(HomePage.URL, HomePage.class);
        String txt = homePage.clickAccountButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton()
                .getTextFieldAccount();
        assertEquals("В этом разделе вы можете изменить свои персональные данные", txt);
    }
    @Test
    @DisplayName("Переход по клику на «Конструктор» и на логотип Stellar Burgers")
    public void transitionToLogoBurger() {
        homePage = open(HomePage.URL, HomePage.class);
        String url = homePage.clickAccountButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton()
                .clickLogoBurgerGetCurrentUrl();
        assertEquals(HomePage.URL, url);
    }
    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void logoutUserByLogoutButton() {
        homePage = open(HomePage.URL, HomePage.class);
        homePage.clickAccountButton()
                .fillLoginForm(user.getEmail(), user.getPassword())
                .clickLoginButton(Condition.hidden);
        boolean isDisplayed = homePage.clickAccountButtonGoAccountPage()
                .clickLogoutButtonIsDisplayed(Condition.hidden);
        assertFalse(isDisplayed);
    }
}