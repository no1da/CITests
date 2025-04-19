package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс WayPageHeader расширяет функциональность класса BasePage,
 * предоставляя методы для взаимодействия с элементами заголовка страницы.
 * Этот класс включает методы для получения контактной информации,
 * такой как номера телефонов и ссылки на социальные сети.
 */
public class WayPageHeader extends WayPage {
    @FindBy(css = "a.lazyloaded[href=\"https://wa.me/+919711111558\"]")
    private WebElement headerPhoneNumber1;
    @FindBy(css = "[href=\"https://wa.me/+919711191558\"]")
    private WebElement headerPhoneNumber2;
    @FindBy(css = "[href=\"tel:+16464800603\"]")
    private WebElement headerPhoneNumber3;
    @FindBy(css = "[href=\"skype:seleniumcoaching?chat\"]")
    private WebElement headerSkype;
    @FindBy(css = "[href=\"mailto:trainer@way2automation.com\"]")
    private WebElement headerMail;
    @FindBy(css = "[href=\"https://www.facebook.com/way2automation\"]")
    private WebElement faceBook;
    @FindBy(css = "[href=\"https://in.linkedin.com/in/rahul-arora-0490b751\"]")
    private WebElement linkedIn;
    @FindBy(css = "[href=\"https://plus.google.com/u/0/+RamanAhujatheseleniumguru\"]")
    private WebElement google;
    @FindBy(css = "[href=\"https://www.youtube.com/c/seleniumappiumtutorialtraining\"]")
    private WebElement youTube;

    /**
     * Конструктор класса WayPageHeader.
     * Инициализирует веб-драйвер, унаследованный от класса BasePage.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public WayPageHeader(WebDriver driver) {
        super(driver);
    }

    /**
     * Получает текст первого номера телефона из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст первого номера телефона.
     */
    @Step("Get the first phone number from header")
    public String getPhoneNumber1() {
        return waitAndGetHref(headerPhoneNumber1);
    }

    /**
     * Получает текст второго номера телефона из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст второго номера телефона.
     */
    @Step("Get the second phone number from header")
    public String getPhoneNumber2() {
        return waitAndGetHref(headerPhoneNumber2);
    }

    /**
     * Получает текст третьего номера телефона из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст третьего номера телефона.
     */
    @Step("Get the third phone number from header")
    public String getPhoneNumber3() {
        return waitAndGetHref(headerPhoneNumber3);
    }

    /**
     * Получает текст ссылки на Skype из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст ссылки на Skype.
     */
    @Step("Get the Skype link text from header")
    public String getSkype() {
        return waitAndGetHref(headerSkype);
    }

    /**
     * Получает текст адреса электронной почты из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст адреса электронной почты.
     */
    @Step("Get the email address text from header")
    public String getMail() {
        return waitAndGetHref(headerMail);
    }

    /**
     * Получает URL Facebook из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return URL ссылки на Facebook.
     */
    @Step("Get the Facebook URL from header")
    public String getFaceBook() {
        return waitAndGetHref(faceBook);
    }

    /**
     * Получает URL LinkedIn из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return URL ссылки на LinkedIn.
     */
    @Step("Get the LinkedIn URL from header")
    public String getLinkedIn() {
        return waitAndGetHref(linkedIn);
    }

    /**
     * Получает URL Google из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return URL ссылки на Google.
     */
    @Step("Get the Google URL from header")
    public String getGoogle() {
        return waitAndGetHref(google);
    }

    /**
     * Получает URL YouTube из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return URL ссылки на YouTube.
     */
    @Step("Get the YouTube URL from header")
    public String getYouTube() {
        return waitAndGetHref(youTube);
    }
}
