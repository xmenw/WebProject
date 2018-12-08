package com.qimo.ShopDao;

import com.qimo.DBUtil.ShopUpdate;
import com.qimo.entity.Shop;

public class UpdateShopDao {
	public static boolean insertDao(Shop shop) {
		String sql = "insert into shopcar values(?,?,?,?,?,?,?,?)";
		Object[] param = {shop.getId(), shop.getUsername(), shop.getPic(), shop.getDesc(), shop.getColor(), shop.getSize(), shop.getPrice(), shop.getNum()};
		boolean result = false;
		result = ShopUpdate.Update(sql, param);
		return result;
	}
	
	public static boolean deleteDao(int id) {
		String sql = "delete from shopcar where id = ?";
		Object[] param = {id};
		boolean result = false;
		result = ShopUpdate.Update(sql, param);
		return result;
	}
}
