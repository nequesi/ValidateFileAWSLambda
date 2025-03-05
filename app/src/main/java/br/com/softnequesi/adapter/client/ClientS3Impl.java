package br.com.softnequesi.adapter.client;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class ClientS3Impl implements ClientS3{

    static String localhost = System.getenv("LOCALHOST");
    @Override
    public AmazonS3 getClient() {
        if (localhost!= null && localhost.equalsIgnoreCase("true")) {
            return AmazonS3ClientBuilder.standard()
                    .withEndpointConfiguration(
                            new AwsClientBuilder.EndpointConfiguration(
                                    "http://s3.us-east-1.localhost.localstack.cloud:4566",
                                    "us-east-1"))
                    .withCredentials(new ProfileCredentialsProvider("localstack"))
                    .withAccelerateModeEnabled(true)
                    .build();
        } else {
            return AmazonS3ClientBuilder.defaultClient();
        }
    }
}
