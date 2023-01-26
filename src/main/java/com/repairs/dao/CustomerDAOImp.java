package com.repairs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import com.repairs.model.CustomerModel;

public class CustomerDAOImp implements CustomerDAO {

	Connection con = ConnectionHandler.getConnection();

	@Override
	public boolean customerInsert(CustomerModel cm) throws ParseException {
		// This method will insert the data for new Customer
		String sql = "insert into customer(customer_name,customer_phonenumber,location,gender) values (?,?,?,?) ;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cm.getCustomerName());
			ps.setString(2, cm.getCustomerPhone());
			ps.setString(3, cm.getCustomerLocation());
			ps.setString(4, cm.getCustomerGender());
			if (ps.executeUpdate() == 1) { 
				return true;
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*
			 * try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
			 */
		}
		return false;

	}

	@Override
	public void customerRemove(CustomerModel cm) {
		// Delete the account for the exists customer
		String sql = "delete from customer where customer_phonenumber=?";
		System.out.println("Deleting......");
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cm.getCustomerPhone());
			if (ps.executeUpdate() == 1) {
				System.out.println("Deleted");
			} else {
				System.out.println("Fail to delete");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*
			 * try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
			 */
		}

	}

	@Override
	public CustomerModel customerRetrival(String custName, String custPhone) throws ParseException {
		// This method will retrieve the customer details
		// customer_name,customer_phonenumber,location
		CustomerModel cm = null;
		System.out.println("Retrieving ....");
		String sql = "select * from customer";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println(sql);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {

				if (rs.getString("customer_name").equalsIgnoreCase(custName)
						&& rs.getString("customer_phonenumber").equals(custPhone)) {
					return new CustomerModel(rs.getString("customer_name"), rs.getString("location"),
							rs.getString("customer_phonenumber"),rs.getString("gender"));
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			if(e.getMessage().contains("Unknown database \'mydb\'")) {
				System.out.println("Yes We can implement here ");
			}
		} finally {
			/*
			 * try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
			 */
		}

		return cm;
	}

	@Override
	public boolean customerUpdate(CustomerModel cm) {
		// This method will edit the location
		System.out.println("Editing...");
		String sql = "update customer \r\n" + "set location=? where customer_phonenumber=?;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cm.getCustomerLocation());
			ps.setString(2, cm.getCustomerPhone());

			if (ps.executeUpdate() == 1) {
				System.out.println("Edited");
				return true;
			} else {
				System.out.println("Fail to edit");
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*
			 * try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
			 */
		}
		return false;
	}

}
