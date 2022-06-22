package soapReq;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
//for checks
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SoapXmlRequests {


    @Test
    public void validateSoapRe() throws IOException {

        File file=new File("./soapreq/add.xml.txt");
        if (file.exists())
        System.out.println(">> File Exists");
        FileInputStream filee=new FileInputStream(file);
        String reqbody= IOUtils.toString(filee,"UTF-8");
       baseURI="https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService";
       given().
               contentType("text/xml").accept(ContentType.XML).
               body(reqbody).
               when().
               post("/Calc.asmx").
               then().statusCode(500).
               log().
               all();



    }
}
