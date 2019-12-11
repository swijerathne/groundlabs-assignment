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
public class CalculatorTest {

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
    public void testAdditonOfWholeNumbers(){

        //Specify the name to be displayed in the report
        test = report.startTest("Validate Addition of Two Whole Numbers");

        //Specify the category of the test
        test.assignCategory("Calculator");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set  Username");
        getLoginPage().setPasswordBx("Password123");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter=waitCounter+1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Log on To Calculator Page Successfully");

        getHomePage().clickBtnNo1();
        getHomePage().clickBtnNo0();
        getHomePage().clickBtnAddition();
        getHomePage().clickBtnNo3();
        getHomePage().clickBtnNo5();
        getHomePage().clickBtnEqual();
        test.log(LogStatus.PASS, "Conduct Whole Numbers Addition");

        String finalValue=getHomePage().getDisplayLblTxt();

        Assert.assertEquals(45,Integer.parseInt(finalValue));
        test.log(LogStatus.PASS, "Final Value Validated Successfully");
    }

    @Test
    public void testSubstractionOfWholeNumbers(){
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Substraction Between Two Whole Numbers");

        //Specify the category of the test
        test.assignCategory("Calculator");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set  Username");
        getLoginPage().setPasswordBx("Password123");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter=waitCounter+1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Log on To Calculator Page Successfully");

        getHomePage().clickBtnNo4();
        getHomePage().clickBtnNo0();
        getHomePage().clickBtnSubstration();
        getHomePage().clickBtnNo3();
        getHomePage().clickBtnNo5();
        getHomePage().clickBtnEqual();
        test.log(LogStatus.PASS, "Conduct Substraction Between Two Whole Numbers");

        String finalValue=getHomePage().getDisplayLblTxt();

        Assert.assertEquals(5,Integer.parseInt(finalValue));
        test.log(LogStatus.PASS, "Final Value Validated Successfully");
    }

    @Test
    public void testMultiplicationOfWholeNumbers(){
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Multiplication Between Two Whole Numbers");

        //Specify the category of the test
        test.assignCategory("Calculator");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set  Username");
        getLoginPage().setPasswordBx("Password123");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter=waitCounter+1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Log on To Calculator Page Successfully");

        getHomePage().clickBtnNo4();
        getHomePage().clickBtnNo0();
        getHomePage().clickBtnMultiplication();
        getHomePage().clickBtnNo3();
        getHomePage().clickBtnNo5();
        getHomePage().clickBtnEqual();
        test.log(LogStatus.PASS, "Conduct Multiplication Between Two Whole Numbers");

        String finalValue=getHomePage().getDisplayLblTxt();

        Assert.assertEquals(1400,Integer.parseInt(finalValue));
        test.log(LogStatus.PASS, "Final Value Validated Successfully");
    }

    @Test
    public void testDivisionOfWholeNumbers(){
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Division Between Two Whole Numbers");

        //Specify the category of the test
        test.assignCategory("Calculator");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set  Username");
        getLoginPage().setPasswordBx("Password123");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter=waitCounter+1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Log on To Calculator Page Successfully");

        getHomePage().clickBtnNo4();
        getHomePage().clickBtnNo0();
        getHomePage().clickBtnNo0();
        getHomePage().clickBtnDivision();
        getHomePage().clickBtnNo1();
        getHomePage().clickBtnNo0();
        getHomePage().clickBtnEqual();
        test.log(LogStatus.PASS, "Conduct Division Between Two Whole Numbers");

        String finalValue=getHomePage().getDisplayLblTxt();

        Assert.assertEquals(40,Integer.parseInt(finalValue));
        test.log(LogStatus.PASS, "Final Value Validated Successfully");
    }

    @Test
    public void testAdditonOfNumbersWithDecimalPoints(){

        //Specify the name to be displayed in the report
        test = report.startTest("Validate Addition of Two Whole Numbers");

        //Specify the category of the test
        test.assignCategory("Calculator");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set  Username");
        getLoginPage().setPasswordBx("Password123");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter=waitCounter+1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Log on To Calculator Page Successfully");

        getHomePage().clickBtnNo1();
        getHomePage().clickBtnNo0();
        getHomePage().clickBtnDecimalPoint();
        getHomePage().clickBtnNo5();
        getHomePage().clickBtnAddition();
        getHomePage().clickBtnNo3();
        getHomePage().clickBtnNo5();
        getHomePage().clickBtnDecimalPoint();
        getHomePage().clickBtnNo6();
        getHomePage().clickBtnEqual();
        test.log(LogStatus.PASS, "Conduct Addition Between Numbers With Decimal Points ");

        String finalValue=getHomePage().getDisplayLblTxt();

        Assert.assertEquals(46.1,Double.parseDouble(finalValue),0.0);
        test.log(LogStatus.PASS, "Final Value Validated Successfully");
    }

