package model;

import java.io.Serializable;

public class CreateUserRqst implements Serializable {

	private String name;
	private String job;
	private String salary;

	public String getName() {
		return name;
	}

	public CreateUserRqst setName(String name) {
		this.name = name;
		return this;
	}

	public String getJob() {
		return job;
	}

	public CreateUserRqst setRole(String job) {
		this.job = job;
		return this;
	}

	public String getSalary() {
		return salary;
	}

	public CreateUserRqst setSalary(String salary) {
		this.salary = salary;
		return this;
	}
}
