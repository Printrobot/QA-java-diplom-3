import POM.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
    private HomePage homePage;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        homePage = open(HomePage.URL, HomePage.class);
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Булки»")
    @Description("Переход к разделу «Булки» по клику на слово Булки")
    public void checkToBunIngredient() {
        String isSelected = homePage.findBunIngredient();
        String expected = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        Assert.assertEquals(expected,isSelected);
    }

    @Test
    @DisplayName("Проверка перехода к разделу «Соусы»")
    @Description("Переход к разделу «Соусы» по клику на слово Соусы")
    public void checkToSauceIngredient() {
        homePage.clickSauceIngredient();
        //проверка отображения текста Соус
        homePage.checkSaucesSectionText();
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void checkToFillingIngredient() {
        //клик на слово Соусы
        homePage.clickFillingButton();
        //проверка, что отображаются булки
        homePage.checkFillingSectionText();
    }
}