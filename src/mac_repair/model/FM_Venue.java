package mac_repair.model;

import java.io.Serializable;

public class FM_Venue  implements Serializable{

	private static final long serialVersionUID = 3L;
	private String id;
	private String venue;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}

}
