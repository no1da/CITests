package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс WayPageFuter расширяет функциональность класса BasePage,
 * предоставляя методы для взаимодействия с элементами футера страницы.
 * Этот класс включает методы для получения контактной информации,
 * такой как адрес, номера телефонов и электронные почты.
 */
public class WayPageFooter extends WayPage {
    @FindBy(css = ".elementor-icon-list-item > .elementor-icon-list-text")
    private WebElement footerAdress;
    @FindBy(xpath = "//span[text()='+91 97111-11-558']")
    private WebElement footerPhoneNumber1;
    @FindBy(xpath = "//span[text()='+91 97111-91-558']")
    private WebElement footerPhoneNumber2;
    @FindBy(xpath = "//span[text()='trainer@way2automation.com']")
    private WebElement footerMail1;
    @FindBy(xpath = "//span[text()='seleniumcoaching@gmail.com']")
    private WebElement footerMail2;

    /**
     * Конструктор класса WayPageFuter.
     * Инициализирует веб-драйвер, унаследованный от класса BasePage.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public WayPageFooter(WebDriver driver) {
        super(driver);
    }

    /**
     * Получает адрес из футера.
     * Включает ожидание видимости элемента адреса перед его извлечением.
     *
     * @return текст адреса из футера.
     */
    public String getFooterAdress() {
        return waitAndGetText(footerAdress);
    }

    /**
     * Получает первый номер телефона из футера.
     * Включает ожидание видимости элемента номера телефона перед его извлечением.
     *
     * @return текст первого номера телефона из футера.
     */
    public String getFooterPhoneNumber1() {
        return waitAndGetText(footerPhoneNumber1);
    }

    /**
     * Получает второй номер телефона из футера.
     * Включает ожидание видимости элемента номера телефона перед его извлечением.
     *
     * @return текст второго номера телефона из футера.
     */
    public String getFooterPhoneNumber2() {
        return waitAndGetText(footerPhoneNumber2);
    }

    /**
     * Получает первый адрес электронной почты из футера.
     * Включает ожидание видимости элемента адреса электронной почты перед его извлечением.
     *
     * @return текст первого адреса электронной почты из футера.
     */
    public String getFooterMail1() {
        return waitAndGetText(footerMail1);
    }

    /**
     * Получает второй адрес электронной почты из футера.
     * Включает ожидание видимости элемента адреса электронной почты перед его извлечением.
     *
     * @return текст второго адреса электронной почты из футера.
     */
    public String getFooterMail2() {
        return waitAndGetText(footerMail2);
    }
}