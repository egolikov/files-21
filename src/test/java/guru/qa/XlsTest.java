package guru.qa;

import com.codeborne.xlstest.XLS;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class XlsTest {

    private static final ClassLoader cl = PdfTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка содержимого файла .xls")
    void xlsTest() throws IOException {

        boolean filePresentInZip = false;

        try (InputStream zipStream = cl.getResourceAsStream("output.zip");
             ZipInputStream zipInputStream = new ZipInputStream(Objects.requireNonNull(zipStream))) {

            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().equals("output.xls")) {

                    filePresentInZip = true;

                    XLS xls = new XLS(zipInputStream);

                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("Number");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(1).getStringCellValue()).isEqualTo("First Name");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(2).getStringCellValue()).isEqualTo("Last Name");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(3).getStringCellValue()).isEqualTo("Gender");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(4).getStringCellValue()).isEqualTo("Country");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(5).getStringCellValue()).isEqualTo("Age");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(6).getStringCellValue()).isEqualTo("Date");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(7).getStringCellValue()).isEqualTo("Id");

                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(0).getNumericCellValue()).isEqualTo(1.0);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue()).isEqualTo("Dulce");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(2).getStringCellValue()).isEqualTo("Abril");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(3).getStringCellValue()).isEqualTo("Female");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(4).getStringCellValue()).isEqualTo("United States");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(5).getNumericCellValue()).isEqualTo(32);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(6).getStringCellValue()).isEqualTo("15/10/2017");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(7).getNumericCellValue()).isEqualTo(1562);

                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(0).getNumericCellValue()).isEqualTo(2.0);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(1).getStringCellValue()).isEqualTo("Mara");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(2).getStringCellValue()).isEqualTo("Hashimoto");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(3).getStringCellValue()).isEqualTo("Female");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(4).getStringCellValue()).isEqualTo("Great Britain");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(5).getNumericCellValue()).isEqualTo(25);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(6).getStringCellValue()).isEqualTo("16/08/2016");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(2).getCell(7).getNumericCellValue()).isEqualTo(1582);

                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(3).getCell(0).getNumericCellValue()).isEqualTo(3.0);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(3).getCell(1).getStringCellValue()).isEqualTo("Philip");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(3).getCell(2).getStringCellValue()).isEqualTo("Gent");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(3).getCell(3).getStringCellValue()).isEqualTo("Male");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(3).getCell(4).getStringCellValue()).isEqualTo("France");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(3).getCell(5).getNumericCellValue()).isEqualTo(36);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(3).getCell(6).getStringCellValue()).isEqualTo("21/05/2015");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(3).getCell(7).getNumericCellValue()).isEqualTo(2587);

                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(4).getCell(0).getNumericCellValue()).isEqualTo(4.0);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(4).getCell(1).getStringCellValue()).isEqualTo("Kathleen");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(4).getCell(2).getStringCellValue()).isEqualTo("Hanner");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(4).getCell(3).getStringCellValue()).isEqualTo("Female");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(4).getCell(4).getStringCellValue()).isEqualTo("United States");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(4).getCell(5).getNumericCellValue()).isEqualTo(25);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(4).getCell(6).getStringCellValue()).isEqualTo("15/10/2017");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(4).getCell(7).getNumericCellValue()).isEqualTo(3549);

                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(5).getCell(0).getNumericCellValue()).isEqualTo(5.0);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(5).getCell(1).getStringCellValue()).isEqualTo("Nereida");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(5).getCell(2).getStringCellValue()).isEqualTo("Magwood");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(5).getCell(3).getStringCellValue()).isEqualTo("Female");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(5).getCell(4).getStringCellValue()).isEqualTo("United States");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(5).getCell(5).getNumericCellValue()).isEqualTo(58);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(5).getCell(6).getStringCellValue()).isEqualTo("16/08/2016");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(5).getCell(7).getNumericCellValue()).isEqualTo(2468);

                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(6).getCell(0).getNumericCellValue()).isEqualTo(6.0);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(6).getCell(1).getStringCellValue()).isEqualTo("Gaston");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(6).getCell(2).getStringCellValue()).isEqualTo("Brumm");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(6).getCell(3).getStringCellValue()).isEqualTo("Male");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(6).getCell(4).getStringCellValue()).isEqualTo("United States");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(6).getCell(5).getNumericCellValue()).isEqualTo(24);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(6).getCell(6).getStringCellValue()).isEqualTo("21/05/2015");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(6).getCell(7).getNumericCellValue()).isEqualTo(2554);

                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(7).getCell(0).getNumericCellValue()).isEqualTo(7.0);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(7).getCell(1).getStringCellValue()).isEqualTo("Etta");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(7).getCell(2).getStringCellValue()).isEqualTo("Hurn");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(7).getCell(3).getStringCellValue()).isEqualTo("Female");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(7).getCell(4).getStringCellValue()).isEqualTo("Great Britain");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(7).getCell(5).getNumericCellValue()).isEqualTo(56);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(7).getCell(6).getStringCellValue()).isEqualTo("15/10/2017");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(7).getCell(7).getNumericCellValue()).isEqualTo(3598);

                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(8).getCell(0).getNumericCellValue()).isEqualTo(8.0);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(8).getCell(1).getStringCellValue()).isEqualTo("Earlean");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(8).getCell(2).getStringCellValue()).isEqualTo("Melgar");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(8).getCell(3).getStringCellValue()).isEqualTo("Female");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(8).getCell(4).getStringCellValue()).isEqualTo("United States");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(8).getCell(5).getNumericCellValue()).isEqualTo(27);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(8).getCell(6).getStringCellValue()).isEqualTo("16/08/2016");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(8).getCell(7).getNumericCellValue()).isEqualTo(2456);

                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(9).getCell(0).getNumericCellValue()).isEqualTo(9.0);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(9).getCell(1).getStringCellValue()).isEqualTo("Vincenza");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(9).getCell(2).getStringCellValue()).isEqualTo("Weiland");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(9).getCell(3).getStringCellValue()).isEqualTo("Female");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(9).getCell(4).getStringCellValue()).isEqualTo("United States");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(9).getCell(5).getNumericCellValue()).isEqualTo(40);
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(9).getCell(6).getStringCellValue()).isEqualTo("21/05/2015");
                    Assertions.assertThat(xls.excel.getSheetAt(0).getRow(9).getCell(7).getNumericCellValue()).isEqualTo(6548);
                }
            }
        }

        Assertions.assertThat(filePresentInZip).as("Ожидаемый файл отсутствует в архиве output.zip").isTrue();

    }
}
