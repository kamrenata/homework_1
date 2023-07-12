package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();

    ResultsModal resultsModal = new ResultsModal();

    //Selenide elements
    SelenideElement
            formHeaderText = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyRadioButton = $("#hobbies-checkbox-1"),
            uploadPicture = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $(byText("Select State")),
            city = $(byText("Select City")),
            submitButton = $("#submit");

    //Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");

        formHeaderText.shouldHave(text("Student Registration Form"));
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
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;

    }
    public RegistrationPage setHobby() {
        hobbyRadioButton.parent().click();

        return this;

    }
    public RegistrationPage picture() {
        uploadPicture.uploadFromClasspath("image.jpeg");

        return this;

    }
    public RegistrationPage setAddress(String value) {
        address.setValue(value);

        return this;

    }
    public RegistrationPage setState() {
        state.click();
        $("#react-select-3-option-1").click();

        return this;

    }
    public RegistrationPage setCity() {
        city.click();
        $("#react-select-4-option-0").click();

        return this;

    }
    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }
    public RegistrationPage verifyRegistrationResultsModalAppears() {
        resultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);

        return this;
    }

}
