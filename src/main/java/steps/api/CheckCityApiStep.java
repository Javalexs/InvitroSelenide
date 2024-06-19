package steps.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static spec.Specification.requestSpec;

public class CheckCityApiStep {

    // Экземляр ответа на запрос
    Response response;

    @Given("Отправить запрос и получить ответ запроса с параметром {string}")
    public void checkCityTest(String code) {
        response = given()
                .spec(requestSpec())
                .when()
                .get("/local/ajax/current-city.php?CODE=" + code);
    }

    @Then("Проверить код ответа {string} и тело ответа с параметрами {string}, {string}")
    public void assertBodyAndCodeResponse(String statusCode, String expectedCity, String expectedCode) {
        String notEqual = " в теле запроса не совпадает с ожидаемым";
        assertAll(
                () -> assertEquals(response.jsonPath().getString("city"), expectedCity, "Город" + notEqual),
                () -> assertEquals(response.jsonPath().getString("code"), expectedCode, "Код" + notEqual),
                () -> assertNotNull(response.jsonPath().getString("guid"), "GUID равен нулю"),
                () -> assertEquals(response.getStatusCode(), Integer.parseInt(statusCode), "Cтатус-код" + notEqual)
        );
    }
}
