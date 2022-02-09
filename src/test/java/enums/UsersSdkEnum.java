package enums;

public enum UsersSdkEnum {
	CREATE_USER_RQST("CreateUserRqst"),
	CREATE_USER_RESP("CreateUserResp");

	private String key;

	UsersSdkEnum(String key) {this.key = key;}

	public String getKey() {return key;}
}
