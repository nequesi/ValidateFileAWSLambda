package br.com.softnequesi.adapter.client;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

public class ClientSQSImpl implements ClientSQS{
    static String localhost = System.getenv("LOCALHOST");

    @Override
    public AmazonSQS getSqsClient() {
        if (localhost != null) {
            return AmazonSQSClientBuilder.standard()
                   .withEndpointConfiguration(
                           new AwsClientBuilder.EndpointConfiguration(
                                   "http://localhost:4566", "us-east-1"))
                    .withCredentials( new ProfileCredentialsProvider("localstack"))
                   .build();
        } else {
            return AmazonSQSClientBuilder.standard()
                   .withRegion("us-east-1")
                   .build();
        }
    }
}
