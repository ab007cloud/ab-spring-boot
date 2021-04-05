package com.ab.restfulws.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ab.restfulws.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtil {
	public static List<User> parseCSVFile(MultipartFile multipartFile) {
		final List<User> users = new ArrayList<>();
		try {
			final BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(multipartFile.getInputStream()));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				final String[] data = line.split(",");
				final User user = new User();
				user.setName(data[1]);
				user.setEmail(data[2]);
				users.add(user);
			}

		} catch (Exception e) {
			log.error("CSV parse error {}", e);
		}
		return users;
	}

	public static File convertMultiPartFileToFile(MultipartFile multipartFile) {

		File file = new File(multipartFile.getOriginalFilename());
		try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
			fileOutputStream.write(multipartFile.getBytes());
		} catch (Exception e) {
			log.error("Error Converting File {}", e);
		}
		return file;
	}

}
