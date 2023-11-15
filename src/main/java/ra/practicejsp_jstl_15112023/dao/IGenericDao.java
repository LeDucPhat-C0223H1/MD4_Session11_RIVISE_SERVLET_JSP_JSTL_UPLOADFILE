package ra.practicejsp_jstl_15112023.dao;

import ra.practicejsp_jstl_15112023.model.Word;

import java.util.List;

public interface IGenericDao <T ,E>{
    List<Word> findAll();
    boolean save (T t);
}
