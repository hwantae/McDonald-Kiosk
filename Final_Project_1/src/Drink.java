
public class Drink extends Product{
	private boolean large;	//it checks whether large button is clicked or not.
	private boolean noIce;	//it checks whether noIce button is clicked or not.

	public Drink(int bPrice) {
		super(bPrice);
		// TODO Auto-generated constructor stub
	}
	//this function is for calculate total cost of Drink with option and without option.
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
	//this function gets the state of large.
	public boolean isNoIce() {
		return noIce;
	}
	//this function sets the state of noIce.
	public void setNoIce(boolean noIce) {
		this.noIce = noIce;
	}

}
