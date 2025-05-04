package petadoption.controller;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import petadoption.data.PetDataManager;
import petadoption.model.Animal;
import petadoption.model.Cat;
import petadoption.model.Dog;
import petadoption.model.Pet;
import petadoption.model.Rabbit;
import petadoption.model.Shelter;
import petadoption.view.AddPetDialog;
import petadoption.view.MainFrame;
import petadoption.view.ViewPetDialog;
import petadoption.comparators.*;

/**
 * Controller class for pet adoption application, handles interactions between model and view
 */
public class PetController 
{
    
    private Shelter<Pet> shelter;
    private MainFrame landing;
    private AddPetDialog add;
    private ViewPetDialog view;
    private PetDataManager manager;
    
    /**
     * constructor for the controller, initialize the ui and data
     */
    public PetController() throws IOException 
    {
    	
        manager = new PetDataManager();
        landing = new MainFrame();
        add = new AddPetDialog();
        view = new ViewPetDialog();
    
        shelter = manager.loadPetData();
        setupTableModel();
        setupEventHandlers();
        landing.setVisible(true);
        
    }
    
    /**
     * initialization for the table model
     */
    private void setupTableModel() 
    {
        DefaultTableModel table = new DefaultTableModel() 
        {
            private static final long serialVersionUID = 1L;
        };
        
        table.addColumn("ID");
        table.addColumn("Name");
        table.addColumn("Type");
        table.addColumn("Species");
        table.addColumn("Age");
        table.addColumn("Status");
        
        updateTableModel(table);
        landing.setTableModel(table);
    }
    
    /**
     * Updates the model with pet data from shelter
     * 
     * @param model the table model to update
     */
    private void updateTableModel(DefaultTableModel model) 
    {
        model.setRowCount(0); 
        
        List<Pet> pets = shelter.getAllPets();
        for (Pet pet : pets) 
        {
        	String status = "Available";
        	if(pet.isAdopted())
        	{
        		status = "Adopted";
        	}
            	model.addRow(new Object[] {pet.getId(),pet.getName(),pet.getType(),pet.getSpecies(),pet.getAge(),status});
        }
    }
    
    /**
     * handlers for ui components 
     */
    private void setupEventHandlers() 
    {
        landing.addActionListeneraddButton(e -> {add.clearFields(); add.setVisible(true);});
        
        add.addOkButtonListener(e -> 
        {
            if (validatePetInput()) 
            {
                addNewPet();
                add.dispose();
            }
        });
        
        landing.addActionListeneradoptButton(e -> adoptSelectedPet());
        landing.addActionListenerremoveButton(e -> removeSelectedPet());
        landing.addActionListenerviewButton(e -> viewSelectedPet());
        landing.addActionListenersaveButton(e -> {
			try {
				savePets();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        landing.addSortComboBoxListener(e -> sortPets());
    }
    
    /**
     * Validates user input
     */
    private boolean validatePetInput() {
        String name = add.getPetName();
        String species = add.getPetSpecies();
        int age = add.getPetAge();
        
        if (name.isEmpty()) 
        {
            JOptionPane.showMessageDialog(add, "you must enter a name for the pet.");
            return false;
        }
        
        if (species.isEmpty()) {
            JOptionPane.showMessageDialog(add, "species info cannot be left blank");
            return false;
        }
        
        if (age <= 0) {
            JOptionPane.showMessageDialog(add, "age must be valid.");
            return false;
        }
        
        return true;
    }
    
    /**
     * Adds a new pet to the shelter, I am not gonna have a switch case for cat dog and rabbit since we already have animal class just use that as category for new pets anyways
     */
    private void addNewPet() 
    {
        String name = add.getPetName();
        String type = add.getPetType();
        String species = add.getPetSpecies();
        int age = add.getPetAge();
        
        int newId = 1;
        for (Pet pet : shelter.getAllPets()) 
        {
            if (pet.getId() >= newId) {
                newId = pet.getId() + 1;
            }
        }
      
        Pet newPet = new Animal(newId, name, type, species, age);
        
        shelter.addPet(newPet);
        updateTableModel(landing.getTableModel());
    }
    
    /**
     * Adopts the currently selected pet
     */
    private void adoptSelectedPet() 
    {
        int selectedRow = landing.getSelectedPetRow();
        if (selectedRow != -1) 
        {
            int petId = (int) landing.getTableModel().getValueAt(selectedRow, 0);
            Pet selectedPet = findPetById(petId);
            
            if (selectedPet != null) 
            {
                if (selectedPet.isAdopted()) 
                {
                    JOptionPane.showMessageDialog(landing, "This pet has already been adopted.");
                } else 
                {
                    shelter.adoptPet(selectedPet);
                    updateTableModel(landing.getTableModel());
                }
            }
        }
    }
    
    /**
     * Removes the currently selected pet
     */
    private void removeSelectedPet() {
        int selectedRow = landing.getSelectedPetRow();
        if (selectedRow != -1) {
            int petId = (int) landing.getTableModel().getValueAt(selectedRow, 0);
            Pet selectedPet = findPetById(petId);
            
            if (selectedPet != null) {
                shelter.removePet(selectedPet);
                updateTableModel(landing.getTableModel());
            }
        }
    }
    
    /**
     * Views details of a selected pet
     */
    private void viewSelectedPet() {
        int selectedRow = landing.getSelectedPetRow();
        if (selectedRow != -1) 
        {
            int petId = (int) landing.getTableModel().getValueAt(selectedRow, 0);
            Pet selectedPet = findPetById(petId);
            
            if (selectedPet != null) 
            {
                view.setPet(selectedPet);
                view.setVisible(true);
            }
        }
    }
    
    /**
     * Saves current pet data to a JSON file
     */
    private void savePets() throws IOException {
        try 
        {
            String fileName = manager.savePets(shelter);
            JOptionPane.showMessageDialog(landing, "Pets saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Sorts pets according to the selected sort criteria
     */
    private void sortPets() {
        String sortOption = landing.getSortOption();
        
        switch (sortOption) {
            case "Name":
                shelter.sortBy(new NameComparator());
                break;
            case "Age":
                shelter.sortBy(new AgeComparator());
                break;
            case "Species":
                shelter.sortBy(new SpeciesComparator());
                break;
        }
        
        updateTableModel(landing.getTableModel());
    }
    
    /**
     * Finds a pet by ID
     * 
     * @param id of the pet
     * @return the pet associated with that id or null if not found
     */
    private Pet findPetById(int id) {
        for (Pet pet : shelter.getAllPets()) 
        {
            if (pet.getId() == id) 
            {
                return pet;
            }
        }
        return null;
    }
}