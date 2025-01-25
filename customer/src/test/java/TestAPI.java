import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestAPI {

    @Test
    public void testPostRequestWithApiKey() {
        // Base URI of the API
        RestAssured.baseURI = "https://reqres.in";

        // API Key for authentication
        String apiKey = "your_api_key_here";

        // Create a request body using the User POJO with Builder pattern
        User user = new User.Builder()
                .name("John Doe")
                .email("johndoe@example.com")
                .age(30)
                .build();

        // Send POST request
        Response response = given()
                .header("x-api-key", apiKey) // Set API key in the header
                .contentType(ContentType.JSON) // Set content type to JSON
                .body(user) // Attach the request body
                .when()
                .post("/api/users") // Replace with the appropriate endpoint
                .then()
                .extract()
                .response();

        // Assert status code
        Assert.assertEquals( 201,  (long) response.getStatusCode());

        System.out.println("Response: " + response.getBody().asString());

        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.getString("name");  // Assuming 'name' is returned in the response
        String age = jsonPath.getString("age");
        String email = jsonPath.getString("email");  // Assuming 'email' is returned in the response
        String id = jsonPath.getString("id");  // Assuming 'id' is present
        String createdAt = jsonPath.getString("createdAt");  // Assuming 'createdAt' is present

        // Assert specific fields in the response
        Assert.assertEquals("Expected name to match", "John Doe", name);
        Assert.assertEquals("Expected email to match", "johndoe@example.com", email);
        Assert.assertEquals("Expected Age to match", "30", age);

    }
}
