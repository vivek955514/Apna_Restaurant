package tech.vkrestro.model;

public class ServiceModulePojo {
	
	    private String iconname;
	    private String title;
	    private String description;
	    private String datetime;
	    
	    
		public ServiceModulePojo(String iconname, String title, String description, String datetime) {
			super();
			this.iconname = iconname;
			this.title = title;
			this.description = description;
			this.datetime = datetime;
		}


		public String getIconname() {
			return iconname;
		}


		public void setIconname(String iconname) {
			this.iconname = iconname;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getDatetime() {
			return datetime;
		}


		public void setDatetime(String datetime) {
			this.datetime = datetime;
		}


		@Override
		public String toString() {
			return "ServiceModulePojo [iconname=" + iconname + ", title=" + title + ", description=" + description
					+ ", datetime=" + datetime + "]";
		}


		
		
		
		
	    
	    

}
