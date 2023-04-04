package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class FormTest extends TestBase {


    @Test
    void FormTest(){
        //Configuration.holdBrowserOpen = true;
        open("/automation-practice-form");

        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
        $(byText("Submit")).scrollTo();

        $("#firstName").setValue("John"); //first name
        $("#lastName").setValue("Doe");// last name
        $("#userEmail").setValue("test@email.com"); // email address
        $(byText("Female")).click(); //or $("#gender-radio-2").parent().click(); // gender radio button
        $("#userNumber").setValue("1234567890"); // phone number

        //date of birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").parent().click();
        $(byText("February")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1993")).click();
        $(byText("18")).click();

        $("#subjectsInput").setValue("English").pressEnter(); //subject
        $("#hobbies-checkbox-1").parent().click(); // hobby checkbox checked
        $("#uploadPicture").uploadFromClasspath("image.jpeg"); //upload image
        $("#currentAddress").click(); // address field
        $("#currentAddress").setValue("Jean Marot street"); // fill in address
        $(byText("Select State")).click(); //state drop-down
        $("#react-select-3-option-1").click(); //select state
        $(byText("Select City")).click(); // city drop-down
        $("#react-select-4-option-0").click(); //select city
        $(byText("Submit")).scrollTo();
        $("#submit").click();

        //$("#output").shouldHave(text("John"), text("Doe"), text("test@email.com"), text("1234567890"), text("John"), text("test@email.com"), text("Nowhere"), text("Here"));

    }
}

