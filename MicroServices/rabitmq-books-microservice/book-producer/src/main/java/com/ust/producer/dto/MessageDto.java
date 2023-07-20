package com.ust.producer.dto;

import java.io.Serializable;
import java.util.List;

public record MessageDto(String name, List<String> bookList) implements Serializable {
}
