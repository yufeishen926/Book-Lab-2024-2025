//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...

public class Book
{
  public String pigLatin(String word)
  {
    if (word.substring(0, 1).equals("a") || word.substring(0, 1).equals("e") || word.substring(0, 1).equals("i") || word.substring(0, 1).equals("o") || word.substring(0, 1).equals("u")){
      return word + "yay";
    }
    else{
      return word.substring(1) + word.substring(0, 1) + "ay";
    }
  }
  
  public int endPunctuation(String word)  //return the index of where the punctuation is at the end of a String. If it is all punctuation return 0, if there is no punctuation return -1
  {

    return -1;
  }

  public String translateWord(String word)    //to share with class
  {
    String convertedWord = "";

    boolean punctuation = false;
    int i = 0;
    while (punctuation == false){
      if (word.charAt(i) == '!' || word.charAt(i) == '.' || word.charAt(i) == '?' || word.charAt(i) == ';' || word.charAt(i) == ','){
        convertedWord = word.substring(0, i);
        punctuation = true;
      }
      i++;
    }

    char letter = word.charAt(0);
    char letter2 = word.charAt(1);

    if (Character.isUpperCase(letter) && Character.isLowerCase(word.charAt(1))){
      String firstLetter = String.valueOf(Character.toUpperCase(letter2));
      String lastLetter = String.valueOf(Character.toLowerCase(letter));
      convertedWord = firstLetter + convertedWord.substring(2) + lastLetter + "ay";
    }
    else if (Character.isUpperCase(word.charAt(1))) // use AY
    else {
      convertedWord = convertedWord.substring(1) + letter + "ay";
    }

    return convertedWord + word.substring(i-1, word.length());
  }

  public String translateSentence(String sentence)
  {
    String retSentence = "";


    return retSentence;
  }
}  
