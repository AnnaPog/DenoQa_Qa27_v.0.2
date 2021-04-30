package manager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper user;

    public UserHelper user() {
        return user;
    }

    public void init(){
        wd = new ChromeDriver();
        wd.navigate().to("https://demoqa.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        user = new UserHelper(wd);

        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    public void stop(){
       // wd.quit();
    }
}



