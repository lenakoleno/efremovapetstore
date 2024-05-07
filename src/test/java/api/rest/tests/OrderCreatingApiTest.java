package api.rest.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import models.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.GeneratorData.getOrder;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specification.RequestSpecification.request;
import static specification.ResponseSpecification.response;

public class OrderCreatingApiTest {

    @Test
    @Feature("Order")
    @Story("Order")
    @DisplayName("Order creating")
    void orderCreatingTest() {
        Order newOrder = getOrder();

        Integer resp = given(request)
                .body(newOrder)
                .when()
                .post("/v2/store/order")
                .then()
                .spec(response)
                .extract().path("id");

        assertThat(resp).isEqualTo(newOrder.getId());
    }
}
