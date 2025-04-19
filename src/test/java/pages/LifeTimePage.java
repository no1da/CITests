package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс LifeTimePage представляет веб-страницу, связанную с отдельным разделом приложения.
 * Он используется для взаимодействия с элементами на странице жизни и управления проверкой их состояния.
 */
public class LifeTimePage extends BasePage {
    @FindBy(css = "article#post-25580 h1.elementor-heading-title.elementor-size-default")
    private WebElement header;

    /**
     * Конструктор класса LifeTimePage.
     * Инициализирует веб-драйвер, унаследованный от класса BasePage.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public LifeTimePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Получает текст заголовка страницы.
     * Перед получением текста заголовка метод ожидает, пока элемент не станет видимым.
     *
     * @return текст заголовка страницы.
     */
    public String getTextHeader() {
        return waitAndGetText(header);
    }
}
