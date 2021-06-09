import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTest extends TestBase{
    @BeforeMethod
    public void preconditions(){
        app.user().openRegistrationForm();
//        app.form().selectItemForms();
//        app.form().selectPracticeForm();
        app.user().hideFooter();
    }

    @Test
    public void formTest(){
        app.user().fillRegistrationForm(new User()
        .withFirstName("Michel")
        .withLastName("Forbs")
                .withEmail("MichelFor@gmail.com")
                .withGender("Male")
                        .withMobile("8908058678")
                .withDateOfBirth("30 April 1990")
                .withSubjects("English")
                .withHobbies("Sports")
                .withCurrentAddress("Tel Aviv")
                .withCity("Gurgaon")
                .withState("NCR")
                .withCity("Gurgaon")
        );

        app.user().attachPhoto("/Users/annapogrebinskaya/Documents/GitHub/DenoQa_Qa27_v.0.2/graficheskij-portret-karandashom-na-zakaz-2.jpg");
        app.user().clickSubmitButton();

        Assert.assertTrue(app.user().isUserAdded());
        app.user().closeDialog();
        logger.info("Car was created");
    }

}
