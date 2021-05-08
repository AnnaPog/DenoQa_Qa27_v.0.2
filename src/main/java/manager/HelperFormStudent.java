package manager;

import org.openqa.selenium.*;
import models.User;
import org.openqa.selenium.interactions.Actions;

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
        selectBDay(user.getDateOfBirth());
        //typeBDay(user.getDateOfBirth());
        selectSubject(user.getSubjects());
        selectHobbies(user.getHobbies());
        type(By.id("currentAddress"), user.getCurrentAddress());
        selectState(user.getState());
        selectCity(user.getCity());


    }

    private void selectCity(String city) {
        WebElement el =wd.findElement(By.id("react-select-4-input"));
        new Actions(wd).sendKeys(el,city).perform();
        el.sendKeys(Keys.ENTER);
    }

    private void selectState(String state) {
//        type(By.id("#react-select-3-input"), state);
//        wd.findElement(By.id("#react-select-3-input")).sendKeys(Keys.ENTER);
        WebElement el = wd.findElement(By.id("react-select-3-input"));
        new Actions(wd).sendKeys(el, state).perform();
        //new Actions(wd).sendKeys(el, state).perform();
        el.sendKeys(Keys.ENTER);
    }

    private void selectSubject(String subjects) {
        type(By.id("subjectsInput"), subjects);
        wd.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
    }

    private void selectHobbies(String hobbies) {
        if(hobbies.equals("Sports")){
            click(By.xpath("//label[@for='hobbies-checkbox-1']"));
        }else if(hobbies.equals("Reading")){
            click(By.xpath("//label[@for='hobbies-checkbox-2']"));
        }else{
            click(By.xpath("//label[@for='hobbies-checkbox-3']"));
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
            click(By.xpath("//label[@for='gender-radio-1']"));
        }else if(gender.equals("Female")){
            click(By.xpath("//label[@for='gender-radio-2']"));
        }else {
            click(By.xpath("//label[@for='gender-radio-3']"));
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

    public void closeDialog(){
        click(By.id("closeLargeModal"));
    }

    private  void selectBDay(String bday){
        click(By.xpath("//input[@id='dateOfBirthInput']"));
        //selectMonth(By.xpath("//select[@class='react-datepicker__month-select']/option[4]"));
        //selectYear(By.xpath("//select[@class='react-datepicker__year-select']/option[.=1990]"));
        //selectDay();

        String [] arr = bday.split(" ");
        String month = arr [1];
        String year = arr [2];
        String day = arr [0];

        click(By.xpath("//input[@id='dateOfBirthInput']"));
        select(By.xpath("//select[@class='react-datepicker__month-select']"), month);

        select(By.xpath("//select[@class='react-datepicker__year-select']"), year);

        //select(By.xpath("//div[@class='react-datepicker__month-container']"), day);
        int newDay = Integer.parseInt(day);
       // selectnewDay(newDay);

        click(By.xpath("//div[.="+newDay+"]"));

    }

    private void selectnewDay(int newDay) {
        if (newDay <=9){
            click(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--00"+ newDay +"']"));
        }else {
        click(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--0"+ newDay +"']"));
        }
    }

//    private void selectDay() {
//        click(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--026']"));
//    }
//
//    private void selectYear(By locator) {
//        click(By.xpath("//select[@class='react-datepicker__year-select']"));
//        click(locator);
//    }
//
//    private void selectMonth(By locator) {
//        click(By.xpath("//select[@class='react-datepicker__month-select']"));
//        click(locator);
//    }
}

