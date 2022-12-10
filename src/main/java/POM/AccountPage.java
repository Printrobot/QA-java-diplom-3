package POM;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AccountPage {
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructor;
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoBurger;

    @FindBy(how = How.XPATH, using = ".//*[@class='Account_text__fZAIn text text_type_main-default']")
    private SelenideElement textFieldAccount;

    public String getTextFieldAccount() {
        String textFieldAccount = "В этом разделе вы можете изменить свои персональные данные";
        return textFieldAccount;
}
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement accountButton;

    public String clickAccountButton() {
        accountButton.click();
        return Selenide.switchTo().window(0).getCurrentUrl();
    }

    public String clickConstructor() {
        constructor.click();
        return Selenide.switchTo().window(0).getCurrentUrl();
    }
    public String clickLogoBurger() {
        logoBurger.click();
        return Selenide.switchTo().window(0).getCurrentUrl();
    }
    public boolean clickLogoutButton(Condition condition) {
        logoutButton.click();
        return logoutButton.shouldBe(condition).isDisplayed();
    }
}
