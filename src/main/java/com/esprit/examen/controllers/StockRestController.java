package com.esprit.examen.controllers;



import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.services.IStockService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Gestion des stocks")
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockRestController {

	private final IStockService stockService;

	@GetMapping("/retrieve-all-stocks")
	public List<Stock> getStocks() {
		return stockService.retrieveAllStocks();
	}

	@GetMapping("/{stock-id}")
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
	}

	@PostMapping
	public Stock addStock(@RequestBody Stock s) {
		Stock stock = stockService.addStock(s);
		return stock;
	}

	@DeleteMapping("/{stock-id}")
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockService.deleteStock(stockId);
	}

	@PutMapping
	public Stock modifyStock(@RequestBody Stock stock) {
		return stockService.updateStock(stock);
	}

	/*
	 * Spring Scheduler : Comparer QteMin tolérée (à ne pa dépasser) avec
	 * Quantité du stock et afficher sur console la liste des produits inférieur
	 * au stock La fct schédulé doit obligatoirement etre sans paramètres et
	 * sans retour (void)
	 */
	// http://localhost:8089/SpringMVC/stock/retrieveStatusStock
	// @Scheduled(fixedRate = 60000)
	// @Scheduled(fixedDelay = 60000)
	//@Scheduled(cron = "*/60 * * * * *")
	//@GetMapping("/retrieveStatusStock")
//	@ResponseBody
//	public void retrieveStatusStock() {
//		stockService.retrieveStatusStock();
//	}

}