package api.automation.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import resource.GetAccessToken;
import static io.restassured.RestAssured.given;//import to use given method
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OauthImplementation extends Website {
	private static Logger log = LogManager.getLogger(Logger.class.getName());

	@Test
	public void accessCode() throws InterruptedException {

		String code = Website.getCode();
		log.debug("Calling code generation method"+code);
		
		String accessTokenResponse = given().urlEncodingEnabled(false).queryParam("code", code)
				.queryParam("client_id", GetAccessToken.clientId())
				.queryParam("client_secret", GetAccessToken.clientSecret())
				.queryParam("redirect_uri", GetAccessToken.redirectUri())
				.headers("Content-Type", GetAccessToken.contentType()).queryParam("grant_type", GetAccessToken.grantType()).log().all()
				.when().post(GetAccessToken.postResource()).asString();
		log.debug("Get accessToken request posted and resonse" + accessTokenResponse);
		JsonPath jstoken = new JsonPath(accessTokenResponse);

		String accessToken = jstoken.getString("access_token");
		log.info("accessToken: "+accessToken);

		GetCourse gc = given().urlEncodingEnabled(false).queryParam("access_token", accessToken)
				.headers("Content-Type", GetAccessToken.contentType()).expect().defaultParser(Parser.JSON).when()
				.post(GetAccessToken.redirectUri()).as(GetCourse.class);
		log.info("Posted requested to receive response");
		String[] list = { "Selenium Webdriver Java", "Cypress", "Protractor" };
		List<String> expectedlList = Arrays.asList(list);
		ArrayList<String> a = new ArrayList<String>();

		List<WebAutomation> wa = gc.getCourses().getWebAutomation();
		for (int i = 0; i < wa.size(); i++) {
			a.add(wa.get(i).getCourseTitle());
		}

		log.info("actual List is : " + a);
		log.info("Expected List is : " + expectedlList);

		log.debug(" Both are Equal assert ");
		Assert.assertTrue(expectedlList.equals(a));
	}
}
