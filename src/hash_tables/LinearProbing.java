package hash_tables;

public class LinearProbing extends HashTable {

   public LinearProbing(int size,double loadFactor) {
        super(size,loadFactor);
    }

    /**
     * @param key
     * @return index of the place the element was inserted at
     */
    @Override
    public int insert(Object key) {

        HashObject entry= new HashObject(key);
        int h= this.positiveMod(key.hashCode(),this.size);
        int i=0;
        int index = (h+i)%this.size;

        while(i<this.size && this.hashTable[index]!=null){

            if(this.hashTable[index].getKey().equals(entry.getKey())){
                this.hashTable[index].incrementFrequency();
                this.duplicates++;
                this.numItems++;
                return -1;

            }
            entry.incrementProbe();
            i++;
            index = (h+i)%this.size;
        }

        if(i==this.size)
            return -1;

        entry.incrementProbe();
        this.hashTable[index]=entry;
        this.numItems++;
        this.numProbes+=entry.probe;

        return index;


    }


    /**
     * @return  the summary of the hashtable
     */
    @Override
    public String toString() {
        String hashtableTest="HashtableTest: ";
        String str=hashtableTest+"Using Linear Hashing....\n";
        str+= String.format(hashtableTest+"Input %d elements, of which %d duplicates\n",this.numItems,this.duplicates);

        double tempLoadFactor =(double)(this.numItems-this.duplicates)/(double)this.size;
        double tempProbe =  (double) this.numProbes/((double)this.numItems-this.duplicates);
        str+=String.format(hashtableTest+"load factor = %.2f, Avg. no. of probes %f\n",tempLoadFactor,tempProbe);

        return str;
    }
}
