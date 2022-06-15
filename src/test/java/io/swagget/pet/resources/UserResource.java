package io.swagget.pet.resources;



import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swageer.pet.Abstracts.User;

import static io.restassured.RestAssured.given;
public class UserResource {
	

	    public Response userByUsername(String queryParam)
	    {
	        return given()
	                .when()
	                .get(queryParam);
	    }

	    public Response  userCreation(User user)
	    {
	        return  given()
	                .when()
	                .contentType(ContentType.JSON)
	                .when()
	                .body(user)
	                .post();
	    }

	    public Response userLogin(String usernname,String password)
	    {
	        return  given()
	                .when()
	                .queryParam("username",usernname)
	                .queryParam("password",password)
	                .get();
	    }

	    public Response userLogout()
	    {
	        return given()
	                .when()
	                .get();
	    }
	}
