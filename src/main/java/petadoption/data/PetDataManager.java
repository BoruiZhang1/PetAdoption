package petadoption.data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import petadoption.model.Pet;
import petadoption.model.Shelter;

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
			return null;
			
		}
	
		public Shelter<Pet> savePetData() throws IOException
		{
			
		}
}
