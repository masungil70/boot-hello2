package org.kosa.hello.code;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosa.hello.entity.CodeVO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CodeMapper {

	List<CodeVO> getList();
}
