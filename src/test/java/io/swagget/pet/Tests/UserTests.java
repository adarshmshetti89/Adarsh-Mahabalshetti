package io.swagget.pet.Tests;


import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.swageer.pet.Abstracts.User;
import io.swagger.Pet.Utilities.UserUtilities;
import io.swagget.pet.resources.UserResource;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class UserTests extends TestBase {
	
	    User user = new User();
	    public static UserResource  userRequests=new UserResource();
	    public static UserUtilities userDataCreator=new UserUtilities();
	    public static String createdUserName;
	    public static String createdUerPassword;

	    UserTests() { super.TestBase("/user");}

	    @Feature("User endpoint")
	    @Story("Fetching details of a user by its username")
	    @Test
	    public void getUserByUsername()
	    {
	        response = userRequests.userByUsername(createdUserName);
	        response.prettyPrint();
	        validatableResponse=
	                response
	                .then()
	                .statusCode(200);
	    }

	    @Feature("User endpoint")
	    @Story("Creating a new user")
	    @Test(priority=1)
	    public void createAUser()
	    {
	       response = userRequests.userCreation(userDataCreator.DataForUSerCreation());

	       validatableResponse =
	                response
	                .then()
	                .statusCode(200);

	        String responseString = response.asString();

	        createdUserName = JsonPath.read(responseString,"$.username");
	        createdUerPassword = JsonPath.read(responseString,"$.password");
	        createdUserName = "/"+createdUserName;
	    }

	    @Feature("User endpoint")
	    @Story("Log user into the system")
	    @Test(priority=2)
	    public void LoginTheUser()
	    {
	        super.TestBase("/user/login");

	        response = userRequests.userLogin(createdUserName,createdUerPassword);


	        response.prettyPrint();
	        validatableResponse =
	                response
	                .then()
	                .statusCode(200);
	    }

	    @Feature("User endpoint")
	    @Story("Logs out current active session")
	    @Test(priority=2)
	    public void LogOutTheActiveUserSession()
	    {
	        super.TestBase("/user/logout");

	        response = userRequests.userLogout();

	        response.prettyPrint();

	        validatableResponse =
	                response
	                .then()
	                .statusCode(200);

	    }
	    
	    
	}
