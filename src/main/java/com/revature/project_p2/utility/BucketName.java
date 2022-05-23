package com.revature.project_p2.utility;

public enum BucketName {
    PROFILE_IMAGE("awsimageuploaddemo");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
