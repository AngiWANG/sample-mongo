package orders.db;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import orders.Order;

//混合自定义
public interface OrderRepository extends MongoRepository<Order, String>, OrderRepositoryCustom {

	// begin 自定义查询方法
	List<Order> findByCustomer(String customer);

	List<Order> findByCustomerLike(String customer);

	List<Order> findByCustomerAndType(String customer, String type);

	List<Order> getByType(String type);
	// end 自定义查询方法

	// begin 声明自定义查询
	@Query("{'customer':'Chuck Wagon','type':?0}")
	List<Order> findChucksOrders(String type);
	// end 声明自定义查询

}
