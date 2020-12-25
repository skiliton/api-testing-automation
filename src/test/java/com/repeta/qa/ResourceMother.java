package com.repeta.qa;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class ResourceMother {

    private static String accessToken = System.getProperty("api-test.dropbox.accessToken");

    private static RequestSpecification given_Authorized() {
        return given()
                .auth()
                    .oauth2(accessToken)
                .config(RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
    }

    public static Response given_UploadResponse(JSONObject params, File file) throws FileNotFoundException {
        return given_Authorized()
                .header("Dropbox-API-Arg", params.toString())
                .contentType(ContentType.BINARY)
                .body(new FileInputStream(file))
                .request("POST", "https://content.dropboxapi.com/2/files/upload");
    }



    public static Response given_GetFileMetadataResponse(JSONObject params){
        return given_Authorized()
                .contentType(ContentType.JSON)
                .body(params.toString())
                .request("https://api.dropboxapi.com/2/sharing/get_file_metadata");
    }

    public static Response given_DeleteResponse(JSONObject params){
        return given_Authorized()
                .contentType(ContentType.JSON)
                .body(params.toString())
                .request("https://api.dropboxapi.com/2/files/delete_v2");
    }

}
