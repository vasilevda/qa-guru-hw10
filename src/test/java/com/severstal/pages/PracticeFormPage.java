package com.severstal.pages;

import io.qameta.allure.Step;
import com.severstal.TestData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPage {

    @Step("Заполнить поля на странице Demoqa")
    public PracticeFormPage fillStudentRegistrationForm(TestData testData) {
        $("#firstName").setValue(testData.getFirstName());
        $("#lastName").setValue(testData.getLastName());
        $("#userEmail").setValue(testData.getUserEmail());
        $(byText("Male")).click();
        $("#userNumber").setValue(testData.getUserNumber());
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(testData.getDateOfBirth()[1]);
        $(".react-datepicker__year-select").selectOption(testData.getDateOfBirth()[2]);
        $(String.format(".react-datepicker__day--0%s", testData.getDateOfBirth()[0])).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $x("//label[contains(., 'Sports')]").click();
//        $("#uploadPicture").uploadFromClasspath("starPhoto.jpg");
        $("#currentAddress").setValue(testData.getCurrentAddress());
        $("#state #react-select-3-input").setValue("Haryana").pressEnter();
        $("#city #react-select-4-input").setValue("Panipat").pressEnter();
        $("#submit").scrollTo();
        $("#submit").click();
        return this;
    }

    @Step("Проверить поля на странице Demoqa")
    public PracticeFormPage checkStudentRegistrationForm(TestData testData) {
        $(".modal-content").shouldHave(
                text("Thanks for submitting the form"),
                text(String.format("%s %s", testData.getFirstName(), testData.getLastName())),
                text(testData.getUserEmail()),
                text("Male"),
                text(testData.getUserNumber()),
                text(String.format("%s %s,%s",
                        testData.getDateOfBirth()[0],
                        testData.getDateOfBirth()[1],
                        testData.getDateOfBirth()[2])),
                text("English"),
                text("Sports"),
                text(testData.getCurrentAddress()),
                text("Haryana Panipat")
        );
        return this;
    }
}