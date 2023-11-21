package DesignPattern.StatusMode;

/**
 * @author dongfeng
 * @since 2023-11-13 20:49
 */
public class OrderService {
    public static void main(String[] args) {
        Order order = new Order("1");
        // 初始订单状态,提示未支付
        order.print();
        // 支付成功,更改状态
        // ...
        order.nextState();
        order.print();
        // 邮件配送生成,更改状态
        // ...
        order.nextState();
        order.print();
        // 货物送达,更改状态
        // ...
        order.nextState();
        order.print();
    }
}
