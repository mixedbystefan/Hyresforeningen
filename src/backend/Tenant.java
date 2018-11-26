package backend;

public class Tenant extends Apartment 
{
int id;
int apartmentNumber;
String firstName;
String lastName;
String ss_number;
String mobile;
String email;
String _from;
String _until;
String notes;






// För att skriva ut info kring lägenhet

public Tenant(boolean elevator, boolean gym, boolean sauna, boolean storage_room, String construction_date,
		String address, String postal_code, String city, int id, int house_number, double size, int rooms,
		boolean balcony, int floor, double bofond, double rent, String fridge, String freezer, String stove,
		String a_notes, int id2, int apartmentNumber, String firstName, String lastName, String ss_number, String mobile,
		String email, String _from, String _until, String notes) {
	super(elevator, gym, sauna, storage_room, construction_date, address, postal_code, city, id, house_number, size,
			rooms, balcony, floor, bofond, rent, fridge, freezer, stove, a_notes);
	
	this.id = id2;
	this.apartmentNumber = apartmentNumber;
	this.firstName = firstName;
	this.lastName = lastName;
	this.ss_number = ss_number;
	this.mobile = mobile;
	this.email = email;
	this._from = _from;
	this._until = _until;
	this.notes = notes;
}

public Tenant(int id, int apartmentNumber, String firstName, String lastName, String ss_number, String mobile, String email,
		String _from, String _until, String notes) 
{
	this.id = id;
	this.apartmentNumber = apartmentNumber;
	this.firstName = firstName;
	this.lastName = lastName;
	this.ss_number = ss_number;
	this.mobile = mobile;
	this.email = email;
	this._from = _from;
	this._until = _until;
	this.notes = notes;
}

public Tenant(int apartmentNumber, String firstName, String lastName, String ss_number, String mobile, String email,
		String _from, String _until, String notes) {
	
	this.apartmentNumber = apartmentNumber;
	this.firstName = firstName;
	this.lastName = lastName;
	this.ss_number = ss_number;
	this.mobile = mobile;
	this.email = email;
	this._from = _from;
	this._until = _until;
	this.notes = notes;
}



public Tenant(int id, String firstName, String lastName, String address, String postal_code, String city, String mobile) {
	super(address, postal_code, city);
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.mobile = mobile;
	
}

public int getId() {return id;}

public int getApartmentNumber() {return apartmentNumber;}


public String getFirstName() {return firstName;}

public void setFirstName(String name) {this.firstName = name;}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getSs_number() {
	return ss_number;
}

public void setSs_number(String ss_number) {
	this.ss_number = ss_number;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String get_from() {
	return _from;
}

public void set_from(String _from) {
	this._from = _from;
}

public String get_until() {
	return _until;
}

public void set_until(String _until) {
	this._until = _until;
}

public String getNotes() {
	return notes;
}

public void setNotes(String notes) {
	this.notes = notes;
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
public void setCity(String city) {
	// TODO Auto-generated method stub
	super.setCity(city);
}

@Override
public int getHouse_number() {
	// TODO Auto-generated method stub
	return super.getHouse_number();
}

@Override
public double getSize() {
	// TODO Auto-generated method stub
	return super.getSize();
}

@Override
public int getRooms() {
	// TODO Auto-generated method stub
	return super.getRooms();
}

@Override
public boolean isBalcony() {
	// TODO Auto-generated method stub
	return super.isBalcony();
}

@Override
public int getFloor() {
	// TODO Auto-generated method stub
	return super.getFloor();
}

@Override
public double getBofond() {
	// TODO Auto-generated method stub
	return super.getBofond();
}

@Override
public double getRent() {
	// TODO Auto-generated method stub
	return super.getRent();
}

@Override
public String getFridge() {
	// TODO Auto-generated method stub
	return super.getFridge();
}

@Override
public String getFreezer() {
	// TODO Auto-generated method stub
	return super.getFreezer();
}

@Override
public String getStove() {
	// TODO Auto-generated method stub
	return super.getStove();
}

@Override
public void setHouse_number(int house_number) {
	// TODO Auto-generated method stub
	super.setHouse_number(house_number);
}

@Override
public void setSize(double size) {
	// TODO Auto-generated method stub
	super.setSize(size);
}

@Override
public void setRooms(int rooms) {
	// TODO Auto-generated method stub
	super.setRooms(rooms);
}

@Override
public void setBalcony(boolean balcony) {
	// TODO Auto-generated method stub
	super.setBalcony(balcony);
}

@Override
public void setFloor(int floor) {
	// TODO Auto-generated method stub
	super.setFloor(floor);
}

@Override
public void setBofond(double bofond) {
	// TODO Auto-generated method stub
	super.setBofond(bofond);
}

@Override
public void setRent(double rent) {
	// TODO Auto-generated method stub
	super.setRent(rent);
}

@Override
public void setFridge(String fridge) {
	// TODO Auto-generated method stub
	super.setFridge(fridge);
}

@Override
public void setFreezer(String freezer) {
	// TODO Auto-generated method stub
	super.setFreezer(freezer);
}

@Override
public void setStove(String stove) {
	// TODO Auto-generated method stub
	super.setStove(stove);
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
	// TODO Auto-generated method stub
	super.setStorage_room(storage_room);
}

@Override
public void setConstruction_date(String construction_date) {
	// TODO Auto-generated method stub
	super.setConstruction_date(construction_date);
}

@Override
public String getA_notes() {
	// TODO Auto-generated method stub
	return super.getA_notes();
}

@Override
public void setA_notes(String a_notes) {
	// TODO Auto-generated method stub
	super.setA_notes(a_notes);
}

@Override
public String toString() {
	return "Tenant [id=" + id + ", apartmentNumber=" + apartmentNumber + ", firstName=" + firstName + ", lastName="
			+ lastName + ", ss_number=" + ss_number + ", mobile=" + mobile + ", email=" + email + ", _from=" + _from
			+ ", _until=" + _until + ", notes=" + notes + ", house_number=" + house_number + ", size=" + size
			+ ", rooms=" + rooms + ", balcony=" + balcony + ", floor=" + floor + ", bofond=" + bofond + ", rent=" + rent
			+ ", fridge=" + fridge + ", freezer=" + freezer + ", stove=" + stove + ", a_notes=" + a_notes
			+ ", elevator=" + elevator + ", gym=" + gym + ", sauna=" + sauna + ", storage_room=" + storage_room
			+ ", construction_date=" + construction_date + ", address=" + address + ", postal_code=" + postal_code
			+ ", city=" + city + "]";
}


















}
