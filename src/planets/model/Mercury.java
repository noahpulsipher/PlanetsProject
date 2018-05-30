package planets.model;

public class Mercury extends Planets
{
	public Mercury()
	{
		super(1, "Mercury");
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