package org.learnSpring.Prototype;

import java.util.HashMap;
import java.util.Map;

public abstract class Document implements Cloneable {
    protected String title;
    protected String content;
    protected Map<String, String> metadata;

    public Document() {
        this.metadata = new HashMap<>();
    }

    public Document(String title, String content, Map<String, String> metadata) {
        this.title = title;
        this.content = content;
        this.metadata = metadata != null ? new HashMap<>(metadata) : new HashMap<>();
    }
    @Override
    public Document clone() throws CloneNotSupportedException {
        Document clonedObj = (Document) super.clone();
        clonedObj.metadata = new HashMap<>(this.metadata);
        return clonedObj;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata != null ? new HashMap<>(metadata) : new HashMap<>();
    }

    public abstract void display();
}
