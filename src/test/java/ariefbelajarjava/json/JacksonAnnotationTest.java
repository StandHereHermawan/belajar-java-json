package ariefbelajarjava.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JacksonAnnotationTest {

    @Test
    void annotation() throws JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT,true)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(dateFormat);

        Person person = new Person();
        person.setId("002");
        person.setName("Hilmi");
        person.setFullName("Hilmi Akbar Muharrom");
        person.setPassword("rahasia");
        person.setHobbies(List.of("Nonton Anime","Dengerin Lagu Retrowave","Share meme iT", "Nugas"));
        person.setCreatedAt(new Date());
        person.setUpdatedAt(new Date());

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);

    }
}
