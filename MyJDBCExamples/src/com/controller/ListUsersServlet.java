package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.UserService;


@WebServlet("/ListUsersServlet")
public class ListUsersServlet extends HttpServlet {
	private UserService userService = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> users = userService.listUsers();
		for (User u : users) {
			System.out.println(u.getId() + "/" + u.getUserName());
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private static final long serialVersionUID = 1L;
	  
    public ListUsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
}
