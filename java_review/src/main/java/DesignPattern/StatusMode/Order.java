package DesignPattern.StatusMode;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import static DesignPattern.StatusMode.OrderStateEnum.UNPAID;

/**
 * @author dongfeng
 * @since 2023-11-13 19:59
 */
public class Order {
    private String  orderId;
    private OrderStateEnum state;

    public Order(String orderId) {
        this.orderId = orderId;
        this.state=UNPAID;
    }

    /**
     * 只提供实现OrderState接口的类调用
     */
    public void setState(OrderStateEnum state) {
        this.state = state;
    }


    /**
     * 改变状态
     */
    public void nextState(){
        state.nextState(this);
    }


    /**
     * 打印日志
     */
    public void print() {
        System.out.println("orderId: " + orderId + ", state: " + state);
    }
}
