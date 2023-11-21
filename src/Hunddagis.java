import java.util.Random;
import java.util.Scanner;

/**
 * Hunddagis-klassen skapar en objektarray av hundar, lägger till 3 hundar i arrayen och
 * använder sedan en metod för att visa en meny som fortsätter programmet och gör det
 * möjligt för användaren att interagera med Hunddagiset.
 */
public class Hunddagis {

	public static void main(String[] args) {

		// Basoperationen
		// Skapa 3 standard-objekt / hundar med dess information / egenskaper
		Dog h1 = new Dog("H1", "Nike", 8, "Labrador", "Svart", "Hane", "Sara Karlsson", "07012345678", 5, "-");
		Dog h2 = new Dog("H2", "Cookie", 3, "Coccker spaniel", "Vit och brun", "Tik", "Kalle Ek", "07012345679", 49,
				"-");
		Dog h3 = new Dog("H3", "Lara", 5, "Fransk Bulldog", "Svart", "Tik", "Pelle Andersson", "07012345671", 30, "-");

		// skapa en objektarray som ska hålla hundarna
		Dog[] dogs = new Dog[21];
		
		// lägg de 3 hundarna i objektarrayen 
		dogs[0] = h1;
		dogs[1] = h2;
		dogs[2] = h3;

		// kalla på metoden för menyn, som startar hela programmet och dess interaktion
		menu(dogs);

	}

	/**
	 * menu-metoden skapar en meny med flera alternativ.
	 * Alternativ A låter användaren lägga till en hund i arrayen.
	 * Alternativ B låter användaren uppdatera en hunds timmar i arrayen.
	 * Alternativ C låter användaren ta bort en hund från arrayen.
	 * Alternativ D visar alla hundar i arrayen / hunddagiset.
	 * Alternativ E låter användaren söka efter en hund i arrayen som stannat längre än 40 timmar.
	 * Alternativ F visar priset som ska betalas av en viss kontaktperson denna månaden.
	 * Alternativ G visar alla hundar som är en viss hundras.
	 * Alternativ H visar en specifik hund i arrayen.
	 * Alternativ I det totala antalet timmar bland alla hundar i hunddagiset, sammanlagt.
	 * Alternativ J slumpar fram en vinnare bland hundarna som får 10 gratis timmar.
	 * Alternativ K sorterar alla hundar i arrayen i bokstavsordning baserat på hundras.
	 * Alternativ Q får användaren att gå ur menyn och avsluta programmet.
	 * @param dogs Objektarrayen med hundar behövs för att kunna utföra metoderna i menyn (se ovan).
	 */
	public static void menu(Dog[] dogs) {

		// Scanner-objektet möjliggör hantering av indata
		Scanner input = new Scanner(System.in);

		// boolesk variabel för menyns while-loop
		boolean isRunning = true;

		//medan isRunning = true, visa menyn och dess alternativ
		while (isRunning) {
			System.out.println(
							  "[A] - Lägg till en hund\n"
							+ "[B] - Uppdatera timmar för en viss hund\n"
							+ "[C] - Ta bort hund\n"
							+ "[D] - Visa alla hundar\n"
							+ "[E] - Sök efter hundar som stannat längre än 40 timmar\n"
							+ "[F] - Visa priset som ska betalas denna månaden\n"
							+ "[G] - Visa alla hundar som är av en viss hundras\n"
							+ "[H] - Visa en specifik hund\n"
							+ "[I] - Visa den totala mängden timmar bland hundarna\n"
							+ "[J] - Slumpa fram en hund som ska få vinna 10 gratis timmar\n"
							+ "[K] - Sortera alla hundar i bokstavsordning baserat på hundras\n"
							+ "[Q] - Avsluta\n");

			// lagra indatan i strängen answer
			String answer = input.nextLine();

			// switch sats för strängen answer / indatan / svaret
			switch (answer.toUpperCase()) {
			case "A": // Om "A" matas in, lägg till hund
				addDog(dogs);
				break;
			case "B": // Om "B" matas in, uppdatera timmarna för en hund
				updateHours(dogs);
				break;
			case "C": // Om "C" matas in, ta bort hund
				removeDog(dogs);
				break;
			case "D": // Om "D" matas in, visa alla hundar
				showAllDogs(dogs);
				break;
			case "E": // Om "E" matas in, sök efter hundar som stannat längre än 40 timmar
				searchDogsOver40Hours(dogs);
				break;
			case "F": // Om "F" matas in, visa priset som en kontaktperson ska betala
				showPrice(dogs);
				break;
			case "G": // Om "G" matas in, visa alla hundar som är en viss hundras
				showBreed(dogs);
				break;
			case "H": // Om "H" matas in, visa en specifik hund
				showDog(dogs);
				break;
			case "I": // Om "I" matas in, visa det totala antalet timmar för hundarna, sammanlagt
				showTotalHours(dogs);
				break;
			case "J": // Om "J" matas in, slumpa fram en hund som får vinna 10 gratis timmar
				randomWinner(dogs);
				break;
			case "K": // Om "K" matas in, sortera alla hundar i bokstavsordning baserat på hundras
				sortAlphabetically(dogs);
				break;
			case "Q": // Om "Q" matas in, gå ut ur menyn och avsluta programmet
				isRunning = false;
				break;
			default: // Om något annat än alternativen ovan matas in, skriv ut felmeddelande 
				System.out.println("Ogiltigt alternativ.\n");
				break;
			}
		}

	}

