package simplilearn.model;


public class ClassInfo {
	
	private int class_id;
	private String class_sec;
	
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	
	public String getClass_sec() {
		return class_sec;
	}
	public void setClass_sec(String class_sec) {
		this.class_sec = class_sec;
	}
	
	private ClassInfo() {
		//private constructor
	}
	
	//Inner class to provide instance of class
    private static class BillPughSingleton
    {
		private static final ClassInfo INSTANCE = new ClassInfo();
    }
		 
    public static ClassInfo getInstance()
	{
		return BillPughSingleton.INSTANCE;
    }
		
}
