package com.repeta.qa;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;

import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static com.repeta.qa.ResponseMother.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FileTest {


    private static Response givenUploadResponse;

    private static Response givenGetFileMetadataResponse;

    private static Response givenDeleteResponse;

    private static String fileId;

    @Test
    @Order(1)
    public void assertUploadResponseHasCorrectSchema() throws FileNotFoundException {
        JSONObject params = new JSONObject();
        params.put("path","/kitten.jpeg");
        params.put("mode","add");
        params.put("autorename",true);
        params.put("mute",false);
        params.put("strict_conflict", false);

        givenUploadResponse = given_UploadResponse(params,new File("src/test/resources/kitten.jpeg"));
        fileId = new JSONObject(givenUploadResponse.asString()).getString("id");
        givenUploadResponse
            .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("upload-schema.json"));
    }

    @Test
    @Order(2)
    public void assertGetFileMetadataResponseHasCorrectSchema(){
        JSONObject params = new JSONObject();
        params.put("file",fileId);
        params.put("actions", Collections.emptyList());

        givenGetFileMetadataResponse = given_GetFileMetadataResponse(params);
        givenGetFileMetadataResponse
            .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("get-file-metadata-schema.json"));
    }

    @Test
    @Order(3)
    public void assertDeleteResponseHasCorrectSchema(){
        JSONObject params = new JSONObject();
        params.put("path","/kitten.jpeg");

        givenDeleteResponse = given_DeleteResponse(params);
        givenDeleteResponse
            .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("delete-schema.json"));
    }
}
