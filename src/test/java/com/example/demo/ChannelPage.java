package com.example.demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ChannelPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public ChannelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[contains(@class, 'tm-button-follow__button tm-button-follow__button_big')]")
    private WebElement btnFollow;

    @FindBy(xpath = "//*[contains(@class, 'tm-button-follow__button tm-button-follow__button_big tm-button-follow__button_is-active')]")
    private WebElement btnUnFollow;


    public void clickBtnFollow() {
        btnFollow.click(); }

    public void clickBtnUnFollow() {
        btnUnFollow.click(); }

    public String getTextFollow() {
        String textFollow = btnFollow.getText();
        return textFollow; }

    public String getTextUnFollow() {
        String textUnFollow = btnUnFollow.getText();
        return textUnFollow; }



}
