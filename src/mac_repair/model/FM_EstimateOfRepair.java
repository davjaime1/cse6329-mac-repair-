package mac_repair.model;

import java.io.Serializable;

public class FM_EstimateOfRepair implements Serializable{

	private static final long serialVersionUID = 3L;
	private String id;
	private String repairTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(String repairTime) {
		this.repairTime = repairTime;
	}

}
