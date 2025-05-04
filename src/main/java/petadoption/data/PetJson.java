package petadoption.data;


/**
 * the data transfer obj, I can't fully rely on gson and customization needed here since we have hard coded dog cat rabbit class extended the pet abstract class 
 */
	public class PetJson {
	    int id;
	    String name;
	    String type;
	    String species;
	    int age;
	    boolean adopted;
	}

