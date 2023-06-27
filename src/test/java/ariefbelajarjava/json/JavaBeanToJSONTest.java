package ariefbelajarjava.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JavaBeanToJSONTest {

    @Test
    void createJSONFromObject() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("Arief");
        person.setHobbies(List.of("Nonton Youtube","Reading"));

        Address address = new Address();
        address.setStreet("Bumi Pesona Asri");
        address.setCity("Bandung");
        address.setCountry("Indonesia");
        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }
}
