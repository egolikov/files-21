package guru.qa;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class XlsTest {

    private static final ClassLoader cl = PdfTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка содержимого файла .xls")
    void xlsxTest() throws Exception {

        try (InputStream zipStream = cl.getResourceAsStream("output.zip");
             ZipInputStream zipInputStream = new ZipInputStream(Objects.requireNonNull(zipStream))) {

            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().equals("output.xls")) {
                    XLS xls = new XLS(zipInputStream);

                    Assertions.assertEquals("Number", xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue());
                    Assertions.assertEquals("First Name", xls.excel.getSheetAt(0).getRow(0).getCell(1).getStringCellValue());
                    Assertions.assertEquals("Last Name", xls.excel.getSheetAt(0).getRow(0).getCell(2).getStringCellValue());
                    Assertions.assertEquals("Gender", xls.excel.getSheetAt(0).getRow(0).getCell(3).getStringCellValue());
                    Assertions.assertEquals("Country", xls.excel.getSheetAt(0).getRow(0).getCell(4).getStringCellValue());
                    Assertions.assertEquals("Age", xls.excel.getSheetAt(0).getRow(0).getCell(5).getStringCellValue());
                    Assertions.assertEquals("Date", xls.excel.getSheetAt(0).getRow(0).getCell(6).getStringCellValue());
                    Assertions.assertEquals("Id", xls.excel.getSheetAt(0).getRow(0).getCell(7).getStringCellValue());

                    Assertions.assertEquals(1.0, xls.excel.getSheetAt(0).getRow(1).getCell(0).getNumericCellValue());
                    Assertions.assertEquals("Dulce", xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue());
                    Assertions.assertEquals("Abril", xls.excel.getSheetAt(0).getRow(1).getCell(2).getStringCellValue());
                    Assertions.assertEquals("Female", xls.excel.getSheetAt(0).getRow(1).getCell(3).getStringCellValue());
                    Assertions.assertEquals("United States", xls.excel.getSheetAt(0).getRow(1).getCell(4).getStringCellValue());
                    Assertions.assertEquals(32, xls.excel.getSheetAt(0).getRow(1).getCell(5).getNumericCellValue());
                    Assertions.assertEquals("15/10/2017", xls.excel.getSheetAt(0).getRow(1).getCell(6).getStringCellValue());
                    Assertions.assertEquals(1562, xls.excel.getSheetAt(0).getRow(1).getCell(7).getNumericCellValue());

                    Assertions.assertEquals(2.0, xls.excel.getSheetAt(0).getRow(2).getCell(0).getNumericCellValue());
                    Assertions.assertEquals("Mara", xls.excel.getSheetAt(0).getRow(2).getCell(1).getStringCellValue());
                    Assertions.assertEquals("Hashimoto", xls.excel.getSheetAt(0).getRow(2).getCell(2).getStringCellValue());
                    Assertions.assertEquals("Female", xls.excel.getSheetAt(0).getRow(2).getCell(3).getStringCellValue());
                    Assertions.assertEquals("Great Britain", xls.excel.getSheetAt(0).getRow(2).getCell(4).getStringCellValue());
                    Assertions.assertEquals(25, xls.excel.getSheetAt(0).getRow(2).getCell(5).getNumericCellValue());
                    Assertions.assertEquals("16/08/2016", xls.excel.getSheetAt(0).getRow(2).getCell(6).getStringCellValue());
                    Assertions.assertEquals(1582, xls.excel.getSheetAt(0).getRow(2).getCell(7).getNumericCellValue());

                    Assertions.assertEquals(3.0, xls.excel.getSheetAt(0).getRow(3).getCell(0).getNumericCellValue());
                    Assertions.assertEquals("Philip", xls.excel.getSheetAt(0).getRow(3).getCell(1).getStringCellValue());
                    Assertions.assertEquals("Gent", xls.excel.getSheetAt(0).getRow(3).getCell(2).getStringCellValue());
                    Assertions.assertEquals("Male", xls.excel.getSheetAt(0).getRow(3).getCell(3).getStringCellValue());
                    Assertions.assertEquals("France", xls.excel.getSheetAt(0).getRow(3).getCell(4).getStringCellValue());
                    Assertions.assertEquals(36, xls.excel.getSheetAt(0).getRow(3).getCell(5).getNumericCellValue());
                    Assertions.assertEquals("21/05/2015", xls.excel.getSheetAt(0).getRow(3).getCell(6).getStringCellValue());
                    Assertions.assertEquals(2587, xls.excel.getSheetAt(0).getRow(3).getCell(7).getNumericCellValue());

                    Assertions.assertEquals(4.0, xls.excel.getSheetAt(0).getRow(4).getCell(0).getNumericCellValue());
                    Assertions.assertEquals("Kathleen", xls.excel.getSheetAt(0).getRow(4).getCell(1).getStringCellValue());
                    Assertions.assertEquals("Hanner", xls.excel.getSheetAt(0).getRow(4).getCell(2).getStringCellValue());
                    Assertions.assertEquals("Female", xls.excel.getSheetAt(0).getRow(4).getCell(3).getStringCellValue());
                    Assertions.assertEquals("United States", xls.excel.getSheetAt(0).getRow(4).getCell(4).getStringCellValue());
                    Assertions.assertEquals(25, xls.excel.getSheetAt(0).getRow(4).getCell(5).getNumericCellValue());
                    Assertions.assertEquals("15/10/2017", xls.excel.getSheetAt(0).getRow(4).getCell(6).getStringCellValue());
                    Assertions.assertEquals(3549, xls.excel.getSheetAt(0).getRow(4).getCell(7).getNumericCellValue());

                    Assertions.assertEquals(5.0, xls.excel.getSheetAt(0).getRow(5).getCell(0).getNumericCellValue());
                    Assertions.assertEquals("Nereida", xls.excel.getSheetAt(0).getRow(5).getCell(1).getStringCellValue());
                    Assertions.assertEquals("Magwood", xls.excel.getSheetAt(0).getRow(5).getCell(2).getStringCellValue());
                    Assertions.assertEquals("Female", xls.excel.getSheetAt(0).getRow(5).getCell(3).getStringCellValue());
                    Assertions.assertEquals("United States", xls.excel.getSheetAt(0).getRow(5).getCell(4).getStringCellValue());
                    Assertions.assertEquals(58, xls.excel.getSheetAt(0).getRow(5).getCell(5).getNumericCellValue());
                    Assertions.assertEquals("16/08/2016", xls.excel.getSheetAt(0).getRow(5).getCell(6).getStringCellValue());
                    Assertions.assertEquals(2468, xls.excel.getSheetAt(0).getRow(5).getCell(7).getNumericCellValue());

                    Assertions.assertEquals(6.0, xls.excel.getSheetAt(0).getRow(6).getCell(0).getNumericCellValue());
                    Assertions.assertEquals("Gaston", xls.excel.getSheetAt(0).getRow(6).getCell(1).getStringCellValue());
                    Assertions.assertEquals("Brumm", xls.excel.getSheetAt(0).getRow(6).getCell(2).getStringCellValue());
                    Assertions.assertEquals("Male", xls.excel.getSheetAt(0).getRow(6).getCell(3).getStringCellValue());
                    Assertions.assertEquals("United States", xls.excel.getSheetAt(0).getRow(6).getCell(4).getStringCellValue());
                    Assertions.assertEquals(24, xls.excel.getSheetAt(0).getRow(6).getCell(5).getNumericCellValue());
                    Assertions.assertEquals("21/05/2015", xls.excel.getSheetAt(0).getRow(6).getCell(6).getStringCellValue());
                    Assertions.assertEquals(2554, xls.excel.getSheetAt(0).getRow(6).getCell(7).getNumericCellValue());

                    Assertions.assertEquals(7.0, xls.excel.getSheetAt(0).getRow(7).getCell(0).getNumericCellValue());
                    Assertions.assertEquals("Etta", xls.excel.getSheetAt(0).getRow(7).getCell(1).getStringCellValue());
                    Assertions.assertEquals("Hurn", xls.excel.getSheetAt(0).getRow(7).getCell(2).getStringCellValue());
                    Assertions.assertEquals("Female", xls.excel.getSheetAt(0).getRow(7).getCell(3).getStringCellValue());
                    Assertions.assertEquals("Great Britain", xls.excel.getSheetAt(0).getRow(7).getCell(4).getStringCellValue());
                    Assertions.assertEquals(56, xls.excel.getSheetAt(0).getRow(7).getCell(5).getNumericCellValue());
                    Assertions.assertEquals("15/10/2017", xls.excel.getSheetAt(0).getRow(7).getCell(6).getStringCellValue());
                    Assertions.assertEquals(3598, xls.excel.getSheetAt(0).getRow(7).getCell(7).getNumericCellValue());

                    Assertions.assertEquals(8.0, xls.excel.getSheetAt(0).getRow(8).getCell(0).getNumericCellValue());
                    Assertions.assertEquals("Earlean", xls.excel.getSheetAt(0).getRow(8).getCell(1).getStringCellValue());
                    Assertions.assertEquals("Melgar", xls.excel.getSheetAt(0).getRow(8).getCell(2).getStringCellValue());
                    Assertions.assertEquals("Female", xls.excel.getSheetAt(0).getRow(8).getCell(3).getStringCellValue());
                    Assertions.assertEquals("United States", xls.excel.getSheetAt(0).getRow(8).getCell(4).getStringCellValue());
                    Assertions.assertEquals(27, xls.excel.getSheetAt(0).getRow(8).getCell(5).getNumericCellValue());
                    Assertions.assertEquals("16/08/2016", xls.excel.getSheetAt(0).getRow(8).getCell(6).getStringCellValue());
                    Assertions.assertEquals(2456, xls.excel.getSheetAt(0).getRow(8).getCell(7).getNumericCellValue());

                    Assertions.assertEquals(9.0, xls.excel.getSheetAt(0).getRow(9).getCell(0).getNumericCellValue());
                    Assertions.assertEquals("Vincenza", xls.excel.getSheetAt(0).getRow(9).getCell(1).getStringCellValue());
                    Assertions.assertEquals("Weiland", xls.excel.getSheetAt(0).getRow(9).getCell(2).getStringCellValue());
                    Assertions.assertEquals("Female", xls.excel.getSheetAt(0).getRow(9).getCell(3).getStringCellValue());
                    Assertions.assertEquals("United States", xls.excel.getSheetAt(0).getRow(9).getCell(4).getStringCellValue());
                    Assertions.assertEquals(40, xls.excel.getSheetAt(0).getRow(9).getCell(5).getNumericCellValue());
                    Assertions.assertEquals("21/05/2015", xls.excel.getSheetAt(0).getRow(9).getCell(6).getStringCellValue());
                    Assertions.assertEquals(6548, xls.excel.getSheetAt(0).getRow(9).getCell(7).getNumericCellValue());
                }
            }
        }
    }
}
