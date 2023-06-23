
public class Product {
	private int basePrice;	//for storing base Price of the product
	private int totalCost;	//for storing total cost of the product
	private String name;	//for storing name of the product.
	private String Option;	//for storing options that are selected by user.
	
	public Product(int bPrice) {
		basePrice = bPrice;
		totalCost = bPrice;
		name = "";
		Option = "";
	}
	
	//this function is for getting option that is selected by user.
	public String getOption() {
		return Option;
	}
	//this function is for setting options that are selected by user.
	public void setOption(String option) {
		Option += option;
	}

	// this function is for calculate overall cost of products.
	public void calculateCost() {
		
	}
	//this function is for getting basic value of product.
	public int getBasePrice() {
		return basePrice;
	}
	//this function is for setting basic value of product.
	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
	// this function is for getting totalcost of the product.
	public int getTotalCost() {
		return totalCost;
	}
	//this function is for setting total cost of the product.
	public void setTotalCost(int totalCost) {
		this.totalCost = this.totalCost+totalCost;
	}
	// this function is for getting name of the product.
	public String getName() {
		return name;
	}
	// this function is for setting name of the product.
	public void setName(String name) {
		this.name = name;
	}
	
}
