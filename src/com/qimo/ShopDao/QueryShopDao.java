package com.qimo.ShopDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.qimo.DBUtil.ShopQuery;
import com.qimo.entity.Shop;

public class QueryShopDao {
	public static List<Shop> setDao(int begin) {
		begin = (begin - 1) * 5;
		String sql = "select * from shopcar where username = ? limit "+ begin +",5";
		List<Shop> result = null;
		result = ShopQuery.Query(sql, null);
		return result;
	}
	
	public static int queryCount() {
		String sql = "select count(1) from shopcar";
		int  result = 0;
		result = ShopQuery.QueryCount(sql, null);
		return result;
	}
	
	public static int queryLast() {
		String sql = "select id from shopcar order by id DESC limit 1";
		int  result = 0;
		result = ShopQuery.QueryLastIndex(sql, null);
		return result;
	}
	
}
