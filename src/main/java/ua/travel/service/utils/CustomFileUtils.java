package ua.travel.service.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

public final class CustomFileUtils {

	static String PROJECT_PATH = System.getProperty("user.dir");
	static String SEPARATOR = System.getProperty("file.separator");
	static String ROOT_PATH = PROJECT_PATH + SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "webapp" + SEPARATOR + "upload";
	
	public static File createFolder(String folderName) {

		File uploadDir = new File(ROOT_PATH);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		File folder = new File(uploadDir.getAbsolutePath() + File.separator + folderName);
		if (!folder.exists()) {
			folder.mkdir();
		}

		return folder;
	}
	
	public static void createImage(String folderName, MultipartFile file) throws IOException {
		if (!file.isEmpty() && file != null) {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			File destination = new File(createFolder(folderName).getAbsolutePath() + SEPARATOR + file.getOriginalFilename());
			ImageIO.write(image, "png", destination);
		}
	}
	
public static String getImage(String folderName, String image) throws IOException {
		
		File file = null;
		byte[] encodeFileToByte = null;
		String encodedFile = null;
		
		System.out.println("Image: " + image);
		String defaultPath = ROOT_PATH + SEPARATOR + "default.png";
		
		if (image != null && image != "") {
			file = new File(ROOT_PATH + SEPARATOR + folderName + SEPARATOR + image);
			
			if(!file.exists()) { 
				file = new File(defaultPath); 
			}
		} else {
			file = new File(defaultPath);
		}
		
		System.out.println(file.getAbsolutePath());	
		encodeFileToByte = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
		encodedFile = new String(encodeFileToByte);
		
		return encodedFile;
	}
}
