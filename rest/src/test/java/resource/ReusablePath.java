package resource;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusablePath {
	
	public static XmlPath rawToXMl(Response r)
	{
		String str=r.asString();
		XmlPath x=new XmlPath(str);
		
		return x;
		
	}
	
	public static JsonPath rawToJson(Response r)
	{
		String str=r.asString();
		JsonPath x=new JsonPath(str);
		
		return x;
		
	}

}
