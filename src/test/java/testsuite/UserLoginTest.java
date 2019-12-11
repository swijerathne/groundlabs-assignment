package testsuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import junit.spring.main.AppConfig;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import pages.HomePage;
import pages.LoginPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import testbase.TestBase;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class UserLoginTest {

    @Autowired
    private TestBase testBase;
    @Autowired
    private LoginPage loginPage;
    @Autowired
    Environment environment;
    int waitCounter = 0;
    @Autowired
    private HomePage homePage;
    private static ExtentTest test;
    private static ExtentReports report;


    @BeforeClass
    public static void startTest() {
        report = new ExtentReports(System.getProperty("user.dir") + "\\testreports\\RegressionTestResults.html", false);
        report.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));

    }

    @Before
    public void initializeTest() {

        getTestBase().setWebDriver();
        getTestBase().openBrowserWindow();
        getTestBase().launchApplication();

    }

    @Test
    public void testUsernameFieldWithEmptyValue() {

        //Specify the name to be displayed in the report
        test = report.startTest("Validate Username Field With Empty Value");

        //Specify the category of the test
        test.assignCategory("User Login");


        getLoginPage().setUsernameTxtBx("");
        test.log(LogStatus.PASS, "Set Empty Value As Username");
        getLoginPage().setPasswordBx("Password123");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on login Btn");

        while ((getLoginPage().waitUntilErrorUNErrorMsg()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Assert.assertEquals("Invalid Username", getLoginPage().getUsernameErrLblTxt());
        test.log(LogStatus.PASS, "Empty Value as Username is validated Successfully");
    }

    @Test
    public void testUNAndPasswordFieldWithEmptyValue() {

        //Specify the name to be displayed in the report
        test = report.startTest("Validate Username And Password Fields With Empty Values");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("");
        test.log(LogStatus.PASS, "Set an empty value as username");
        getLoginPage().setPasswordBx("");
        test.log(LogStatus.PASS, "Set an empty value as password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on login Btn");

        while ((getLoginPage().waitUntilErrorPWErrorMsg()) && (getLoginPage().waitUntilErrorUNErrorMsg()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertEquals("Invalid Username", getLoginPage().getUsernameErrLblTxt());
        test.log(LogStatus.PASS, "Empty values as Username and Password Fields Validated Successfully");
    }

    @Test
    public void testLessThanMinimumLengthValidationForUsernameField() {

        //Specify the name to be displayed in the report
        test = report.startTest("Validate Username Less Than Minimum Character Length");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sand");
        test.log(LogStatus.PASS, "Set Username less than 5 characters");
        getLoginPage().setPasswordBx("Password");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on login Btn");

        while ((getLoginPage().waitUntilErrorUNErrorMsg()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertEquals("Invalid Username", getLoginPage().getUsernameErrLblTxt());
        test.log(LogStatus.PASS, "Username Less Than Minimum Character Length Validated Successfully");

    }

    @Test
    public void testEqualMinimumLengthValidationForUsernameField() {

        //Specify the name to be displayed in the report
        test = report.startTest("Validate Username Equal To Minimum Character Length");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sandu");
        test.log(LogStatus.PASS, "Set Username Equal to 5 characters");
        getLoginPage().setPasswordBx("Password");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on login Btn");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Username  Minimum Character Length Validated Successfully");

    }

    @Test
    public void testGreaterThanMinimumLengthValidationForUsernameField() {
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Username Greater Than Minimum Character Length");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set Username Greater Than 5 characters");
        getLoginPage().setPasswordBx("Password");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on login Btn");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Username Greater Than Minimum Character Length Validated Successfully");

    }

    @Test
    public void testEqualToMaximumLengthValidationForUsernameField() {
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Username Equal To Maximum Character Length");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("SandunikaThathsarani");
        test.log(LogStatus.PASS, "Set Username Equal to 20 characters");
        getLoginPage().setPasswordBx("Password");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on login Btn");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Username Equal To Maximum Character Length Validated Successfully");

    }

    @Test
    public void testGreaterThanMaximumLengthValidationForUsernameField() {
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Username Greater Than Maximum Character Length");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("SandunikaThathsaraniW");
        test.log(LogStatus.PASS, "Set Username Greater Than 20 characters");

        while ((waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertEquals(20, getLoginPage().getMaxLengthOfUNTxtBx());
        Assert.assertEquals(getLoginPage().getMaxLengthOfUNTxtBx(), getLoginPage().getUNTxtBxCharacterCount());
        test.log(LogStatus.PASS, "Username Maximum Character Length Validated Successfully");

    }

    @Test
    public void testSpecialCharacterValidationForUsernameField() {

        //Specify the name to be displayed in the report
        test = report.startTest("Validate Special Characters As Username");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sandunika@#");
        test.log(LogStatus.PASS, "Set Username With Special characters");
        getLoginPage().setPasswordBx("Password123");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().waitUntilErrorUNErrorMsg()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Assert.assertEquals("Invalid Username", getLoginPage().getUsernameErrLblTxt());
        test.log(LogStatus.PASS, "Username With Special Characters is Validated Successfully");

    }

    @Test
    public void testPasswordFieldWithEmptyValue() {

        //Specify the name to be displayed in the report
        test = report.startTest("Validate Empty Value as Password");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set Username ");
        getLoginPage().setPasswordBx("");
        test.log(LogStatus.PASS, "Set Empty Value as Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().waitUntilErrorPWErrorMsg()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Assert.assertEquals("Invalid Password", getLoginPage().getPasswordErrLblTxt());
        test.log(LogStatus.PASS, "Empty Value As Password Validated Successfully");
    }

    @Test
    public void testLessThanMinimumLengthValidationForPasswordField() {
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Password Less Than Minimum Character Length");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set Username");
        getLoginPage().setPasswordBx("Pass1");
        test.log(LogStatus.PASS, "Set Password Less Than 6 Characters");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().waitUntilErrorPWErrorMsg()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Assert.assertEquals("Invalid Password", getLoginPage().getPasswordErrLblTxt());
        test.log(LogStatus.PASS, "Password Less Than Minimum Character Length Validated Successfully");

    }

    @Test
    public void testEqualToMinimumLengthValidationForPasswordField() {

        //Specify the name to be displayed in the report
        test = report.startTest("Validate Password Equal To Minimum Character Length");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set Username");
        getLoginPage().setPasswordBx("Pass12");
        test.log(LogStatus.PASS, "Set Password Equal To 6 Characters");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Password Equal To Minimum Character Length Validated Successfully");

    }

    @Test
    public void testGreaterThanMinimumLengthValidationForPasswordField() {
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Password Greater Minimum Character Length");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set Username");
        getLoginPage().setPasswordBx("Password123");
        test.log(LogStatus.PASS, "Set Password Greater Than 6 Characters");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Password Greater Than Minimum Character Length Validated Successfully");

    }

    @Test
    public void testEqualToMaximumLengthValidationForPasswordField() {
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Password Equal To Maximum Character Length");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set Username");
        getLoginPage().setPasswordBx("MyPassword1234567890");
        test.log(LogStatus.PASS, "Set PasswordEqual To 20 Characters");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Password Equal To Maximum Character Length Validated Successfully");

    }

    @Test
    public void testGreaterThanMaximumLengthValidationForPasswordField() {

        //Specify the name to be displayed in the report
        test = report.startTest("Validate Password Greater Than Maximum Character Length");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set Username");
        getLoginPage().setPasswordBx("MyPassword12345678901");
        test.log(LogStatus.PASS, "Set Password Greater Than 20 Characters");

        while ((waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertEquals(20, getLoginPage().getMaxLengthOfPwdBx());
        Assert.assertEquals(getLoginPage().getMaxLengthOfPwdBx(), getLoginPage().getPWTxtBxCharacterCount());
        test.log(LogStatus.PASS, "Password Greater Than Maximum Character Length Validated Successfully");

    }

    @Test
    public void testLettersOnlyValidationForPasswordField() {

        //Specify the name to be displayed in the report
        test = report.startTest("Validate Only Letters As Password Field");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set Username");
        getLoginPage().setPasswordBx("Password");
        test.log(LogStatus.PASS, "Set Only Letters As Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().waitUntilErrorPWErrorMsg()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Assert.assertEquals("Invalid Password", getLoginPage().getPasswordErrLblTxt());
        test.log(LogStatus.PASS, "Only letters as Password validated Successfully");

    }

    @Test
    public void testNumbersOnlyValidationForPasswordField() {

        //Specify the name to be displayed in the report
        test = report.startTest("Validate Only Numbers As Password Field");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set Username");
        getLoginPage().setPasswordBx("123456");
        test.log(LogStatus.PASS, "Set Only Numbers As Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().waitUntilErrorPWErrorMsg()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Assert.assertEquals("Invalid Password", getLoginPage().getPasswordErrLblTxt());
        test.log(LogStatus.PASS, "Only Numbers as Password validated Successfully");

    }

    @Test
    public void testSpecialCharacterValidationForPasswordField() {
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Password WIth Special Characters");

        //Specify the category of the test
        test.assignCategory("User Login");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set Username");
        getLoginPage().setPasswordBx("Password123@#$");
        test.log(LogStatus.PASS, "SetPassword WIth Special Characters");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().waitUntilErrorPWErrorMsg()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter = waitCounter + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        Assert.assertEquals("Invalid Password", getLoginPage().getPasswordErrLblTxt());
        test.log(LogStatus.PASS, "Password With Special Characters validated Successfully");

    }


    public TestBase getTestBase() {
        return testBase;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    @Rule
    public TestRule testWatcher = new TestWatcher() {
        @Override
        public void failed(Throwable e, Description description) {

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String screenShotName = description.getMethodName() + timeStamp + ".jpeg";
            String screenShotLocationToCopy = System.getProperty("user.dir") + "\\testreports\\ErrorScreenshots\\" + screenShotName;
            String screenShotLocationToReport = "ErrorScreenshots\\" + screenShotName;

            Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(getTestBase().driver);

            try {
                ImageIO.write(fpScreenshot.getImage(), "JPEG", new File(screenShotLocationToCopy));
                test.log(LogStatus.FAIL, e);
                test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(screenShotLocationToReport));

            } catch (IOException e1) {
                e1.printStackTrace();

            } finally {
                report.endTest(test);
                report.flush();
                getTestBase().driver.quit();
            }
        }

        @Override
        protected void succeeded(Description description) {
            report.endTest(test);
            report.flush();
            getTestBase().driver.quit();
        }
    };

    @After
    public void tearDown() {

    }

    @AfterClass
    public static void endTest() {

    }


}
