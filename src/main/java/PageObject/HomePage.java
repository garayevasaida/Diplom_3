package PageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By makeBurgerText = By.xpath(".//h1[text()='Соберите бургер']");
    private final By orderButton = By.xpath("//button[text() = 'Оформить заказ']");
    private final By accountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By bunsButton = By.xpath("//div[contains(@class, 'tab_tab') and span[text()='Булки']]");
    private final By soucesButton = By.xpath("//span[@class='text text_type_main-default'][text()='Соусы']");
    private final By fillingsButton = By.xpath("//span[@class='text text_type_main-default'][text()='Начинки']");
    private final By bunsInfo = By.xpath("//div[contains(@class, 'tab_tab_type_current') and span[text()='Булки']]");
    private final By souseInfo = By.xpath("//div[contains(@class, 'tab_tab_type_current') and span[text()='Соусы']]");
    private final By fillingsInfo = By.xpath("//div[contains(@class, 'tab_tab_type_current') and span[text()='Начинки']]");

    @Step("Клик на кнопку «Войти в аккаунт»")
    public void clickLoginButton() {

        driver.findElement(loginButton).click();
    }
    @Step("Клик на кнопку «Личный кабинет»")
    public void clickAccountButton() {

        driver.findElement(accountButton).click();
    }
    @Step("Отображение кнопки «Оформить заказ»")
    public boolean orderButtonIsDisplayed() {
        return driver.findElement(orderButton).isDisplayed();
    }
    @Step("Отображение кнопки «Соберите бургер»")
    public boolean makeBurgerTextIsDisplayed() {

        return driver.findElement(makeBurgerText ).isDisplayed();
    }
    @Step("Клик на «Булки»")
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }
    @Step("Клик на «Соусы»")
    public void clickSoucesButton() {

        driver.findElement(soucesButton).click();
    }
    @Step("Клик на «Начинки»")
    public void clickFillingsButton() {

        driver.findElement(fillingsButton).click();
    }
    public boolean bunsInfoCheck() {

        return driver.findElement(bunsInfo).isDisplayed();
    }
    public boolean souseInfoCheck() {

        return driver.findElement(souseInfo).isDisplayed();
    }
    public boolean fillingsInfoCheck() {

        return driver.findElement(fillingsInfo).isDisplayed();
    }

}
