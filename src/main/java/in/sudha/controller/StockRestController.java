package in.sudha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sudha.entity.Stock;
import in.sudha.exception.StockNotFoundException;
import in.sudha.service.StockService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/stock")
public class StockRestController {
	
	@Autowired
	private StockService service;
	
	@PostMapping("/add")
	public ResponseEntity<String> addStock(@RequestBody Stock stock){
		log.info("ENTERED INTO SAVE METHOD");
		ResponseEntity<String> resp=null;
		
		try {
			Long id = service.addStock(stock);
			resp=ResponseEntity.ok("CREATED WITH ID:"+id);
			
	          log.info("COMPANY IS CREATED {} .",id);

		}catch (StockNotFoundException e) {
		     log.error(e.getMessage());
			throw e;
		}
		
		log.info("ABOUT TO LEAVE SAVE METHOD");
		return resp;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Stock>> getAllStock(){
		log.info("ENTERED INTO FETCH METHOD");
		ResponseEntity<List<Stock>> resp=null;
		
		try {
			List<Stock> list = service.getAllStock();
			resp=ResponseEntity.ok(list);
	          log.info("FETCH METHOD IS SUCCESS");

		} catch (StockNotFoundException e) {
		     log.error(e.getMessage());
             throw e;
		}
		log.info("ABOUT TO LEAVE FETECH METHOD");
		return resp;
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Stock> getOneStock(@PathVariable Long id){
		log.info("ENTERED INTO ONE FETCH METHOD");
		
		ResponseEntity<Stock> resp=null;
		try {
			Stock stock = service.getOneStock(id);
			resp= ResponseEntity.ok(stock);
	          log.info("ONE FETCH METHOD IS SUCCESS");

		}catch (StockNotFoundException e) {
			//e.printStackTrace();
		     log.error(e.getMessage());
		     throw e;

		}
		log.info("ABOUT TO LEAVE ONE FETECH METHOD");
		return resp;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateStock(@RequestBody Stock stock){
		log.info("ENTERED INTO UPDATE METHOD");
		ResponseEntity<String> resp=null;
		
		try {
			service.updateStock(stock);
			resp=ResponseEntity.ok("UPDATED STOCK :");
			
	          log.info("STOCK IS UPDATED {} .");

		}catch (StockNotFoundException e) {
		     log.error(e.getMessage());
			throw e;
		}
		
		log.info("ABOUT TO LEAVE UPDATE METHOD");
		return resp;
	}
}
