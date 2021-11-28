package com.company.charcounter.count;

import java.util.Map;

public interface CharCounter {

    Map<Character, Long> countInternal(String text);

}
