package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER_TABLE")
public class CreateUserResp {

	public CreateUserResp() {
	}

	@Id
	@Column(name = "id", nullable = false, length = 150)
	private String id;

	@Column(name = "name", nullable = true, length = 150)
	private String name;

	@Column(name = "job", nullable = true, length = 150)
	private String job;

	@Column(name = "salary", nullable = true, length = 150)
	private String salary;

	@Column(name = "createdAt", nullable = true, length = 150)
	private String createdAt;

	public String getName() {
		return name;
	}

	public CreateUserResp setName(String name) {
		this.name = name;
		return this;
	}

	public String getJob() {
		return job;
	}

	public CreateUserResp setJob(String job) {
		this.job = job;
		return this;
	}

	public String getId() {
		return id;
	}

	public CreateUserResp setId(String id) {
		this.id = id;
		return this;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public CreateUserResp setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public String getSalary() {
		return salary;
	}

	public CreateUserResp setSalary(String salary) {
		this.salary = salary;
		return this;
	}

	@Override
	public String toString() {
		return "{" +
			"id=" + id +
			", Name='" + name + '\'' +
			", Job='" + job + '\'' +
			", Salary='" + salary + '\'' +
			'}';
	}
}
