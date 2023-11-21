package DesignPattern.StatusMode;

/**
 * @author dongfeng
 * @since 2023-11-13 19:57
 */
public interface OrderState {
    void nextState(Order order);
}
