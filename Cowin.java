package com.projects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cowin {

		public static WebDriver driver;
		public static JavascriptExecutor js;

		public static void browserLaunch() {

			System.setProperty("webdriver.chrome.driver", ".\\Chrome_Driver\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.get("https://www.cowin.gov.in/");

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		}

		public static void selectState() throws InterruptedException {

			js = (JavascriptExecutor) driver;

			WebElement state = driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper ng-tns-c69-352']"));
			js.executeScript("arguments[0].scrollIntoView();", state);
			js.executeScript("arguments[0].click();", state);
			WebElement tamilNadu = driver.findElement(By.xpath("//span[text()=' Tamil Nadu ']"));
			js.executeScript("arguments[0].click();", tamilNadu);
			Thread.sleep(3000);
		}

		public static void selectDistrict() throws InterruptedException {

			js = (JavascriptExecutor) driver;
			
			WebElement district = driver.findElement(By.xpath("//div[@class='mat-select-value ng-tns-c69-354']"));
			js.executeScript("arguments[0].click();", district);
			WebElement madurai = driver.findElement(By.xpath("//span[text()=' Chennai ']"));
			js.executeScript("arguments[0].click();", madurai);
			Thread.sleep(3000);
		}

		public static void search() throws InterruptedException {

			js = (JavascriptExecutor) driver;

			WebElement search = driver.findElement(By.xpath("//button[text()='Search']"));
			js.executeScript("arguments[0].click();", search);
			Thread.sleep(3000);
		}

		public static void filters() throws InterruptedException {

			WebElement age = driver.findElement(By.xpath("//label[text()='18+']"));
			js.executeScript("arguments[0].click();", age);

			WebElement dose = driver.findElement(By.xpath("//label[text()='Dose 2']"));
			js.executeScript("arguments[0].click();", dose);

			WebElement cost = driver.findElement(By.xpath("//label[text()='Paid']"));
			js.executeScript("arguments[0].click();", cost);

			WebElement vaccine = driver.findElement(By.xpath("//label[text()='Covishield']"));
			js.executeScript("arguments[0].click();", vaccine);
			Thread.sleep(3000);
		}
		
		public static void filterDetails() throws InterruptedException {

			WebElement age = driver.findElement(By.xpath("//div[@class='show-result']//ancestor::span[text()='18+']"));
			System.out.println("Age :" +age.getText());
			
			WebElement cost = driver.findElement(By.xpath("//div[@class='show-result']//ancestor::span[text()='Paid']"));
			System.out.println("Cost :" +cost.getText());
			
			WebElement dose = driver.findElement(By.xpath("//div[@class='show-result']//ancestor::span[text()='2']"));
			System.out.println("Dose :" +dose.getText());
			
			WebElement vaccine = driver.findElement(By.xpath("//div[@class='show-result']//ancestor::span[text()='COVISHIELD']"));
			System.out.println("Vaccine :" +vaccine.getText());
			Thread.sleep(3000);
		}

		public static void hospitalDetails() {

			List<WebElement> hospitalDetails = driver
					.findElements(By.xpath("//h5[@class='center-name-title accessibility-plugin-ac']"));

			for (WebElement detail : hospitalDetails) {

				System.out.println("Hospital Name :" + detail.getText());

			}
		}

		public static void hospitalAddress() {

			List<WebElement> hospitalAddress = driver
					.findElements(By.xpath("//p[@class='center-name-text accessibility-plugin-ac']"));

			for (WebElement address : hospitalAddress) {

				System.out.println("Hospital Address :" + address.getText());
			}
		}

		public static void main(String[] args) throws InterruptedException {

			browserLaunch();
			selectState();
			selectDistrict();
			search();
			filters();
			filterDetails();
			hospitalDetails();
			hospitalAddress();
		}

	}

