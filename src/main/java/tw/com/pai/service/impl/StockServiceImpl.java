package tw.com.pai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.pai.dao.hibernate.IStockHibernateDAO;
import tw.com.pai.model.Stock;
import tw.com.pai.service.IStockService;

@Service

public class StockServiceImpl implements IStockService{

	@Autowired
	private IStockHibernateDAO stockHDao;
	
	
	@Override
	public void save(Stock stock) {
		stockHDao.save(stock);
	}

	@Override
	public void update(Stock stock) {
		stockHDao.update(stock);
	}

	@Override
	public void delete(Stock stock) {
		stockHDao.delete(stock);
	}

	@Override
	public Stock findByStockCode(String stockCode) {
		return stockHDao.getByStockCode(stockCode);
	}

}
