package br.com.softnequesi.adapter.client;

import com.amazonaws.services.s3.AmazonS3;

public interface ClientS3 {

    AmazonS3 getClient();
}
