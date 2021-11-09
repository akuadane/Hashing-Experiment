package data_generators;

import hash_tables.HashTable;

public interface DataGenerator {
    /**
     * @param hashTable
     */
    public void generateData(HashTable hashTable);
}
