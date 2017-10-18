package com.eshaul.cloud.libs;

import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.springframework.stereotype.Service;

/**
 * Created by eshaul on 10/18/17.
 */
@Service
public class TranslateService {

    String translate(String input) {
        Translate translate = TranslateOptions.getDefaultInstance().getService();
        Detection detection = translate.detect(input);
        Translation translation = translate.translate(input, Translate.TranslateOption.sourceLanguage(detection.getLanguage()), Translate.TranslateOption.targetLanguage("es"));

        return translation.getTranslatedText();
    }

}
