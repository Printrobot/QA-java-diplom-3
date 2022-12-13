package pom;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.page;

public class HomePage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement accountButton;
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;
    //локатор раздел «Булки»
    @FindBy(how = How.XPATH, using = ".//h2[text()='Булки']")
    private static SelenideElement bunSection;
    //локатор кнопки «Булки»
    @FindBy(how = How.XPATH, using = "//*[text()='Булки']")
    private static SelenideElement bunButton;
    @FindBy(how = How.XPATH, using = "//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement bun;
    @FindBy(how = How.XPATH, using = "//div/span[text() = 'Соусы']")
    private SelenideElement sauce;
    @FindBy(how = How.XPATH,using = "//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement selectedSauce;
    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private static SelenideElement fillingButton;
    @FindBy(how = How.XPATH, using = "//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']")
    private SelenideElement selectedFilling;

    public LoginPage clickAccountButton() {
        accountButton.click();
        return page(LoginPage.class);
    }

    public AccountPage clickAccountButtonGoAccountPage() {
        accountButton.click();
        return page(AccountPage.class);
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return page(LoginPage.class);
    }

    public String findBunIngredient() {
        return bun.getAttribute("class");
    }

    @Step("Клик по разделу «Булки»")
    public static void clickBunButton() {
        bunButton.shouldBe(enabled).click();
    }
    @Step("Проверка корректности отображения раздела Булки")
    public void checkBunSectionText() {
        bunSection.shouldHave(exactText("Булки"));
    }

    @Step("Клик по разделу «Соус»")
    public HomePage clickSauceIngredient(){
        sauce.click();
        return page(HomePage.class);
    }
    public String findSauceIngredient() {
        return selectedSauce.getAttribute("class");
    }
    @Step("Клик по разделу «Начинки»")
    public HomePage clickFillingIngredient() {
        fillingButton.click();
        return page(HomePage.class);
    }
        public String findFillingIngredient() {
            return selectedFilling.getAttribute("class");
        }
}