package api.rest.tests;

import models.Pet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.GeneratorData.getPet;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specification.RequestSpecification.request;
import static specification.ResponseSpecification.response;

public class PetCreatingApiTest {
    @Test
    @DisplayName("Pet creating")
    void petCreatingTest() {
        Pet newPet = getPet(8, 16, true, true, true);

        Integer resp = given(request)
                .body(newPet)
                .when()
                .post("/v2/pet")
                .then()
                .spec(response)
                .extract().path("id");

        assertThat(resp).isEqualTo(newPet.getId());
    }
}
