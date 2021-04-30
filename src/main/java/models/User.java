package models;

public class User {
    String firstName;
    String LastName;
    String email;
    String mobile;
    String dateOfBirth;
    String subjects;
    String currentAddress;
    String state;
    String city;

    public User withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User withLastName(String lastName) {
        LastName = lastName;
        return this;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public User withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public User withSubjects(String subjects) {
        this.subjects = subjects;
        return this;
    }

    public User withCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public User withState(String state) {
        this.state = state;
        return this;
    }

    public User withCity(String city) {
        this.city = city;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSubjects() {
        return subjects;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
