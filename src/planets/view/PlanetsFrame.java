package planets.view;

import planets.controller.PlanetsController;
import javax.swing.JFrame;

public class PlanetsFrame extends JFrame
{
	private PlanetsController appController;
	private PlanetsPanel appPanel;
	
	public PlanetsFrame(PlanetsController appController)
	{
		super();
		this.appController = appController;
		appPanel = new PlanetsPanel(appController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("Planet Guide");
		this.setResizable(true);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public PlanetsController getPokemonController()
	{
		return appController;
	}
}
