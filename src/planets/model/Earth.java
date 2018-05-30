package planets.model;

public class Earth extends Planets implements Rock
{
	public Earth()
	{
		super(3, "Earth");
		setup();
	}
	
	protected void setup()
	{
		this.setDiameter(7918);
		this.setDistance(0);
		this.setMoons(1);
		this.setName("Earth");
		this.setNumber(3);
		this.setOrbit(1.0);
	}
	
	public boolean hasLife()
	{
		
		return true;
	}
}