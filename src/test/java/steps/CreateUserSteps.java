package steps;

import database.UserRepository;
import io.cucumber.datatable.DataTable;
import model.CreateUserResp;
import model.CreateUserRqst;
import common.UsersApiStepBase;
import enums.UsersEndpointsEnum;
import enums.UsersSdkEnum;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static builders.CreateUserBuilder.aUser;
import static utils.UsersAPIContextManager.*;

public class CreateUserSteps extends UsersApiStepBase {

	@Given("{string} is a {string} with a salary of {string}")
	public void createCreateUserRqst(String name, String role, String salary) {
		CreateUserRqst createUserRqst = aUser()
			.withName(name)
			.withRole(role)
			.withSalary(salary)
			.build();
		setSdkManager(UsersSdkEnum.CREATE_USER_RQST, createUserRqst);
	}

	@When("I send the information to create the user in the platform")
	public void createUser() {
		CreateUserRqst createUserRqst = (CreateUserRqst) getSdkManager(UsersSdkEnum.CREATE_USER_RQST);
		Response response = usersService.createUser(createUserRqst);
		setResponseManager(UsersEndpointsEnum.CREATE_USER, response);
		CreateUserResp createUserResp = usersService.toSdkObject(response, CreateUserResp.class);

		// Persist user in database
		if (response.statusCode() == HttpStatus.SC_CREATED) {
			repository = new UserRepository("user_pu_test");
			repository.addUser(createUserResp);
			System.out.println(createUserResp.toString());
			setUserRespContext(createUserResp);
		}
	}

	@Then("the user will be created")
	public void verifyCreatedUser() {
		SoftAssertions softAssertions = new SoftAssertions();

		CreateUserRqst createUserRqst = (CreateUserRqst) getSdkManager(UsersSdkEnum.CREATE_USER_RQST);
		Response response = getResponseManager(UsersEndpointsEnum.CREATE_USER);

		CreateUserResp createUserResp = usersService.toSdkObject(response, CreateUserResp.class);

		softAssertions.assertThat(response.statusCode()).as("status code").isEqualTo(HttpStatus.SC_CREATED);
		softAssertions.assertThat(createUserResp.getName()).as("name").isEqualTo(createUserRqst.getName());
		softAssertions.assertThat(createUserResp.getJob()).as("job").isEqualTo(createUserRqst.getJob());

		// Validate user in database
		if (response.statusCode() == HttpStatus.SC_CREATED) {
			CreateUserResp userInDb = repository.find(createUserResp.getId());
			softAssertions.assertThat(userInDb.getId()).as("id").isNotNull();
			softAssertions.assertThat(userInDb.getName()).as("name").isEqualTo(createUserResp.getName());
			softAssertions.assertThat(userInDb.getJob()).as("job").isEqualTo(createUserResp.getJob());
			softAssertions.assertThat(userInDb.getSalary()).as("salary").isEqualTo(createUserResp.getSalary());
		}
		softAssertions.assertAll();
	}

	@Given("the user has been created")
	public void createUsers(DataTable user) {
		List<String> data = user.row(1);
		createCreateUserRqst(data.get(0), data.get(1), data.get(2));
		createUser();
	}
}
