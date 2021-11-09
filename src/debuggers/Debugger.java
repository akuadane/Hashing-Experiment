package debuggers;

import hash_tables.HashTable;

public interface Debugger {

    /**
     * @param inputType
     * @param linearHashing
     * @param doubleHashing
     */
    void debug(int inputType, HashTable linearHashing, HashTable doubleHashing);
}
