package tech.vkrestro.model;

import java.util.Objects;

public class MenuPojo {
	private int idmenu;
	private String name;
    private String category;
    private double price;
    private String description;
    private String imageUrl;
    
    public MenuPojo() {
		super();
	
	}
	
    
    
	public MenuPojo(  int idmenu ,String name,   String description , double price,String category, String imageUrl) {
		super();
		this.idmenu=idmenu;
		this.name = name;
		this.category = category;
		this.price = price;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	
	
	public int getIdmenu() {
		return idmenu;
	}


	public void setIdmenu(int idmenu) {
		this.idmenu = idmenu;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(category, description, imageUrl, name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuPojo other = (MenuPojo) obj;
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	@Override
	public String toString() {
		return "MenuPojo [name=" + name + ", category=" + category + ", price=" + price + ", description=" + description
				+ ", imageUrl=" + imageUrl + "]";
	}
    
    
    
    

}
