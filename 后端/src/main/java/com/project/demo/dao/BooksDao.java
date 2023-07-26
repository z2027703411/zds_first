package com.project.demo.dao;


import com.project.demo.bean.Books;
import com.project.demo.bean.BooksType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksDao {
    //查询所有书籍或对应类型的书籍  pageStart:第几页开始    pageSize：每页最大的显示多少个
    public List<Books>getBooksList(@Param("typeId") Integer typeId,
                                   @Param("pageStart") Integer pageStart,
                                   @Param("pageSize") Integer pageSize,
                                   @Param("name") String name);
    //查询所有书籍的类型
    public List<BooksType> boosTypeList();
    //查询对应名字的书籍的数量，没有名字就是全部
    public int getBooksCounts(@Param("typeId") Integer typeId,@Param("name")String name);
    //修改图书状态方法
    public int updateBookState(@Param("id") Integer id,@Param("state") boolean state);
    //添加图书方法
    public int addBook(Books books);
   //删除图书方法
    public int deleteBook(@Param("id") Integer id);
   //修改图书信息
   public Books getUpdateBook(int id);//查出要修改的图书
   public int editBook(Books books);//修改图书信息
}