	/**
	 * addDog-metoden låter användaren lägga till en hund i objektarrayen genom att
	 * den läser in HundID, namn, ålder, hundras, färg, kön, kontaktperson, telefonnummer,
	 * antal timmar i hunddagiset och även övrig information.
	 * @param dogs Objektarrayen med hundar behövs för att kunna utföra metoden.
	 */
	public static void addDog(Dog[] dogs) {

		// Scanner-objektet möjliggör hantering av indata
		Scanner input = new Scanner(System.in);

		// variabler för egenskaperna skapas, även en boolean för om en hund redan finns
		String id = "";
		String name = "";
		int age = 0;
		String breed = "";
		String color = "";
		String gender = "";
		String contactPerson = "";
		String phoneNumber = "";
		int hours = 0;
		String other = "";
		boolean alreadyExists = false;

		// en räknare initieras och objektarrayen analyseras
		// om en index i arrayen är tom eller om en hund är "borttagen" så ökar räknarens värde
		int counter = 0;
		for (int i = 0; i < dogs.length; i++) {
			if (dogs[i] == null || dogs[i].id.equals("deleted")) {
				counter++;
			}
		}
		
		System.out.println("Du har valt att lägga till en hund\n");

		// om räknarens värde är 0 så betyder det att det inte finns plats för fler hundar
		if (counter == 0) {
			System.out.print("Vi har ingen plats för fler hundar, tyvärr.\n");
		}
		// annars så får användaren mata in ett hundID för den nya hunden
		else {
			//HundID't matas in och lagras
			System.out.print("HundID: ");
			id = input.nextLine().toUpperCase();

			// för varje hund i objektarrayen
			for (Dog d : dogs) {

				// om objektet är "tomt" eller har ID't "deleted" (borttagen)
				if (d == null || d.id.equals("deleted")) {

					// gör inget
				}
				// annars om det ID't som matats in redan finns bland hundarna
				else if (id.equals(d.id)) {

					// boolean alreadyExists (redan finns) blir sant och ett felmeddelande skrivs ut
					alreadyExists = true;
					System.out.println("En hund med hund-id " + d.id + " finns redan i vår samling\n");
					break;
				}
			}
			
			// om hunden inte redan finns, be användaren att mata in mer information om hunden
			if (!alreadyExists) {

				System.out.print("Hundnamn: ");
				name = input.nextLine();

				System.out.print("Ålder: ");
				age = Integer.parseInt(input.nextLine());

				System.out.print("Hundras: ");
				breed = input.nextLine();

				System.out.print("Färg: ");
				color = input.nextLine();

				System.out.print("Kön: ");
				gender = input.nextLine();

				System.out.print("Kontaktperson: ");
				contactPerson = input.nextLine();

				System.out.print("telnr: ");
				phoneNumber = input.nextLine();

				System.out.print("Totalt antal timmar på hunddagis: ");
				hours = Integer.parseInt(input.nextLine());

				System.out.print("Övrig info: ");
				other = input.nextLine();

				// skapa ett objekt av hunden med alla egenskaper som matats in
				Dog dog = new Dog(id, name, age, breed, color, gender, contactPerson, phoneNumber, hours, other);

				// för varje index i objektarrayen
				for (int i = 0; i < dogs.length; i++) {

					// om indexen är "tom" eller "borttagen" så kan den nya hunden läggas in där
					if (dogs[i] == null || dogs[i].id.equals("deleted")) {
						dogs[i] = dog;
						break;
					}
				}
				
				System.out.println("Hund tillagd.\n");
			}
		}
	}

