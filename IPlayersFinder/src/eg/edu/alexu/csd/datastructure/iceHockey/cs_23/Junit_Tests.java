package eg.edu.alexu.csd.datastructure.iceHockey.cs_23;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Junit_Tests 
{
	@Test
	void test1() 
	{
		Program pr = new Program();
		java.awt.Point [] actual= pr.findPlayers(new String []
				{
						"33JUBU33",
						"3U3O4433",
						"O33P44NB",
						"PO3NSDP3",
						"VNDSD333",
						"OINFD33X"
				}, 3, 16);
		java.awt.Point [] expected = new java.awt.Point [] 
				{
				new java.awt.Point(4,5),
				new java.awt.Point(13,9),
				new java.awt.Point(14,2)
				};
		assertArrayEquals(expected, actual);
	}
	@Test
	void test2() 
	{
		Program pr = new Program();
		java.awt.Point [] actual= pr.findPlayers(new String []
				{
						"44444H44S4",
						"K444K4L444",
						"4LJ44T44XH",
						"444O4VIF44",
						"44C4D4U444",
						"4V4Y4KB4M4",
						"G4W4HP4O4W",
						"4444ZDQ4S4",
						"4BR4Y4A444",
						"4G4V4T4444"
				}, 4, 16);
		java.awt.Point [] expected = new java.awt.Point [] 
				{
				new java.awt.Point(3,8),
				new java.awt.Point(4,16),
				new java.awt.Point(5,4),
				new java.awt.Point(16,3),
				new java.awt.Point(16,17),
				new java.awt.Point(17,9)
				};
		assertArrayEquals(expected, actual);
	}
	@Test
	void test3() 
	{
		Program pr = new Program();
		java.awt.Point [] actual= pr.findPlayers(new String []
				{
						"8D88888J8L8E888",
						"88NKMG8N8E8JI88",
						"888NS8EU88HN8EO",
						"LUQ888A8TH8OIH8",
						"888QJ88R8SG88TY",
						"88ZQV88B88OUZ8O",
						"FQ88WF8Q8GG88B8",
						"8S888HGSB8FT8S8",
						"8MX88D88888T8K8",
						"8S8A88MGVDG8XK8",
						"M88S8B8I8M88J8N",
						"8W88X88ZT8KA8I8",
						"88SQGB8I8J88W88",
						"U88H8NI8CZB88B8",
						"8PK8H8T8888TQR8"
				}, 8, 9);
		java.awt.Point [] expected = new java.awt.Point [] 
				{
					new java.awt.Point(1, 17),
					new java.awt.Point(3, 3),
					new java.awt.Point(3, 10),
					new java.awt.Point(3, 25),
					new java.awt.Point(5, 21),
					new java.awt.Point(8, 17),
					new java.awt.Point(9, 2),
					new java.awt.Point(10,9),
					new java.awt.Point(12,23),
					new java.awt.Point(17,16),
					new java.awt.Point(18,3),
					new java.awt.Point(18,11),
					new java.awt.Point(18,28),
					new java.awt.Point(22,20),
					new java.awt.Point(23,26),
					new java.awt.Point(24,15),
					new java.awt.Point(27,2),
					new java.awt.Point(28,26),
					new java.awt.Point(29,16)
				};
		assertArrayEquals(expected, actual);
	}
	@Test
	void test4() 
	{
		Program pr = new Program();
		java.awt.Point [] actual= pr.findPlayers(new String []
				{
						"11111",
						"1AAA1",
						"1A1A1",
						"1AAA1",
						"11111"
				}, 1, 3);
		java.awt.Point [] expected = new java.awt.Point [] 
				{
				new java.awt.Point(5,5),
				new java.awt.Point(5,5),
				};
		assertArrayEquals(expected, actual);
	}
	@Test
	void test5() 
	{
		Program pr = new Program();
		java.awt.Point [] actual= pr.findPlayers(new String [] {}, 1, 3);
		java.awt.Point [] expected = new java.awt.Point [] {};
		assertArrayEquals(expected, actual);
	}
	@Test
	void test6() 
	{
		Program pr = new Program();
		java.awt.Point [] actual= pr.findPlayers(new String []
				{
						"111",
						"1X1",
						"111"
				}, 1,32);
		java.awt.Point [] expected = new java.awt.Point [] 
				{
				new java.awt.Point(3,3),
				};
		assertArrayEquals(expected, actual);
	}
	@Test
	void test7() 
	{
		Program pr = new Program();
		java.awt.Point [] actual= pr.findPlayers(null, 1,32);
		java.awt.Point [] expected = new java.awt.Point [] {};
		assertArrayEquals(expected, actual);
	}
	@Test
	void test8()
	{
		Program pr = new Program();
		java.awt.Point [] actual= pr.findPlayers(new String [] {"5"}, 5,4);
		java.awt.Point [] expected = new java.awt.Point [] 
				{
				new java.awt.Point(1,1),
				};
		assertArrayEquals(expected, actual);
	}
	@Test
	void test9()
	{
		Program pr = new Program();
		java.awt.Point [] actual= pr.findPlayers(new String [] {"55","55"}, 5,7);
		java.awt.Point [] expected = new java.awt.Point [] 
				{
				new java.awt.Point(2,2),
				};
		assertArrayEquals(expected, actual);
	}
	@Test
	void test10()
	{
		Program pr = new Program();
		java.awt.Point [] actual= pr.findPlayers(new String [] {"5555"}, 5,16);
		java.awt.Point [] expected = new java.awt.Point [] 
					{
							new java.awt.Point(4,1),
					};
		assertArrayEquals(expected, actual);
	}
}
