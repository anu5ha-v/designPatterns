package org.learnSpring;

import java.util.HashMap;

public interface ConfigSource {
    HashMap<String, String> readConfig();
}
