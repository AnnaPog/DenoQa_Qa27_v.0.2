package manager;

import org.openqa.selenium.*;
import models.User;

public class HelperFormStudent extends HelperBase{
    public HelperFormStudent(WebDriver wd) {
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
        selectGender(user.getGender());
        type(By.id("userNumber"), user.getMobile());
        typeBDay(user.getDateOfBirth());
        //type(By.id("subjectsInput"), user.getSubjects());
        selectHobbies(user.getHobbies());
        type(By.id("currentAddress"), user.getCurrentAddress());
//        select(By.xpath("//div[.='Select State']"), user.getState());
//        select(By.id("city"), user.getCity());

    }

    private void selectHobbies(String hobbies) {
        if(hobbies.equals("Sports")){
            click(By.id("hobbies-checkbox-1"));
        }else if(hobbies.equals("Reading")){
            click(By.id("hobbies-checkbox-2"));
        }else{
            click(By.id("hobbies-checkbox-3"));
        }
    }

    private void typeBDay(String dateOfBirth) {
        WebElement bDay = wd.findElement(By.id("dateOfBirthInput"));
        //click(By.id("dateOfBirthInput"));
        bDay.click();
        String os = System.getProperty("os.name");
        System.out.println(os);
        if(os.startsWith("Mac")){
            bDay.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        }else {
            bDay.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        bDay.sendKeys(dateOfBirth);
        bDay.sendKeys(Keys.ENTER);
    }

    private void selectGender(String gender) {
        if(gender.equals("Male")){
            click(By.id("gender-radio-1"));
        }else if(gender.equals("Female")){
            click(By.id("gender-radio-2"));
        }else {
            click(By.id("gender-radio-3"));
        }
    }

    public void clickSubmitButton() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none';");
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
