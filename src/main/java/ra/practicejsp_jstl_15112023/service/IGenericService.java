package ra.practicejsp_jstl_15112023.service;

import ra.practicejsp_jstl_15112023.model.Word;

import java.util.List;

public interface IGenericService <T, E>{

    List<Word> findAll();
    boolean save (T t);
}
