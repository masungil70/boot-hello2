package org.kosa.hello.board;

import java.util.List;

import org.kosa.hello.entity.BoardVO;
import org.kosa.hello.page.PageRequestVO;
import org.kosa.hello.page.PageResponseVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * MVC 
 * Model : B/L 로직을 구현하는 부분(service + dao)  
 * View  : 출력(jsp) 
 * Controller : model와 view에 대한 제어를 담당 
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {
	private final BoardMapper boardMapper;

    public PageResponseVO<BoardVO> getList(PageRequestVO pageRequestVO) {
    	List<BoardVO> list = boardMapper.getList(pageRequestVO);
        int total = boardMapper.getTotalCount(pageRequestVO);
        
        log.info("list {} ", list);
        log.info("total  = {} ", total);

        PageResponseVO<BoardVO> pageResponseVO = new PageResponseVO<BoardVO>(list, total, pageRequestVO.getSize(), pageRequestVO.getPageNo());

        return pageResponseVO;
	}
	
	public BoardVO view(BoardVO board)  {
		//view Count의 값을 증가한다. 
		//만약 값을 증가 하지 못하면 게시물이 존재하지 않는 경우임  
		if (0 == boardMapper.incViewCount(board)) {
			return null; 
		}
		//view Count의 값이 증가된 객체를 얻는다
		BoardVO resultVO = boardMapper.view(board);
		return resultVO;
	}
	
	public int delete(BoardVO board)  {
		return boardMapper.delete(board);
	}

	
	public BoardVO updateForm(BoardVO board)  {
		return boardMapper.view(board);
	}
	
	public int update(BoardVO board) {
		return boardMapper.update(board);
	}
	
	public int insert(BoardVO board)  {
		return boardMapper.insert(board);
	}
	
}











