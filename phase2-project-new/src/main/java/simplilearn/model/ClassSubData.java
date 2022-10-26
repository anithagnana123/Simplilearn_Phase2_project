package simplilearn.model;

import java.io.Serializable;

public class ClassSubData implements Serializable{
	
	private String subject;
	private int standard;
    private String class_sec;
	
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public String getClass_sec() {
		return class_sec;
	}
	public void setClass_sec(String class_sec) {
		this.class_sec = class_sec;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	private ClassSubData() {
		// private constructor
	}
	
	//Inner class to provide instance of class
    private static class BillPughSingleton
    {
		private static final ClassSubData INSTANCE = new ClassSubData();
    }
		 
    public static ClassSubData getInstance()
	{
		return BillPughSingleton.INSTANCE;
    }

}
