package backend;

public class Apartment extends House
{
	
	int id;
	int house_number;
	double size;
	int rooms;
	boolean balcony;
	int floor;
	double bofond;
	double rent;
	String fridge;
	String freezer;
	String stove;
	String a_notes;
	
	public Apartment() {}
	
	
	public Apartment(int id, double rent, double bofond, String fridge,
			String freezer, String stove, String a_notes) 
	{
		this.id = id;
		this.bofond = bofond;
		this.rent = rent;
		this.fridge = fridge;
		this.freezer = freezer;
		this.stove = stove;
		this.a_notes = a_notes;
	}
	
	public Apartment(int id, double size, int rooms, double rent,int floor, String address, String postal_code, String city) 
	{
		super(address, postal_code, city);
		this.id = id;
		this.size = size;
		this.rooms = rooms;
		this.floor = floor;
		this.rent = rent;
	}
	
	public Apartment(String address, String postal_code, String city) 
	{
		super(address, postal_code, city);
	}

	public Apartment(String address, String postal_code, String city, int id, double rent, double bofond,
			String fridge, String freezer, String stove, String a_notes) 
	{
		super(address, postal_code, city);
		this.bofond = bofond;
		this.rent = rent;
		this.fridge = fridge;
		this.freezer = freezer;
		this.stove = stove;
		this.a_notes = a_notes;
		this.id=id;
	}
	
	
	public Apartment(boolean elevator, boolean gym, boolean sauna, boolean storage_room, String construction_date,
			String address, String postal_code, String city,int id, int house_number, double size, int rooms, boolean balcony, int floor, double bofond,
			double rent, String fridge, String freezer, String stove, String a_notes) 
	
	{
		super(elevator, gym, sauna, storage_room, construction_date,address,postal_code, city);
		this.id = id;
		this.house_number = house_number;
		this.size = size;
		this.rooms = rooms;
		this.balcony = balcony;
		this.floor = floor;
		this.bofond = bofond;
		this.rent = rent;
		this.fridge = fridge;
		this.freezer = freezer;
		this.stove = stove;
		this.a_notes = a_notes;
	}



	public String getA_notes() 				{return a_notes;}
	public void setA_notes(String a_notes) 	{this.a_notes = a_notes;}
	public int getId() 						{return id;}
	public int getHouse_number() 			{return house_number;}
	public double getSize() 				{return size;}
	public int getRooms() 					{return rooms;}
	public boolean isBalcony() 				{return balcony;}
	public int getFloor() 					{return floor;}
	public double getBofond() 				{return bofond;}
	public double getRent() 				{return rent;}
	public String getFridge() 				{return fridge;}
	public String getFreezer() 				{return freezer;}
	public String getStove() 				{return stove;}
	public void setId(int id) 				{this.id = id;}


	public void setHouse_number(int house_number) {
		this.house_number = house_number;
	}




	public void setSize(double size) {
		this.size = size;
	}




	public void setRooms(int rooms) {
		this.rooms = rooms;
	}




	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}




	public void setFloor(int floor) {
		this.floor = floor;
	}




	public void setBofond(double bofond) {
		this.bofond = bofond;
	}




	public void setRent(double rent) {
		this.rent = rent;
	}




	public void setFridge(String fridge) {
		this.fridge = fridge;
	}




	public void setFreezer(String freezer) {
		this.freezer = freezer;
	}




	public void setStove(String stove) {
		this.stove = stove;
	}




	






	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return super.getAddress();
	}






	@Override
	public String getPostal_code() {
		// TODO Auto-generated method stub
		return super.getPostal_code();
	}






	@Override
	public String getCity() {
		// TODO Auto-generated method stub
		return super.getCity();
	}






	@Override
	public void setAddress(String address) {
		// TODO Auto-generated method stub
		super.setAddress(address);
	}






	@Override
	public void setPostal_code(String postal_code) {
		// TODO Auto-generated method stub
		super.setPostal_code(postal_code);
	}






	@Override
	public boolean isElevator() {
		// TODO Auto-generated method stub
		return super.isElevator();
	}






	@Override
	public boolean isGym() {
		// TODO Auto-generated method stub
		return super.isGym();
	}






	@Override
	public boolean isSauna() {
		// TODO Auto-generated method stub
		return super.isSauna();
	}






	@Override
	public boolean isStorage_room() {
		// TODO Auto-generated method stub
		return super.isStorage_room();
	}






	@Override
	public String getConstruction_date() {
		// TODO Auto-generated method stub
		return super.getConstruction_date();
	}






	@Override
	public void setElevator(boolean elevator) {
		// TODO Auto-generated method stub
		super.setElevator(elevator);
	}






	@Override
	public void setGym(boolean gym) {
		// TODO Auto-generated method stub
		super.setGym(gym);
	}






	@Override
	public void setSauna(boolean sauna) {
		// TODO Auto-generated method stub
		super.setSauna(sauna);
	}






	@Override
	public void setStorage_room(boolean storage_room) {
				super.setStorage_room(storage_room);
	}






	@Override
	public void setConstruction_date(String construction_date) {
	
		super.setConstruction_date(construction_date);
	}






	@Override
	public void setCity(String city) {
		
		super.setCity(city);
	}






	@Override
	public String toString() {
		return "Apartment [id=" + id + ", house_number=" + house_number + ", size=" + size + ", rooms=" + rooms
				+ ", balcony=" + balcony + ", floor=" + floor + ", bofond=" + bofond + ", rent=" + rent + ", fridge="
				+ fridge + ", freezer=" + freezer + ", stove=" + stove + ", a_notes=" + a_notes + ", elevator=" + elevator
				+ ", gym=" + gym + ", sauna=" + sauna + ", storage_room=" + storage_room + ", construction_date="
				+ construction_date + ", address=" + address + ", postal_code=" + postal_code + ", city=" + city + "]";
	}




	




	
	
	
	

}
