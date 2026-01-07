package com.ibm.climate;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FakeApiTestingNonBDD {

	@Test
	public void GetData() {
		RestAssured.baseURI = "http://localhost:3000/";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("stocks");
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.body().asPrettyString());
	}

	@Test(priority = 2)
	public void GetDataForParticular() {
		RestAssured.baseURI = "http://localhost:3000/";
		RequestSpecification request = RestAssured.given();
		Response response = request.queryParam("name", "MINI").get("/stocks");
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.body().asPrettyString());
	}

	@Test(priority = 3)
	public void PutData() {
		JSONObject jsonObjectData = new JSONObject();
		jsonObjectData.put("name", "HM");
		jsonObjectData.put("price", 234.45);
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification request = RestAssured.given();
		Response response = request.body(jsonObjectData.toString()).put("/stocks/5");
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.body().asPrettyString());

	}
	
	@Test(priority = 4)
	public void PatchData() {
		JSONObject jsonObjectData = new JSONObject();
		jsonObjectData.put("name", "Citron");
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification request = RestAssured.given();
		Response response = request.body(jsonObjectData.toString()).patch("/stocks/5");
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.body().asPrettyString());

	}
	
	@Test(priority = 1)
	public void HeadData() {
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification request = RestAssured.given();
		Response response = request.head("/stocks");
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.headers());
	}

	@Test(priority = 5)
	public void PostData() {
		JSONObject jsonObjectData = new JSONObject();
		jsonObjectData.put("id", 11);
		jsonObjectData.put("name", "Lexus");
		jsonObjectData.put("price", 234.45);
		RestAssured.baseURI = "http://localhost:3000/";
		RequestSpecification request = RestAssured.given();
		Response response = request.body(jsonObjectData.toString()).post("/stocks");
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.body().asPrettyString());

	}

	@Test(priority = 6)
	public void DeleteData() {
		RestAssured.baseURI = "http://localhost:3000/";
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("stocks/5");
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.body().asPrettyString());
	}

}
