package com.ab.restfulws.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ab.restfulws.config.AWSConfig;
import com.ab.restfulws.util.FileUtil;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AWSS3FileService {
	@Autowired
	private AmazonS3 s3Client;
	@Autowired
	private AWSConfig awsConfig;

	public void uploadFileToAWS(MultipartFile multipartFile) {
		File file = FileUtil.convertMultiPartFileToFile(multipartFile);
		String fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
		log.info("fileName {}", fileName);
		s3Client.putObject(new PutObjectRequest(awsConfig.getAwsS3BucketName(), fileName, file));
		log.info("File Uploaded Successfully to AWS S3");
		file.delete();
		log.info("File deleted Successfully from Server");
	}

	public byte[] downloadFileFromAWS(String fileName) {
		byte[] fileContent = null;
		S3Object s3Object = s3Client.getObject(awsConfig.getAwsS3BucketName(), fileName);
		S3ObjectInputStream s3ObjectInputStream = s3Object.getObjectContent();
		try {
			fileContent = IOUtils.toByteArray(s3ObjectInputStream);
		} catch (IOException e) {
			log.error("Exception happened {}", e);

		}
		return fileContent;
	}

	public void deleteFileFromAWS(String fileName) {
		s3Client.deleteObject(awsConfig.getAwsS3BucketName(), fileName);
		log.info("File Deleted Successfully from AWS S3");
	}

}
