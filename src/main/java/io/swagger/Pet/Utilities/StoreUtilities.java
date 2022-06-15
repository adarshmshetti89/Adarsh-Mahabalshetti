package io.swagger.Pet.Utilities;

import com.github.javafaker.Faker;

import io.swageer.pet.Abstracts.Store;
public class StoreUtilities {

    public static Store store = new Store();
    public static Faker fake = new Faker();

    public Store NewOrderData()
    {
        store.setId(fake.number().numberBetween(12,999));
        store.setPetID(fake.idNumber().valid());
        store.setQuantity(fake.number().randomDigit());
        store.setShipDate("2022-06-01T12:00:00.111Z");
        store.setStatus("approved");
        store.setComplete(fake.bool().bool());

        return store;
    }
}
