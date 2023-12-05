package hcmute.springbootdemo.Service.impl;

import hcmute.springbootdemo.Entity.Order;
import hcmute.springbootdemo.Repository.OrderRepository;
import hcmute.springbootdemo.Service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderRepository orderRepository;
	
	@Override
	public List<Order> findTop10NewestOrder() {
		return orderRepository.findTop10NewestOrder();
	}

	@Override
	public List<Order> findByOrderDateBetween(Date startDate, Date endDate) {
		return orderRepository.findByOrderDateBetween(startDate, endDate);
	}

	@Override
	public <S extends Order> S save(S entity) {
		return orderRepository.save(entity);
	}

	@Override
	public List<Order> findOrdersByUserId(int userId) {
		return orderRepository.findOrdersByUserId(userId);
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> findById(Integer id) {
		return orderRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return orderRepository.existsById(id);
	}

	@Override
	public <S extends Order> boolean exists(Example<S> example) {
		return orderRepository.exists(example);
	}

	@Override
	public long count() {
		return orderRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		orderRepository.deleteById(id);
	}

	@Override
	public void delete(Order entity) {
		orderRepository.delete(entity);
	}

    
}
