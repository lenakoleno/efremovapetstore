package specification;

import io.restassured.http.ContentType;
import utils.AllureFilters;

import static io.restassured.RestAssured.with;

public class RequestSpecification {
    public static io.restassured.specification.RequestSpecification request = with()
            .filter(AllureFilters.withCustomTemplates())
            .baseUri("https://petstore.swagger.io")
            .log().all()
            .contentType(ContentType.JSON);
}
