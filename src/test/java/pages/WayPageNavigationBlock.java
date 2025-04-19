package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс WayPageNavigationBlock расширяет функциональность класса BasePage,
 * предоставляя методы для взаимодействия с навигационным блоком страницы.
 * Этот класс включает методы, которые позволяют пользователю перемещаться
 * по меню и выбирать различные курсы.
 */
public class WayPageNavigationBlock extends WayPage {
    @FindBy(xpath = "//div[contains(@class, 'ast-main-header-wrap') and contains(@class, 'main-header-bar-wrap')]" +
            "//span[@class='menu-text' and contains(text(), 'All Courses')]")
    private WebElement allCourses;
    @FindBy(css = ".ast-primary-header-bar .sub-menu a.menu-link[href=\"https://www.way2automation.com/lifetime-membership-club/\"]")
    private WebElement linkLifeTime;

    /**
     * Конструктор класса WayPageNavigationBlock.
     * Инициализирует веб-драйвер, унаследованный от класса BasePage.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public WayPageNavigationBlock(WebDriver driver) {
        super(driver);
    }

    /**
     * Метод для навигации к разделу "Пожизненный доступ".
     * Данный метод перемещается к элементу "Все курсы",
     * задерживает выполнение до его видимости,
     * затем перемещается к элементу "Пожизненный доступ" и кликает на него.
     */
    public WayPageNavigationBlock goToLifeTime() {
        waitAndMove(allCourses);
        return (WayPageNavigationBlock) waitAndClick(linkLifeTime);
    }
}
