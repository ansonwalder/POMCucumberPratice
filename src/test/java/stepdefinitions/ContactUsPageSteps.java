package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.ContactUsPage;
import com.util.ElementUtil;
import com.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps {

	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());

	@Given("User navigates to Contact us page")
	public void user_navigates_to_contact_us_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
	}

	@When("User fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData("./src/test/resources/ExcelWorkbooks/ContactUsData.xlsx",
				sheetName);
		String subjectHeading = testData.get(rowNumber).get("SubjectHeading");
		String email = testData.get(rowNumber).get("Email");
		String orderReference = testData.get(rowNumber).get("OrderReference");
		String message = testData.get(rowNumber).get("Message");
		contactUsPage.fillContactUsForm(subjectHeading, email, orderReference, message);
	}

	@When("User clicks on send button")
	public void user_clicks_on_send_button() {
		contactUsPage.clickSend();
	}

	@Then("System shows successful message as {string}")
	public void system_shows_successful_message_as(String expectedSuccessMessage) {
		String actualSuccessMessage = contactUsPage.getSuccessMessg();
		Assert.assertEquals(expectedSuccessMessage, actualSuccessMessage);
		ElementUtil.sleep(3);
	}
}
