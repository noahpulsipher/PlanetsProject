package planets.model;

public class Sun extends Planets
{
	public Sun()
	{
		super(0, "Sun");
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
