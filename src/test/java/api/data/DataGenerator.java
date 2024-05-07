package api.data;

import api.models.Pet;
import com.github.javafaker.Faker;

public class DataGenerator {
    public static Pet getPet(int minimumLength, int maximumLength, boolean includeUppercase,
                                boolean includeSpecial, boolean includeDigit) {
        Faker faker = new Faker();
        return Pet.builder()
                .id(faker.hashCode())
                .name(faker.name().name())
                .status("placed")
                .build();
    }
}
