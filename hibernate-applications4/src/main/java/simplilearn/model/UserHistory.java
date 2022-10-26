package simplilearn.model;

import java.util.Date;

public class UserHistory {
	
	private int id;
	private User user;
	
	private Date entryTime;
	private String entry;
	
	//getter and setter for the variables
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}
	
	
	// some user will not make an entry
	public UserHistory() {
		super();
	}
	
	// some users will make an entry
	public UserHistory(Date entryTime, String  entry) {
		this.entryTime = entryTime;
		this.entry = entry;
	}
	
}
