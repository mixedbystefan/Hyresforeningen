package backend;

public class Admin 
{
	String _username;
	String _password;
	public Admin(String _username, String _password) {
		super();
		this._username = _username;
		this._password = _password;
	}
	public String get_username() {
		return _username;
	}
	public String get_password() {
		return _password;
	}
	public void set_username(String _username) {
		this._username = _username;
	}
	public void set_password(String _password) {
		this._password = _password;
	}
	
	

}
