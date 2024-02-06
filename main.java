package Mini;
import java.util.*;
import java.util.List;
public class CaesarCipherApp {
 private static final List<Character> ALPHABET = Arrays.asList('a', 'b', 'c', 'd',
'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
 public static String splitAndReverseString(String string) {
 Stack<Character> stack = new Stack<>();
 String sam="";
 char ch[]=string.toCharArray();
 for(int i=0;i<ch.length;i++){
 if(i%2==0){
 sam+=ch[i];
 }
 else{
 stack.push(ch[i]);
 }
 }
 while(!(stack.isEmpty())){
 sam+=stack.pop();
 }
 return sam;
 }
 public static String splitAndReverseString1(String string) {
 StringBuilder oddElements = new StringBuilder();
 StringBuilder evenElements = new StringBuilder();
 for (int i = 0; i < string.length(); i++) {
 if (i % 2 == 0) {
 evenElements.append(string.charAt(i));
 } else {
 oddElements.append(string.charAt(i));
 }
 }
 String reversedOddElements = new
StringBuilder(oddElements.toString()).reverse().toString();
 return evenElements.toString() + reversedOddElements;
10
 }
 public static String encrypt(String text, int key) {
 String encryptedText = "";
 for (char character : text.toCharArray()) {
 int index = ALPHABET.indexOf(character);
 int newIndex = (index + key) % 26;
 char newCharacter = ALPHABET.get(newIndex);
 encryptedText += newCharacter;
 }
 CaesarCipherApp ob=new CaesarCipherApp();
 encryptedText=ob.splitAndReverseString(encryptedText);
 return encryptedText;
 }
 public static String decrypt(String text, int key) {
 String decryptedText = "";
 for (char character : text.toCharArray()) {
 int index = ALPHABET.indexOf(character);
 int newIndex = (index - key) % 26;
 if (newIndex < 0) {
 newIndex += 26;
 }
 char newCharacter = ALPHABET.get(newIndex);
 decryptedText += newCharacter;
 }
 CaesarCipherApp ob1=new CaesarCipherApp();
 decryptedText=ob1.splitAndReverseString(decryptedText);
 decryptedText=ob1.splitAndReverseString(decryptedText);
 return text;
 }
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 System.out.println("Enter the text to encrypt/decrypt: ");
 String text = scanner.nextLine();
 System.out.println("Enter the key: ");
 int key = scanner.nextInt();
 System.out.println("Encrypted text: " + encrypt(text, key));
// text=encrypt(text, key);
 System.out.println("Decrypted text: " + decrypt(text, key));
11
 scanner.close();
 }
}
