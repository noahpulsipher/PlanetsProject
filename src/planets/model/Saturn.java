package planets.model;

public class Saturn extends Planets
{
	public Saturn()
	{
		super(6, "Saturn");
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