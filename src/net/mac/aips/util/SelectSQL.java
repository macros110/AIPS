package net.mac.aips.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.sql.Delete;

import com.opensymphony.xwork2.Result;
import com.sun.jndi.cosnaming.CNCtx;

import javafx.beans.binding.StringBinding;

public class SelectSQL {
	public static ResultSet rs;
	public static StringTrans st;
	public static ConnDB connDB = new ConnDB();
	public static Collection getRet(){
		Collection ret = new ArrayList<>();
		try {
			ConnDB connDB = new ConnDB();
			String sql = "select * from tb_user";
			rs = connDB.executeQuery(sql);
			while(rs.next()){
				String account = rs.getString("account");
				String pwd = rs.getString("pwd");
				User user = new User();
				user.setAccount(account);
				user.setPwd(pwd);
				ret.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connDB.close();
		return ret;
	}
	public static int check(String account,String pwd){
		int i = 0;
		String accounts = "";
		String pwds = "";
		try {
			ConnDB connDB = new ConnDB();
			String sql = "select * from tb_user where account = '"+ account +"' and pwd ='"+ pwd +"'";
			System.out.println(sql);
			rs = connDB.executeQuery(sql);
			while (rs.next()) {
				accounts = rs.getString("account");
				pwds = rs.getString("pwd");
				if (accounts != null) {
					i = 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connDB.close();
		return i;
	}
	public int Insert(String title,String author,String news){
		int i = 0;
		try {
			ConnDB connDB = new ConnDB();
			String sql = "insert into tb_news (nws_title,nws_author,nws_content) values ('"
					+ title + "','" + author + "','" + news + "')";
			i = connDB.executeUpate(sql);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		connDB.close();
		return i;
	}
	public void Insert1(String title,String author,String news){
		try {
			ConnDB connDB = new ConnDB();
			String sql = "insert into tb_news (nws_title,nws_author,nws_content) values ('"
					+ title + "','" + author + "','" + news + "')";
			connDB.executeUpate(sql);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		connDB.close();
	}
	public Collection selectNewsAll(){
		Collection ret = new ArrayList<>();
		try {
			ConnDB connDB = new ConnDB();
			String sql = "select * from tb_news order by nws_id desc";
			ResultSet rs = connDB.executeQuery(sql);
			while(rs.next()){
				News news = new News();
				news.setNwsId(rs.getString("nws_id"));
				news.setNwsAuthor(rs.getString("nws_author"));
				news.setNwsContent(rs.getString("nws_content"));
				news.setNwsTitle(rs.getString("nws_title"));
				news.setNwsSubmittime(rs.getString("nws_submittime"));
				ret.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		connDB.close();
		return ret;
	}
	public Collection selectNews(String id){
		Collection ret = new ArrayList<>();
		try {
			ConnDB connDB = new ConnDB();
			String sql = "select * from tb_news where nws_id ='" + id + "'";
			ResultSet rs = connDB.executeQuery(sql);
			while(rs.next()){
				News news = new News();
				news.setNwsId(rs.getString("nws_id"));
				news.setNwsAuthor(rs.getString("nws_author"));
				news.setNwsContent(rs.getString("nws_content"));
				news.setNwsTitle(rs.getString("nws_title"));
				news.setNwsSubmittime(rs.getString("nws_submittime"));
				ret.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		connDB.close();
		return ret;
	}
	public Collection selectNews(){
		Collection ret = new ArrayList<>();
		try {
			ConnDB connDB = new ConnDB();
			String sql = "select * from tb_news order by nws_id desc limit 6";
			ResultSet rs = connDB.executeQuery(sql);
			while(rs.next()){
				News news = new News();
				news.setNwsId(rs.getString("nws_id"));
				news.setNwsAuthor(rs.getString("nws_author"));
				news.setNwsContent(rs.getString("nws_content"));
				news.setNwsTitle(rs.getString("nws_title"));
				news.setNwsSubmittime(rs.getString("nws_submittime"));
				ret.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		connDB.close();
		return ret;
	}
	public Collection selectMoreNewsFy(int page){
		Collection ret = new ArrayList<>();
		MoreNewsPage down = new MoreNewsPage();
		try {
			ConnDB connDB = new ConnDB();
			String sql = "select * from tb_news where nws_id not in (select id from tb_news order by nws_id limit "
					+ down.getPageSize() * page + ") order by nws_id limit 20";
			News news = new News();
			news.setNwsId(rs.getString("nws_id"));
			news.setNwsAuthor(rs.getString("nws_author"));
			news.setNwsContent(rs.getString("nws_content"));
			news.setNwsTitle(rs.getString("nws_title"));
			news.setNwsSubmittime(rs.getString("nws_submittime"));
			ret.add(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		connDB.close();
		return ret;
	}
	public Collection selectNewsFy(int page){
		Collection ret = new ArrayList<>();
		MoreNewsPage down = new MoreNewsPage();
		try {
			ConnDB connDB = new ConnDB();
			String sql = "select * from tb_news where nws_id not in (select id from tb_news order by nws_id limit "
					+ down.getPageSize() * page + ") order by nws_id limit 10";
			News news = new News();
			news.setNwsId(rs.getString("nws_id"));
			news.setNwsAuthor(rs.getString("nws_author"));
			news.setNwsContent(rs.getString("nws_content"));
			news.setNwsTitle(rs.getString("nws_title"));
			news.setNwsSubmittime(rs.getString("nws_submittime"));
			ret.add(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		connDB.close();
		return ret;
	}
	public Collection selectNewsForQyxw(int page){
		Collection ret = new ArrayList<>();
		MoreNewsPage down = new MoreNewsPage();
		try {
			ConnDB connDB = new ConnDB();
			String sql = "select * from tb_news order by nws_id limit 15";
			News news = new News();
			news.setNwsId(rs.getString("nws_id"));
			news.setNwsAuthor(rs.getString("nws_author"));
			news.setNwsContent(rs.getString("nws_content"));
			news.setNwsTitle(rs.getString("nws_title"));
			news.setNwsSubmittime(rs.getString("nws_submittime"));
			ret.add(news);
		} catch (Exception e) {
			e.printStackTrace();
		}
		connDB.close();
		return ret;
	}
	public int updateNews(String title,String content,String author,String id){
		int i = 0;
		try {
			ConnDB connDB = new ConnDB();
			String sql = "update tb_news set nws_title = '"+title+"',nws_content='"
					+content+"',nws_author='"+author+"',nws_id='"+id+"'";
			i = connDB.executeUpate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		connDB.close();
		return i;
	}
	public int delNews(String id){
		int i = 0;
		try {
			ConnDB connDB = new ConnDB();
			String sql = "Delete * from where nws_id='" + id + "'";
			i = connDB.executeUpate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public Collection selectBusinessAll(){
		Collection ret = new ArrayList<>();
		try {
			ConnDB connDB = new ConnDB();
			String sql = "select * from tb_business";
			ResultSet rs = connDB.executeQuery(sql);
			while(rs.next()){
				Product product = new Product();
				product.setBnsId(rs.getString("bns_id"));
				product.setBnsImg(rs.getString("bns_img"));
				product.setBnsCategory(rs.getString("bns_category"));
				product.setBnsDesc(rs.getString("bns_desc"));
				product.setBnsName(rs.getString("bns_name"));
				product.setBnsSubmittime(rs.getString("bns_submittiime"));
				ret.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		connDB.close();
		return ret;
	}
	public ResultSet selectBusiness(){
		ResultSet rs = null;
		try {
			ConnDB connDB = new ConnDB();
			String sql = "select * from tb_business";
			rs = connDB.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
}
