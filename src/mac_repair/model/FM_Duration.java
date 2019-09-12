package mac_repair.model;

import java.io.Serializable;

public class FM_Duration  implements Serializable{

	private static final long serialVersionUID = 3L;
	private String id;
	private String duration;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}


}
