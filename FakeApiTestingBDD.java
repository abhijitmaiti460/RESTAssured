package com.ibm.climate;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class FakeApiTestingBDD {
	
	@Test
	public void GetData() {
		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.given()
		 	.when()
		 	.get("/stocks")
		.then()
			.statusCode(200)
			.log().body();		
	}
	
	@Test(priority = 1)
	public void PostData() {
		JSONObject jsonObjectData = new JSONObject();
		jsonObjectData.put("id", 16);
		jsonObjectData.put("name", "Dodge");
		jsonObjectData.put("price", 234.45);
		
		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.given()
			.when()
			.body(jsonObjectData.toString())
			.post("/stocks")
		.then()
			.statusCode(201);	
	}
	
	@Test(priority = 2)
	public void PutData() {
		JSONObject jsonObjectData = new JSONObject();
		jsonObjectData.put("name", "Limo");
		jsonObjectData.put("price", 234.45);
		
		RestAssured.given()
				.when()
				.body(jsonObjectData.toString())
				.put("/stocks/15")
			.then()
				.statusCode(200);
		
	}
	
	@Test(priority = 3)
	public void PatchData() {
		JSONObject jsonObjectData = new JSONObject();
		jsonObjectData.put("name", "Citron");
		
		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.given()
			.when()
			.body(jsonObjectData.toString())
			.patch("/stocks/9")
		.then()
			.statusCode(200);	
	}
	
	@Test(priority = 4)
	public void DeleteData() {
		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.given()
	 		.when()
	 		.delete("/stock/1")
	 	.then()
	 		.statusCode(200);
		
	}
}

