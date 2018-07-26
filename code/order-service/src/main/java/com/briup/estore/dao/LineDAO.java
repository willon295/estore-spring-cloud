package com.briup.estore.dao;

import com.briup.estore.common.bean.Line;

import java.util.List;

/**
 * 订单明细 DAO
 *
 * @author willon
 */
public interface LineDAO {

    /**
     * 通过 明细id 查询明细
     *
     * @param id 明细id
     * @return 明细
     */
    Line getLineById(int id);


    /**
     * 获取所有 订单明细
     *
     * @return 订单明细
     */
    List<Line> listLines();


    /**
     * 新增明细
     *
     * @param line 订单明细
     */
    void saveLine(Line line);


    /**
     * 根据 订单id 查询 所有订单明细
     *
     * @param id 订单id
     * @return 订单明细
     */
    List<Line> listLinesByOrderId(long id);
}
