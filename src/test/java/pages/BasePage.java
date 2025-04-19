package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utils.Waiter;

import java.time.Duration;

/**
 * Базовый класс для страниц в тестах, использующий Selenium WebDriver.
 * Содержит общие методы для работы с элементами страницы,
 * включая ожидание и взаимодействие с элементами.
 */
public class BasePage {
    protected WebDriver driver;
    protected Waiter waiter;

    /**
     * Конструктор класса BasePage.
     * Инициализирует WebDriver, WebDriverWait и элементы страницы.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Ожидает видимость элемента и возвращает его текст.
     *
     * @param element элемент, текст которого нужно получить.
     * @return текст элемента.
     */
    public String waitAndGetText(WebElement element) {
        waiter.waitForVisibility(element);
        return element.getText();
    }

    /**
     * Ожидает видимость элемента и возвращает значение его атрибута "href".
     *
     * @param element элемент, значение атрибута которого нужно получить.
     * @return значение атрибута "href" элемента.
     */
    public String waitAndGetHref(WebElement element) {
        waiter.waitForVisibility(element);
        return element.getAttribute("href");
    }

    /**
     * Ожидает видимость элемента и проверяет, отображается ли он.
     *
     * @param element элемент, который нужно проверить.
     * @return true, если элемент отображается, иначе false.
     */
    public boolean waitAndIsDisplayed(WebElement element) {
        waiter.waitForVisibility(element);
        return element.isDisplayed();
    }

    /**
     * Ожидает кликабельность элемента и перемещает курсор мыши к нему.
     *
     * @param element элемент, к которому нужно переместить курсор.
     * @return текущий экземпляр BasePage для цепочки вызовов.
     */
    public BasePage waitAndMove(WebElement element) {
        waiter.waitForClickability(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        return this;
    }

    /**
     * Ожидает кликабельность элемента и выполняет клик по нему.
     *
     * @param element элемент, по которому нужно кликнуть.
     * @return текущий экземпляр BasePage для цепочки вызовов.
     */
    public BasePage waitAndClick(WebElement element) {
        waiter.waitForClickability(element);
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
        return this;
    }

}
