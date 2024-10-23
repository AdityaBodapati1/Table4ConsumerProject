class sentimentOutput {
    public static void main(String[] args) 
    {
      /* calculate sentiment values of different restaurants */
      double tacoBell = BestRestaurant.sentimentTotal("tacobell.txt");
      double mcd = BestRestaurant.sentimentTotal("mcdonalds.txt");
      double innout = BestRestaurant.sentimentTotal("innout.txt");

      // print out final output
      System.out.println("Review 1: The total sentiment analysis for Taco Bell is " + tacoBell);
      System.out.println("Review 2: The total sentiment analysis for McDonalds is " + mcd);
      System.out.println("Review 3: The total sentiment analysis for In n Out is " + innout);
      System.out.println("");
      System.out.println("");

      
      // compare sentiment values to determine highest rated values
      if (tacoBell > mcd && tacoBell > innout) {
        System.out.println("Therefore, Taco Bell is the highest rated restaurant.");
      }

      else if(mcd > tacoBell && mcd > innout){
        System.out.println("Therefore, McDonalds is the highest rated restaurant.");
      }

      else if(innout > mcd && innout > tacoBell){
        System.out.println("Therefore, In n Out is the highest rated restaurant.");
      }
      

      //another way to write the segment above using nested conditionals 
      /*
      if (tacoBell > mcd) {
        if(tacoBell > innout){
          System.out.println("Therefore, Taco Bell is the highest rated restaurant.");
        }  
      }
      
      else if (mcd > tacoBell) {
        if(mcd > innout){
          System.out.println("Therefore, McDonalds is the highest rated restaurant.");
        }  
      }
      
      else if (innout > mcd) {
        if(innout > tacoBell){
          System.out.println("Therefore, Taco Bell is the highest rated restaurant.");
        }  
      }

       */

       
    }
  }