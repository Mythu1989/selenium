package com.projects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automation_project {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\eclipse-workspace\\Selenium_Concepts\\Chrome_Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://automationpractice.com/");
		// Sign up the account- Automation practice site

//		driver.findElement(By.xpath("(//a[@rel='nofollow'])[1]")).click();
//		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("venkatpro10@gmail.com");		
//		driver.findElement(By.id("SubmitCreate")).click();
//		driver.findElement(By.xpath("(//input[@name='id_gender'])[2]")).click();
//		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Lee");
//		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("S");
//		driver.findElement(By.id("passwd")).
//		driver.findElement(By.id("days")).sendKeys("10");
//		driver.findElement(By.id("months")).sendKeys("October");
//		
//		WebElement year = driver.findElement(By.id("years"));
//		Select S=new Select(year);
//		S.selectByValue("1982");
//		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("Lee");
//		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("S");
//		driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("Lee Tech");
//		driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("No:42,100 feet road");
//		driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("Periyar nagar");
//		driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("Chennai");
//		
//		WebElement state = driver.findElement(By.xpath("//select [@id='id_state']"));
//		state.click();
//		Select S1=new Select(state);
//		S1.selectByVisibleText("Indiana");
//		state.click();
//		
//		driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("60008");
//		driver.findElement(By.id("phone")).sendKeys("398559283");
//		driver.findElement(By.xpath("(//input[@type='text'])[13]")).sendKeys("9884644222");
//		driver.findElement(By.id("alias")).sendKeys("No:42,100 feet road");
//		driver.findElement(By.id("submitAccount")).click();

		// Account Created
		// After created account , Sign-in enter into Home page

		driver.findElement(By.xpath("(//a[@rel='nofollow'])[1]")).click();
		driver.findElement(By.id("email")).sendKeys("venkatpro10@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Lee123");
		driver.findElement(By.id("SubmitLogin")).click();

		// Fluent wait
		/*
		 * Wait<WebDriver> wait = new
		 * FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
		 * .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		 * 
		 * WebElement women = wait.until(new Function<WebDriver, WebElement>() { public
		 * WebElementapply(WebDriver driver) { return
		 * driver.findElement(By.xpath("//a[@title='Women']")); } }); women.click();
		 */

		// Explicit wait -Element to be clickable method

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement causal_Dress = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/header[1]/div[3]/div/div/div[6]/ul/li[2]/a")));
		causal_Dress.click();

		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
		driver.findElement(By.xpath("(//label[@class='layered_color'])[4]")).click();
		driver.findElement(By.xpath("//span[@itemprop='offers']")).click();
		driver.findElement(By.xpath("//a[@title='Add to cart']")).click();
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("18");
		driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		driver.findElement(By.xpath("//a[@class='bankwire']")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

		TakesScreenshot TS = (TakesScreenshot) driver;
		File source = TS.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\user\\eclipse-workspace\\Selenium_Concepts\\Screenshot\\automation.png");
		FileUtils.copyFile(source, des);

	}

}
