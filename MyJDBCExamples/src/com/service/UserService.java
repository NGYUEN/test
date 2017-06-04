package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;
import com.util.DataSourceUtils;

public class UserService {
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user) {
		String sql = "INSERT INTO user(name) VALUES(?)";
		try(Connection connection = DataSourceUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, user.getUserName());
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 基于ID查询
	 * @param id
	 * @return
	 */
	public User getUser(int id) {
		User user = null;
		String sql = "SELECT * FROM user WHERE id=?";
		try(Connection connection = DataSourceUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			try(ResultSet resultSet = statement.executeQuery()) {
				user = new User();
				while (resultSet.next()) {
					user.setId(resultSet.getInt("id"));
					user.setUserName(resultSet.getString("name"));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
	
	/**
	 * 列出全部用户
	 * @return
	 */
	public List<User> listUsers() {
		List<User> users = null;
		String sql = "SELECT * FROM user";
		try(Connection connection = DataSourceUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			try(ResultSet resultSet = statement.executeQuery()) {
				users = new ArrayList<>();
				while (resultSet.next()) {
					User user = new User();
					user.setId(resultSet.getInt("id"));
					user.setUserName(resultSet.getString("name"));
					users.add(user);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return users;
	}
}
