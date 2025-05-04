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
		
		// Create components
		JLabel nameTitle = new JLabel("Name;");
		nameLabel = new JLabel();
		
		JLabel ageTitle = new JLabel("Age:");
		ageLabel = new JLabel();
		
		JLabel typeTitle = new JLabel("Type:");
		typeLabel = new JLabel();
		
		JLabel speciesTitle = new JLabel("Species/Breed:");
		speciesLabel = new JLabel();
		
		
	}
	
	
	
}
