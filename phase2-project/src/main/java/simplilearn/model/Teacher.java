package simplilearn.model;

public class Teacher {
	
	private int teacher_id;
	private String teacher_firstName;
	private String teacher_lastName;
	private int experience;
	private String qualification;
	
	private Teacher() {
		//private constructor
	}
	
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	public String getTeacher_firstName() {
		return teacher_firstName;
	}
	public void setTeacher_firstName(String teacher_firstName) {
		this.teacher_firstName = teacher_firstName;
	}
	public String getTeacher_lastName() {
		return teacher_lastName;
	}
	public void setTeacher_lastName(String teacher_lastName) {
		this.teacher_lastName = teacher_lastName;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	//Inner class to provide instance of class
	private static class BillPughSingleton
	  {
	    private static final Teacher INSTANCE = new Teacher();
	  }
	 
	  public static Teacher getInstance()
	  {
	    return BillPughSingleton.INSTANCE;
	  }
	}


