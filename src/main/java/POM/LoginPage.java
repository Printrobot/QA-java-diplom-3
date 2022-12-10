package POM;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    @FindBy(how = How.XPATH, using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerLink;
    @FindBy(how = How.XPATH, using = ".//a[text()='Восстановить пароль']")
    private SelenideElement forgotPasswordLink;
    @FindBy(how = How.XPATH, using = ".//input[@name='name']")
    public SelenideElement emailField;
    @FindBy(how = How.XPATH, using = ".//input[@name='Пароль']")
    public SelenideElement passwordField;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    public RegistrationPage clickRegisterLink() {
        registerLink.click();
        return page(RegistrationPage.class);
    }
    public ForgotPasswordPage clickForgotPassword() {
        forgotPasswordLink.click();
        return page(ForgotPasswordPage.class);
    }
    public void setEmailField(String email) {
        emailField.setValue(email);
    }
    public void setPasswordField(String password) {
        passwordField.setValue(password);
    }
    public LoginPage fillLoginForm(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        return page(LoginPage.class);
    }
    public AccountPage clickLoginButton() {
        loginButton.click();
        return page(AccountPage.class);
    }
    public boolean clickLoginButton(Condition condition) {
        loginButton.click();
        return loginButton.shouldBe(condition).isDisplayed();
    }
}
