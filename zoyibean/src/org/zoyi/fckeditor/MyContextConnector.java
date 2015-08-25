package org.zoyi.fckeditor;

import java.io.InputStream;

import org.zoyi.util.FileOper;

import net.fckeditor.connector.exception.InvalidCurrentFolderException;
import net.fckeditor.connector.exception.WriteException;
import net.fckeditor.connector.impl.ContextConnector;
import net.fckeditor.handlers.ResourceType;

/**
 * 2009-9-2
 * 
 * @author PengFei 文件上传的操作在ContextConnector类中，这里只是对其进行重命名操作，其实完全可以重新自己写上传的代码
 */
public class MyContextConnector extends ContextConnector {

	// 此方法中可以对文件重命名
	@Override
	public String fileUpload(ResourceType type, String currentFolder,
			String fileName, InputStream inputStream)
			throws InvalidCurrentFolderException, WriteException {
		fileName = java.util.UUID.randomUUID() + "."
				+ FileOper.getFileExtName(fileName);// 重命名操作在这里进行
		return super.fileUpload(type, currentFolder, fileName, inputStream);
	}

}
