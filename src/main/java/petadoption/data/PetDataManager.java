// https://howtodoinjava.com/gson/gson-serialize-deserialize-hashmap/  good for understanding wtf gson is doing
//https://howtodoinjava.com/gson/gson/#5-custom-serialization-and-deserialization is what I tried to replicate


package petadoption.data;

import petadoption.model.Pet;
import petadoption.model.Shelter;
import petadoption.model.ExoticAnimal;
import petadoption.model.ExoticAnimalAdapter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class PetDataManager {
	
		
		private PetJsonSerializer pjs = new PetJsonSerializer();
		
		
		/** Note that when loading exotic animal we are using the adapter wrapper so that we can add it as a pet into shelter instead of as an exotic animal 
		 * @return shelter that has the pets which are loaded from the pet json and exotic animals json file
		 * @throws IOException
		 */
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
	
		
		/**loads normal pets from pet json
		 * @return the list of pet objects that is deserialized using jsonToPets 
		 * @throws IOException
		 */
		private List<Pet> loadNormal() throws IOException
		{
			String path = getClass().getResource("/pets.json").getFile();
			try(BufferedReader br = new BufferedReader(new FileReader(path)))
			{
				return pjs.jsonToPets(br);
				
			}
		}
		
		/**loads exotic pets from exotic animal json
		 * @return list of exotic animal objs deserialzied by jsonToExotic after reading exotic animals json file
		 * @throws IOException
		 */
		private List<ExoticAnimal> loadExotic() throws IOException
		{
			String path = getClass().getResource("/exotic_animals.json").getFile();
			try(BufferedReader br = new BufferedReader(new FileReader(path)))
			{
				return pjs.jsonToExotic(br);
			}
			
		}
		
		/**Saves the newest edited list of pets with a time stamp 
		 * @param shelter contains all the pets
		 * @return name of the file saved
		 * @throws IOException
		 */
		public String savePets(Shelter<Pet> shelter) throws IOException {
	     
			String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		    String name = timestamp + "_pets.json";
	        
	        // Write to file
	        try (FileWriter writer = new FileWriter(name)) {
	            pjs.petsToJson(shelter.getAllPets(), writer);
	        }
	        
	        return name;
	    }
		
	
}
