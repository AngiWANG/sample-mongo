package orders.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import orders.Order;

//混合自定义
public class OrderRepositoryImpl implements OrderRepositoryCustom {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Order> findOrderByType(String t) {
		String type = t.equals("NET") ? "WEB" : t;
		Criteria where = Criteria.where("type").is(type);
		Query query = Query.query(where);

		return mongoTemplate.find(query, Order.class);
	}

}
