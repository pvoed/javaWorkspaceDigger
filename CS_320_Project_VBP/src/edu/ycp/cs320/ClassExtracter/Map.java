package edu.ycp.cs320.ClassExtracter;

public interface Map<K, V> {
	public V put(K key, V value);
	public V get(K key);
	public V remove(K key);
}