package com.nakardo.trendyhotels.dto;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;

/**
 * Created by nakes on 2/17/14.
 */
public class DefaultMapper extends ObjectMapper {

    public DefaultMapper() {
        setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }
}
