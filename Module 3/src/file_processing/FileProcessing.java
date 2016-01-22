package file_processing;


import text_cypher.TextCypher;

import java.io.*;

public class FileProcessing {
    private int key;

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void saveText(String text, String fileName) {

        if (text == null || text.length() == 0) {
            System.out.println("There is no text!");
            return;
        }

        TextCypher encryptor = new TextCypher();
        text = encryptor.caesarCypher(text, this.getKey());

        BufferedWriter saver = null;
        try {
            saver = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));

            saver.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("There is no such file '" + fileName + "'");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Writing to file failed");
        } finally {
            try {
                if (saver != null) {
                    saver.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Cannot close file correctly");
            }
        }
    }

    public String uploadText(String fileName) {

        BufferedReader uploader;
        try {

            uploader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        } catch (FileNotFoundException e) {
            System.out.println("There is no such file '" + fileName + "'");
            return "File not found";
        }
        StringBuilder resultString = new StringBuilder();
        String nextString;
        try {
            nextString = uploader.readLine();
            while (nextString != null) {
                resultString.append(nextString);
                nextString = uploader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error during reading file");
        }
        try {
            uploader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error during closing file");
        }
        TextCypher encryptor = new TextCypher();

        return encryptor.caesarDecipher(resultString.toString(), this.getKey());
    }

    public static void main(String[] args) {
        FileProcessing textHandler = new FileProcessing();
        textHandler.setKey(4);
        String quote = "Do not let your fire go out, spark by irreplaceable spark in the hopeless swamps of the not-quite, the not-yet, and the not-at-all.\n Do not let the hero in your soul perish in lonely frustration for the life you deserved and have never been able to reach.\n The world you desire can be won. It exists.. it is real.. it is possible.. it's yours.\n \t\t\t\t\t\t\t Atlas Shrugged | Ayn Rand";
        textHandler.saveText(quote, "cool.txt");
        System.out.println(textHandler.uploadText("cool.txt"));
    }
}
