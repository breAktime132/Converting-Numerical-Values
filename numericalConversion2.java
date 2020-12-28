/* Peter
*
* Programming Essentials
*
* 1/21/2019
*
* The purpose of this program is to convert values between two number systems: binary to decimal, and decimal to binary.
*
* Original Version: 1/6/2019
*
*/
import java.util.Scanner;                                                                                                                                 // Allows for input to be taken within this program.
public class numericalConversion2{                                                                                                                         // File name.
   public static void main (String [] args){                                                                                                              // Main method.
      Scanner input = new Scanner (System.in);                                                                                                            // Creates a scanner that receives input from the user and is only used within this method.
      int LCV = 0;                                                                                                                                        // Loop Control Variable.
      int temp = 0;                                                                                                                                       // Stores an integer return value for the method userInputDecimal.
      String temp2 = "";                                                                                                                                  // Stores a string return value for the method userInputString.
      String userInput = "";                                                                                                                              // Holds user input as a string for menu selection.
      System.out.println("Please enter your type of conversion. Decimal to binary (enter db) or binary to decimal (enter bd)?");                          // Asks for type of conversion.
      userInput = input.nextLine();                                                                                                                       // Gets string input from the user and stores it in userInput.
      while(!userInput.equals("db") && !userInput.equals("bd") && !userInput.equals("hd")){                                                                                          // While the user does not enter "db" or "bd" for menu selection (keeps looping)...
         System.out.println("Please enter: 'bd', 'db', or 'hd' using lowercase letters.");                                                                       // Asks the user to enter "db" or "bd" again.
         userInput = input.nextLine();                                                                                                                    // The variable userInput resets and stores a new input from the user.
      }
      if(userInput.equals("bd")){                                                                                                                         // If the user enters the string "bd"...
         temp2 = userInputString();                                                                                                                       // Stores the return value of userInputString.
      }else if(userInput.equals("db")){                                                                                                                   // If the user enters "db"...
         temp = userInputDecimal();                                                                                                                       // Stores the return value of userInputDecimal.
      }else if(userInput.equals("hd")){
         temp2 = userInputHexadecimal();
      }
      if(userInput.equals("db")){                                                                                                                         // If the user enters "db" (decimal to binary)...
         decimalToBinary(temp);                                                                                                                           // Calls the method, decimalToBinary, to convert the user input to binary.
      }else if(userInput.equals("bd")){                                                                                                                   // If the user enters "bd" (binary to decimal)...
         binaryToDecimal2(temp2);                                                                                                                         // Calls the method, binaryToDecimal, to convert the user input to decimal.
      }else if(userInput.equals("hd")){
         hexadecimalToDecimal(temp2);
      }
   }
   public static void binaryToDecimal2(String userNumber){                                                                                                // Converts binary code to decimal.
      int LCV = 0;                                                                                                                                        // Loop Control Variable.
      int bitValue = 1;                                                                                                                                   // Stores the bit value of each digit in a binary number, which is multiplied by 2 every time the bit selected in the array moves left.
      int bitMaximum = 16384;                                                                                                                             // The variable bitMaximum is set equal to the maximum number all bits, when turned on, must be less than or equal to.
      int decimal = 0;                                                                                                                                    // Holds the sum of all values of the bits that have been turned on.
      int signNumber = 0;                                                                                                                                 // Determines whether the decimal number is negative or positive (first element of the array).
      if(userNumber.charAt(0) == '0'){                                                                                                                    // If the bit entered is 0 (number is positive)...
         signNumber = 1;                                                                                                                                  // The first element in the array is eqaul to 1.
      }else{
         signNumber = -1;                                                                                                                                 // The first element in the array is equal to 0.
      }
      for(LCV = 1; LCV < 16; LCV++){                                                                                                                      // Runs 15 times for string characters 2=16
         if(userNumber.charAt(LCV) == ('1')){                                                                                                             // If userNumber is less than the bitMaximum...
            decimal = decimal + bitMaximum;                                                                                                               // Adds the current bitValue to the variable decimal.
         }
            bitMaximum = bitMaximum / 2;                                                                                                                  // The variable bitMaximum is divided by 2.
      }
      decimal = decimal * signNumber;                                                                                                                     // The total decimal value of the binary input is multiplied by the sign number, which will either keep it positive or make it negative.
      System.out.print(decimal);                                                                                                                          // Prints out the converted number.
   }
   // traverse the array and when it finds it, index + 1.
   public static void hexadecimalToDecimal(String userNumber){
      char hexadecimalArray[] = new char[]{'1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
      int LCV = 0;                                                                                                                                        // Loop Control Variable.
      int LCV2 = 0;
      int bitValue = 1;                                                                                                                                   // Stores the bit value of each digit in a binary number, which is multiplied by 2 every time the bit selected in the array moves left.
      int bitMaximum = 1;                                                                                                                                 // The variable bitMaximum is set equal to the maximum number all bits, when turned on, must be less than or equal to.
      int decimal = 0;                                                                                                                                    // Holds the sum of all values of the bits that have been turned on.
      int temp = 0;
      
      for(LCV2 = userNumber.length(); LCV > 0; LCV--){
      for(LCV = hexadecimalArray.length; LCV > 0; LCV--){                                                                                                     // Runs 15 times for string characters 2=16
            bitMaximum = 1;
            temp = LCV + 1;
            bitMaximum = bitMaximum * 16;
            bitMaximum = bitMaximum * 16;
            decimal = bitMaximum * LCV;
      }
      }
      System.out.print(decimal);                                                                                                                          // Prints out the converted number.
   }
   public static void decimalToBinary(int userNumber){                                                                                                    // Converts a decimal number to binary.
      int[] myArray = new int[16];                                                                                                                        // Creates an array of 16 elements that have no value.
      int LCV = 0;                                                                                                                                        // Loop Control Variable.
      int bitValue = 1;                                                                                                                                   // Stores the bit value of each digit in a binary number, which is multiplied by 2 every time the bit selected in the array moves left.
      int bitMaximum = 16384;                                                                                                                             // The variable bitMaximum is set equal to the maximum number all bits, when turned on, must be less than or equal to.
      if(userNumber < 0){                                                                                                                                 // If the number entered is negative...
         myArray[LCV] = 1;                                                                                                                                // The first element in the array is eqaul to 1.
         userNumber = userNumber * -1;                                                                                                                    // The comparisons inside the for loop below only operate correctly if userNumber is positive. Regardless of whether the number is actually negative, it is converted to positive after the first element of the array contains the binary digit of 1.
      }else{
         myArray[LCV] = 0;                                                                                                                                // The first element in the array is equal to 0.
      }
      for(LCV = 1; LCV < 16; LCV++){                                                                                                                      // The loop runs for the length of the array, and selects each index.
         if(userNumber < bitMaximum){                                                                                                                     // If userNumber is less than the bitMaximum...
            myArray[LCV] = 0;                                                                                                                             // A zero is placed in index LCV.
         }else{
            myArray[LCV] = 1;                                                                                                                             // A one is placed in index LCV.
            userNumber = userNumber - bitMaximum;                                                                                                         // The variable userNumber is decreased by bitMaximum, so when the loop runs again, the comparison above will check to see if userNumber is then less than bitMaximum.
         }
         bitMaximum = bitMaximum / 2;                                                                                                                     // The variable bitMaximum is divided by 2.
      }
      for(LCV = 0; LCV < myArray.length; LCV++){                                                                                                          // Runs as many times as the length of the array (16), and LCV is used to represent each index inside the array.
         System.out.print(myArray[LCV]);                                                                                                                  // Prints out each index of the array that has been filled, which will be the binary equivalent of the decimal number originally entered.
      }
   }
   public static int userInputDecimal(){                                                                                                                  // Takes user input for decimal to binary.
      Scanner input = new Scanner(System.in);                                                                                                             // Creates a scanner to allow for user input within this method.
      int userNumberDecimal = 32768;                                                                                                                      // Creates the variable userNumberDecimal and initializes it to 32768, so that the while loop that checks for correct decimal inputs can run at least once.
      while(-32767 > userNumberDecimal || userNumberDecimal > 32767){                                                                                     // While the userNumber is either smaller than -32767 or greater than 32767...                                                                                                                // While the variable userNumberDecimal is greater than 32767 (userNumberDecimal is initialized to 32768)...
         System.out.println("Please enter the decimal number you wish to convert to binary, with a value between -32767 - 32767.");                       // Tells the user to enter the decimal number they want to convert, and tells them that the maximum value they can enter is 32767.
         userNumberDecimal = input.nextInt();                                                                                                             // The variable userNumber takes in the long number from the user.
      }
      return userNumberDecimal;                                                                                                                           // Returns input value.
   }
   public static String userInputString(){                                                                                                                // Takes user input for binary to decimal.
      Scanner input = new Scanner(System.in);                                                                                                             // Creates a scanner to allow for user input within this method.
      String userNumber = "";                                                                                                                             // Stores the user input as a long number. It is 16 digits long, plus two numbers other than zero in the front, so that the computer does not read 16 zeroes as just zero.
      while(userNumber.length() < 17){                                                                                                                   // While the string input for binary to decimal is not 16 bits long...
         System.out.println("Please enter 16 characters.");                                                                                               // Tells the user to enter 16 characters.
         userNumber = input.nextLine();                                                                                                                   // Gets input from the user and stores it in userNumber.
         if(userNumber.length() < 17){
            break;
         }
      }
      return userNumber;                                                                                                                                  // Returns input value.
   }
   public static String userInputHexadecimal(){
      Scanner input = new Scanner(System.in);
      String userNumber = "00000";
      while(userNumber.length() > 4){
         System.out.println("Please enter up to 4 characters.");
         userNumber = input.nextLine();
      }
      return userNumber;
   }
}
// Math.pow only takes in a double.
