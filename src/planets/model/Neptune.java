package planets.model;

public class Neptune extends Planets implements Gas
{
	public Neptune()
	{
		super(8, "Neptune");
		setup();
	}
	
	protected void setup()
	{
		this.setDiameter(30599);
		this.setDistance(270000000);
		this.setMoons(14);
		this.setName("Neptune");
		this.setNumber(8);
		this.setOrbit(165);
	}
}