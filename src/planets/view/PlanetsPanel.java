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
	private JLabel orbitLabel2;
	private JLabel distanceLabel2;
	private JLabel diameterLabel2;
	
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
	
	private JScrollPane planetScroll;
	
	
	public PlanetsPanel(PlanetsController appController)
	{
		super();
		this.appController = appController;
		
		//Initialize GUI data members
		appLayout = new SpringLayout();
		distanceLabel = new JLabel("Distance from earth:");	
		diameterLabel = new JLabel("Diameter:");
		diameterLabel2 = new JLabel("miles");
		distanceLabel2 = new JLabel("miles");
		nameLabel = new JLabel("Name:");
		moonsLabel = new JLabel("Number of moons:");
		orbitLabel = new JLabel("One orbit is:");
		orbitLabel2 = new JLabel("earth years");
		
		iconLabel = new JLabel("", new ImageIcon(getClass().getResource("/planets/view/images/solar system.jpg")), JLabel.CENTER);
		appLayout.putConstraint(SpringLayout.NORTH, iconLabel, 8, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, iconLabel, 8, SpringLayout.WEST, this);
		moonsField = new JTextField();
		appLayout.putConstraint(SpringLayout.EAST, moonsField, 23, SpringLayout.EAST, moonsLabel);
		nameField = new JTextField();
		numberField = new JTextField();
		diameterField = new JTextField();
		distanceField = new JTextField();
		orbitField = new JTextField();
		appLayout.putConstraint(SpringLayout.EAST, orbitField, 41, SpringLayout.EAST, orbitLabel);

		planetScroll = new JScrollPane();
		
		descriptionArea = new JTextArea();
		appLayout.putConstraint(SpringLayout.WEST, planetScroll, 8, SpringLayout.WEST, this);
		typeArea = new JTextArea();
		
		saveButton = new JButton("Save");
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 8, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -8, SpringLayout.SOUTH, this);
		clearButton = new JButton("Clear");
		appLayout.putConstraint(SpringLayout.SOUTH, clearButton, -8, SpringLayout.SOUTH, this);
	
		planetDropdown = new JComboBox();
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
		setupScrollPane();
	}
	
	private void setupComboBox()
	{
		DefaultComboBoxModel planetsModel = new DefaultComboBoxModel(appController.convertPlanetList());
		planetDropdown.setModel(planetsModel);
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(appLayout);
		
		this.add(orbitLabel);
		this.add(distanceLabel);
		this.add(nameLabel);
		this.add(distanceLabel2);
		this.add(diameterLabel2);
		this.add(orbitLabel2);
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

		this.add(planetScroll);
		this.add(typeArea);
		
		
		
		this.add(saveButton);
		this.add(clearButton);
		this.add(planetDropdown);
		}
	
	private void updateTypePanels()
	{
		String[] types = appController.getPlanetList().get(planetDropdown.getSelectedIndex()).getPlanetsTypes();
		if (types[0].equals("Star"))
		{
			typeArea.setBackground(Color.YELLOW);
			typeArea.setText("Star");
		}
		else if(types[0].equals("Rock"))
		{
			typeArea.setBackground(Color.darkGray);
			typeArea.setText("Rock");
		}
		else if (types[0].equals("Gas"))
		{
			typeArea.setBackground(Color.GREEN);
			typeArea.setText("Gas");
		}
		else
		{
			typeArea.setBackground(Color.white);
		}
	}
	
	private void setupScrollPane()
	{
		planetScroll.setViewportView(descriptionArea);
		planetScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		planetScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		planetScroll.setBackground(Color.LIGHT_GRAY);
		descriptionArea.setBackground(Color.LIGHT_GRAY);
		descriptionArea.setEditable(false);
		descriptionArea.setLineWrap(true);
		descriptionArea.setWrapStyleWord(true);
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
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 8, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, nameField, 54, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, diameterLabel2, 0, SpringLayout.NORTH, diameterLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, diameterLabel2, 0, SpringLayout.SOUTH, diameterLabel);
		appLayout.putConstraint(SpringLayout.NORTH, distanceLabel2, 0, SpringLayout.NORTH, distanceLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, distanceLabel2, 0, SpringLayout.SOUTH, distanceLabel);
		appLayout.putConstraint(SpringLayout.EAST, diameterField, 52, SpringLayout.EAST, diameterLabel);
		appLayout.putConstraint(SpringLayout.WEST, diameterLabel2, 3, SpringLayout.EAST, diameterField);
		appLayout.putConstraint(SpringLayout.EAST, numberField, 15, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.EAST, distanceField, 71, SpringLayout.EAST, distanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, distanceLabel2, 3, SpringLayout.EAST, distanceField);
		appLayout.putConstraint(SpringLayout.NORTH, orbitLabel2, 0, SpringLayout.NORTH, orbitLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, orbitLabel2, 0, SpringLayout.SOUTH, orbitLabel);
		appLayout.putConstraint(SpringLayout.WEST, orbitLabel2, 3, SpringLayout.EAST, orbitField);
		appLayout.putConstraint(SpringLayout.NORTH, moonsLabel, 3, SpringLayout.SOUTH, distanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, orbitLabel, 3, SpringLayout.SOUTH, moonsLabel);
		appLayout.putConstraint(SpringLayout.WEST, orbitLabel, 3, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, moonsLabel, 3, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, distanceLabel, 3, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, diameterLabel, 3, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 3, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.NORTH, moonsField, 0, SpringLayout.NORTH, moonsLabel);
		appLayout.putConstraint(SpringLayout.WEST, moonsField, 3, SpringLayout.EAST, moonsLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, moonsField, 0, SpringLayout.SOUTH, moonsLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameField, 0, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 3, SpringLayout.EAST, nameLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, nameField, 0, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, diameterField, 0, SpringLayout.NORTH, diameterLabel);
		appLayout.putConstraint(SpringLayout.WEST, diameterField, 3, SpringLayout.EAST, diameterLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, diameterField, 0, SpringLayout.SOUTH, diameterLabel);
		appLayout.putConstraint(SpringLayout.NORTH, distanceField, 0, SpringLayout.NORTH, distanceLabel);
		appLayout.putConstraint(SpringLayout.WEST, distanceField, 3, SpringLayout.EAST, distanceLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, distanceField, 0, SpringLayout.SOUTH, distanceLabel);
		appLayout.putConstraint(SpringLayout.NORTH, orbitField, 0, SpringLayout.NORTH, orbitLabel);
		appLayout.putConstraint(SpringLayout.WEST, orbitField, 3, SpringLayout.EAST, orbitLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, orbitField, 0, SpringLayout.SOUTH, orbitLabel);
		appLayout.putConstraint(SpringLayout.NORTH, typeArea, 3, SpringLayout.SOUTH, iconLabel);
		appLayout.putConstraint(SpringLayout.NORTH, planetScroll, 3, SpringLayout.SOUTH, typeArea);
		appLayout.putConstraint(SpringLayout.WEST, typeArea, 0, SpringLayout.WEST, iconLabel);
		appLayout.putConstraint(SpringLayout.EAST, planetScroll, 0, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.EAST, typeArea, 0, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.SOUTH, planetScroll, -3, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.WEST, clearButton, 3, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.NORTH, planetDropdown, 3, SpringLayout.SOUTH, iconLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, planetDropdown, -3, SpringLayout.NORTH, planetScroll);
		appLayout.putConstraint(SpringLayout.EAST, planetDropdown, 0, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.NORTH, distanceLabel, 3, SpringLayout.SOUTH, diameterLabel);
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
