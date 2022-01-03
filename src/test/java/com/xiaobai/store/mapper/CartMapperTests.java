package com.xiaobai.store.mapper;

import com.xiaobai.store.entity.Cart;
import com.xiaobai.store.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTests {
    @Autowired
    private CartMapper cartMapperTests;

    @Test
    public void findCartByCid() {
        Integer cid = 8;
        Cart result = cartMapperTests.findCartByCid(cid);
        System.out.println(result);
    }

    @Test
    public void findVOByCids() {
        Integer[] cids = {1, 2, 3, 4, 5, 6, 7};
        List<CartVO> list = cartMapperTests.findCartVoByCid(cids);
        System.out.println("count=" + list.size());
        for (CartVO item : list) {
            System.out.println(item);
        }
    }

}
