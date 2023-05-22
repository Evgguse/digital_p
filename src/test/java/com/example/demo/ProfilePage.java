package com.example.demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProfilePage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//*[contains(@name, 'speciality')]")
    private WebElement tbSpeciality;

    @FindBy(xpath = "//*[contains(@class, 'tm-form__submit base-button')]")
    private WebElement btnSave;

    @FindBy(xpath = "//*[contains(@class, 'base-input__counter tm-input__counter base-input__counter_speciality ')]")
    private WebElement numSym;

    public void inputLogin(String speciality) {
        tbSpeciality.sendKeys(speciality); }

    public void clickBtnSave() {
        btnSave.click(); }

    public String getTextSpeciality() {

        String textAlarm = numSym.getText();
        return textAlarm; }
}