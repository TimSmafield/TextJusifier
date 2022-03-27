import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextJusifier {

    public static void main(String[] args) {

          try {
              int length = Integer.parseInt(args[1]);
              System.out.println(justify(args[0], length));
          } catch ( NumberFormatException e ){
              System.out.println("Please provide an int for length");
          }
    }

    /**
     *  the general approach is as follows:
     *  count the length of string without whitespace
     *  The difference between this length and the desired length is the deficit
     *  next the program counts how many words exist in the text
     *  This tells us how many spaces we can use to pad the string to fill the deficit
     *  Spaces =  # of words - 1
     *  The Program calculated the length of the spaces by dividing the deficit by the # of spaces.
     *   We need to account for the remainder r, so the program adds an extra length to r spaces.
     *   The program reconstructs the string with those calculated spaces.
     *
     * @param line
     * @param length
     * @return Justified Text
     */
    public static String justify( String line, int length) {

        // validate inputs
        if (line == null) {
            throw new IllegalArgumentException("Line is null or empty");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("length must be a positive int");
        }
        if (line.isBlank()) {
            return "";
        }

        // preprocessing text:  Removing leading and trailing whitespace and non-visible chars
        line = line.trim().replaceAll("\\p{C}", "");

        // calculating length of text once all spaces are removed.
        int minSize = line.replaceAll("\\s+", "").length();

        if( minSize > length) {
            throw new RuntimeException("text is too large for line");
        }

        // calculating how many additional spaces are required to fully pad text
        int deficit = length - minSize;

        //splitting text into words and added them into a list
        List words = Arrays.asList(line.split("\\s+"));

        // finding the number of spaces
        int totalNumberOfSpaces = words.size() - 1;
        if (totalNumberOfSpaces == 0) {
            return line;
        }

        // finding the length of each space
        int sizeOfSpace = deficit / totalNumberOfSpaces;

        // finding how many spaces need an extra length
        int extraSpacesNeeded = deficit % totalNumberOfSpaces;
        String baseSpace = createSpaceOfVariableLength(sizeOfSpace);

        String result = "";

        // reconstructs the text with the calculated space size.
        if (extraSpacesNeeded > 0) {
            result = String.join(baseSpace + " ", words.subList(0, extraSpacesNeeded)) + baseSpace + " ";
        }
        result += String.join(baseSpace, words.subList(extraSpacesNeeded, words.size()));

        return result;
    }

    /**
     *   Creates a string of spaces of length
     *
     * @param length
     * @return String of space
     */
    private static String createSpaceOfVariableLength (int length) {

        StringBuilder sb = new StringBuilder();
        while (sb.length() < length){
            sb.append(" ");
        }
        return sb.toString();
    }
}
