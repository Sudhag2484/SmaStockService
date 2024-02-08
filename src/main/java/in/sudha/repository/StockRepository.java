package in.sudha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sudha.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{

}
