package vo;

public class StateVO {

	private int id;
	private String sname;
	
	private String sdesc;
	
	private CountryVO cvo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public CountryVO getCvo() {
		return cvo;
	}
	public void setCvo(CountryVO cvo) {
		this.cvo = cvo;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSdesc() {
		return sdesc;
	}
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
}
