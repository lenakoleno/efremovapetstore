package api;

import api.data.DataGenerator;
import api.models.Pet;
import api.spec.Specs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class RestApiTests {
    @Test
    @DisplayName("Pet creating")
    void petCreatingTest() {
        Pet newPet = DataGenerator.getPet(8, 16, true, true, true);

        Integer response = given(Specs.request)
                .body(newPet)
                .when()
                .post("/v2/pet")
                .then()
                .spec(Specs.responseSpec)
                .extract().path("id");

        assertThat(response).isEqualTo(newPet.getId());
    }
}
