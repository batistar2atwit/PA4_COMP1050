package edu.wit.cs.comp1050;

public class PA4a

{

     /**

     * Error if incorrect command-line arguments are supplied

     */

     public static final String ERR_USAGE = "Please supply correct inputs: <encrypted string> <substring>";

     /**

     * Error if shift could not be found

     */

     public static final String ERR_NONE = "No valid shifts found.";

     /**

     * Outputs all shifts of the encrypted string that contain the supplied

     * substring

     *

     * @param args

     *            command-line arguments: <encrypted string> <substring>

     */

     public static void main(String[] args){

          //if there are few or more arguments,
          //then print the error message
          if (args.length != 2) {
              System.out.println(ERR_USAGE);
              return;
          }

          //create an array of 26 integers
          int result[] = new int[26];

          //create an object for class Shifter
          //and pass the encrypted string (first argument)
          Shifter shif_obj = new Shifter(args[0]);

          //call the method findShift() bys passing the substring (second argument)
          result = shif_obj.findShift(args[1]);

          //if the first value of result array is -1,
          //then print the error message
          if (result[0] == -1) {
              System.out.println(ERR_NONE);
          }
          
          //check all the value of result array
          for (int i = 0; i < 26; i++){
              if (result[i] == -1) {
                   break;
              //print the output
              }
              System.out.println(result[i]);

          }
     }
}