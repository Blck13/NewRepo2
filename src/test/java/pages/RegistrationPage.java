package pages;
import com.codeborne.selenide.SelenideElement;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static pages.components.CalendarComponent.setDate;

public class RegistrationPage {
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            lastNameInput = $("#lastName"),
            firstNameInput = $("#firstName"),
            dateOfBirthInput = $("#dateOfBirthInput");


    public RegistrationPage openPage() {
        open("https://demoqa.com//automation-practice-form");
        $(".pratice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;

    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        setDate(day, month, year);

        return this;

    }


    public RegistrationPage verifyResultsModalAppears() {
        RegistrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        RegistrationResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;

    }

    public RegistrationPage setHobbies(String value) {
        $("#hobbies-checkbox-1").parent().$(byText(value)).click();

        return this;

    }

    public RegistrationPage setPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);


        return this;

    }
    public RegistrationPage setAdress(String value) {
        $("#currentAddress").setValue(value);
        $("#state").click();
        return this;
    }

    public RegistrationPage setStateAndCity(String value1, String value2) {
        $("#stateCity-wrapper").$(byText(value1)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value2)).click();
        $("#submit").click();
        return this;
    }


}