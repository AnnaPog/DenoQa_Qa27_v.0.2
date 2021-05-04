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
                .withDateOfBirth("04 May 1986")
                //.withSubjects("English")
                .withHobbies("Sports")
                .withCurrentAddress("Tel Aviv")
//                .withState("NCR")
//                .withCity("Gurgaon")
        );

        app.user().attachPhoto("/Users/annapogrebinskaya/Documents/GitHub/DenoQa_Qa27_v.0.2/graficheskij-portret-karandashom-na-zakaz-2.jpg");
        app.user().clickSubmitButton();

        Assert.assertTrue(app.user().isUserAdded());
    }

}
