package ua.travel.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {
	
	private String login;
	
	private String password;

	public LoginRequest() {
		super();
	}

	public LoginRequest(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	

}
