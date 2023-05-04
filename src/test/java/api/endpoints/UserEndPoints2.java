package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// UserEndPoints.java is created to perform: 
// Create, Read, Update, Delete requests from the User API.

public class UserEndPoints2 {
	
	// Method for getting URL's from properties file
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");	// Load properties file
		return routes;
	}
	
	public static Response createUser(User payload)
	{
		String postUrl = getURL().getString("postUrl");
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(postUrl);
		
		return response;
	}
	
	public static Response readUser(String userName)
	{
		String getUrl = getURL().getString("getUrl");
		Response response = 
		given()
			.pathParam("username", userName)
		.when()
			.get(getUrl);
		
		return response;
	}
	
	public static Response updateUser(String userName, User payload)
	{
		String putUrl = getURL().getString("putUrl");
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(putUrl);
		
		return response;

	}
	
	public static Response deleteUser(String userName)
	{
		String deleteUrl = getURL().getString("deleteUrl");
		Response response = 
		given()
			.pathParam("username", userName)
		.when()
			.delete(deleteUrl);
		
		return response;
	}
	
}
