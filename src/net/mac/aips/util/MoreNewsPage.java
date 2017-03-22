package net.mac.aips.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MoreNewsPage {
	int ttlPages = 1;
	int pageSize = 20;
	int currentPage = 1;
	ResultSet rs = null;
	int ttlRows;
	public int getTtlPages() {
		if(getRows() % getPageSize() == 0){
			return getRows()/getPageSize();
		}else{
			return getRows()/getPageSize() + 1;
		}		
	}
	public void setTtlPages(int ttlPages) {
		this.ttlPages = ttlPages;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRows() {
		ConnDB connDB = new ConnDB();
		String sql = "select count(*) from tb_news";
		rs = connDB.executeQuery(sql);
		try {
			if (rs.next()) {
				ttlRows = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ttlRows;
	}
}
