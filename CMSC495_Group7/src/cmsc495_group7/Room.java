package cmsc495_group7;
/**
 * Room class. Allows creation of a Room object with properties that can be queried by the system based on guest criteria.
 * 
 * @author Van Chadrick Villondo, Jason Cain, Marcus Goodwin
 * @date Initial Date of Creation: 04/26/2020
 */
public class Room {
	
	//Room attributes
	int roomNum;
	int numberOfGuests;
	int numberOfBeds;
	String checkInDate;
	String checkOutDate;
	boolean isSmokingFriendly;
	boolean isPetFriendly;
	boolean isVacant;
	
	/**
	 * Default Room constructor if no parameters are passed for creation
	 */
	public Room() {
		roomNum = 0;
		numberOfGuests = 0;
		numberOfBeds = 0;
		checkInDate = "";
		checkOutDate = "";
		isSmokingFriendly = true;
		isPetFriendly = true;
		isVacant = true;
	}
	
	/**
	 * Room constructor for rooms with specific criteria
	 * 
	 * @param rn - room number
	 * @param nOG - number of guests the room can accommodate
	 * @param nOB - number of beds in the room
	 * @param cID - check in date in the form of MM/DD/YYYY
	 * @param cOD - check out date in the form of MM/DD/YYYY
	 * @param iSF - identifier for if the room is smoking-friendly
	 * @param iPF - identifier for if the room is pet-friendly
	 */
	public Room(int rn, int nOG, int nOB, String cID, String cOD, boolean iSF, boolean iPF, boolean v) {
		roomNum = rn;
		numberOfGuests = nOG;
		numberOfBeds = nOB;
		checkInDate = cID;
		checkOutDate = cOD;
		isSmokingFriendly = iSF;
		isPetFriendly = iPF;
		isVacant = v;
	}
	
	/**
	 * Get method for room number
	 * 
	 * @return the specified room number
	 */
	public int getRoomNumber() {
		return roomNum;
	}
	
	/**
	 * Get method for number of guests
	 * 
	 * @return the number of guests the room can accommodate
	 */
	public int getGuests() {
		return numberOfGuests;
	}
	
	/**
	 * Get method for number of beds
	 * 
	 * @return the number of beds in the room
	 */
	public int getBeds() {
		return numberOfBeds;
	}
	
	/**
	 * Get method for check in date for the room
	 * 
	 * @return the check in date the room occupancy begins
	 * @room will be unavailable on this day
	 */
	public String getCheckIn() {
		return checkInDate;
	}
	
	/**
	 * Set method for check in date
	 * 
	 * @param cI - the room's check in date
	 */
	public void setCheckIn(String cI) {
		checkInDate = cI;
	}
	
	/**
	 * Get method for check out date for the room
	 * 
	 * @return the check out date when the room occupancy ends
	 * @room will be available again on this day
	 */
	public String getCheckOut() {
		return checkOutDate;
	}
	
	/**
	 * Set method for check out date
	 * 
	 * @param cO - the room's check out date
	 */
	public void setCheckOut(String cO) {
		checkOutDate = cO;
	}
	
	/**
	 * Set method for vacancy status
	 * 
	 * @param v - the vacancy status of the room
	 */
	public void setVacancy(boolean v) {
		isVacant = v;
	}
}