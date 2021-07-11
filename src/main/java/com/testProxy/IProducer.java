package com.testProxy;

/**
 * @ProjectName: Tryspring-boot
 * @Package: com.testProxy
 * @ClassName: IProductor
 * @Author: xbo
 * @Description: 对生产厂家要求的接口
 * @Date: 2021/3/31 15:46
 */
public interface IProducer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money);

    /**
     * 售后
     * @param money
     */
    public void afterService(float money);
}
