package in.sudha.service;

import java.util.List;

import in.sudha.entity.Stock;

public interface StockService {
	
	Long addStock(Stock stock);
	List<Stock> getAllStock();
	void updateStock(Stock stock);
	Stock getOneStock(Long id);
	

}
