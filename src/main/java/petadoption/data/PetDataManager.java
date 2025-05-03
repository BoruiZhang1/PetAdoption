package petadoption.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import petadoption.model.Pet;
import petadoption.model.Shelter;
import petadoption.model.ExoticAnimal;

import java.io.*;
import java.util.*;

import org.ietf.jgss.GSSException;

public class PetDataManager {
	
		private Gson gson;
		
		public PetDataManager()
		{
			this.gson = new Gson();
		}
	
		public Shelter<Pet> loadPetData() throws IOException
		{
			Shelter<Pet> shelter = new Shelter<Pet>();
			
			
		}
	
		public Shelter<Pet> savePetData() throws IOException
		{
			
		}
		
		private List<Pet> loadNormal() throws IOException
		{
			List<Pet> pets = new ArrayList<Pet>();
			String path = getClass().getResource("/pets.json").getFile();
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(path));
				List<>
			}
		}
		
		private List<ExoticAnimal> loadExotic() throws IOException
		{
			return null;
			
		}
}
