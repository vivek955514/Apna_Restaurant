package tech.vkrestro.model;

public class OrderPojo {
	
	
	private int id;
    private int menuId;
    private String userEmail;
    private int quantity;
    private double totalPrice;
    private String status;
    private String datetime;
    
	public OrderPojo() {
		super();
	
	}
	
	

	public OrderPojo(int id, int menuId, String userEmail, int quantity, double totalPrice, String status) {
		super();
		this.id = id;
		this.menuId = menuId;
		this.userEmail = userEmail;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.status = status;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	 public String getDatetime() {
			return datetime;
		}

		public void setDatetime(String datetime) {
			this.datetime = datetime;
		}

	
	
    
    
    

}
