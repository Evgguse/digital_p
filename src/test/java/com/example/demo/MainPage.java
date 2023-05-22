package com.example.demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора поля ввода логина
     */
    @FindBy(xpath = "//*[contains(@data-test-id, 'menu-toggle-guest')]")
    private WebElement btnMenu;

    @FindBy(xpath = "//*[contains(@data-test-id, 'menu-toggle-user')]")
    private WebElement btnUser;
    @FindBy(xpath = "//*[contains(@href, 'https://habr.com/kek/v1/auth/habrahabr/?back=/ru/all/&hl=ru')]")
    private WebElement btnAutorize;

    @FindBy(xpath = "//*[contains(@href, 'https://habr.com/kek/v1/auth/habrahabr/?back=/ru/all/&hl=ru')]")
    private WebElement findUsername;

    @FindBy(xpath = "//*[contains(@class, 'tm-user-item__username')]")
    private WebElement usname;

    @FindBy(xpath = "//*[contains(@href, '/ru/auth/settings/profile/')]")
    private WebElement btnSettings;

    @FindBy(xpath = "//*[contains(@href, '/ru/companies/ruvds/articles/')]")
    private WebElement btnChannel;


    public void clickBtnChannel() {
        btnChannel.click(); }

    public String getUserName() {
        String userName = usname.getText();
        return userName; }

    public void clickBtnMenu() {
        btnMenu.click(); }

    public void clickBtnAutorize() {
        btnAutorize.click(); }
    public void clickBtnUser() {
        btnUser.click(); }

    public void clickSettings() {
        btnSettings.click(); }

}



