package data_generators;

import hash_tables.HashTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileDataGenerator implements DataGenerator{
    final String FILE_NAME = "C:\\Users\\PC\\Desktop\\Fall21\\Data structures\\Homework\\Individual Project 3\\src\\data_generators\\word-list";
    @Override
    public void generateData(HashTable hashTable) {

        try {
            File file = new File(FILE_NAME);
            Scanner scanner = new Scanner(file);

            while(((double)(hashTable.getNumItems()-hashTable.getDuplicates())/(double)hashTable.getSize())<hashTable.getLoadFactor() && scanner.hasNextLine()){
                String entry =scanner.nextLine();
                hashTable.insert(entry);

            }
            scanner.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
