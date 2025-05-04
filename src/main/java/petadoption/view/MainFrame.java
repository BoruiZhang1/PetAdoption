package petadoption.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;


public class MainFrame extends JFrame {
	
	// declare UI button 
	private static final long serialVersionUID = 1L;
	private JTable petsTable;
	private JButton addButton;
	private JButton adoptButton;
	private JButton removeButton;
	private JButton viewButton;
	private JButton saveButton;
	// declare combobox for sorting pets
	private JComboBox<String> sortComboBox = new JComboBox<>(new String[]{"Name", "Age", "Species"});;

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
		setSize(600,400);
		setLayout(new BorderLayout());
		
		petsTable = new JTable();
		JScrollPane tableScrollPane = new JScrollPane(petsTable);
		add(tableScrollPane, BorderLayout.CENTER);
		
		
		// adding buttons and change the text 
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
