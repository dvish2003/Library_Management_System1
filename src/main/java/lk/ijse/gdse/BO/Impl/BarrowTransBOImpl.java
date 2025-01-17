package lk.ijse.gdse.BO.Impl;

import lk.ijse.gdse.BO.BarrowTransBO;
import lk.ijse.gdse.DAO.BorrowTransDAO;
import lk.ijse.gdse.DAO.Impl.BarrowTransDAOImpl;
import lk.ijse.gdse.DTO.BorrowingTransactionsDTO;
import lk.ijse.gdse.DTO.CartTmDTO;
import lk.ijse.gdse.Entity.BorrowingTransactions;
import lk.ijse.gdse.Entity.CartTm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BarrowTransBOImpl implements BarrowTransBO {

    BorrowTransDAO borrowTransDAO = new BarrowTransDAOImpl();

    @Override
    public boolean save(BorrowingTransactionsDTO borrowingTransactionsDTO) throws SQLException {
        return borrowTransDAO.save(new BorrowingTransactions(
                borrowingTransactionsDTO.getTransaction_id(),
                borrowingTransactionsDTO.getBook_id(),
                borrowingTransactionsDTO.getMember_id(),
                borrowingTransactionsDTO.getBorrow_date(),
                borrowingTransactionsDTO.getDue_date()));
    }

    @Override
    public ArrayList<BorrowingTransactionsDTO> getAll() {
        return null;
    }

    @Override
    public int getCurrentId() throws SQLException {
        return borrowTransDAO.getCurrentId();
    }

    @Override
    public List<CartTmDTO> getAllCart() throws SQLException {
List <CartTm> list = borrowTransDAO.getAllCart();
    List<CartTmDTO> cartTmDTOS = new ArrayList<>();
    for (CartTm cartTm : list) {
    cartTmDTOS.add(new CartTmDTO( cartTm.getBorrowId(),
            cartTm.getBookId(),
            cartTm.getBookName(),
            cartTm.getMemberId(),
            cartTm.getMemberName(),
            cartTm.getBorrowDate(),
            cartTm.getDueDate()));
    }
    return cartTmDTOS;
    }
}
