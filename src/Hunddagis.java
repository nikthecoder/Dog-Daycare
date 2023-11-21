import java.util.Random;
import java.util.Scanner;

/**
 * Hunddagis-klassen skapar en objektarray av hundar, l�gger till 3 hundar i arrayen och
 * anv�nder sedan en metod f�r att visa en meny som forts�tter programmet och g�r det
 * m�jligt f�r anv�ndaren att interagera med Hunddagiset.
 */
public class Hunddagis {

	public static void main(String[] args) {

		// Basoperationen
		// Skapa 3 standard-objekt / hundar med dess information / egenskaper
		Dog h1 = new Dog("H1", "Nike", 8, "Labrador", "Svart", "Hane", "Sara Karlsson", "07012345678", 5, "-");
		Dog h2 = new Dog("H2", "Cookie", 3, "Coccker spaniel", "Vit och brun", "Tik", "Kalle Ek", "07012345679", 49,
				"-");
		Dog h3 = new Dog("H3", "Lara", 5, "Fransk Bulldog", "Svart", "Tik", "Pelle Andersson", "07012345671", 30, "-");

		// skapa en objektarray som ska h�lla hundarna
		Dog[] dogs = new Dog[21];
		
		// l�gg de 3 hundarna i objektarrayen 
		dogs[0] = h1;
		dogs[1] = h2;
		dogs[2] = h3;

		// kalla p� metoden f�r menyn, som startar hela programmet och dess interaktion
		menu(dogs);

	}

	/**
	 * menu-metoden skapar en meny med flera alternativ.
	 * Alternativ A l�ter anv�ndaren l�gga till en hund i arrayen.
	 * Alternativ B l�ter anv�ndaren uppdatera en hunds timmar i arrayen.
	 * Alternativ C l�ter anv�ndaren ta bort en hund fr�n arrayen.
	 * Alternativ D visar alla hundar i arrayen / hunddagiset.
	 * Alternativ E l�ter anv�ndaren s�ka efter en hund i arrayen som stannat l�ngre �n 40 timmar.
	 * Alternativ F visar priset som ska betalas av en viss kontaktperson denna m�naden.
	 * Alternativ G visar alla hundar som �r en viss hundras.
	 * Alternativ H visar en specifik hund i arrayen.
	 * Alternativ I det totala antalet timmar bland alla hundar i hunddagiset, sammanlagt.
	 * Alternativ J slumpar fram en vinnare bland hundarna som f�r 10 gratis timmar.
	 * Alternativ K sorterar alla hundar i arrayen i bokstavsordning baserat p� hundras.
	 * Alternativ Q f�r anv�ndaren att g� ur menyn och avsluta programmet.
	 * @param dogs Objektarrayen med hundar beh�vs f�r att kunna utf�ra metoderna i menyn (se ovan).
	 */
	public static void menu(Dog[] dogs) {

		// Scanner-objektet m�jligg�r hantering av indata
		Scanner input = new Scanner(System.in);

		// boolesk variabel f�r menyns while-loop
		boolean isRunning = true;

		//medan isRunning = true, visa menyn och dess alternativ
		while (isRunning) {
			System.out.println(
							  "[A] - L�gg till en hund\n"
							+ "[B] - Uppdatera timmar f�r en viss hund\n"
							+ "[C] - Ta bort hund\n"
							+ "[D] - Visa alla hundar\n"
							+ "[E] - S�k efter hundar som stannat l�ngre �n 40 timmar\n"
							+ "[F] - Visa priset som ska betalas denna m�naden\n"
							+ "[G] - Visa alla hundar som �r av en viss hundras\n"
							+ "[H] - Visa en specifik hund\n"
							+ "[I] - Visa den totala m�ngden timmar bland hundarna\n"
							+ "[J] - Slumpa fram en hund som ska f� vinna 10 gratis timmar\n"
							+ "[K] - Sortera alla hundar i bokstavsordning baserat p� hundras\n"
							+ "[Q] - Avsluta\n");

			// lagra indatan i str�ngen answer
			String answer = input.nextLine();

			// switch sats f�r str�ngen answer / indatan / svaret
			switch (answer.toUpperCase()) {
			case "A": // Om "A" matas in, l�gg till hund
				addDog(dogs);
				break;
			case "B": // Om "B" matas in, uppdatera timmarna f�r en hund
				updateHours(dogs);
				break;
			case "C": // Om "C" matas in, ta bort hund
				removeDog(dogs);
				break;
			case "D": // Om "D" matas in, visa alla hundar
				showAllDogs(dogs);
				break;
			case "E": // Om "E" matas in, s�k efter hundar som stannat l�ngre �n 40 timmar
				searchDogsOver40Hours(dogs);
				break;
			case "F": // Om "F" matas in, visa priset som en kontaktperson ska betala
				showPrice(dogs);
				break;
			case "G": // Om "G" matas in, visa alla hundar som �r en viss hundras
				showBreed(dogs);
				break;
			case "H": // Om "H" matas in, visa en specifik hund
				showDog(dogs);
				break;
			case "I": // Om "I" matas in, visa det totala antalet timmar f�r hundarna, sammanlagt
				showTotalHours(dogs);
				break;
			case "J": // Om "J" matas in, slumpa fram en hund som f�r vinna 10 gratis timmar
				randomWinner(dogs);
				break;
			case "K": // Om "K" matas in, sortera alla hundar i bokstavsordning baserat p� hundras
				sortAlphabetically(dogs);
				break;
			case "Q": // Om "Q" matas in, g� ut ur menyn och avsluta programmet
				isRunning = false;
				break;
			default: // Om n�got annat �n alternativen ovan matas in, skriv ut felmeddelande 
				System.out.println("Ogiltigt alternativ.\n");
				break;
			}
		}

	}

