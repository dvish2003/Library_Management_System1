package lk.ijse.gdse.DAO;

import lk.ijse.gdse.DTO.CartTmDTO;
import lk.ijse.gdse.Entity.BorrowingTransactions;
import lk.ijse.gdse.Entity.CartTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public interface BorrowTransDAO {
    public boolean save(BorrowingTransactions borrowingTransactions) throws SQLException;
    public ArrayList<BorrowingTransactions> getAll();
    public int getCurrentId() throws SQLException;
    public List<CartTm> getAllCart() throws SQLException;


}
