package lk.ijse.gdse.Entity;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data
public class CartTm {

   int borrowId;
   int BookId;
   String BookName;
   int MemberId;
   String MemberName;
   Date BorrowDate;
   Date DueDate;

}
