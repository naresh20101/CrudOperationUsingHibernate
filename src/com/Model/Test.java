package com.Model;
import com.Dao.StudentDao;
import com.DaoImp.*;

public class Test {
	public static void main(String[] args)
	{
		Student s=new Student();
		s.setName("Turab");
		s.setContact("03744");
		s.setGender("Male");
		s.setCountry("Pak");
		StudentDaoImp sDao=new StudentDaoImp();
		//sDao.addStudent(s);
		//Integer id=3;
		//((StudentDaoImp) sDao).deleteStudent(id);
		
		//Integer Id=sDao.getIdByStudent(s.getName());
		//System.out.print("ID:"+ Id);	
		Student s1=new Student();
		s.setName("GOVINda");
		s.setContact("03744");
		s.setGender("Male");
		s.setCountry("Pak");
  
		
	}

}
 