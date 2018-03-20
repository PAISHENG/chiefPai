package tw.com.pai.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tw.com.pai.model.User;
import tw.com.pai.service.UserService;

public class UserServiceTest {

	private static UserService userService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userService = new UserService();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		userService = null;

	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testGetUserById() {
//		User user = userService.getUserById(2);
//		Assert.assertNotNull(user);
//		System.out.println(user);
//	}
//
//	@Test
//	public void testGetAllUsers() {
//		List<User> users = userService.getAllUsers();
//		Assert.assertNotNull(users);
//		for (User user : users) {
//			System.out.println(user);
//		}

//	}

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setEmailId("test_email_" + System.currentTimeMillis() + "@gmail.com");
		user.setPassword("secret");
		user.setFirstName("TestFirstName");
		user.setLastName("TestLastName");

		userService.insertUser(user);
		System.out.println(user.getId());
		Assert.assertTrue(user.getId() != 0);
		User createdUser = userService.getUserById(user.getId());
		Assert.assertNotNull(createdUser);
		Assert.assertEquals(user.getEmailId(), createdUser.getEmailId());
		Assert.assertEquals(user.getPassword(), createdUser.getPassword());
		Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
		Assert.assertEquals(user.getLastName(), createdUser.getLastName());

	}

	@Test
	public void testUpdateUser() {
		long timestamp = System.currentTimeMillis();
		User user = userService.getUserById(2);
		System.out.println(user);
		user.setFirstName("TestFirstName" + timestamp);
		user.setLastName("TestLastName" + timestamp);
		userService.updateUser(user);
		User updatedUser = userService.getUserById(2);
		Assert.assertEquals(user.getFirstName(), updatedUser.getFirstName());
		Assert.assertEquals(user.getLastName(), updatedUser.getLastName());
	}

	@Test
	public void testDeleteUser() {
		User user = userService.getUserById(1);
		userService.deleteUser(user.getId());
		User deletedUser = userService.getUserById(1);
		Assert.assertNull(deletedUser);

	}

}
