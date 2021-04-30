import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTest extends TestBase{
    @BeforeMethod
    public void preconditions(){
        app.user().openRegistrationForm();
    }

    @Test
    public void formTest(){
        app.user().fillRegistrationForm(new User()
        .withFirstName("Michel")
        .withLastName("Forbs")
                        .withMobile("8908058678")

                .withSubjects("Selenium")
                //.withCurrentAddress("Tel Aviv")
//                .withState("NCR")
//                .withCity("Gurgaon")
        );

        app.user().clickGenderMenu();
        app.user().clickHobbiesMenu();
        app.user().attachPhoto("/Users/annapogrebinskaya/Documents/GitHub/DenoQa_Qa27_v.0.2/graficheskij-portret-karandashom-na-zakaz-2.jpg");
        app.user().clickSubmitButton();

        Assert.assertTrue(app.user().isUserAdded());
    }

}
