package Bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Bank.db.connection;
import Bank.model.Register;

public class registerDaoImpl implements registerDao {
	connection c=new connection();

	@Override
	public int createRecord(List<Register> reglst) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Register robj=reglst.get(0);
		int i=0;
		try {
			conn=c.getconnection();
			PreparedStatement pstate=conn.prepareStatement("insert into accountCrud values(?,?,?,?,?)");
			pstate.setInt(1,robj.getRegNo() );
			pstate.setString(2, robj.getCustName());
			pstate.setString(3, robj.getUsername());
			pstate.setString(4, robj.getPassword());
			pstate.setFloat(5, robj.getAccBal());
			i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return i;
	}

	@Override
	public List<Register> retrive(int regNo) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<Register> lst=null;
		try {
			conn=c.getconnection();
			PreparedStatement pstate=conn.prepareStatement("SELECT * FROM accountCrud where regNo=?");
			pstate.setInt(1, regNo);
			ResultSet result=pstate.executeQuery();
			if(result.next())
			{
				lst=new ArrayList<Register>();
				Register reg=new Register(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getFloat(5));
				lst.add(reg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return lst;
	}

	@Override
	public boolean Login(Register reg) {
		// TODO Auto-generated method stub
		boolean b=false;
		Connection conn=null;
		
		try {
			conn=c.getconnection();
			PreparedStatement pstate=conn.prepareStatement("SELECT * FROM accountCrud where username=? and password=?");
			pstate.setString(1, reg.getUsername());
			pstate.setString(2, reg.getPassword());
			ResultSet result=pstate.executeQuery();
			if(result.next())
			{
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return b;
	}

	@Override
	public int update(Register reg) {
		Connection conn=null;
		int i=0;
		List<Register> lst=null;
		try {
			conn=c.getconnection();
			PreparedStatement pstate=conn.prepareStatement("UPDATE accountCrud set accBal=? where regNo=?");
			pstate.setFloat(1, reg.getAccBal());
			pstate.setInt(2, reg.getRegNo());
			i=pstate.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		// TODO Auto-generated method stub
		return i;
	}

	@Override
	public int delete(int regNo) {
		Connection conn=null;
		int i=0;
		
		try {
			conn=c.getconnection();
			PreparedStatement pstate=conn.prepareStatement("delete from accountCrud  where regNo=?");
		
			pstate.setInt(1, regNo);
			i=pstate.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return i;
	}

	@Override
	public List<Register> list() {
		 Connection conn=null;
		 List<Register> lst=new LinkedList<Register>();;
	  try {
		  conn=c.getconnection();
		  String str="SELECT * from accountCrud";
		
		Statement state=conn.createStatement();
		ResultSet result=state.executeQuery(str);
		
		while(result.next())
		{
			Register reg=new Register(result.getInt(1),result.getString(2), result.getString(3), result.getString(4), result.getFloat(5));
			lst.add(reg);
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		return lst;
	}

}
