package resource;

public class GetAccessToken {
	
	public static String clientId()
	{
		String clientId="692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com";
		return clientId;
	}
	public static String clientSecret()
	{
		String clientSecret="erZOWM9g3UtwNRj340YYaK_W";
		return clientSecret;
	}
	
	
	public static String redirectUri()
	{
		String redirectUri="https://rahulshettyacademy.com/getCourse.php";
		return redirectUri;
	}
	public static String contentType()
	{
		String contentType="application/json";
		return contentType;
	}
	public static String grantType()
	{
		String grantType="authorization_code";
		return grantType;
	}
	public static String postResource()
	{
		String postResource="https://www.googleapis.com/oauth2/v4/token";
		return postResource;
	}


}
