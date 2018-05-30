package planets.model;

public class Uranus extends Planets implements Gas
{
	public Uranus()
	{
		super(7, "Uranus");
		setup();
	}
	
	protected void setup()
	{
		this.setDiameter(31518);
		this.setDistance(1615565100);
		this.setMoons(27);
		this.setName("Uranus");
		this.setNumber(7);
		this.setOrbit(84.00);
	}
}