package simplilearn.model;

import java.io.Serializable;

public class ClassSubTeach {
	
	private int class_info_id;
	private ClassInfo theclass; 
	private int fr_teach_id;
	private String subject;
	private String time;
	
	public int getClass_info_id() {
		return class_info_id;
	}

	public void setClass_info_id(int class_info_id) {
		this.class_info_id = class_info_id;
	}

	public ClassInfo getTheclass() {
		return theclass;
	}

	public void setTheclass(ClassInfo theclass) {
		this.theclass = theclass;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	private ClassSubTeach() {
		// private constructor
		setTheclass(ClassInfo.getInstance());
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
