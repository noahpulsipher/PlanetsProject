package planets.model;

import java.util.List;
import java.util.ArrayList;

import java.io.*;
import java.net.*;

public class Mercury extends Planets implements Rock
{
	public Mercury()
	{
		super(1, "Mercury");
		setup();
	}
	
	public String toString()
	{
		String description = "";
		
		List<String> rawInputVals = new ArrayList<String>();
		
		try
		{
			URL valueSite = new URL("https://en.wikipedia.org/wiki/Mercury");
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(valueSite.openStream()));
				
			String inputLine;
	        while ((inputLine = inputReader.readLine()) != null)
	        {
		       	rawInputVals.add(inputLine);
		       	//System.out.println(inputLine);
	        }
				
		    inputReader.close();
		}
		catch(Exception error)
		{
			System.out.println(error);
		}
		
		description = rawInputVals.toString();
		
		return description;
		
		
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