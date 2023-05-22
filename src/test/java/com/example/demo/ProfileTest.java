package com.example.demo;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class ProfileTest {
    public static LoginPage loginPage;

    public static MainPage mainPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    private static WebDriverWait wait;


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
        //нажать на кнопку пользователь
        mainPage.clickBtnUser();
        //нажать на настройки
        mainPage.clickSettings();
        //вводим информацию о себе
        profilePage.inputLogin(ConfProperties.getProperty("speciality"));
        //нажимаем на кнопку сохранить
        profilePage.clickBtnSave();
        String textSpeciality = profilePage.getTextSpeciality();
        //сравниваем текст поля информации о себе с тем что в конфиге
        Assert.assertEquals(ConfProperties.getProperty("numspeciality"),textSpeciality);

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    } }