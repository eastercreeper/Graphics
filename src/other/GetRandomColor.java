package other;

import java.awt.Color;




//make sure the class extends jPanel

public class GetRandomColor {

	public GetRandomColor() {

		

	}

	public static Color randomColor(int minr, int maxr, int ming, int maxg, int minb, int maxb) {

		return new Color((int)(Math.random()*(maxr-minr+1))+minr, (int)(Math.random()*(maxg-ming+1))+ming, (int)(Math.random()*(maxb-minb+1))+minb);

	}

	public static Color randomColor() {

		return new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));

	}

	public static Color randomRed() {

		return new Color(randomInt(100, 255), 0, 0);

	}

	public static Color randomRed(int min) {

		return new Color(randomInt(min, 255), 0, 0);

	}

	public static Color randomGreen() {

		return new Color(0, randomInt(100, 255), 0);

	}

	public static Color randomGreen(int min) {

		return new Color(0, randomInt(min, 255), 0);

	}

	public static Color randomBlue() {

		return new Color(0, 0, randomInt(100, 255));

	}


	public static Color randomBlue(int min) {

		return new Color(0, 0, randomInt(min, 255));

	}

	public static int randomInt(int min, int max) {

		return (int) (Math.random()*(max-min+1))+min;

	}

	public static double randomDouble(double min, double max) {

		return (Math.random()*(max-min+1))+min;

	}

	public static int randomEven(int min, int max) {

		int randInt=(int) (Math.random()*(max-min+1))+min;

		while(randInt%2!=0) {

			randInt=(int) (Math.random()*(max-min+1))+min;

		}

		return randInt;

	}

	public static int randomMultipleOf(int min, int max, int mult) {

		int randInt=(int) (Math.random()*(max-min+1))+min;

		while(randInt%mult!=0) {

			randInt=(int) (Math.random()*(max-min+1))+min;

		}

		return randInt;

	}

}