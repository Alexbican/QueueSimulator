package PT2020.demo.Tema2;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class QueueTest {

	// private List<Client> clients = new ArrayList<Client>();

	@Test
	public void testGenerate() {
		Queue q=new Queue();
		List<Client> clients= new ArrayList<Client>();
		List<Client> clients1= new ArrayList<Client>();
		
		Client c1=new Client(1, 3, 5);
		Client c2=new Client(1, 7, 8);
		Client c3=new Client(1, 3, 5);
		
		clients.add(c1);
		clients.add(c3);
		clients.add(c2);
		
		clients1.add(c1);
		clients1.add(c3);
		clients1.add(c2);
		
		q.SortClients();
		
		assertEquals(clients,clients1);
		System.out.println("sunt Alex");

		
	}

}
