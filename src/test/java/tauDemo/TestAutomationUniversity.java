package tauDemo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.stream.Location;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;


public class TestAutomationUniversity {
    private static RequestSpecification requestSpec;


@BeforeTest
        public static void createRequestSpecification() {

    requestSpec = new RequestSpecBuilder().
            setBaseUri("http://api.zippopotam.us").

            build();
    }



    @Test
    public void testReq()
    {
                given().contentType(ContentType.XML).
                        accept(ContentType.XML).
                        spec(requestSpec).
                        when().
                        log().body().
                        get("us/90210").


                        then().statusCode(200).and().
                      //  assertThat().body("response.places.place.findAll{it.stateAbbreviation!='SH'}",empty()).
                        log().all();


    }

    }
