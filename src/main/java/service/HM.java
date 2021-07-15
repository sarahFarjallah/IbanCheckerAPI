package main.java.service;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @param <K> preferred as String
 * @param <V> preferred as Object
 */
public class HM<K,V> extends HashMap<K, V> {
	
	private static final long serialVersionUID = -4046256555545198648L;
	
	/**
	 * 
	 * @param old object to clone (values are not cloned)
	 */
	
	public HM(AbstractMap<K,V> old)
	{
		super();
		for(K k : old.keySet()) {
			this.put(k, old.get(k));
		}
	}
	
	protected void copyFrom(AbstractMap<K,V> old)
	{
		for(K k : old.keySet()) {
			this.put(k, old.get(k));
		}
	}
	
	public HM()
	{
		super();
	}
	
	/**
	 * Searched in a list of HMs for a key with a specific value;
	 * @param key
	 * @param val
	 * @param list
	 * @return
	 */
	public static <K,V> boolean searchForKeyInList(K key, V val, List<HM<K,V>> list) {
		boolean found = false;
		for(HM<K,V> row : list) {
			V val1 = row.get(key);
			if(val1 != null) {
				if(val1.equals(val)) {
					found = true;
					break;
				}
			}
		}
		return found;
	}
	
	/**
	 * 
	 */
	public String toString() {
		String ret = "{ ";
		List<String> vals = new ArrayList<String>();
		for(K k : this.keySet()) {
			V v = this.get(k);
			vals.add("\""+k.toString()+"\":"+(v==null?("null"):("\""+v.toString()+"\"")) );
		}
		ret += String.join(", ", vals)+" }";
		return ret;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public String getAsString(K key)
	{
		String ret = null;
		if(key == null) {
			ret = null;
		}
		Object v = null; 
		if(key != null ) { 
			v = this.get(key);
		}
		
		if(v == null) {
			ret = null;
			return ret; // if no key value returns null;
		} else if(v.getClass() == String.class) {
			ret = (String) v;
		} else {
			ret = v.toString();
		}
		
		if(ret == null) {
//			NullPointerException e = new NullPointerException("could not get String value");
//			logger.log(Level.SEVERE, ExceptionUtils.getStackTrace(e));
			ret = ""; // Safe Value
		}
		return ret;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public Long getAsLong(K key)
	{
		Object v = this.get(key);
		if(v == null)
			return null;
		Long ret = null;
		if(v.getClass() == Long.class) {
			ret = (Long) v;
		}
//		else if (v.getClass() == Integer.class) {
//			ret = (Long) v;
//		}
		else
		{
			try {
				ret = Long.parseLong(v.toString());
			}
			catch(Exception e) {
				ret = null;
			}
		}
		if(ret == null)
		{
//			NullPointerException e = new NullPointerException("could not get long or integer value");
//			logger.log(Level.SEVERE, ExceptionUtils.getStackTrace(e));
			ret = 0L; // Safe Value
		}
		return ret;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public Integer getAsInt(K key)
	{
		Object v = this.get(key);
		if(v == null)
			return null;
		Integer ret = null;
		if(v.getClass() == Long.class) {
			ret = (Integer.valueOf(v.toString()));
		}
		else if (v.getClass() == Integer.class) {
			ret = (Integer) v;
		}
		else if(v.getClass() == Double.class) {
			ret = Integer.valueOf((int) Math.round((Double) v));
		}
		else if(v.getClass() == Float.class) {
			ret = Integer.valueOf((int) Math.round((Float) v));
		}
		else
		{
			try {
				ret = Integer.parseInt(v.toString());
			}
			catch(Exception e) {
				ret = null;
			}
		}
//		if(ret == null)
//		{
//			NullPointerException e = new NullPointerException("could not get integer value");
//			logger.log(Level.SEVERE, ExceptionUtils.getStackTrace(e));
//			ret = 0; // Safe Value
//		}
		return ret;
	}
	
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public Boolean getAsBoolean(K key)
	{
		Object v = this.get(key);
		if(v == null)
			return null;
		Boolean ret = null;
		if(v.getClass() == Boolean.class) {
			ret = (Boolean) v;
		}
		else if (v.getClass() == Integer.class) {
			ret = (Integer)v != 0;
		}
		else
		{
			String s = v.toString();
			if(s.equals("t") || s.equals("True") || s.equals("true")) {
				ret = true;
			} else if(s.equals("f") || s.equals("False") || s.equals("false")) {
				ret = false;
			} else {
				try {
					ret = Integer.parseInt(s) != 0;
				}
				catch(Exception e) {
					ret = null;
				}
			}
		}
		if(ret == null)
		{
//			NullPointerException e = new NullPointerException("could not get boolean value");
//			logger.log(Level.SEVERE, ExceptionUtils.getStackTrace(e));
			ret = false; // Safe Value
		}
		return ret;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> keysAsStrings()
	{
		List<String> ret = new ArrayList<String>();
		Set<K> keys =  this.keySet();
		for (Object k : keys) {
			if(k == null) {
				continue;
			}
			if(k.getClass() == String.class) {
				ret.add((String) k);
			}
			else {
				NullPointerException e = new NullPointerException("could not get key " + k.toString() +" as string");
			}
		}
		return ret;
	}
	
	/**
	 * 
	 * @param <T>
	 * @param c
	 * @return
	 */
	public <T> List<T> valuesAsClass(Class<T> c) {
		Object[] all = this.values().toArray();
		List<T> all_ret = new ArrayList<T>();
		for(Object o: all) {
			T ret = null; 
			if(o != null && c.isInstance(o))
				ret = c.cast(o);
			if(ret != null) {
				all_ret.add(ret);
			}
		}
		return all_ret;
	}
	
	/**
	 * 
	 * @param key
	 * @param c
	 * @return
	 */
	public <T> T getAsClass(K key, Class<T> c)
	{
		Object o = this.get(key);
		if( o == null)
			return null;
		T ret = null; 
		if(o != null && c.isInstance(o))
			ret = c.cast(o);
//		if(ret == null)
//		{
//			NullPointerException e = new NullPointerException("could not get value as class");
//			logger.log(Level.SEVERE, ExceptionUtils.getStackTrace(e));
//			ret = null; // Safe Value
//		}
		return ret;
	}
	
//	public <T> T getAsType(Object key, Type<T> T) {
//		Object o = this.get(key);
//		if( o == null)
//			return null;
//		T ret = null; 
//		tToken = new TypToken()
//		T.isAssignableFrom(o.getClass());
//		if(o != null && c.isInstance(o))
//			ret = c.cast(o);
//		return ret;
//	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public Double getAsDouble(K key)
	{
		Object v = this.get(key);
		if(v == null)
			return 0.0;
		Double ret = null;
		if(v.getClass() == Double.class)
			ret = (Double) v;
		else if(v.getClass() == String.class)
		{
			try {
				ret = Double.parseDouble((String) v);
			}
			catch(Exception e)
			{
				ret = null;
			}
		} else {
			try {
				ret = Double.parseDouble(v.toString());
			}
			catch(Exception e)
			{
				ret = null;
			}
		}
		if(ret == null)
		{
//			NullPointerException e = new NullPointerException("could not get double value");
//			logger.log(Level.SEVERE, ExceptionUtils.getStackTrace(e));
			ret = 0.0; // Safe Value
		}
		return ret;
	}
	
	public String toJSON() {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(this);
	}
	
	@SuppressWarnings("unchecked")
	public <C> List<C> getAsListOf(K key, Class<C> c) {
		Object obj = this.get(key);
		if(List.class.isInstance(obj)) {
			@SuppressWarnings("rawtypes")
			List ret = (List)obj;
			List<C> ret2 = null;
			if(ret.getClass().getTypeName().equals(c.toString())) {
				ret2 = (List<C>)ret;
				if(ret2 != null) {
					return ret2;
				}
			}
			
			ret2 = new ArrayList<C>();
			for(Object o : ret) {
				if(c.isInstance(o)) {
					ret2.add((C)o);
				} else if(c == String.class) {
					ret2.add((C)o.toString());
				}
			}
			return ret2;
		} else {
			return null;
		}
		
	}




}
