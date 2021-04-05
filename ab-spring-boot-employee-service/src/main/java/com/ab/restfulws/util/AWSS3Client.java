package com.ab.restfulws.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.ab.restfulws.config.AWSConfig;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Component
public class AWSS3Client {

	@Autowired
	private AWSConfig awsConfig;

	@Bean
	public AmazonS3 generateAWSS3Clinet() {
		AWSCredentials awsCredentials = new BasicAWSCredentials(awsConfig.getAwsAccessKey(),
				awsConfig.getAwsSecretKey());
		return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.withRegion(awsConfig.getRegion()).build();

	}

}
