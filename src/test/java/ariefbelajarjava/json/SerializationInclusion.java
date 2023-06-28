package ariefbelajarjava.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

public class SerializationInclusion {

    @Test
    void serializationWithoutInclusion() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = new Person();
        person.setId("1");
        person.setName("Hilmi");

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    void serializationWithoutInclusionWithSerializationFeatures() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT,true);

        Person person = new Person();
        person.setId("1");
        person.setName("Hilmi");

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    void serializationInclusion() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Person person = new Person();
        person.setId("1");
        person.setName("Hilmi");

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    void serializationInclusionWithSerializationFeatures() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.INDENT_OUTPUT,true);

        Person person = new Person();
        person.setId("1");
        person.setName("Hilmi");

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
    }
}
