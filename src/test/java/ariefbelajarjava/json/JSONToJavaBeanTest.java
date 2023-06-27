package ariefbelajarjava.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JSONToJavaBeanTest {

    @Test
    void readObjectFromJSON() throws JsonProcessingException {
        String json = """
                    {
                      "id": "1",
                      "name": "Arief",
                      "hobbies": [
                        "Nonton Youtube",
                        "Reading"
                      ],
                      "address": {
                        "street": "Bumi Pesona Asri",
                        "city": "Bandung",
                        "country": "Indonesia"
                      }
                    }                              
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("1",person.getId());
        Assertions.assertEquals("Arief",person.getName());
        Assertions.assertEquals(List.of("Nonton Youtube","Reading"),person.getHobbies());
        Assertions.assertEquals("Bumi Pesona Asri",person.getAddress().getStreet());
        Assertions.assertEquals("Bandung",person.getAddress().getCity());
        Assertions.assertEquals("Indonesia",person.getAddress().getCountry());
    }
}
