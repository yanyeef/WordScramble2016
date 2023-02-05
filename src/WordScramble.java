import java.util.ArrayList;

public class WordScramble
{
    /** Scrambles a given word.
     *
     *  @param word  the word to be scrambled
     *  @return  the scrambled word (possibly equal to word)
     *
     *  Precondition: word is either an empty string or contains only uppercase letters.
     *  Postcondition: the string returned was created from word as follows:
     *  - the word was scrambled, beginning at the first letter and continuing from left to right
     *  - two consecutive letters consisting of "A" followed by a letter that was not "A" were swapped
     *  - letters were swapped at most once
     */
    public static String scrambleWord(String word)
    {
        /* to be implemented in part (a) */
        String newWord = "";
        int i = 0;
        while(i < word.length()-1){
            String letter = word.substring(i, i+1);
            String nextLetter = word.substring(i+1, i+2);
            if(letter.equals("A") && !nextLetter.equals("A")) {
                newWord += nextLetter;
                i ++;
            }
            newWord += letter;
                i++;

        }
        if(newWord.length()< word.length()){
            newWord+= word.substring(word.length()-1);
        }
        return newWord;
    }

    /** Modifies wordList by replacing each word with its scrambled
     *  version, removing any words that are unchanged as a result of scrambling.
     *
     *  @param wordList the list of words
     *
     *  Precondition: wordList contains only non-null objects
     *  Postcondition:
     *  - all words unchanged by scrambling have been removed from wordList
     *  - each of the remaining words has been replaced by its scrambled version
     *  - the relative ordering of the entries in wordList is the same as it was
     *    before the method was called
     */
    public static void scrambleOrRemove(ArrayList<String> wordList)
    {
        /* to be implemented in part (b) */
        String wordOriginal ="";
        for(int i =0; i < wordList.size(); i++){
            wordOriginal = wordList.get(i);
            if(wordOriginal.equals(scrambleWord(wordOriginal))){
                wordList.remove(i);
                i--;
            } else {
                wordList.set(i, scrambleWord(wordOriginal));
            }
        }
    }
}
