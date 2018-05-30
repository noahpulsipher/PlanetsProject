package planets.controller;

import planets.model.Planets;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class FileController
{
	public static void savePlanetsToFile(ArrayList<Planets> pokedex)
	{
		File saveFile = new File("Saved Planets.txt");
		try
		{
			PrintWriter writeToDisk = new PrintWriter(saveFile);
			
			for(int index = 0; index < pokedex.size(); index ++)
			{
				
				

			}
			writeToDisk.close();
		}
		catch(FileNotFoundException error)
		{
			System.out.println("There was an error:" + error.getMessage());
		}
	}
	
	public static String readPlanetsFromFile()
	{
		String contents = "";
		String path = "Saved Planets.txt";
		try
		{
			Scanner fileScanner = new Scanner(new File(path));
			while(fileScanner.hasNextLine())
			{
				String row = fileScanner.nextLine();
				contents += row + "\n";
			}
			fileScanner.close();
		}
		catch (FileNotFoundException error)
		{
			System.out.println("There was an error:" + error.getMessage());
		}
		
		return contents;
	}
}