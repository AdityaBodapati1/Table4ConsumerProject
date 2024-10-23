import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;


public class BestRestaurant {
    private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
    private static ArrayList<String> posAdjectives = new ArrayList<String>();
    private static ArrayList<String> negAdjectives = new ArrayList<String>();
    
    static{
        try {
          Scanner input = new Scanner(new File("cleanSentiment.csv"));
          while(input.hasNextLine()){
            String[] temp = input.nextLine().split(",");
            sentiment.put(temp[0],Double.parseDouble(temp[1]));
            // System.out.println("added "+ temp[0]+", "+temp[1]);
          }
          input.close();
        }
        catch(Exception e){
          System.out.println("Error reading or parsing cleanSentiment.csv");
        }

    //read in the positive adjectives in postiveAdjectives.txt
    try {
        Scanner input = new Scanner(new File("positiveAdjectives.txt"));
        while(input.hasNextLine()){
          posAdjectives.add(input.nextLine().trim());
        }
        input.close();
      }
      catch(Exception e){
        System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
      }   
   
    //read in the negative adjectives in negativeAdjectives.txt
       try {
        Scanner input = new Scanner(new File("negativeAdjectives.txt"));
        while(input.hasNextLine()){
          negAdjectives.add(input.nextLine().trim());
        }
        input.close();
      }
      catch(Exception e){
        System.out.println("Error reading or parsing negativeAdjectives.txt");
      }   
    }
    public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
  
    public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    // remove any additional space that may have been added at the end of the string
    return temp.trim();
  }

    // Calculate sentiment value of words in text file
    public static double sentimentTotal (String fileName) {
        String review = textToString(fileName);
        double totalSentiment = 0.0;
        
        for (String word: review.split(" ")) {
            word = removePunctuation(word).toLowerCase();
            if(sentiment.containsKey(word)){
                totalSentiment += sentiment.get(word);
        }
        }  

        // same code using while loop instead of for loop 

        /* 
        int index = 0;
        String[] reviewWords = review.split(" ");
        while(index < reviewWords.length){
          String word = removePunctuation(reviewWords[index]).toLowerCase();
          if(sentiment.containsKey(word)){
            totalSentiment += sentiment.get(word);
          } 
          index++;
        }
        
        */
        return totalSentiment;
    }
}

/*
 
 */