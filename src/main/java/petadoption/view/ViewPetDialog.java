package petadoption.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ViewPetDialog extends JDialog {
	
	private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel speciesLabel;
    private JLabel breedLabel;
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
		nameLabel = new JLabel();
		ageLabel = new JLabel();
		speciesLabel = new JLabel();
		breedLabel = new JLabel();
		descriptionArea = new JTextArea(5,30);
		
	}

}
