package PT2020.demo.Tema2;

public class Client implements Comparable<Client> {
	private int id;
	private int serviceTime;
	private int arrivalTime;
	private int startTimeShop;////fac un set

	public Client(int id, int arrivalTime, int serviceTime) {
		this.id = id;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
	}

	public int getId() {
		return id;
	}

	public int getTarrival() {
		return arrivalTime;
	}

	public int getTservice() {
		return serviceTime;
	}
	
	
	public void subTservice1() {
		 serviceTime--;
	}
	
	public void setStartTime(int startTime){
		this.startTimeShop=startTime;
	}
	
	public int getStartTime() {
		return startTimeShop;
	}

	// metoda de comparare a arrivalTime si serviceTime in caz ca avem acelasi
	// arrivalTime
	public int compareTo(Client c) {
		if (arrivalTime > c.arrivalTime)
			return 1;
		else if (arrivalTime == c.arrivalTime) {
			if (serviceTime > c.serviceTime)
				return 1;
			else if (serviceTime == c.serviceTime)
				return 0;
			else
				return -1;
		} else
			return -1;
	}

	// metoda de afisare
	public String toString() {
		return "Clientul cu id:" + id + " are tarrival:" + getTarrival() + " si tservice:" + getTservice();
	}

}
