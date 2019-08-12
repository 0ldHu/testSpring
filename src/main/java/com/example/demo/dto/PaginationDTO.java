package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Integer page;
}
