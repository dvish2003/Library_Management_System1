package lk.ijse.gdse.BO;

import lk.ijse.gdse.DTO.BorrowingTransactionsDTO;
import lk.ijse.gdse.DTO.CartTmDTO;
import lk.ijse.gdse.Entity.BorrowingTransactions;
import lk.ijse.gdse.Entity.CartTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface BarrowTransBO {
    public boolean save(BorrowingTransactionsDTO borrowingTransactionsDTO) throws SQLException;
    public ArrayList<BorrowingTransactionsDTO> getAll();
    public int getCurrentId() throws SQLException;
    public List<CartTmDTO> getAllCart() throws SQLException;

}
