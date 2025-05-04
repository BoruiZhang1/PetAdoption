package petadoption.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ViewPetDialog extends JDialog {
	
	private JLabel name;
    private JLabel age;
    private JLabel species;
    private JLabel breed;
    private JTextArea descriptionArea;
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
		name = new JLabel();
		age = new JLabel();
		species = new JLabel();
		breed = new JLabel();
		descriptionArea = new JTextArea(5,30);
		descriptionArea.setEditable(false);
		descriptionArea.setLineWrap(true);
		descriptionArea.setWrapStyleWord(true);
		adoptedLabel = new JLabel();
		adoptedLabel.setForeground(Color.red);
		closeButton = new JButton("Close");
		
	}
	
	private void layoutComponents()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints table = new GridBagConstraints();
		table.insets = new Insets(5, 5, 5, 5);
		table.anchor = GridBagConstraints.WEST;
		table.fill = GridBagConstraints.HORIZONTAL;
		
		// Row 0
		table.gridx = 0;
		table.gridy = 0;
		panel.add(new JLabel("Name: "), table);
		
		table.gridx = 1;
		panel.add(name, table);
		
		// Row 1
		table.gridx = 0;
		table.gridy = 1;
		panel.add(new JLabel("Age:"), table);
		
		table.gridx = 1;
		panel.add(age, table);
		
		// Row 2
		table.gridx = 0;
		table.gridy = 2;
		panel.add(new JLabel("Species:"), table);
		
		table.gridx = 1;
		panel.add(species, table);
		
		// Row 3
		table.gridx = 0;
		table.gridy = 3;
		panel.add(new JLabel("Breed:"), table);
		
		table.gridx = 1;
		panel.add(breed, table);
		
		// Row 4
		table.gridx = 0;
		table.gridy = 4;
		panel.add(new JLabel("Description:"), table);
				
		table.gridx = 1;
		panel.add(new JScrollPane(descriptionArea), table);
	}

}
