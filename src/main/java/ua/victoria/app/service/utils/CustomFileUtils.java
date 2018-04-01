package ua.victoria.app.service.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import ua.victoria.app.entity.UserDetail;
import ua.victoria.app.entity.UserEntity;
import ua.victoria.app.entity.enumerated.Gender;

public final class CustomFileUtils {

	public static String PROJECT_PATH = System.getProperty("user.dir");
	public static String SEPARATOR = System.getProperty("file.separator");
	public static String ROOT_PATH = PROJECT_PATH + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "webapp" + SEPARATOR + "upload";
	public static String RESOURCES_PATH = PROJECT_PATH + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "webapp" + SEPARATOR + "resources";
	public static String RESOURCES_IMG_PATH = PROJECT_PATH + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "webapp" + SEPARATOR + "resources"+SEPARATOR+"img"+SEPARATOR;
	
	public static File createFolder(String folderName) {
		  File root = new File(ROOT_PATH);
		  if (!root.exists()) {
			  root.mkdir();
			}
		  
		  File folder = new File(root.getAbsolutePath() + File.separator + folderName);
	        if (!folder.exists()) {
	            if (folder.mkdir()) {
	                System.out.println("Directory is created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
	        }
		return folder;
	}
	
public static String getImage(UserEntity user) throws IOException {
		File file = null;
		byte[] encodeFileToByte = null;
		String encodedFile = null;
		String defaultPath;
		if(user.getUserDetail().getGender()==Gender.WONAN) {
			defaultPath = ROOT_PATH + SEPARATOR + "default_female.png";
		}else {
			defaultPath = ROOT_PATH + SEPARATOR + "default_man.png";
		}
		
		String img = ROOT_PATH+SEPARATOR+"user_"+user.getId()+SEPARATOR+"logo.png";
		
		
		if (new File(img).exists()) {
			file = new File(img);
			
			if(!file.exists()) { 
				file = new File(defaultPath); 
			}
		} else {
			file = new File(defaultPath);
		}
		
		encodeFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
		encodedFile = new String(encodeFileToByte);
		
		return encodedFile;
	}

public static String getImage(String  pathfoto) throws IOException {
	File file = null;
	byte[] encodeFileToByte = null;
	String encodedFile = null;
	String defaultPath = ROOT_PATH + SEPARATOR + "default_news.png";
	String img = ROOT_PATH+SEPARATOR+pathfoto;
	
	if (new File(img).exists()) {
		file = new File(img);
		
		if(!file.exists()) { 
			file = new File(defaultPath); 
		}
	} else {
		file = new File(defaultPath);
	}
	
	encodeFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
	encodedFile = new String(encodeFileToByte);
	
	return encodedFile;
}
	
}
