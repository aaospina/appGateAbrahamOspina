package utils;

import enums.UsersEndpointsEnum;
import enums.UsersSdkEnum;
import io.restassured.response.Response;
import model.CreateUserResp;

import java.util.HashMap;
import java.util.Map;

public class UsersAPIContextManager {
	private static Map<UsersSdkEnum, Object> sdkManager = new HashMap<>();
	private static Map<UsersEndpointsEnum, Response> responseManager = new HashMap<>();
	private static String temporalValue = null;
	private static CreateUserResp userResp = new CreateUserResp();

	public static Object getSdkManager(UsersSdkEnum key) {
		if (!sdkManager.containsKey(key)) {
			throw new RuntimeException("Cannot get object from context with key: " + key.getKey());
		}
		return sdkManager.get(key);
	}

	public static void setSdkManager(UsersSdkEnum key, Object object) {
		sdkManager.put(key, object);
	}

	public static Response getResponseManager(UsersEndpointsEnum key) {
		if (!responseManager.containsKey(key)) {
			throw new RuntimeException("Cannot get response from context with key: " + key.getKey());
		}
		return responseManager.get(key);
	}

	public static void setResponseManager(UsersEndpointsEnum key, Response response) {
		responseManager.put(key, response);
	}

	public static String getTemporalValueContext() {
		return temporalValue;
	}

	public static void setTemporalValueContext(String temporalValue) {
		UsersAPIContextManager.temporalValue = temporalValue;
	}

	public static CreateUserResp getUserRespContext() {
		return userResp;
	}

	public static void setUserRespContext(CreateUserResp userResp) {
		UsersAPIContextManager.userResp = userResp;
	}
}
