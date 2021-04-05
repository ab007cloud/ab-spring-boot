package com.ab.restfulws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@PropertySource(value = "aws.properties")
@Data
public class AWSConfig {

	@Value("${cloud.aws.credentials.access-key}")
	private String awsAccessKey;
	@Value("${cloud.aws.credentials.secret-key}")
	private String awsSecretKey;
	@Value("${application.bucket.name}")
	private String awsS3BucketName;
	@Value("${cloud.aws.region.static}")
	private String region;

}
