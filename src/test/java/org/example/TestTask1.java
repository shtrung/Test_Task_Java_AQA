package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.everyItem;

public class TestTask1 {

    private static RequestSpecification request;
    public static ResponseSpecification response;

    @BeforeAll
    public static void init(){
        RestAssured.baseURI = "https://reqres.in/api";

        request = RestAssured.given()
                .contentType(ContentType.JSON);

        response = RestAssured.expect()
                .contentType(ContentType.JSON);
    }

    @Test
    public void testSuccessfulRegistration(){
        given(request)
                .body("""
                        {"email": "eve.holt@reqres.in",
                        "password": "pistol"}
                        """)
                .when()
                .post("/register")
                .then()
                .statusCode(200);
    }

    @Test
    public void testUnsuccessfulRegistration(){
        given(request)
                .body("""
                        {"email": "eve.holt@reqres.in"}
                        """)
                .when()
                .post("/register")
                .then()
                .statusCode(400);
    }
    @Test
    public void testGetUsersEmailDomain() {
        given(request)
                .when()
                .get("/users?page=1")
                .then()
                .spec(response)
                .statusCode(200)
                .body("data.email", everyItem(endsWith("@reqres.in")));
    }

    @Test
    public void testDeleteUserById(){
        given(request)
                .when()
                .delete("/users/2")
                .then()
                .statusCode(204);
    }
}
