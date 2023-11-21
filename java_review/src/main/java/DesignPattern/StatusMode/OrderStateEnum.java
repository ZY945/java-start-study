package DesignPattern.StatusMode;

/**
 * @author dongfeng
 * @since 2023-11-13 20:00
 */
public enum OrderStateEnum implements OrderState {
    /**
     * 未支付
     */
    UNPAID {
        @Override
        public void nextState(Order order) {
            order.setState(PAID);
        }
    },
    /**
     * 支付成功
     */
    PAID {
        @Override
        public void nextState(Order order) {
            order.setState(DELIVERING);
        }
    },
    /**
     * 进行中
     */
    DELIVERING {
        @Override
        public void nextState(Order order) {
            order.setState(DONE);
        }
    },

    /**
     * 已完成
     */
    DONE {
        @Override
        public void nextState(Order order) {
//            order.setState(DONE);
        }
    }

}
