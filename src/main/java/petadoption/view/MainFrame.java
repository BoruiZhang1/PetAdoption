package petadoption.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MainFrame extends JFrame {
	
	// declare UI button 
	private static final long serialVersionUID = 1L;
	private JTable petsTable;
    private JButton addButton;
    private JButton adoptButton;
    private JButton removeButton;
    private JButton viewButton;
    private JButton saveButton;
    public JComboBox<String> sortComboBox;
	
	/**
	 * come with window builder
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() 
	{
		
		setTitle("Pet Adoption Center");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLayout(new BorderLayout());
		
        // Top panel for sorting
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Sort by:"));
        sortComboBox = new JComboBox<>(new String[]{"Name", "Age", "Species"});
        topPanel.add(sortComboBox);
        add(topPanel, BorderLayout.NORTH);
        
        // Center panel for pet table
        petsTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(petsTable);
        add(tableScrollPane, BorderLayout.CENTER);
		
		// adding buttons and change the text of the field
		JPanel buttonPanel = new JPanel();
		addButton = new JButton("Add Pet");
		adoptButton = new JButton("Adopt Pet");
		removeButton = new JButton("Remove Pet");
		viewButton = new JButton("View Pets");
		saveButton = new JButton("Save Pet");
		
		// adding button to the table
		buttonPanel.add(addButton);
		buttonPanel.add(adoptButton);
		buttonPanel.add(removeButton);
		buttonPanel.add(viewButton);
		buttonPanel.add(saveButton);
		
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		setLocationRelativeTo(null);
		}
	
		public void setTableModel(DefaultTableModel model)
		{
			petsTable.setModel(model);
		}

		public DefaultTableModel getTableModel() 
		{
		return (DefaultTableModel) petsTable.getModel();
		}

		public int getSelectedPetRow()
		{
	    return petsTable.getSelectedRow();
		}
		
		public String getSortOption() 
		{
	        return (String) sortComboBox.getSelectedItem();
	    }
		
		// action listsener for all the buttons
		public void addActionListeneraddButton(ActionListener listener)
		{
			addButton.addActionListener(listener);
		}
		public void addActionListeneradoptButton(ActionListener listener)
		{
			adoptButton.addActionListener(listener);
		}
		public void addActionListenerremoveButton(ActionListener listener)
		{
			removeButton.addActionListener(listener);
		}
		public void addActionListenerviewButton(ActionListener listener)
		{
			viewButton.addActionListener(listener);
		}
		public void addActionListenersaveButton(ActionListener listener)
		{
			saveButton.addActionListener(listener);
		}
		public void addSortComboBoxListener(ActionListener listener) {
		    sortComboBox.addActionListener(listener);
		}
	
}
