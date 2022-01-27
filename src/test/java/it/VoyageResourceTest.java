package it;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ibm.gse.voyagems.domain.model.Voyage;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class VoyageResourceTest { 

    String basicURL = "/api/v1/voyages";
    
    @Test
    public void testVoyagesEndpoint() {
       Response rep = given()
          .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
          .when().get(basicURL)
          .then()
             .statusCode(200)
             .contentType(ContentType.JSON)
            .extract()
            .response();
            System.out.println(rep.jsonPath().prettyPrint());
            Voyage[] voyages = rep.body().as(Voyage[].class);
            Assertions.assertTrue(voyages.length >= 1);
    }
}
