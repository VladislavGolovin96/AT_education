package tests.git;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        //План действий
        // открыть страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из выдачи
        $$("[data-testid='results-list']").first().$("a").click();
        // перейти в раздел Wiki
        $("[data-content='Wiki']").click();
        // Убедиться, что в pages присутствует страница soft assertions
        $(".markdown-body").shouldHave(text("Soft assertions"));
        // перейти по ссылке soft assertions
        $(byText("Soft assertions")).click();
        // убедить что на странице есть пример кода для junit 5
        $(".markdown-body").shouldHave(text("3. Using JUnit5 extend test class:"));
        sleep(5000);


    }
}
