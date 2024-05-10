package BBridge;

import java.util.Objects;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class Advertisement
{
	String content;
	int time;
	int ID;
	public Advertisement() {}
	public Advertisement(int ID,String content,int time) 
	{
		this.ID = ID;
		this.time = time;
		this.content = content;
		
	}
	
	@SuppressWarnings("unused")
	public void createinrest() 
	{
		//when user create an account, create an object at the same time to rest to save data
		RestClient client = RestClient.create();
		
		String uriBase = "http://localhost:9000/v1";
		String urib = uriBase+"/Project1/Advertisement/"+this.ID;

		String savedata = client.post()
		.uri(urib)
		.contentType(MediaType.APPLICATION_JSON)
		.body(this)
		.retrieve()
		.body(String.class);		
		
	}
	@SuppressWarnings("unused")
	public void updateinrest() 
	{
		RestClient client = RestClient.create();
		
		String uriBase = "http://localhost:9000/v1";
		String urib = uriBase+"/Project1/Advertisement/"+this.ID;

		String savedata = client.put()
		.uri(urib)
		.contentType(MediaType.APPLICATION_JSON)
		.body(this)
		.retrieve()
		.body(String.class);

		
	}
	public Advertisement readfromServer() 
	{
		RestClient client = RestClient.create();
		
		String uriBase = "http://localhost:9000/v1";
		String urib = uriBase+"/Project1/Advertisement/"+this.ID;
		String read = client.get()
				  .uri(urib)
				  .retrieve()
				  .body(String.class);
		System.out.println(read);
		DSAD reada = client.get()
				  .uri(urib)
				  .retrieve()
				  .body(DSAD.class);
		//return null;
		return reada.data();
		
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(ID, content, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Advertisement other = (Advertisement) obj;
		return ID == other.ID && Objects.equals(content, other.content) && time == other.time;
	}

	/**
	 * @return the content
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	/**
	 * @return the time
	 */
	public int getTime()
	{
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time)
	{
		this.time = time;
	}

	/**
	 * @return the iD
	 */
	public int getID()
	{
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD)
	{
		ID = iD;
	}

	@Override
	public String toString()
	{
		return content;
	}
	
	

}
