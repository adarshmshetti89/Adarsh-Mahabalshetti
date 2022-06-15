package io.swagget.pet.resources;



import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swageer.pet.Abstracts.Pet;

import static io.restassured.RestAssured.*;
public class PetResource {


	    public Response getPetByStatus(String queryParam)
	    {
	        return given()
	                .queryParam("status",queryParam)
	                .when()
	                .get("/findByStatus");
	    }

	    public Response  petCreation(Pet pet)
	    {

	        return given()
	                .when()
	                .contentType(ContentType.JSON)
	                .when()
	                .body(pet)
	                .post();
	    }

	    public Response petById(String queryParam)
	    {
	        return given()
	                .when()
	                .get(queryParam);
	    }

	    public Response updateGivenPet(Pet pet)
	    {
	        return given()
	                .when()
	                .contentType(ContentType.JSON)
	                .when()
	                .body(pet)
	                .put();
	    }
	    public Response updatePetWithFormData(Pet pet)
	    {
	        return given()
	                .when()
	                .contentType(ContentType.JSON)
	                .when()
	                .body(pet)
	                .post();
	    }
	    
	    public Response deletePetById(String queryParam)
	    {
	        return given()
	                .when()
	                .delete(queryParam);
	    }
	}

