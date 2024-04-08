import PageObject.HomePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import PageObject.*;
import constants.*;
import org.openqa.selenium.WebDriver;

public class LogoutTest {
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
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете")
    public void checkExitButton() {
        homePage.clickAccountButton();
        cabinetPage.clickExitButton();
        Assert.assertTrue("Выход не произошел", loginPage.enterTextIsDisplayed());
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
