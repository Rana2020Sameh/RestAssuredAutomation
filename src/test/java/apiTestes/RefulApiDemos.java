package apiTestes;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
public class RefulApiDemos {
    @Test
    public void Registration()
    {
        Map<String,Object>map=new HashMap<String,Object>();
        map.put("email","eve.holt@reqres.in");
      //  map.put("password","pistol");
        JSONObject jso=new JSONObject(map);
        System.out.println(jso.toJSONString());
       baseURI="https://reqres.in/";
       given().header("Content-type","application/json").
        contentType(ContentType.JSON).accept(ContentType.JSON).
               body(jso.toJSONString()).
               when().
               post("/api/register").
               then().
               statusCode(400).
               log().all();
    }

    @Test
    public void createUser()
    {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name","morpheus");
        map.put("job","leader");
        JSONObject ob=new JSONObject(map);
        System.out.println(ob.toJSONString());
        baseURI="https://reqres.in/";
        given().header("Content-type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(ob.toJSONString()).
                when().
                post("/api/users").
                then().
                statusCode(201).
                log().all();
    }

    @Test
    public void loginUser()
    {

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("email","eve.holt@reqres.in");
       // map.put("password","cityslicka");
        JSONObject ob=new JSONObject(map);
        System.out.println(ob.toJSONString());
        baseURI="https://reqres.in/";
        given().header("Content-type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(ob.toJSONString()).
                when().
                post("/api/login").
                then().
                statusCode(400).
                log().all();
    }

    @Test
    public void putUser()
    {
        Map<String,Object>map=new HashMap<String,Object>();
        map.put("name","morpheus");
        map.put("job","zion resident");
        JSONObject re=new JSONObject(map);
        System.out.println(re.toJSONString());
        baseURI="https://reqres.in";
        given().
                header("Content-type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(re.toJSONString()).
                put("/api/users/2").
                then().statusCode(200).log().all();
    }

    @Test
    public void patchUsers()
    {
        Map<String,Object>m=new HashMap<String,Object>();
        m.put("name","Js");
        m.put("job","TL");
        JSONObject jso=new JSONObject(m);
        System.out.println(jso.toJSONString());
        baseURI="https://reqres.in";
        given().header("Content-type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(jso.toJSONString()).
                patch("/api/users/2").
                then().
                statusCode(200).
                log().all();

    }

    @Test
    public void deletUser()
    {
        baseURI="https://reqres.in";
        given().when().
                delete("/api/users/2").
                then().
                statusCode(204).
                log().all();
    }
    @Test
    public void getUser()
    {
        baseURI="https://reqres.in";
        given().
                when().
                get("/api/unknown/2").
                then().
                statusCode(200).log().all();
    }
}
