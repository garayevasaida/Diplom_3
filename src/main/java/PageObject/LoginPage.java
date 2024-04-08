package PageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }
    private final By registrationButton = By.xpath(".//a[@href='/register' and text()='Зарегистрироваться']");
    private final By emailField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_text input_size_default']/input[@name='name']");
    private final By passwordField = By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default']/input[@name='Пароль']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By resetPasswordButton = By.xpath(".//a[@href='/forgot-password' and text()='Восстановить пароль']");
    private final By inputField = By.xpath(".//main/div/h2[text()='Вход']");
    @Step("Клик на ссылку «Зарегистрироваться»")
    public void clickRegistrationButton() {

        driver.findElement(registrationButton).click();
    }
    @Step("Заполнение Email")
    public void sendKeyToEmailField(String email) {

        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Заполнение Password")
    public void sendKeyToPasswordField(String password) {

        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Клик на кнопку «Войти»")
    public void clickLoginButton() {

        driver.findElement(loginButton).click();
    }
    @Step("Клик на «Восстановить пароль»")
    public void clickResetPasswordButton() {

        driver.findElement(resetPasswordButton).click();
    }
    @Step("Отображение кнопки «Войти»")
    public boolean inputFieldIsDisplayed() {
        return driver.findElement(inputField).isDisplayed();
    }

}
