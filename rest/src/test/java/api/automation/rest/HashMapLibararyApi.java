package api.automation.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;//import to use given method


public class HashMapLibararyApi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList mapData=ExcelDriven.excelData("API", "name","RestAssured");
		HashMap<String, Object> jsonAsMap = new HashMap();
		jsonAsMap.put("name", mapData.get(0));
		jsonAsMap.put("isbn", mapData.get(1));
		jsonAsMap.put("aisle",  mapData.get(2));
		jsonAsMap.put("author",  mapData.get(3));
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String str=given().
		body(jsonAsMap).
		when().post("Library/Addbook.php").
		then().assertThat().statusCode(200).extract().asString();
		//System.out.println(str);
		JsonPath js=new JsonPath(str);
		String id=js.getString("ID");
		
		System.out.println(id);
		
		
		

	}

}
