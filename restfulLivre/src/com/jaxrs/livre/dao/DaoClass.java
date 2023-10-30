package com.jaxrs.livre.dao;

import java.util.HashMap;
import java.util.Map;

import com.jaxrs.livre.model.Livre;

public class DaoClass {
	private static Map<Integer,Livre> livres = new HashMap<Integer,Livre>();
	public static Map<Integer, Livre> getLivres() {
		return livres;
	}
}
