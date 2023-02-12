package com.accelhack.accelparts.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Objects;

public class ObjectMapperUtils {
  private static ObjectMapper mapper;

  public static ObjectMapper getMapper() {
    if (Objects.nonNull(mapper)) {
      return mapper;
    }
    mapper = new JsonMapper();
    mapper.registerModule(new JavaTimeModule());
//    mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
    mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    return mapper;
  }

  public static String writeValueAsString(Object value) throws JsonProcessingException {
    return getMapper().writeValueAsString(value);
  }

  public static <T> T readValue(String content, Class<T> valueType) throws JsonProcessingException, JsonMappingException {
    return mapper.readValue(content, valueType);
  }
}
