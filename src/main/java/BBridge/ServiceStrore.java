package BBridge;

public interface ServiceStrore
{
	public Service createService(int serviceID,String Adtype, String ownername);
	public Service orderService(int serviceid, String specifictype, String ownername);

}
