package tw.com.pai.service;

import tw.com.pai.model.Stock;

public interface IStockService {

	void save(Stock stock);

	void update(Stock stock);

	void delete(Stock stock);

	Stock findByStockCode(String stockCode);
}
