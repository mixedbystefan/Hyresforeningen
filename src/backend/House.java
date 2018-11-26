package backend;

public class House 
{
	
	int id;
	boolean elevator;
	boolean gym;
	boolean sauna;
	boolean storage_room;
	String construction_date;
	String address;
	String postal_code;
	String city;
	
	public House(String address, String postal_code, String city) 
	{
		
		this.address = address;
		this.postal_code = postal_code;
		this.city = city;
	}

	public House() {
		
	}
	
	public House(boolean elevator, boolean gym, boolean sauna, boolean storage_room, String construction_date,
			String address, String postal_code, String city) {
		super();
		this.elevator = elevator;
		this.gym = gym;
		this.sauna = sauna;
		this.storage_room = storage_room;
		this.construction_date = construction_date;
		this.address = address;
		this.postal_code = postal_code;
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public String getCity() {
		return city;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public int getId() {
		return id;
	}

	public boolean isElevator() {
		return elevator;
	}

	public boolean isGym() {
		return gym;
	}

	public boolean isSauna() {
		return sauna;
	}

	public boolean isStorage_room() {
		return storage_room;
	}

	public String getConstruction_date() {
		return construction_date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}

	public void setGym(boolean gym) {
		this.gym = gym;
	}

	public void setSauna(boolean sauna) {
		this.sauna = sauna;
	}

	public void setStorage_room(boolean storage_room) {
		this.storage_room = storage_room;
	}

	public void setConstruction_date(String construction_date) {
		this.construction_date = construction_date;
	}

	public void setCity(String city) {
		this.city = city;
	}


}
