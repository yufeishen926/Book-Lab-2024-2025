//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...

public class Book
{
  public String pigLatin(String word)
  {
    String newWord = "";
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
    String punctuationString = ".?!,;";
    String vowels = " aeiouyAEIOUY";

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

    char letter = word.charAt(0);

    if (vowels.indexOf(convertedWord.substring(1,2))<= 0 && vowels.indexOf(convertedWord.substring(0,1)) <= 0){
      System.out.println("helo");
      for (int x = 0; x < convertedWord.length(); x++){
         if (vowels.indexOf(convertedWord.substring(x, x+1))>=0){
            String left = convertedWord.substring ( 0,x);
            left = String.valueOf(Character.toLowerCase(left.charAt(0))) + left.substring(1);
            String right = convertedWord.substring (x, convertedWord.length());
            convertedWord = right+left;
         }
      }
      System.out.println(convertedWord);

    }
    
    
    if (Character.isUpperCase(letter) && Character.isLowerCase(convertedWord.charAt(1))){
      String firstLetter = String.valueOf(Character.toUpperCase(convertedWord.charAt(0)));
      if (vowels.indexOf(word.substring(0,1))>=0){
        convertedWord = firstLetter + convertedWord.substring(1) + "yay";
      }
      else {
          convertedWord = firstLetter + convertedWord.substring(1) + "ay";       
      }

    }
    else if (Character.isUpperCase(word.charAt(1))){
      convertedWord = convertedWord.substring(1) + letter + "AY";
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
    String space = " ";
    String word = "";
    int count = 0;

    for (int i = 0; i < sentence.length()-1; i++){
      if (space.indexOf(sentence.substring(i, i+1)) >=0){
        word = sentence.substring(count, i);
        count = i+1;

        word = translateWord(word); 
        retSentence = retSentence +  word + " "; // "is" returns as "siay" instead of "isay", missing last word
      }
    }

    return retSentence;
  }
}
