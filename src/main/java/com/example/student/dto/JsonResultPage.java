package com.example.student.dto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

public class JsonResultPage<T> extends Page<T> {
    /**
     * 查询数据列表
     */
    private List<T> records;
    /**
     * 总数
     */
    private long total = 0;

    /**
     * 每页显示条数，默认 10
     */
    private long pageSize = 10;

    /**
     * 当前页
     */
    private long page = 1;

    /**
     * 是否进行 count 查询
     */
    private boolean isSearchCount = true;

    @Override
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public Page<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public Page<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    public boolean getSearchCount() {
        if (total < 0) {
            return false;
        }
        return isSearchCount;
    }

    @Override
    public boolean isSearchCount() {
        if (total < 0) {
            return false;
        }
        return isSearchCount;
    }

    @Override
    public Page<T> setSearchCount(boolean isSearchCount) {
        this.isSearchCount = isSearchCount;
        return this;
    }

    @Override
    public long getSize() {
        return this.pageSize;
    }

    @Override
    public Page<T> setSize(long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.page;
    }

    @Override public Page<T> setCurrent(long page) { this.page = page; return this; }
}