	/**
	 * updateHours-metoden låter användaren uppdatera - minska eller öka - antalet timmar
	 * på en viss hund i objektarrayen.
	 * @param dogs Objektarrayen med hundar behövs för att kunna utföra metoden.
	 */
	public static void updateHours(Dog[] dogs) {

		// Scanner-objektet möjliggör hantering av indata
		// sträng för utmatning initieras
		// heltal för timmar initieras
		Scanner input = new Scanner(System.in);
		String output = "";
		int hours = 0;

		// användaren för skriva vilken hund vars timmar de vill uppdatera, baserat på ID't
		System.out.print("Du har valt att uppdatera en hunds timmar\nHundID: ");
		String id = input.nextLine();

		// för varje hund i objektarrayen
		for (Dog d : dogs) {

			// om objektet är "tomt" eller har ID't "deleted" (borttagen)
			if (d == null || d.id.equals("deleted")) {

				// gör inget
			}
			// annars om ID't som matats in finns
			else if (id.toUpperCase().equals(d.id)) {
				
				// användaren matar in det nya antalet timmar för hunden, som sparas i objektet
				// utmatningssträngen blir nu ett meddelande och loopen lämnas
				System.out.print("Mata in hur många timmar som ska registreras på hunden: ");
				hours = Integer.parseInt(input.nextLine());
				d.hours = hours;
				output = "Hundens timmar har uppdaterats.\n";
				break;
			}
		}

		// om inget gjorts i föregående if sats och output är tom
		if (output.equals("")) {
			System.out.println("Hunden finns inte i systemet.\n");
		}
		// annars
		else {
			// utmatning av meddelande
			System.out.println(output);
		}
	}

	/**
	 * removeDog-metoden låter användaren ta bort en viss hund i objektarrayen.
	 * @param dogs Objektarrayen med hundar behövs för att kunna utföra metoden.
	 */
	public static void removeDog(Dog[] dogs) {

		// Scanner-objektet möjliggör hantering av indata
		// sträng för utmatning initieras
		Scanner input = new Scanner(System.in);
		String output = "";

		// användaren matar in HundID't, som sparas
		System.out.print("Du har valt att ta bort en hund\n\nHundID: ");
		String id = input.nextLine();

		// för varje hund i objektarrayen
		for (Dog d : dogs) {

			// om objektet är "tomt"
			if (d == null) {

				// gör inget
			}
			// annars om hunden finns, ändra ID't till "deleted" (borttagen), hunden "tas bort"
			// meddelande skrivs ut och loopen lämnas
			else if (id.toUpperCase().equals(d.id)) {
				d.id = "deleted";
				output = "Hund borttagen från systemet.\n";
				break;
			}
		}

		// om inget gjorts i föregående if sats och output är tom
		if (output.equals("")) {
			// skriv ut felmeddelande
			System.out.println("Hunden finns inte i systemet.\n");
		}
		// annars, meddela om att borttagning slutförts
		else {
			System.out.println(output);
		}
	}

