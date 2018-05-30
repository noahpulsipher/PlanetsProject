package planets.model;

public class Saturn extends Planets implements Gas
{
	public Saturn()
	{
		super(6, "Saturn");
		setup();
	}
	
	protected void setup()
	{
		this.setDiameter(72367);
		this.setDistance(745645431);
		this.setMoons(53);
		this.setName("Saturn");
		this.setNumber(6);
		this.setOrbit(29.0);
	}
}