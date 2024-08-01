package lk.ijse.gdse.DAO.Impl;

import lk.ijse.gdse.DAO.BorrowTransDAO;
import lk.ijse.gdse.DAO.SQLUtil;
import lk.ijse.gdse.DTO.CartTmDTO;
import lk.ijse.gdse.Entity.BorrowingTransactions;
import lk.ijse.gdse.Entity.CartTm;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BarrowTransDAOImpl implements BorrowTransDAO {
    @Override
    public boolean save(BorrowingTransactions borrowingTransactions) throws SQLException {
        return SQLUtil.execute("INSERT INTO borrowing_transactions (transaction_id,book_id, member_id, borrow_date, due_date) VALUES (?,?, ?, ?, ?)",
                borrowingTransactions.getTransaction_id(),
                borrowingTransactions.getBook_id(),
                borrowingTransactions.getMember_id(),
                borrowingTransactions.getBorrow_date(),
                borrowingTransactions.getDue_date());
    }

    @Override
    public ArrayList<BorrowingTransactions> getAll() {
        return null;
    }

    @Override
    public int getCurrentId() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT transaction_id FROM borrowing_transactions ORDER BY transaction_id DESC LIMIT 1");
        if(rst.next()) {
            int borrowId = rst.getInt(1);
            return borrowId;
        }
        return 0;    }

    @Override
    public List<CartTm> getAllCart() throws SQLException {
ResultSet resultSet = SQLUtil.execute("SELECT \n" +
        "    bt.transaction_id,\n" +
        "    b.book_id ,\n" +
        "    b.title ,\n" +
        "    m.member_id ,\n" +
        "    m.name ,\n" +
        "    bt.borrow_date ,\n" +
        "    bt.due_date\n" +
        "FROM \n" +
        "    borrowing_transactions bt\n" +
        "JOIN \n" +
        "    books b ON bt.book_id = b.book_id\n" +
        "JOIN \n" +
        "    members m ON bt.member_id = m.member_id;\n");

    List<CartTm> cartList = new ArrayList<>();
    while(resultSet.next()){
        int borrowId = Integer.parseInt(resultSet.getString("transaction_id"));
        int bookId = Integer.parseInt(resultSet.getString("book_id"));
        String bookName = resultSet.getString("title");
        int memberId = Integer.parseInt(resultSet.getString("member_id"));
        String memberName = resultSet.getString("name");
        Date borrowDate = Date.valueOf(resultSet.getString("borrow_date"));
        Date dueDate = Date.valueOf(resultSet.getString("due_date"));

         cartList.add(new CartTm(borrowId,bookId,bookName,memberId,memberName,borrowDate,dueDate));
    }
    return cartList;
    }
}
