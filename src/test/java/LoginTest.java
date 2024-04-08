import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import PageObject.*;
import constants.*;
import org.openqa.selenium.WebDriver;

public class LoginTest {
    private WebDriver driver;
    String name="Sairis";
    String email="garayevas@yandex.ru";
    String password="123456";
    HomePage homePage;
    LoginPage loginPage;
    RegistrPage registrPage;
    PasswordPage passwordPage;
    User user;
    UserSteps userSteps;
    @Before
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrPage = new RegistrPage(driver);
        passwordPage= new PasswordPage(driver);
        user = new User(email, password, name);
        userSteps.createUser(user);
    }
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void checkLoginOnMainPage() {
        homePage.clickLoginButton();
        loginPage.sendKeyToEmailField(email);
        loginPage.sendKeyToPasswordField(password);
        loginPage.clickLoginButton();
        Assert.assertTrue("Кнопка оформить заказ не появилась", homePage.makeBurgerTextIsDisplayed());
    }
    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void checkLoginByPersonalAccountButton() {
        homePage.clickAccountButton();
        loginPage.sendKeyToEmailField(email);
        loginPage.sendKeyToPasswordField(password);
        loginPage.clickLoginButton();
        Assert.assertTrue("Кнопка оформить заказ не появилась", homePage.makeBurgerTextIsDisplayed());
    }
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void checkLoginOnRegistrationPage() {
        homePage.clickLoginButton();
        loginPage.clickRegistrationButton();
        registrPage.clickLoginButton();
        loginPage.sendKeyToEmailField(email);
        loginPage.sendKeyToPasswordField(password);
        loginPage.clickLoginButton();
        Assert.assertTrue("Кнопка оформить заказ не появилась", homePage.makeBurgerTextIsDisplayed());
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля.")
    public void checkLoginOnPasswordRecoveryPage() {
        homePage.clickLoginButton();
        loginPage.clickResetPasswordButton();
        passwordPage.clickLoginButton();
        loginPage.sendKeyToEmailField(email);
        loginPage.sendKeyToPasswordField(password);
        loginPage.clickLoginButton();
        Assert.assertTrue("Кнопка оформить заказ не появилась", homePage.makeBurgerTextIsDisplayed());
    }


    @After
    public void tearDown() {
        String accessToken = UserSteps.loginUser(new User(email,password)).then().extract().path("accessToken");
        if (accessToken != null) {
            UserSteps.deleteUser(accessToken);
        }
        driver.quit();
    }
}
