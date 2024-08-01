package lk.ijse.gdse.DAO;

import lk.ijse.gdse.DAO.Impl.*;

public class DAOFactory implements SuperDAO {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        MEMBER,BOOKS,BOOK_CATEGORIES,BORROWING_TRANSACTIONS
    }
    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case MEMBER:
                return new MemberDAOImpl();
            case BOOKS:
                return new BooksDAOImpl();
            case BOOK_CATEGORIES:
                return new BookCategoryDAOImpl();
            default:
                return null;
        }
    }

}
