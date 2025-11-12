//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...


import java.util.Scanner;
import java.io.IOException;
import java.net.URL;

public class Book
{

  public String book;

  public Book(String url){
    readBook(url);
  }

  private void readBook(String link){
    try {
      URL url = new URL(link);
      Scanner s = new Scanner(url.openStream());

      while(s.hasNext()){
        String text = s.nextLine();
        System.out.println(text);
        book += text;
      }
      s.close();
    }
    catch(IOException ex){
      ex.printStackTrace();
    }

  }

  public String getText(){
    return book;
  }

  public String pigLatin(String word)
  {
      String vowel = "aeiouy";
      String numbers = "1234567890";
      if(word.length()==0){
         return word;
      }
      else if (vowel.indexOf(word.substring(0,1))>=0){
         return word + "yay";
      }
      else if(numbers.indexOf(word.substring(0,1))>=0){
         return word;
      }
      else if (word.length()==1){
         return word+"ay";
      }

      for (int i = 0; i < word.length(); i++){
         if (vowel.indexOf(word.substring(i, i+1))>=0){
            String left = word.substring ( 0,i);
            String right = word.substring (i, word.length());
            return right+left+"ay";
            
         }
      }
      return word;
  }


  
  public int endPunctuation(String word)  //return the index of where the punctuation is at the end of a String. If it is all punctuation return 0, if there is no punctuation return -1
  {

    return -1;
  }

  public String translateWord(String word)    //to share with class
  {
    String convertedWord = "";
    String punctuationString = ".?!,;:";
    String vowels = " aeiouyAEIOUY";
    String bracket = "[";

    boolean punctuation = false;
    int i = 0;
    while (punctuation == false){
      if (i >= word.length()){
        convertedWord = word;
        break;
      }

      if (punctuationString.indexOf(word.substring(i, i+1))>=0){
        convertedWord = word.substring(0, i);
        punctuation = true;
      }
      i++;

    }

    System.out.println(convertedWord);

    if(convertedWord.length()==0){
         return convertedWord;
      }

    if (bracket.equals(convertedWord.substring(0, 1))){
      return convertedWord;
    }
    
    char letter = word.charAt(0);
    String left = "";

    if (vowels.indexOf(convertedWord.substring(0,1)) <= 0 && vowels.indexOf(convertedWord.substring(1,2))<= 0){

         if (vowels.indexOf(convertedWord.substring(2, 3))>=0){
            left = convertedWord.substring ( 0,2);
            
            left = String.valueOf(Character.toLowerCase(left.charAt(0))) + left.substring(1);
            
            String right = convertedWord.substring (2, convertedWord.length());
            
            convertedWord = right+left;

         }
         else if (vowels.indexOf(convertedWord.substring(2, 3))<0){
            left = convertedWord.substring ( 0,3); // school returns oolschhay with double h
            
            left = String.valueOf(Character.toLowerCase(left.charAt(0))) + left.substring(1);
            
            String right = convertedWord.substring (2, convertedWord.length());
            
            convertedWord = right+left;
         }
      

    }
    
    
    if (Character.isUpperCase(letter) && convertedWord.length() > 1 && Character.isLowerCase(convertedWord.charAt(1))){
      String firstLetter = String.valueOf(Character.toLowerCase(convertedWord.charAt(0)));
      String secondLetter = String.valueOf(Character.toUpperCase(convertedWord.charAt(1)));
      if (vowels.indexOf(word.substring(0,1))>=0){
        convertedWord = secondLetter + convertedWord.substring(2) + firstLetter + "yay";
      }
      else {
          convertedWord = secondLetter + convertedWord.substring(2) + firstLetter + "ay";       
      }

    }
    else if (vowels.indexOf(convertedWord.substring(0, 1)) >= 0 && left.length() == 0){
      convertedWord = convertedWord + "yay";
    }
    else if (convertedWord.length() == 1){
      convertedWord = convertedWord + "ay";
    }
    else if (Character.isUpperCase(word.charAt(1))){
      convertedWord = convertedWord.substring(1) + letter + "AY";
    }
    else if (left.length() == 2){
      convertedWord = convertedWord + "ay";
    }
    else {
      convertedWord = convertedWord.substring(1) + letter + "ay";
    }

    if (punctuationString.indexOf(word.substring(word.length()-1))>=0){
      return convertedWord + word.substring(i-1, word.length());
    }
    else{
      return convertedWord;
    }
  }

  public String translateSentence(String sentence)
  {
    String retSentence = "";
    String word = "";
    int count = 0;

    int space = sentence.indexOf(" ");

    while (space >=0){
        word = sentence.substring(0, space);
        word = translateWord(word);
        retSentence = retSentence + word + " ";
        sentence = sentence.substring(space + 1);
        space = sentence.indexOf(" ");
    }
    if (sentence.length() > 0){
      word = translateWord(sentence);
      retSentence = retSentence + word + " ";
    }
    

    return retSentence;
  }

  public String translateBook(String book){
    String translatedBook = "";

    translatedBook += translateSentence(book);

    return translatedBook;
  }

}
