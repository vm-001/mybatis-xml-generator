package top.leeys.codegenerator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询与分页
 * 
 * model: 实体bean <br/>
 * page: 页码，默认第一页 <br/>
 * pageSize: 每页记录数，默认20 <br/>
 * 
 * @author leeys.top@gmail.com
 * @param <T>
 *
 */
public class QueryCondition<T> {

    public static final int DEFAULT_PAGE = 1;
    public static final int DEFAULT_PAGE_SIZE = 20;
    
    public enum OrderBy {
        DESC, ASC;
    }

    private T model;
    private int page = DEFAULT_PAGE;
    private int pageSize = DEFAULT_PAGE_SIZE;
    private Map<String, String> orderBy = new LinkedHashMap<>(4);
    private Map<String, String> where = new HashMap<>(8);

    private QueryCondition() {}

    private void setModel(T model) {
        this.model = model;
    }

    private void setPage(int page) {
        this.page = page < 1 ? DEFAULT_PAGE : page;
    }

    private void setPageSize(int pageSize) {
        this.pageSize = pageSize < 1 ? DEFAULT_PAGE_SIZE : pageSize;
    }
    
    // ================ PUBLIC ================

    public static <T> QueryCondition<T> with(T model) {
        QueryCondition<T> qc = new QueryCondition<T>();
        qc.setModel(model);
        return qc;
    }

    public static <T> QueryCondition<T> with(T model, int pageNo, int pageSize) {
        QueryCondition<T> qc = new QueryCondition<T>();
        qc.setModel(model);
        qc.setPage(pageNo);
        qc.setPageSize(pageSize);
        return qc;
    }

    public QueryCondition<T> where(String key, String value) {
        where.put(key, value);
        return this;
    }


    public QueryCondition<T> orderBy(String col, OrderBy sort) {
        orderBy.put(col, sort.name());
        return this;
    }

    public T getModel() {
        return model;
    }

    public int getStartRow() {
        return (page - 1) * pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Map<String, String> getOrderBy() {
        return orderBy;
    }
    
    public Map<String, String> getWhere() {
        return where;
    }
}


