package PageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordPage {
    WebDriver driver;
    public PasswordPage(WebDriver driver) {

        this.driver = driver;
    }
    private final By loginButton = By.xpath(".//div/p/a[@href = '/login' and text() = 'Войти']");
    @Step("Клик на кнопку 'Войти'")
    public void clickLoginButton() {

        driver.findElement(loginButton).click();
    }
}
