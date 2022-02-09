package service;

public class UsersResources {

	private static final String BASIC_URL = "https://reqres.in";
	private static final String USERS = "/api/users";

	public String createUser() { return BASIC_URL + USERS; }

	public String deleteUser() { return BASIC_URL + USERS; }
}
