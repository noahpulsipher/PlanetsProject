package planets.model;

public class Venus extends Planets implements Rock
{
	public Venus()
	{
		super(2, "Venus");
		setup();
	}
	
	protected void setup()
	{
		this.setDiameter(7521);
		this.setDistance(162000000);
		this.setMoons(0);
		this.setName("Venus");
		this.setNumber(2);
		this.setOrbit(0.62);
	}
	
	public boolean hasLife()
	{
		
		return false;
	}
}