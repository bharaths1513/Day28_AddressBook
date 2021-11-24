package Day28_AddressBook;

import java.util.Comparator;
import java.util.Scanner;

public class Sort {

	static Comparator<Contacts> compareCity = new Comparator<Contacts>() {
		public int compare(Contacts one, Contacts two) {
			return one.getCity().compareTo(two.getCity());
		}
	};
	/*
	 * to State search
	 */
	static Comparator<Contacts> compareState = new Comparator<Contacts>() {
		public int compare(Contacts one, Contacts two) {
			return one.getState().compareTo(two.getState());
		}
	};

	/*
	 * 
	 * to search a person by using first name
	 *
	 */
	static Comparator<Contacts> compareFirstName = new Comparator<Contacts>() {
		public int compare(Contacts one, Contacts two) {
			return one.getFirstName().compareTo(two.getFirstName());
		}
	};

	/*
	 * 
	 * to search a person by zip
	 *
	 */
	public static void zipsort() {
		System.out.println("Enter the Zip code to search");
		Scanner scanner = new Scanner(System.in);
		Long zip = scanner.nextLong();
		Contacts o = new Contacts();
		AddressBook n = new AddressBook();
		Long Zip = o.getZip();
		if (n.list.stream().filter(i -> Zip == zip) != null) {
			System.out.println(n.list);
		}
	}
}
