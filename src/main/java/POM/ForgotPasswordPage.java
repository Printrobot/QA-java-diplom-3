package POM;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;
public class ForgotPasswordPage {
@FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
private SelenideElement loginLink;
    public LoginPage clickLogin() {
        loginLink.click();
        return page(LoginPage.class);
    }
}
