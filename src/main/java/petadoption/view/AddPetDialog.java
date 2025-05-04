package petadoption.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddPetDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private JTextField nameField;
	private JComboBox<String> typeComboBox;
	private JTextField speciesField;
	private JTextField ageField;
	private JButton okButton;
	private JButton cancelButton;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddPetDialog dialog = new AddPetDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddPetDialog() 
	{
		setTitle("Add New Pet");
        setBounds(100, 100, 400, 250);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new GridBagLayout());
		
		// create Labels 
		JLabel nameLabel = new JLabel("Name:");
		nameField = new JTextField(20);
		
		JLabel typeLabel = new JLabel("Type:");
		String[] petTypes = {"Dog", "Cat", "Rabbit", "Other"};
		typeComboBox = new JComboBox<>(petTypes);
		
		JLabel speciesLabel = new JLabel("Species/Breed:");
		speciesField = new JTextField(20);
		
		JLabel ageLabel = new JLabel("Age:");
		ageField = new JTextField(5);
		
		// add components to panel making rows for name type,ect.
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		
		// Row 1 for the animal label
		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPanel.add(nameLabel, gbc);
		
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPanel.add(nameField, gbc);
		
		// Row 2 for animal type 
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		contentPanel.add(typeLabel, gbc);
		
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPanel.add(typeComboBox, gbc);
		
		// Row 3 for species of animal 
		 gbc.gridx = 0;
	     gbc.gridy = 2;
	     gbc.fill = GridBagConstraints.NONE;
	     contentPanel.add(speciesLabel, gbc);
	        
	     gbc.gridx = 1;
	     gbc.fill = GridBagConstraints.HORIZONTAL;
	     contentPanel.add(speciesField, gbc);
		
	     // Row 4 for making the age of the animal
	     gbc.gridx = 0;
	     gbc.gridy = 3;
	     gbc.fill = GridBagConstraints.NONE;
	     contentPanel.add(ageLabel, gbc);
	        
	     gbc.gridx = 1;
	     gbc.fill = GridBagConstraints.HORIZONTAL;
	     contentPanel.add(ageField, gbc);
		
	     // Button for adding and cancel
	     JPanel buttonPane = new JPanel();
	     buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
	     getContentPane().add(buttonPane, BorderLayout.SOUTH);
	     
	     okButton = new JButton("OK");
	     okButton.setActionCommand("OK");
	     buttonPane.add(okButton);
	     getRootPane().setDefaultButton(okButton);
	     
	     cancelButton = new JButton("Cancel");
	     cancelButton.setActionCommand("Cancel");
	     buttonPane.add(cancelButton);
	     
	     // adding action to the button to close the current window
	     cancelButton.addActionListener(e -> dispose());
	     
	     setModal(true);
	     setLocationRelativeTo(null);
	     
	     
	}
	
		/*
		 *  Gets the name of the pet by user enter in the text field
		 *  
		 *  return the pet name
		 */
		public String getPetName()
		{
			return nameField.getText()
;		}
		
		/*
		 * Get the type of pet when user select it and return the pet type
		 */
		public String getPetType()
		{
			return (String) typeComboBox.getSelectedItem();
		}
		
		/*
		 * get the pet species when is enter by user
		 */
		public String getPetSpecies()
		{
			return speciesField.getText();
		}
		
		/*
		 *  Gets the pet age which is enter by user
		 */
		public int getPetAge()
		{
			try
			{
				return Integer.parseInt(ageField.getText());
			}
			catch(NumberFormatException e)
			{
				return 0;
			}
		}
		
		/*
		 * Clears everything 
		 */
		
		public void clearFields()
		{
			nameField.setText("");
			typeComboBox.setSelectedIndex(0);
			speciesField.setText("");
			ageField.setText("");
		}

}
