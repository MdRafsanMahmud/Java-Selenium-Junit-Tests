import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.time.Duration;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TableExtractor {

    WebDriver driver;

    @BeforeAll
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    @DisplayName("Scrape DSE Table and Assert Success")
    void printAndSaveTableData() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");

        WebElement table = driver.findElement(By.cssSelector(".table-responsive.inner-scroll table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Prepare file
        Path filePath = Paths.get("src", "test", "resources", "share_prices.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()));

        int totalCellCount = 0;

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                String text = cell.getText().trim();
                writer.write(text + "\t");
                System.out.print(text + "\t");
                totalCellCount++;
            }
            writer.newLine();
            System.out.println();
        }

        writer.close();

        // ✅ Single assertion to confirm table was scraped
        Assertions.assertTrue(totalCellCount > 0, "Table scraping failed");

        System.out.println("Table scraped and saved successfully.");
    }
}
