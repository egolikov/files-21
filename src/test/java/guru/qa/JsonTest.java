package guru.qa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.model.PersonModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    private static final ClassLoader cl = PdfTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка содержимого файла .json")
    public void testJsonParsing() throws Exception {

        try (InputStream stream = cl.getResourceAsStream("output.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<PersonModel> personModel = objectMapper.readValue(stream, new TypeReference<>() {});

            assertEquals(3, personModel.size());

            PersonModel firstPerson = personModel.get(0);
            assertEquals(1, firstPerson.getId());
            assertEquals("Evgeniy", firstPerson.getFirstName());
            assertEquals("Golikov", firstPerson.getLastName());
            assertEquals("Russia", firstPerson.getCountry());
            assertEquals(29, firstPerson.getAge());

            PersonModel secondPerson = personModel.get(1);
            assertEquals(2, secondPerson.getId());
            assertEquals("Alexandra", secondPerson.getFirstName());
            assertEquals("Golikova", secondPerson.getLastName());
            assertEquals("Russia", secondPerson.getCountry());
            assertEquals(28, secondPerson.getAge());

            PersonModel thirdPerson = personModel.get(2);
            assertEquals(3, thirdPerson.getId());
            assertEquals("Elizabeth", thirdPerson.getFirstName());
            assertEquals("Golikova", thirdPerson.getLastName());
            assertEquals("Russia", thirdPerson.getCountry());
            assertEquals(13, thirdPerson.getAge());

        }
    }
}