package com.zen.hardwarechallengebackend.hardware.bill.usecases;

import com.zen.hardwarechallengebackend.hardware.bill.dto.BillDTO;
import com.zen.hardwarechallengebackend.hardware.bill.entity.ProductSold;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class PostBillUseCaseTest {

    @MockBean
    PostBillUseCase useCase;


    @Test
    void shouldSaveProvider() {
        ProductSold productSold1 = new ProductSold();
        productSold1.setId("1");
        productSold1.setPrice(50);
        productSold1.setName("table");
        productSold1.setAmount(4);
        ProductSold productSold2 = new ProductSold();
        productSold2.setId("1");
        productSold2.setPrice(50);
        productSold2.setName("table");
        productSold2.setAmount(4);

        BillDTO billDTO = new BillDTO();
        billDTO.setId("testID");
        billDTO.setDate(LocalDate.now());
        billDTO.setCustomer("Mario");
        billDTO.setSeller("Raul");
        billDTO.setProductsSold(List.of(productSold1, productSold2));
        billDTO.setTotal(1000);



        StepVerifier
                .create(Mono.just(Mockito.when(useCase.apply(billDTO))
                        .thenReturn(Mono.just(billDTO)))).expectNextCount(1).expectComplete().verify();


    }

}