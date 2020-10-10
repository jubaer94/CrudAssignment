package com.Employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String bankaccount=request.getParameter("bankaccount");
		String address=request.getParameter("address");
		double initialsalary = Double.parseDouble(request.getParameter("initialsalary"));
		Integer grade = Integer.parseInt(request.getParameter("grade"));
		Emolyee e=new Emolyee();
		e.setId(id);
		e.setName(name);
	    e.setBankAccountNumber(bankaccount);
	    e.setAddress(address);
        e.setGrade(grade);
       e.setInitialSalary(initialsalary);;
	    
		int status=EmployeeDao.update(e);
		if(status>0){
			
			response.sendRedirect("ViewsServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
