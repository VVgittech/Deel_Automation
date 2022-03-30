import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author Vaishnavi
 */

public class deelMain {

    @Test

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/vaishnavivenkatesh/Documents/chromedriver/");

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.deel.training/login**");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       //Login through the user, created manually - Individual client
       WebElement login = driver.findElement(By.id("mui-1"));
       login.sendKeys("companytest@yahoo.co.in");
       WebElement password = driver.findElement(By.id("mui-2"));
       password.sendKeys("Companytest@@1234");
       WebElement loginbutton = driver.findElement(By.cssSelector("#root > div.MuiGrid-root.css-rfnosa > div.MuiGrid-root.login-container-box-shadow.login-form.css-16ypnmh > div.MuiGrid-root.MuiGrid-container.MuiGrid-item.css-lptq43 > div > div > form > div.MuiGrid-root.css-o48jmu > button"));
       loginbutton.click();


        /*
        WebElement allowcookies = driver.findElement(By.cssSelector("#CybotCookiebotDialogBodyButtonAccept"));
        allowcookies.click();

        WebElement dismisspopup = driver.findElement(By.cssSelector("body > div.fade.popup.whats-new-popup.modal.show > div > div > div > div.whats-new-slides > button"));
        dismisspopup.click();

         */



       //Creating a fixed rate contract

        WebElement createcontract = driver.findElement(By.cssSelector("#root > div:nth-child(2) > div.mobile-sidebar-container > div.mobile-sidebar-inner > div > nav > div > div.sidebar-inner-div > ul > div:nth-child(2) > a > li > div.flex.align-items-center.w-100 > p"));
        createcontract.click();
        WebElement fixedrate = driver.findElement(By.cssSelector("#root > div:nth-child(2) > div:nth-child(4) > div > div.row > div:nth-child(1) > a > div > div > div.deel-ui__stack.deel-ui__stack_vertical.deel-ui__stack_with-spacing > div > h4"));
        fixedrate.click();

        //Entering Contractor's mandatory basic details(Name, Job title, Seniority level and scope of work)

        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("Name1");

        Select jobtitle = new Select(driver.findElement(By.name("jobTitle")));
        jobtitle.selectByVisibleText("Academic Advisor");

        Select dropseniority = new Select(driver.findElement(By.cssSelector("#root > div:nth-child(2) > div:nth-child(4) > div > form > div.box.mb-10.undefined > div > div:nth-child(4) > div > div > div > div")));
        dropseniority.selectByVisibleText("Senior (Individual Contributor Level 3)");

        WebElement scopeofwork = driver.findElement(By.name("scope"));
        scopeofwork.sendKeys("Test test");

        //Select Contractor's tax residence Country and State

        Select dropcountry = new Select(driver.findElement(By.cssSelector("#root > div:nth-child(2) > div:nth-child(4) > div > form > div.box.mb-10.undefined > div > div.deel-ui__stack.deel-ui__stack_vertical.deel-ui__stack_with-spacing > div.input-container > div > div > div")));
        dropcountry.selectByVisibleText("United States");

        Select dropstate = new Select(driver.findElement(By.cssSelector("#root > div:nth-child(2) > div:nth-child(4) > div > form > div.box.mb-10.undefined > div > div.deel-ui__stack.deel-ui__stack_vertical.deel-ui__stack_with-spacing > div.deel-ui__select.css-2b097c-container > div > div")));
        dropstate.selectByVisibleText("Colorado");


        //Select Contractor's start date

        Instant now = Instant.now();
        Instant yesterday = now.minus(1, ChronoUnit.DAYS);

        WebElement dropcalendar = driver.findElement(By.cssSelector("#root > div:nth-child(2) > div:nth-child(4) > div > form > div.box.mb-10.undefined > div > div.deel-ui__calendar-input-container__input > div > div > div.deel-ui__calendar-input-container__input_dropdown-icon"));
        dropcalendar.click();

        /*Select previousdate = new Select(driver.findElement(yesterday));
        previousdate.selectByValue();

         */

        //Select currency
        Select setCurrency = new Select(driver.findElement(By.cssSelector("#root > div:nth-child(2) > div:nth-child(4) > div > div:nth-child(3) > form > div.box.clearfix > div.deel-ui__stack.deel-ui__stack_vertical.deel-ui__stack_with-spacing > div.deel-ui__stack.deel-ui__stack_horizontal.deel-ui__stack_stretch.payment-set-controls > div > div > div")));
        setCurrency.selectByVisibleText("GBP - British Pound");


        //Input Payment rate
        WebElement rate = driver.findElement(By.cssSelector("#root > div:nth-child(2) > div:nth-child(4) > div > div:nth-child(3) > form > div.box.clearfix > div.deel-ui__stack.deel-ui__stack_vertical.deel-ui__stack_with-spacing > div.deel-ui__stack.deel-ui__stack_horizontal.deel-ui__stack_stretch.payment-set-controls > span > div > div > input"));
        rate.sendKeys("1000");

        //Set Payment frequency
        Select frequencyofpay = new Select(driver.findElement(By.cssSelector("#root > div:nth-child(2) > div:nth-child(4) > div > div:nth-child(3) > form > div.box.clearfix > div.deel-ui__stack.deel-ui__stack_vertical.deel-ui__stack_with-spacing > div:nth-child(2) > div > div > div > div")));
        frequencyofpay.selectByVisibleText("Weekly");

        //Tap on Next and create the contract
        WebElement submit = driver.findElement(By.cssSelector("#root > div:nth-child(2) > div:nth-child(4) > div > div:nth-child(3) > form > div.contract-creation-footer > button.button.mt-9.submit-payments-details.heap-create-contract-fixed-payment-details-next.w-100"));
        submit.click();

        WebElement submittocreate = driver.findElement(By.cssSelector("#root > div:nth-child(2) > div:nth-child(4) > div > div:nth-child(3) > div > div.text-left > form > div > div.contract-creation-footer > button.button.submit-define-dates.heap-create-contract-fixed-define-dates-next.w-100"));
        submittocreate.click();

        WebElement createnext = driver.findElement(By.cssSelector("#root > div:nth-child(2) > div:nth-child(4) > div > div.flex.flex-dir-col.extra-form > div:nth-child(6) > div > button.button.mt-7.submit-extras.heap-create-contract-fixed-benefits-extras-next.w-100"));
        createnext.click();

        WebElement finalcreate = driver.findElement(By.cssSelector("#root > div:nth-child(2) > div:nth-child(4) > div > div.flex.flex-dir-col.compliance-form > div:nth-child(5) > div > button.button.mt-7.submit-compliance.heap-create-contract-fixed-compliance-create.w-100"));
        finalcreate.click();




        driver.quit();


    }

    ExtentReports reports = new ExtentReports("/Users/vaishnavivenkatesh/Documents/Deel_Automation");

    ExtentTest test = reports.startTest("deelMain.java");

}
