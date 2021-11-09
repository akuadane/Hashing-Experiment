package data_generators;

import hash_tables.HashTable;

public class SystemTimeDataGenerator implements DataGenerator{

    /**
     * @param hashTable
     */
    @Override
    public void generateData(HashTable hashTable) {
        while(((double)(hashTable.getNumItems()-hashTable.getDuplicates())/(double)hashTable.getSize())<hashTable.getLoadFactor()){
            long entry = System.currentTimeMillis();
            hashTable.insert(entry);

            try {
                Thread.sleep(0,1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
