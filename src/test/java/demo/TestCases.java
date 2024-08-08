package demo;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.wrappers.Wrappers;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
//    private ChromeDriver driver;
   private WebDriver driver;
   private WebDriverWait wait;
   private Wrappers wrapperMethod;


//    public TestCases(WebDriver driver, WebDriverWait wait) {
//        this.driver = (ChromeDriver) driver;
//        this.wait = wait;
//        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        wrapperMethod = new Wrappers(driver);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//    }

       /*
    * TODO: Write your tests here with testng @Test annotation.
    * Follow `testCase01` `testCase02`... format or what is provided in instructions
    */


   /*
    * Do not change the provided methods unless necessary, they will help in automation and assessment
    */
   @BeforeTest
   public void startBrowser()    {
       System.setProperty("java.util.logging.config.file", "logging.properties");
    //    wrapperMethod = new Wrappers(driver);
       // NOT NEEDED FOR SELENIUM MANAGER
      
       WebDriverManager.chromedriver().timeout(30).setup();

       ChromeOptions options = new ChromeOptions();
       LoggingPreferences logs = new LoggingPreferences();
       logs.enable(LogType.BROWSER, Level.ALL);
       logs.enable(LogType.DRIVER, Level.ALL);
       options.setCapability("goog:loggingPrefs", logs);
       options.addArguments("--remote-allow-origins=*");
       System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");
       driver = new ChromeDriver(options);
       wrapperMethod = new Wrappers(driver);
       driver.manage().window().maximize();
   }

   @AfterTest
   public void endTest(){
       driver.close();
       driver.quit();
   }

        @Test
        public void testCase01(){  
            System.out.println("Starting testCase01");
            wrapperMethod.testCase01();
        }    

        @Test 
        public void TC_01_navigateToGoogleFormUrl(){
           System.out.println("Start Test case: TC_01_navigateToGoogleFormUrl");
           String url = "https://forms.gle/wjPkzeSEk1CM7KgGA";
           wrapperMethod.NavigateToForm(url);
           System.out.println("End Test case: TC_01_navigateToGoogleFormUrl");
       }
       @Test 
       public void TC_02_enterName() {
          System.out.println("Start Test case: TC_02_enterName");
           wrapperMethod.fillName("Crio Learner");
           System.out.println("End Test case: TC_02_enterName");
       }
       @Test 
       public void TC_03_myAutomation() {
           System.out.println("Start Test case: TC_03_myAutomation");
           long epochTime = Instant.now().getEpochSecond();
           wrapperMethod.fillMessage("I want to be the best QA Engineer! "+epochTime);
           System.out.println("End Test case: TC_03_myAutomation");
       }
       @Test 
       public void TC_04_howMuchAutomationExp() {
           System.out.println("Start Test case: TC_04_howMuchAutomationExp");
           wrapperMethod.selectExperience(1);
           System.out.println("End Test case: TC_04_howMuchAutomationExp");
       }
       @Test 
       public void TC_05_skillsLearnAtCrio() {
           System.out.println("Start Test case: TC_05_skillsLearnAtCrio");
           wrapperMethod.selectCourses(true, true, false, true);
           System.out.println("End Test case: TC_05_skillsLearnAtCrio");
       }
       @Test 
       public void TC_06_titleToBeAddressed() throws InterruptedException {
           System.out.println("Start Test case: TC_06_titleToBeAddressed");
           wrapperMethod.chooseToBeAddressed();
//        wrapperMethod.chooseToBeAddressed(address);  // Using the address variable
           WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increase wait time
           System.out.println("End Test case: TC_06_titleToBeAddressed");

       }
       @Test 
       public void TC_07_dateSevenDaysAgo() throws InterruptedException {
           System.out.println("Start Test case: TC_07_dateSevenDaysAgo");
           wrapperMethod.FilldateMinus7Days();
           System.out.println("End Test case: TC_07_dateSevenDaysAgo");
       }
       @Test 
       public void TC_08_currentTime24hrsFormat() {
           System.out.println("Start Test case: TC_08_currentTime24hrsFormat");
           String currentTime = "07:30";  // Provide the desired time in 24hrs format
           wrapperMethod.fillTime(currentTime);  // Using the time variable
           WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increase wait time
           System.out.println("End Test case: TC_08_currentTime24hrsFormat");
       }
       @Test 
       public void TC_09_getAmazonUrl() {
           System.out.println("Start Test case: TC_09_getAmazonUrl");
           wrapperMethod.fillName("https://www.amazon.com");
           System.out.println("End Test case: TC_09_getAmazonUrl");
       }
       @Test 
       public void TC_10_clickSubmit() {
           System.out.println("Start Test case: TC_10_clickSubmit");
           wrapperMethod.SubmitForm();
           System.out.println("End Test case: TC_10_clickSubmit");
       }
       @Test 
       public void TC_11_printSuccessMessage() throws InterruptedException {
           System.out.println("Start Test case: TC_11_printSuccessMessage");
           String message = wrapperMethod.getMessage();
           System.out.println("Success Message: " + message);
           System.out.println("End Test case: TC_11_printSuccessMessage");
       }
}