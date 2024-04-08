import PageObject.HomePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import PageObject.*;
import constants.*;
import org.openqa.selenium.WebDriver;


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
    public void checkingSuccessfulRegistration() {
        registrPage.clickAndSendKeyToNameField(name);
        registrPage.clickAndSendKeyToEmailField(email);
        registrPage.clickAndSendKeyToPasswordField(password);
        registrPage.clickRegistrationButton();
        Assert.assertTrue("Регистрация не произошла", loginPage.enterTextIsDisplayed());
    }

    @Test
    @DisplayName("Проверка входа с некорректным паролем")
    public void checkingForBadPasswordLogin() {
        registrPage.clickAndSendKeyToNameField(name);
        registrPage.clickAndSendKeyToEmailField(email);
        registrPage.clickAndSendKeyToPasswordField(incorrectPassword);
        registrPage.clickRegistrationButton();
        Assert.assertTrue("Ошибка о некорректном пароле не появилась",
                registrPage.errorPasswordFieldIsDisplayed());
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
