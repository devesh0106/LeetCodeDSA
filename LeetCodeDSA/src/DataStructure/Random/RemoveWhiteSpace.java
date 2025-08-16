package DataStructure.Random;
/*
"\\s" is a regular expression (regex) pattern.

It matches any whitespace character, including:

Space (' ')

Tab ('\t')

Newline ('\n')

Carriage return ('\r')

Form feed ('\f')
* */
public class RemoveWhiteSpace {
    public String removeSpaceFromString(String str){
        return str.replaceAll("\\s", "");
    }

    public static void main(String[] args) {
        RemoveWhiteSpace removeWhiteSpace = new RemoveWhiteSpace();
        String res= removeWhiteSpace.removeSpaceFromString("Was it a car or a cat I saw?");
        System.out.println(res);
    }
}
