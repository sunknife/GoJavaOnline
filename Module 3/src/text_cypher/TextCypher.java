package text_cypher;


import files.File;
import files.ImageFile;

import java.util.ArrayList;

public class TextCypher {
    public String caesarCypher(String text, int key){
        if (key<0) {
            key=26+key%26;
        } else if (key==0) {
            return text;
        }
        StringBuilder cipheredText= new StringBuilder(text);
        for (int i=0; i<cipheredText.length();i++) {
            char encryptedChar = cipheredText.charAt(i);
            if (encryptedChar<='z' && encryptedChar>='a') {
                encryptedChar = (char) ((cipheredText.charAt(i) + key-'a') % 26+'a');
            } else if (encryptedChar<='Z' && encryptedChar>='A'){
                encryptedChar = (char) ((cipheredText.charAt(i) + key-'A') % 26+'A');
            }
            cipheredText.replace(i,i+1,String.valueOf(encryptedChar));
        }
        return cipheredText.toString();
    }

    public String caesarDecipher(String text, int key){
        return caesarCypher(text,26-key%26);
    }

    public static void main(String[] args){
        TextCypher cipher = new TextCypher();
        ArrayList<File> files = new ArrayList<>();
        files.add(new ImageFile("Ap"));
        files.add(new File("Broiler"));
        files.add(new File("Oi"));
        files.add(new File("Apple"));
        String textBeforeEncryption = files.toString();
        String encryptedText=cipher.caesarCypher(textBeforeEncryption,3);
        System.out.println(encryptedText);
        String deencryptedText=cipher.caesarDecipher(encryptedText,3);
        System.out.println(deencryptedText);


        if (textBeforeEncryption.equals(deencryptedText)){
            System.out.println("Win!");
        }
    }
}
