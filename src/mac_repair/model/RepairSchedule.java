package mac_repair.model;


import java.io.Serializable;

public class RepairSchedule  implements Serializable{

		private static final long serialVersionUID = 3L;
		private String username;
		private String marID;
		private String scheduleDate;
		public void setRepairSchedule(String username, String marID, String scheduleDate) {
			setUsername(username);
			setScheduleDate(scheduleDate);
			setMarID(marID);
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}

		public String getScheduleDate() {
			return scheduleDate;
		}
		public void setScheduleDate(String scheduleDate) {
			this.scheduleDate = scheduleDate;
		}
		public String getMarID() {
			return marID;
		}
		public void setMarID(String marID) {
			this.marID = marID;
		}
}
