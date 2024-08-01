package lk.ijse.gdse.DTO;

import lombok.*;

import java.sql.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data
public class CartTmDTO {

   int borrowId;
   int BookId;
   String BookName;
   int MemberId;
   String MemberName;
   Date BorrowDate;
   Date DueDate;

}
