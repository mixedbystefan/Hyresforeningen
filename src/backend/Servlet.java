package backend;

import java.io.IOException;

import java.time.LocalDateTime;
import java.util.List;


import javax.annotation.Resource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

// Talar om sökvägen till Servleten

@WebServlet("/Servlet")

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBUtility dBUtility;
	
	int count =1;
	Boolean Validmess = true;
	String _command;
	
	// Säger åt Tomcat att hämta info från contextfilen där name= jdbc/Hyresforeningen
	@Resource(name="jdbc/Hyresforeningen")
	private DataSource dataSource;

	// init är en override-metod från superklassen och fungerar som en konstruktor, skapar en instans av DBUtility med en uppkoppling
	@Override
	public void init() throws ServletException 
	
	{
		super.init();
		try {dBUtility = new DBUtility(dataSource);}
		catch (Exception e) {throw new ServletException(e);}
	}
	
	// doGet-metoden anropas från JSP-sidan genom ett form action = servlet, method "GET"
	// command hämtas från diverse JSP-sida och styr vilket case som anropas.
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			_command = request.getParameter("command");
			
			if (_command == null) {_command = "VALIDATE";}
			
			switch (_command) 
			{
			
			
			case "VALIDATE":
				
				if (Validmess == false) 
				{
					listEmptyA(request, response);
					_command="LOAD_EMPTY_A";
				}
				else {doPost(request, response);}
				break;
			case "LIST":
				listTenants(request, response);
				break;
			
			case "LIST_EMPTY_A":
				listEmptyA(request, response);
				break;
				
			case "LIST_A":
				listA(request, response);
				break;
			
			case "ADD" :
				addTenant(request, response);
				break;
				
			case "ADD_FROM_ID" :
				addTenant_from_id(request, response);
				break;	
				
			case "LOAD" :
				loadTenant(request, response);
				break;
				
			case "LOAD_A" :
				loadA(request, response);
				break;
				
			case "UPDATE" :
				updateTenant(request, response);
				break;
				
			case "UPDATE_APARTMENT" :
				updateApartment(request, response);
				break;
				
			case "INFO_APARTMENT" :
				infoApartment(request, response);
				break;
				
			case "DELETE" :
				deleteTenant(request, response);
				break;
				
			
				default:
						
					addTenant_from_id(request, response);
			
			}
			
			listTenants(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	
	

	
// Hämtar lägenheter genom att först hämta ID från JSP-sidan, sedan anropa DBUtiliy där lägenheten med detta ID hämtas och läggs till
// det request som sedan skickas till JSP sidan. Eftersom JSP-sidan inte vet om den förra sidan är lediga lägenheter eller Alla lägenheter
// så skickas även parametern "from". 
	
	private void loadA(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theA_ID = request.getParameter("A_ID");
		String error_mess = request.getParameter("ERROR_MESS");
		String from = request.getParameter("from");
		
		Apartment theApartment = dBUtility.getEmptyA(theA_ID);
		
		request.setAttribute("THE_E_APARTMENT", theApartment);
		request.setAttribute("ERROR_MESS", error_mess);
		request.setAttribute("FROM", from);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-apartment-form.jsp");
		dispatcher.forward(request, response);
		
	}
	
	// Samma som ovan men en överlagrad version som bär på ett felmeddelande
	
	private void loadA(HttpServletRequest request, HttpServletResponse response,String error) throws Exception {
		String theA_ID = request.getParameter("A_ID");
		String from = request.getParameter("from");
		String error_mess = error;
		Apartment theApartment = dBUtility.getEmptyA(theA_ID);
		
		request.setAttribute("THE_E_APARTMENT", theApartment);
		request.setAttribute("ERROR_MESS", error_mess);
		request.setAttribute("FROM", from);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-apartment-form.jsp");
		dispatcher.forward(request, response);
		
	}
	
	// Här hämtas alla värden från JSP-sidan för att sedan skickas vidare till DBUtility som säger åt databasen att uppdatera lägenheten.
	// Eftersom JSP-sidan sedan automatiskt öppnar föregående sida så används "from" för att avgöra vilken det är.
	
	private void updateApartment(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String from = request.getParameter("from");
		int id = Integer.parseInt(request.getParameter("A_ID"));
		
		
		try 
		{
			double rent = Double.parseDouble(request.getParameter("rent"));
			double bofond = Double.parseDouble(request.getParameter("bofond"));
			String fridge = request.getParameter("fridge");
			String freezer = request.getParameter("freezer");
			String stove = request.getParameter("stove");
			String notes = request.getParameter("notes");
			
			Apartment tempApartment = new Apartment (id, rent, bofond, fridge, freezer, stove, notes);
			
			dBUtility.updateApartment(tempApartment);
			
			if (from.equalsIgnoreCase("empty_a")) 
			{
				listEmptyA(request, response);
			}
			
			if (from.equalsIgnoreCase("all_a")) 
			{
				listA(request, response);
			}
			listEmptyA(request, response);
			
		} catch (Exception e) {
			
			request.setAttribute("THE_E_APARTMENT", id);
			
			loadA(request, response,"Otillåtet värde i ett eller flera fält!" );
			
		}
		
		
		
		

		
	}
	
	// Här anropas DBUtility där en lista på alla lägeheter hämtas och lagras i en ny lista som skickas till JSP-sidan som listar alla lägenheter.

	private void listA(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		List<Apartment> Apartments = dBUtility.getAllApartments();
		
		request.setAttribute("A_LIST", Apartments);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-all-apartments.jsp");
		dispatcher.forward(request, response);
		
	}
	
	// Samma som ovan men här hämtas bara de lediga lägenheterna och mostvarande JSP-sida
	
	private void listEmptyA(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Apartment> emptyApartments = dBUtility.getApartments();
		
		request.setAttribute("EMPTY_A_LIST", emptyApartments);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-empty-apartments.jsp");
		dispatcher.forward(request, response);
	}
	
	// Hämtar alla information om en lägenhet (vilket kräver en lista av subklassen Tenant)
	// ID'et skickas till metoden vilket avgör vilken lägenhet som ska hämtas. 

	private void infoApartment(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String apartmentID = request.getParameter("A_ID");
		List<Tenant> apartmentInfo = dBUtility.getApartmetInfo(apartmentID);
		request.setAttribute("INFOAPARTMENT", apartmentInfo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/apartment-info.jsp");
		dispatcher.forward(request, response);
		
	}

	// Hämtar en lista på alla hyresgäster och skickar en lista på dessa till JSP-list tenants
	
	private void listTenants(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
			List<Tenant> tenants = dBUtility.getTenants();
			
			request.setAttribute("TENANT_LIST", tenants);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-tenants.jsp");
			dispatcher.forward(request, response);	
			
	}
	// Anropar DBUtility för att ta bort en hyresgäst - Skickar med ID till den hyresgäst som ska rederas från tabellen

	private void deleteTenant(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		
		String theTenantID = request.getParameter("tenantID");
		dBUtility.deleteTenant(theTenantID);	
	}
	
	// Hämtar en hyresgäst baserat på ID från databasen och fyller formuläret i update-tenant-form.JSP

	private void loadTenant(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String theTenantID = request.getParameter("tenantID");
		Tenant theTenant = dBUtility.getTenant(theTenantID);
		request.setAttribute("THE_TENANT", theTenant);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-tenant-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	// Hämtar information från alla input-fält på JSP-sidan, skapar ett objekt som motsvarar en tabellrad och skickar vidare dessa till DBUtility
	// För att uppdatera en hyresgäst.
	
	private void updateTenant(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	
		int id = Integer.parseInt(request.getParameter("tenantID"));
		int apartmentNumber = Integer.parseInt(request.getParameter("apartmentNumber"));
		String firstName = request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		String ss_number= request.getParameter("ss_number");
		String mobile= request.getParameter("mobile");
		String email= request.getParameter("email");
		String _from= request.getParameter("_from");
		String _until= request.getParameter("_until");
		if (_until.equalsIgnoreCase("")) {_until = null;}
		String notes= request.getParameter("notes");
		
		Tenant tempTenant = new Tenant(id, apartmentNumber, firstName, lastName, ss_number,mobile, email, _from,_until, notes);
		
		
		
		dBUtility.updateTenant(tempTenant);
		
		
		listTenants(request, response);
	}
	
	// Lägger till en hyresgäst genom att hämta parametervärden från JSP-sidans input-fält, skapar ett objekt av dessa som skickas till DBUtility
	// där objektet sätter värden på en ny tabellrad som skickas till databasen.
	
private void addTenant(HttpServletRequest request, HttpServletResponse response) throws Exception 
	
	{
		
		int apartmentNumber = Integer.parseInt(request.getParameter("apartmentNumber"));
		String firstName = request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		String ss_number= request.getParameter("ss_number");
		String mobile= request.getParameter("mobile");
		String email= request.getParameter("email");
		String _from= request.getParameter("_from");
		String _until= request.getParameter("_until");
		String notes= request.getParameter("notes");
		
		
		Tenant tempTenant = new Tenant(apartmentNumber, firstName, lastName, ss_number,mobile, email, _from,_until, notes);
		dBUtility.addTenant(tempTenant);
		
		listTenants(request, response);	
	}

// Lägger till en hyresgäst utifrån ID när en lägehet hyrs ut, den plockar med sig lägenhetsnummer och dagens datum som inflyttningsdatum
// substring körs på datumet för att skala bort tiden då grundformatet är datum & Tid med SQL-databasen vill bara ha datum.

private void addTenant_from_id(HttpServletRequest request, HttpServletResponse response) throws Exception 

{
	
	int emptyA_ID = Integer.parseInt(request.getParameter("emptyA_ID"));
	LocalDateTime date = LocalDateTime.now();
	String _today = date.toString();
	String today = _today.substring(0, 10);
	
	request.setAttribute("THE_APARTMENT", emptyA_ID);
	request.setAttribute("DATE", today);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/add-tenant-form_from_ID.jsp");
	dispatcher.forward(request, response);
	listTenants(request, response);	
}

// Denna metod används bara vid login, här hämtas informationen via "POST" vilket bl.a. innebär att den inte skickas via URL'en.
// If-satsen säger att om den boolean som returneras från DBUtilitysidan (som jämför input av lösenord mot databasen) = true så är lösenodet rätt
// List empty apartment kan öppnas. I annat fall skickas "fel anv el lös" till JSP-sidan och loginsidan "öppnas igen".
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");  
		String validation;
	  
		String _username = request.getParameter("_username");
		String _password = ((ServletRequest) request).getParameter("_password");
		
		
		
			
			
			 if(dBUtility.validateAdmin(_username, _password)){  
				 _command = "LIST_EMPTY_A";
				 
				
				 try {
					listEmptyA(request, response);
					Validmess = false;
				} catch (Exception e) {
					
					e.printStackTrace();
				}	
				 
			    }  
			    else
			    {  
			    	
			    	
			    	validation = "Fel användarnamn eller lösenord";
			    	
			        request.setAttribute("VALID", validation);
			        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
			        rd.forward(request,response);  
			    }  
		
	}
	
	


}