	/**
	 * showAllDogs-metoden visar alla hundar i objektarrayen.
	 * @param dogs Objektarrayen med hundar behövs för att kunna utföra metoden.
	 */
	public static void showAllDogs(Dog[] dogs) {

		//sträng för utmatning initieras
		String output = "";

		System.out.println("Du har valt att visa alla hundar\n");
		
		// för varje hund i objektarrayen
		for (Dog d : dogs) {

			// om hunden inte finns eller är "borttagen"
			if (d == null || d.id.equals("deleted")) {

				// gör inget
			}
			// annars
			else {

				// skriv ut / visa hunden och dess information
				output = d.readDog();
				System.out.println(output);
			}
		}
		
		// om inget gjorts i föregående if sats och output är tom
		if (output.equals("")) {
			System.out.println("Det finns inga hundar för tillfället.\n");
		}
	}

	/**
	 * searchDogsOver40Hours-metoden låter användaren söka efter hundar i objektarrayen
	 * vars timmar är högre än 40. De hundar som stannat längre än 40 timmar får ett nytt
	 * rabaterrat timpris.
	 * @param dogs Objektarrayen med hundar behövs för att kunna utföra metoden.
	 */
	public static void searchDogsOver40Hours(Dog[] dogs) {

		// sträng för alla hundar som stannat längre än 40 timmar initieras
		String dogsOver40 = "";

		System.out.println("Du har valt att söka efter alla hundar som stannat längre än 40 timmar");

		// för varje hund i objektarrayen
		for (Dog d : dogs) {

			// om hunden inte finns eller är "borttagen"
			if (d == null || d.id.equals("deleted")) {

				// gör inget
			}
			// annars om hunden stannat längre än 40 timmar
			else if (d.hours > 40) {

				// lägg till hunden till strängen dogsOver40
				dogsOver40 += d.name + "\n";
			}
		}

		// om inget gjorts i föregående if sats och dogsOver40 är tom
		if (dogsOver40.equals("")) {
			System.out.println("Det fanns inga hundar som stannat längre än 40 timmar.\n");
		}
		// annars, skriv ut hundarna som stannat längre än 40 timmar
		else {
			System.out.println("Dessa hundar har stannat längre än 40 timmar och får nu ett nytt timpris, med 10% rabatt:");
			System.out.println(dogsOver40);
		}
	}

	/**
	 * showPrice-metoden visar priset som ska betalas av en viss kontaktperson denna månaden.
	 * @param dogs Objektarrayen med hundar behövs för att kunna utföra metoden.
	 */
	public static void showPrice(Dog[] dogs) {

		// konstanterna för timpris och rabatt skapas
		final double HOURLY_FEE = 25;
		final double DISCOUNT = 0.9;

		// Scanner-objektet behövs för hantering av indata
		// strängar för kontaktperson och namn initieras, samt ett tal för det resulterande priset
		// boolean för om kontaktpersonen och dess hund inte finns med i objektarrayen
		Scanner input = new Scanner(System.in);
		String contactPerson = "";
		String name = "";
		double price = 0;
		boolean doesNotExist = true;

		// Kontaktpersonen matas in och sparas
		System.out.print("Du har valt att visa priset som ska betalas denna månaden\nKontaktperson: ");
		contactPerson = input.nextLine();

		// för varje hund i objektarrayen
		for (Dog d : dogs) {

			// om hunden inte finns eller är "borttagen"
			if (d == null || d.id.equals("deleted")) {
				
				// gör inget
			}
			// annars om kontaktpersonen finns och dess hund stannat längre än 40 timmar
			else if (contactPerson.toUpperCase().equals(d.contactPerson.toUpperCase()) && d.hours > 40) {
				
				// boolean doesNotExist (finns inte) blir falsk, det *rabatterade* priset beräknas
				// utmatningen av kontaktpersonen, dess avgift och dess hund sker
				doesNotExist = false;
				price = (double)d.hours * HOURLY_FEE * DISCOUNT;
				name = d.name;
				System.out.printf(contactPerson + " ska betala %.2f kr för " + name + ".\n", price);
				
			}
			// annars om kontaktpersonen finns och dess hund *INTE* stannat längre än 40 timmar
			else if (contactPerson.toUpperCase().equals(d.contactPerson.toUpperCase())) {
				
				// boolean doesNotExist (finns inte) blir falsk, priset beräknas
				// utmatningen av kontaktpersonen, dess avgift och dess hund sker
				doesNotExist = false;
				price = (double)d.hours * HOURLY_FEE;
				name = d.name;
				System.out.printf(contactPerson + " ska betala %.2f kr för " + name + ".\n", price);
			}
		}

		// om kontaktpersonen inte finns i objektarrayen
		if (doesNotExist) {
			System.out.println("Kontaktpersonen finns inte i vårt system.\n");
		}

	}

