package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailAddress = By.id("email");
	private By password = By.id("passwd");
	private By sigInButton = By.id("SubmitLogin");
	private By forgotPasswordLink = By.linkText("Forgot your password?");

	public void enterEmailAddress(String emailId) {
		driver.findElement(emailAddress).sendKeys(emailId);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickSignIn() {
		driver.findElement(sigInButton).click();
	}

	public AccountsPage performLogin(String emailId, String pwd) {
		driver.findElement(emailAddress).sendKeys(emailId);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(sigInButton).click();
		return new AccountsPage(driver);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}

}
