package PageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CabinetPage {
    WebDriver driver;
    public CabinetPage(WebDriver driver) {

        this.driver = driver;
    }
    private final By constructorButton = By.xpath(".//a[@href='/']/p[text()='Конструктор']");
    private final By logoButton = By.xpath(".//div/a[@href='/']");
    private final By exitButton = By.xpath(".//li/button[text()='Выход']");
    public final By textAccountPage = By.xpath(".//nav/p[text()='В этом разделе вы можете изменить свои персональные данные']");
    @Step("Клик на кнопку «Выход»")
    public void clickExitButton() {

        driver.findElement(exitButton).click();
    }
    @Step("Клик на лого")
    public void clickLogoButton() {

        driver.findElement(logoButton).click();
    }
    @Step("Клик на кнопку «Конструктор»")
    public void clickConstructorButton() {

        driver.findElement(constructorButton).click();
    }
    public boolean textAccountPageIsDisplayed() {

        return driver.findElement(textAccountPage).isDisplayed();
    }

}
