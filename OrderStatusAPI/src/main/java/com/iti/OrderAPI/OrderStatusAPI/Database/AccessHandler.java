package com.iti.OrderAPI.OrderStatusAPI.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iti.OrderAPI.OrderStatusAPI.Model.Order;
import com.iti.OrderAPI.OrderStatusAPI.Model.User;

public class AccessHandler {

	public static int verifyLogin(String username, String password) {
		boolean invalidLogin = false;
		String fetchedName = "";
		ResultSet result;

		try {

			PreparedStatement pst2 = DataBaseConnector.connection
					.prepareStatement("select * from users where uname = ? and password = ?");
			pst2.setString(1, username);
			pst2.setString(2, password);
			result = pst2.executeQuery();
			while (result.next()) {

				fetchedName = result.getString(3);

			}
			if (fetchedName.equals("")) {
				invalidLogin = true;

			}

			if (invalidLogin) {
				return 0;
			} else {

				return 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static List<Order> getOrderStatus(String userName) {
		ResultSet result;
		Order order ;
		int userId=0;
		List<Order> orders = new ArrayList<Order>();
		try {

			PreparedStatement pst2 = DataBaseConnector.connection
					.prepareStatement("select id from users where uname = ? ");
			pst2.setString(1, userName);

			result = pst2.executeQuery();
			while (result.next()) {
				userId = result.getInt(1);
			}
			pst2 = DataBaseConnector.connection.prepareStatement("select billno,datee,state from orders where user_id=?");
			pst2.setInt(1, userId);
			result = pst2.executeQuery();
			while(result.next()) {
				order = new Order();
				order.setOrderNumber(result.getInt("billno"));
				order.setOrderDate(result.getDate("datee").toString());
				order.setOrderStatus(result.getInt("state"));
				
				orders.add(order);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
