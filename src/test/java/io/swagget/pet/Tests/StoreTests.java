package io.swagget.pet.Tests;


import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.swagger.Pet.Utilities.StoreUtilities;
import io.swagget.pet.resources.StoreResource;
import org.testng.annotations.Test;

public class StoreTests extends TestBase {



	    public static StoreResource storeRequests = new StoreResource();
	    public static StoreUtilities storeDataCreator = new StoreUtilities();
	    public static int createdOrderID;
	    public static String createdOrderIDString;

	    StoreTests() { 
	    	super.TestBase("/store"); 
	    	}

	    @Feature("Stores endpoint")
	    @Story("Fetching all orders from inventory by given status")
	    @Test
	    public void getInventoryStatus()
	    {
	        response= storeRequests.inventoryStatus();
	        response.prettyPrint();

	        validatableResponse=
	                response
	                .then()
	                .statusCode(200);
	    }

	    @Feature("Stores endpoint")
	    @Test(priority=1,description="Place a new order")
	    
	    public void placeAnOrder()
	    {
	        super.TestBase("/store/order");

	        response= storeRequests.newOrder(storeDataCreator.NewOrderData());
	        response.prettyPrint();

	        validatableResponse =
	                response
	                .then()
	                .statusCode(200);

	        String responseString = response.asString();

	        createdOrderID = JsonPath.read(responseString,"$.id");
	        createdOrderIDString = "/"+ String.valueOf(createdOrderID);
	    }

	    @Feature("Stores endpoint")
	    @Test(priority=2,description="Fetching the order by given ID")
	    public void getOrderByID()
	    {
	        super.TestBase("/store/order");

	        Response response = storeRequests.orderById(createdOrderIDString);
	        response.prettyPrint();

	        validatableResponse=
	                response
	                .then()
	                .statusCode(200);
	    }

	    @Feature("Stores endpoint")
	    @Test(priority=3,description="Delete the order created as part of previous test")
	    public void DeleteTheCreatedOrder()
	    {
	        super.TestBase("/store/order");

	        response = storeRequests.deleteOrder(createdOrderIDString);
	        response.prettyPrint();

	        ValidatableResponse validatableResponse =
	                response
	                .then()
	                .statusCode(200);
	    }
	}

