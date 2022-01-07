package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;

	@Given("User is already loggedin to application")
	public void user_is_already_loggedin_to_application(DataTable credTable) {

		List<Map<String, String>> credList = credTable.asMaps(String.class, String.class);
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.performLogin(userName, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		Assert.assertTrue(accountsPage.accountTextDisplayed());
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable dataTable) {
		List<String> expectedList = dataTable.asList(String.class);
		List<String> actualList = accountsPage.getAccountsSectionList();
		Assert.assertTrue(expectedList.containsAll(actualList));

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedCount) {
		int actualCount = accountsPage.getAccountsSectionCount();
		Assert.assertTrue(actualCount == expectedCount);

	}

}
