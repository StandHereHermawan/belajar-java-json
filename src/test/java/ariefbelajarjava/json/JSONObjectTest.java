package ariefbelajarjava.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JSONObjectTest {

    @Test
    void createJSON() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstName", "Hilmi",
                "lastName","Akbar",
                "age",19,
                "punya waifu", true,
                "address", Map.of(
                        "street", "belum ada",
                        "city","Bogor",
                        "country", "Indonesia"
                )
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void createJSONTryCatch() {
        Map<String, Object> person = Map.of(
                "firstName", "Hilmi",
                "lastName","Akbar",
                "age",19,
                "punya waifu", true,
                "address", Map.of(
                        "street", "belum ada",
                        "city","Bogor",
                        "country", "Indonesia"
                )
        );

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(person);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            Assertions.fail(e);
        }

    }

}
