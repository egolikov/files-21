package guru.qa;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;



public class PdfTest {

    private static final ClassLoader cl = PdfTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка содержимого файла .pdf")
    void pdfTest() throws IOException {

        boolean filePresentInZip = false;

        try (InputStream zipStream = cl.getResourceAsStream("output.zip");
             ZipInputStream zipInputStream = new ZipInputStream(Objects.requireNonNull(zipStream))) {

            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().equals("output.pdf")) {

                    filePresentInZip = true;

                    PDF pdf = new PDF(zipInputStream);

                    String expectedResult = "Файлы PDF (Portable Document Format) действительно популярны по множеству" +
                            "причин. Вот некоторые из основных преимуществ, которые сделали PDF таким" +
                            "распространенным форматом для обмена и хранения документов:" +
                            "Целостность и сохранение вида: Файлы PDF сохраняют исходный внешний вид и" +
                            "форматирование документов, независимо от платформы или программы просмотра." +
                            "Это обеспечивает надежное воспроизведение документов на разных устройствах и" +
                            "платформах." +
                            "Компактность: PDF-файлы обычно имеют более низкий объем по сравнению с" +
                            "исходными документами, такими как файлы Microsoft Word или документы в других" +
                            "форматах. Это делает PDF идеальным выбором для передачи и хранения документов," +
                            "особенно в ситуациях с ограниченным доступом к интернету или ограниченным" +
                            "дисковым пространством." +
                            "Безопасность и контроль доступа: Файлы PDF могут быть защищены паролями," +
                            "шифрованы и содержать цифровые подписи. Это обеспечивает высокий уровень" +
                            "безопасности и предотвращает несанкционированные изменения или доступ к" +
                            "конфиденциальной информации." +
                            "Поддержка комментариев и совместной работы: PDF-файлы позволяют пользователям" +
                            "добавлять комментарии, отметки, аннотации и заметки. Это упрощает совместную" +
                            "работу над документами и обсуждение их содержания без необходимости изменения" +
                            "самого документа." +
                            "Поддержка мультимедийных элементов: Формат PDF может включать в себя различные" +
                            "мультимедийные элементы, такие как изображения, видео и звук. Это позволяет" +
                            "создавать богатые мультимедийные документы." +
                            "Возможность создания интерактивных форм: PDF позволяет создавать интерактивные" +
                            "формы, которые пользователи могут заполнять и отправлять в электронном виде. Это" +
                            "полезно для сбора данных и обратной связи от пользователей." +
                            "Из-за этих преимуществ и большой поддержки со стороны программ и платформ," +
                            "формат PDF стал стандартом для обмена документами, от бизнес-корреспонденции до" +
                            "научных статей и медиа-материалов.";

                    Assertions.assertThat(pdf.text.replace("\r\n", ""))
                            .isEqualTo(expectedResult);
                }
            }
        }

        Assertions.assertThat(filePresentInZip).as("Ожидаемый файл отсутствует в архиве output.zip").isTrue();

    }
}
