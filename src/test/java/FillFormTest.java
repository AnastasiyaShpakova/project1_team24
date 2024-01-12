import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anastasiya");
        $("#lastName").setValue("Shpakova");
        $("#userEmail").setValue("test1@bk.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9991002030");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__day--022").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("nature2.jpg");
        $("#currentAddress").setValue("Testing 12-35");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Anastasiya Shpakova"),
                text("test1@bk.ru"),
                text("Female"),
                text("9991002030"),
                text("22 September,1987"),
                text("Maths"),
                text("Music"),
                text("nature2.jpg"),
                text("Testing 12-35"),
                text("Haryana Panipat"));
    }

    //{
    //Configuration.holdBrowserOpen = true;
    //}
}
