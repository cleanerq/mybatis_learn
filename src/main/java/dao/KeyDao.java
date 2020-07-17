package dao;

import bean.Key;

public interface KeyDao {

    /**
     * 查询时 将钥匙和锁子一起查询
     * @param id
     * @return
     */
    public Key getKeyById(Integer id);
}
