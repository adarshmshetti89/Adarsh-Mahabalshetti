package io.swagger.Pet.Utilities;

import com.github.javafaker.Faker;
import io.swageer.pet.Abstracts.Pet;
import java.util.ArrayList;
import java.util.HashMap;

public class PetUtilities {

	    public static Pet pet = new Pet();
	    public static Faker fake = new Faker();

	    public Pet petDataforUpdate(int petID)
	    {
	        pet = new Pet();
	        HashMap<String, String> categoryMap = new HashMap<String, String>();
	        categoryMap.put("id", "1");
	        categoryMap.put("name", "Dogs");

	        ArrayList<String> photoUrlList = new ArrayList<String>();
	        photoUrlList.add("dummyPhotoURL");

	        HashMap<String, String> tag = new HashMap<String, String>();
	        tag.put("id", "0");
	        tag.put("name", "dummyTagNAme");

	        ArrayList<HashMap<String, String>> tags = new ArrayList<HashMap<String, String>>();
	        tags.add(tag);

	        pet.setId(String.valueOf(petID));
	        pet.setName("Updated" + fake.name().firstName());
	        pet.setCategory(categoryMap);
	        pet.setPhotoUrls(photoUrlList);
	        pet.setTags(tags);
	        pet.setStatus("available");

	        return pet;
	    }
	    public Pet petCreationData()
	    {
	        HashMap<String,String> categoryMap = new HashMap<String, String>();
	        categoryMap.put("id","1");
	        categoryMap.put("name","Dogs");

	        ArrayList<String> photoUrlList = new ArrayList<String>();
	        photoUrlList.add("dummyPhotoURL");

	        HashMap<String,String> tag = new HashMap<String, String>();
	        tag.put("id","0");
	        tag.put("name","dummyTagNAme");

	        ArrayList<HashMap<String,String>> tags = new ArrayList<HashMap<String,String>>();
	        tags.add(tag);

	        pet.setId(fake.number().digit());
	        pet.setName(fake.name().firstName());
	        pet.setCategory(categoryMap);
	        pet.setPhotoUrls(photoUrlList);
	        pet.setTags(tags);
	        pet.setStatus("available");

	        return pet;
	    }
	    public Pet existingPetUpdateData(int petID)
	    {
	        pet = new Pet();
	        HashMap<String,String> categoryMap = new HashMap<String, String>();
	        categoryMap.put("id","1");
	        categoryMap.put("name","Dogs");

	        ArrayList<String> photoUrlList = new ArrayList<String>();
	        photoUrlList.add("dummyPhotoURL");

	        HashMap<String,String> tag = new HashMap<String, String>();
	        tag.put("id","0");
	        tag.put("name","dummyTagNAme");

	        ArrayList<HashMap<String,String>> tags = new ArrayList<HashMap<String,String>>();
	        tags.add(tag);

	        pet.setId(String.valueOf(petID));
	        pet.setName(fake.name().firstName()+"Updated");
	        pet.setCategory(categoryMap);
	        pet.setPhotoUrls(photoUrlList);
	        pet.setTags(tags);
	        pet.setStatus("available");
	        return pet;
	    }
	}
