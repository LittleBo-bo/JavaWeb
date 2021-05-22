package com.cb.controller;

import com.cb.pojo.Books;
import com.cb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String QueryAll(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    @RequestMapping("/addBook")
    public String AddBook(Model model,Books books){
        bookService.insert(books);
        return "redirect:/book/allBook";
    }


    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id,Model model){
        Books books = bookService.queryById(id);
        System.out.println("bookService==>>"+books);
        model.addAttribute("QBooks",books);
        return "updateBook";
    }


    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        int i = bookService.update(books);
        if(i>0){
            System.out.println("修改书籍成功"+books);
        }
        return "redirect:/book/allBook";
    }

    //删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.delete(id);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/queryMoHu")
    public String queryMoHu(String bookName,Model model){

        List<Books> list = bookService.queryMoHu(bookName);
        if (list.size()==0){
            list = bookService.queryAllBook();
            model.addAttribute("error","查不到该书！");
        }
            model.addAttribute("list", list);
            return "allBook";

    }

    //登录界面
    @RequestMapping("/SystemIn")
    public String SystemIn(String name,String password){
        return "SystemIn";
    }




}
