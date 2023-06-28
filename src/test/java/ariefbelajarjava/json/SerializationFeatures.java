package ariefbelajarjava.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class SerializationFeatures {

    @Test
    void serializationFeatures() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("Arief");
        person.setHobbies(List.of("Nonton Youtube","Reading"));

        Address address = new Address();
        address.setStreet("Bumi Pesona Asri");
        address.setCity("Bandung");
        address.setCountry("Indonesia");
        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT,true);
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void readJSONWithSerializationFeature() throws JsonProcessingException {
        String json = """
                {
                  "punya waifu": true,
                  "firstName": "Hilmi",
                  "lastName": "Akbar",
                  "age": 19,
                  "address": {
                    "city": "Bogor",
                    "country": "Indonesia",
                    "street": "belum ada"
                  }
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT,true);
        System.out.println(json);
        Map<String, Object> person = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        Assertions.assertEquals("Hilmi",person.get("firstName"));
        Assertions.assertEquals("Akbar",person.get("lastName"));
    }
}
