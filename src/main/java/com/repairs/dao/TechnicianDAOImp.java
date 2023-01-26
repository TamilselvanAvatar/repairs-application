package com.repairs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.repairs.model.TechnicianModel;

public class TechnicianDAOImp implements TechnicianDAO {

	Connection con = ConnectionHandler.getConnection();
	List<TechnicianModel> list = new ArrayList<TechnicianModel>();

	public List<TechnicianModel> technicianSearch(String location, String skill, int rate) {
		// This method will search technician based on skill, rate
		String sql = "select technician_name,technician_rating,technician_pay from technician\r\n"
				+ "where location=? and services=? and technician_pay <=? and availability='yes'\r\n"
				+ " order by technician_rating desc;";
		try {
			System.out.println("Fetching the desired data...");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, location);
			ps.setString(2, skill);
			ps.setLong(3, rate);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				list.add(new TechnicianModel(rs.getString("technician_name"), rs.getString("technician_rating"), skill,
						location, rs.getString("technician_pay")));
				System.out.println(rs.getString("technician_name"));
			}

			List<TechnicianModel> copy = new ArrayList<>(list);
			list.clear();
			return copy;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*
			 * try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
			 */
		}

		return null;
	}

	@Override
	public List<TechnicianModel> technicianSort(String location, String skill, int rate) {
		// This method sort the record, according to price pay to technician
		String sql = "select technician_name,technician_rating,technician_pay from technician\r\n"
				+ "where location=? and services=? and technician_pay <=? and availability='yes'\r\n"
				+ " order by technician_pay asc;";
		try {
			System.out.println("Fetching the desired data...");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, location);
			ps.setString(2, skill);
			ps.setLong(3, rate);
			ResultSet qs = ps.executeQuery();

			while (qs.next()) {
				list.add(new TechnicianModel(qs.getString("technician_name"), qs.getString("technician_rating"), skill,
						location, qs.getString("technician_pay")));
				System.out.println(qs.getString("technician_name"));
			}

			List<TechnicianModel> copy = new ArrayList<>(list);
			list.clear();
			return copy;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*
			 * try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
			 */
		}
		return null;
	}

	@Override
	public List<TechnicianModel> technicianSelect(String techName) {
		// This method retrieve the technician data
		String sql = "select technician_name,technician_rating,services,location,technician_pay from technician\r\n"
				+ "where technician_name=? \r\n";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, techName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new TechnicianModel(rs.getString("technician_name"), rs.getString("technician_rating"),
						rs.getString("services"), rs.getString("location"), rs.getString("technician_pay")));
				System.out.println(rs.getString("technician_name"));
			}

			List<TechnicianModel> copy = new ArrayList<>(list);
			list.clear();
			return copy;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*
			 * try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
			 */
		}
		return null;
	}

}
