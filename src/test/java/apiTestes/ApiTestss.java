package apiTestes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTestss {

    @Test


    public void test1()
    {
        Response res= RestAssured.get("https://reqres.in/api/users?page=2");
      System.out.println(res.getStatusCode());
        System.out.println(res.getContentType());
        System.out.println(res.getBody().asString());
        System.out.println(res.getHeader("content-Type")) ;
        System.out.println(res.getTime());
        System.out.println(res.getBody().asString());
        System.out.println(res.getStatusLine());
        int statuscode=res.getStatusCode();
        Assert.assertEquals(statuscode,200);

    }


    @Test
    public void test2()
    {

        baseURI="https://reqres.in/";
                given().
                get("/api/users?page=2").
                then().
                statusCode(200).
                        body("data[1].id",equalTo(8)).
                        log().all();
    }

    @Test
    public void test3()
    {
        baseURI="https://reqres.in/api/";
        given().
                get("/users?page=2").
                then().
                statusCode(200).
                body("data[3].first_name",equalTo("Byron")).
                body("data.first_name",hasItems("Byron","Lindsay"));
    }


    @Test
    public void testPost()
    {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("name","Rana");
        map.put("job","QC");

        JSONObject re=new JSONObject(map);
        System.out.println(re.toJSONString());
        baseURI="https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(re.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).log().all();

    }

    @Test
    public void testPut()
    {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("name","Rana");
        map.put("job","QC");

        JSONObject re=new JSONObject(map);
        System.out.println(re.toJSONString());
        baseURI="https://reqres.in/api";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(re.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).
                log().
                all();
    }

    @Test

    public void testPatch()
    {
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("name","Rana");
        map.put("job","QC");

        JSONObject re=new JSONObject(map);
        System.out.println(re.toJSONString());
        baseURI="https://reqres.in/";
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(re.toJSONString()).
                when().
                patch("/api/users/2").
                then().
                statusCode(200).
                log().
                all();
    }

    @Test

    public void testDelete()
    {

        baseURI="https://reqres.in/";
        given().

                when().
                delete("/api/users/2").
                then().
                statusCode(204).
                log().
                all();
    }


    @Test(dataProvider = "testdata")
    public void getuserdata(String id,String email,String fname,String lname,String av ,String ur,String textt)
    {
        String ks=RestAssured.get("https://reqres.in/api/users/2").andReturn().asString();
        Assert.assertTrue(ks.contains(email));
        Assert.assertTrue(ks.contains(fname));
        Assert.assertTrue(ks.contains(lname));
      Assert.assertTrue(ks.contains(av));
        Assert.assertTrue(ks.contains(ur));
        Assert.assertTrue(ks.contains(textt));

    }

    @DataProvider
    public Object[][] testdata() throws IOException, InvalidFormatException {
    ReadData red=new ReadData();
    return red.readdata();
    }

}
