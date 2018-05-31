package planets.model;

public class Mercury extends Planets implements Rock
{
	public Mercury()
	{
		super(1, "Mercury");
		setup();
	}
	
	protected void setup()
	{
		this.setDiameter(3032);
		this.setDistance(48000000);
		this.setMoons(0);
		this.setName("Mercury");
		this.setNumber(1);
		this.setOrbit(0.241);
	}
	
	public boolean hasLife()
	{
		
		return false;
	}
}