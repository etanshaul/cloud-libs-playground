package com.eshaul.cloud.libs;

import com.google.cloud.datastore.*;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by eshaul on 10/18/17.
 */
@Service
public class DatastoreService {
    Map<String, String> getEntries() {
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        Query<Entity> query = Query.newEntityQueryBuilder().setKind("TestKind").build();
        QueryResults<Entity> results = datastore.run(query);

        Map<String, String> properties = Maps.newHashMap();
        while (results.hasNext()) {
            Entity currentEntity = results.next();
            System.out.println(currentEntity.getString("key1"));
            System.out.println(currentEntity.getNames());
            currentEntity.getNames().forEach(name -> properties.put(name, currentEntity.getString(name)));
        }

        return properties;
    }

    void seedData() {
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("LocalEmulator");
        Key key = keyFactory.newKey("localKey") ;
        Entity entity = Entity.newBuilder(key).set("test", "testVal").build();
        datastore.put(entity);
    }
}
