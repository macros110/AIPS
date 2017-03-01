package net.mac.test;

import java.util.Calendar;

public class DaoImpl implements IDao {

	@Override
	public String sayHello(String name) {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour < 6) {
			return "�賿�ã�" + name;
		}
		if (hour < 12) {
			return "���Ϻã�" + name;
		}
		if (hour < 13) {
			return "����ã�" + name;
		}
		if (hour < 18) {
			return "����ã�" + name;
		}
		
		return "���Ϻã�" + name;
	}

}
