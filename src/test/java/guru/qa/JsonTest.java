package guru.qa;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.qa.model.PersonModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import org.assertj.core.api.Assertions;

public class JsonTest {

    private static final ClassLoader cl = PdfTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка содержимого файла .json")
    public void testJsonParsing() throws Exception {

        try (InputStream stream = cl.getResourceAsStream("output.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<PersonModel> personModel = objectMapper.readValue(stream, new TypeReference<>() {});

            Assertions.assertThat(personModel).hasSize(3);

            PersonModel firstPerson = personModel.get(0);
            Assertions.assertThat(firstPerson.getId()).isEqualTo(1);
            Assertions.assertThat(firstPerson.getFirstName()).isEqualTo("Evgeniy");
            Assertions.assertThat(firstPerson.getLastName()).isEqualTo("Golikov");
            Assertions.assertThat(firstPerson.getCountry()).isEqualTo("Russia");
            Assertions.assertThat(firstPerson.getAge()).isEqualTo(29);

            PersonModel secondPerson = personModel.get(1);
            Assertions.assertThat(secondPerson.getId()).isEqualTo(2);
            Assertions.assertThat(secondPerson.getFirstName()).isEqualTo("Alexandra");
            Assertions.assertThat(secondPerson.getLastName()).isEqualTo("Golikova");
            Assertions.assertThat(secondPerson.getCountry()).isEqualTo("Russia");
            Assertions.assertThat(secondPerson.getAge()).isEqualTo(28);

            PersonModel thirdPerson = personModel.get(2);
            Assertions.assertThat(thirdPerson.getId()).isEqualTo(3);
            Assertions.assertThat(thirdPerson.getFirstName()).isEqualTo("Elizabeth");
            Assertions.assertThat(thirdPerson.getLastName()).isEqualTo("Golikova");
            Assertions.assertThat(thirdPerson.getCountry()).isEqualTo("Russia");
            Assertions.assertThat(thirdPerson.getAge()).isEqualTo(13);

        }
    }
}