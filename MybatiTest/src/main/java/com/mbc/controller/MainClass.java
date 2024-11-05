package com.mbc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainClass {

	public static void main(String[] args) {

		String resource = "com/mbc/controller/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

			System.out.println("sqlSessionFactory : " + sqlSessionFactory);

			SqlSession session = sqlSessionFactory.openSession();

			System.out.println("session : " + session);

			BoardDTO dto = new BoardDTO();

			BoardMapper mapper = session.getMapper(BoardMapper.class);

			/*
			 * int result = mapper.deleteBoard(5); // ����
			 * 
			 * dto = mapper.selectOne(5);//�ܰ� ��ȸ
			 * 
			 * List<BoardDTO> lists = mapper.selectAllList(); //��ü ��ȸ
			 */

			dto.setTitle("���̹�Ƽ��");
			dto.setContent("dsdsdd");
			dto.setNum(200);

			int result = mapper.updateBoard(dto);
			
			session.commit();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
