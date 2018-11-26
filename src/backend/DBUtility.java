package backend;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.oracle.wls.shaded.org.apache.bcel.classfile.Method;


public class DBUtility 

{
	
private DataSource dataSource;



public DBUtility(DataSource theDataSource) 

	{
		dataSource = theDataSource;
	}


// Metod som hämtar alla lediga lägenheter från databasen, skapar ett tillfälligt objekt som motsvarar varje post som motsvarar SQL'n - lediga lägenheter -  och fyller på en lista som returneras av metoden
//  som kan hämtas av Servleten.

public List<Apartment> getApartments() throws Exception 
{
	List<Apartment> emptyApartments = new ArrayList<>();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	try 
	{
		
		conn = dataSource.getConnection();
		
		String query = "select a.id, a.size, a.rooms, a.rent, a.floor, h.address, \n" + 
				"h.postal_code, h.city from Apartment as a join house as h where a.house_number = h.id and a.id \n" + 
				"NOT IN (SELECT apartmentNumber FROM tenant where tenant._until IS NULL) order by h.city, a.size desc";

		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);

		
		while (rs.next()) 
		{
			
			int id = rs.getInt("a.id");
			double size = rs.getDouble("a.size");
			int rooms = rs.getInt("a.rooms");
			double rent = rs.getDouble("a.rent");
			int floor = rs.getInt("a.floor");
			String address = rs.getString("h.address");
			String postal_code = rs.getString("h.postal_code");
			String city = rs.getString("h.city");
	
			Apartment tempApartment = new Apartment(id, size,rooms, rent,floor,address, postal_code, city);
			emptyApartments.add(tempApartment);
			
		}
		
		return emptyApartments;
	}

finally {close(rs, stmt, conn);}
	
	
}  

// Metod som hämtar alla lägeheter, skapar ett tillfälligt objekt som motsvarar varje post i tabellen apartment och fyller på en lista som returneras av metoden
//som kan hämtas av Servleten.

public List<Apartment> getAllApartments() throws Exception 
{
	List<Apartment> Apartments = new ArrayList<>();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	try 
	{
	
		
		conn = dataSource.getConnection();
		
		String query = "select a.id, a.size, a.rooms, a.rent, a.floor, h.address, \n" + 
				"h.postal_code, h.city from Apartment as a join house as h where a.house_number = h.id order by h.city, a.size desc";

		
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(query);

		
		while (rs.next()) 
		{
			
			int id = rs.getInt("a.id");
			double size = rs.getDouble("a.size");
			int rooms = rs.getInt("a.rooms");
			double rent = rs.getDouble("a.rent");
			int floor = rs.getInt("a.floor");
			String address = rs.getString("h.address");
			String postal_code = rs.getString("h.postal_code");
			String city = rs.getString("h.city");
			
			Apartment tempApartment = new Apartment(id, size,rooms, rent,floor,address, postal_code, city);
			Apartments.add(tempApartment);
			
			
		}
		
		
		System.out.println(Apartments);
		return Apartments;
	}

finally {close(rs, stmt, conn);}
	
	
}  

// Metod som hämtar alla hyresgäster, returnerar en lista på dessa
public List<Tenant> getTenants() throws Exception
{
	
	List<Tenant> tenants = new ArrayList<>();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try 
		{
		
			conn = dataSource.getConnection();
			
			
			String query = "select t.id, t.firstname, t.lastname, h.address, h.postal_code, h.city,"
					+ " t.mobile from apartment as a join Tenant as t  "
					+ "on t.apartmentNumber = a.id join House as h on h.id = a.house_number "
					+ "where t._until  IS NULL  order by t.id desc";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while (rs.next()) 
			{
				int id = rs.getInt("t.id");
				String firstName = rs.getString("t.firstname");
				String lastName = rs.getString("t.lastname");
				String address = rs.getString("h.address");
				String postal_code = rs.getString("h.postal_code");
				String city = rs.getString("h.city");
				String mobile = rs.getString("t.mobile");
				
				
				Tenant tempTenant = new Tenant(id, firstName,lastName, address, postal_code, city, mobile);
				tenants.add(tempTenant);
				
			}
			
			
			
			return tenants;
		}
	
	finally {close(rs, stmt, conn);}
	
	
}
// Gjorde en metod för att stänga alla uppkopplingar men använde den nog bara en gång:)

