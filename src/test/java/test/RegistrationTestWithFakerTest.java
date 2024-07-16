package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;


public class RegistrationTestWithFakerTest extends TestBase {
    private Configuration Configuraion;

    @Test
    public void myTest() {


        //Configuration.pageLoadStrategy = "eager";

        //open("https://demoqa.com/automation-practice-form");
        //Selenide.executeJavaScript("$('#fixedban').remove()");
        //Selenide.executeJavaScript("$('footer').remove()");
        Configuration.pageLoadStrategy = "eager";


        Faker faker = new Faker();


        String userName = faker.name().firstName();
        String userLName = faker.name().lastName() ;
        String userEmail = faker.internet().emailAddress();
        String userGender = "Other";
        String userPhone = "1234567890";
        String XX = "07";
        String YY = "July";
        String ZZ = "2008";
        String userSubject = "Chemistry";
        String userHobbie = "Sports";
        String userPicture = "images/3.png";
        String userAdress = faker.address().fullAddress();
        String userState = "Uttar Pradesh";
        String userCity = "Agra";


        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(XX, YY, ZZ)
                .setSubjects(userSubject)
                .setHobbies(userHobbie)
                .setPicture(userPicture)
                .setAdress(userAdress)
                .setStateAndCity(userState, userCity);

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", "Ivan" + "Egorov")
                .verifyResult("Student Email", "krovostok@mail.ru")
                .verifyResult("Gender", "Other")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "07 September,2007");


        $("#closeLargeModal").click();
        Selenide.sleep(5000);

    }

    public void main() {
    }
}

