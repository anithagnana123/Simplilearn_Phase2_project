package simplilearn.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int id;
	private String name;
	
	//ProteinData as an entity
	private ProteinData proteindata;
	
	public ProteinData getProteindata() {
		return proteindata;
	}

	public void setProteindata(ProteinData proteindata) {
		this.proteindata = proteindata;
		proteindata.setUser(this);
	}
	
	public User() {
		setProteindata(new ProteinData());
	}

	private List<UserHistory> history = new ArrayList<>();
	
	public List<UserHistory> getHistory(){
		return history;
	}
	
	public void setHistory(List<UserHistory> history){
		this.history = history;
	}
	
	public void addHistory(UserHistory historyItem) {
		historyItem.setUser(this);
		history.add(historyItem);
	}
	
	private ProteinData  proteinData = new ProteinData();
	

	public ProteinData getProteinData() {
		return proteinData;
	}
	
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData ;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	
}
