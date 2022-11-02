package tn.esprit.rh.achat.services;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
//@SpringBootTest
@Slf4j
public class StockServiceImplTest {
	@Mock
    StockRepository Stockrepository;

    @InjectMocks
    StockServiceImpl stockService;
    @Test
	public void testAddStock() {
	
		Stock s = new Stock("stock test",10,100);
		stockService.addStock(s);

	
		verify(Stockrepository, times(1)).save(s);

		System.out.println(s);
		log.info("add "+ s.toString());
		
	} 
    
    @Test
	public void testDeleteStock() {
		Stock s = new Stock("stock test",30,60);
		Stockrepository.save(s);
		stockService.deleteStock(s.getIdStock());
		verify(Stockrepository, times(1)).deleteById(s.getIdStock());
		log.info("delete ==>"+ s.toString());

	}
	@Test
	public void testUpdateStock() {
		//	List<Stock> stocks = stockService.retrieveAllStocks();
		//	int expected=stocks.size();
		Stock s = new Stock("stock test",10,100);
		when(Stockrepository.save(s)).thenReturn(s);
		assertNotNull(s);
		assertEquals(s, stockService.updateStock(s));
		log.info("update ==>"+ s.toString());
	}
	@Test
	public void TestRetrieveAllStocks()
	{
		List<Stock> Ls = new ArrayList<Stock>() {

			{

				add(new Stock("stock test",10,100));
				add(new Stock("stock test",10,100));
				add(new Stock("stock test",10,100));

			}};


		when(stockService.retrieveAllStocks()).thenReturn(Ls);
		//test
		List<Stock> StockList = stockService.retrieveAllStocks();
		assertEquals(3, StockList.size());
		log.info("retrieve all ==>"+ StockList.toString());

	}

	@Test
	public void TestretrieveStock(){
		Stock s = new Stock("stock test",10,100);
          s.setIdStock(1L);
		when(Stockrepository.findById(1L)).thenReturn(Optional.of(s));
		Stock stock= stockService.retrieveStock((long) 1);
		Assertions.assertNotNull(stock);
		log.info("get ==>"+ stock.toString());
	}
}
