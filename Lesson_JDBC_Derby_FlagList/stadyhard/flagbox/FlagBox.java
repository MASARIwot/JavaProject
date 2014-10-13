package flagbox;

/**
 * This is a Box For flag information
 * @author Саня
 *
 */

public class FlagBox {
	 
	 private int id;
	 private int adres;
	 private int sqvere;
	 private int room;
	 private String streat;
	 private String type;
	 private int timeOfUse;
	/**
	 * 
	 * @param id
	 * @param adres
	 * @param sqvere
	 * @param room
	 * @param streat
	 * @param type
	 * @param time
	 */
	 public FlagBox(int id , int adres ,int sqvere,int room,String streat,String type, int time){
		this.id = id;
		this.adres = adres;
		this.sqvere = sqvere;
		this.room = room;
		this.type = type;
		this.timeOfUse = time;
		this.streat = streat;
			
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return id;
	}

	/**
	 * @param i the iD to set
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * @return the flatN
	 */
	public int getAdres() {
		return adres;
	}

	/**
	 * @param flatN the flatN to set
	 */
	public void setAdres(int flatN) {
		this.adres = flatN;
	}

	/**
	 * @return the sqvere
	 */
	public int getSqvere() {
		return sqvere;
	}

	/**
	 * @param sqvere the sqvere to set
	 */
	public void setSqvere(int sqvere) {
		this.sqvere = sqvere;
	}

	/**
	 * @return the room
	 */
	public int getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(int room) {
		this.room = room;
	}

	/**
	 * @return the streat
	 */
	public String getStreat() {
		return streat;
	}

	/**
	 * @param streat the streat to set
	 */
	public void setStreat(String streat) {
		this.streat = streat;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return timeOfUse;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.timeOfUse = time;
	}

	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " FlagBox [ID=" + id + ", Adres=" + adres + ", sqvere=" + sqvere
				+ ", room=" + room + ", Streat=" + streat + ", type=" + type
				+ ", Time Of Use=" + timeOfUse + "] \n";
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof FlagBox)){
			return false;
		}
		
		FlagBox other = (FlagBox) obj;
		if (adres != other.adres)
			return false;
		if (id != other.id)
			return false;
		if (room != other.room)
			return false;
		if (sqvere != other.sqvere)
			return false;
		if (streat == null) {
			if (other.streat != null)
				return false;
		} else if (!streat.equals(other.streat))
			return false;
		if (timeOfUse != other.timeOfUse)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
