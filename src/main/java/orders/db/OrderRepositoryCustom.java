package orders.db;

import java.util.List;

import orders.Order;

//混合自定义
public interface OrderRepositoryCustom {

	List<Order> findOrderByType(String type);

}
