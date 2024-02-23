package org.dnyanyog.services;

import java.util.List;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	UsersRepository userRepo;

	public LoginResponse validateUser(LoginRequest loginRequest) {

		LoginResponse response = new LoginResponse();

		List<Users> liuser = userRepo.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());

		if (liuser.size() == 1) {
			response.setStatus("Success");
			response.setMessage("Login Successful");
		} else {
			response.setStatus("Fail");
			response.setMessage("Login Failed!");
		}
		return response;
	}
}
