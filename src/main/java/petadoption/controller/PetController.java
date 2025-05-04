package petadoption.controller;

import java.awt.event.ActionListener;

import petadoption.data.PetDataManager;
import petadoption.model.Pet;
import petadoption.model.Shelter;
import petadoption.view.AddPetDialog;
import petadoption.view.MainFrame;
import petadoption.view.ViewPetDialog;

public class PetController implements ActionListener{
	
	
	private MainFrame landing;
	private AddPetDialog dialog;
	private ViewPetDialog view;
	private Shelter<Pet> shelter;
	private PetDataManager manager;
	
	public PetController() 
	{
			
	}
	
	private void setEventListeners()
	{
		landing.getAddButton()
	}
}
