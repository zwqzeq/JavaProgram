/*
 * MainPage.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.User;
import dao.DbUtil;
import dao.UserDao;


public class MainPage extends javax.swing.JFrame {
	
	private javax.swing.JTextField addTelTxt;
	private javax.swing.JTextField addUserNameTxt;
	private javax.swing.JTextField addStudentIDTxt;
	private javax.swing.JTextField addsexTxt;
	
	private javax.swing.JTextField modifyTelTxt;
	private javax.swing.JTextField modifyUserNameTxt;
	private javax.swing.JTextField modifyStudent_IDTxt;
	private javax.swing.JTextField modifysexTxt;
	
	private javax.swing.JTextField searchUserNameTxt;

	
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;

	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	
	private javax.swing.JScrollPane jScrollPane1;
	
	private javax.swing.JTable userTable;
	
	String [] facultyStrings = {"计算机系","外语系","化学系","日语系","物电系"};
	
	DbUtil dbUtil = new DbUtil();
	UserDao userDao = new UserDao();
	int num=0;
	
		
	/** Creates new form MainPage */
	public MainPage() {
		initComponents();
		this.fillTable(new User());
	}

	
	private void fillTable(User user) {
		DefaultTableModel dtm = (DefaultTableModel) userTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = userDao.getUsers(user, con);
			while (rs.next()) {
				Vector v = new Vector();				
				v.add(rs.getString("name"));
				v.add(rs.getString("faculty"));
				v.add(rs.getString("student_id"));
				v.add(rs.getString("sex"));
				dtm.addRow(v);
			    num = dtm.getColumnCount();	
			}
			if (num == 0 || num < 0) {
				JOptionPane.showMessageDialog(null, "查询失败！！！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		addUserNameTxt = new javax.swing.JTextField();	
	
		jLabel2 = new javax.swing.JLabel();	
		addTelTxt = new javax.swing.JTextField();
			
		jLabel6 = new javax.swing.JLabel();
		addStudentIDTxt = new javax.swing.JTextField();
		
		jLabel8 = new javax.swing.JLabel();
		addsexTxt = new javax.swing.JTextField();
		
		
		jLabel7 = new javax.swing.JLabel();
		modifyStudent_IDTxt = new javax.swing.JTextField();
		
		jLabel9 = new javax.swing.JLabel();
		modifysexTxt = new javax.swing.JTextField();
		
		
		jLabel3 = new javax.swing.JLabel();
		searchUserNameTxt = new javax.swing.JTextField();
		
		jLabel4 = new javax.swing.JLabel();
		modifyUserNameTxt = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();	
		modifyTelTxt = new javax.swing.JTextField();
		
		
		jButton1 = new javax.swing.JButton();	
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		userTable = new javax.swing.JTable();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("StudentTable");

		jLabel1.setText("Name");

		jLabel2.setText("Faculty");
	
		jLabel6.setText("Student_ID");//添加
		jLabel7.setText("Student_ID");//修改
		jLabel8.setText("sex");//添加
		jLabel9.setText("sex");//修改
		

		jButton1.setText("Add");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel3.setText("SelectName");
		jButton2.setText("Select");
		
		
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

userTable
	.setModel(
				new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null , null , null}, { null , null, null , null}, { null, null , null, null}, {  null , null, null, null },
						{ null, null , null, null}, { null , null , null, null}, { null,  null , null, null} },
								new String[] { "name", "faculty","student_id","sex"}) {
							Class[] types = new Class[] {java.lang.String.class,java.lang.String.class, java.lang.String.class ,java.lang.String.class};

							public Class getColumnClass(int columnIndex) {
								return types[columnIndex];
							}
						});
		userTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				userTableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(userTable);

		
		jLabel4.setText("Name");
		jLabel5.setText("Faculty");
		jButton3.setText("Update");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("Delete");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
										layout.createSequentialGroup()
					
										
										.addComponent(jLabel4).addGap(18, 18, 18)
												.addComponent(modifyUserNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
														92, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												
												
										.addComponent(jLabel5).addGap(18, 18, 18)
												.addComponent(modifyTelTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												
										.addComponent(jLabel7).addGap(18, 18, 18)
												.addComponent(modifyStudent_IDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												
										.addComponent(jLabel9).addGap(18, 18, 18)
												.addComponent(modifysexTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												
												
												
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jButton3)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jButton4).addContainerGap())
								
								.addGroup(layout.createSequentialGroup()
										.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458,
												Short.MAX_VALUE)
										.addContainerGap())
								.addGroup(layout.createSequentialGroup().addGroup(layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel3)
												.addGap(18, 18, 18).addComponent(searchUserNameTxt,
														javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
												
												
												
												
												.addComponent(jLabel1)
												.addGap(18, 18, 18)
												.addComponent(addUserNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 97,
														Short.MAX_VALUE)
												.addGap(18, 18, 18)
												
												.addComponent(jLabel2)))
										        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
														.addComponent(addTelTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
																132, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(29, 29, 29)
														
				
												.addComponent(jLabel6)))
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
												.addComponent(addStudentIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE,132, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(29, 29, 29)		
														
												.addComponent(jLabel8)))
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
												.addComponent(addsexTxt, javax.swing.GroupLayout.PREFERRED_SIZE,132, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(29, 29, 29)		
																	
														 
														
														.addComponent(jButton1))
												.addGroup(layout.createSequentialGroup().addGap(31, 31, 31)
														
														
														.addComponent(jButton2)))
										.addGap(53, 53, 53)))));
		
		
		
		
		
		
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								
								
								.addComponent(jLabel1)
								.addComponent(jLabel2)
								.addComponent(jLabel6)
								.addComponent(jLabel8)
								
								.addComponent(addUserNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addTelTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								
								.addComponent(addStudentIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(addsexTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								
								
								
								
								.addComponent(jButton1))
						.addGap(29, 29, 29)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel3)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(searchUserNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jButton2)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(26, 26, 26)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(jLabel5)
								.addComponent(jLabel7)
								.addComponent(jLabel9)

								
								.addComponent(modifyUserNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(modifyTelTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(modifyStudent_IDTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(modifysexTxt, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								
								
								
								
								.addComponent(jButton4).addComponent(jButton3))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
		// GEN-END:initComponents

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		String name = modifyUserNameTxt.getText();
		String faculty = modifyTelTxt.getText();
		String Student_id = modifyStudent_IDTxt.getText();
		
		String sex = modifysexTxt.getText();

		User user = new User(name, faculty,Student_id,sex);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			
			if(name.equals("")){
				JOptionPane.showMessageDialog(null, "请输入姓名！");
				return;

			}
			
			
			int flag = userDao.delete(user, con);
			if (flag > 1 || flag == 1) {
				JOptionPane.showMessageDialog(null, "删除成功");
				modifyUserNameTxt.setText(null);
				modifyTelTxt.setText(null);
				modifyStudent_IDTxt.setText(null);
				modifysexTxt.setText(null);
				fillTable(new User());
			} else {
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		String name = modifyUserNameTxt.getText();
		String faculty = modifyTelTxt.getText();
		
		String student_Id = modifyStudent_IDTxt.getText();
		
		String sex = modifysexTxt.getText();
        ResultSet rs = null;
        String dbid;
        int flag;
		User user = new User(name, faculty, student_Id,sex);
		
		Connection con = null;
		
			try {
				con = dbUtil.getCon();
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			
				if(name.equals("")){
					 JOptionPane.showMessageDialog(null, "请输入姓名！");
                     return;
				}
				
				
				if(!student_Id.equals("")){
					try {
						rs = userDao.getID(student_Id, con);
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				} else {
					 JOptionPane.showMessageDialog(null, "学号不能为空！");
                     return;
				}
							
				try {
					int i = Integer.parseUnsignedInt(student_Id);
					if(rs.next()){//ID存在
						 JOptionPane.showMessageDialog(null, "学号为 "+student_Id+" 的学生信息已经存在！无法添加信息");
					     return;
					} else if((student_Id.length() > 13)){	//判断学号
						 JOptionPane.showMessageDialog(null, "学号必须小于13位");
							flag=0;
							return;
					 }  else if(faculty.equals("")){
						 JOptionPane.showMessageDialog(null, "注意：系别不能为空！");
					     return; 
					 } 
					
					  else if(!(faculty.equals(facultyStrings[0])||faculty.equals(facultyStrings[1])||faculty.equals(facultyStrings[2])||faculty.equals(facultyStrings[3])||faculty.equals(facultyStrings[4]))){
						 JOptionPane.showMessageDialog(null, "系别只能为："+facultyStrings[0]+", "+facultyStrings[1]+", "+facultyStrings[2]+", "+facultyStrings[3]+", "+facultyStrings[4]);
					     return;
					 }
					else if(sex.equals("")){
						 JOptionPane.showMessageDialog(null, "性别不能为空！");
					     return;
					 } else if(!(sex.equals("男")||sex.equals("女"))){
						 JOptionPane.showMessageDialog(null, "注意：性别只能为男或女！");
					     return; 
					 } else {
						
							 flag = userDao.modify(user, con);
						      if (flag == 1) {
							JOptionPane.showMessageDialog(null, "修改成功");
							modifyUserNameTxt.setText(null);
							modifyTelTxt.setText(null);
							modifyStudent_IDTxt.setText(null);
							modifysexTxt.setText(null);
							fillTable(new User());
						} else {
							JOptionPane.showMessageDialog(null, "修改失败!");
						}				 
					 }
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "数据格式错误，只能为数字!");
					System.out.println("数据格式错误，只能为数字！");
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}			
	}

	private void userTableMousePressed(java.awt.event.MouseEvent evt) {
		int row = userTable.getSelectedRow();
		modifyUserNameTxt.setText((String) userTable.getValueAt(row, 0));
		modifyTelTxt.setText((String) userTable.getValueAt(row, 1));
		modifyStudent_IDTxt.setText((String) userTable.getValueAt(row, 2));
		modifysexTxt.setText((String) userTable.getValueAt(row, 3));

	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel dtm = (DefaultTableModel) userTable.getModel();
		dtm.setRowCount(0);
		String name = searchUserNameTxt.getText();
		User user = new User(name, null);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = userDao.getUsers(user, con);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("name"));
				v.add(rs.getString("faculty"));
				v.add(rs.getString("student_id"));
				v.add(rs.getString("sex"));
				dtm.addRow(v);
				int rowCount = dtm.getRowCount();
//				if(rowCount > 0){
//					 JOptionPane.showMessageDialog(null, "查询成功！");
//				} else  {
//					JOptionPane.showMessageDialog(null, "查询失败！！！");
//				}
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		int flag = 0;
		String name = addUserNameTxt.getText();
		String faculty = addTelTxt.getText();
		String id=addStudentIDTxt.getText();
		
		String sex=addsexTxt.getText();	
		String getdbId = null;
		ResultSet rs = null;
		User user = new User(name,faculty,id,sex);
		Connection con = null;	
			try {
				con = dbUtil.getCon();
			} catch (ClassNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			try {
				if(name.equals("")){
					 JOptionPane.showMessageDialog(null, "姓名不能为空！");
                     return;
				}			
				if(!id.equals("")){
					rs = userDao.getID(id, con);
				} else {
					 JOptionPane.showMessageDialog(null, "学号不能为空！");
                     return;
				}
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			try {
				int i = Integer.parseUnsignedInt(id);
				
				
				 if(rs.next()){//ID存在
					 JOptionPane.showMessageDialog(null, "学号为 "+id+" 的学生信息已经存在！无法添加信息");
				     return;
				} else if((id.length() > 13)){	//判断学号
					 JOptionPane.showMessageDialog(null, "学号必须小于13位");
						flag=0;
						return;
				 }
				
				else if(faculty.equals("")){
					 JOptionPane.showMessageDialog(null, "注意：系别不能为空！");
				     return; 
				 } 
				
				  else if(!(faculty.equals(facultyStrings[0])||faculty.equals(facultyStrings[1])||faculty.equals(facultyStrings[2])||faculty.equals(facultyStrings[3])||faculty.equals(facultyStrings[4]))){
					 JOptionPane.showMessageDialog(null, "系别只能为："+facultyStrings[0]+", "+facultyStrings[1]+", "+facultyStrings[2]+", "+facultyStrings[3]+", "+facultyStrings[4]);
				     return;
				 }
				
				
				 if(sex.equals("")) {
					 JOptionPane.showMessageDialog(null, "性别不能为空！");
				     return;
				 } else if(!(sex.equals("男")||sex.equals("女"))){
					 JOptionPane.showMessageDialog(null, "注意：性别只能为男或女！");
				     return; 
				 } else {
					 try {
						flag = userDao.add(user, con);
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					 if (flag == 1) {
							JOptionPane.showMessageDialog(null, "添加成功！");
							addUserNameTxt.setText(null);
							addTelTxt.setText(null);
							addStudentIDTxt.setText(null);
							addsexTxt.setText(null);

							fillTable(new User());
						} else {
							JOptionPane.showMessageDialog(null, "添加失败!");
						}

				 }
			} catch (NumberFormatException e) {
				// TODO 自动生成的 
				JOptionPane.showMessageDialog(null, "输入格式错误，只能为数字!");
                System.out.println("输入格式错误，只能输入数字！");
				return;
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} 
			
         
			
		}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainPage().setVisible(true);
			}
		});
	}

	


}