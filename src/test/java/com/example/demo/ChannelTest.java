package com.example.demo;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChannelTest {
    public static LoginPage loginPage;

    public static MainPage mainPage;
    public static ProfilePage profilePage;
    public static ChannelPage channelPage;
    public static WebDriver driver;


    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        profilePage = new ProfilePage(driver);
        channelPage = new ChannelPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage")); }
    /**
     * тестовый метод для осуществления аутентификации
     */
    @Test
    public void loginTest() {

        //нажать на кнопку меню
        mainPage.clickBtnMenu();
        //нажать на кнопку войти
        mainPage.clickBtnAutorize();
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //нажимаем кнопку входа
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //нажать на канал RUVDS
        mainPage.clickBtnChannel();
        //нажать на кнопку подписаться
        channelPage.clickBtnFollow();
        //проверка состояния после подписки
        String textFollower = channelPage.getTextUnFollow();
        Assert.assertEquals("Подписан",textFollower);
        //нажать на кнопку отписаться
        channelPage.clickBtnUnFollow();
        //проверка состояния после отподписки
        String textNoFollower = channelPage.getTextFollow();
        Assert.assertEquals("Подписаться",textNoFollower);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    } }
