package petadoption.data;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import petadoption.model.Animal;
import petadoption.model.Cat;
import petadoption.model.Dog;
import petadoption.model.ExoticAnimal;
import petadoption.model.Pet;
import petadoption.model.Rabbit;

public class PetJsonSerializer {

	private Gson gson = new Gson();
	
	/** JSON -> Pet
	 * @param reader has the data in JSON format
	 * @return in the format as the list of pet objs
	 */
	public List<Pet> jsonToPets(Reader reader)
	{
		Type listType = new TypeToken<ArrayList<PetJson>>(){}.getType();
		List<PetJson> petJsonList = gson.fromJson(reader, listType);
		
		List<Pet> pets = new ArrayList<>();
		for (PetJson json : petJsonList) 
		{
			Pet pet = null; 
			 switch(json.type) {
             case "Dog":
                 pet = new Dog(json.id, json.name, json.species, json.age);
                 break;
             case "Cat":
                 pet = new Cat(json.id, json.name, json.species, json.age);
                 break;
             case "Rabbit":
                 pet = new Rabbit(json.id, json.name, json.species, json.age);
                 break;
             default:
                 // For any other animal type, use the general Animal class
                 pet = new Animal(json.id, json.name, json.type, json.species, json.age);
                 break;
         }
			
			if(pet != null)
			{
				if(json.adopted)
				{
					pet.setAdopted(true);
				}
				pets.add(pet);
			}	
		}
		return pets;
	}
	
	
	/** JSON -> ExoticAnimal
	 * @param reader has the data in JSON format
	 * @return in the format as the list of ExoticAnimal objs
	 */
	public List<ExoticAnimal> jsonToExotic(Reader reader)
	{
		 Type listType = new TypeToken<ArrayList<ExoticAnimal>>(){}.getType();
		 return gson.fromJson(reader, listType);
	}
	
	
	/**
	 * @param pets pet objs that will be converted to json
	 * @param writer writes to json format
	 */
	public void petsToJson(List<Pet> pets, Writer writer) {
        List<PetJson> petJsonList = new ArrayList<>();
        
        for (Pet pet : pets) {
           
                PetJson json = new PetJson();
                json.id = pet.getId();
                json.name = pet.getName();
                json.type = pet.getType();
                json.species = pet.getSpecies();
                json.age = pet.getAge();
                json.adopted = pet.isAdopted();
                petJsonList.add(json);
           
        }
        
        gson.toJson(petJsonList, writer);
    }
	
	
	
	
}
