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
		
		JLabel adeoptedTitle = new JLabel("Status:");
		adoptedLabel = new JLabel();
		
		// add components to panel
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		
		// Row 1
		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPanel.add(nameTitle, gbc);
		
		gbc.gridx = 1;
		contentPanel.add(nameLabel, gbc);
		
		// Row 2
		gbc.gridx = 0;
		gbc.gridy = 1;
		contentPanel.add(ageTitle, gbc);
		
		gbc.gridx = 1;
		contentPanel.add(ageLabel, gbc);
		
		// Row 3
		gbc.gridx = 0;
		gbc.gridy = 2;
		contentPanel.add(typeTitle, gbc);
		
		gbc.gridx = 1;
		contentPanel.add(typeLabel, gbc);
		
		// Row 4
		gbc.gridx = 0;
        gbc.gridy = 3;
        contentPanel.add(speciesTitle, gbc);
        
        gbc.gridx = 1;
        contentPanel.add(speciesLabel, gbc);
        
     // Row 5
        gbc.gridx = 0;
        gbc.gridy = 4;
        contentPanel.add(adoptedLabel, gbc);
        
        gbc.gridx = 1;
        contentPanel.add(adoptedLabel, gbc);
        
        // Button Panel
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        closeButton = new JButton("Close");
        buttonPane.add(closeButton);
        getRootPane().setDefaultButton(closeButton);
        
        // add action to the close button
        closeButton.addActionListener(e -> dispose());
        
        setModal(true);
        setLocationRelativeTo(null);
        
		
	}
	
	
	
}
