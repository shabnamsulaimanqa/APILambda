package com.rest.api;

import Util.GetConfigProp;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RestHelper extends GetConfigProp{
    GetConfigProp getProp = new GetConfigProp();
    RequestSpecification httpRequest = given();

    public RestHelper() throws IOException {

    }

    @Test
    public void getMethod() {
        System.out.println(getProp.getUrl());
        RestAssured.baseURI = getProp.getUrl();
        Response getResponse;
        getResponse= given().when().get(getUrl()+"myname6").thenReturn();
//        RequestSpecification httpRequest = given();
//        Response response = httpRequest.get("username6");
        System.out.println("Response is" + getResponse.getBody().prettyPrint());

    }

    @Test
    public void postMethod() {
        JSONObject reqParams= new JSONObject(payload);
        httpRequest.header("Content-Type", "application/json");

       Response response =httpRequest.header("Content-Type", "application/json").and().body(reqParams.toString()).when().post(getUrl()).then().extract().response();
        System.out.println("this is post response" +response.getBody().prettyPrint());
    }
    @Test
    public void deleteMethod(){


    }
}