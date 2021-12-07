package datastructures;

public class HashNode<K, V> {
    final K key;
    V data;
    HashNode<K,V> next;
    final int hash;

    public HashNode(K k, V v, HashNode<K,V> n, int h){
        key = k;
        data = v;
        next = n;
        hash = h;
    }
}
