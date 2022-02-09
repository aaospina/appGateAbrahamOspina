package builders;

import model.CreateUserRqst;

public class CreateUserBuilder {

	private CreateUserRqst createUserRqst;

	private CreateUserBuilder() {
		createUserRqst = new CreateUserRqst();
	}

	public static CreateUserBuilder aUser() {
		return new CreateUserBuilder();
	}

	public CreateUserBuilder withName(String name) {
		this.createUserRqst.setName(name);
		return this;
	}

	public CreateUserBuilder withRole(String role) {
		this.createUserRqst.setRole(role);
		return this;
	}

	public CreateUserBuilder withSalary(String salary) {
		this.createUserRqst.setSalary(salary);
		return this;
	}

	public CreateUserRqst build() {
		return createUserRqst;
	}
}
