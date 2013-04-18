package forDatabase;

//Ching Yu


public class TestAddressInfo {

	public static void main(String[] args) {
		AddressInfo info1;
		AddressInfo info2;
		AddressInfo info3;
		AddressInfo info4;
		AddressInfo info6;
		Address ad1;
		Address ad2;
		Address ad3;
		Address ad4;
		Address ad5;
		Address ad6;
		Name name1;
		Name name2;
		Name name3;
		Name name4;
		
		System.out.println("Now testing the Name class....");
		name1 = new Name("Yu", "Tiffany");
		System.out.println("Name1 is " + name1);
		name1.setFirst("Danny");
		System.out.println("You just changed Name1's first name. \n" +
				"Name1's first name is now " + name1.getFirst());
		name1.setLast("Liang");
		System.out.println("You just changed Name1's last name. \n" +
				"Name1's last name is now " + name1.getLast());
		name2 = new Name("Liang", "Danny");
		name3 = new Name("Zhao", "Jiawei");
		System.out.println("Name2 is " + name2);
		System.out.println("Name3 is " + name3);
		System.out.println("Are Name1 and Name2 the same?: " + name1.equals(name2));
		System.out.println("Are Name1 and Name3 the same?: " + name1.equals(name3));
		System.out.println("Is Name1 before Name3?: " + name1.before(name3));
		System.out.println("Is Name3 before Name1?: " + name3.before(name1));
		name4 = new Name("Zhao", "Yang");
		System.out.println("Name4 is " + name4);
		System.out.println("Is Name3 before Name4?: " + name3.before(name4));
		System.out.println("The value comparing Name2 to Name4 is: " + name2.compareTo(name4));
		System.out.println("The value comparing Name4 to Name2 is: " + name4.compareTo(name2));
		System.out.println("The value comparing Name1 to Name2 is: " + name1.compareTo(name2) +"\n");
		
		System.out.println("Now testing the Address class....");
		ad1 = new Address("123 Hellman Ave.", "Condo X", "Rosemead",
				"CA", "91770");
		System.out.println("Address1 is: " + ad1);
		ad2 = new Address("455 Greenwood Dr.", "San Pablo",
				"CA", "94806");
		System.out.println("Address2 is: " + ad2);
		ad3 = new Address("333 Pomelo Ave.", "Apartment A", 
				"Monterey Park", "TX", "91755");
		System.out.println("Address3 is: " + ad3);
		ad3.setStreet("123 Hellman Ave.");
		System.out.println("You just changed Address3's street \n" 
				+ "Address3's street is now: " + ad3.getStreet());
		ad3.setLine("Condo A");
		System.out.println("You just changed Address3's optinal line \n" 
				+ "Address3's optional line is now: " + ad3.getLine());
		ad3.setCity("Rosemead");
		System.out.println("You just changed Address3's city \n" 
				+ "Address3's city is now: " + ad3.getCity());
		ad3.setState("CA");
		System.out.println("You just changed Address3's state \n" 
				+ "Address3's state is now: " + ad3.getState());
		ad3.setZipCode("91770");
		System.out.println("You just changed Address3's zip code \n" 
				+ "Address3's zipcode is now: " + ad3.getZipCode());
		System.out.println("Address3 is now: " + ad3);
		System.out.println("Are Address1 and Address3 the same?: " + ad1.equals(ad3));
		System.out.println("Are Address1 and Address2 the same?: " + ad1.equals(ad2));
		System.out.println("Is Address1 before Address2?: " + ad1.before(ad2));
		System.out.println("Is Address2 before Address1?: " + ad2.before(ad1));
		System.out.println("The value comparing Address1 to Address2 is: " + ad1.compareTo(ad2));
		System.out.println("The value comparing Address2 to Address1 is: " + ad2.compareTo(ad1));
		System.out.println("The value comparing Address1 to Address3 is: " + ad1.compareTo(ad3));
		ad4 = new Address("455 Greenwood Dr.", "San Pablo", "CA", "93806");
		System.out.println("Address4 is now: " + ad4);
		ad5 = new Address("455 Greenwood Dr.", "San Leandro", "CA", "94806");
		System.out.println("Address5 is now: " + ad5);
		ad6 = new Address("453 Greenwood Dr.", "San Pablo", "CA", "94806");
		System.out.println("Address5 is now: " + ad6);
		System.out.println("Is Address4 before Address2?: " + ad4.before(ad2));
		System.out.println("Is Address2 before Address4?: " + ad2.before(ad4));
		System.out.println("Is Address5 before Address2?: " + ad5.before(ad2));
		System.out.println("Is Address2 before Address5?: " + ad2.before(ad5));
		System.out.println("Is Address6 before Address2?: " + ad6.before(ad2));
		System.out.println("Is Address2 before Address6?: " + ad2.before(ad6));
		ad4.setLine("Apartment A");
		System.out.println("You just added Address4's optinal line \n" 
				+ "Address4's optional line is now: " + ad4.getLine());
		ad4.setZipCode("94806");
		System.out.println("You just changed Address4's zip code \n" 
				+ "Address4's zip code is now: " + ad4.getZipCode());
		System.out.println("Your changed Address4 is now: " + ad4);
		System.out.println("Now is Address4 before Address2?: " + ad4.before(ad2) + "\n");
		System.out.println("Now testing the AddressInfo class....");
		info1 = new AddressInfo("Yu", "Tiffany", "123 Hellman Ave.",
				"Apartment A", "Rosemead", "CA", "91770");
		System.out.println("AddressInfo1 is: " + info1);
		info2 = new AddressInfo("Wu", "Eric", "1000 Evil Ave.",
					"Candyland", "NO", "1337");
		System.out.println("AddressInfo2 is: " + info2);
		info3 = new AddressInfo("Pooh", "Winnie");
		System.out.println("AddressInfo3 is: " + info3);
		info4 = new AddressInfo("Little", "Piglet");
		System.out.println("AddressInfo4 is: " + info4);
		info1.setName(new Name("Pooh", "Winnie"));
		System.out.println("You just changed the name of AddressInfo1 \n" 
				+ "The name of AddressInfo1 is now: "+ info1.getName());
		info2.setAddress(new Address("143 Chocolate St.", "", "Sweetsland",
				"CA", "1413"));
		System.out.println("The address of AddressInfo2 is: " + info2.getAddress());
		System.out.println("AddressInfo1 is now: " + info1);
		System.out.println("AddressInfo2 is now: " + info2);
		info6 = new AddressInfo("Yu", "Ching", "143 Chocolate St.",
				"", "Sweetsland", "CA", "1413");
		System.out.println("AddressInfo6 is: " + info6);
		info1.setName(new Name("Pooh", "Winnie"));
		System.out.println("Are the names of AddressInfo1 and AddressInfo3 the same?: "
				+ info1.equals(info3));
		System.out.println("Are the names of AddressInfo3 and AddressInfo4 the same?: "
				+ info3.equals(info4));
		System.out.println("Is AddressInfo2 sorted before AddressInfo1?: " + info2.beforeAlpha(info1));
		System.out.println("Is AddressInfo1 sorted before AddressInfo2?: " + info1.beforeAlpha(info2));
		System.out.println("Is AddressInfo6 sorted before AddressInfo2" + 
				"\neven when they have the same address?: " + info6.beforeAddress(info2));
		System.out.println("Is AddressInfo2 sorted before AddressInfo6" +
				"\neven when they have the same address?: " + info2.beforeAddress(info6));
		System.out.println("The value comparing names of AddressInfo1 to AddressInfo3 is: " + ad1.compareTo(ad3));
		System.out.println("The value comparing names of AddressInfo1 to AddressInfo2 is: " + ad1.compareTo(ad2));
		System.out.println("The value comparing names of AddressInfo2 to AddressInfo1 is: " + ad2.compareTo(ad1));
	}//main class
	
}//TestAddressInfo class
