
public class Set extends Product{
	private boolean brioshBun;	//it checks whether brioshBun is selected or not.
	private boolean large;	//it checks whether Large is selected or not.
	private boolean noIce;	//it checks whether noIce is selected or not.

	public Set(int bPrice) {
		super(bPrice);
		// TODO Auto-generated constructor stub
	}
	//this function is for calculating total cost of set with chosen options.
	public void calculateCost() {
		if (isLarge()) {
			setTotalCost(1500);
		}
		if (isBrioshBun()) {
			setTotalCost(1000);
		}
	}
	//this function returns state of brioshBun.
	public boolean isBrioshBun() {
		return brioshBun;
	}
	//this function sets state of brioshBun.
	public void setBrioshBun(boolean brioshBun) {
		this.brioshBun = brioshBun;
	}
	//this function returns state of brioshBun.
	public boolean isLarge() {
		return large;
	}
	//this function sets the state of the large.
	public void setLarge(boolean large1) {
		large = large1;
	}
	//this function returns the state of the noIce.
	public boolean isNoIce() {
		return noIce;
	}
	// this function sets the state of the noIce.
	public void setNoIce(boolean noIce) {
		this.noIce = noIce;
	}

}
