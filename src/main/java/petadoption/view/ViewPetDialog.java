package petadoption.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ViewPetDialog extends JDialog {
	
	private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel typeLabel;
    private JLabel speciesLabel;
    private JLabel adoptedLabel;
    private JButton closeButton;

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewPetDialog dialog = new ViewPetDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewPetDialog() 
	{

		setTitle("Pet Details");
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(10,10,10,10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridBagLayout());
		
	}
	
	private void initializeComponents()
	{
		name = new JLabel();
		age = new JLabel();
		species = new JLabel();
		breed = new JLabel();
		descriptionArea = new JTextArea(5,30);
		descriptionArea.setEditable(false);
		descriptionArea.setLineWrap(true);
		adoptedLabel = new JLabel();
		adoptedLabel.setForeground(Color.red);
		closeButton = new JButton("Close");
	}
	
	
	private void layoutComponents()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		// Row 0
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Name:"), gbc);
		
		gbc.gridx = 1;
		panel.add(name, gbc);
		
		// Row 1
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(new JLabel("Age:"), gbc);
		
		gbc.gridx = 1;
		panel.add(age, gbc);
		
		// Row 2
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(new JLabel("Species:"), gbc);
		
		gbc.gridx = 1;
		panel.add(species, gbc);
		
		// Row 3
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(new JLabel("Breed:"), gbc);
		
		gbc.gridx = 1;
		panel.add(breed, gbc);
		
		// Row 4
		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(new JLabel("Description:"), gbc);
				
		gbc.gridx = 1;
		panel.add(new JScrollPane(descriptionArea), gbc);
		
		// Row 5
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(adoptedLabel, gbc);
		
		// Row 6
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(closeButton);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(buttonPanel, gbc);
		
		add(panel);
		
		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.add(closeButton);
		
	}
	
	public void setCloseButtonListener(ActionListener listener) 
	{
	    closeButton.addActionListener(listener);
	}
	
	public void displayPetDetails(String petName, int petAge, String petSpecies, String petBreed, String petDescription, boolean isAdopted)
	{
		name.setText(petName);
		age.setText(String.valueOf(petAge));
		species.setText(petSpecies);
		breed.setText(petBreed);
		descriptionArea.setText(petDescription);
		if(isAdopted)
		{
			adoptedLabel.setText("Adopted");
		}
		else
		{
			adoptedLabel.setText("Available");
		}
		setVisible(true);
		
	}

}
