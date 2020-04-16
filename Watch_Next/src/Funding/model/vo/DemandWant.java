package Funding.model.vo;

public class DemandWant {
	private String user_id;
	private int demand_survey_no;
	private String demand_user_id;
	
	public DemandWant() {}
	
	public DemandWant(String user_id, int demand_survey_no, String demand_user_id) {
		super();
		this.user_id = user_id;
		this.demand_survey_no = demand_survey_no;
		this.demand_user_id = demand_user_id;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getDemand_survey_no() {
		return demand_survey_no;
	}
	public void setDemand_survey_no(int demand_survey_no) {
		this.demand_survey_no = demand_survey_no;
	}
	public String getDemand_user_id() {
		return demand_user_id;
	}
	public void setDemand_user_id(String demand_user_id) {
		this.demand_user_id = demand_user_id;
	}
	
	@Override
	public String toString() {
		return "DemandWant [user_id=" + user_id + ", demand_survey_no=" + demand_survey_no + ", demand_user_id="
				+ demand_user_id + "]";
	}
	
	
}
