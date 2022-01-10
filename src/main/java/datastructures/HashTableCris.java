package datastructures;

public class HashTableCris<K, V> {
    private HashNode<K,V>[] nodes;
    public int size = 0;

    @SuppressWarnings("unchecked")
    public HashTableCris(int size){
        nodes = new HashNode[size];
    }

    private int getIndex(K key){
        int hash = key.hashCode() % nodes.length;
        if(hash < 0){
            hash += nodes.length;
        }
        return hash;
    }

    public V insert(K key, V data){
        int hash = getIndex(key);

        for(HashNode<K,V> node = nodes[hash]; node != null; node = node.next){
            if((hash == node.hash) && key.equals(node.key)){
                V oldData = node.data;
                node.data = data;
                return oldData;
            }
        }

        HashNode<K,V> node = new HashNode<K,V>(key, data, nodes[hash], hash);
        nodes[hash] = node;
        size++;
        return null;
    }

    public boolean remove(K key){
        int hash = getIndex(key);
        HashNode<K,V> previous = null;

        for (HashNode<K,V> node = nodes[hash]; node != null; node = node.next) {
            if ((hash == node.hash) && key.equals(node.key)) {
                if (previous != null){
                    previous.next = node.next;
                } else {
                    nodes[hash] = node.next;
                }
                return true;
            }
            previous = node;
        }
        size--;
        return false;
    }

    public V get(K key){
        int hash = getIndex(key);

        for(HashNode<K,V> node = nodes[hash]; node != null; node = node.next){
            if(key.equals(node.key))
                return node.data;
        }
        return null;
    }

    public void resize(int size) {
        HashTableCris<K, V> newtbl = new HashTableCris<K, V>(size);
        for(HashNode<K,V> node : nodes){
            for(; node != null; node = node.next){
                newtbl.insert(node.key, node.data);
                remove(node.key);
            }
        }
        nodes = newtbl.nodes;
    }
}
