package com.beautifulsoup.dataexchange.com.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;


/**
 * <p>Title: JsonRowMapper</p>
 * <p>Description: 数据封装</p>
 * <p>Author: BeautifulSoup</p>
 * <p>Time: 2019年1月31日 下午3:38:24</p>
 */
public class JsonRowMapper implements RowMapper<JSONObject> {


    /**
     * <p>@see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)</p>
     * <p>Description: 结果集的映射</p>
     * <p>Author: BeautifulSoup</p>
     * <p>Time: 2019年1月31日 下午3:51:25</p>
     */
    public JSONObject mapRow(ResultSet rs, int row) throws SQLException {
        String key = null;
        Object obj = null;
        JSONObject json = new JSONObject();
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();
        for (int i = 1; i <= count; i++) {
            key = JdbcUtils.lookupColumnName(rsmd, i);
            obj = JdbcUtils.getResultSetValue(rs, i);
            try {
                json.put(key, obj);
            }
            catch (JSONException e) {
            }
        }
        return json;
    }
}
