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
	
	

}
