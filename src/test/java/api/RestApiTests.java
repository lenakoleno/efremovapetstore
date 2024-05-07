package api;

import api.data.DataGenerator;
import api.models.Order;
import api.models.Pet;
import api.models.User;
import api.spec.Specs;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class RestApiTests {

    @Test
    @DisplayName("Найти статус - доступный")
    void availableStatusTest() {
        given(Specs.request)
                .when()
                .params("status", "available")
                .get("/v2/pet/findByStatus")
                .then()
                .spec(Specs.responseSpec)
                .body("id", hasSize(greaterThan(0)));
    }

    @Test
    @DisplayName("Найти статус - продано")
    void soldStatusTest() {
        given(Specs.request)
                .when()
                .params("status", "sold")
                .get("/v2/pet/findByStatus")
                .then()
                .spec(Specs.responseSpec)
                .body("id", hasSize(greaterThan(0)));
    }

    @Test
    @DisplayName("Найти нулевой статус")
    void nullStatusTest() {
        given(Specs.request)
                .when()
                .params("status", "null")
                .get("/v2/pet/findByStatus")
                .then()
                .spec(Specs.responseSpec);
    }

    @Test
    @DisplayName("Создать пользователя")
    void userCreatingTest() {
        User newUser = DataGenerator.getUser(8, 16, true, true, true);

        String response = given(Specs.request)
                .body(newUser)
                .when()
                .post("/v2/user")
                .then()
                .spec(Specs.responseSpec)
                .extract().path("message");

        assertThat(response).isEqualTo(newUser.getId().toString());
    }

    @Test
    @DisplayName("Получить пустого пользователя")
    void userEmptyTest() {
        given(Specs.request)
                .when()
                .get("v2/user/user55")
                .then()
                .statusCode(404)
                .body("message", is("User not found"));
    }

    @Test
    @DisplayName("Создание заказа")
    void orderCreatingTest() {
        Order newOrder = DataGenerator.getOrder(8, 16, true, true, true);

        Integer response = given(Specs.request)
                .body(newOrder)
                .when()
                .post("/v2/store/order")
                .then()
                .spec(Specs.responseSpec)
                .extract().path("id");

        assertThat(response).isEqualTo(newOrder.getId());
    }

    @Test
    @DisplayName("Найти заказ")
    void orderFindingTest() {
        given(Specs.request)
                .when()
                .get("/v2/store/order/2")
                .then()
                .statusCode(404)
                .body("message", is("Order not found"));
    }

    @Test
    @DisplayName("Создать питомца")
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
