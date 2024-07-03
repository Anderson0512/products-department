package com.dio.santander.model.dto;

import com.dio.santander.model.vo.ProductVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductListDTO extends BaseListBFFResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("_content")
    private List<ProductVO> productVOList;
}
