package com.dio.santander.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class BaseListBFFResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = -5511064390914624123L;
    @JsonProperty("_pageable")
    private Pageable pageable = new Pageable("Padrao");

    public BaseListBFFResponse() {
    }

    public void setValuesPageable(List<?> content) {
        Pageable paginacao = new Pageable("0");
        int totalElements = content != null ? content.size() : 0;
        int totalPages = totalElements / paginacao.getLimit();
        int totalPagesCount = totalElements > 0 ? 1 : 0;
        paginacao.setTotalElements(totalElements);
        paginacao.setTotalPages(totalPages > 0 ? totalPages : totalPagesCount);
        this.setPageable(paginacao);
    }

    public Pageable getPageable() {
        return this.pageable;
    }

    @JsonProperty("_pageable")
    public void setPageable(Pageable pageable) {
        this.pageable = pageable;
    }
}
