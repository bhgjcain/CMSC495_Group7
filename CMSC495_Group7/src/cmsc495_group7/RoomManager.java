package cmsc495_group7;

/**
 * RoomManager class. Allows management of Room objects. Interfaces with the GUI to perform room management tasks.
 * 
 * @author Van Chadrick Villondo, Jason Cain, Marcus Goodwin
 * @date Initial Date of Creation: 05/03/2020
 */
public class RoomManager {
	
	
	//RoomManager attributes
	Room[] Rooms;
	
	
	/**
	 * RoomManager constructor builds an array of Room objects
	 */
	public RoomManager() {
		
		
		//Assign space for 100 Room objects in the Rooms array
		Rooms = new Room[100];
		
		
		//Populate the Rooms array with 4 types of rooms
		/* Loop through 25 times to create 25 rooms with the following characteristics
		 * 2 guests
		 * 1 bed
		 * smoking friendly
		 * pet friendly
		 */
		for(int i = 0; i < 25; i++) {
			Room newRoom = new Room(i, 2, 1, "Vacant", "Vacant", true, true, true);
			Rooms[i] = newRoom;
		}
		
		/* Loop through 25 times to create 25 rooms with the following characteristics
		 * 4 guests
		 * 2 beds
		 * not smoking friendly
		 * pet friendly
		 */
		for(int i = 25; i < 50; i++) {
			Room newRoom = new Room(i, 4, 2, "Vacant", "Vacant", false, true, true);
			Rooms[i] = newRoom;
		}
		
		/* Loop through 25 times to create 25 rooms with the following characteristics
		 * 4 guests
		 * 2 beds
		 * smoking friendly
		 * not pet friendly
		 */
		for(int i = 50; i < 75; i++) {
			Room newRoom = new Room(i, 4, 2, "Vacant", "Vacant", true, false, true);
			Rooms[i] = newRoom;
		}
		
		/* Loop through 25 times to create 25 rooms with the following characteristics
		 * 2 guests
		 * 2 beds
		 * not smoking friendly
		 * not pet friendly
		 */
		for(int i = 75; i < 100; i++) {
			Room newRoom = new Room(i, 2, 2, "Vacant", "Vacant", false,false, true);
			Rooms[i] = newRoom;
		}
		
		
	}
	
	
	/**
	 * Searches the Rooms array for rooms that match guest input criteria
	 * 
	 * @param g - number of guests that will stay
	 * @param b - number of needed beds in the room
	 * @param sF - guest preference for rooms that are smoking friendly
	 * @param pF - guest preference for rooms that are pet friendly
	 * @return an int array of room numbers that match guest input criteria
	 */
	public int[] systemSearch(int g, int b, boolean sF, boolean pF) {
		
		
		//Array of available rooms
		int[] availableRooms = new int[100];
		
		
		//Loop through Rooms array to find a room that matches the criteria
		for(int i = 0; i < 100; i++) {
			if (Rooms[i].isVacant)
				if(Rooms[i].getGuests() >= g)
					if(Rooms[i].getBeds() >= b)
						if(Rooms[i].isSmokingFriendly == sF)
							if(Rooms[i].isPetFriendly == pF)
								availableRooms[i] = i;
								
		}
		
		
		//Return array of available rooms
		return availableRooms;
		
		
	}
	
	
	/**
	 * Reserves a guest-selected room
	 * 
	 * @param rN - the room number the guest selected
	 * @param cI - the guest's check in date
	 * @param cO - the guest's check out date
	 */
	public void reserveRoom(int rN, String cI, String cO) {
		Rooms[rN].setCheckIn(cI);
		Rooms[rN].setCheckOut(cO);
		Rooms[rN].setVacancy(true);
	}
	
	
	/**
	 * Checks out a guest from the room
	 * 
	 * @param rN
	 */
	public void checkOutRoom(int rN) {
		Rooms[rN].setCheckIn("Vacant");
		Rooms[rN].setCheckOut("Vacant");
		Rooms[rN].setVacancy(false);
	}
	

}