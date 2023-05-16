package com.sopra.dao;

import java.util.List;

public interface Repository <T> {

	public int add(T t);
	public int delete(int id,T t);
	public int update(T t);
	public List<T> list(T t);
	public T get(int id,T t);
}
