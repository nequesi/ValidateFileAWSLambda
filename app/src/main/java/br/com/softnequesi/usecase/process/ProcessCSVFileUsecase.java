package br.com.softnequesi.usecase.process;

import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;

public interface ProcessCSVFileUsecase {
    void execute(S3EventNotification.S3BucketEntity bucket, String key);
}
