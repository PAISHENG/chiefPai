package tw.com.pai.model.mybatis;

import java.io.Serializable;

public class MUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -983945608574136L;


	private Integer id;
	private String firstName;
	private String lastName;
	private String email;

	public MUser() {
		
	}

	public MUser(Integer id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
