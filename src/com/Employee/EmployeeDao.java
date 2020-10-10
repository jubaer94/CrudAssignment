package com.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class EmployeeDao {
	public static Connection getConnection(){
		Connection con = null;
		String url= "jdbc:mysql://localhost:3306/test_db";
		String user="root";

		String password="jubaer94";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection(url, user, password);
			System.out.println("Database connected...");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
	
	public static int SaveEmployee(Emolyee emp)
	{
		int status=0;
		try {
			Connection con = EmployeeDao.getConnection();
			PreparedStatement ps =con.prepareStatement("insert into employeeinfo(grade,name,address,salary,bankaccount,initialsalary) values (?,?,?,?,?,?)");
			ps.setInt(1, emp.getGrade());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getAddress());
			ps.setDouble(4, emp.getSalary());
			ps.setString(5, emp.getBankAccountNumber());
			ps.setDouble(6, emp.getInitialSalary());
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public static int update(Emolyee e){
		int status=0;
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update  employeeinfo set grade=?,name=?,address=?,salary=?,bankaccount=?,initialsalary=? where id=?");
			ps.setInt(1, e.getGrade());
			ps.setString(2, e.getName());
			ps.setString(3,e.getAddress());
    		ps.setDouble(4, e.getSalary());
			ps.setString(5, e.getBankAccountNumber());
			ps.setDouble(6, e.getInitialSalary());
			ps.setInt(7, e.getId());
			
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from  employeeinfo where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	
	
	public static Emolyee getEmployeeById(int id){
		Emolyee e=new Emolyee();
		
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from  employeeinfo where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setGrade(rs.getInt(2));
				e.setName(rs.getNString(3));
				e.setAddress(rs.getNString(4));
			
				e.setBankAccountNumber(rs.getString(6));
				e.setInitialSalary(rs.getDouble(7));
				
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static ArrayList<Emolyee> getAllEmployees(){
		ArrayList<Emolyee> list=new ArrayList<>();
		
		try{
			Connection con=EmployeeDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employeeinfo");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emolyee e=new Emolyee();
				e.setId(rs.getInt(1));
				e.setGrade(rs.getInt(2));
				e.setName(rs.getString(3));
				e.setAddress(rs.getString(4)); 
				e.setBankAccountNumber(rs.getString(6));
				e.setInitialSalary(rs.getDouble(7));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
}
}
