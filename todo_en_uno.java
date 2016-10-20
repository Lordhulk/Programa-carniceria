package todoenuno;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import org.sqlite.SQLiteConfig.Pragma;





public class todo_en_uno {
	
	  static todo_en_uno inicio = new todo_en_uno();
	
	 //************************************************************FRAMES
	static  JFrame frame = new JFrame("La Selecion");
	  JFrame ventana = new JFrame("La Selecion");
	  JFrame clientes = new JFrame("Clientes");
	JFrame agregar_cliente = new JFrame ("Agregar clientes");
	 JFrame ven_stock = new JFrame("Stock");
	
	
	//************************************************************botones
	
	  JButton menu1 = new JButton("Entrada y Salida");
	  JButton menu2 = new JButton("Clientes y Proveedores");
	  JButton menu3 = new JButton("Stock");
	  JButton menu4 = new JButton("Proveedores");
	  JButton menu5 = new JButton("Balance Pollo");

	  //**************************
	  JButton terminar_jornada = new JButton("Fin Jornada");
	  
	  
	  
	  
	  
	  //*************************
	  JButton boton_volver_entrasal = new JButton("Volver menu");
	  
	  
	  
	  
	 //****************************
	  JButton boton_volver_clientes = new JButton("Volver menu");
	  JButton boton_volver_eliminar = new JButton("eliminar"); 
	  JButton boton_volver_agregar = new JButton("agregar");
	  JButton instertar = new JButton("Listo");
	  JButton otro_dato = new JButton("Insertar");
	  
	  
	  
	  
	 
	//************************************************************paneles y labels
	  JPanel panel_clientes = new JPanel();
	  JPanel panel = new JPanel();
	  JPanel panel_central = new JPanel(); 
	  JPanel agregar_jpanel = new JPanel(); 	  
	  JPanel pan_stock = new JPanel();
	  
	  //**************************************
	  

	  JLabel dato1 = new JLabel("Nombre cliente");
	  JLabel dato2 = new JLabel("Pedido");
	  JLabel dato3 = new JLabel("Debe");
	  JLabel dato4 = new JLabel("Pago");
	  JLabel dato5 = new JLabel("Fecha");
	  JLabel dato11 = new JLabel("Nombre cliente");
	  JLabel dato12 = new JLabel("Pedido");
	  JLabel dato13 = new JLabel("Debe");
	  JLabel dato14 = new JLabel("Pago");
	  JLabel dato15 = new JLabel("Fecha");
	  JLabel dato16 = new JLabel("Falta");
	  JLabel label1 = new JLabel("Menu");
	  JLabel label2 = new JLabel("Cobrado negocio");
	  
	
	//************************************************************text field y datos
	   DefaultListModel data = new DefaultListModel();
	   JList list = new JList(data);
	  JScrollPane scroll = new JScrollPane(list);
	  //************************ 
	  DefaultListModel fecha_wasa = new DefaultListModel();
	   JList fechas = new JList(fecha_wasa);
	  JScrollPane fecha_fecha = new JScrollPane(fechas);
	 //************************ 
	 
	  JTextField dinero = new JTextField(10);
	  JTextField finjornada = new JTextField(10);
	  
	  //*********************
	  
	  
	  DefaultListModel data_clientes = new DefaultListModel();	 
	  JList list_clientes = new JList(data_clientes);
	  JScrollPane scroll_clientes = new JScrollPane(list_clientes);
	 
