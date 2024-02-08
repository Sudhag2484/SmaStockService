package in.sudha.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="STOCK_TBL")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stock_id_col")
	private Long id;
	@Column(name="stock_code_col")
	private String code;
	@Column(name="stock_desc_col")
	private String description;
	@Column(name="stock_cost_col")
	private Double costPerUnit;
	@Column(name="stock_lot_size_col")
	private Integer batchLotSize;
	@Column(name="stock_lot_max_col")
	private Integer maxLotsCust;
	@Column(name="stock_type_col")
	private String stockType;
	@Column(name="stock_cons_id_col")
	private String regConsumerId;
	@Column(name="stock_source_mode_col")
	private String sourceMode;
}
