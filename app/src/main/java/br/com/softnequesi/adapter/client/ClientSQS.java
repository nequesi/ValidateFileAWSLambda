package br.com.softnequesi.adapter.client;

import com.amazonaws.services.sqs.AmazonSQS;

public interface ClientSQS {

    AmazonSQS getSqsClient();
}
