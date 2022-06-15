package io.swagger.Pet.Utilities;


import io.swageer.pet.Abstracts.User;
import com.github.javafaker.Faker;

public class UserUtilities 
{
	    public static User user = new User();
	    public static Faker fake = new Faker();

	    public User DataForUSerCreation()
	    {
	        user.setId(fake.number().randomDigitNotZero());
	        user.setUsername(fake.name().username());
	        user.setFirstName(fake.name().firstName());
	        user.setLastName(fake.name().lastName());
	        user.setEmail(fake.internet().emailAddress());
	        user.setPassword(fake.internet().password());
	        user.setPhone(fake.phoneNumber().phoneNumber());
	        user.setUserStatus("1");
	        return user;
	    }
}