package com.module.user.service.impl;

import com.module.user.dao.GoodsInfoMapper;
import com.module.user.dao.GoodsSkuMapper;
import com.module.user.model.GoodsInfo;
import com.module.user.model.GoodsSku;
import com.module.user.service.GoodsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;

    public int addGoods(GoodsInfo model) {
        return this.goodsInfoMapper.insert(model);
    }

    public List<GoodsInfo> getGoodsList(Integer categoryId, Integer pageNo) {
        Map map = new HashMap();
        map.put("categoryId", categoryId);
        map.put("beginIndex", Integer.valueOf((pageNo.intValue() - 1) * 6));
        map.put("pageSize", Integer.valueOf(6));
        return this.goodsInfoMapper.selectGoodsList(map);
    }

    public List<GoodsInfo> getAllGoodsList(Integer categoryId) {
        return this.goodsInfoMapper.selectAllGoodsList(categoryId);
    }

    public GoodsInfo getGoodsDetail(Integer goodsId) {
        return this.goodsInfoMapper.selectByPrimaryKey(goodsId);
    }

    public int addGoodsSku(GoodsSku model) {
        return this.goodsSkuMapper.insert(model);
    }

    public List<GoodsSku> getGoodsSkuList(Integer goodsId) {
        return this.goodsSkuMapper.selectGoodsSkuList(goodsId);
    }

    public void modifyGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfoMapper.updateByPrimaryKey(goodsInfo);
    }

    public List<GoodsInfo> getGoodsListByKeyword(String keyword, Integer pageNo) {
        Map map = new HashMap();
        map.put("keyword", keyword);
        map.put("beginIndex", Integer.valueOf((pageNo.intValue() - 1) * 6));
        map.put("pageSize", Integer.valueOf(6));
        return this.goodsInfoMapper.selectGoodsListByKeyword(map);
    }

    public List<GoodsInfo> getAllByKeyword(String keyword) {
        return this.goodsInfoMapper.selectAllByKeyword(keyword);
    }
}
