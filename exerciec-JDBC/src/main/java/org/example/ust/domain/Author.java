package org.example.ust.domain;

import java.time.LocalDate;
public record Author(int authorId,String authorName,String authorEmail,LocalDate joinDate){}
