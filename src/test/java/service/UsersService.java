package service;

import model.CreateUserRqst;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersService {
	private static final UsersResources resources = new UsersResources();

	public <T> T toSdkObject(Response response, Class<T> aClass) {
		return response.body().as(aClass);
	}

	public Response createUser(CreateUserRqst createUserRqst) {
		return given()
			.contentType(ContentType.JSON)
			.body(createUserRqst)
			.when()
			.post(resources.createUser())
			.then()
			.extract().response();
	}

	public Response deleteUser(String id) {
		return given()
			.contentType(ContentType.JSON)
			//.pathParam("id", id)
			.when()
			.delete(resources.deleteUser())
			.then()
			.extract().response();
	}
}
