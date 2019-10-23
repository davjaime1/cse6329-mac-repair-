package mac_repair.model;

import java.io.Serializable;

public class UtilityModel  implements Serializable{

	private static final long serialVersionUID = 3L;
	private String id;
	private String value;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
