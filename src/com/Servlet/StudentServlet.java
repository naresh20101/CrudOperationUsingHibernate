package com.Servlet;
import com.DaoImp.StudentDaoImp;
import com.Model.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Student
 */
@WebServlet("/Student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDaoImp stdDao=new StudentDaoImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("html/text");
		String action = request.getParameter("action");
		
		Gson gson=new Gson();
		String listData="";
		
		System.out.println("Action : "+action);
		if(action.equals("getAll"))
		{
			response.setContentType("javascript/json");
			List<Student> allstudent=stdDao.getStudents();
			String jsonList=gson.toJson(allstudent);
			JsonElement element = gson.toJsonTree(allstudent, new TypeToken<List<Student>>() {
			}.getType());
			JsonArray jsonArray = element.getAsJsonArray();
			listData = jsonArray.toString();

	

			listData = "{\"Result\":\"OK\", \"Records\":" + listData + "}";

			response.getWriter().print(listData);

		}
		if(action.equals("create"))
		{
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String g = request.getParameter("gender");
		String c=request.getParameter("country");
		
      	Student s=new Student();
	//StudentDaoImp stdDao=new StudentDaoImp();
	s.setName(name);
	s.setContact(contact);
	s.setGender(g);
	s.setCountry(c);
	stdDao.addStudent(s);
	Student student2=stdDao.getStudentById(stdDao.getIdByStudent(s.getName()));
	response.setContentType("javascript/json");
	String json=gson.toJson(student2);
	listData = "{\"Result\":\"OK\", \"Record\":" + json + "}";

	response.getWriter().print(listData);

	
	
		}
		
		
		if(action.equals("delete"))
		{
			Integer id=Integer.parseInt(request.getParameter("id"));
			 
			 stdDao.deleteStudent(id);
			
			response.setContentType("javascript/json");
			
			listData = "{\"Result\":\"OK\"}";

			response.getWriter().print(listData);
					
					
		}
		if(action.equals("update"))
		{ Integer id=Integer.parseInt(request.getParameter("id"));
		 
		 Student s=stdDao.getStudentById(id);
			String name = request.getParameter("name");
			String contact = request.getParameter("contact");
			String g = request.getParameter("gender");
			String c=request.getParameter("country");
			
			
	      	
		//StudentDaoImp stdDao=new StudentDaoImp();
		s.setName(name);
		s.setContact(contact);
		s.setGender(g);
		s.setCountry(c);
		stdDao.updateStudent(s);
		
		
		
		response.setContentType("javascript/json");
		String json=gson.toJson(s);
		listData = "{\"Result\":\"OK\", \"Record\":" + json + "}";

		response.getWriter().print(listData);
				
				
			 
		}
	
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
		
	
}