	/**
	 * addDog-metoden l�ter anv�ndaren l�gga till en hund i objektarrayen genom att
	 * den l�ser in HundID, namn, �lder, hundras, f�rg, k�n, kontaktperson, telefonnummer,
	 * antal timmar i hunddagiset och �ven �vrig information.
	 * @param dogs Objektarrayen med hundar beh�vs f�r att kunna utf�ra metoden.
	 */
	public static void addDog(Dog[] dogs) {

		// Scanner-objektet m�jligg�r hantering av indata
		Scanner input = new Scanner(System.in);

		// variabler f�r egenskaperna skapas, �ven en boolean f�r om en hund redan finns
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

		// en r�knare initieras och objektarrayen analyseras
		// om en index i arrayen �r tom eller om en hund �r "borttagen" s� �kar r�knarens v�rde
		int counter = 0;
		for (int i = 0; i < dogs.length; i++) {
			if (dogs[i] == null || dogs[i].id.equals("deleted")) {
				counter++;
			}
		}
		
		System.out.println("Du har valt att l�gga till en hund\n");

		// om r�knarens v�rde �r 0 s� betyder det att det inte finns plats f�r fler hundar
		if (counter == 0) {
			System.out.print("Vi har ingen plats f�r fler hundar, tyv�rr.\n");
		}
		// annars s� f�r anv�ndaren mata in ett hundID f�r den nya hunden
		else {
			//HundID't matas in och lagras
			System.out.print("HundID: ");
			id = input.nextLine().toUpperCase();

			// f�r varje hund i objektarrayen
			for (Dog d : dogs) {

				// om objektet �r "tomt" eller har ID't "deleted" (borttagen)
				if (d == null || d.id.equals("deleted")) {

					// g�r inget
				}
				// annars om det ID't som matats in redan finns bland hundarna
				else if (id.equals(d.id)) {

					// boolean alreadyExists (redan finns) blir sant och ett felmeddelande skrivs ut
					alreadyExists = true;
					System.out.println("En hund med hund-id " + d.id + " finns redan i v�r samling\n");
					break;
				}
			}
			
			// om hunden inte redan finns, be anv�ndaren att mata in mer information om hunden
			if (!alreadyExists) {

				System.out.print("Hundnamn: ");
				name = input.nextLine();

				System.out.print("�lder: ");
				age = Integer.parseInt(input.nextLine());

				System.out.print("Hundras: ");
				breed = input.nextLine();

				System.out.print("F�rg: ");
				color = input.nextLine();

				System.out.print("K�n: ");
				gender = input.nextLine();

				System.out.print("Kontaktperson: ");
				contactPerson = input.nextLine();

				System.out.print("telnr: ");
				phoneNumber = input.nextLine();

				System.out.print("Totalt antal timmar p� hunddagis: ");
				hours = Integer.parseInt(input.nextLine());

				System.out.print("�vrig info: ");
				other = input.nextLine();

				// skapa ett objekt av hunden med alla egenskaper som matats in
				Dog dog = new Dog(id, name, age, breed, color, gender, contactPerson, phoneNumber, hours, other);

				// f�r varje index i objektarrayen
				for (int i = 0; i < dogs.length; i++) {

					// om indexen �r "tom" eller "borttagen" s� kan den nya hunden l�ggas in d�r
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
	 * updateHours-metoden l�ter anv�ndaren uppdatera - minska eller �ka - antalet timmar
	 * p� en viss hund i objektarrayen.
	 * @param dogs Objektarrayen med hundar beh�vs f�r att kunna utf�ra metoden.
	 */
	public static void updateHours(Dog[] dogs) {

		// Scanner-objektet m�jligg�r hantering av indata
		// str�ng f�r utmatning initieras
		// heltal f�r timmar initieras
		Scanner input = new Scanner(System.in);
		String output = "";
		int hours = 0;

		// anv�ndaren f�r skriva vilken hund vars timmar de vill uppdatera, baserat p� ID't
		System.out.print("Du har valt att uppdatera en hunds timmar\nHundID: ");
		String id = input.nextLine();

		// f�r varje hund i objektarrayen
		for (Dog d : dogs) {

			// om objektet �r "tomt" eller har ID't "deleted" (borttagen)
			if (d == null || d.id.equals("deleted")) {

				// g�r inget
			}
			// annars om ID't som matats in finns
			else if (id.toUpperCase().equals(d.id)) {
				
				// anv�ndaren matar in det nya antalet timmar f�r hunden, som sparas i objektet
				// utmatningsstr�ngen blir nu ett meddelande och loopen l�mnas
				System.out.print("Mata in hur m�nga timmar som ska registreras p� hunden: ");
				hours = Integer.parseInt(input.nextLine());
				d.hours = hours;
				output = "Hundens timmar har uppdaterats.\n";
				break;
			}
		}

		// om inget gjorts i f�reg�ende if sats och output �r tom
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
	 * removeDog-metoden l�ter anv�ndaren ta bort en viss hund i objektarrayen.
	 * @param dogs Objektarrayen med hundar beh�vs f�r att kunna utf�ra metoden.
	 */
	public static void removeDog(Dog[] dogs) {

		// Scanner-objektet m�jligg�r hantering av indata
		// str�ng f�r utmatning initieras
		Scanner input = new Scanner(System.in);
		String output = "";

		// anv�ndaren matar in HundID't, som sparas
		System.out.print("Du har valt att ta bort en hund\n\nHundID: ");
		String id = input.nextLine();

		// f�r varje hund i objektarrayen
		for (Dog d : dogs) {

			// om objektet �r "tomt"
			if (d == null) {

				// g�r inget
			}
			// annars om hunden finns, �ndra ID't till "deleted" (borttagen), hunden "tas bort"
			// meddelande skrivs ut och loopen l�mnas
			else if (id.toUpperCase().equals(d.id)) {
				d.id = "deleted";
				output = "Hund borttagen fr�n systemet.\n";
				break;
			}
		}

		// om inget gjorts i f�reg�ende if sats och output �r tom
		if (output.equals("")) {
			// skriv ut felmeddelande
			System.out.println("Hunden finns inte i systemet.\n");
		}
		// annars, meddela om att borttagning slutf�rts
		else {
			System.out.println(output);
		}
	}

	/**
	 * showAllDogs-metoden visar alla hundar i objektarrayen.
	 * @param dogs Objektarrayen med hundar beh�vs f�r att kunna utf�ra metoden.
	 */
	public static void showAllDogs(Dog[] dogs) {

		//str�ng f�r utmatning initieras
		String output = "";

		System.out.println("Du har valt att visa alla hundar\n");
		
		// f�r varje hund i objektarrayen
		for (Dog d : dogs) {

			// om hunden inte finns eller �r "borttagen"
			if (d == null || d.id.equals("deleted")) {

				// g�r inget
			}
			// annars
			else {

				// skriv ut / visa hunden och dess information
				output = d.readDog();
				System.out.println(output);
			}
		}
		
		// om inget gjorts i f�reg�ende if sats och output �r tom
		if (output.equals("")) {
			System.out.println("Det finns inga hundar f�r tillf�llet.\n");
		}
	}

	/**
	 * searchDogsOver40Hours-metoden l�ter anv�ndaren s�ka efter hundar i objektarrayen
	 * vars timmar �r h�gre �n 40. De hundar som stannat l�ngre �n 40 timmar f�r ett nytt
	 * rabaterrat timpris.
	 * @param dogs Objektarrayen med hundar beh�vs f�r att kunna utf�ra metoden.
	 */
	public static void searchDogsOver40Hours(Dog[] dogs) {

		// str�ng f�r alla hundar som stannat l�ngre �n 40 timmar initieras
		String dogsOver40 = "";

		System.out.println("Du har valt att s�ka efter alla hundar som stannat l�ngre �n 40 timmar");

		// f�r varje hund i objektarrayen
		for (Dog d : dogs) {

			// om hunden inte finns eller �r "borttagen"
			if (d == null || d.id.equals("deleted")) {

				// g�r inget
			}
			// annars om hunden stannat l�ngre �n 40 timmar
			else if (d.hours > 40) {

				// l�gg till hunden till str�ngen dogsOver40
				dogsOver40 += d.name + "\n";
			}
		}

		// om inget gjorts i f�reg�ende if sats och dogsOver40 �r tom
		if (dogsOver40.equals("")) {
			System.out.println("Det fanns inga hundar som stannat l�ngre �n 40 timmar.\n");
		}
		// annars, skriv ut hundarna som stannat l�ngre �n 40 timmar
		else {
			System.out.println("Dessa hundar har stannat l�ngre �n 40 timmar och f�r nu ett nytt timpris, med 10% rabatt:");
			System.out.println(dogsOver40);
		}
	}

	/**
	 * showPrice-metoden visar priset som ska betalas av en viss kontaktperson denna m�naden.
	 * @param dogs Objektarrayen med hundar beh�vs f�r att kunna utf�ra metoden.
	 */
	public static void showPrice(Dog[] dogs) {

		// konstanterna f�r timpris och rabatt skapas
		final double HOURLY_FEE = 25;
		final double DISCOUNT = 0.9;

		// Scanner-objektet beh�vs f�r hantering av indata
		// str�ngar f�r kontaktperson och namn initieras, samt ett tal f�r det resulterande priset
		// boolean f�r om kontaktpersonen och dess hund inte finns med i objektarrayen
		Scanner input = new Scanner(System.in);
		String contactPerson = "";
		String name = "";
		double price = 0;
		boolean doesNotExist = true;

		// Kontaktpersonen matas in och sparas
		System.out.print("Du har valt att visa priset som ska betalas denna m�naden\nKontaktperson: ");
		contactPerson = input.nextLine();

		// f�r varje hund i objektarrayen
		for (Dog d : dogs) {

			// om hunden inte finns eller �r "borttagen"
			if (d == null || d.id.equals("deleted")) {
				
				// g�r inget
			}
			// annars om kontaktpersonen finns och dess hund stannat l�ngre �n 40 timmar
			else if (contactPerson.toUpperCase().equals(d.contactPerson.toUpperCase()) && d.hours > 40) {
				
				// boolean doesNotExist (finns inte) blir falsk, det *rabatterade* priset ber�knas
				// utmatningen av kontaktpersonen, dess avgift och dess hund sker
				doesNotExist = false;
				price = (double)d.hours * HOURLY_FEE * DISCOUNT;
				name = d.name;
				System.out.printf(contactPerson + " ska betala %.2f kr f�r " + name + ".\n", price);
				
			}
			// annars om kontaktpersonen finns och dess hund *INTE* stannat l�ngre �n 40 timmar
			else if (contactPerson.toUpperCase().equals(d.contactPerson.toUpperCase())) {
				
				// boolean doesNotExist (finns inte) blir falsk, priset ber�knas
				// utmatningen av kontaktpersonen, dess avgift och dess hund sker
				doesNotExist = false;
				price = (double)d.hours * HOURLY_FEE;
				name = d.name;
				System.out.printf(contactPerson + " ska betala %.2f kr f�r " + name + ".\n", price);
			}
		}

		// om kontaktpersonen inte finns i objektarrayen
		if (doesNotExist) {
			System.out.println("Kontaktpersonen finns inte i v�rt system.\n");
		}

	}

	/**
	 * showBreed-metoden visar alla hundar som �r en viss hundras.
	 * @param dogs Objektarrayen med hundar beh�vs f�r att kunna utf�ra metoden.
	 */
	public static void showBreed(Dog[] dogs) {

		// Scanner-objekt beh�vs f�r hantering av indata, str�ngar f�r hundras och utmatning initieras
		Scanner input = new Scanner(System.in);
		String breed = "";
		String output = "";

		// hundrasen matas in
		System.out.print("Du har valt att visa alla hundar som �r en viss hundras\nHundras: ");
		breed = input.nextLine();

		// f�r varje hund i objektarrayen
		for (Dog d : dogs) {

			// om hunden inte finns eller �r "borttagen"
			if (d == null || d.id.equals("deleted")) {

				// g�r inget
			}
			// annars om det finns en eller flera hundar med hundrasen
			else if (breed.toUpperCase().equals(d.breed.toUpperCase())) {

				// l�gg till hunden i utmatningsstr�ngen och skriv ut den
				output = d.readDog();
				System.out.println(output);

			}
		}

		// om inget gjordes i f�reg�ende if-sats och output �r tom
		if (output.equals("")) {
			System.out.println("Det finns ingen hund hos oss med den hundrasen.\n");
		}
	}

	/**
	 * showDog-metoden visar en specifik hund.
	 * @param dogs Objektarrayen med hundar beh�vs f�r att kunna utf�ra metoden.
	 */
	public static void showDog(Dog[] dogs) {

		// Scanner-objektet beh�vs f�r hantering av indata, str�ngar f�r id och utmatning initieras
		Scanner input = new Scanner(System.in);
		String id = "";
		String output = "";

		// ID matas in
		System.out.print("Du har valt att visa en specifik hund\nHund-ID: ");
		id = input.nextLine();

		// f�r varje hund i objektarrayen
		for (Dog d : dogs) {

			// om hunden inte finns eller �r "borttagen"
			if (d == null || d.id.equals("deleted")) {

				// g�r inget
			}
			// annars om hunden med ID't finns
			else if (id.toUpperCase().equals(d.id)) {

				// lagra hunden och dess information i utmatningsstr�ngen och skriv ut den
				output = d.readDog();
				System.out.println("\n" + output);

			}
		}

		// om inget gjorts i f�reg�ende if-sats och output �r tom
		if (output.equals("")) {
			System.out.println("Det finns ingen hund hos oss med det Hund-ID't.\n");
		}
	}

	/**
	 * showTotalHours-metoden visar det totala antalet timmar bland hundarna, sammanlagt.
	 * @param dogs Objektarrayen med hundar beh�vs f�r att kunna utf�ra metoden.
	 */
	public static void showTotalHours(Dog[] dogs) {

		// heltal f�r det totala antalet timmar initieras
		int totHours = 0;

		System.out.println("Du har valt att visa det totala antalet timmar bland hundarna.\n");
		
		// f�r varje hund i objektarrayen
		for (Dog d : dogs) {
			
			// om hunden inte finns eller �r "borttagen"
			if (d == null || d.id.equals("deleted")) {

			}
			// annars
			else {
				// l�gg till hundens timmar till variablen med det totala antalet timmar
				totHours += d.hours;
			}
		}

		// utmatning f�r det totala antalet timmar
		System.out.println("Det totala antalet timmar f�r alla hundar �r " + totHours + " timmar.\n");
	}
	
	/**
	 * sortAlphabetically-metoden sorterar alla hundar i bokstavsordning baserat p� hundras.
	 * @param dogs Objektarrayen med hundar beh�vs f�r att kunna utf�ra metoden.
	 */
	public static void sortAlphabetically(Dog[] dogs) {

		// skapa en tillf�llig / tempor�r hund (ett objekt)
		Dog temp = new Dog("H1", "Nike", 8, "Labrador", "Svart", "Hane", "Sara Karlsson", "07012345678", 5, "-");
		
		// f�r varje index / hund i objektarrayen
		for (int i = 0; i < dogs.length; i++) {
			
			// f�r varje hundras bland hundarna
			for (int j = i + 1; dogs[i] != null && j < dogs[i].breed.length(); j++) {

				// om hunden inte finns eller �r "borttagen"
				if (dogs[i] == null || dogs[i].id.equals("deleted")) {

					// g�r inget
				}
				// annars om *n�sta* hund (som ska j�mf�ras) inte finns eller �r "borttagen"
				else if (dogs[j] == null || dogs[j].id.equals("deleted")) {

					// g�r inget
				}
				// annars om hundrasens bokst�ver kommer f�re n�sta hundrasens bokst�ver i alfabetet
				else if (dogs[i].breed.toUpperCase().compareTo(dogs[j].breed.toUpperCase()) > 0) {
					
					// byt plats p� dem
					temp = dogs[j];
					dogs[j] = dogs[i];
					dogs[i] = temp;
				}
			}
		}
	}
	
	/**
	 * randomWinner-metoden slumpar fram en hund som vinner 10 gratis timmar.
	 * @param dogs Objektarrayen med hundar beh�vs f�r att kunna utf�ra metoden.
	 */
	public static void randomWinner(Dog[] dogs) {
		
		// skapa boolean f�r om det inte finns n�gon passande hund
		// Random-objekt beh�vs f�r att slumpa fram en index i objektarrayen f�r hundarna
		// str�ngar f�r hundens namn och utmatning initieras
		// heltal f�r r�knare initieras
		boolean notDog = true;
		Random rand = new Random();
		String name = "";
		String output = "";
		int counter = 0;

		System.out.println("Du har valt att slumpa fram en hund som skall f� vinna 10 gratis timmar\n");
		
		// f�r varje hund i objektarrayen
		for (Dog d : dogs) {

			// om hunden inte finns, �r "borttagen" eller inte har stannat l�ngre �n 10 timmar
			if (d == null || d.id.equals("deleted") || d.hours < 10) {
				
				// g�r inget
			}
			// annars om hunden har stannat l�ngre �n 10 timmar
			else if (d.hours > 10) {
				
				// �ka r�knaren med 1
				counter++;
			}
		}
		
		// medan hunden inte hittats
		while (notDog) {

			// slumpa fram ett nytt number
			int rand_int = rand.nextInt(dogs.length);
			
			// om r�knare �r 0 - det inte finns n�gra hundar som stannat l�ngre �n 40 timmar
			if (counter == 0) {

				// l�mna loopen
				break;
			}
			// annars om hunden med det slumpade numret som index �r tom eller "borttaggen"
			// och hunden har stannat mindre �n 10 timmar
			else if (dogs[rand_int] == null || dogs[rand_int].id.equals("deleted") || dogs[rand_int].hours < 10) {

				// forts�tt till n�sta varv av loopen
				continue;
			}
			// annars om hunden med det slumpade numret som index har stannat l�ngre �n 10
			// timmar
			else if (dogs[rand_int].hours > 10) {

				// minska hundens timmar med 10 / l�gg till 10 gratis timmar
				// namnstr�ngen f�r hundens namn medan hunden och dess information lagras i
				// utmatningsstr�ngen
				// utmatning sker och notDog blir falsk som visar att en hund finns, loopen
				// l�mnas
				dogs[rand_int].hours -= 10;
				name = dogs[rand_int].name;
				output = dogs[rand_int].readDog();
				System.out.println("Vinnaren �r: " + name + "\n\n" + output);
				notDog = false;
			}
			
		}
		
		// om r�knare �r 0 / om det inte finns n�gon passande hund eller n�gon hund alls
		if (counter == 0) {
			System.out.println("Det fanns inga hundar som stannat l�ngre �n 10 timmar.\n");
		}
	}

}
