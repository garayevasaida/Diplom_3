import constants.DriverFactory;
import PageObject.HomePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    private WebDriver driver;


    @Before
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.getDriver();

    }

    @Test
    @DisplayName("Переход на вкладку булки")
    public void testActiveBunsButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSoucesButton();
        homePage.clickBunsButton();
        assertTrue(homePage.bunsInfoCheck());
    }

    @Test
    @DisplayName("Переход на вкладку соусы")
    public void testActiveSaucesButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSoucesButton();
        assertTrue(homePage.souseInfoCheck());
    }

    @Test
    @DisplayName("Переход на вкладку начинки")
    public void testActiveFillingsButton() {
        HomePage homePage = new HomePage(driver);
        homePage.clickFillingsButton();
        assertTrue(homePage.fillingsInfoCheck());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}