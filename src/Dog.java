
/**
 * Dog-klassen inneh�ller alla egenskaper hos hundarna / objekten som ska anv�ndas
 * i Hunddagis-klassen. HundID, namn, �lder, hundras, f�rg, k�n, kontaktperson, telefonnummer,
 * antal timmar och �vrig information �r tillg�nglig samt en konstruktor som m�jligg�r
 * registreringen av en ny hund med alla ovann�mnda egenskaper. 
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

	//konstruktor f�r hundar med all n�dv�ndig information / alla egenskaper
	// g�r om argumenten i konstruktorn till egenskaper hos hunden - klassens objekt
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
	 * readDog-metoden l�ter Hunddagis-klassen f� tillg�ng till en hund och dess egenskaper
	 * i en organiserad str�ng, som sedan kan lagras och skrivas ut i programmet som helhet.
	 * @return Str�ng med hunden och dess information / egenskaper.
	 */
	public String readDog() {

		// Initialisera hund-str�ngen
		String dog = "";

		// L�t hundstr�ngen inneh�lla all information om hunden i �nskat format.
		dog += "Hund-ID: " + id + "\nHundnamn: " + name + "\n�lder: " + age + "\nHundras: " + breed + "\nF�rg: " + color
				+ "\nK�n: " + gender + "\nKontaktperson: " + contactPerson + "\ntelnr: " + phoneNumber
				+ "\nTotalt antal timmar p� hunddagis: " + hours + "\n�vrig info: " + other + "\n";

		// �terv�nder den kompletta, strukturerade hundstr�ngen
		return dog;
	}

}
