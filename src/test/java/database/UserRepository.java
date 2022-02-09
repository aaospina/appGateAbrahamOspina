package database;

import model.CreateUserResp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserRepository {

	private EntityManager entityManager;
	private EntityManagerFactory eMf;

	public UserRepository() {
		eMf = Persistence.createEntityManagerFactory("user_pu");
		this.entityManager = this.eMf.createEntityManager();
	}

	public UserRepository(String pu) {
		eMf = Persistence.createEntityManagerFactory(pu);
		this.entityManager = this.eMf.createEntityManager();
	}

	public CreateUserResp addUser(CreateUserResp user) {
		entityManager.getTransaction().begin();
		entityManager.merge(user);
		System.out.println(user.toString());
		entityManager.getTransaction().commit();
		return user;
	}

	public CreateUserResp find(String id) {
		return entityManager.find(CreateUserResp.class, id);
	}

	public CreateUserResp update(CreateUserResp user) {
		CreateUserResp userToUpdate = find(user.getId());
		entityManager.getTransaction().begin();
		userToUpdate.setName(user.getName());
		userToUpdate.setSalary(user.getSalary());
		entityManager.getTransaction().commit();
		return userToUpdate;
	}

	public void delete(CreateUserResp user) {
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(user));
		entityManager.getTransaction().commit();
	}

	public void close() {
		this.entityManager.close();
		this.eMf.close();
	}
}
