// https://howtodoinjava.com/gson/gson-serialize-deserialize-hashmap/  good for understanding wtf gson is doing
//https://howtodoinjava.com/gson/gson/#5-custom-serialization-and-deserialization is what I tried to replicate


package petadoption.data;

import petadoption.model.Pet;
import petadoption.model.Shelter;
import petadoption.model.ExoticAnimal;
import petadoption.model.ExoticAnimalAdapter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class PetDataManager {
	
		private PetJsonSerializer pjs = new PetJsonSerializer();
		
		
		public Shelter<Pet> loadPetData() throws IOException
		{
			Shelter<Pet> shelter = new Shelter<Pet>();
			
			List<Pet> pets = loadNormal();
			for(Pet pet : pets)
			{
				shelter.addPet(pet);
			}
			
			List<ExoticAnimal> exoticAnimals = loadExotic();
			for(ExoticAnimal exoticAnimal : exoticAnimals)
			{
				shelter.addPet(new ExoticAnimalAdapter(exoticAnimal));
			}
			
			return shelter;
			
		}
	
		
		private List<Pet> loadNormal() throws IOException
		{
			String path = getClass().getResource("/pets.json").getFile();
			try(BufferedReader br = new BufferedReader(new FileReader(path)))
			{
				return pjs.jsonToPets(br);
				
			}
		}
		
		private List<ExoticAnimal> loadExotic() throws IOException
		{
			String path = getClass().getResource("/exotic_animals.json").getFile();
			try(BufferedReader br = new BufferedReader(new FileReader(path)))
			{
				return pjs.jsonToExotic(br);
			}
			
		}
		
		public String savePets(Shelter<Pet> shelter) throws IOException {
	     
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String name = timestamp + "_pets.json";
	        
	        // Write to file
	        try (FileWriter writer = new FileWriter(name)) {
	            pjs.petsToJson(shelter.getAllPets(), writer);
	        }
	        
	        return name;
	    }
		
	
}
