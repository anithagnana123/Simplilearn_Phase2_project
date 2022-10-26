package simplilearn.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import simplilearn.model.User;
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
				
		//Retrieve the transaction
		session.beginTransaction();
		
		User user = new User();
		user.setName("anitha");
		user.getProteinData().setGoal(100);

		session.save(user);
		session.getTransaction().commit();
		
		session.beginTransaction();
		
		User loadedUser = (User) session.get(User.class,1);
		
		System.out.println("Name:" + loadedUser.getName());
		System.out.println("Goal:" + loadedUser.getProteinData().getGoal());

		//Manipulate the user
		System.out.println(loadedUser.getProteinData().getTotal());
		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 50);
		
		//auto-updating
		session.getTransaction().commit();
		
		session.close();

//	    System.out.println("Obtained the session");
		
	}

}
