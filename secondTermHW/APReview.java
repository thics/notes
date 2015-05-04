import java.util.*;
import java.io.*;

public class APReview {
  /** Scrambles a given word.
   * @param word the word to be scrambled
   * @return the scrambled word (possibly equal to word)
   * Precondition: word is either an empty string or contains only uppercase letters.
   * Postcondition: the string returned was created from word as follows:
   * - the word was scrambled, beginning at the first letter and continuing from left to right
   * - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
   * - letters were swapped at most once
   */
  public static String scrambleWord(String word) {
    String s = word;
    int i = 0;
    while( i < s.length()) {
      if(s.substring(i, i + 1) == "A") {
        if(i == 0)
          s = s.substring(i + 1, i + 2) + s.substring(i, i + 1) + s.substring(i + 2);
        else
          s = s.substring(0, i) + s.substring(i + 1, i+2) + s.substring(i, i+1) + s.substring(i+2);
        i++;
      }
      i++;
    }
    return s;
  }

  /** Modifies wordList by replacing each word with its scrambled
   * version, removing any words that are unchanged as a result of scrambling.
   * @param wordList the list of words
   * Precondition: wordList contains only non-null objects
   * Postcondition:
   * - all words unchanged by scrambling have been removed from wordList
   * - each of the remaining words has been replaced by its scrambled version
   * - the relative ordering of the entries in wordList is the same as it was
   * before the method was called
   */
  public static void scrambleOrRemove(List<String> wordList) {
    List<String> l = wordList;
    for(int i = 0; i < wordList.size(); i++)
      wordList.set(i, scrambleWord(wordList.get(i)));
    for(int j = 0; j < wordList.size(); j++) {
      if(wordList.get(j).equals(l.get(j))) {
        wordList.remove(j);
        l.remove(j);
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("TNA:" + scrambleWord("TAN"));
    System.out.println("BARCADABARA:" + scrambleWord("ABRACADABRA"));
    System.out.println("WHOA:" + scrambleWord("WHOA"));
  }
}
