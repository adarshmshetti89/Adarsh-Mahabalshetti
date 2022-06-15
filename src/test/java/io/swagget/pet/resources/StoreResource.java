package io.swagget.pet.resources;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swageer.pet.Abstracts.Store;

import static io.restassured.RestAssured.*;

public class StoreResource
{
    public Response inventoryStatus()
    {
        return given()
               .when()
               .get("/inventory");
    }

    public Response newOrder(Store store)
    {
        return  given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(store)
                .post();
    }

    public Response orderById(String queryParam)
    {
        return given()
                .when()
                .get(queryParam);
    }

    public Response deleteOrder(String orderId)
    {
        return given()
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(orderId)
                .put();
    }

}
