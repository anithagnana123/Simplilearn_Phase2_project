package simplilearn.model;


public class SubInfo {
	
	private int sub_id;
	private String subject;
	
	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	
	private SubInfo() {
		//private constructor
	}
	
	//Inner class to provide instance of class
    private static class BillPughSingleton
    {
		private static final SubInfo INSTANCE = new SubInfo();
    }
		 
    public static SubInfo getInstance()
	{
		return BillPughSingleton.INSTANCE;
    }
		
}
