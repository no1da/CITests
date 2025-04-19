package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Класс WayPageCourses расширяет функциональность класса BasePage,
 * предоставляя методы для взаимодействия с элементами меню курсов.
 * Этот класс включает методы для получения информации о курсах и прокрутки карусели курсов.
 */
public class WayPageCourses extends BasePage {
    @FindBy(css = "div.swiper-slide.swiper-slide-active h4.pp-info-box-title")
    private WebElement titleActiveCurse;
    @FindBy(css = "div.pp-slider-arrow>.fas.fa-angle-right")
    private WebElement leftScrollButton;
    @FindBy(css = "div.pp-slider-arrow>.fas.fa-angle-left")
    private WebElement rightScrollButton;
    @FindBy(css = ".swiper-container-wrap")
    private WebElement menuCourses;

    /**
     * Конструктор класса WayPageCourses.
     * Инициализирует веб-драйвер, унаследованный от класса BasePage.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public WayPageCourses(WebDriver driver) {
        super(driver);
    }

    /**
     * Получает заголовок активного курса на странице,
     * сначала ожидая видимости меню курсов.
     * Включает прокрутку до элемента, перемещение к элементу меню,
     * клик по кнопке закрытия и ожидает видимости заголовка активного курса.
     *
     * @return атрибут "data-swiper-slide-index" активного курса.
     */
    public String getTitleActiveCourse() {
        waiter.waitForVisibility(menuCourses);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector(".swiper-container-wrap")));
        Actions action = new Actions(driver);
        action.moveToElement(menuCourses).perform();
        return waitAndGetText(titleActiveCurse);
    }

    /**
     * Прокручивает карусель курсов влево.
     * Ожидает, что кнопка прокрутки влево станет кликабельной и затем кликает по ней.
     */
    public WayPageCourses scrollCoursesLeft() {
        return (WayPageCourses) waitAndClick(leftScrollButton);
    }

    /**
     * Прокручивает карусель курсов вправо.
     * Ожидает, что кнопка прокрутки вправо станет видимой и затем кликает по ней.
     */
    public WayPageCourses scrollCoursesRight() {
        return (WayPageCourses) waitAndClick(rightScrollButton);
    }
}
