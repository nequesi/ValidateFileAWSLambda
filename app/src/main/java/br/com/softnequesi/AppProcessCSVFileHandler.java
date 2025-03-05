package br.com.softnequesi;

import br.com.softnequesi.usecase.process.ProcessCSVFileUsecase;
import br.com.softnequesi.usecase.process.ProcessCSVFileUsecaseImpl;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;

public class AppProcessCSVFileHandler implements RequestHandler <S3Event, Void> {

    private final ProcessCSVFileUsecase processCSVFileUsecase = new ProcessCSVFileUsecaseImpl();
    @Override
    public Void handleRequest(S3Event input, Context context) {
        try {
            for (S3EventNotification.S3EventNotificationRecord s3EventNotificationRecord : input.getRecords()) {
                S3EventNotification.S3BucketEntity bucket = s3EventNotificationRecord.getS3().getBucket();
                String key = s3EventNotificationRecord.getS3().getObject().getKey();
                processCSVFileUsecase.execute(bucket, key);
            }
        }catch (Exception e) {
            System.err.println("Error processing S3 event: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return null;
    }
}
