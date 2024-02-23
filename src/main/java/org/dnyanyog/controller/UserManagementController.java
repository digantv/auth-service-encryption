package org.dnyanyog.controller;

import org.dnyanyog.dto.UserData;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {

	@Autowired
	UserManagementService userService;

	@PostMapping(path = "/api/auth/user", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public UserResponse adduser(@RequestBody UserRequest addUserRequest) throws Exception {
		return userService.adduser(addUserRequest);

	}

	@GetMapping(path = "/api/auth/user/{userId}")
	public UserData getSingleUser(@PathVariable Long userId) {
		return userService.getSingleUser(userId);
	}
}
