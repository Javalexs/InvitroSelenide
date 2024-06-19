package ru.invitro;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@CucumberOptions(
        plugin = {"pretty", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm", "pretty", "json:target/cucumber-report/report.json"},
        features = "src/test/java/ru.invitro",
        glue = {"hooks", "steps"}
)

@RunWith(Cucumber.class)
public class CucumberRunnerTest {
}

