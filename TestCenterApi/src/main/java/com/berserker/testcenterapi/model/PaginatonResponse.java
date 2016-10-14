package com.berserker.testcenterapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatonResponse<T> implements Serializable {
    private static final long serialVersionUID = 768549219446295665L;
    private Integer total;  //总条数
    private List<T> records; //当前页显示数据
}
