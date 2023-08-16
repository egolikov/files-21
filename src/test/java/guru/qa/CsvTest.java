package guru.qa;

import com.opencsv.CSVReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CsvTest {

    private static final ClassLoader cl = CsvTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка содержимого файла .csv")
    void csvTest() throws Exception {

        try (InputStream zipStream = cl.getResourceAsStream("output.zip");
             ZipInputStream zipInputStream = new ZipInputStream(Objects.requireNonNull(zipStream))) {

            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().equals("output.csv")) {
                    Reader reader = new InputStreamReader(zipInputStream);
                    CSVReader csvReader = new CSVReader(reader);
                    List<String[]> content = csvReader.readAll();

                    Assertions.assertThat(content).hasSize(10);

                    Assertions.assertThat(content.get(0)).containsExactly("Анна", "Иванова", "123-456-7890", "anna@example.com");
                    Assertions.assertThat(content.get(1)).containsExactly("Петр", "Петров", "987-654-3210", "petr@example.com");
                    Assertions.assertThat(content.get(2)).containsExactly("Елена", "Сидорова", "555-123-4567", "elena@example.com");
                    Assertions.assertThat(content.get(3)).containsExactly("Иван", "Смирнов", "111-222-3333", "ivan@example.com");
                    Assertions.assertThat(content.get(4)).containsExactly("Мария", "Кузнецова", "444-555-6666", "maria@example.com");
                    Assertions.assertThat(content.get(5)).containsExactly("Алексей", "Попов", "777-888-9999", "alex@example.com");
                    Assertions.assertThat(content.get(6)).containsExactly("Ольга", "Морозова", "333-444-5555", "olga@example.com");
                    Assertions.assertThat(content.get(7)).containsExactly("Александр", "Васильев", "666-777-8888", "sasha@example.com");
                    Assertions.assertThat(content.get(8)).containsExactly("Анна", "Петрова", "888-999-0000", "annap@example.com");
                    Assertions.assertThat(content.get(9)).containsExactly("Сергей", "Иванов", "222-333-4444", "sergei@example.com");
                }
            }
        }
    }
}