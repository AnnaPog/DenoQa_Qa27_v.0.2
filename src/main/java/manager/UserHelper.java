package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import models.User;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openRegistrationForm(){
        click(By.xpath("//h5[.='Forms']"));
        click(By.xpath("//span[.='Practice Form']"));
    }

    public void fillRegistrationForm(User user){
        type(By.id("firstName"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("userEmail"), user.getEmail());
        type(By.id("userNumber"), user.getMobile());

        type(By.id("subjectsInput"), user.getSubjects());
        //type(By.id("currentAddress"), user.getCurrentAddress());
//        select(By.xpath("//div[.='Select State']"), user.getState());
//        select(By.id("city"), user.getCity());

    }

    public void clickGenderMenu() {
        click(By.xpath("//label[.='Male']"));
    }

    public void clickHobbiesMenu() {
        click(By.xpath("//label[.='Music']"));
    }

    public void clickSubmitButton() {
        click(By.xpath("//button[.='Submit']"));
    }

    public void attachPhoto(String link) {
        wd.findElement(By.id("uploadPicture")).sendKeys(link);
    }

    public boolean isUserAdded() {
        String text = wd.findElement(By.id("example-modal-sizes-title-lg")).getText();
        return text.contains("Thanks for submitting the form");
    }
}