private void close(ResultSet rs, Statement stmt, Connection conn) {
	try {if (rs != null) {rs.close();}
	if (stmt != null) {stmt.close();}
	if (conn != null) {conn.close();}
	}
	catch(Exception e) {e.printStackTrace();}
	
	
}


// Metod som lägger till en hyresgäst till databasen utifrån ett objekt som skickas in i metoden från Servleten

public void addTenant(Tenant tempTenant) throws SQLException 

	{
		
		Connection conn = null;	
		PreparedStatement pstmt= null;
		String query ="";
	
		try {
			conn = dataSource.getConnection();
			query = "insert into Tenant (apartmentNumber, firstName, lastName, "
					+ "ss_number,mobile, email, _from,_until, notes) "
					+ "values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tempTenant.getApartmentNumber());
			pstmt.setString(2, tempTenant.getFirstName());
			pstmt.setString(3, tempTenant.getLastName());
			pstmt.setString(4, tempTenant.getSs_number());
			pstmt.setString(5, tempTenant.getMobile());
			pstmt.setString(6, tempTenant.getEmail());
			pstmt.setString(7, tempTenant.get_from());
			pstmt.setString(8, tempTenant.get_until());
			pstmt.setString(9, tempTenant.getNotes());
			pstmt.execute();
			
		} 
		
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		
		finally {conn.close(); pstmt.close(); conn.close();}	
	
	}

// Metod som hämtar en ledig lägenhet baserat på ID som skickas från JSP/servleten, ett objekt av typen Apartment returneras

public Apartment getEmptyA(String emptyA_ID) throws Exception 
{
	Apartment theApartment = null;
	Connection conn = null;
	PreparedStatement statement = null;
	ResultSet rs = null;
	int ApartmentID;
	
	
	try {
		
	ApartmentID = Integer.parseInt(emptyA_ID);
	conn = dataSource.getConnection();
	String sql = "select a.rent, a.bofond, a.fridge,a.freezer,a.stove, a.notes, h.address, "
			+ "h.postal_code, h.city from Apartment as a join house as h on h.id=a.house_number "
			+ "where a.id =?";
	statement = conn.prepareStatement(sql);
	statement.setInt(1, ApartmentID);
	rs = statement.executeQuery();
	
	if (rs.next()) 
	{
		
		double rent = rs.getDouble("a.rent");
		double bofond = rs.getDouble("a.bofond");
		String fridge = rs.getString("a.fridge");
		String freezer = rs.getString("a.freezer");
		String stove = rs.getString("a.stove");
		String a_notes = rs.getString("a.notes");
		String address = rs.getString("h.address");
		String postal_code = rs.getString("h.postal_code");
		String city = rs.getString("h.city");
		
		theApartment = new Apartment(address, postal_code, city, ApartmentID,rent,bofond,fridge,freezer,stove,a_notes);	
		
	}
	
	else {throw new Exception("Kunde inte hitta Lägenhetens ID " + ApartmentID); }
	
	return theApartment;
	}

	finally {conn.close(); statement.close(); rs.close();
		
		
	}
}

// Metod som hämtar en hyresgäst

