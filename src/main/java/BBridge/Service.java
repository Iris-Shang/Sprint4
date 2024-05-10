package BBridge;

public abstract class Service
{
	int time;
	int price;
	//int ownerID;
	public Service() {}
	public abstract void doService();
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
	 * @return the price
	 */
	public int getPrice()
	{
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price)
	{
		this.price = price;
	}

	

}
