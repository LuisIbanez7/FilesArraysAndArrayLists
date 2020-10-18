import java.util.ArrayList;
import java.util.Scanner;

public class UniqueNames {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		while (true) {
			Scanner sn = new Scanner(System.in);
			System.out.println("Enter Name: ");
			String name = "";
			name = sn.nextLine();
			//String name = readLine("Enter name: ");
			if (name.equals(""))
				break;
			if (!list.contains(name)) {
				list.add(name);
			}
		}
		System.out.println("Unique name list contains:");
		printList(list);
	}

	/* Prints out contents of ArrayList, one element per line */
	private static void printList(ArrayList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
