
public class Hamburger extends Product{
	private boolean brioshBun;	//for checking whether brioshBun button is selected or not.
	
	public Hamburger(int bPrice) {
		super(bPrice);
		// TODO Auto-generated constructor stub
	}
	//this function is for calculate total cost of Hamburger with option and without option.
	public void calculateCost() {
		if (brioshBun) {
			setTotalCost(1000);
		}
	}
	//this function is for getting state of brioshBun.
	public boolean isBrioshBun() {
		return brioshBun;
	}
	//this function is for setting state of brioshBun.
	public void setBrioshBun(boolean brioshBun) {
		this.brioshBun = brioshBun;
	}

}
