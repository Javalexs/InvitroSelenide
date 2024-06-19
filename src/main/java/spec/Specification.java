package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {
    public static RequestSpecification requestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri("https://www.invitro.ru/")
                .setContentType("application/json")
                .build();
    }
}
