package petadoption.data;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import petadoption.data.PetDTO.PetJson;
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
			if ("Dog".equals(json.type))
			{
				pet = new Dog(json.id, json.name, json.species, json.age);
			}
			else if ("Cat".equals(json.type))
			{
				pet = new Cat(json.id, json.name, json.species, json.age);
			}
			else if ("Rabbit".equals(json.type))
			{
				pet = new Rabbit(json.id, json.name, json.species, json.age);
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
	
	
	
	
	
	
	
}
