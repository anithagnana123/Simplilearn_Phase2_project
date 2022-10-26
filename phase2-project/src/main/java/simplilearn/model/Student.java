package simplilearn.model;

public class Student {

	private int student_id;
	private String firstName;
	private String lastName;
	//dateOfBirth(dd-mm-yyyy) format
	private String dateOfBirth;
	private String class_sec;
	
	public String getClass_sec() {
		return class_sec;
	}
	public void setClass_sec(String class_sec) {
		this.class_sec = class_sec;
	}

	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	private Student() {
		//private constructor
	}
	
	//Inner class to provide instance of class
    private static class BillPughSingleton
    {
		private static final Student INSTANCE = new Student();
    }
		 
    public static Student getInstance()
	{
		return BillPughSingleton.INSTANCE;
    }
	
}
