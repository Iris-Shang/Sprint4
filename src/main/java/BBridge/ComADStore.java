package BBridge;

public class ComADStore implements ServiceStrore
{

	@Override
	public Service createService(int serviceID,String Adtype, String ownername)
	{
		Service s = null;
		if (Adtype == "Com") 
		{
			s = new ComAD(serviceID, Adtype,ownername);
			
		}

		return s;
	}

	@Override
	public Service orderService(int serviceid, String specifictype, String ownername)
	{
		
		Service s = createService(serviceid,specifictype, ownername);
		if (s != null) 
		{
			s.doService();
		}
		return s;
	}


}
