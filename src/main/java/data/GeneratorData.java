package data;

import com.github.javafaker.Faker;
import models.Order;
import models.Pet;

public class GeneratorData {
    public static Pet getPet() {
        Faker faker = new Faker();
        return Pet.builder()
                .id(faker.hashCode())
                .name(faker.name().name())
                .status("placed")
                .build();
    }

    public static Order getOrder() {
        Faker faker = new Faker();
        return Order.builder()
                .id(faker.hashCode())
                .petId(faker.hashCode())
                .quantity(faker.hashCode())
                .shipDate("2001-03-14T13:24:19.234+0000")
                .status("placed")
                .complete(true)
                .build();
    }
}
