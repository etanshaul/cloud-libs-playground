package com.eshaul.cloud.libs;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by eshaul on 10/17/17.
 */
@Service
class GcsService {
    List<String> getBuckets() {
        // app default creds
        Storage storage = StorageOptions.getDefaultInstance().getService();
        Iterable<Bucket> buckets = storage.list().iterateAll();

        return StreamSupport.stream(buckets.spliterator(), false).map(BucketInfo::getName).collect(Collectors.toList());
    }
}
