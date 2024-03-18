package com.blackbox.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;


public class APIUtils {

    public static RequestSpecification request;

    public static Response sendGetRequest(String url){
        return request
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendGetRequest(String url, Map<String,String> queryParams){
        return request
                .contentType(ContentType.JSON)
                .queryParams(queryParams)
                .when()
                .get(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendGetRequest(String url, Object payload){
        return request
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .get(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendGetRequest(String url, String[] pathParams){
        return request
                .contentType(ContentType.JSON)
                .pathParam(pathParams[0],pathParams[1])
                .when()
                .get(url +"/{" + pathParams[0] +"}")
                .then().log().all()
                .extract().response();
    }
    public static Response sendPostRequest(String url, Map<String,String> queryParams){
        return request
                .contentType(ContentType.JSON)
                .queryParams(queryParams)
                .when()
                .post(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendPostRequest(String url, Object payload){
        return request
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendPostRequest(String url, Map<String,String> queryParams,Object payload){
        return request
                .contentType(ContentType.JSON)
                .queryParams(queryParams)
                .when()
                .body(payload)
                .post(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendPostRequest(String url, String[] pathParams,Object payload){
        return request
                .contentType(ContentType.JSON)
                .pathParam(pathParams[0],pathParams[1])
                .when()
                .body(payload)
                .post(url + "/{" + pathParams[0] + "}")
                .then().log().all()
                .extract().response();
    }
    public static Response sendPostRequest(String url){
        return request
                .contentType(ContentType.JSON)
                .when()
                .post(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendPutRequest(String url,Object payload){
        return request
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put(url)
                .then().log().all()
                .extract().response();
    }
    public static Response sendPutRequest(String url,Object payload,Map<String,String> queryParams) {
        return request
                .contentType(ContentType.JSON)
                .body(payload)
                .queryParams(queryParams)
                .when()
                .put(url)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response sendPutRequest(String url,Object payload,Object[] pathParameters) {
        return request
                .contentType(ContentType.JSON)
                .body(payload)
                .pathParam(String.valueOf(pathParameters[0]),String.valueOf(pathParameters[1]))
                .when()
                .put(url + "/{"+pathParameters[0]+"}")
                .then()
                .log().all()
                .extract().response();
    }
    public static Response sendPutRequest(String url,Object[] pathParameters) {
        return request
                .contentType(ContentType.JSON)
                .pathParam(String.valueOf(pathParameters[0]),String.valueOf(pathParameters[1]))
                .when()
                .put(url + "/{"+pathParameters[0]+"}")
                .then()
                .log().all()
                .extract().response();
    }
    public static Response sendPutRequest(String url,Object payload,Map<String,String> queryParams,String[] pathParameters) {
        return request
                .pathParam(pathParameters[0],pathParameters[1])
                .contentType(ContentType.JSON)
                .body(payload)
                .queryParams(queryParams)
                .when()
                .put(url + "/{"+pathParameters[0]+"}")
                .then()
                .log().all()
                .extract().response();
    }

    public static Response sendPutRequest(String url,Object payload,String key) {
        return request
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put(url + "/key")
                .then()
                .log().all()
                .extract().response();
    }

    public static Response sendPostRequest(String url, String key){
        return request
                .header("X-Atlassian-Token", "no-check")
                .contentType(ContentType.MULTIPART)
                .multiPart("file", new File("C:\\Users\\Gürkan\\Desktop\\Screenshot_4.png"))
                .when()
                .post(url + "/" + key + "/attachments" )
                .then().log().all()
                .extract().response();
    }

    public static Response sendPostRequest(String url, String key, String fileName){
        return request
                .header("X-Atlassian-Token", "no-check")
                .contentType(ContentType.MULTIPART)
                .multiPart("file", new File(System.getProperty("user.dir") + "/src/test/resources/attachment/" + fileName))
                .when()
                .post(url + "/" + key + "/attachments" )
                .then().log().all()
                .extract().response();
    }
    public static Response sendDeleteRequest(String url, String[] pathParam){
        return request
                .contentType(ContentType.JSON)
                .when()
                .pathParams(pathParam[0],pathParam[1])
                .delete(url + "/{" + pathParam[0] + "}")
                .then()
                .extract().response();
    }
    public static Response sendDeleteRequest(String url, String[] pathParam,Map<String,Boolean> queryParams){
        return request
                .contentType(ContentType.JSON)
                .when()
                .pathParams(pathParam[0],pathParam[1])
                .queryParams(queryParams)
                .delete(url + "/{" + pathParam[0] + "}")
                .then()
                .extract().response();
    }
    
      public static Response sendDeleteRequest(String endpoint){
        return request.when()
                .delete(endpoint);
      
    }
}