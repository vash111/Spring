package org.zerock.Mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("select sysdate from dual")
	public String getTime();
	
	public String getTime2();
}
