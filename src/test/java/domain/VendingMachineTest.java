package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자판기 객체 생성 관련 테스트")
public class VendingMachineTest {

    @Test
    void 자판기_생성(){
        VendingMachine vendingMachine = new VendingMachine();

        assertThat(vendingMachine).isNotNull();
    }
}
