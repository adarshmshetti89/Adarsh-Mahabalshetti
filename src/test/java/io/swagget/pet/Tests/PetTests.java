package io.swagget.pet.Tests;


import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;
import io.qameta.allure.Feature;
import io.swageer.pet.Abstracts.Pet;
import io.swagger.Pet.Utilities.PetUtilities;
import io.swagget.pet.resources.PetResource;

public class PetTests extends TestBase 
{

	PetTests()
	{
		super.TestBase("/pet");
	}

	public static Pet pet = new Pet();
	public static PetResource petRequest = new PetResource();
	public static int createdPetID;
	public static String createdPetIDString;
	public static PetUtilities petDataCreator = new PetUtilities();

	@Test
	public void getPetsByStatus()
	{
		response = petRequest.getPetByStatus("available");
		validatableResponse =
				response
				.then()
				.statusCode(200);
	}

	
	@Test(priority=1)
	public void createPet()
	{
		response = petRequest.petCreation(petDataCreator.petCreationData());

		validatableResponse =
				response
				.then()
				.statusCode(200);

		String responseString = response.asString();

		createdPetID = JsonPath.read(responseString,"$.id");
		createdPetIDString = "/"+ String.valueOf(createdPetID);
		pet=null;
	}

	@Test(priority=2)
	public void findPetByID()
	{
		response = petRequest.petById(createdPetIDString);

		response.prettyPrint();

		validatableResponse =
				response
				.then()
				.statusCode(200);
	}

	@Feature("Pet endpoint")
	@Test(description = "Pet-update pet by given id",priority=3)
	public void updateExistingPet()
	{
		response = petRequest.updateGivenPet(petDataCreator.existingPetUpdateData(createdPetID));

		response.prettyPrint();

		validatableResponse =
				response
				.then()
				.statusCode(200);
		pet=null;
	}

	@Feature("Pet endpoint")
	@Test(description = "Update pet in store with form data")
	public void updateExistingPetWithFormData()
	{
		response = petRequest.updatePetWithFormData(petDataCreator.petDataforUpdate(createdPetID));

		validatableResponse =
				response
				.then()
				.statusCode(200);

		response.prettyPrint();
	}
	
	@Test(description = "delete pet in store ")
	public void deletePetByID()
	{
		response = petRequest.deletePetById(createdPetIDString);

		response.prettyPrint();

		validatableResponse =
				response
				.then()
				.statusCode(200);
	}
}