    @Test
    public void testSubstractionOfNumbersWithDecimalPoints(){
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Substraction Between Two Numbers With Decimal Points");

        //Specify the category of the test
        test.assignCategory("Calculator");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set  Username");
        getLoginPage().setPasswordBx("Password123");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter=waitCounter+1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Log on To Calculator Page Successfully");

        getHomePage().clickBtnNo4();
        getHomePage().clickBtnNo0();
        getHomePage().clickBtnDecimalPoint();
        getHomePage().clickBtnNo5();
        getHomePage().clickBtnSubstration();
        getHomePage().clickBtnNo3();
        getHomePage().clickBtnNo5();
        getHomePage().clickBtnDecimalPoint();
        getHomePage().clickBtnNo6();
        getHomePage().clickBtnEqual();
        test.log(LogStatus.PASS, "Conduct Substraction Between Numbers With Decimal Points");

        String finalValue=getHomePage().getDisplayLblTxt();

        Assert.assertEquals(4.9,Double.parseDouble(finalValue),0.0);
        test.log(LogStatus.PASS, "Final Value Validated Successfully");
    }

    @Test
    public void testMultiplicationOfNumbersWithDecimalPoints(){
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Multiplication Between Two Numbers With Decimal Points");

        //Specify the category of the test
        test.assignCategory("Calculator");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set  Username");
        getLoginPage().setPasswordBx("Password123");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter=waitCounter+1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Log on To Calculator Page Successfully");

        getHomePage().clickBtnNo4();
        getHomePage().clickBtnNo0();
        getHomePage().clickBtnDecimalPoint();
        getHomePage().clickBtnNo5();
        getHomePage().clickBtnMultiplication();
        getHomePage().clickBtnNo3();
        getHomePage().clickBtnNo5();
        getHomePage().clickBtnDecimalPoint();
        getHomePage().clickBtnNo5();
        getHomePage().clickBtnEqual();
        test.log(LogStatus.PASS, "Conduct Multiplication Between Two Numbers With Decimal Points");

        String finalValue=getHomePage().getDisplayLblTxt();

        Assert.assertEquals(1235.25,Double.parseDouble(finalValue),0.0);
        test.log(LogStatus.PASS, "Final Value Validated Successfully");
    }

    @Test
    public void testDivisionOfNumbersWithDecimalPoints(){
        //Specify the name to be displayed in the report
        test = report.startTest("Validate Division Between Two Whole Numbers");

        //Specify the category of the test
        test.assignCategory("Calculator");

        getLoginPage().setUsernameTxtBx("Sandunika");
        test.log(LogStatus.PASS, "Set  Username");
        getLoginPage().setPasswordBx("Password123");
        test.log(LogStatus.PASS, "Set Password");
        getLoginPage().clickLoginBtn();
        test.log(LogStatus.PASS, "Click on Login Button");

        while ((getLoginPage().isLoginBtnDisplayed()) && (waitCounter < 6)) {
            try {
                Thread.sleep(1000);
                waitCounter=waitCounter+1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Assert.assertTrue(getHomePage().isCalContainerDisplayed());
        test.log(LogStatus.PASS, "Log on To Calculator Page Successfully");

        getHomePage().clickBtnNo4();
        getHomePage().clickBtnNo0();
        getHomePage().clickBtnNo0();
        getHomePage().clickBtnDivision();
        getHomePage().clickBtnNo1();
        getHomePage().clickBtnNo0();
        getHomePage().clickBtnEqual();
        test.log(LogStatus.PASS, "Conduct Division Between Two Whole Numbers");

        String finalValue=getHomePage().getDisplayLblTxt();

        Assert.assertEquals(40,Integer.parseInt(finalValue));
        test.log(LogStatus.PASS, "Final Value Validated Successfully");
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

            Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(getTestBase().driver);

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
