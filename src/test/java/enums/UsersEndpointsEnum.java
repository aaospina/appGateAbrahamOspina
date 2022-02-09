package enums;

public enum UsersEndpointsEnum {
	CREATE_USER("createUser"),
	DELETE_USER("deleteUser");

	private String key;

	UsersEndpointsEnum(String key) { this.key = key; }

	public String getKey() { return key;}
}
