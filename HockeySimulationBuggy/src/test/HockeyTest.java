package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import edu.ense475.Buggy.HockeyLeague;
import edu.ense475.Buggy.HockeyPlayer;
import edu.ense475.Buggy.HockeyTeam;
import edu.ense475.Buggy.CSVReader;
import edu.ense475.Buggy.CSVWriter;

public class HockeyTest {

	@Test
	public void testHockeyLeague() {
		HockeyLeague league = new HockeyLeague();
		assertTrue(league.getTeam("Maple Leafs").getRoster().size() > 0);
	}
	
	@Test
	public void testAddPlayer() {
		HockeyLeague league = new HockeyLeague();
		assertEquals(false,league.addPlayer("Maple Leafs", "LW", "Henry", "George", 99));
		league.deletePlayer("Maple Leafs", "Viktor", "Stalberg");
		assertEquals(true,league.addPlayer("Maple Leafs", "LW", "Henry", "George", 99));
		assertEquals(false,league.addPlayer("DBZ", "LW", "Henry", "George", 99));
		league.deletePlayer("Maple Leafs", "Tim", "Thomas");
		assertEquals(false,league.addPlayer("Maple Leafs", "LW", "Henry", "George", 99));
		league.addPlayer("Maple Leafs","C","Harry","Potter", 81);
		assertEquals(false,league.getTeam("Maple Leafs").addPlayer(new HockeyPlayer("LW","Henry","George",100)));
	
	}

	@Test
	public void testDeletePlayer() {
		HockeyLeague league = new HockeyLeague();
		assertEquals(false,league.deletePlayer("Maple Leafs","Luke", "Warm"));
		assertEquals(true,league.deletePlayer("Maple Leafs", "Phil", "Kessel"));
		assertEquals(false,league.deletePlayer("DBZ", "Luke", "Warm"));
		
	}
	
	@Test 
	public void testEditPlayer() {
		HockeyLeague league = new HockeyLeague();
		assertEquals(false, league.editPlayer("Maple Leafs", "LW", "Daniel", "Paille", 80));
		assertEquals(true, league.editPlayer("Bruins", "LW", "Daniel", "Paille", 80));
		assertEquals(false, league.editPlayer("DBZ", "LW", "Daniel", "Paille", 80));
	}
	
	@Test 
	public void testPlayGame() {
		HockeyLeague league = new HockeyLeague();
		assertTrue(league.playGame("Bruins", "Maple Leafs") != "Unplayable Game Rosters are wrong");
		league.editPlayer("Maple Leafs", "C", "Carl", "Gunnarsson", 82);
		assertEquals("Unplayable Game Rosters are wrong", league.playGame("Rangers", "Maple Leafs"));
		league.deletePlayer("Bruins", "Blake", "Wheeler");
		assertEquals("Unplayable Game Rosters are wrong", league.playGame("Bruins", "Maple Leafs"));
		assertEquals("Unplayable Game Rosters are wrong", league.playGame("DBZ", "One"));
		
	}
	
			
}

