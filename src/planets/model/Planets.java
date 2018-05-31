package planets.model;

import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.net.*;

public abstract class Planets 
{
	private long distance;
	private int diameter;
	private int moons;
	private int number; //Meaning number from sun
	private String name;
	private double orbit;
	
	public Planets(int number, String name)
	{
		this.name = name;
		this.number = number;
	}
	
	public final String[] getPlanetsTypes()
	{
		String [] types = null;
		ArrayList<String> parentType = new ArrayList<String>();
		Class<?> currentClass = this.getClass();
		
		while(currentClass.getSuperclass() != null)
		{
			Class<?> [] planetsTypes = currentClass.getInterfaces();
			types = new String[planetsTypes.length];
			

			for(int index = 0; index < types.length; index++)
			{
				String currentInterface = planetsTypes[index].getCanonicalName();
				currentInterface = currentInterface.replace(this.getClass().getPackage().getName() + ".", "");
				if(!parentType.contains(currentInterface))
				{
					parentType.add(currentInterface);
				}
			}
			
			currentClass = currentClass.getSuperclass();
		}
		
		types = new String [parentType.size()];
		
		for(int index = 0; index < parentType.size(); index++)
		{
			types[index] = parentType.get(index);
		}
		
		return types;
	}

	public String getPlanetsInformation()
	{
		String planetInfo = "";
		
		if(this.getClass().getSimpleName().equals("Star"))
		{
			planetInfo = "This planet is a " + this.getClass().getSimpleName();
		}
		else
		{
			planetInfo = "This planet is a " + this.getClass().getSimpleName() + " planet.";
		}
		
		return planetInfo;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}

	public int getMoons() {
		return moons;
	}

	public void setMoons(int moons) {
		this.moons = moons;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getOrbit() {
		return orbit;
	}

	public void setOrbit(double orbit) {
		this.orbit = orbit;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	

}
