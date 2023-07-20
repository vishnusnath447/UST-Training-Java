package com.ust.customerService.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ErrorDto(String message, LocalDateTime time,String uri,int status) {
}
