package planets.model;

public class Uranus extends Planets
{
	public Uranus()
	{
		super(7, "Uranus");
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