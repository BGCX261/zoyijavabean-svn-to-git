package org.zoyi.test;

import java.io.*;
import java.util.*;

import org.zoyi.util.*;
import org.zoyi.vo.*;
import org.zoyi.adapter.*;
import org.zoyi.hibernate.*;
import org.zoyi.jsf.*;
import org.zoyi.model.*;
import org.zoyi.po.*;
import org.zoyi.service.impl.*;

;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			System.out.println(new GroupCategoryServiceImpl().queryAll().size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}