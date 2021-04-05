package com.ab.restfulws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ab.restfulws.service.AWSS3FileService;

@RestController

public class AWSS3Controller {

	@Autowired
	private AWSS3FileService awss3FileService;

	@PostMapping("/aws/upload")
	public ResponseEntity uploadFile(@RequestParam(value = "file") MultipartFile multipartFile) {
		awss3FileService.uploadFileToAWS(multipartFile);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@GetMapping("/aws/download/{fileName}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
		byte[] data = awss3FileService.downloadFileFromAWS(fileName);
		ByteArrayResource byteArrayResource = new ByteArrayResource(data);
		return ResponseEntity.ok().contentLength(data.length)
				.header("Content-type", MediaType.APPLICATION_OCTET_STREAM_VALUE)
				.header("Content-deposition", "attachment,fileName=\"" + fileName + "\"").body(byteArrayResource);

	}

	@DeleteMapping("/aws/delete/{fileName}")
	public ResponseEntity deleteFile(@PathVariable String fileName) {
		awss3FileService.deleteFileFromAWS(fileName);
		return ResponseEntity.status(HttpStatus.OK).build();

	}

}
