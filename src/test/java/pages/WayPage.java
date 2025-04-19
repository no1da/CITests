package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс WayPage представляет веб-страницу с элементами, которые можно найти и с которыми можно взаимодействовать.
 * Он использует Selenium WebDriver для управления браузером и выполнения операций с элементами на странице.
 */
public class WayPage extends BasePage {
    @FindBy(css = "#ast-desktop-header")
    private WebElement header;
    @FindBy(css = ".ast-primary-header-bar > .site-primary-header-wrap")
    private WebElement navigationBlock;
    @FindBy(css = "a.elementor-button.elementor-slide-button[href=\"https://www.way2automation.com/lifetime-membership-club/\"]")
    private WebElement buttonRegistration;
    @FindBy(css = "section.elementor-section.nitro-offscreen[data-settings*='\"shape_divider_bottom\":\"waves\"']")
    private WebElement listCourses;
    @FindBy(css = "div[data-elementor-type=\"footer\"]")
    private WebElement footer;

    /**
     * Конструктор класса WayPage.
     * Инициализирует веб-драйвер, унаследованный от класса BasePage.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public WayPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Находит заголовок страницы и проверяет его видимость.
     *
     * @return true, если заголовок видимый; иначе false.
     */
    public boolean findHeader() {
        return waitAndIsDisplayed(header);
    }

    /**
     * Находит навигационный блок и проверяет его видимость.
     *
     * @return true, если навигационный блок видимый; иначе false.
     */
    public boolean findNavigationBlock() {
        return waitAndIsDisplayed(navigationBlock);
    }

    /**
     * Находит кнопку регистрации и проверяет ее видимость.
     *
     * @return true, если кнопка регистрации видимая; иначе false.
     */
    public boolean findButtonRegistration() {
        return waitAndIsDisplayed(buttonRegistration);
    }

    /**
     * Находит список курсов и проверяет его видимость.
     *
     * @return true, если список курсов видимый; иначе false.
     */
    public boolean findListCourses() {
        return waitAndIsDisplayed(listCourses);
    }

    /**
     * Находит футер страницы и проверяет его видимость.
     *
     * @return true, если футер видимый; иначе false.
     */
    public boolean findFooter() {
        return waitAndIsDisplayed(footer);
    }
}