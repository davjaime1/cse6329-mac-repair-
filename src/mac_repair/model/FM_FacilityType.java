package mac_repair.model;

import java.io.Serializable;

public class FM_FacilityType  implements Serializable{

	private static final long serialVersionUID = 3L;
	private String id;
	private String facilityType;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
}
