package com.kim.controller;

import com.kim.domain.BoardVO;
import com.kim.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/adminpost_insert.do")
    public String blogAdmin_category_insert(BoardVO vo){
        boardService.insertBoard(vo);
        System.out.println("---> 글 작성 완료");
        return "forward:/blogMainView.do";
    }

    @RequestMapping("/adminpost_update.do")
    public String blogAdmin_category_update(BoardVO vo){
        boardService.updateBoard(vo);
        System.out.println("---> 글 수정 완료");
        return "forward:/blogMainView.do";
    }

    @RequestMapping("/adminpostView_update.do")
    public String blogAdminView_category_update(BoardVO vo, Model model){
        model.addAttribute("postUpdate", boardService.getBoard(vo));
        return "forward:/adminPostView.do";
    }

    @RequestMapping("/adminpost_delete.do")
    public String blogAdmin_category_delete(BoardVO vo){
        boardService.deleteBoard(vo);
        System.out.println("---> 글 삭제 완료");
        return "forward:/blogMainView.do";
    }
}
