/**
 * 
 */
package org.zoyi.util;


/**
 * @author dhibmclub
 * 
 */
public class FileOper {

	public static String getFileExtName(String fileName) {
		if (org.zoyi.adapter.StringAdapter.isAvailableString(fileName)) {
			String[] tokens = fileName.split("\\x2E"); // \\x2E在正则表达式中表示"."     
			String ext = tokens[tokens.length-1];
			return ext ;
		} else {
			return "";
		}
	}

	public FileOper() {
		// TODO Auto-generated constructor stub
	}


}
