package ra.practicejsp_jstl_15112023.daoImpl;

import ra.practicejsp_jstl_15112023.dao.IDictionaryDao;
import ra.practicejsp_jstl_15112023.dao.IGenericDao;
import ra.practicejsp_jstl_15112023.model.Word;
import ra.practicejsp_jstl_15112023.util.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryDao implements IDictionaryDao {

    @Override
    public List<Word> findAll() {
        Connection conn = ConnectDB.getConnection();
        List<Word> list = new ArrayList<>();
        try {
            CallableStatement CallSt = conn.prepareCall("{call Find_All()}");
            ResultSet rs = CallSt.executeQuery();
            while (rs.next()){
                Word w = new Word();
                w.setName(rs.getString("name"));
                w.setImageUrl(rs.getString("image_url"));
                list.add(w);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return list;
    }

    @Override
    public boolean save(Word word) {
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement CallSt = conn.prepareCall("{call Insert_Word_Into_Dictionary(?,?)}");
            CallSt.setString(1,word.getName());
            CallSt.setString(2,word.getImageUrl());
            CallSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return true;
    }
}
