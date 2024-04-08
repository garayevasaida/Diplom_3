import PageObject.HomePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import PageObject.*;
import constants.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class CabinetTest {
    private WebDriver driver;
    String name="Sairis";
    String email="garayevas@yandex.ru";
    String password="123456";
    HomePage homePage;
    LoginPage loginPage;
    CabinetPage cabinetPage;
    User user;
    UserSteps userSteps;

    @Before
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        cabinetPage = new CabinetPage(driver);
        user = new User(email, password, name);
        userSteps.createUser(user);
        homePage.clickLoginButton();
        loginPage.sendKeyToEmailField(email);
        loginPage.sendKeyToPasswordField(password);
        loginPage.clickLoginButton();
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет».")
    public void cabinetButtonTest() {
        homePage.clickAccountButton();
        assertTrue(cabinetPage.textAccountPageIsDisplayed());
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор")
    public void constructorButtonTest() {
        homePage.clickAccountButton();
        cabinetPage.clickConstructorButton();
        assertTrue(homePage.makeBurgerTextIsDisplayed());
    }

    @Test
    @DisplayName("Переход по клику на на логотип Stellar Burgers.")
    public void logoButtonTest() {
        homePage.clickAccountButton();
        cabinetPage.clickLogoButton();
        assertTrue(homePage.makeBurgerTextIsDisplayed());
    }
    @After
    public void tearDown() {
        String accessToken = UserSteps.loginUser(new User(email, password)).then().extract().path("accessToken");
        if (accessToken != null) {
            UserSteps.deleteUser(accessToken);
        }
        driver.quit();
    }
}