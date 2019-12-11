package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.TestBase;

public class HomePage {
    WebDriver driver;
    @FindBy(id = "container")
    WebElement calContainer;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(1)")
    WebElement btnAddition;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(2)")
    WebElement btnSubstration;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(3)")
    WebElement btnMultiplication;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(4)")
    WebElement btnDivision;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(5)")
    WebElement btnNo7;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(6)")
    WebElement btnNo8;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(7)")
    WebElement btnNo9;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(8)")
    WebElement btnNo4;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(9)")
    WebElement btnNo5;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(10)")
    WebElement btnNo6;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(11)")
    WebElement btnNo1;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(12)")
    WebElement btnNo2;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(13)")
    WebElement btnNo3;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(14)")
    WebElement btnNo0;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(15)")
    WebElement btnDecimalPoint;
    @FindBy(css = "#container > div > div.calculator__keys > button:nth-child(16)")
    WebElement btnClear;
    @FindBy(css = "#container > div > div.calculator__keys > button.key--equal")
    WebElement btnEqual;
    @FindBy(css = "#container > div > div.calculator__display")
    WebElement displayLbl;



    public HomePage(TestBase testBase) {
        this.driver = testBase.driver;
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
    }

    public boolean isCalContainerDisplayed(){
        return calContainer.isDisplayed();
    }

    public void clickBtnAddition() {
        this.btnAddition.click();
    }

    public void clickBtnSubstration() {
        this.btnSubstration.click();
    }

    public void clickBtnMultiplication() {
        this.btnMultiplication.click();
    }

    public void clickBtnDivision() {
        this.btnDivision.click();
    }

    public void clickBtnNo7() {
        this.btnNo7.click();
    }

    public void clickBtnNo8() {
        this.btnNo8.click();
    }

    public void clickBtnNo9() {
        this.btnNo9.click();
    }

    public void clickBtnNo4() {
        this.btnNo4.click();
    }

    public void clickBtnNo5() {
        this.btnNo5.click();
    }

    public void clickBtnNo6() {
        this.btnNo6.click();
    }

    public void clickBtnNo1() {
        this.btnNo1.click();
    }

    public void clickBtnNo2() {
        this.btnNo2.click();
    }

    public void clickBtnNo3() {
        this.btnNo3.click();
    }

    public void clickBtnNo0() {
        this.btnNo0.click();
    }

    public void clickBtnDecimalPoint() {
        this.btnDecimalPoint.click();
    }

    public void clickBtnClear() {
        this.btnClear.click();
    }

    public void clickBtnEqual() {
        this.btnEqual.click();
    }

    public String getDisplayLblTxt() {
        return displayLbl.getText();
    }
}
