package com.example.PortraitAPI.zzz;


import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;


public class AWSSample {
    static final String S3_ACCESS_KEY           = "";
    static final String S3_SECRET_KEY           = "";
    static final String S3_SERVICE_END_POINT    = "";
    static final String S3_REGION               = "";
    static final String S3_BUCKET_NAME          = "";


    public static void main(String[] args) {
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        List<Bucket> buckets = s3.listBuckets();
        System.out.println("Your Amazon S3 buckets are:");
        for (Bucket b : buckets) {
            System.out.println("* " + b.getName());
        }
    }

    private static AmazonS3 auth(){
        System.out.println("auth start");

        // AWSの認証情報
        AWSCredentials credentials = new BasicAWSCredentials(S3_ACCESS_KEY, S3_SECRET_KEY);

        // クライアント設定
        ClientConfiguration clientConfig = new ClientConfiguration();

        // エンドポイント設定
        AwsClientBuilder.EndpointConfiguration endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(S3_SERVICE_END_POINT,  S3_REGION);

        // S3アクセスクライアントの生成
        AmazonS3 client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withClientConfiguration(clientConfig)
                .withEndpointConfiguration(endpointConfiguration).build();

        System.out.println("auth end");
        return client;
    }
}
