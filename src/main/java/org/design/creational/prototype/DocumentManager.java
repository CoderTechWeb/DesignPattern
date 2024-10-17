package org.design.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class DocumentManager {

    public Map<String, Document> documentTemplate = new HashMap<>();

    public void addTemplate(String key, Document doc){
        documentTemplate.put(key, doc);
    }

    public Document createDocument(String key){
        return documentTemplate.get(key).clone();
    }
}