	/**
	 * showBreed-metoden visar alla hundar som är en viss hundras.
	 * @param dogs Objektarrayen med hundar behövs för att kunna utföra metoden.
	 */
	public static void showBreed(Dog[] dogs) {

		// Scanner-objekt behövs för hantering av indata, strängar för hundras och utmatning initieras
		Scanner input = new Scanner(System.in);
		String breed = "";
		String output = "";

		// hundrasen matas in
		System.out.print("Du har valt att visa alla hundar som är en viss hundras\nHundras: ");
		breed = input.nextLine();

		// för varje hund i objektarrayen
		for (Dog d : dogs) {

			// om hunden inte finns eller är "borttagen"
			if (d == null || d.id.equals("deleted")) {

				// gör inget
			}
			// annars om det finns en eller flera hundar med hundrasen
			else if (breed.toUpperCase().equals(d.breed.toUpperCase())) {

				// lägg till hunden i utmatningssträngen och skriv ut den
				output = d.readDog();
				System.out.println(output);

			}
		}

		// om inget gjordes i föregående if-sats och output är tom
		if (output.equals("")) {
			System.out.println("Det finns ingen hund hos oss med den hundrasen.\n");
		}
	}

	/**
	 * showDog-metoden visar en specifik hund.
	 * @param dogs Objektarrayen med hundar behövs för att kunna utföra metoden.
	 */
	public static void showDog(Dog[] dogs) {

		// Scanner-objektet behövs för hantering av indata, strängar för id och utmatning initieras
		Scanner input = new Scanner(System.in);
		String id = "";
		String output = "";

		// ID matas in
		System.out.print("Du har valt att visa en specifik hund\nHund-ID: ");
		id = input.nextLine();

		// för varje hund i objektarrayen
		for (Dog d : dogs) {

			// om hunden inte finns eller är "borttagen"
			if (d == null || d.id.equals("deleted")) {

				// gör inget
			}
			// annars om hunden med ID't finns
			else if (id.toUpperCase().equals(d.id)) {

				// lagra hunden och dess information i utmatningssträngen och skriv ut den
				output = d.readDog();
				System.out.println("\n" + output);

			}
		}

		// om inget gjorts i föregående if-sats och output är tom
		if (output.equals("")) {
			System.out.println("Det finns ingen hund hos oss med det Hund-ID't.\n");
		}
	}

	/**
	 * showTotalHours-metoden visar det totala antalet timmar bland hundarna, sammanlagt.
	 * @param dogs Objektarrayen med hundar behövs för att kunna utföra metoden.
	 */
	public static void showTotalHours(Dog[] dogs) {

		// heltal för det totala antalet timmar initieras
		int totHours = 0;

		System.out.println("Du har valt att visa det totala antalet timmar bland hundarna.\n");
		
		// för varje hund i objektarrayen
		for (Dog d : dogs) {
			
			// om hunden inte finns eller är "borttagen"
			if (d == null || d.id.equals("deleted")) {

			}
			// annars
			else {
				// lägg till hundens timmar till variablen med det totala antalet timmar
				totHours += d.hours;
			}
		}

		// utmatning för det totala antalet timmar
		System.out.println("Det totala antalet timmar för alla hundar är " + totHours + " timmar.\n");
	}
	
