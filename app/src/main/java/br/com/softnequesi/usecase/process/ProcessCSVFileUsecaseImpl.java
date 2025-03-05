package br.com.softnequesi.usecase.process;

import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;

public class ProcessCSVFileUsecaseImpl implements ProcessCSVFileUsecase{
    @Override
    public void execute(S3EventNotification.S3BucketEntity bucket, String key) {

    }
}
