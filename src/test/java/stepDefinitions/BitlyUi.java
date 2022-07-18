package stepDefinitions;

import common.Controls;
import dataProvider.ConfigFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitlyUi {
    public static WebDriver driver;
    public static Controls com=null;
    JavascriptExecutor jsp=null;

    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() throws Throwable {

        System.setProperty("webdriver.chrome.driver", ConfigFileReader.getInstance().getDriverPath());
            driver = new ChromeDriver();
            com=new Controls(driver);
         jsp=(JavascriptExecutor)driver;
      //  driver.manage().timeouts().implicitlyWait(ConfigFileReader.getInstance().getImplicitlyWait(),TimeUnit.SECONDS);
        driver.navigate().to(ConfigFileReader.getInstance().getApplicationUrl());
        driver.manage().window().maximize();
    }

    @When("^User Navigate to LogIn Page$")
    public void user_Navigate_to_LogIn_Page() throws Throwable {
        com.wait(50);
        driver.findElement(By.id("login")).isEnabled();
        driver.findElement(By.id("login")).click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals("Verified the login page","https://demoqa.com/login",driver.getCurrentUrl());
        System.out.println("Navigate LoginPage");
    }

    @When("^User enters UserName and Password$")
    public void user_enters_UserName_and_Password() throws Throwable {
        com.wait(40);
        driver.findElement(By.id("userName")).isEnabled();
        jsp.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //js.executeScript("arguments[0].scrollIntoView();", Element);
        com.wait(20);
        driver.findElement(By.id("userName")).sendKeys("das");
        driver.findElement(By.id("password")).isEnabled();
        driver.findElement(By.id("password")).sendKeys("Dasaraju2848@#");
        driver.findElement(By.id("login")).click();
        com.wait(60);
        Assert.assertEquals("Verified the book page","ToolsQA",driver.getTitle());



    }

    @Then("^Message displayed Login Successfully$")
    public void message_displayed_Login_Successfully() throws Throwable {
        System.out.println("Login Successfully");
    }

    @When("^User LogOut from the Application$")
    public void user_LogOut_from_the_Application() throws Throwable {
        driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
    }

    @Then("^Message displayed Logout Successfully$")
    public void message_displayed_Logout_Successfully() throws Throwable {
        System.out.println("LogOut Successfully");
    }

    @And("User should be add the items {string}")
    public void userShouldBeAddTheItems(String item) throws InterruptedException {
        com.wait(20);
        WebElement element=driver.findElement(By.id("searchBox"));
        element.clear();
        jsp.executeScript("arguments[0].scrollIntoView();", element);
        element.sendKeys(item);
        driver.findElement(By.xpath("//*[contains(@id,'see-book')]/a")).click();
        com.wait(60);
        WebDriverWait wait = new WebDriverWait(driver,30);

        //item add page
        if(item.contains("'"))
        {

            jsp.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//div/div[@id='title-wrapper']//label[contains(text(),\"Don't\")]")));
            Assert.assertEquals("item not displayed",driver.findElement(By.xpath("//div/div[@id='title-wrapper']//label[contains(text(),\"Don't\")]")).getText(),item);
        }
        else {


            // presenceOfElementLocated condition
            Thread.sleep(100);
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) By.xpath("//div/div[@id='title-wrapper']//label[contains(text(),'"+item+"')]")));
            jsp.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div/div[@id='title-wrapper']//label[contains(text(),'"+item+"')]")));
            Assert.assertEquals("item not displayed",driver.findElement(By.xpath("//div/div[@id='title-wrapper']//label[contains(text(),'"+item+"')]")).getText(),item);
        }
        com.wait(20);
        WebElement element1=driver.findElement(By.xpath("//div[contains(@class,'text-right')]/button[@id='addNewRecordButton']"));
        jsp.executeScript("arguments[0].scrollIntoView();", element1);
        element1.click();
        //com.wait(800);

      //  WebElement e= (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        Thread.sleep(900);
        System.out.println("Message: "+driver.switchTo().alert().getText());
        Assert.assertEquals("verify the book added ","Book added to your collection.",driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement element2=driver.findElement(By.xpath("//div[contains(@class,'text-left')]/button[@id='addNewRecordButton']"));
        jsp.executeScript("arguments[0].scrollIntoView();", element2);
        element2.click();
        com.wait(20);
        Thread.sleep(800);
        Assert.assertEquals("Verified the book page","https://demoqa.com/books",driver.getCurrentUrl());

        //div/div[@id='title-wrapper']//label[contains(text(),'"+You+"')]
        //*[@id='title-wrapper']//label[contains(text(),'"+item+"')]
    }

    @And("User should be add the item with search part of item {string}")
    public void userShouldBeAddTheItemWithSearchPartOfItem(String item) throws InterruptedException {

        WebElement element=driver.findElement(By.id("searchBox"));
        jsp.executeScript("arguments[0].scrollIntoView();", element);
        element.clear();
        com.wait(20);
        element.sendKeys(item);
        Assert.assertEquals("Git Pocket Guide",driver.findElement(By.xpath("//*[contains(@id,'see-book')]/a")).getText());
        driver.findElement(By.xpath("//*[contains(@id,'see-book')]/a")).click();
        com.wait(60);
        //item add page
        jsp.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div/div[@id='title-wrapper']//label[contains(text(),'"+item+"')]")));
        Assert.assertEquals("item not displayed",driver.findElement(By.xpath("//div/div[@id='title-wrapper']//label[contains(text(),'Git Pocket Guide')]")).getText(),"Git Pocket Guide");
        com.wait(50);
        WebElement element1=driver.findElement(By.xpath("//div[contains(@class,'text-right')]/button[@id='addNewRecordButton']"));
        jsp.executeScript("arguments[0].scrollIntoView();", element1);
        element1.click();
        //com.wait(800);

        Thread.sleep(800);
        System.out.println("Message: "+driver.switchTo().alert().getText());
        Assert.assertEquals("verify the book added ","Book added to your collection.",driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
      /*  WebElement element2=driver.findElement(By.xpath("//div[contains(@class,'text-left')]/button[@id='addNewRecordButton']"));
        jsp.executeScript("arguments[0].scrollIntoView();", element2);
        element2.click();
        com.wait(20);
        Thread.sleep(200);
        Assert.assertEquals("Verified the book page","https://demoqa.com/books",driver.getCurrentUrl());*/
    }

    @Then("Verify all books is added Login Successfully")
    public void verifyAllBooksIsAddedLoginSuccessfully() throws InterruptedException {
        com.wait(30);
        WebElement element2=driver.findElement(By.xpath("//div[@class='left-pannel']//ul/li[@id='item-3']/span[text()='Profile']"));
        jsp.executeScript("arguments[0].scrollIntoView();", element2);
        element2.click();
        com.wait(40);
        Thread.sleep(200);
        Assert.assertEquals("Verified the book page","https://demoqa.com/profile",driver.getCurrentUrl());
        System.out.println("Navigate to profile page");
        List<WebElement> lst=driver.findElements(By.xpath("//div[@class='rt-table']//div[text()='Title']/parent::div/preceding-sibling::div/../../following::div[@class='rt-td']//span[@class='mr-2']"));
        ArrayList<String> arrayList=new ArrayList<>();
        List<String> lstele= Arrays.asList("You Don't Know JS","Understanding ECMAScript 6","Learning JavaScript Design Patterns","Git Pocket Guide");
        for(int i=0;i<=lst.size()-1;i++)
        {
            arrayList.add(lst.get(i).getText());
            if(arrayList.contains(lstele.get(i)))
            {
                System.out.println("Books is present"+lst.get(i).getText());
               // Serenity.recordReportData().withTitle("Books is present"+lst.get(i).getText());
            }else {
                Assert.assertEquals("books is not present",lst.get(i).getText());
            }
            //Serenity.recordReportData().withTitle("all Books is present");

        }

        

    }
}
