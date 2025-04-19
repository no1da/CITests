package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Класс Config предназначен для загрузки и управления настройками приложения
 * из файла конфигурации `config.properties`. Он предоставляет методы для
 * доступа к настройкам, хранящимся в этом файле.
 */
public class Config {
    private Properties properties;
    /**
     * Конструктор класса Config.
     * Инициализирует объект Properties и загружает настройки
     * из файла конфигурации `config.properties`.
     * Если файл не найден или возникла ошибка при загрузке,
     * соответствующее сообщение будет выведено в консоль.
     */
    public Config() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Получает значение свойства по заданному ключу.
     *
     * @param key ключ свойства, значение которого необходимо получить.
     * @return значение свойства в виде строки. Если ключ не найден, возвращает null.
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
