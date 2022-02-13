package practiceCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

	@Test
	public void createProject() {
		
		//step-1: create test data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Sanjeeb2");
		jobj.put("projectName", "DELLS");
		jobj.put("status", "Created");
		jobj.put("teamSize", 12);
		
		//step-2: provide request specification
		RequestSpecification req=RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		//step-3: perform Action
		Response resp=req.post("http://localhost:8084/addProject");
		
		//step-4: print in console and verify
		System.out.println(resp.asString());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.getContentType());
	}
	
	
	
}
