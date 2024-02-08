package in.sudha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sudha.entity.Stock;
import in.sudha.exception.StockNotFoundException;
import in.sudha.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockRepository repo;

	@Override
	public Long addStock(Stock stock) {
		return repo.save(stock).getId();
	}

	@Override
	public List<Stock> getAllStock() {
		return repo.findAll();
	}

	@Override
	public void updateStock(Stock stock) {
    if(stock.getId()!=null & repo.existsById(stock.getId())) {
    	repo.save(stock);
    }
	}

	@Override
	public Stock getOneStock(Long id) {
           Optional<Stock> opt = repo.findById(id);
           if(opt.isEmpty()) {
        	   throw new StockNotFoundException("Given '"+id+"'Not Exist");
           }else {
        	   return opt.get();
           }
		
	}

}
