package PT2020.demo.Tema2;


public class Shop {

	private int number;
	private Client c;

	public Shop(int number) {
		this.number = number;
	}
    
	public void openShop(Client c,int testSimulare) {
		this.c=c;
		c.setStartTime(testSimulare);
	}
	public boolean isReady(int timpSimulare) {
		if(c==null)
			return true;
		if((c.getStartTime()+c.getTservice()) <= timpSimulare) {
		return true;
		}  
		return false;
	}
	
	public void closeShop() {
		this.c=null;
	}
	
	public boolean isOpen() {
		if(c==null)
		return true;
		
		return false;
	}
	
	public void addClienttoShop() {
		
	}
	
	/*
	 * public void OpenShop() { waitingTime++; }
	 * 
	 * public String CloseShop() {
	 * 
	 * return "closed"; }
	 * 
	 * adaugam in Shop public void Proba() {
	 * 
	 * for(time=0;time<simulationTime;time++) { for (Client c : clients) { if
	 * (c.getTarrival() == time) { OpenShop();
	 * 
	 * } } } }
	 */

	public String toString() {

		if(c==null)
			return "Casa este inchisa";
		else
		    return "Casa cu numarul:" + number + " serveste clientul " + c;              
	}
}
