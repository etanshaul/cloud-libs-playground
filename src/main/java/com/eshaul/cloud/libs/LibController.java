package com.eshaul.cloud.libs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Created by eshaul on 10/16/17.
 */
@Controller
@EnableAutoConfiguration
public class LibController {

    private final GcsService gcsService;
    private final DatastoreService datastoreService;
    private final TranslateService translateService;

    private static final String TRANSLATE_INPUT = "dog";

    @Autowired
    public LibController(GcsService gcsService, DatastoreService datastoreService,
                         TranslateService translateService) {
        this.gcsService = gcsService;
        this.datastoreService = datastoreService;
        this.translateService = translateService;
    }

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        model.put("buckets", gcsService.getBuckets());
        model.put("datastoreProps", datastoreService.getEntries());
        model.put("translationInput", TRANSLATE_INPUT);
        model.put("translationOutput", translateService.translate(TRANSLATE_INPUT));
        return "index";
    }

    @GetMapping("/seed")
    public String seed() {
        datastoreService.seedData();
        return "index";
    }
}