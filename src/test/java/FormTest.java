import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTest extends TestBase{
    @BeforeMethod
    public void preconditions(){
        wd.findElement(By.xpath("//h5[.='Forms']")).click();
        wd.findElement(By.xpath("//span[.='Practice Form']")).click();
    }

    @Test
    public void formTest(){
       // wd.findElement(By.xpath("//input[@id='firstName']"));
       // wd.findElement(By.cssSelector("#firstName"));

        typeByLocator(By.id("firstName"), "Lola");
        typeByLocator(By.id("lastName"), "Now");

    }

    public void typeByLocator(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }
}
