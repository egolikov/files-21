package guru.qa;

import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CsvFromZipTest {

    private static final ClassLoader cl = CsvFromZipTest.class.getClassLoader();

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

                    Assertions.assertEquals(10, content.size());

                    final String[] firstRow = content.get(0);
                    final String[] secondRow = content.get(1);
                    final String[] thirdRow = content.get(2);
                    final String[] fourthRow = content.get(3);
                    final String[] fifthRow = content.get(4);
                    final String[] sixthRow = content.get(5);
                    final String[] seventhRow = content.get(6);
                    final String[] eighthRow = content.get(7);
                    final String[] ninthRow = content.get(8);
                    final String[] tenthRow = content.get(9);

                    Assertions.assertArrayEquals(new String[]{"Анна", "Иванова", "123-456-7890", "anna@example.com"}, firstRow);
                    Assertions.assertArrayEquals(new String[]{"Петр", "Петров", "987-654-3210", "petr@example.com"}, secondRow);
                    Assertions.assertArrayEquals(new String[]{"Елена", "Сидорова", "555-123-4567", "elena@example.com"}, thirdRow);
                    Assertions.assertArrayEquals(new String[]{"Иван", "Смирнов", "111-222-3333", "ivan@example.com"}, fourthRow);
                    Assertions.assertArrayEquals(new String[]{"Мария", "Кузнецова", "444-555-6666", "maria@example.com"}, fifthRow);
                    Assertions.assertArrayEquals(new String[]{"Алексей", "Попов", "777-888-9999", "alex@example.com"}, sixthRow);
                    Assertions.assertArrayEquals(new String[]{"Ольга", "Морозова", "333-444-5555", "olga@example.com"}, seventhRow);
                    Assertions.assertArrayEquals(new String[]{"Александр", "Васильев", "666-777-8888", "sasha@example.com"}, eighthRow);
                    Assertions.assertArrayEquals(new String[]{"Анна", "Петрова", "888-999-0000", "annap@example.com"}, ninthRow);
                    Assertions.assertArrayEquals(new String[]{"Сергей", "Иванов", "222-333-4444", "sergei@example.com"}, tenthRow);
                }
            }
        }
    }
}