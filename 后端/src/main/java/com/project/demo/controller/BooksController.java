package com.project.demo.controller;

import com.project.demo.bean.Books;
import com.project.demo.bean.BooksType;
import com.project.demo.dao.BooksDao;
import com.project.demo.util.AjaxResult;
import com.project.demo.util.QueryInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class BooksController {

    @Autowired
    BooksDao booksDao;

    //所有图书的方法（分页）
    @RequestMapping("/getBooksList")
    public AjaxResult getBooksList(@RequestBody QueryInfo queryInfo){
        System.out.println("queryInfo："+queryInfo);
        int typeId=Integer.valueOf(queryInfo.getQuery());
        int pageStart=(queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        int pageSize=queryInfo.getPageSize();
        System.out.println("typeId:"+typeId+","+"pageStart:"+pageStart+","+"pageSize:"+pageSize);
        List<Books> booksList = booksDao.getBooksList(typeId,pageStart,pageSize,queryInfo.getName());

        /**这里要查书的总数start)**/
        HashMap<String,Object>hashMap=new HashMap<>();
        hashMap.put("booksList",booksList);
        int numbers = booksDao.getBooksCounts(typeId,queryInfo.getName());
        hashMap.put("numbers",numbers);
        /**这里要查书的总数（over）**/

        return AjaxResult.result("200","success",hashMap);
    }

    //所有图书类型的方法
    @RequestMapping("/getBooksListType")
    public AjaxResult getBooksListType(){
        List<BooksType>list = booksDao.boosTypeList();
        return AjaxResult.result("200","success",list);
    }

    //修改图书状态方法
    @RequestMapping("/updateBookState")
    public AjaxResult updateBookState(@RequestParam("id") Integer id,
                                      @RequestParam("state") boolean state){
        int i = booksDao.updateBookState(id,state);
        if(i>0) {
            return AjaxResult.result("200","success",null);
        }else{
            return AjaxResult.result("404","fail",null);
        }
    }

    //添加图书方法
    @RequestMapping("/addBook")
    public AjaxResult addBook(@RequestBody Books books){
        books.setAddTime(new Date());
        books.setState(false);//默认不上架
        int i = booksDao.addBook(books);
        if(i!=0){
            return AjaxResult.result("200","success",books.getId());
        }else{
            return AjaxResult.result("404","fail",null);
        }
    }

    //删除图书方法
    @RequestMapping("/deleteBook")
    public AjaxResult deleteBook(Integer id){
        int i = booksDao.deleteBook(id);
        return i>0?AjaxResult.result("200","删除成功",null)
               :AjaxResult.result("404","删除失败",null);
    }

    //获取当前要修改图书信息
    @RequestMapping("/getUpdateBookById")
    public AjaxResult getUpdateBook(int id){
        Books book = booksDao.getUpdateBook(id);
        System.out.println("啦啦啦："+book);
        return AjaxResult.result("200","操作成功",book);
    }
    //修改当前图书信息
    @RequestMapping("/editBook")
    public AjaxResult editBook(@RequestBody Books books){
        System.out.println("输出books："+books);
        int i = booksDao.editBook(books);
        return i>0?AjaxResult.result("200","修改成功",null)
                :AjaxResult.result("404","修改失败",null);
    }

}
