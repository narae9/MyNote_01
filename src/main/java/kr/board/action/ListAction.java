package kr.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.board.dao.BoardDAO;
import kr.board.vo.BoardVO;
import kr.controller.Action;
import kr.util.PagingUtil;

public class ListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) pageNum = "1";
		
		BoardDAO dao = BoardDAO.getInstance();
		int count = dao.getCount();
		
		//페이지 처리
		//currentPage,count,rowCount,pageCount,pageUrl
		PagingUtil util = 
				new PagingUtil(Integer.parseInt(pageNum),
						count,20,10,"list.do");
		
		List<BoardVO> list = null;
		if(count > 0) {
			list = dao.getList(util.getStartRow(), 
					           util.getEndRow());
		}
		
		//데이터를 request에 저장
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("page", util.getPage());
		
		//JSP 경로 반환
		return "/WEB-INF/views/list.jsp";
	}

}
