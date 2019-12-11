package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.TestBase;

public class LoginPage {

    WebDriver driver;
    @FindBy(id = "username")
    WebElement usernameTxtBx;
    @FindBy(id = "password")
    WebElement passwordBx;
    @FindBy(id = "login")
    WebElement loginBtn;
    @FindBy(id = "usernameErr")
    WebElement usernameErrLbl;
    @FindBy(id = "passwordErr")
    WebElement passwordErrLbl;

    public LoginPage(TestBase testBase) {

        this.driver = testBase.driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public void setUsernameTxtBx(String usernameTxtBxValue) {
        this.usernameTxtBx.sendKeys(usernameTxtBxValue);
    }

    public void setPasswordBx(String passwordBxTxtValue) {
        this.passwordBx.sendKeys(passwordBxTxtValue);
    }

    public void clickLoginBtn() {
        this.loginBtn.click();
    }

    public String getUsernameErrLblTxt() {
        return usernameErrLbl.getText();
    }

    public boolean waitUntilErrorUNErrorMsg(){

        return usernameErrLbl.isDisplayed();

    }

    public String getPasswordErrLblTxt() {
        return passwordErrLbl.getText();
    }

    public boolean waitUntilErrorPWErrorMsg(){

        return passwordErrLbl.isDisplayed();

    }

    public boolean isLoginBtnDisplayed(){
        return loginBtn.isDisplayed();
    }

    public int getMaxLengthOfUNTxtBx(){
        return Integer.parseInt(usernameTxtBx.getAttribute("maxlength"));
    }

    public int getUNTxtBxCharacterCount(){
        return usernameTxtBx.getAttribute("value").length();
    }

    public int getMaxLengthOfPwdBx(){
        return Integer.parseInt(passwordBx.getAttribute("maxlength"));
    }

    public int getPWTxtBxCharacterCount(){
        return passwordBx.getAttribute("value").length();
    }


}
