package simplilearn.model;

import java.io.Serializable;

public class ClassSubTeach {
	
	private int fr_teach_id;
	private String subject;
	private String class_sec;
	

	public String getClass_sec() {
		return class_sec;
	}

	public void setClass_sec(String class_sec) {
		this.class_sec = class_sec;
	}

	public int getFr_teach_id() {
		return fr_teach_id;
	}

	public void setFr_teach_id(int fr_teach_id) {
		this.fr_teach_id = fr_teach_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	private ClassSubTeach() {
		// private constructor
	}
	
	//Inner class to provide instance of class
    private static class BillPughSingleton
    {
		private static final ClassSubTeach INSTANCE = new ClassSubTeach();
    }
		 
    public static ClassSubTeach getInstance()
	{
		return BillPughSingleton.INSTANCE;
    }

}
