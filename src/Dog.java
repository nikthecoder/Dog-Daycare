
/**
 * Dog-klassen innehåller alla egenskaper hos hundarna / objekten som ska användas
 * i Hunddagis-klassen. HundID, namn, ålder, hundras, färg, kön, kontaktperson, telefonnummer,
 * antal timmar och övrig information är tillgänglig samt en konstruktor som möjliggör
 * registreringen av en ny hund med alla ovannämnda egenskaper. 
 */
public class Dog {

	// Alla egenskaper deklareras
	public String id;
	public String name;
	private int age;
	public String breed;
	private String color;
	private String gender;
	public String contactPerson;
	private String phoneNumber;
	public int hours;
	private String other;

	//konstruktor för hundar med all nödvändig information / alla egenskaper
	// gör om argumenten i konstruktorn till egenskaper hos hunden - klassens objekt
	public Dog(String id, String name, int age, String breed, String color, String gender, String contactPerson,
			String phoneNumber, int hours, String other) {

		this.id = id;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.color = color;
		this.gender = gender;
		this.contactPerson = contactPerson;
		this.phoneNumber = phoneNumber;
		this.hours = hours;
		this.other = other;
	}

	/**
	 * readDog-metoden låter Hunddagis-klassen få tillgång till en hund och dess egenskaper
	 * i en organiserad sträng, som sedan kan lagras och skrivas ut i programmet som helhet.
	 * @return Sträng med hunden och dess information / egenskaper.
	 */
	public String readDog() {

		// Initialisera hund-strängen
		String dog = "";

		// Låt hundsträngen innehålla all information om hunden i önskat format.
		dog += "Hund-ID: " + id + "\nHundnamn: " + name + "\nÅlder: " + age + "\nHundras: " + breed + "\nFärg: " + color
				+ "\nKön: " + gender + "\nKontaktperson: " + contactPerson + "\ntelnr: " + phoneNumber
				+ "\nTotalt antal timmar på hunddagis: " + hours + "\nÖvrig info: " + other + "\n";

		// Återvänder den kompletta, strukturerade hundsträngen
		return dog;
	}

}
