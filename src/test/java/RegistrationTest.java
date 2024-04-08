import PageObject.HomePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import PageObject.*;
import constants.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class RegistrationTest{
    private WebDriver driver;
    String name="Sairis";
    String email="garayevas@yandex.ru";
    String password="123456";
    String incorrectPassword="123";
    HomePage homePage;
    LoginPage loginPage;
    RegistrPage registrPage;

    @Before
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrPage = new RegistrPage(driver);
        homePage.clickLoginButton();
        loginPage.clickRegistrationButton();
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void successfulRegistrationTest() {
        registrPage.clickAndSendKeyToNameField(name);
        registrPage.clickAndSendKeyToEmailField(email);
        registrPage.clickAndSendKeyToPasswordField(password);
        registrPage.clickRegistrationButton();
        assertTrue(loginPage.inputFieldIsDisplayed());
    }

    @Test
    @DisplayName("Проверка входа с некорректным паролем")
    public void incorretPasswordLoginTest() {
        registrPage.clickAndSendKeyToNameField(name);
        registrPage.clickAndSendKeyToEmailField(email);
        registrPage.clickAndSendKeyToPasswordField(incorrectPassword);
        registrPage.clickRegistrationButton();
        assertTrue(registrPage.incorrectPasswordFieldIsDisplayed());
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
