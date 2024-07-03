package com.dio.santander.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

@Getter
public class Pageable implements Serializable {
    @Serial
    private static final long serialVersionUID = -753749465559432781L;
    @JsonProperty("_limit")
    private Integer limit;
    @JsonProperty("_offset")
    private Integer offset;
    @JsonProperty("_pageNumber")
    private Integer pageNumber;
    @JsonProperty("_pageElements")
    private Integer pageElements;
    @JsonProperty("_totalPages")
    private Integer totalPages;
    @JsonProperty("_totalElements")
    private Integer totalElements;

    public Pageable(String valor) {
        this.initializeAttributes();
    }

    public void initializeAttributes() {
        this.limit = 50;
        this.offset = 0;
        this.pageNumber = 0;
        this.pageElements = 0;
        this.totalPages = 1;
        this.totalElements = 0;
    }

  @JsonProperty("_limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @JsonProperty("_offset")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @JsonProperty("_pageNumber")
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    @JsonProperty("_pageElements")
    public void setPageElements(Integer pageElements) {
        this.pageElements = pageElements;
    }

    @JsonProperty("_totalPages")
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @JsonProperty("_totalElements")
    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }
}

