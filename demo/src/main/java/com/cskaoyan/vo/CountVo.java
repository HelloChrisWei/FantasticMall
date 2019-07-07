package com.cskaoyan.vo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class CountVo {
    private String[] columns;
    private List<Map> rows;

    public CountVo() {
    }

    public CountVo(String[] columns, List<Map> rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public List<Map> getRows() {
        return rows;
    }

    public void setRows(List<Map> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "CountVo{" +
                "columns=" + Arrays.toString(columns) +
                ", rows=" + rows +
                '}';
    }
}
