package com.cskaoyan.vo;

import java.util.List;

public class StatementResultVo<T> {
    private String[] columns;
    private List<T> rows;

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }


}
