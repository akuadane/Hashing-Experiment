package hash_tables;

public class DoubleHashing extends HashTable {
    public DoubleHashing(int size,double loadFactor) {
        super(size,loadFactor);
    }

    @Override
   public int insert(Object key) {
        HashObject entry = new HashObject(key);
        int i=0;
        int h1 = this.positiveMod(key.hashCode(),this.size);
        int h2 = 1+this.positiveMod(key.hashCode(),this.size-2);

        int index =this.positiveMod( h1 + i*h2,this.size);

        while(i<this.size && this.hashTable[index]!=null){

            if(this.hashTable[index].getKey().equals(entry.getKey())){
                this.hashTable[index].incrementFrequency();
                this.duplicates++;
                this.numItems++;
                return -1;

            }
            entry.incrementProbe();
            i++;
            index =this.positiveMod( h1 + i*h2,this.size);
        }

        if(i==this.size)
            return -1;

        entry.incrementProbe();
        this.hashTable[index]=entry;
        this.numItems++;
        this.numProbes+=entry.probe;
        return index;
    }

    @Override
    void delete(Object key) {

    }

    @Override
    int search(Object key) {
        return 0;
    }

    @Override
    public String toString() {
        String hashtableTest="HashtableTest: ";
        String str=hashtableTest+"Using Double Hashing....\n";
        str+= String.format(hashtableTest+"Input %d elements, of which %d duplicates\n",this.numItems,this.duplicates);

        double tempLoadFactor =(double)(this.numItems-this.duplicates)/(double)this.size;
        double tempProbe =  (double) this.numProbes/((double)this.numItems-this.duplicates);
        str+=String.format(hashtableTest+"load factor = %.2f, Avg. no. of probes %f\n",tempLoadFactor,tempProbe);


        return str;
    }
}
