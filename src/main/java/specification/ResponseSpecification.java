package specification;

import io.restassured.builder.ResponseSpecBuilder;

public class ResponseSpecification {

    public static io.restassured.specification.ResponseSpecification response = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
