package planets.model;

public class Sun extends Planets implements Star
{
	public Sun()
	{
		super(0, "Sun");
		setup();
	}
	
	protected void setup()
	{
		this.setDiameter(864337);
		this.setDistance(92955807);
		this.setMoons(0);
		this.setName("Sun");
		this.setNumber(0);
		this.setOrbit(0.0);
	}
	
	public boolean fusion()
	{
		
		return false;
	}
	
	public int heatLevel()
	{
		
		return 0;
	}
	
	public void dies()
	{
		
	}
}
