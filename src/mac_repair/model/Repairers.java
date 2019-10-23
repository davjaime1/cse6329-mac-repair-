package mac_repair.model;

import java.io.Serializable;

public class Repairers implements Serializable{

	private static final long serialVersionUID = 3L;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
