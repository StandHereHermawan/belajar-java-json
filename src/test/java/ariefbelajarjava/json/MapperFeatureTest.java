package ariefbelajarjava.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapperFeatureTest {

    @Test
    void MapperFeatureTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        String json = """
                {"ID" : "1", "Name": "Arief"}
                """;

        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("1",person.getId());
        Assertions.assertEquals("Arief",person.getName());
    }
}
