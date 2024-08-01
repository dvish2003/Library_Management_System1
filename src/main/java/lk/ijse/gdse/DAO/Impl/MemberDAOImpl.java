package lk.ijse.gdse.DAO.Impl;

import lk.ijse.gdse.DAO.MemberDAO;
import lk.ijse.gdse.DAO.SQLUtil;
import lk.ijse.gdse.Entity.Members;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public boolean save(Members members) throws SQLException {
        return SQLUtil.execute("INSERT INTO members VALUES(?,?,?,?,?,?,?,?)",members.getMemberId(),members.getName(),members.getEmail(),members.getPhoneNumber(),members.getAddress(),members.getDateOfBirth(),members.getJoinDate(),members.getMembershipType());
    }

    @Override
    public ArrayList<Members> getAll() throws SQLException {
        ArrayList<Members> members = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT*FROM members");
        while (rst.next()){
            Members member = new Members(
                    rst.getInt("member_id"),
                    rst.getString("name"),
                    rst.getString("email"),
                    rst.getString("phone_number"),
                    rst.getString("address"),
                    rst.getDate("date_of_birth"),
                    rst.getDate("join_date"),
                    rst.getString("membership_type")
            );
            members.add(member);
        }
        return members;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return SQLUtil.execute("DELETE FROM members WHERE member_id = ?",id);
    }

    @Override
    public boolean update(Members members) throws SQLException {
        return SQLUtil.execute("UPDATE members SET name = ? , email = ? , phone_number = ? , address = ?, date_of_birth = ?, join_date = ?, membership_type = ? WHERE member_id = ?",
                members.getName(),
                members.getEmail(),
                members.getPhoneNumber(),
                members.getAddress(),
                members.getDateOfBirth(),
                members.getJoinDate(),
                members.getMembershipType(),
                members.getMemberId())
                ;
    }

    @Override
    public Members searchByTel(String tel) throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM members WHERE phone_number = ?",tel +"");
        if(rst.next()){
            int member_id = rst.getInt("member_id");
            String name=rst.getString("name");
            String email=rst.getString("email");
            String phoneNumber=rst.getString("phone_number");
            String address=rst.getString("address");
            Date dateOfBirth= Date.valueOf(rst.getString("date_of_birth"));
            Date joinDate= Date.valueOf(rst.getString("join_date"));
            String membershipType=rst.getString("membership_type");
             return new Members(member_id,name,email,phoneNumber,address,dateOfBirth,joinDate,membershipType);

        }
return null;
      }

    @Override
    public List<String> getTel() throws SQLException {
        List<String> telList = new ArrayList<>();

        try (ResultSet rst = SQLUtil.execute("SELECT phone_number FROM members")) {
            while (rst.next()) {
                String tel = rst.getString("phone_number");
                telList.add(tel);
            }
        }
        return telList;
    }

    @Override
    public int getCurrentId() throws SQLException {
        ResultSet rst = SQLUtil.execute("SELECT member_id FROM members ORDER BY member_id DESC LIMIT 1");
        if(rst.next()) {
            int memberId = rst.getInt(1);
            return memberId;
        }
        return 0;
    }
}