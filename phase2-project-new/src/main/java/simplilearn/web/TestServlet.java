package simplilearn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import simplilearn.model.ClassInfo;
import simplilearn.model.ClassSubData;
import simplilearn.model.Student;
import simplilearn.model.Teacher;
import simplilearn.utils.HibernateUtils;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
        Session session = HibernateUtils.getSessionFactory().openSession();
		 
        String operation = request.getParameter("operation");
        System.out.println(operation);
        
      //response page
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			
        
     // add a teacher  
     if(operation.equals("addteacher")) {
    	
        String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String experience = request.getParameter("experience");
		int exp =Integer.parseInt(experience);
		String qualification = request.getParameter("qualification");
		
		System.out.println(operation);
		
		session.beginTransaction();
		Teacher teacher = Teacher.getInstance();

		teacher.setTeacher_firstName(firstname);
		teacher.setTeacher_lastName(lastname);
		teacher.setExperience(exp);
		teacher.setQualification(qualification);
	
		session.save(teacher);
		session.getTransaction().commit();
		
	    out.println("<h2> Teacher added successfully </h2>");
		
		out.println("<form action='addteacher' method='get'>");
	  	out.println("<br> <input type='submit' value='Add another teacher'/>");
	    out.println("</form>");
	
     }
		
  // delete a teacher  
     if(operation.equals("deleteteacher")) {
    	
		String teacher_id = request.getParameter("teacher_id");
		int id =Integer.parseInt(teacher_id);
		
		System.out.println(operation);
		
		session.beginTransaction();
		Teacher teacher = Teacher.getInstance();

		teacher.setTeacher_id(id);
		
		session.delete(teacher);
		session.getTransaction().commit();
		
	    out.println("<h2> Teacher deleted successfully </h2>");
		
		out.println("<form action='deleteteacher' method='get'>");
	  	out.println("<br> <input type='submit' value='Delete another teacher'/>");
	    out.println("</form>");
	
     }

     // update a teacher  
     if(operation.equals("updateteacher")) {
    	
		String teacher_id = request.getParameter("teacher_id");
		int id =Integer.parseInt(teacher_id);
		String firstname = request.getParameter("teacher_firstName");
		String lastname = request.getParameter("lname");
		String experience = request.getParameter("experience");
		int exp =Integer.parseInt(experience);
		String qualification = request.getParameter("qualification");
	
		System.out.println(operation);
		
		session.beginTransaction();
		Teacher teacher = Teacher.getInstance();

		teacher.setTeacher_id(id);
		teacher.setTeacher_firstName(firstname);	
		teacher.setTeacher_lastName(lastname);
		teacher.setExperience(exp);
		teacher.setQualification(qualification);
		
		
		session.update(teacher);
		session.getTransaction().commit();
		
	    out.println("<h2> Teacher details updated successfully </h2>");
		
		out.println("<form action='updateteacher' method='get'>");
	  	out.println("<br> <input type='submit' value='Update another teacher'/>");
	    out.println("</form>");
	
     }
 

     
     // add a class 
     if(operation.equals("addclass")) {
     
    	String section = request.getParameter("class_sec");
 		String standard = request.getParameter("standard");
 		int class_no =Integer.parseInt(standard);
 		
 		System.out.println(operation);
 		
 		session.beginTransaction();
 		ClassInfo theclass = ClassInfo.getInstance();

 		theclass.setStandard(class_no);
 		theclass.setClass_sec(section);
 	
 		session.save(theclass);
 		session.getTransaction().commit();
 		
 	    out.println("<h2> Class added successfully </h2>");
 		
 		out.println("<form action='addclass' method='get'>");
 	  	out.println("<br> <input type='submit' value='Add another class'/>");
 	    out.println("</form>");
 	
      }

     // delete a class 
     if(operation.equals("deleteclass")) {
    	
		String standard = request.getParameter("standard");
		int std =Integer.parseInt(standard);
		String section = request.getParameter("class_sec");
		
		session.beginTransaction();
		ClassInfo theclass = ClassInfo.getInstance();

		theclass.setStandard(std);
		theclass.setClass_sec(section);
		
		session.delete(theclass);
		session.getTransaction().commit();
		
	    out.println("<h2> Class deleted successfully </h2>");
		
		out.println("<form action='deleteclass' method='get'>");
	  	out.println("<br> <input type='submit' value='Delete another class'/>");
	    out.println("</form>");
	
     }

     // add a student  
     if(operation.equals("addstudent")) {
     
    	
 		String firstname = request.getParameter("firstName");
 		String lastname = request.getParameter("lastName");
 		String dateOfBirth = request.getParameter("dateOfBirth");
 		String standard = request.getParameter("standard");
 		
 		int std = Integer.parseInt(standard);
 		
 		String section = request.getParameter("class_sec");
 		
 	
 		System.out.println(operation);
 		
 		session.beginTransaction();
 		Student thestudent = Student.getInstance();

 		thestudent.setFirstName(firstname);
 		thestudent.setLastName(lastname);
 		thestudent.setDateOfBirth(dateOfBirth);
 		
 		ClassInfo classData = ClassInfo.getInstance();
		classData.setStandard(std);
		classData.setClass_sec(section);
		thestudent.setTheclass(classData);
		
 		session.save(thestudent);
 		session.getTransaction().commit();
 		
 	    out.println("<h2> Student added successfully </h2>");
 		
 		out.println("<form action='addstudent' method='get'>");
 	  	out.println("<br> <input type='submit' value='Add another student'/>");
 	    out.println("</form>");
    	   
       }
       

     // update a student  
     if(operation.equals("updatestudent")) {
     
    	String student_id = request.getParameter("student_id");
  		int id = Integer.parseInt(student_id);
 		String firstname = request.getParameter("firstName");
 		String lastname = request.getParameter("lastName");
 		String dateOfBirth = request.getParameter("dateOfBirth");
 		String standard = request.getParameter("standard");
 		int std = Integer.parseInt(standard);
 		String section = request.getParameter("class_sec");
 		
 		session.beginTransaction();
 		Student thestudent = Student.getInstance();

 		thestudent.setStudent_id(std);
 		thestudent.setFirstName(firstname);
 		thestudent.setLastName(lastname);
 		thestudent.setDateOfBirth(dateOfBirth);
 		
 		ClassInfo classData = ClassInfo.getInstance();
		classData.setStandard(std);
		classData.setClass_sec(section);
		thestudent.setTheclass(classData);
		
 		session.update(thestudent);
 		session.getTransaction().commit();
 		
 	    out.println("<h2> Student profile updated successfully </h2>");
 		
 		out.println("<form action='updatestudent' method='get'>");
 	  	out.println("<br> <input type='submit' value='Update another student profile'/>");
 	    out.println("</form>");
    	   
       }

  // delete a student  
     if(operation.equals("deletestudent")) {
    	
		String student_id = request.getParameter("student_id");
		int id =Integer.parseInt(student_id);
		String standard = request.getParameter("standard");
 		int std = Integer.parseInt(standard);
 		String section = request.getParameter("class_sec");
		
		session.beginTransaction();
		Student thestudent = Student.getInstance();
		thestudent.setStudent_id(id);
		
		ClassInfo classData = ClassInfo.getInstance();
		classData.setStandard(std);
		classData.setClass_sec(section);
		thestudent.setTheclass(classData);	
		
		session.delete(thestudent);
		session.persist(classData);
		session.getTransaction().commit();
		
	    out.println("<h2> Student deleted successfully </h2>");
		
		out.println("<form action='deletestudent' method='get'>");
	  	out.println("<br> <input type='submit' value='Delete another student'/>");
	    out.println("</form>");
	
     }

    System.out.println(operation);
    
  // assign class to a subject  
     if(operation.equals("assignclasssub")) {
    	
    	String subject = request.getParameter("subject");
        System.out.println("subject :" + subject);
		String standard = request.getParameter("standard");
		System.out.println("standard:" + standard);
 		int std = Integer.parseInt(standard);
 		String section = request.getParameter("class_sec");
		
		session.beginTransaction();
		ClassSubData classsub = ClassSubData.getInstance();
		classsub.setSubject(subject);
		classsub.setStandard(std);
		classsub.setClass_sec(section);
		
		session.save(classsub);
		session.getTransaction().commit();
		
	    out.println("<h2> Class assigned to a subject successfully </h2>");
		
		out.println("<form action='classsub.jsp' method='get'>");
	  	out.println("<br> <input type='submit' value='Add another class to a subject'/>");
	    out.println("</form>");
	
     }

     
        session.close();
		
	    out.println("<form action='welcome' method='get'>");
	  	out.println("<br> <input type='submit' value='home page'/>");
	    out.println("</form>");
		
	    System.out.println("Obtained the session");
		
	}

}
