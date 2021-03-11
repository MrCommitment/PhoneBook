package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String FILENAME= "phoneBook.txt";

    public static boolean saveRecord(PhoneBookRecord phoneBookRecord) {
        try (
                FileWriter fileWriter = new FileWriter(FILENAME, true);
                BufferedWriter writer = new BufferedWriter(fileWriter);
        ){
            writer.write(phoneBookRecord.getFirstName());
            writer.write(" ");
            writer.write(phoneBookRecord.getSecondName());
            writer.write(" ");
            writer.write(phoneBookRecord.getPhoneNumber());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<PhoneBookRecord> getAllRecordsFromFile(){
        List<PhoneBookRecord> records =new ArrayList<>();
        try (
                FileReader fileReader = new FileReader(FILENAME);
                final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ){
            String nextLine = null;
            while((nextLine=bufferedReader.readLine())!=null){
                String[] parts = nextLine.split(" ");
                PhoneBookRecord phoneBookRecord = new PhoneBookRecord(parts[0], parts[1], parts[2]);
                records.add(phoneBookRecord);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
