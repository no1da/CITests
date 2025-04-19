package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/**
 * Утилита ожидания, которая инкапсулирует методы для выполнения ожиданий
 * с использованием Selenium WebDriver.
 *
 * Этот класс предоставляет методы для ожидания видимости и доступности элементов перед взаимодействием с ними.
 */
public class Waiter {
    private final WebDriverWait waiter;
    /**
     * Конструктор класса Waiter.
     *
     * @param driver объект WebDriver, который будет использоваться для ожиданий.
     * @param duration время ожидания перед истечением, задается в миллисекундах.
     */
    public Waiter(WebDriver driver, Duration duration) {
        this.waiter = new WebDriverWait(driver, duration);
    }
    /**
     * Ожидает, пока указанный элемент не станет видимым на странице.
     *
     * @param element элемент, видимость которого необходимо проверить.
     */
    public void waitForVisibility(WebElement element) {
        waiter.until(ExpectedConditions.visibilityOf(element));
    }
    /**
     * Ожидает, пока указанный элемент не станет кликабельным на странице.
     *
     * @param element элемент, кликабельность которого необходимо проверить.
     */
    public void waitForClickability(WebElement element) {
        waiter.until(ExpectedConditions.elementToBeClickable(element));
    }
}
