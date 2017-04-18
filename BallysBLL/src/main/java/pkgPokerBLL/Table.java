package pkgPokerBLL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;
public class Table implements Serializable {

	private UUID TableID;
	private int NoOfPlayers; 
	private HashMap<Double, Player> TablePlayers = new HashMap<Double, Player>();

	public Table() {
		super();
		TableID = UUID.randomUUID();
		NoOfPlayers= 0;
	}

	public Table AddPlayerToTable(Player p) {
		NoOfPlayers = NoOfPlayers + 1;
		TablePlayers.put((double) NoOfPlayers, p);
		return this;
	}

	public Table RemovePlayerFromTable(Player p) {
		double k = 0.0;
		for (Entry<Double, Player> E: TablePlayers.entrySet())
			if (p.equals(E.getValue()))
				k = E.getKey();
		TablePlayers.remove(k);
		
		NoOfPlayers= NoOfPlayers - 1;
		
		return this;
	}
	public int getNoOfPlayers(){
		return NoOfPlayers;
	}
	public HashMap<Double, Player> getTable(){
		return TablePlayers;
	}
}