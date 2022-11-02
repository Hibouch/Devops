package tn.esprit.rh.achat.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
@Slf4j
@RunWith(SpringRunner.class)

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StockServiceImplTest {
	@Autowired
 IStockService St;
	@Order(1)
  @Test
  
 void retrieveAllStocks() {
      List<Stock> listUsers = St.retrieveAllStocks();
      assertEquals(0, listUsers.size());
  }

  @Test
  void addStock() {
      Stock s1 = new Stock();
      s1.setLibelleStock("stock test");
      s1.setQte(10);
      s1.setQteMin(100);
      Stock savedStock1= St.addStock(s1);
      assertEquals(s1.getLibelleStock(), savedStock1.getLibelleStock());
  }

  @Test
  void deleteStock() {
      St.deleteStock(0L);
  }

  @Test
  void updateStock() {
      Stock s1= St.retrieveStock(0L);
      s1.setQte(100);
      Stock updatedStock1= St.updateStock(s1);
      assertEquals(s1.getQte(), updatedStock1.getQte());
  }

  @Test
  void retrieveStock() {
      St.retrieveStock(11L);
  }

  @Test
  void retrieveStatusStock() {
      St.retrieveStatusStock();
  }
}
