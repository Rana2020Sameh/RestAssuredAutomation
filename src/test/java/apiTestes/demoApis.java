package apiTestes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class demoApis {

    //different ways to validate status code
    @Test
    public void test_1()
    {
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                log().all();
    }

    @Test
    public void test_2()
    {
        Response res= RestAssured.get("https://reqres.in/api/users?page=2");
        Assert.assertEquals(res.statusCode(),200);
    }
    @Test
    public void test_3() {
       given().
               get("https://reqres.in/api/users/2").
               then().
assertThat().
             //  body("data[1].id", equalTo(8)).
               and().
               assertThat().
               body("data[3].first_name",equalTo("Byron")).
               and().
               assertThat().
               body("data[3].last_name",equalTo("")).

               log().all();

    }
}