	/**
	 * sortAlphabetically-metoden sorterar alla hundar i bokstavsordning baserat på hundras.
	 * @param dogs Objektarrayen med hundar behövs för att kunna utföra metoden.
	 */
	public static void sortAlphabetically(Dog[] dogs) {

		// skapa en tillfällig / temporär hund (ett objekt)
		Dog temp = new Dog("H1", "Nike", 8, "Labrador", "Svart", "Hane", "Sara Karlsson", "07012345678", 5, "-");
		
		// för varje index / hund i objektarrayen
		for (int i = 0; i < dogs.length; i++) {
			
			// för varje hundras bland hundarna
			for (int j = i + 1; dogs[i] != null && j < dogs[i].breed.length(); j++) {

				// om hunden inte finns eller är "borttagen"
				if (dogs[i] == null || dogs[i].id.equals("deleted")) {

					// gör inget
				}
				// annars om *nästa* hund (som ska jämföras) inte finns eller är "borttagen"
				else if (dogs[j] == null || dogs[j].id.equals("deleted")) {

					// gör inget
				}
				// annars om hundrasens bokstäver kommer före nästa hundrasens bokstäver i alfabetet
				else if (dogs[i].breed.toUpperCase().compareTo(dogs[j].breed.toUpperCase()) > 0) {
					
					// byt plats på dem
					temp = dogs[j];
					dogs[j] = dogs[i];
					dogs[i] = temp;
				}
			}
		}
	}
	
	/**
	 * randomWinner-metoden slumpar fram en hund som vinner 10 gratis timmar.
	 * @param dogs Objektarrayen med hundar behövs för att kunna utföra metoden.
	 */
	public static void randomWinner(Dog[] dogs) {
		
		// skapa boolean för om det inte finns någon passande hund
		// Random-objekt behövs för att slumpa fram en index i objektarrayen för hundarna
		// strängar för hundens namn och utmatning initieras
		// heltal för räknare initieras
		boolean notDog = true;
		Random rand = new Random();
		String name = "";
		String output = "";
		int counter = 0;

		System.out.println("Du har valt att slumpa fram en hund som skall få vinna 10 gratis timmar\n");
		
		// för varje hund i objektarrayen
		for (Dog d : dogs) {

			// om hunden inte finns, är "borttagen" eller inte har stannat längre än 10 timmar
			if (d == null || d.id.equals("deleted") || d.hours < 10) {
				
				// gör inget
			}
			// annars om hunden har stannat längre än 10 timmar
			else if (d.hours > 10) {
				
				// öka räknaren med 1
				counter++;
			}
		}
		
		// medan hunden inte hittats
		while (notDog) {

			// slumpa fram ett nytt number
			int rand_int = rand.nextInt(dogs.length);
			
			// om räknare är 0 - det inte finns några hundar som stannat längre än 40 timmar
			if (counter == 0) {

				// lämna loopen
				break;
			}
			// annars om hunden med det slumpade numret som index är tom eller "borttaggen"
			// och hunden har stannat mindre än 10 timmar
			else if (dogs[rand_int] == null || dogs[rand_int].id.equals("deleted") || dogs[rand_int].hours < 10) {

				// fortsätt till nästa varv av loopen
				continue;
			}
			// annars om hunden med det slumpade numret som index har stannat längre än 10
			// timmar
			else if (dogs[rand_int].hours > 10) {

				// minska hundens timmar med 10 / lägg till 10 gratis timmar
				// namnsträngen får hundens namn medan hunden och dess information lagras i
				// utmatningssträngen
				// utmatning sker och notDog blir falsk som visar att en hund finns, loopen
				// lämnas
				dogs[rand_int].hours -= 10;
				name = dogs[rand_int].name;
				output = dogs[rand_int].readDog();
				System.out.println("Vinnaren är: " + name + "\n\n" + output);
				notDog = false;
			}
			
		}
		
		// om räknare är 0 / om det inte finns någon passande hund eller någon hund alls
		if (counter == 0) {
			System.out.println("Det fanns inga hundar som stannat längre än 10 timmar.\n");
		}
	}

}
