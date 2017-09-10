import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

class JFCMVCAppTest{

	static class MainFrame extends JFrame{
	
		JTextField input = new JTextField();
		JTable view = new JTable();
		JScrollPane pane = new JScrollPane(view);

		public MainFrame(){
			super("Hello JFC");
			setSize(400, 400);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setUndecorated(true);
			rootPane.setWindowDecorationStyle(JRootPane.FRAME);
			add(input, BorderLayout.NORTH);
			add(pane);
			input.addActionListener(new OrderController());
		}

		class OrderEntry{
			
			int orderNo;
			java.sql.Date orderDate;
			int productNo;
			int quantity;

			public OrderEntry(ResultSet rs) throws SQLException{
				orderNo = rs.getInt("ord_no");
				orderDate = rs.getDate("ord_date");
				productNo = rs.getInt("pno");
				quantity = rs.getInt("qty");
			}
		}

		class OrderTableModel extends AbstractTableModel{
			
			ArrayList<OrderEntry> orders = 
				new ArrayList<OrderEntry>();

			public OrderTableModel(String customerId){
				try{
					Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@//localhost/xe",
						"scott", "tiger");
					try{
						PreparedStatement pstmt = con.prepareStatement(
							"select ord_no,ord_date,pno,qty from orders"
							+ " where cust_id=?");
						pstmt.setString(1, customerId);
						ResultSet rs = pstmt.executeQuery();
						while(rs.next())
							orders.add(new OrderEntry(rs));
						rs.close();
						pstmt.close();
					}finally{
						con.close();
					}
				}catch(Exception e){
					throw new RuntimeException(e);
				}
			}

			@Override
			public int getColumnCount(){return 4;}

			@Override
			public String getColumnName(int i){
				String[] names = {"Order No", "Order Date", 
					"Product No", "Quantity"};
				return names[i];
			}

			@Override
			public Class<?> getColumnClass(int i){
				Class<?>[] classes = {Integer.class, 
					java.sql.Date.class, Integer.class, Integer.class};
				return classes[i];
			}

			@Override
			public int getRowCount(){
				return orders.size();
			}

			@Override
			public Object getValueAt(int i, int j){
				OrderEntry entry = orders.get(i);
				switch(j){
					case 0: return entry.orderNo;
					case 1: return entry.orderDate;
					case 2: return entry.productNo;
					default: return entry.quantity;
				}
			}
		}

		class OrderController implements ActionListener{
			
			public void actionPerformed(ActionEvent ae){
				String customerId = input.getText();
				if(customerId.length() == 0) return;
				TableModel model = new OrderTableModel(customerId);
				pane.setVisible(false);
				view.setModel(model);
				pane.setVisible(true);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

}















