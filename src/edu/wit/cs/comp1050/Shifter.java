package edu.wit.cs.comp1050;

public class Shifter {

	//declare a string variable
	String str;

	/**
	 * Number of letters in the English alphabet
	 */

	public static final int NUM_LETTERS = ('z' - 'a') + 1;

	/**
	 * Initializes the shifter
	 *
	 * @param s
	 * encrypted string
	 */

	public Shifter(String s) {
		//initialize the string variable
		str = s;
	}

	/**
	 * Returns the result of shifting by a supplied amount
	 *
	 * @param n
	 * number of places to shift
	 * @return shifted string
	 */

	public String shift(int n) {

		//iterate over the lenght of the string
		for (int i = 0; i < str.length(); i++) {

			//check if the characters of the string is alphabets or not
			if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z')  || (str.charAt(i) > 'A' && str.charAt(i) <= 'Z')) {
				if (str.charAt(i) == 'z') {
					str = str.substring(0, i) + 'a' + str.substring(i + 1);
				}

				else if (str.charAt(i) == 'Z') {
					str = str.substring(0, i) + 'A' + str.substring(i + 1);
				}

				//shift the characters using the substring
				else {
					str = str.substring(0, i) + (char) (str.charAt(i) + 1) + str.substring(i + 1);
				}
			}

		}

		//return the value of the shifted string

		return str;

	}

	/**
	 * Finds all shifts that contain the supplied substring
	 *
	 * @param sub
	 * substring to find
	 * @return array of shifts (0-25) that contain the substring (in order)
	 */

	public int[] findShift(String substr){

		int shift_result[] = new int[26];
		int j = 0;
		for (int i = 0; i < NUM_LETTERS; i++){

			//call the method shift
			str = shift(1);    

			//shift that contain the substring
			if (str.indexOf(substr) != -1){
				shift_result[j] = i + 1;
				j++;
			}
		}

		shift_result[j] = -1;

		// array of shifts (0-25) that contain the substring
		return shift_result;

	}

}