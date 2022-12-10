package POM;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginLink;
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;
    @FindBy(how = How.XPATH, using = ".//input[@class='text input__textfield text_type_main-default']")
    public ElementsCollection registerForm;
    @FindBy(how = How.XPATH, using = ".//p[text()='Некорректный пароль']")
    public SelenideElement passwordError;
    public void setNameField(String name) {
        registerForm.get(0).setValue(name);
    }
    public void setEmailField(String email) {
        registerForm.get(1).setValue(email);
    }
    public void setPasswordField(String password) {
        registerForm.get(2).setValue(password);
    }
    public RegistrationPage fillRegisterForm(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
        return page(RegistrationPage.class);
    }
    public boolean clickRegisterButton(Condition condition) {
        registerButton.click();
        return registerButton.shouldBe(condition).isDisplayed();
    }
//    public boolean isDisplayedPasswordError() {
//        clickRegisterButton(Condition.visible);
//        return passwordError.isDisplayed();
//    }
    public LoginPage clickLoginLink() {
        loginLink.click();
        return page(LoginPage.class);
    }
}
