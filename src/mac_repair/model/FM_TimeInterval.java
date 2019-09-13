package mac_repair.model;
import java.io.Serializable;


public class FM_TimeInterval implements Serializable{

	private static final long serialVersionUID = 3L;
	private String id;
	private String timeInterval;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTimeInterval() {
		return timeInterval;
	}
	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

}
