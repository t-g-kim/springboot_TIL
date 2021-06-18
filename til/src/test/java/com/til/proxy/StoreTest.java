package com.til.proxy;

import org.testng.annotations.Test;

public class StoreTest {

    @Test
    public void testPay() {
        // Payment cashPerf = new Cash();
        Payment cashPerf = new CashPerf(); // CashPerf라는 프록시를 만들었다.
        Store store = new Store(cashPerf);
        store.buySonmething(100);
    }
}
