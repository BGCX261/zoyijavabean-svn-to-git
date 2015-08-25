/**
 * 
 */
package org.zoyi.adapter;

/**
 * @author dhibmclub
 *
 */
public class StringAdapter {

	public static int str2Int(String str){
		if(isAvailableString(str)){
			try {
				return Integer.valueOf(str);
			} catch (Exception e) {
				return 0;
			}
		}else{
			return 0;
		}
	}
	
	public static boolean isAvailableString(String str){
		if(str==null || "".equals(str.trim()))
			return false ;
		else
			return true ;
	}
	
	public static int obj2Int(Object obj){
		if(obj!=null){
			try {
				return Integer.valueOf(obj.toString());
			} catch (Exception e) {
				return 0;
			}
		}else{
			return 0;
		}
	}
	
	public static String obj2str(Object obj){
		if(obj==null || !isAvailableString(obj.toString())){
			return "";
		}
		return obj.toString().trim();
	}
	
}
