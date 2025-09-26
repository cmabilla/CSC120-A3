import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class Conversation implements ConversationRequirements {

  // Attributes 
  int number_rounds;
  String user_response;
  String [] responses;
  String [] default_responses;
  String [] possible_pronouns;
  int i;
  int amount;
  int array_length;
  String newVariable;
  ArrayList<String> transcript = new ArrayList <>();

  /**
   * Constructor 
   */
  public Conversation() {
    String [] responses = {};
    String [] default_responses = {"Mhm","Okay!", "Sounds good", "Oh wow", "Great!"};
    String [] possible_pronouns = {"i", "me", "am", "you", "my", "your"};
    this.responses = responses;
    this.default_responses = default_responses;
    this.possible_pronouns = possible_pronouns;
    transcript = new ArrayList <String>();//honestly, I only did this because I couldnt...
    //..find a way to add strings to the other list type I used above. This didn't work though.
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner input = new Scanner (System.in);//Not sure why its yellow
    System.out.println ("How many rounds?");
    transcript.add("How many rounds?");
    int amount = input.nextInt();
    input.nextLine();
    transcript.add(amount+"");
    System.out.println ("Hi! What's on your mind?");
    transcript.add("Hi! What's on your mind?");
    //input.close();
    for (int i = 0; i <= amount ; i++){//It never does the exact amount of rows
      String user_response = input.nextLine();
      transcript.add(user_response);
      user_response = user_response.toLowerCase();//.equalsIgnoreCase works too
      String [] responses = user_response.split(" ");//what happens if its not split by spaces?
      //System.out.println(Arrays.toString(responses));
      int array_length = responses.length;
      //System.out.println(array_length);
      for (int j = 0; j < array_length; j++){
        for (String key : possible_pronouns){
          if (responses[j].equals(key)){
            responses[j] = respond(responses[j]);
            //System.out.println(Arrays.toString(responses));
            break;//This prevents a repetition or replacing already swapped words
          }
        }
      }
      String new_responses = String.join(" ",responses);
      if (new_responses.equalsIgnoreCase(user_response)){
        Random random = new Random();
        
        String newVariable = (default_responses[random.nextInt(default_responses.length)]);
        transcript.add(newVariable);//Doesn't work

      }else{
        System.out.println(new_responses);
        transcript.add(new_responses);//this should ideally work but it doesn't
      }
    }
}
  //THIS WAS AN INITIAL ATTEMPT AT READING MY USER RESPONSE FOR MIRROR WORD
  //     for (String word:responses){
  //       for (String key : possible_pronouns){
  //         if (word.equalsIgnoreCase(key)){
  //           respond(word);
  //         } else {

  //         }
  //       }
  //     }
  //   }
  // }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    for (String i : transcript){
      System.out.println(i);//This entire method is not working 
      //I did an ArrayList instead of whatever I was doing before 
    }
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {

    if (inputString.equals("i")|inputString.equals("me")){
      return "you"; 
    } else if (inputString.equals("you")){
      return "I";
    } else if (inputString.equals("am")){
      return "are";
    } else if (inputString.equals("my")){
      return "your";
    } else if (inputString.equals("your")){
      return "my";
    }
    String returnString = ""; 
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
    //my printTranscript does not work and I am not sure why

  }
}
