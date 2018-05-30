package planets.view;

import planets.controller.PlanetsController;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlanetsPanel extends JPanel
{
	private PlanetsController appController;
	private SpringLayout appLayout;
	
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel iconLabel;
	private JLabel distanceLabel;
	private JLabel diameterLabel;
	private JLabel moonsLabel;
	private JLabel orbitLabel;
	
	private JTextField nameField;
	private JTextField numberField;
	private JTextField distanceField;
	private JTextField diameterField;
	private JTextField moonsField;
	private JTextField orbitField;
	
	private JTextArea descriptionArea;
	private JTextArea typeArea;
	
	private JButton saveButton;
	private JButton clearButton;
	private JComboBox planetDropdown;
	
	private JLabel firstType;
	
	public PlanetsPanel(PlanetsController appController)
	{
		super();
		this.appController = appController;
		
		//Initialize GUI data members
		appLayout = new SpringLayout();
		distanceLabel = new JLabel("Distance from earth:");	
		diameterLabel = new JLabel("Diameter:");
		nameLabel = new JLabel("Name:");
		numberLabel = new JLabel("Number from sun:");
		moonsLabel = new JLabel("Number of moons:");
		orbitLabel = new JLabel("1 orbit is:");
		
		iconLabel = new JLabel("", new ImageIcon(getClass().getResource("/pokemon/view/images/Pokemon Default.png")), JLabel.CENTER);
		
		moonsField = new JTextField();
		nameField = new JTextField();
		numberField = new JTextField();
		diameterField = new JTextField();
		distanceField = new JTextField();
		orbitField = new JTextField();
		
		descriptionArea = new JTextArea();
		typeArea = new JTextArea();
		
		saveButton = new JButton("Save");
		clearButton = new JButton("Clear");
		planetDropdown = new JComboBox();
		firstType = new JLabel();
		
		setupComboBox();
		setupTypePanels();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupComboBox()
	{
		DefaultComboBoxModel planetsModel = new DefaultComboBoxModel(appController.convertPlanetList());
		planetDropdown.setModel(planetsModel);
	}
	
	private void setupTypePanels()
	{
		firstType.setSize(50, 50);
	}
	
	private void setupPanel()
	{
		this.setBackground(new Color(220, 20, 60));
		this.setLayout(appLayout);
		
		this.add(orbitLabel);
		this.add(distanceLabel);
		this.add(nameLabel);
		this.add(numberLabel);
		this.add(moonsLabel);
		this.add(diameterLabel);
		this.add(iconLabel);
		
		this.add(moonsField);
		this.add(nameField);
		this.add(numberField);
		this.add(distanceField);
		this.add(orbitField);
		this.add(diameterField);

		this.add(descriptionArea);
		this.add(typeArea);
		
		this.add(saveButton);
		this.add(clearButton);
		this.add(planetDropdown);
		
		this.add(firstType);
		}
	
	private void updateTypePanels()
	{
		String[] types = appController.getPlanetList().get(planetDropdown.getSelectedIndex()).getPlanetsTypes();
		if (types[0].equals("Star"))
		{
			firstType.setBackground(Color.YELLOW);
			firstType.setText("Star");
		}
		else if(types[0].equals("Rock"))
		{
			firstType.setBackground(Color.lightGray);
			firstType.setText("Rock");
		}
		else if (types[0].equals("Gas"))
		{
			firstType.setBackground(Color.GREEN);
			firstType.setText("Gas");
		}
		else
		{
			firstType.setBackground(Color.white);
		}
	}
	
	private void updateImage()
	{
		String path = "/planets/view/images/";
		String defaultName = "Planet Default";
		String name = planetDropdown.getSelectedItem().toString();
		String extension = ".png";
		ImageIcon planetIcon;
		
		try
		{
			planetIcon = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch(NullPointerException missingImageFile)
		{
			planetIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		
		iconLabel.setIcon(planetIcon);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		planetDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int selectedPokemonIndex = planetDropdown.getSelectedIndex();
				updatePlanetListInfo(selectedPokemonIndex);
				updateImage();
				updateTypePanels();
				repaint();
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(appController.isValidDouble(moonsField.getText()) && appController.isValidInteger(distanceField.getText()) && appController.isValidDouble(orbitField.getText()))
				{
					int selected = planetDropdown.getSelectedIndex();
					int distance = Integer.parseInt(distanceField.getText());
					int moons = Integer.parseInt(moonsField.getText());
					double orbit = Double.parseDouble(orbitField.getText());
					int diameter = Integer.parseInt(diameterField.getText());
					
					String name = nameField.getText();
					
					//Send to the controller to modify the Pokemon
					appController.updateSelected(selected, distance, moons, diameter, orbit, name);
				}
			}
		});
	}
	
	private void updatePlanetListInfo(int index)
	{
		//Update basic fields
		diameterField.setText(appController.getPlanetList().get(index).getDiameter() + "");
		nameField.setText(appController.getPlanetList().get(index).getName());
		numberField.setText(appController.getPlanetList().get(index).getNumber() + "");
		moonsField.setText(appController.getPlanetList().get(index).getMoons() + "");
		distanceField.setText(appController.getPlanetList().get(index).getDistance() + "");
		orbitField.setText(appController.getPlanetList().get(index).getOrbit() + "");
		
		//Update text ares
		descriptionArea.setText(appController.getPlanetList().get(index).toString());
		typeArea.setText("");
		
		for(String current : appController.getPlanetList().get(index).getPlanetsTypes())
		{
			typeArea.append(current + "\n");
		}
	}
}
