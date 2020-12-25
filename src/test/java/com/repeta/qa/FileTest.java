package com.repeta.qa;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.io.FileNotFoundException;

import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static com.repeta.qa.ResourceMother.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FileTest {


    private Response givenUploadResponse;

    private Response givenDeleteResponse;

    private String fileId;

    @Test
    @Order(1)
    public void testUpload() throws FileNotFoundException {
        //System.out.println("Test 1");
        /*JSONObject params = new JSONObject();
        params.put("path","/kitten.jpeg");
        params.put("mode","add");
        params.put("autorename",true);
        params.put("mute",false);
        params.put("strict_conflict", false);

        givenUploadResponse = given_UploadResponse(params,new File("src/test/resources/kitten.jpeg"));

        fileId = givenUploadResponse.jsonPath().get("id");

        givenUploadResponse
            .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("upload-schema.json"));*/
    }

    @Test
    @Order(2)
    public void testGetFileMetadata(){
        System.out.println("Test 2");
        //System.out.println(fileId);
    }

    @Test
    @Order(3)
    public void testDelete(){
        System.out.println("Test 3");
        /*JSONObject params = new JSONObject();
        params.put("path","/kitten.jpeg");

        givenDeleteResponse = given_DeleteResponse(params);

        givenDeleteResponse
            .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("delete-schema.json"));*/
    }

}