public Tenant getTenant(String theTenantID) throws Exception
{
	Tenant theTenant = null;
	Connection conn = null;
	PreparedStatement statement = null;
	ResultSet rs = null;
	int tenantID;
	
	
	try {
		
	tenantID = Integer.parseInt(theTenantID);
	
	conn = dataSource.getConnection();
	String sql = "select * from Tenant where id =?";
	statement = conn.prepareStatement(sql);
	statement.setInt(1, tenantID);
	rs = statement.executeQuery();
	
	if (rs.next()) 
	{
		int apartmentNumber = rs.getInt("apartmentNumber");
		String firstName = rs.getString("firstName");
		String lastName = rs.getString("lastName");
		String ss_number = rs.getString("ss_number");
		String mobile = rs.getString("mobile");
		String email = rs.getString("email");
		String _from = rs.getString("_from");
		String _until = rs.getString("_until");
		String notes = rs.getString("notes");
		
		theTenant = new Tenant(tenantID,apartmentNumber, firstName, lastName, ss_number,mobile, email, _from,_until, notes);
	}
	
	else {throw new Exception("Kunde inte hitta Hyresgästens ID " + tenantID); }
	
	return theTenant;
	}

	finally {conn.close(); statement.close(); rs.close();
			
	}
}

// Hämtar data för att upddatera en lägenhet
public void updateApartment(Apartment tempApartment) throws SQLException 
{
	
	Connection conn=null;
	PreparedStatement statement = null;
	
	
	
	String sql = "update apartment " 
			+ "set rent = ?, bofond= ?, fridge = ?, "
			+ "freezer = ?, stove = ?, notes = ? "
			+ "where id= ?"; 
	System.out.println(sql);
	
	try 
	{
	conn = dataSource.getConnection();
	
	statement= conn.prepareStatement(sql);
	statement.setDouble(1, tempApartment.getRent());
	statement.setDouble(2, tempApartment.getBofond());
	statement.setString(3, tempApartment.getFridge());
	statement.setString(4, tempApartment.getFreezer());
	statement.setString(5, tempApartment.getStove());
	statement.setString(6, tempApartment.getA_notes());
	statement.setInt(7, tempApartment.id);
	
	statement.execute();
	
	}

finally {conn.close(); statement.close();}
	
	
}
//Hämtar data för att upddatera en hyresgäst

public void updateTenant(Tenant tempTenant) throws Exception
{
	
	
	
		Connection conn=null;
		PreparedStatement statement = null;
		
		String sql = "update tenant " 
				+ "set apartmentNumber = ?, firstName= ?, lastName = ?, "
				+ "ss_number = ?, mobile = ?, email = ?, _from = ?, _until = ?, notes = ? "
				+ "where id= ?"; 
		try {
		conn = dataSource.getConnection();
		
		
		
	
		statement= conn.prepareStatement(sql);
		
		statement.setInt(1, tempTenant.getApartmentNumber());
		statement.setString(2, tempTenant.getFirstName());
		statement.setString(3, tempTenant.getLastName());
		statement.setString(4, tempTenant.getSs_number());
		statement.setString(5, tempTenant.getMobile());
		statement.setString(6, tempTenant.getEmail());
		statement.setString(7, tempTenant.get_from());
		statement.setString(8, tempTenant.get_until());
		statement.setString(9, tempTenant.getNotes());
		statement.setInt(10, tempTenant.id);
		
		statement.execute();
		
		}
	
	finally {conn.close(); statement.close();}
		
}

// Tar bort en hyresgäst från databasen


public void deleteTenant(String theTenantID) throws SQLException 
{
	Connection conn=null;
	PreparedStatement statement = null;
	
	try {
		
		int tenantID = Integer.parseInt(theTenantID);
		conn = dataSource.getConnection();
		String sql = "delete from tenant where id =?";
		
		statement= conn.prepareStatement(sql);
		statement.setInt(1, tenantID);
		statement.execute();
		
		}
	
	finally {conn.close(); statement.close();}
	
	
}

// Används vid inloggning, validerar lösenord mot tabellen _admin. 
// Lösenord och användarnamn går genom en metod i klassen PassCrypt som gör om dessa till en sträng med massa omkastade och tillagda bytes.
// Om lösenordet är rätt så returnerar rs.next boolean = true (det finns en rad i tabellen som stämmer mot Queryn som markören kan syälla sig på)
// validateAdmin-metoden kan sedan användas i en ifsats som villkor.

