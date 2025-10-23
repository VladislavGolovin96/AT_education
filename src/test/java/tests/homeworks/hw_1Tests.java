package tests.homeworks;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

//TODO
// Разработать автотест на проверку формы: https://demoqa.com/automation-practice-form
// Необходимо заполнить все поля, а не только обязательные

public class hw_1Tests {
    @BeforeAll
    public static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTest() {
        open("automation-practice-form");

        executeAsyncJavaScript("$(#fixedban).remove()");
        executeAsyncJavaScript("$('footer').remove()");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Vladislav");
        $("#lastName").setValue("Golovin");
        $("#userEmail").setValue("Golovin@gmail.com");
//        $(byText("Male")).click(); //  1 вариация. Не универсальный из-за привязки к тексту
//        $("#gender-radio-1").parent().click(); // 2 вариация
        $("#genterWrapper").$(byText("Female")).click(); //3 вариация. Является лучшей в использовании
        $("#userNumber").setValue("89370094524");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside)").click();
        $("#uploadPicture").uploadFile(new File("/Users/vladislavgolovin/Desktop/a.png"));
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Sports")).click();
        $("#currentAddress").setValue("Kazan");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

    }
}
