package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeForm;
import settings.BaseTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PracticeFormTest extends BaseTest {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String genderMale = faker.dog().gender();
    String number = faker.phoneNumber().subscriberNumber(10);
    String birthYear = String.valueOf(faker.number().numberBetween(1900, 2100));
    String birthMonth = "august";
    String birthDay = String.valueOf(faker.number().numberBetween(10, 28));
    String subject = "English";
    String sports = "Sports";
    String music = "Music";
    String pictureName = "dart-veyder-boba-fett-kostyumy.jpg";
    String address = faker.address().streetAddress();
    String state = "Uttar Pradesh";
    String city = "Agra";

    Map<String, String> registerForm = new HashMap<>();

    @Test
    void studentRegistrationForm() {
        fillMapForRegisterFormMap();

        AutomationPracticeForm.openPage()
                .checkForm()
                .fillName(firstName, lastName)
                .fillEmail(email)
                .selectGender(genderMale)
                .fillMobileNumber(number)
                .selectDateOfBirth(birthYear, birthMonth, birthDay)
                .fillSubjects(subject)
                .selectHobbies(Arrays.asList(sports, music))
                .loadPictures(pictureName)
                .fillCurrentAddress(address)
                .selectState(state)
                .selectCity(city)
                .clickOnSubmitButton()
                .formSuccessfullyFilled()
                .checkRegisterForm(registerForm);
    }

    private void fillMapForRegisterFormMap() {
        registerForm.put("Student Name", firstName + " " + lastName);
        registerForm.put("Student  Email", email);
        registerForm.put("Gender", genderMale);
        registerForm.put("Mobile", number);
        registerForm.put("Date of Birth", birthDay + " " + birthMonth + "," + birthYear);
        registerForm.put("Subjects", subject);
        registerForm.put("Hobbies", sports + ", " + music);
        registerForm.put("Picture", pictureName);
        registerForm.put("Address", address);
        registerForm.put("State and City", state + " " + city);
    }
}
