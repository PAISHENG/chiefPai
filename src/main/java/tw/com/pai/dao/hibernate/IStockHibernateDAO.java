package tw.com.pai.dao.hibernate;

import tw.com.pai.model.Stock;


public interface IStockHibernateDAO {

	public void save(Stock stock);
	
	public void update(Stock stock);
	
	public void delete(Stock stock);
	
	public Stock getByStockCode(String stockCode);
	
	
}
