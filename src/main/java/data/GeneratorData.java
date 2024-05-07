package data;

import com.github.javafaker.Faker;
import models.Pet;

public class GeneratorData {
    public static Pet getPet(int minLength, int maxLength, boolean uppercase,
                                boolean special, boolean digit) {
        Faker faker = new Faker();
        return Pet.builder()
                .id(faker.hashCode())
                .name(faker.name().name())
                .status("placed")
                .build();
    }
}
