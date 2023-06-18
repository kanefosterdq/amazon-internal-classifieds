package com.amazon.classified.model;

//classified
public class Classified {
	
	/*CREATE TABLE classified (
			productId INT PRIMARY KEY AUTO_INCREMENT NOT NULL
			,NAME VARCHAR(100)
			,DESCRIPTION VARCHAR(100)
			,price  INT
			,TYPE VARCHAR(100)
			,STATUS INT
			,postedOn DATETIME DEFAULT CURRENT_TIMESTAMP
			,login VARCHAR(100)
			,FOREIGN KEY (login) REFERENCES USER(login)
			)*/
	
	
	private int productId;
	private String name;
	private String description;
	private int type; 		//category of product
	private int status;		//0-deactivated 1-activated
	private String postedOn;
	private double price;
	
	public Classified() {
		
	}

	

	public Classified(int productId, String name, String description, int type, int status, String postedOn,
			double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.type = type;
		this.status = status;
		this.postedOn = postedOn;
		this.price = price;
	}



	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(String postedOn) {
		this.postedOn = postedOn;
	}

	@Override
	public String toString() {
		return "Classified [productId=" + productId + ", name=" + name + ", description=" + description + ", type="
				+ type + ", status=" + status + ", postedOn=" + postedOn + ", price=" + price + "]";
	}

	
	
	
	
}
