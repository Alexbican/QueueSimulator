package PT2020.demo.Tema2;

public class Client {
	private int id;
	private int tarrival;// timpul in care ajunge
	private int tservice;// timpul petrecut de client la coada

	public Client(int id, int tarrival, int tservice) {
		this.id = id;
		this.tarrival = tarrival;
		this.tservice = tservice;
	}

	public int getId() {
		return id;
	}

	public int getTarrival() {
		return tarrival;
	}

	public int getTservice() {
		return tservice;
	}

	public String toString()
	{
		return "Clientul cu id: " + id + " cu tarrival " + getTarrival() + " tservice " +getTservice(); 
	}


}
