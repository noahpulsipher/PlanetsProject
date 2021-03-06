package planets.controller;

import planets.model.*;
import planets.view.PlanetsFrame;

import java.util.List;
import java.util.ArrayList;

public class PlanetsController
{
	private List<Planets> planetList;
	private PlanetsFrame appFrame;
	
	public PlanetsController()
	{
		planetList = new ArrayList<Planets>();	
		buildPlanetList();

		appFrame = new PlanetsFrame(this);
	}
	
	public void buildPlanetList()
	{
		planetList.add(new Sun());
		planetList.add(new Mercury());
		planetList.add(new Venus());
		planetList.add(new Earth());
		planetList.add(new Mars());
		planetList.add(new Jupiter());
		planetList.add(new Uranus());
		planetList.add(new Neptune());
	}
	
	public List<Planets> getPlanetList()
	{
		return planetList;
	}
	
	public boolean isValidInteger(String input)
	{
		boolean validInt = false;
		
		if(input != null)
		{
			validInt = true;
		}
		
		return validInt;
	}
	
	public boolean isValidDouble(String input)
	{
		boolean validDouble = false;
		
		if(input != null)
		{
			validDouble = true;
		}
		
		return validDouble;
	}
	
	public String [] convertPlanetList()
	{
		String [] names = new String [planetList.size()];
		
		for (int index = 0; index < planetList.size(); index ++)
		{
			names[index] = planetList.get(index).getName();
		}
		
		return names;
	}
	
	public void updateSelected(int selection, int distance, int moons, int diameter, double orbit, String name)
	{
		Planets selected = planetList.get(selection);
		
		
		FileController.savePlanetsToFile((ArrayList<Planets>) planetList);
	}
	
}
