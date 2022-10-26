package simplilearn.model;

import java.io.Serializable;

public class ClassSubTeach implements Serializable {
	
    private int id;
	private int teacher_id;
	private ClassSubData classsub; 
	
	public ClassSubData getClasssub() {
		return classsub;
	}

	public void setClasssub(ClassSubData classsub) {
		this.classsub = classsub;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}
	
	
	private ClassSubTeach() {
		// private constructor
		setClasssub(ClassSubData.getInstance());
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