public boolean validateAdmin(String _username, String _password)
{
		
		_password = PassCrypt.hashPassword(_password);
		_username = PassCrypt.hashPassword(_username);
		
	
	boolean status=false;  
	
	Connection conn = null; 
	String query = "select * from _admin where _username =? and _password =?";
	
	
	try {
		conn = dataSource.getConnection();
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, _username);
		pst.setString(2, _password);
		ResultSet rs = pst.executeQuery();

		status = rs.next();
		
		

		}
	
	catch(Exception e){System.out.println(e);}  
	
	return status;  
	}

// Hämtar all information om en lägenhet utifrån subklassen Tenant.
// Objektet Tenant används genom en konstruktor som innehåller alla variabler i superklasserna.
// En lista på alla Tenants som bor i lägenheten med "apartmentID" som skickades in i metoden kanreturneras.


public List<Tenant> getApartmetInfo(String apartmentID) throws Exception 
{
	List<Tenant> apartmentInfoList = new ArrayList<>();
	
	Tenant theTenant = null;
	Connection conn = null;
	PreparedStatement statement = null;
	ResultSet rs = null;
	int _apartmentID;
	
	
	
	try 
	{
		
		_apartmentID = Integer.parseInt(apartmentID);
		conn = dataSource.getConnection();
		
		String sql ="select h.elevator, h.gym, h.sauna, h.storage_room, h.construction_date,h.address,"
				+ "h.postal_code, h.city, a.id, a.house_number, a.size, a.rooms, a.balcony, a.floor, a.bofond,"
				+ "a.rent, a.fridge, a.freezer, a.stove, a.notes, t.id, t.apartmentNumber, t.firstName, t.lastName, "
				+ "t.ss_number, t.mobile, t.email, t._from, t._until,t.notes from apartment as a left join tenant as t on "
				+ "t.apartmentNumber = a.id left join house as h on h.id=a.house_number where a.id = ?";
		
		
		statement = conn.prepareStatement(sql);
		statement.setInt(1, _apartmentID);
		rs = statement.executeQuery();
		
		while (rs.next()) 
			
	{
			boolean elevator = rs.getBoolean("h.elevator");
			boolean gym = rs.getBoolean("h.gym");
			boolean sauna = rs.getBoolean("h.sauna");
			boolean storage_room = rs.getBoolean("h.storage_room");
			String construction_date = rs.getString("h.construction_date");
			String address= rs.getString("h.address");
			String postal_code= rs.getString("h.postal_code");
			String city= rs.getString("h.city");
			int id = rs.getInt("a.id");
			int house_number = rs.getInt("a.house_number");
			double size = rs.getDouble("a.size");
			int rooms= rs.getInt("a.rooms");
			boolean balcony = rs.getBoolean("a.balcony");
			int floor= rs.getInt("a.floor");
			double bofond = rs.getDouble("a.bofond");
			double rent = rs.getDouble("a.rent");
			String fridge= rs.getString("a.fridge");
			String freezer= rs.getString("a.freezer");
			String stove= rs.getString("a.stove");
			String a_notes= rs.getString("a.notes");
			int id2 = rs.getInt("t.id");
			int apartmentNumber = rs.getInt("t.apartmentNumber");
			String firstName = rs.getString("t.firstName");
			String lastName = rs.getString("t.lastName");
			String ss_number = rs.getString("t.ss_number");
			String mobile = rs.getString("t.mobile");
			String email = rs.getString("t.email");
			String _from = rs.getString("t._from");
			String _until = rs.getString("t._until");
			String notes = rs.getString("t.notes");
			
			
		
		theTenant = new Tenant(elevator, gym, sauna, storage_room, construction_date,address,postal_code, city, id, 
				house_number,size, rooms, balcony,floor, bofond, rent, fridge, freezer, stove, a_notes, id2, apartmentNumber,
				firstName, lastName,ss_number, mobile, email,_from, _until, notes );
		
		apartmentInfoList.add(theTenant);
		
	}
	
		
	
	
	
		
	
	
	return apartmentInfoList;
	}

	finally {conn.close(); statement.close(); rs.close();
		
		
	}
}





	
	
}



