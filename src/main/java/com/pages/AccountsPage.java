package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	private By accountSections = By.cssSelector("div#center_column span");
	private By myAccountText = By.xpath("//span[text()='My account']");
	

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getAccountsSectionCount() {
		return driver.findElements(accountSections).size();
	}

	public List<String> getAccountsSectionList() {
		List<String> accountList = new ArrayList<String>();
		List<WebElement> accountHeaderList = driver.findElements(accountSections);
		for (WebElement accountHeader : accountHeaderList) {
			String text = accountHeader.getText();
			accountList.add(text);
		}
		return accountList;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean accountTextDisplayed() {
		return driver.findElement(myAccountText).isDisplayed();
	}

}
