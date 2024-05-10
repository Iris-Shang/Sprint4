package BBridge;

public class ComAD extends Service
{
	String content;
	String type;
	int ID;
	int time;
	int price;

	public ComAD(int serviceID,String Adtype, String ownername) 
	{
		//Person A = new Person();
		this.ID = serviceID;
		//this.ownerID = owner;
		this.type = Adtype;
		this.time = 30;
		this.price = 3000;
		//String ownername = A.findacom(owner).name;
		String content = "LOOK AT ME!! I AM COMPANY" + ownername;
		this.content = content;
		
	}
	@Override
	public void doService()
	{
		Advertisement a = new Advertisement(this.ID,this.content,this.time);
		a.createinrest();
		
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
