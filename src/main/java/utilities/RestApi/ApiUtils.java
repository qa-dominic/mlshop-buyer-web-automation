package utilities.RestApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class ApiUtils {
    public static Response sendGetRequest(String endpoint) {
        return RestAssured.get(endpoint);
    }

    public static String getResponseBody(Response response) {
        return response.getBody().asString();
    }

    public static int getStatusCode(Response response) {
        return response.getStatusCode();
    }

    public static Response sendOTPRequest(String mobileNumber, String authorization){
        // Create the main JSON object
        JSONObject requestBody = new JSONObject();
        // Create the login object
        JSONObject login = new JSONObject();
        login.put("mobileNumber", mobileNumber);
        login.put("isMlWalletRequired", true);

        // Add login object and authorization to the main JSON object
        requestBody.put("login", login);
        requestBody.put("authorization", authorization);

        // Send the POST request and return the response
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post("https://mlshoppreprod.mlhuillier.com/jewelryback/Account/SendOTP");

    }
}
