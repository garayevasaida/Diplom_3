package PageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrPage {
    WebDriver driver;
    public RegistrPage(WebDriver driver) {

        this.driver = driver;
    }
    private final By nameField = By.xpath(".//div[./label[text()='Имя']]/input[@name='name']");
    private final By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");
    private final By passwordField = By.xpath(".//div[./label[text()='Пароль']]/input[@name='Пароль']");
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    public final By errorPasswordField = By.className("input__error");
    public final By loginButton = By.className("Auth_link__1fOlj");

    @Step("Клик на кнопку 'Зарегистрироваться'")
    public void clickRegistrationButton() {

        driver.findElement(registrationButton).click();
    }
    @Step("Ввести имя пользователя")
    public void clickAndSendKeyToNameField(String name) {
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }
    @Step("Ввести почту пользователя")
    public void clickAndSendKeyToEmailField(String email) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Ввести пароль пользователя")
    public void clickAndSendKeyToPasswordField(String password) {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Клик на кнопку 'Войти'")
    public void clickLoginButton() {

        driver.findElement(loginButton).click();
    }

    @Step("Проверить, что сообщение об ошибке регистрации отображается")
    public boolean errorPasswordFieldIsDisplayed() {

        return driver.findElement(errorPasswordField).isDisplayed();
    }

}
