package JTextArea;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class accountadmin{
	JTextField usernameField;
	JPasswordField passwordField;
	JButton newAccountButton,viewAccountButton,generateAccountButton,removeAccountButton;
	String usernames[] = new String[100];
	String passwords[] = new String[100];
	JFrame jFrameWindow;
	
	public accountadmin()
	{
		jFrameWindow = new JFrame("Account Administrator");
		
		FlowLayout flowLayout = new FlowLayout();
		
		jFrameWindow.setLayout(flowLayout);
		
		jFrameWindow.setSize(500,150);
		
		jFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel promptLabel = new JLabel("Welcome administrator,which action "+
										"would you like to perform?");
										
		jFrameWindow.add(promptLabel);
		
		newAccountButton = new JButton("Create New Account");
		jFrameWindow.add(newAccountButton);
		
		viewAccountButton = new JButton("View Specific Account");
		jFrameWindow.add(viewAccountButton);
		
		JButton removeAccountButton = new JButton("Remove Account");
		jFrameWindow.add(removeAccountButton);
		
	ButtonEventHandler buttonHandler = new ButtonEventHandler();
		
		newAccountButton.addActionListener(buttonHandler);
		viewAccountButton.addActionListener(buttonHandler);
		removeAccountButton.addActionListener(buttonHandler);
		viewAccountButton.addActionListener(buttonHandler);
		
		jFrameWindow.setVisible(true);
		
		
		
		
	}
	
	public static void main(String args[])
	{
		accountadmin guiApp = new accountadmin();
	}
	
	private class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==newAccountButton)
			{
				JFrame accountDetailsWindow = new JFrame("Account Details");
				
				FlowLayout flowLayout = new FlowLayout();
				
				accountDetailsWindow.setLayout(flowLayout);
				
				accountDetailsWindow.setSize(350,100);
				
				JLabel usernameLabel = new JLabel("Username");
				accountDetailsWindow.add(usernameLabel);
				
				usernameField = new JTextField(8);
				accountDetailsWindow.add(usernameField);
				
				JLabel passwordLabel = new JLabel("Password");
				accountDetailsWindow.add(passwordLabel);
				
				passwordField = new JPasswordField(8);
				accountDetailsWindow.add(passwordField);
				
				generateAccountButton = new JButton("Generate New Account");
				accountDetailsWindow.add(generateAccountButton);
				
				generateAccountButton.addActionListener(new ButtonEventHandler());
				
				accountDetailsWindow.setLocation(200,200);
				
				accountDetailsWindow.setVisible(true);
				
			}
		else if(e.getSource()==generateAccountButton)
		{
			String username = usernameField.getText();
			char[] password = passwordField.getPassword();
			
			for(int i = 0;i<usernames.length;i++)
			{
				if(usernames[i]!=null&&username.equals(usernames[i]))
				{
					JOptionPane.showMessageDialog(null,"This username is already" +
													" taken!","Error!",JOptionPane.ERROR_MESSAGE);
					break;
				}
				else if(usernames[i]==null)
				{
					usernames[i] = username;
					passwords[i]= new String(password);
					
					JOptionPane.showMessageDialog(null,"new account created"+
						"successfully!!!!","Success!",JOptionPane.INFORMATION_MESSAGE);
						
					break;
				}
			}
		}
			
		
		else if(e.getSource()==viewAccountButton)
			{
			String username = JOptionPane.showInputDialog("Please enter the username of the account you seek");
			
			selectionSort(usernames,passwords);
			
			int subscriptUsername = binarySearch(usernames,username);
			
			if(subscriptUsername!=-1)
				JOptionPane.showMessageDialog(null,"The details for this account are as follows:\n\nUsername: " + usernames[subscriptUsername] + "\nPassword: "+passwords[subscriptUsername]
					,"Account Details",JOptionPane.INFORMATION_MESSAGE);
		
				
			else
				JOptionPane.showMessageDialog(null,"The details for this account could not be found!!"
					,"Error!",JOptionPane.ERROR_MESSAGE);
			
			}
		else if(e.getSource()==removeAccountButton)
		{
			String username = JOptionPane.showInputDialog("Please enter the username of the account you wish to remove" );
			int subscriptUsername = linearSearch(usernames,username);
			
			if(subscriptUsername!=-1)
			{
				usernames[subscriptUsername] = null;
				passwords[subscriptUsername] = null;
				
				System.out.println(Arrays.toString(usernames));
				System.out.println(Arrays.toString(passwords));
				
				JOptionPane.showMessageDialog(null,"The details for this account have now been removed",
												"Account removed",JOptionPane.INFORMATION_MESSAGE);
			}
			else 
				JOptionPane.showMessageDialog(null,"The details for this account could not be found!",
												"error",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			JTextArea textArea = new JTextArea();
			Font font = new Font("monospaced",Font.PLAIN,12);
			
			textArea.setFont(font);	
				
			textArea.append(String.format("%-25s%s\n%-25s%s\n\n","Usernames","Passwords","--------","-------"));
			selectionSort(usernames,passwords);
			
			String text = "";
			
			for(int i = 0;i<usernames.length;i++)
			{
				if(usernames[i]!=null)
					text += String.format("%-25s%s\n",usernames[i],passwords[i]);
			}
			
			if(text.equals(""))
				textArea.setText("no accounts yet!");
			else
				textArea.append(text);
				
			JOptionPane.showMessageDialog(null,textArea,"All ACCOUNTS SORTED",JOptionPane.INFORMATION_MESSAGE);
		}
		
				
		}
	}
	
	
	private static int linearSearch(String usernames[],String username)
	{
		for(int i = 0;i<usernames.length;i++)
		{
			if(usernames[i]!=null&&usernames[i].equals(username))
				return i;
		}
		return -1;
	}
	
	private static void selectionSort(String[] usernames, String[] passwords)
			{
		      	String smallest,temp;
		      	int sub;
		      	
		      	for (int i = 0; i < usernames.length-1; i++)
		      		{
		      			if(usernames[i]!=null)
		      			{	
				  			smallest = usernames[i];
				  			sub = i;
				  			
				  			for (int j = i+1; j < usernames.length; j++)
				       			if (usernames[j]!=null && usernames[j].compareTo(smallest) < 0)
				       				{
					   					smallest = usernames[j];
					   					sub = j;
				       				}
				  				
			        		temp = usernames[i];
					  		usernames[i] = usernames[sub];
				  			usernames[sub] = temp;
				  			
				  			temp = passwords[i];
				  			passwords[i] = passwords[sub];
				  			passwords[sub] = temp;
		      			}		  			
		      		}
			}
			
			
		private static int binarySearch(String usernames[], String username)
			{
				 int lowerSub = 0, higherSub = usernames.length-1, middleSub;
					 		 		 
				 while(lowerSub<=higherSub)
					 {
					 	middleSub = (lowerSub+higherSub)/2;
					 	
					 	if(usernames[middleSub]!=null)
						 	if(usernames[middleSub].compareTo(username) < 0)
							 	lowerSub = middleSub+1;
							else if(usernames[middleSub].compareTo(username) > 0)
								higherSub = middleSub-1;
							else
								return middleSub;
						else
							higherSub = middleSub-1;
					 }
		      	 
		      	 return -1;
			}	
}