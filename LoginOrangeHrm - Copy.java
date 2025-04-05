package com.tau.cucumber.steps;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginOrangeHrm {
	private WebDriver driver;
	private String expectedUrl="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
	private String ExpectedStr="No Records Found";
	
	@Given("I am in the login page of the Orange HRM")
	public void i_am_in_the_login_page_of_the_Orange_HRM() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); 
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("I enter valid credentials of Orange HRM")
	public void i_enter_valid_credentials_of_Orange_HRM() throws InterruptedException {
		Thread.sleep(10000);
	   driver.findElement(By.name("username")).sendKeys("Admin");
	   driver.findElement(By.name("password")).sendKeys("admin123");
	   driver.findElement(By.tagName("button")).click();
	}

	@Then("I should be taken to the Login Page of Orange HRM")
	public void i_should_be_taken_to_the_Login_Page_of_Orange_HRM() throws IOException {
		String testPass= "Test is pass";
				String ActualUrl=driver.getCurrentUrl();
				assertEquals(testPass, expectedUrl, ActualUrl);
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(scrFile, new File("screenshot1.png"));

	}
	@Given("I am in the Leave Tab section")
	public void i_am_in_the_Leave_Tab_section() {
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")).click();
	}

	@When("I click on approve button")
	public void i_click_on_approve_button() {
	   driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]")).click();
	}



}
