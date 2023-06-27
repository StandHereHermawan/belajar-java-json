package ariefbelajarjava.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DeserializationFeatures {

    @Test
    void deserialiizationFeatures() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);

        String json = """
                {"id" : "1", "name": "Arief", "age": "20", "hobbies" : "Coding"}
                """;
        String json2 = """
                {"id" : "1", "name": "Arief", "age": "20", "hobbies" : ["Coding"]}
                """;

        Person person = objectMapper.readValue(json, Person.class);
        Assertions.assertEquals("1",person.getId());
        Assertions.assertEquals("Arief",person.getName());
        Assertions.assertEquals(List.of("Coding"),person.getHobbies());

    }
}
