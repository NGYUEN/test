package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.UserService;


@WebServlet("/GetUserServlet")
public class GetUserServlet extends HttpServlet {
	private UserService userService = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = userService.getUser(1);
		System.out.println(user.getId() + "/" + user.getUserName());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private static final long serialVersionUID = 1L;
	   
    public GetUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
}
