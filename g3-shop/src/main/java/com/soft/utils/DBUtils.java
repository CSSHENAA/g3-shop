package com.soft.utils;


import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.Date;
import java.util.*;

/**
 *工具类
 */
public class DBUtils
{
	private DBUtils(){

	}

	/**
	 * 返回数据库connection对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotFoundException
	 *
	 */
	public static Connection getConn() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException{
		// 加载资源文件
		Properties ps = new Properties();


		// 方法1:参照目录为工程根目录
		//ps.load(new FileInputStream("jdbc.properties"));

		// 方法2：参照目录为src目录（常用）
		ps.load(DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));

		// 方法3：参照目录为当前包目录通常不使用
		//ps.load(DBUtils.class.getResourceAsStream("jdbc.properties"));

		String drivername =(String) ps.get("drivername");
		String url =(String) ps.get("url");
		String username =(String) ps.get("username");
		String password =(String) ps.get("password");

		// 1、加载驱动
		Class.forName(drivername);
		// 2、获取连接
		Connection conn = DriverManager.getConnection(url,
				username, password);
		return conn;
	}

	/**
	 * 释放资源：
	 */
	public static void free(Connection conn,Statement ps,ResultSet rs){
		// 关闭连接 从下往上
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 增删改操作
	 *    delete from cqq_tb_manager_0505 where id=？
	 *
	 * @param sql
	 * @param objs
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 */
	public static int update(String sql,Object...objs) throws Exception{
		Connection conn = getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		int i = 1;
		for (Object obj : objs) {
			if(obj instanceof Date){
//				ps.setDate(i++, new java.sql.Date(((Date)obj).getTime()));
				long time = ((Date) obj).getTime();
				ps.setTimestamp(i++, new Timestamp((time)));

			}else{

				ps.setObject(i++, obj);
			}
		}
		int cnt = ps.executeUpdate();
		free(conn, ps, null);
		return cnt;
	}

	/**
	 * 查询处理（单表单条记录）
	 * @param sql select * from cqq_tb_manager where id=?
	 * @param cls    BackMemberService.class   javabean=BackMemberService
	 *
	 *
	 *                BackMemberService：属性和cqq_tb_manager表属性名完全一样 类型相匹配。其目的用于接收查询结果  一条记录--1个Manager对象
	 * @param objs 1
	 * @return   Account对象
	 * @throws Exception
	 */
	public static <T> T queryByObject(String sql,Class<T> cls,Object...objs) throws Exception{
		Connection conn = getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		int i = 1;
		for (Object obj : objs) {
			if(obj instanceof Date){
				ps.setDate(i++, new java.sql.Date(((Date)obj).getTime()));
			}else{
				ps.setObject(i++, obj);
			}
		}
		ResultSet rs = ps.executeQuery();// 执行结果


//		 cls:--->BackMemberService.class
		T t = cls.newInstance();// 获取类的对象  BackMemberService t= new BackMemberService()  无参构造方法
		Field[] flds = cls.getDeclaredFields(); // 获取Manager中所有属性  id  username  password.....


		if (rs.next()) {

			ResultSetMetaData rsm = rs.getMetaData();// 为了获取表中信息

			int cnt = rsm.getColumnCount(); // 获取表中所有列数 10  rs.getXXX(index)

			for (Field field : flds) {  // id
				field.setAccessible(true);// 把私有属性设置为可见  private修饰----设置公开化
				for (int j = 1; j <= cnt; j++) {
					String columnName = rsm.getColumnName(j);
					//System.out.println(columnName);
					if(columnName.equalsIgnoreCase(field.getName())){
//						System.out.println("field.getName()===:"+field.getName());
						field.set(t, convet(rs.getObject(columnName),field.getType() , rsm.getColumnType(j)));
						break;
					}
				}
			}
		}
		free(conn, ps, rs);
		return t;
	}


	/**
	 * 查询处理（多条记录）
	 * @param sql  select * from cqq_tb_manager
	 * @param cls 类对象  BackMemberService.class
	 * @param objs
	 * @return  List<BackMemberService>
	 * @throws Exception
	 */
	public static <T> List<T> queryForList(String sql,Class<T> cls,Object...objs) throws Exception{

		List<T> list = new ArrayList<T>();
		Connection conn = getConn();
		PreparedStatement ps = conn.prepareStatement(sql);
		int i = 1;
		for (Object obj : objs) {
			if(obj instanceof Date){
				ps.setDate(i++, new java.sql.Date(((Date)obj).getTime()));
			}else{
				ps.setObject(i++, obj);
			}
		}

		Field[] flds = cls.getDeclaredFields();
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			T t = cls.newInstance();
			ResultSetMetaData rsm = rs.getMetaData();
			int cnt = rsm.getColumnCount();

			for (Field field : flds) {
				field.setAccessible(true);
				for (int j = 1; j <= cnt; j++) {
					String columnName = rsm.getColumnName(j);
					if(columnName.equalsIgnoreCase(field.getName())){
//						System.out.println("field.getName()===:"+field.getName());
						field.set(t, convet(rs.getObject(columnName),field.getType() , rsm.getColumnType(j)));
						break;
					}
				}
			}

			list.add(t);
		}

		return list;
	}

	/**
	 * 查询单条记录，支持多表查询
	 *
	 *select t1.empno,t1.ename,t1.job,t2.deptno,t2.dname
	 * from cqq_tb_emp t1,cqq_tb_dept t2
	 * where t1.empno=? and t1.deptno=t2.deptno;
	 * @param sql
	 * @param objs
	 * @return
	 */
	public static Map<String,Object> queryForObject(String sql ,Object...objs) {
		Map<String,Object> map = new HashMap<>();
		Connection conn = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			//设置参数
			int i = 1;
			for (Object obj : objs) {
				if(obj instanceof Date) {
					java.sql.Date d = new java.sql.Date(((Date)obj).getTime());
					ps.setDate(i++, d);
				}else {
					ps.setObject(i++, obj);
				}
			}
			rs = ps.executeQuery();



			ResultSetMetaData metaData = rs.getMetaData();//获取数据库表信息

			int len = metaData.getColumnCount() ; // 获取当前结果集列数----username age  2个

			if (rs.next()) {

				// 2
				for(int k=1 ; k<=len ; k++) {
					String column = metaData.getColumnName(k) ;//username  age

					System.out.println("column:"+column);
					// map.put("username","zs")
					// map.put("age",15)
					map.put(column, convet(rs.getObject(column) , metaData.getColumnType(k))) ;
				}
				return map ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				free(conn, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map ;

	}

	/**
	 * 查询多条记录，支持多表查询
	 *select t1.empno,t1.ename,t1.job,t2.deptno,t2.dname
	 * from cqq_tb_emp t1,cqq_tb_dept t2
	 * where t1.empno=? and t1.deptno=t2.deptno;
	 * @param sql
	 * @param objs
	 * @return
	 */
	public static List<Map<String,Object>> queryForListMap(String sql ,Object...objs) {

		List<Map<String,Object>> list = new ArrayList<>();



		Connection conn = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			//设置参数
			int i = 1;
			for (Object obj : objs) {
				if(obj instanceof Date) {
					java.sql.Date d = new java.sql.Date(((Date)obj).getTime());
					ps.setDate(i++, d);
				}else {
					ps.setObject(i++, obj);
				}
			}
			rs = ps.executeQuery();



			ResultSetMetaData metaData = rs.getMetaData();//获取数据库表信息

			int len = metaData.getColumnCount() ; // 获取当前结果集列数----username age  2个

			while (rs.next()) {
				Map<String,Object> map = new HashMap<>();

				// 2
				for(int k=1 ; k<=len ; k++) {
					String column = metaData.getColumnName(k) ;//username  age
					System.out.println(column);
					if (column.equalsIgnoreCase("count(1)")){
						column="value";
					}
//
					if (column.equalsIgnoreCase("province")){
						column="name";
					}
					// map.put("username","zs")
					// map.put("age",15)
					map.put(column, convet(rs.getObject(column) , metaData.getColumnType(k))) ;
				}
				list.add(map)  ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				free(conn, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list ;

	}





	/**
	 * 查询一个字段，支持统计和获取主键等
	 * @param sql
	 * @param objs
	 * @return
	 */
	public static int queryForInt(String sql , Object...objs) {
		Connection conn = null ;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql) ;
			int i=1;
			for(Object obj : objs) {
				if(obj instanceof Date) {
					java.sql.Date d = new java.sql.Date(((Date)obj).getTime());
					ps.setDate(i++, d);
				}else {
					ps.setObject(i++, obj);//将传入的数据设置进sql语句的占位符
				}
			}
			//执行SQL
			rs= ps.executeQuery();

			if(rs.next()) {
				return rs.getInt(1) ;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				free(conn, ps, rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0 ;
	}

	/**
	 *
	 * map.put("id",1)
	 * 主要用于返回map对象时，对数据库类型进行判断，放置至map的value中
	 * @param val  数据库返回的值
	 * @param columnType  数据库字段的类型
	 * @return
	 */
	private static Object convet(Object val, int columnType) throws Exception{
		if(val==null) return null ;
		if(columnType ==Types.NUMERIC || columnType == Types.INTEGER) {
			return  Integer.parseInt(String.valueOf(val)) ;
		}
		if(columnType ==Types.NUMERIC || columnType == Types.BIT) {
			return  Byte.parseByte(String.valueOf(val)) ;
		}
		if((columnType ==Types.NUMERIC || columnType == Types.BIGINT)) {
			return  Long.parseLong(String.valueOf(val)) ;
		}
		if((columnType ==Types.NUMERIC || columnType == Types.FLOAT)) {
			return  Float.parseFloat(String.valueOf(val)) ;
		}

		if(columnType ==Types.NUMERIC || columnType == Types.DOUBLE|| columnType == Types.DECIMAL) {
			return  Double.parseDouble(String.valueOf(val)) ;
		}

		if(columnType == Types.VARCHAR || columnType ==Types.CHAR) {
			return  String.valueOf(val) ;
		}

		if(columnType == Types.DATE || columnType== Types.TIMESTAMP) {
			return val ;
		}
		/***
		 * 数据库中的Blob类型和java中 byte[] 是对应的
		 * 数据库中的Clob类型和 java中 String 是对应的
		 */
		if(columnType == Types.BLOB ) {
			Blob blob = (Blob) val ;
			InputStream in = blob.getBinaryStream();
			byte[] byteArray = IOUtils.toByteArray(in) ;
			return byteArray ;
		}

		if(columnType==Types.CLOB) {
			Clob clob = (Clob) val ;
			Reader reader = clob.getCharacterStream() ;
			char[] charArray = IOUtils.toCharArray(reader) ;
			return new String(charArray);
		}
		throw new Exception("暂不支持该数据类型，请检查数据库字段类型和属性的类型是否一致！！！");
	}

	/**
	 * 类型之间相互转化（根据java中属性类型以及数据库字段类型进行判断是否匹配，如果匹配则进行转换）
	 * @param val  数据库返回的值
	 * @param type   Java类中属性的类型
	 * @param columnType  数据库字段的类型
	 * @return  1：rs.getObject(columnName)：获取数据库值   2：类中属性类型(id--->Integer.class)  3:数据库中字段类型（number）
	 */
	private static Object convet(Object val, Class<?> type, int columnType) throws Exception{
		if(val==null) return null ;
		if((type==Integer.class || type==int.class) && (columnType ==Types.NUMERIC || columnType == Types.INTEGER|| columnType == Types.BIGINT)) {
			return  Integer.parseInt(String.valueOf(val)) ;
		}
		if((type==Byte.class || type==byte.class) && (columnType ==Types.NUMERIC || columnType == Types.BIT)) {
			return  Byte.parseByte(String.valueOf(val)) ;
		}
		if((type==Short.class || type==short.class) && (columnType ==Types.NUMERIC || columnType == Types.INTEGER)) {
			return  Short.parseShort(String.valueOf(val)) ;
		}
		if((type==Long.class || type==long.class) && (columnType ==Types.NUMERIC || columnType == Types.INTEGER)) {
			return  Long.parseLong(String.valueOf(val)) ;
		}
		if((type==Float.class || type==float.class) && (columnType ==Types.NUMERIC || columnType == Types.DOUBLE)) {
			return  Float.parseFloat(String.valueOf(val)) ;
		}
		if((type==Double.class || type==double.class) && (columnType ==Types.NUMERIC || columnType == Types.DOUBLE)) {
			return  Double.parseDouble(String.valueOf(val)) ;
		}
		if((type==char.class || type==Character.class) && (columnType ==Types.CHAR || columnType == Types.VARCHAR)) {
			return  String.valueOf(val).charAt(0) ;
		}
		if((type==Boolean.class || type==boolean.class) && (columnType == Types.VARCHAR)) {
			return  Boolean.parseBoolean(String.valueOf(val)) ;
		}

		if(type==String.class  && (columnType ==Types.CHAR ||columnType == Types.VARCHAR||columnType ==Types.LONGVARCHAR||columnType ==Types.LONGNVARCHAR)) {
			return  String.valueOf(val) ;
		}

		if((type==Date.class||type==Timestamp.class) && (columnType == Types.DATE || columnType== Types.TIMESTAMP)) {
			return val ;
		}
		/***
		 * 数据库中的Blob类型和java中 byte[] 是对应的
		 * 数据库中的Clob类型和 java中 String 是对应的
		 */

		// TODO: 2024/7/23
		if(columnType==Types.LONGVARBINARY&&type==byte[].class){
			byte[] byteArray= (byte[]) val;
			return byteArray;
		}

		if(columnType == Types.BLOB && type == byte[].class) {
			Blob blob = (Blob) val ;
			InputStream in = blob.getBinaryStream();
			byte[] byteArray = IOUtils.toByteArray(in) ;
			return byteArray ;
		}

		if(columnType==Types.CLOB && type == String.class) {
			Clob clob = (Clob) val ;
			Reader reader = clob.getCharacterStream() ;
			char[] charArray = IOUtils.toCharArray(reader) ;
			return new String(charArray);
		}
		throw new Exception("暂不支持该数据类型，请检查数据库字段类型和属性的类型是否一致！！！");
	}
}
