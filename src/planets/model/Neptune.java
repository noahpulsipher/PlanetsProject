package planets.model;

public class Neptune extends Planets
{
	public Neptune()
	{
		super(8, "Neptune");
		setup();
	}
	
	protected void setup()
	{
		this.setDiameter(diameter);
		this.setDistance(distance);
		this.setMoons(moons);
		this.setName(name);
		this.setNumber(number);
		this.setOrbit(orbit);
	}
}