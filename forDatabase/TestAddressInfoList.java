package forDatabase;

//Ching Yu

public class TestAddressInfoList {

	public static void main(String[] args) {	
		List myInfoList = new List();
		
		System.out.println("Now testing AddressInfoList...");
		System.out.println("\nAttempting to add Pufferfish...");
		if (myInfoList.add(new AddressInfo("Cutie", "Pufferfish",
				"123 Pacific Ocean",
				"Island", "CA", "91770"))){
			System.out.println("Pufferfish added.");
		}else{
			System.out.println("Pufferfish not added.");
		}//else
		System.out.println("\nAttempting to add Sebastian...");
		if (myInfoList.add(new AddressInfo("Evil", "Sebastian",
				"124 Atlantic Ocean",
				"Waterland", "GA", "91755"))){
			System.out.println("Sebastian added.");
		}else{
			System.out.println("Sebastian not added.");
		}//else
		System.out.println("\nAttempting to add Nemo...");
		if (myInfoList.add(new AddressInfo("Smiley", "Nemo"))){
			System.out.println("Nemo added.");
		}else{
			System.out.println("Nemo not added.");
		}//else
		System.out.println("\nIs the array full yet?: " 
				+ myInfoList.isFull());
		System.out.println("\nAttempting to add Flounder...");
		if (myInfoList.add(new AddressInfo("Happy", "Flounder",
				"125 Great Lake",
				"Oceanpark", "OH", "91770"))){
			System.out.println("Flounder added.");
		}else{
			System.out.println("Flounder not added.");
		}//else
		System.out.println("\nAttempting to add Goldfish...");
		if (myInfoList.add(new AddressInfo("Flappy", "Goldfish",
				"126 Abyss",
				"Ventland", "NY", "91755"))){
			System.out.println("Goldfish added.");
		}else{
			System.out.println("Goldfish not added.");
		}//else
		System.out.println("\nHere is the list: \n" 
				+ myInfoList.toString());
		System.out.println("\nIs the array full now?: " 
				+ myInfoList.isFull());
		System.out.println("\nAttempting to sort list alphabetically...");
		myInfoList.sort();
		System.out.println("\nHere is the alphabetically sorted list: \n"
				+ myInfoList.toString());
		System.out.println("\nAttempting to sort list by address...");
		myInfoList.sort();
		System.out.println("\nHere is the address sorted list: \n" 
				+ myInfoList.toString());
		System.out.println("\nAttempting to search for Nemo....");
		System.out.println("Nemo is in the database: " +
				myInfoList.search(new AddressInfo("Smiley","Nemo")));
		System.out.println("\nAttempting to search for Mermaid....");
		System.out.println("Mermaid is not in the database: " +
				myInfoList.search(new AddressInfo("Fishy","Mermaid")));
		System.out.println("\nAttempting to delete Nemo...");
		System.out.println("Is Nemo deleted?: " + 
				myInfoList.delete(new AddressInfo("Smiley","Nemo")));
		System.out.println("\nAttempting to delete Mermaid...");
		System.out.println("Is Mermaid deleted?: " + 
				myInfoList.delete(new AddressInfo("Fishy","Mermaid")));
	}//main class

}//TestAddressInfoList class
