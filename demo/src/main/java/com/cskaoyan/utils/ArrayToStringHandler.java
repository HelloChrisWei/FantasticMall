package com.cskaoyan.utils;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.type.*;
import java.sql.*;
import java.util.Arrays;

public class ArrayToStringHandler extends BaseTypeHandler<String[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        if (strings == null){
            preparedStatement.setNull(i, Types.VARCHAR);
        }else{
            JSONArray array = new JSONArray(Arrays.asList(strings));
            preparedStatement.setString(i,array.toString());
        }
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String columnValue = resultSet.getString(s);
        return this.getStringArray(columnValue);
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String columnValue = resultSet.getString(i);
        return this.getStringArray(columnValue);
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String columnValue = callableStatement.getString(i);
        return this.getStringArray(columnValue);
    }

    private String[] getStringArray(String columnValue) {
        if (columnValue == null)
            return null;
        JSONArray jsonArr = JSONArray.parseArray(columnValue);
        return jsonArr.toArray(new String[jsonArr.size()]);
    }
}
