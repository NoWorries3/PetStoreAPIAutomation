package api.endpoints;

// Swagger URI 			--> https://petstore.swagger.io
// Create User(Post) 	--> https://petstore.swagger.io/v2/user
// Get User(Get) 		--> https://petstore.swagger.io/v2/user/{username}
// Update User(Put) 	--> https://petstore.swagger.io/v2/user/{username}
// Delete User(Delete) 	--> https://petstore.swagger.io/v2/user/{username}

// Routes.java is created to store the URLs

public class Routes {
	
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	// User Module
	
	public static String postUrl 	= baseUrl + "/user";
	public static String getUrl 	= baseUrl + "/user/{username}";
	public static String putUrl 	= baseUrl + "/user/{username}";
	public static String deleteUrl 	= baseUrl + "/user/{username}";
	
	// Store Module
	
	// Pet Module
}
