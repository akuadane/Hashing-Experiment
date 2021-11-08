package data_generators;

import hash_tables.HashTable;

import java.util.Random;

public class RandomDataGenerator implements DataGenerator{
    private Random random;
    public RandomDataGenerator(){
        random = new Random();
    }
    @Override
    public void generateData(HashTable hashTable) {
        while(((double)(hashTable.getNumItems()-hashTable.getDuplicates())/(double)hashTable.getSize())<hashTable.getLoadFactor()){
            int entry = this.random.nextInt();
            hashTable.insert(entry);

        }
    }


}
