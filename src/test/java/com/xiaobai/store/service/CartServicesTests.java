package com.xiaobai.store.service;

import com.xiaobai.store.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServicesTests {
    @Autowired
    private ICartServices cartService;

    @Test
    public void getVOByCids() {
        Integer[] cids = {1, 2, 3, 4, 5, 6};
        Integer uid = 10;
        List<CartVO> list = cartService.findCartVoByCid(cids, uid);
        System.out.println("count=" + list.size());
        for (CartVO item : list) {
            System.out.println(item);
        }
    }
}
