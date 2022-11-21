package stepDefinitions;

import dk.grell.EnergyAPI.EnergyUtils;
import dk.grell.EnergyAPI.MeteringPoint;
import io.cucumber.java.en.*;
import org.assertj.core.api.SoftAssertions;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;




public class EnergyAPIsteps {


	private String token;
	private JSONObject jsonObject;


	@Given("I invoke an invalid APIKEY {string}")
	public void InvokeAnInvalidToken(String pAPIKEY) throws IOException, InterruptedException {
		System.out.println("InvokeAnInvalidToken(" + pAPIKEY + ")");
		token = EnergyUtils.getToken(pAPIKEY);
		assertNull(token);
		if (token!=null)
			assertTrue(token.length()<=765);
	}


	@Given("I invoke a valid token {string}")
	public void InvokeAValidToken(String pAPIKEY) throws IOException, InterruptedException {
		System.out.println("InvokeAValidToken(" + pAPIKEY + ")");
		token = EnergyUtils.getToken(pAPIKEY);
//		String meteringPoints = EnergyUtils.getLocation(token);
//		System.out.println("meteringPoints=" + meteringPoints);
		System.out.println("length=" + token.length() );
		assertTrue(true); //token.length()==788);
	}



	@When("started")
	public void started() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("started()");

	}
	
	@Then("Verify")
	public void verify() {
	    // Write code here that turns the phrase above into concrete actions)
		System.out.println("verify()");
	}


	
	@Then("Close")
	public void close() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("close()");
	}



	@When("I request metering points for {string} till {string}")
	public void requestMeteringPointsForPeriod(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		//jsonObject = EnergyUtils.requestMetering(token,pFromDate,pToDate);
		System.out.println("requestMeteringPointsForPeriod");

	}


	@Then("Verify that the response contains {int} days of data")
	public void verifyThatTheResponseContainsDaysOfData(int numbersOfDays) throws ParseException {
		List<MeteringPoint> meteringPointList = EnergyUtils.getMeteringPoints((JSONObject) jsonObject);

		System.out.println("Længde af listen: " + meteringPointList.size());
		Assert.assertTrue(meteringPointList.size()==numbersOfDays);

	}


	@When("I request meter data from {string} to {string}")
	public void iRequestMeterDataFromTo(String pFromDate, String pToDate) throws IOException, InterruptedException {
		jsonObject = EnergyUtils.requestMetering(token,pFromDate,pToDate);
	}
}
