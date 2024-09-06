package Bank.dao;

import java.util.List;

import Bank.model.Register;

public interface registerDao {
	   int createRecord(List<Register> reglst);
	   List<Register> retrive(int regNo);
	   boolean Login(Register reg);
	  int update(Register reg);
	  int delete(int accNo);
	   List<Register> list();

}
