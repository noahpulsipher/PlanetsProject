package planets.model;

public class Jupiter extends Planets implements Gas
{
	public Jupiter()
	{
		super(5, "Jupiter");
		setup();
	}
	
	protected void setup()
	{
		this.setDiameter(86881);
		this.setDistance(365366261);
		this.setMoons(53);
		this.setName("Jupiter");
		this.setNumber(5);
		this.setOrbit(12);
	}
}