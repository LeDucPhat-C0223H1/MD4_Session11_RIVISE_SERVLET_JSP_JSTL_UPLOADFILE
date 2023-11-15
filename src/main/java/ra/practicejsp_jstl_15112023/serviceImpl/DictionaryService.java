package ra.practicejsp_jstl_15112023.serviceImpl;

import ra.practicejsp_jstl_15112023.dao.IDictionaryDao;
import ra.practicejsp_jstl_15112023.daoImpl.DictionaryDao;
import ra.practicejsp_jstl_15112023.model.Word;
import ra.practicejsp_jstl_15112023.service.IDictionaryService;

import java.util.List;

public class DictionaryService implements IDictionaryService {

    private IDictionaryDao dictionaryDao = new DictionaryDao();

    @Override
    public List<Word> findAll() {
        return dictionaryDao.findAll();
    }

    @Override
    public boolean save(Word word) {
        return dictionaryDao.save(word);
    }
}