	 //****************************************
	  DefaultListModel menu1_datos = new DefaultListModel();	 
	  JList menu1_list = new JList(menu1_datos);
	  JScrollPane menu1_scroll = new JScrollPane(menu1_list);
	  
	  
	  DefaultListModel menu1_datos1 = new DefaultListModel();	 
	  JList menu1_list1 = new JList(menu1_datos1);
	  JScrollPane menu1_scroll1 = new JScrollPane(menu1_list1);
	  
	  
	  DefaultListModel menu1_datos2 = new DefaultListModel();	 
	  JList menu1_list2 = new JList(menu1_datos2);
	  JScrollPane menu1_scroll2 = new JScrollPane(menu1_list2);
	  
	  
	//******************************************
	  
	  
	  JTextField text1 = new JTextField(30);
	  JTextField text2 = new JTextField(100);
	  JTextField text3 = new JTextField(30);
	  JTextField text4 = new JTextField(30);
	  JTextField fecha = new JTextField(30);


	 
	//************************************************************ variables grandes
	  private Dimension dim;
	  Connection c = null;
	  int espacio;
	  int plata;
	  Statement stmt = null;
	  int borrar=1;
	 int id=0;
	 public String papa3=null;
	 String namee=null;
	 int index=0;
	

	public void inicio(){


				  dim=frame.getToolkit().getScreenSize();


				  try {
				      Class.forName("org.sqlite.JDBC");
				      c = DriverManager.getConnection("jdbc:sqlite:fuera.db");
				      System.out.println("Opened database successfully");

				      stmt = c.createStatement();
				      
				      String sql = "CREATE TABLE COMPANY " +
				                   "(NAME 			TEXT    NOT NULL, " + 
				                   " FECHA            TEXT     NOT NULL, "+ 
				                   " AGE            TEXT     NOT NULL, "  + 
				                   " ADDRESS        CHAR(50), " + 
				                   " ADDRES       CHAR(50), " + 
				                   " SALARY         REAL)"; 
				      stmt.executeUpdate(sql);
				      stmt.close();
				      c.close();
				    } catch ( Exception e ) {
				      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				      //System.exit(0);
				    }
				    
				  System.out.println("Table created successfully");
				    
				  cargar_base();
				  refrescar();

				        
					//aca voy a modificarlas en espacio y tiempo xD	del menu 
						 label1.setBounds( 10,0, 50, 10);

					    
						 
						 menu1.setBounds(dim.width/2,25,150, 30);

				          menu2.setBounds(dim.width/2,65,150, 30);
	      
					      menu3.setBounds(dim.width/2,105,150, 30);
		   
					
					      menu4.setBounds(dim.width/2,145,150, 30);
					  
					      menu5.setBounds(dim.width/2,185,150, 30);
					 
//********************************************************************************************************************************** primer boton	      
					  	 
					      		menu1_scroll.setSize(dim.width/6,dim.height-150);
					      		menu1_scroll1.setSize((dim.width/6),dim.height-150);
					      		menu1_scroll2.setSize((dim.width/6),dim.height-150);
						  label2.setLocation(0, 0);
						  label2.setSize(100, 20);
						     list.setLayoutOrientation(JList.VERTICAL);
						     menu1_scroll.setLocation(0, 20);
						     menu1_scroll1.setLocation((dim.width/2), 20);
						     menu1_scroll2.setLocation((dim.width/6)+200, 20);
							 
						     boton_volver_entrasal.setBounds(0, dim.height-120, 150, 30);
					//		terminar_jornada.setBounds(400, 400, 150, 30);
							// dinero.setBounds(400, 300, 150, 30);
							// finjornada.setBounds(400, 450, 150, 30);
				
 //********************************************************************************************************************************** segundo boton	      
							    
							 
							 
							 
							 boton_volver_eliminar.setBounds(dim.width/4, dim.height/3, 150, 30);
							 boton_volver_agregar.setBounds(dim.width/7,dim.height/3 ,150,30);
							 boton_volver_clientes.setBounds(dim.width/2,dim.height/3,150, 30);
							 scroll_clientes.setSize(dim.width-150,dim.height/8);
							 scroll_clientes.setLocation(0, 100);
							 
							 
							
							 	dato11.setBounds(0, 50, 120, 50);
							    dato15.setBounds(120, 50, 120, 50);
							    dato12.setBounds(200, 50, 120, 50);
							    dato13.setBounds(380, 50, 120, 50);
							    dato14.setBounds(470, 50, 120, 50);
							    dato16.setBounds(580, 50, 120, 50);
							 
						
							 //************************
							 
							 
							 
							 
							 
							    dato1.setBounds(40, 50, 120, 50);
							    
							    dato5.setBounds(450, 50, 120, 50);
							    
							    dato2.setBounds(40, 150, 80, 50);
							    dato3.setBounds(40, 350, 80, 50);
							    dato4.setBounds(40, 450, 80, 50);
							
							instertar.setBounds(300, 500, 120, 50);
							 otro_dato.setBounds(550, 150, 120, 50);
							scroll.setBounds(40, 240, 700, 80);							
							   
							
							
								fecha.setBounds(550, 50, 120, 50);
								text1.setBounds(250, 50, 120, 50);
							    text2.setBounds(250, 150, 250, 50);
							    text3.setBounds(250,350, 120, 50);
							    text4.setBounds(250, 450, 120, 50);
				
							    
						    
//***************************************************************************************************************************************menu
							    
						 
					//las acciones que hacen los botones
					      menu1.addActionListener(new ActionListener(){

							public void actionPerformed(ActionEvent e) {
								System.out.println("You clicked the button1");
								frame.setVisible(false);
								ventana.setVisible(true);
							
							}
					      });
					      
					     
					      
					      menu2.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {
									
									
									frame.setVisible(false);
									clientes.setVisible(true);

									System.out.println("You clicked the button2");
									
									
								}
						      });
					     
					      
					      
					      menu3.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {
									
									frame.setVisible(false);
									ven_stock.setVisible(true);
									
									
									System.out.println("You clicked the button3");
									
								}
						      });
					     
					      
					      
					      menu4.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {
						
									System.out.println("You clicked the button4");
									
								}
						      });

					      menu5.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {

									System.out.println("You clicked the button5");
									
									
								}
						      });
				
 //********************************************************************************************************************************************primer boton
					      
						    boton_volver_entrasal.addActionListener(new ActionListener(){

							
								public void actionPerformed(ActionEvent e) {
									
									 ventana.setVisible(false);
								
									
								//	espacio=data.getSize();
									
									frame.setVisible(true);
									  //System.exit(ventana);
								
								}});
						 
						    
						
						    terminar_jornada.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					
			/*	float valor_turno=0 ;
			for(int completo=0;completo != data.size();completo++){
					
				//	 valor_turno= valor_turno + Float.valueOf(String.valueOf(data.get(completo)));
					
					System.out.println(valor_turno);
					
				}
					
					// data.addElement(valor_turno); 
					
					
					String plata="plata"; 
					plata=Float.toString(valor_turno);
					
					finjornada.setText(plata);
					
					*/
			//		data.clear();
					
				}
			});
					
						    dinero.addKeyListener(new KeyAdapter()
						    {
						    	public void keyTyped(KeyEvent e)
						       {  
						    		
						    	  int key= e.getKeyCode();
						          char caracter = e.getKeyChar();
						         

						          // Verificar si la tecla pulsada no es un digito
						          if(((caracter < '0') ||(caracter > '9')) && (caracter != '.') )
						          {
						        	   e.consume();  // ignorar el evento de teclado
						          
						          }
						           }
						            
						            
						    	public void keyReleased(KeyEvent e)
						    	{
						    	    int key=e.getKeyCode();
						    	        if(dinero.getText().toString().trim().length() > 0 && key==KeyEvent.VK_ENTER)
						    	        { 

						    	        	data.addElement(dinero.getText()); 
						    	        	dinero.setText(null);
						    	      
						    	        }
						    	    }  
						    });
						
 //************************************************************************************************************************************segundo boton
						     
			  
						    
						    boton_volver_clientes.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {

									
									frame.setVisible(true);
									clientes.setVisible(false);

									
									System.out.println("You clicked the button5");
									
									
								}
						      });
						    
						    
						    
						    boton_volver_agregar.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {

									agregar_cliente.setVisible(true);
									
									
								}
						      });
						    
						    
						    
						    
						    boton_volver_eliminar.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {

									
									 String buscar = "/";
							    	
							    	 System.out.println(namee);
							    	
							   	   if (namee.indexOf(buscar,0)>-1){
							   	    	 
							   	    	int papa2 =namee.indexOf(buscar, 0);
						   	    	
							   	    	
							   	    	papa3 = namee.substring(0, papa2);
							   	    	
							   	    	System.out.println(papa3); 
							   	    	 
							   	    	 
							   	     }
							   	    
							    	 //System.out.println(namee);
							    	 System.out.println("INDEX!!!!"+index);
							    	 // encontrar error de poruqen o borrar y restablece la id
							    	 
				
							   	  
							    	 try {
							    	      Class.forName("org.sqlite.JDBC");
							    	      c = DriverManager.getConnection("jdbc:sqlite:fuera.db");
							    	      c.setAutoCommit(false);
							    	      System.out.println("Opened database successfully");

							    	      stmt = c.createStatement();
							    	      String sql = "DELETE from COMPANY where NAME='"+papa3+"';";
							    	      stmt.executeUpdate(sql);					    	      
							    	      stmt.close();
							    	      c.commit();
							    	      c.close();
							    	    } catch ( Exception j ) {
							    	      System.err.println( j.getClass().getName() + "jjjjjjj: " + j.getMessage() );
							    	      //System.exit(0);
							    	    }
						
							    	 refrescar();
							    	    System.out.println("Double clicked on Item fasdfsd" + index);
							    	  
									
			
								}
						      });
						    
						    //**********************************************

						
						    instertar.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {
								
								
								
									 try {
									      Class.forName("org.sqlite.JDBC");
									      c = DriverManager.getConnection("jdbc:sqlite:fuera.db");
									      c.setAutoCommit(false);
									      System.out.println("Opened database successfully");

									      stmt = c.createStatement();
									      String sql = "INSERT INTO COMPANY (NAME,FECHA,AGE,ADDRESS,ADDRES,SALARY) " +
									                   "VALUES ('"+text1.getText()+"','"+fecha.getText()+"','"+data+"','"+text3.getText()+"','"+ text4.getText()+"','"+(Integer.parseInt(text3.getText())-Integer.parseInt(text4.getText()))+"');";				
									      stmt.executeUpdate(sql);
									      
									      
									     


									      stmt.close();
									      c.commit();
									      c.close();
									    } catch ( Exception a ) {
									      System.err.println( a.getClass().getName() + ": " + a.getMessage() );
									      //System.exit(0);
									    }
									    System.out.println("Records created successfully");
									
									    
									    refrescar();

										System.out.println(data_clientes);
										
										 data.clear();
							    			text1.setText(null);
							    			text2.setText(null);	
							    			text3.setText(null);	
							    			text4.setText(null);	
										agregar_cliente.setVisible(false);
									
								//	 String text = text1.getText();
									
									
									
									
								}
						      });
						    
						    
						    
						    otro_dato.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent e) {

									
									
									
							data.addElement(text2.getText());
									
								text2.setText(null);	
									
									
								}
						      });
						    
						    
						    agregar_cliente.addWindowListener( new WindowAdapter(){
						    	
						    	 public void windowClosing(WindowEvent e)
						    	    {
						    		 data.clear();
						    			text1.setText(null);
						    			text2.setText(null);	
						    			text3.setText(null);	
						    			text4.setText(null);	
						    			fecha.setText(null);	
						    		 System.out.println("wfdsgfsag");
						    		 
						    		 
						    	    }
						    	
						    	
						    	
						    	
						    	
						    });
						    
						    
						    MouseListener mouseListener = new MouseAdapter() {
							     public void mouseClicked(MouseEvent e) {
							    	 
							    	 
							    	  index =list_clientes.locationToIndex(e.getPoint());
							    	
							    	 namee = (String) data_clientes.getElementAt(index);
							    	  
							    	  String buscar = "/";
								    	
						
								    	
								   	   if (namee.indexOf(buscar,0)>-1){
								   	    	 
								   	    	int papa2 =namee.indexOf(buscar, 0);
							   	    	
								   	    	
								   	    	papa3 = namee.substring(0, papa2);
								   	    	
							
								   	    	 
								   	    	 
								   	     }
							    	 if (e.getClickCount() == 2) {

											frame.setVisible(false);
											ven_stock.setVisible(true);
										
								
											
											
											  fecha_wasa.clear();
											  try {
											        Class.forName("org.sqlite.JDBC");
											        c = DriverManager.getConnection("jdbc:sqlite:fuera.db");
											        c.setAutoCommit(false);
											      //  System.out.println("Opened database successfully");

											        stmt = c.createStatement();
											        ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
											        while ( rs.next() ) {
											           String  name = rs.getString("name");
											           String  fecha = rs.getString("fecha");
											           String age  = rs.getString("age");
											           String  address = rs.getString("address");
											           String  addres = rs.getString("addres");
											           float salary = rs.getFloat("salary");
											           System.out.println(papa3+"valor1");
										        	   System.out.println(name+"valor2");
											           if(papa3.equals(name)){
											        	
											        	   fecha_wasa.addElement(fecha+"               " +age+"                      "+address+"                      "+addres+"                     "+salary );
													          
											        	   
											        	   
											           }
											          // data_clientes.addElement(name+"/                            "+fecha+"               " +age+"                      "+address+"                      "+addres+"                     "+salary );
											          
											           System.out.println( "NAME = " + name ); 
											           System.out.println( "fecha = " + fecha );
											           System.out.println( "AGE = " + age );
											           System.out.println( "ADDRESS = " + address );
											           System.out.println( "SALARY = " + salary );
											           System.out.println();
											        }
											        rs.close();
											        stmt.close();
											        c.close();
											      } catch ( Exception c ) {
											        System.err.println( c.getClass().getName() + ": " + c.getMessage() );
											     //   System.exit(0);
											      }
											      System.out.println("WASAAAAAAAAAAAAAAAAAAAAAAAAAA");
											
											
											
											
											
											
											
											
											
											
											
											
											
											
											}
							     } 
							    		 
			
							 };
							 list_clientes.addMouseListener(mouseListener);
	//***************************************************************************************************************************** Tercer menu 

	
							 
							 
							 
							  fecha_wasa.clear();
							      try {
								        Class.forName("org.sqlite.JDBC");
								        c = DriverManager.getConnection("jdbc:sqlite:stock.db");
								        c.setAutoCommit(false);
								      //  System.out.println("Opened database successfully");

								        stmt = c.createStatement();
								        ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
								        while ( rs.next() ) {
								           String  name = rs.getString("GRUPO");
								           String  fecha = rs.getString("NOMBRE");
								           String age  = rs.getString("CANTIDAD");

								           fecha_wasa.addElement(name+"               " +fecha+"                      "+age );
								        }
								        rs.close();
								        stmt.close();
								        c.close();
								      } catch ( Exception c ) {
								        System.err.println( c.getClass().getName() + ": " + c.getMessage() );
								     //   System.exit(0);
								        System.out.println("noup");
								      }
								    //  System.out.println("REFRESCOOOOOOOOOOO");
								
							      
							      
							      
							      
							      
							 
					    
					    //***********************************************************************************************************************primer menu
						  ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						  ventana.setSize(dim);
						  ventana.setContentPane(panel_central);
						  
						  
						    panel_central.add(finjornada);
							panel_central.add(dinero);
							panel_central.add(terminar_jornada);
							panel_central.add(label2);  
							panel_central.add(dinero);
							panel_central.add(boton_volver_entrasal);
							panel_central.add(menu1_scroll);
							panel_central.add(menu1_scroll1);
							panel_central.add(menu1_scroll2);
							panel_central.setLayout(null);
							panel_central.setBackground(Color.WHITE);
							panel_central.setOpaque(true);
						  
						  
						  
						//****************************************************************************************************************************segundo menu   
						  
						  
						  clientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						  clientes.setSize(dim);
						  clientes.setContentPane(panel_clientes);
						    panel_clientes.add(boton_volver_agregar);
						    panel_clientes.add(boton_volver_eliminar);
						    panel_clientes.add(boton_volver_clientes);
						   
						    panel_clientes.add(scroll_clientes);
						
						    
						    panel_clientes.add(dato11);
						    panel_clientes.add(dato12);
						    panel_clientes.add(dato13);
						    panel_clientes.add(dato14);
						    panel_clientes.add(dato15);
						    panel_clientes.add(dato16);
						    
						    panel_clientes.setLayout(null);
						    panel_clientes.setBackground(Color.WHITE);
						    panel_clientes.setOpaque(true);
						   
						  //***********************************************  
					agregar_cliente.setSize(800,600);  
					 agregar_cliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
					 agregar_cliente.setContentPane(agregar_jpanel);
					    agregar_jpanel.add(instertar);
					    agregar_jpanel.add(otro_dato);
					    agregar_jpanel.add(scroll);
					    agregar_jpanel.add(text1);
					    agregar_jpanel.add(text2);
					    agregar_jpanel.add(text3);
					    agregar_jpanel.add(text4);
					    agregar_jpanel.add(fecha);
					    agregar_jpanel.add(dato1);
					    agregar_jpanel.add(dato2);
					    agregar_jpanel.add(dato3);
					    agregar_jpanel.add(dato4);
					    agregar_jpanel.add(dato5);
					    agregar_jpanel.setLayout(null);
					   agregar_jpanel.setBackground(Color.WHITE);
					   agregar_jpanel.setOpaque(true);
					    
					 
					 
					 
					//***************************************************************************************************************************** Tercer menu
					 ven_stock.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					 ven_stock.setSize(dim);
					 ven_stock.setContentPane(pan_stock);
					 
					 
				
					 pan_stock.add(fecha_fecha);
					 
					 
					 
					  //*************************************************************************************************************************** menu 
					  
					    panel.setBackground(Color.WHITE);
						  panel.setLayout(null);
						  panel.setOpaque(true);
						  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						  frame.setSize(dim);
						  frame.setContentPane(panel);
					
						    panel.add(label1);
						    panel.add(menu1);
						    panel.add(menu2);
						    panel.add(menu3);
						    panel.add(menu4);
						    panel.add(menu5);
	   
	
	
		
	}
	
	
	public void refrescar(){
		
	
		    data_clientes.clear();
		    try {
		        Class.forName("org.sqlite.JDBC");
		        c = DriverManager.getConnection("jdbc:sqlite:fuera.db");
		        c.setAutoCommit(false);
		      //  System.out.println("Opened database successfully");

		        stmt = c.createStatement();
		        ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
		        while ( rs.next() ) {
		           String  name = rs.getString("name");
		           String  fecha = rs.getString("fecha");
		           String age  = rs.getString("age");
		           String  address = rs.getString("address");
		           String  addres = rs.getString("addres");
		           float salary = rs.getFloat("salary");
		           
		           data_clientes.addElement(name+"/                            "+fecha+"               " +age+"                      "+address+"                      "+addres+"                     "+salary );
		          
		        }
		        rs.close();
		        stmt.close();
		        c.close();
		      } catch ( Exception c ) {
		        System.err.println( c.getClass().getName() + ": " + c.getMessage() );
		     //   System.exit(0);
		      }
		      System.out.println("REFRESCOOOOOOOOOOO");
		
		
		
	}
	
	public void cargar_base(){
		String sql;
		int hecho=0;
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:stock.db");
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      
		      sql = "CREATE TABLE COMPANY " +
		                   "(GRUPO 			TEXT    NOT NULL, " + 
		                   " NOMBRE            TEXT     NOT NULL, "+ 
		                   " CANTIDAD            REAL) ";
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      //System.exit(0);
		    
		    }
		    
		  System.out.println("Table created successfully");

		    try {
		        Class.forName("org.sqlite.JDBC");
		        c = DriverManager.getConnection("jdbc:sqlite:stock.db");
		        c.setAutoCommit(false);
		      //  System.out.println("Opened database successfully");

		        stmt = c.createStatement();
		        ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
		        while ( rs.next() ) {
		           String  name = rs.getString("GRUPO");
		           String  fecha = rs.getString("NOMBRE");
		           String age  = rs.getString("CANTIDAD");

		           if (name.indexOf("CARNE",0)>-1){
		        	   
		        	   hecho=2;
		        	   
		        	   
		           }
		       
		        }
		        System.out.println( hecho );
		        rs.close();
		        stmt.close();
		        c.close();
		      } catch ( Exception c ) {
		        System.err.println( c.getClass().getName() + ": " + c.getMessage() );
		     //   System.exit(0);
		        System.out.println("noup");
		      }
		    
		
		  
		    if(hecho==0){
		    	try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:stock.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		    
		      sql = "INSERT INTO COMPANY (GRUPO,NOMBRE,CANTIDAD) " +
		    		  "VALUES('CARNE','Asado',0);";         
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO COMPANY (GRUPO,NOMBRE,CANTIDAD) " +
		    		  "VALUES('CARNE','Bola de lomo',0);";         
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO COMPANY (GRUPO,NOMBRE,CANTIDAD) " +
		    		  "VALUES('CARNE','Cuadrada',0);";         
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO COMPANY (GRUPO,NOMBRE,CANTIDAD) " +
		    		  "VALUES('CARNE','Cuadril',0);";         
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO COMPANY (GRUPO,NOMBRE,CANTIDAD) " +
		    		  "VALUES('CARNE','Entraña',0);";         
		      stmt.executeUpdate(sql);
		      /*****************************************************************************************/
		      sql = "INSERT INTO COMPANY (GRUPO,NOMBRE,CANTIDAD) " +
		    		  "VALUES('CARNE','Lomo',0);";         
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO COMPANY (GRUPO,NOMBRE,CANTIDAD) " +
		    		  "VALUES('CARNE','matambre',0);";         
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO COMPANY (GRUPO,NOMBRE,CANTIDAD) " +
		    		  "VALUES('CARNE','paleta',0);";         
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO COMPANY (GRUPO,NOMBRE,CANTIDAD) " +
		    		  "VALUES('CARNE','picada comun',0);";         
		      stmt.executeUpdate(sql);
		      
		      sql = "INSERT INTO COMPANY (GRUPO,NOMBRE,CANTIDAD) " +
		    		  "VALUES('CARNE','picada espacial',0);";         
		      stmt.executeUpdate(sql);
		      /*****************************************************************************************/

		      
		      
		     


		      stmt.close();
		      c.commit();
		      c.close();
		    } catch ( Exception a ) {
		      System.err.println( a.getClass().getName() + ": " + a.getMessage() );
		    }
		   // System.out.println("Records created successfully");
		




try {
    Class.forName("org.sqlite.JDBC");
    c = DriverManager.getConnection("jdbc:sqlite:stock.db");
    c.setAutoCommit(false);
  //  System.out.println("Opened database successfully");

    stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery( "SELECT * FROM COMPANY;" );
    while ( rs.next() ) {
       String  name = rs.getString("GRUPO");
       String  fecha = rs.getString("NOMBRE");
       String age  = rs.getString("CANTIDAD");

       fecha_wasa.addElement(name+"               " +fecha+"                      "+age );
    }
    rs.close();
    stmt.close();
    c.close();
  } catch ( Exception c ) {
    System.err.println( c.getClass().getName() + ": " + c.getMessage() );
 //   System.exit(0);
   
  }
 System.out.println("noup");
}


	}
	
	
	public static void main(String[] args) {
		 frame.setVisible(true);
		 
		
		 inicio.inicio();
			
			
			
			
	}

}
