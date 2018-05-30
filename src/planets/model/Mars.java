package planets.model;

public class Mars extends Planets implements Rock
{
	public Mars()
	{
		super(4, "Mars");
		setup();
	}
	
	protected void setup()
	{
		this.setDiameter(4212);
		this.setDistance(33926867);
		this.setMoons(2);
		this.setName("Mars");
		this.setNumber(4);
		this.setOrbit(1.88);
	}
	
	public boolean hasLife()
	{
		
		return false;
	}
}