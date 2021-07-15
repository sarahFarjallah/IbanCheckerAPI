package main.java.service;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;


public class TableRowHM extends HM<String, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2688471811014028164L;

	public TableRowHM() {
		// TODO Auto-generated constructor stub
	}
	public TableRowHM(AbstractMap<String, Object> old) {
		super(old);
	}
	
	public List<TableRowHM> convertToHMList(String key){
		List<AbstractMap> maps = this.getAsListOf(key, AbstractMap.class);
		List<TableRowHM> rows = new ArrayList<TableRowHM>();
		for(AbstractMap<String, Object> map : maps) {
			rows.add(new TableRowHM(map));
		}
		this.put(key, rows);
		return rows;
	}
	
	/**
	 * This function converts a JSONArray of JSONObject(s) object to a list of TableRowHM
	 * @param arr
	 * @return
	 */
//	public static List<TableRowHM> convertToHMList(JSONArray arr) {
//		List<TableRowHM> list = new ArrayList<TableRowHM>();
//		for(int i=0; i <arr.length(); i++) {
//			TableRowHM hm = new TableRowHM();
//			for(String key : arr.getJSONObject(i).keys()) {
//				if(arr.getJSONObject(i).get(key) instanceof JSONArray 
//					&& arr.getJSONObject(i).getJSONArray(key).length() > 0 
//					&& arr.getJSONObject(i).getJSONArray(key).get(0) instanceof JSONObject) {
//					hm.put(key, TableRowHM.convertToHMList(arr.getJSONObject(i).getJSONArray(key)));
//				} else {
//					hm.put(key, String.valueOf(arr.getJSONObject(i).get(key)));					
//				}
//			}
//			list.add(hm);
//		}
		
//		return list;
//	}
	
//	public static TableRowHM convertToTableRowHM(JSONObject obj) {
//		TableRowHM hm = new TableRowHM();
//		for(String key : obj.keySet()) {
//			if(obj.get(key) instanceof JSONArray 
//				&& obj.getJSONArray(key).length() > 0 
//				&& obj.getJSONArray(key).get(0) instanceof JSONObject) {
//				hm.put(key, TableRowHM.convertToHMList(obj.getJSONArray(key)));
//			} else {
//				hm.put(key, String.valueOf(obj.get(key)));					
//			}
//		}
//		return hm;
//	}
	
	/**
	 * 
	 * @param key
	 * @param val
	 * @param list
	 * @return
	 */
	public static boolean searchForKeyInList(String key, Object val, List<TableRowHM> list) {
		boolean found = false;
		for(TableRowHM row : list) {
			Object val1 = row.get(key);
			if(val1 != null) {
				if(val1.equals(val)) {
					found = true;
					break;
				}
			}
		}
		return found;
	}
	
	public static TableRowHM groupListBy(List<TableRowHM> list, String key) {
		TableRowHM groupedElements = new TableRowHM();
		
		for(TableRowHM hm : list) {
			String value = hm.getAsString(key);
			List<TableRowHM> tempList = null;
			if(groupedElements.containsKey(value)) {
				tempList = groupedElements.getAsListOf(value, TableRowHM.class);
			} else {
				tempList = new ArrayList<TableRowHM>();
			}
			tempList.add(hm);
			groupedElements.put(value, tempList);
		}
		
		return groupedElements;
	}
	
	/**
	 * this function loops over all elements of the main list, and adds to them the MISSING
	 * keys and values that exist in the secondary list, while matching items by the provided
	 * key. Items in the secondary list that dont have a match in the main list are not considered
	 * Keys that exist in both lists will not be replaced, only new keys will be added from the secondary list
	 * @param mainList
	 * @param secondaryList
	 * @param key
	 * @return
	 */
	public static List<TableRowHM> combineOverKey(List<TableRowHM> mainList, List<TableRowHM> secondaryList, String key) {
		for(int i=0; i < mainList.size(); i++) {
			TableRowHM mainHM = mainList.get(i);
			List<TableRowHM> filtered = secondaryList.stream().filter(hm->hm.getAsString(key).equals(mainHM.getAsString(key)))
					.collect(Collectors.toList());
			if(filtered.size() == 0) {
				continue;
			}
			
			TableRowHM matchingHM = filtered.get(0);
			
			for(String tempKey : matchingHM.keySet()) {
				if(!mainHM.containsKey(tempKey)) {
					mainHM.put(tempKey, matchingHM.get(tempKey));
				}
			}
			mainList.set(i, mainHM);
		}
		
		return mainList;
	}

}
