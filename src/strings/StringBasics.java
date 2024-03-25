package other;

import java.util.Scanner;

public class StringBasics {
	/* Given a name, return a greeting.
	 * Input: Matt
	 * Output: Hello Matt! Have a nice day!
	 */
	public static String greet(String name) {
		return "Hello " + name + "! Have a nice day!"; //placeholder
	}

	/* Given a String, return the word/sentence reversed
	 * Input: Hello!
	 * Output: !olleH
	 */
	public static String reverse(String s) {
		String reversed = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reversed += s.charAt(i);
		}
		return reversed; //placeholder
	}

	/* Given a full name return it in the format Last, First
	 * Input: Nate William Cool
	 * Output: William Cool, Nate
	 */
	public static String lastFirst(String fullName) {
		String easy = fullName;
		if(fullName.contains(" ")) {
			easy = fullName.substring(fullName.indexOf(' ') + 1) + ", " + fullName.substring(0, fullName.indexOf(' '));
		}
		return easy; //placeholder
	}

	/* Given a full name return the proper initials
	 * Input: Albus Percival Wulfric Brian Dumbledore
	 * Output: APWBD
	 */
	public static String initials(String fullName) {
		String initials = "";
	    for(int i = 0; i < fullName.length(); i++) {
			if(fullName.charAt(i) ==' ') {
               initials = initials + fullName.charAt(i + 1);
            }
		}
		return fullName.charAt(0) + initials; //placeholder
	}

	/* Given a String, return the number of vowels it contains (AEIOU)
	 * Hint: convert the String to upper or lower case first because a != A
	 * Input: Hello
	 * Output: 2
	 */
	public static int countVowels(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
				count++;
			}
		}
		return count; //placeholder
}
	
	/* Given a String, count and return the number of times
	 * that the letter combo "th" appears (in any case).  
	 * Input: Thomas Cruise Mapother
	 * Output: 2
	 */
	public static int countTh(String s) {
		String easy = s.toLowerCase();
		if(easy.contains("th")) {
			int count = 0;
            for (int i = 0; i < easy.length(); i++) {
                if (easy.charAt(i) == 't' && easy.charAt(i + 1) == 'h') {
                    count++;
                }
            }
            return count;
		}
		return 0; //placeholder
	}
	
	public static void main(String[] args) {
	/* Ask the user to enter a name via Scanner
	 * Run all of your methods with that name and print the results.
	 */
		Scanner input = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String name = input.nextLine();
        System.out.println(greet(name));
        System.out.println("Number of Vowels: " + countVowels(name));
        System.out.println("Number of TH:" + countTh(name));
		System.out.println(reverse(name));
		System.out.println(lastFirst(name));
		System.out.println(initials(name));
	}
}