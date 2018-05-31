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
		appLayout.putConstraint(SpringLayout.NORTH, distanceLabel, 3, SpringLayout.SOUTH, diameterLabel);
		nameLabel = new JLabel("Name:");
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 3, SpringLayout.NORTH, this);
		moonsLabel = new JLabel("Number of moons:");
		appLayout.putConstraint(SpringLayout.NORTH, moonsLabel, 3, SpringLayout.SOUTH, distanceLabel);
		orbitLabel = new JLabel("1 orbit is:");
		appLayout.putConstraint(SpringLayout.NORTH, orbitLabel, 3, SpringLayout.SOUTH, moonsLabel);
		
		iconLabel = new JLabel("", new ImageIcon(getClass().getResource("/planets/view/images/solar system.jpg")), JLabel.CENTER);
		appLayout.putConstraint(SpringLayout.WEST, orbitLabel, 3, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, moonsLabel, 3, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, distanceLabel, 3, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, diameterLabel, 3, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 3, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.NORTH, iconLabel, 3, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, iconLabel, 3, SpringLayout.WEST, this);
		
		moonsField = new JTextField();
		appLayout.putConstraint(SpringLayout.NORTH, moonsField, 0, SpringLayout.NORTH, moonsLabel);
		appLayout.putConstraint(SpringLayout.WEST, moonsField, 3, SpringLayout.EAST, moonsLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, moonsField, 0, SpringLayout.SOUTH, moonsLabel);
		appLayout.putConstraint(SpringLayout.EAST, moonsField, 27, SpringLayout.EAST, moonsLabel);
		nameField = new JTextField();
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 0, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 3, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, nameField, 0, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.EAST, nameField, 50, SpringLayout.EAST, nameLabel);
		numberField = new JTextField();
		diameterField = new JTextField();
		appLayout.putConstraint(SpringLayout.NORTH, diameterField, 0, SpringLayout.NORTH, diameterLabel);
		appLayout.putConstraint(SpringLayout.WEST, diameterField, 3, SpringLayout.EAST, diameterLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, diameterField, 0, SpringLayout.SOUTH, diameterLabel);
		appLayout.putConstraint(SpringLayout.EAST, diameterField, 60, SpringLayout.EAST, diameterLabel);
		distanceField = new JTextField();
		appLayout.putConstraint(SpringLayout.NORTH, distanceField, 0, SpringLayout.NORTH, distanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, distanceField, 3, SpringLayout.EAST, distanceLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, distanceField, 0, SpringLayout.SOUTH, distanceLabel);
		appLayout.putConstraint(SpringLayout.EAST, distanceField, 85, SpringLayout.EAST, distanceLabel);
		orbitField = new JTextField();
		appLayout.putConstraint(SpringLayout.NORTH, orbitField, 0, SpringLayout.NORTH, orbitLabel);
		appLayout.putConstraint(SpringLayout.WEST, orbitField, 3, SpringLayout.EAST, orbitLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, orbitField, 0, SpringLayout.SOUTH, orbitLabel);
		appLayout.putConstraint(SpringLayout.EAST, orbitField, 30, SpringLayout.EAST, orbitLabel);
		
		descriptionArea = new JTextArea();
		appLayout.putConstraint(SpringLayout.WEST, descriptionArea, 3, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, descriptionArea, 0, SpringLayout.EAST, iconLabel);
		typeArea = new JTextArea();
		appLayout.putConstraint(SpringLayout.NORTH, typeArea, 3, SpringLayout.SOUTH, iconLabel);
		appLayout.putConstraint(SpringLayout.NORTH, descriptionArea, 3, SpringLayout.SOUTH, typeArea);
		appLayout.putConstraint(SpringLayout.WEST, typeArea, 0, SpringLayout.WEST, iconLabel);
		
		saveButton = new JButton("Save");
		appLayout.putConstraint(SpringLayout.EAST, typeArea, 0, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.SOUTH, descriptionArea, -3, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 3, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -3, SpringLayout.SOUTH, this);
		clearButton = new JButton("Clear");
		appLayout.putConstraint(SpringLayout.WEST, clearButton, 3, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.SOUTH, clearButton, -3, SpringLayout.SOUTH, this);
		planetDropdown = new JComboBox();
		appLayout.putConstraint(SpringLayout.NORTH, planetDropdown, 3, SpringLayout.SOUTH, iconLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, planetDropdown, -3, SpringLayout.NORTH, descriptionArea);
		appLayout.putConstraint(SpringLayout.EAST, planetDropdown, 0, SpringLayout.EAST, iconLabel);
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
		numberLabel = new JLabel("Number from sun:");

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
		String extension = ".jpg";
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
		appLayout.putConstraint(SpringLayout.NORTH, firstType, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, firstType, 3, SpringLayout.EAST, clearButton);
		appLayout.putConstraint(SpringLayout.SOUTH, firstType, -3, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, firstType, -250, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, numberField, 30, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 3, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, 0, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 3, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, numberField, 0, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, diameterLabel, 3, SpringLayout.SOUTH, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 3, SpringLayout.SOUTH, nameLabel);
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
