package api.automation.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class ApiAutomation {
	
	static Properties prop = new Properties();
	@Test
	public void Scenario_1 () throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("resources\\Resource\\file.properties");
		prop.load(fis);
		RestAssured.baseURI = prop.getProperty("BASE");
		Response res=given().
			       when().
			       get("/api/v1/employees").
			       then().assertThat().statusCode(200).and().log().all().extract().response();
		String key="data";
		List<Object> list=res.jsonPath().getList(key);
	
		for (int i=0;i<list.size();i++)
		{	
			HashMap<String,Object> list2=(HashMap<String, Object>) list.get(i);
			String image=(String) list2.get("profile_image");
			assert(image.isEmpty());
		}
	}
	@Test
	public void Scenario_2() throws IOException
	{
		FileInputStream fis = new FileInputStream("resources\\Resource\\file.properties");
		prop.load(fis);
		
		ArrayList mapData=ExcelDrivenAPI.excelData("API", "Employee","Record");
		
		RestAssured.baseURI = prop.getProperty("BASE");
		Response res2=given().pathParam("ID",mapData.get(1)).
			       when().
			       get("/api/v1/employee/{ID}").
			       then().assertThat().statusCode(200).and().assertThat().contentType(ContentType.JSON).and().assertThat().
			       body("message",equalTo("Successfully! Record has been fetched.")).and().log().all().extract().response();
		
	}

}
