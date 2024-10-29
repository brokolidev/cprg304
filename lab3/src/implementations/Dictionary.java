package implementations;

import java.util.ArrayList;

import exceptions.DuplicateKeyException;
import utilities.DictionaryADT;

public class Dictionary<K,V> implements DictionaryADT<K,V>
{
	// constant
	private static final int DEFAULT_SIZE = 10;
	
	// index indicates pairing, e.g. keys[1] is stored at values[1]
	private ArrayList<K> keys;
	private ArrayList<V> values;

	// Constructor
	public Dictionary() {
		keys = new ArrayList<>(DEFAULT_SIZE);
		values = new ArrayList<>(DEFAULT_SIZE);
	}

	@Override
	public void insert(K key, V value) throws DuplicateKeyException {
		if (containsKey(key)) {
			throw new DuplicateKeyException("Key already exists in the dictionary.");
		}
		keys.add(key);
		values.add(value);
	}

	@Override
	public V remove(K key) throws IllegalArgumentException {
		int index = keys.indexOf(key);
		if (index == -1) {
			throw new IllegalArgumentException("Key does not exist in the dictionary.");
		}
		V removedValue = values.get(index);
		keys.remove(index);
		values.remove(index);
		return removedValue;
	}

	@Override
	public void update(K key, V value) throws IllegalArgumentException {
		int index = keys.indexOf(key);
		if (index == -1) {
			throw new IllegalArgumentException("Key does not exist in the dictionary.");
		}
		values.set(index, value);
	}

	@Override
	public V getValue(K key) throws IllegalArgumentException {
		int index = keys.indexOf(key);
		if (index == -1) {
			throw new IllegalArgumentException("Key does not exist in the dictionary.");
		}
		return values.get(index);
	}

	@Override
	public boolean containsKey(K key) {
		return keys.contains(key);
	}

	@Override
	public int size() {
		return keys.size();
	}

}
