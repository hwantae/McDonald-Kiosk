
public class Side extends Product{
	private boolean large;	//it checks whether large is selected or not.
	
	public Side(int bPrice) {
		super(bPrice);
		// TODO Auto-generated constructor stub
	}
	//this function is for calculating total cost of side with chosen options.
	public void calculateCost() {
		if (isLarge()) {
			setTotalCost(1000);
		}
	}
	//this functions gets the state of large.
	public boolean isLarge() {
		return large;
	}
	//this function sets the state of large.
	public void setLarge(boolean large) {
		this.large = large;
	}
}
