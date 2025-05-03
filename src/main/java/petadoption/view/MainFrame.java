package petadoption.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainFrame extends JFrame {
	
	private JTable petsTable;
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		setTitle("Pet Adoption Website");
		setBounds(300,100,500,400);

		
		
		JButton addButton = new JButton("Add Pet");
        addButton.setBounds(10, 320, 77, 27); 
        getContentPane().add(addButton);
        
        JButton adoptButton = new JButton("Adopt Pet");
        adoptButton.setBounds(184, 320, 86, 27); 
        contentPane.add(adoptButton);
        
        JButton removeButton = new JButton("Remove Pet");
        removeButton.setBounds(376, 320, 98, 27); 
        contentPane.add(removeButton);
        
        JButton viewButton = new JButton("View Pet");
        viewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        viewButton.setBounds(97, 320, 77, 27); 
        contentPane.add(viewButton);
        
        JButton takeButton = new JButton("Save Pet");
        takeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        takeButton.setBounds(280, 320, 86, 27); 
        contentPane.add(takeButton);
	}
}
