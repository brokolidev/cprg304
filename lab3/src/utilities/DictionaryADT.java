package utilities;

import exceptions.DuplicateKeyException;

/**
* DictionaryADT.java
*
* @author H
* @version major.minor revision number starting at 1.0
* 
* Class Definition: This interface represents the public contract for the
* implementation of Dictionary for the DictionaryADT Lab. 
*/

public interface DictionaryADT<K,V>
{
	/**
     * Inserts a new (key, value) pair into the dictionary.
     *
     * Pre-condition: The key must not already exist in the dictionary.
     * Post-condition: The key and value will be added to the dictionary.
     *
     * @param key the key to insert
     * @param value the value to associate with the key
     * @throws IllegalArgumentException if the key already exists in the dictionary
     */
    void insert(K key, V value) throws DuplicateKeyException;

    /**
     * Removes a (key, value) pair from the dictionary.
     *
     * Pre-condition: The key must exist in the dictionary.
     * Post-condition: The key and value will be removed from the dictionary.
     *
     * @param key the key to remove
     * @throws IllegalArgumentException if the key does not exist in the dictionary
     */
    V remove(K key) throws IllegalArgumentException;

    /**
     * Updates the value associated with an existing key.
     *
     * Pre-condition: The key must exist in the dictionary.
     * Post-condition: The value associated with the key will be updated.
     *
     * @param key the key whose value is to be updated
     * @param value the new value to associate with the key
     * @throws IllegalArgumentException if the key does not exist in the dictionary
     */
    void update(K key, V value) throws IllegalArgumentException;

    /**
     * Retrieves the value associated with a given key.
     *
     * Pre-condition: The key must exist in the dictionary.
     * Post-condition: The value associated with the key will be returned.
     *
     * @param key the key to look up
     * @return the value associated with the given key
     * @throws IllegalArgumentException if the key does not exist in the dictionary
     */
    V getValue(K key) throws IllegalArgumentException;

    /**
     * Checks if the dictionary contains a given key.
     *
     * Pre-condition: None
     * Post-condition: A boolean value indicating whether the key exists in the dictionary is returned.
     *
     * @param key the key to check
     * @return true if the key exists in the dictionary, false otherwise
     */
    boolean containsKey(K key);

    /**
     * Returns the number of key-value pairs in the dictionary.
     *
     * Pre-condition: None
     * Post-condition: The number of key-value pairs in the dictionary is returned.
     *
     * @return the size of the dictionary
     */
    int size();
}
