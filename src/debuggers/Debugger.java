package debuggers;

import hash_tables.HashTable;

public interface Debugger {
    void debug(int inputType, HashTable linearHashing, HashTable doubleHashing);
}
