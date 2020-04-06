package PT2020.demo.Tema2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainClass {

	private static int max_service_time;
	private static int min_service_time;
	private static int max_arrival_time;
	private static int min_arrival_time;
	private static int nrClienti;
	private static int nrCozi;
	private static int simulationTime;

	private static int waitingTime = 0; // timpul ce trebuie incrementata
	private static int time;
	private static List<Client> clients = new ArrayList<Client>();
	// private static List<Queue> q = new ArrayList<Queue>();
	private static ArrayList<Shop> shops = new ArrayList<Shop>();
	private static Shop p;
	private static Queue q;
	
	private static ExecutorService executor;  

	// metoda de citire din fisier
	public static void readFile(String fileName) {
		try {
			File file = new File(fileName);
			Scanner s = new Scanner(file);

			String data = s.nextLine();
			nrClienti = Integer.parseInt(data);

			String data1 = s.nextLine();
			nrCozi = Integer.parseInt(data1);

			String data2 = s.nextLine();
			simulationTime = Integer.parseInt(data2);

			String data3 = s.nextLine();
			String[] arrival = data3.split(",");
			min_arrival_time = Integer.parseInt(arrival[0]);
			max_arrival_time = Integer.parseInt(arrival[1]);

			String data4 = s.nextLine();
			String[] service = data4.split(",");
			min_service_time = Integer.parseInt(service[0]);
			max_service_time = Integer.parseInt(service[1]);

			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}


	

	public static void main(String[] args) {

		String fileName = "in-test-1.txt";
		readFile(fileName);
		for (int i = 1; i <= nrCozi; i++) {
			Shop shop = new Shop(i);
			shops.add(shop);
			System.out.println(shop);
		}
		q = new Queue(nrClienti, simulationTime, min_arrival_time, max_arrival_time, min_service_time,
				max_service_time);

		for (Client c : q.getClients()) {
			System.out.println("testeaza clientul" + c.toString() + "la timpul" + time);
		}
		q.generateClients();
		q.SortClients();
		
		executor = Executors.newFixedThreadPool(nrCozi);
		
		Manager object = new Manager(simulationTime, shops, q,executor);
		object.start();
		
	
		
		// System.out.println(q);

	}
}
