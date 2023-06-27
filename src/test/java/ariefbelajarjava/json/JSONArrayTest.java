package ariefbelajarjava.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JSONArrayTest {

    @Test
    void createJSONArray() throws JsonProcessingException {
        List<String> hobbies = List.of("Coding", "Gaming", "Discord-an");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(hobbies);

        System.out.println(json);
    }

    @Test
    void createJSONArrayTryCatch() {
        List<String> hobbies = List.of("Coding", "Gaming", "Discord-an");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(hobbies);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(json);
    }

    @Test
    void readJSONArray() throws JsonProcessingException {
        String json = """
                ["Coding","Gaming","Discord-an"]
                """;

        ObjectMapper objectMapper = new ObjectMapper();

        List<String> hobbies = objectMapper.readValue(json, new TypeReference<List<String>>() {
        });

        Assertions.assertEquals(List.of("Coding", "Gaming", "Discord-an"),hobbies);
    }
}
