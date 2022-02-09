package common;

import database.UserRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.UsersService;

public abstract class UsersApiStepBase {

	protected UserRepository repository = new UserRepository("user_pu_test");

	protected UsersService usersService = new UsersService();
	protected Logger logger = LogManager.getLogger(getClass());
	protected void loggerStep(String stepMsg) {
		logger.log(Level.getLevel("STEP"), stepMsg);
	}

}
