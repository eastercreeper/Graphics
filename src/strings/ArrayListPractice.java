package other;

import java.util.ArrayList;

public class ArrayListPractice {

	// TODO: Finish methods
	public static int numWordsOfLength(ArrayList<String> words, int targetLen) {
		int total = 0;
		for (String word : words) {
			if (word.length() == targetLen) {
				total++;
			}
		}
		return total; // placeholder
	}

	public static void removeWordsOfLength(ArrayList<String> words, int targetLen) {
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).length() == targetLen) {
				words.remove(i);
				i = i -1;
			}
		}
	}

		public static void main (String[] args){
			ArrayList<String> testList = new ArrayList<String>();
			testList.add("cat");
			testList.add("dog");
			testList.add("frog");
			testList.add("dog");
			testList.add("mouse");

			// problem #1 tests
			System.out.println(numWordsOfLength(testList, 4)); // prints 1
			System.out.println(numWordsOfLength(testList, 3)); // prints 3

			// problem #2 tests
			removeWordsOfLength(testList, 3);
			System.out.println(testList); // prints frog mouse

			// TODO: problem #3 code goes here
			ArrayList<SuperHero> superHeros = new ArrayList<SuperHero>();
			SuperHero hero1 = new SuperHero("Ninja",30000);
			SuperHero hero3 = new SuperHero("Sid",20000);
			SuperHero hero2 = new SuperHero("Roen",15000);

			superHeros.add(hero1);
			superHeros.add(hero2);
			superHeros.add(1,hero3);

            for (SuperHero superHero : superHeros) {
				System.out.print(superHero.getName());
				if (superHero.getFans() >= 20000) {
                    System.out.print(" " + superHero.getFans());
					System.out.println(" ");
				}
            }


		}


		// nested class for problem #3 - don't edit this code
		static class SuperHero {
			private String name;
			private int fans;

			public SuperHero(String name, int fans) {
				this.name = name;
				this.fans = fans;
			}

			public String getName() {
				return name;
			}

			public int getFans() {
				return fans;
			}

			public void addFans(int newFans) {
				fans += newFans;
			}
		}
	}
