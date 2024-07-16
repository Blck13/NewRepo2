package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.*;


public class RegistrationTestWithRandomUtilsTest extends TestBase {
    private Configuration Configuraion;

    @Test
    public void myTest() {


        //Configuration.pageLoadStrategy = "eager";

        //open("https://demoqa.com/automation-practice-form");
        //Selenide.executeJavaScript("$('#fixedban').remove()");
        //Selenide.executeJavaScript("$('footer').remove()");

        Configuration.pageLoadStrategy = "eager";
        String userName = getRandomString(10);
        String userLName = getRandomString(10);
        String userEmail = getRandomEmail();
        String userGender = "Other";
        String userPhone = "1234567890";
        String XX = "07";
        String YY = "July";
        String ZZ = "2008";
        String userSubject = "Chemistry";
        String userHobbie = "Sports";
        String userPicture = "images/3.png";
        String userAdress = "Svoya ulica kv.5";
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

