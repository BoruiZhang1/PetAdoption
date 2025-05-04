package petadoption.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
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
		
		
		
	}

}
