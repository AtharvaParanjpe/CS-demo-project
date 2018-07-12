package com.example.demo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.jayway.restassured.RestAssured.get;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CaseStudiesApplicationTests {
 @LocalServerPort
 private int serverPort;
 
 @Before
 public void init(){
 RestAssured.port = serverPort;
 } 
 /*
 @Test
 public void contextLoads() {
  given()
  .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE).
  when()
  .post("/place").
  then()
  .statusCode(200).assertThat().body("ticker", equalTo("AAPL"));
  //when().
  //post("/place").contentType(MediaType.APPLICATION_JSON).then().statusCode(200).assertThat().body("ticker", equalTo("AAPL"));
 } */
 
 	@Test
 	public void getTop5TradersListByValue() {
 		given()						//.auth().basic("admin", "admin")
 		.when().get("/top5/trade")
 		.then().statusCode(200);
 	}

	@Test
 	public void getTop5TradersListByVolume() {
 		given()						//.auth().basic("admin", "admin")
 		.when().get("/top5/volume")
 		.then().statusCode(200);
 	}
	
	@Test
 	public void checkIfTradeOpen() {
 		given()						//.auth().basic("admin", "admin")
 		.when().get("/update/orderId/1/quantity/300")
 		.then().statusCode(500);
 	}
	
	@Test
 	public void checkIfQuantityUpdated() {
 		given()						//.auth().basic("admin", "admin")
 			.pathParam("qty", 27)
 	        .when().get("/update/orderId/2/quantity/{qty}")
 	        .then().statusCode(200);
    
 	}
	
	@Test
 	public void checkIfTraderIdMatchesOpen() {
 		given()						//.auth().basic("admin", "admin")
 		.when().get("/update/orderId/2/traderId/153/orderType/0")
 		.then().statusCode(500);
 	}
	
	@Test
    public void checkIfTop5Shown() {

		
//      Response response =  given()
//        .when().get("/top5/trade")
//        .then().contentType(ContentType.JSON).extract().response();
//      
//      String jsonasString = response.asString();
//      List<String> traderIds = response.path("traderId");
//      String first = traderIds.get(0);
//      assertThat(first, equalTo(Integer.toString(8)));
				given()
				.when().get("/top5/trade")
				.then().body("traderId",contains(8,101));

      
    }

//  @Test
//   public void checkCompanyName()
//   {
//   given().auth().basic("admin", "admin")
//   .when().get("/companies")
//   .then().body(containsString("AAPL"));
//   }
//  @Test
//  public void placeOrder()
//  {
//   Map<String,String> order = new HashMap<>();
//   order.put("ticker", "AAPL");
//   order.put("traderId", Integer.toString(2));
//   order.put("quantity", Integer.toString(3));
//   order.put("price", Integer.toString(5));
//   order.put("validity", Integer.toString(3));
//   order.put("orderType", Integer.toString(0));
//   order.put("orderStatus", Integer.toString(0));
//   order.put("buySell", Integer.toString(0));
//   
//   given().auth().basic("admin", "admin")
//         .contentType("application/json")
//         .body(order)
//         .when().post("/companies").then()
//         .statusCode(200);
//  }
}