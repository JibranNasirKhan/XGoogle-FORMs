package demo.wrappers;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Wrappers {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;
    private final JavascriptExecutor js;

    public Wrappers(WebDriver driver) {
        this.driver = driver;
        this.wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public void testCase01(){
        System.out.println("Test Case 1 - Automate filling up a form");
    }

    public void NavigateToForm(String url) {
        driver.get(url);
        System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl().equals(url)){
            System.out.println("The current URL is for google form");
        } else {
            System.out.println("The current URL is not for google form");
        }
    }

    public void fillName(String name) {

        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='whsOnd zHQkBf' and @type='text'])[1]")));
        //Ensuring element is interactable
        wait.until(ExpectedConditions.elementToBeClickable(nameElement));
        //Scroll into view
        actions.moveToElement(nameElement).perform();
         nameElement.sendKeys(name);

        System.out.println("Printing the name mentioned :"+nameElement.getAttribute("value")); 

         if (nameElement.getAttribute("value").equals(name)){
            System.out.println("Name is Entered correctly");
         } else {
            System.out.println("Name is not Entered correctly");
         }
    }

    public void fillMessage(String message) {
       WebElement messageElement = driver.findElement(By.xpath("//textarea[@class='KHxj8b tL9Q4c']"));
       wait.until(ExpectedConditions.elementToBeClickable(messageElement));
        actions.moveToElement(messageElement).perform();
        messageElement.sendKeys(message);

        if (messageElement.getAttribute("value").equals(message)){
            System.out.println("Message is Entered correctly");
         } else {
            System.out.println("Message is not Entered correctly");
         }
    }

    public void selectExperience(int optionIndex) {
       WebElement ExperienceElement = driver.findElement(By.xpath("//div[@class='nWQGrd zwllIb'][" + optionIndex + "]"));
    //    WebElement ExperienceElement = driver.findElement(By.xpath("(//div[@role='radiogroup']//div[@role='radio'])[" + optionIndex + "]"));
       wait.until(ExpectedConditions.elementToBeClickable(ExperienceElement));
       actions.moveToElement(ExperienceElement).perform();
       ExperienceElement.click();
    //    String ExperienceMessage = ExperienceElement.getAttribute("value");
       String ExperienceMessage = ExperienceElement.getAttribute("aria-checked");

       if (ExperienceMessage != null && ExperienceMessage.equals(String.valueOf(optionIndex))) {
        System.out.println("Ensuring " + optionIndex + " is clicked as Experience");
    } else {
        System.out.println("The value of the selected experience element does not match the expected index.");
    }
    
    System.out.println("Experience element " + optionIndex + " selected successfully");
}

    public void selectCourses(boolean java, boolean selenium, boolean springboot, boolean testng) {
        if (java) {
           WebElement JavachkBox = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[1]"));
           JavachkBox.click();

            System.out.println("Checked value "+JavachkBox.getAttribute("value"));
        }
        if (selenium) {
           WebElement seleniumchkBox = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[2]"));
           seleniumchkBox.click();
            System.out.println("Checked value "+seleniumchkBox.getAttribute("value"));
        }
        if (springboot) {
            WebElement springbootchkBox =  driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[3]"));
            springbootchkBox.click();
            System.out.println("Checked value "+springbootchkBox.getAttribute("value"));
        }
        if (testng) {
            WebElement testNGchkBox = driver.findElement(By.xpath("(//div[@class='uHMk6b fsHoPb'])[4]"));
            testNGchkBox.click();
            System.out.println("Checked value "+testNGchkBox.getAttribute("value"));
        }
    }

    public void chooseToBeAddressed() throws InterruptedException {

            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Choose']")));
            dropdown.click();
            String selectaddress = "Mr";
            Thread.sleep(4000);
//            WebElement SelectingMr =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Mr'])[2]")));
            WebElement SelectingMr =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Mr'])[2]")));
            SelectingMr.click();

            if(SelectingMr.getText().equals(selectaddress)){
                System.out.println("Ensuring "+selectaddress+" has been selected from drop down Menu");
            } else {
                System.out.println("Incorrect address selected");
            }
    }

    public void FilldateMinus7Days() throws InterruptedException {
        Thread.sleep(2000);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);
        String dateMinus7Days = sdf.format(calendar.getTime());
        WebElement dateInput = driver.findElement(By.xpath("(//input[@class='whsOnd zHQkBf'])[2]"));
        dateInput.sendKeys(dateMinus7Days);

        if(dateInput.getAttribute("value").equals(dateMinus7Days)){
            System.out.println("The date minus 7 days from today mentioned is :"+dateInput.getAttribute("value"));
        }
    }

    public void fillTime(String time) {
        String[] timeParts = time.split(":");
        String hours = timeParts[0];
        String minutes = timeParts[1];

        WebElement hourElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[2]")));
        hourElement.click();
        hourElement.sendKeys(hours);
        // Click to open the minute dropdown and select the minute
        WebElement minuteElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[3]")));
        minuteElement.click();
        minuteElement.sendKeys(minutes);

        if(hourElement.getAttribute("value").equals(hours) && minuteElement.getAttribute("value").equals(minutes)){
            System.out.println("The time entererd is : "+ hourElement.getAttribute("value")+ ":" + minuteElement.getAttribute("value"));
        } else {
            System.out.println("The time entered is incorrect");
        }
    }

    public void TC_09_getAmazonUrl(String fillName) {
        System.out.println("Start Test case: TC_09_getAmazonUrl");
        driver.get("https://www.amazon.com");
        System.out.println("End Test case: TC_09_getAmazonUrl");
    }

    public void SubmitForm() {
        WebElement SubmitForm = driver.findElement(By.xpath("//span[text()='Submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(SubmitForm));
        SubmitForm.click();

    }

    public String getMessage() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); 
        WebElement successMessage = driver.findElement(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']"));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        
        if(successMessage.isDisplayed()){
            String message = successMessage.getText();
            System.out.println(message);
            return message;
        } else {
            System.out.println("Success Message not displayed");
        }
        return successMessage.getText();
    }
 
}


