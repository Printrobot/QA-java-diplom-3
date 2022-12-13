package pom;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {
    // Поле ввода "Имя"
    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input")
    private SelenideElement inputName;
    // Поле ввода "Email"
    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input")
    private SelenideElement inputEmail;
    // Поле ввода "Пароль"
    @FindBy(how = How.XPATH, using = ".//fieldset[3]//input")
    private SelenideElement inputPassword;
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginLink;
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    public SelenideElement passwordError;

    @Step("Установка значения в поле 'Имя'")
    public RegistrationPage setName(String name) {
        inputName.click();
        inputName.setValue(name);
        return this;
    }
    @Step ("Установка значения в поле 'Email'")
    public RegistrationPage setEmail(String email) {
        inputEmail.click();
        inputEmail.setValue(email);
        return this;
    }
    @Step ("Установка значения в поле 'Пароль'")
    public RegistrationPage setPassword(String password) {
        inputPassword.click();
        inputPassword.setValue(password);
        return this;
    }
    public boolean clickRegisterButton(Condition condition) {
        registerButton.click();
        return registerButton.shouldBe(condition).isDisplayed();
    }
    public LoginPage clickLoginLink() {
        loginLink.click();
        return page(LoginPage.class);
    }
}
