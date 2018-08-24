package tw.com.pai.dao.hibernate.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tw.com.pai.dao.hibernate.IStockHibernateDAO;
import tw.com.pai.model.Stock;
import tw.com.pai.utils.CustomHibernateDaoSupport;

@Repository
@Transactional("transactionManager")
public class StockDAOImpl extends CustomHibernateDaoSupport implements IStockHibernateDAO{

	@Override
	public void save(Stock stock) {
		getHibernateTemplate().save(stock);
	}

	@Override
	public void update(Stock stock) {
		getHibernateTemplate().update(stock);
	}

	@Override
	public void delete(Stock stock) {
		getHibernateTemplate().delete(stock);
	}

	@Override
	public Stock getByStockCode(String stockCode) {
		List list = getHibernateTemplate().find(
                "from Stock where stockCode=?",stockCode
           );
	return (Stock)list.get(0);
	}

}
