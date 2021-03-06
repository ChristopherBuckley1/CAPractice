package SelectSort;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class NameAnalyser{
	JTextField textField;
	JTextArea textArea;
	JButton sortButton;
	String names[] = new String[30];
	int textFieldEventCount=0;
	
	public NameAnalyser()
	{
		JFrame jFrameWindow = new JFrame("Name analyser");
		
		FlowLayout flowLayout = new FlowLayout();
		jFrameWindow.setLayout(flowLayout);
		jFrameWindow.setSize(500,150);
		jFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sortButton = new JButton("Sort");
		jFrameWindow.add(sortButton);
		
		JButton searchButton = new JButton("Search");
		jFrameWindow.add(searchButton);
		
		ButtonEventHandler buttonHandler = new ButtonEventHandler();
		
		sortButton.addActionListener(buttonHandler);
		searchButton.addActionListener(buttonHandler);
		
		JLabel promptLabel = new JLabel("Enter Name");
		jFrameWindow.add(promptLabel);
		
		textField = new JTextField(20);
		jFrameWindow.add(textField);
		
		textArea = new JTextArea();
		textArea.setText("No names entered yet");
		
		Font font = new Font("monospaced",Font.PLAIN,12);
		textArea.setFont(font);
		
		jFrameWindow.add(textArea);
		
		TextFieldEventHandler fieldHandler = new TextFieldEventHandler();
		
		textField.addActionListener(fieldHandler);
		
		jFrameWindow.setVisible(true);
		
		
			
		
		
	}
	public static void main(String args[])
	{
		NameAnalyser guiApp = new NameAnalyser();
	}
	
	private class ButtonEventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==sortButton)
			{
				selectionSort(names);
				JOptionPane.showMessageDialog(null,Arrays.toString(names),"Sorted Names",
				JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				String searchName = JOptionPane.showInputDialog("Please enter the name you seek:");
				boolean found;
				
				selectionSort(names);
				found = binarySearch(names,searchName);
				
				if(found)
					JOptionPane.showMessageDialog(null,"THis name was found in the array of names",
													"Found!",JOptionPane.INFORMATION_MESSAGE);
													
				else
					JOptionPane.showMessageDialog(null,"This name was not found in the array of names",
													"Not found!",JOptionPane.ERROR_MESSAGE);
													
													
				
			}		
		}
	}
	
	private static void selectionSort (String names[])
		{
				String smallest,temp;
				int sub;
				
				for(int i = 0;i<names.length-1;i++)
				{
					if(names[i]!=null)
					{
						smallest = names[i];
						sub = i;
						
						for(int j = i+1;j<names.length; j++)
							if(names[j] != null && names[j].compareTo(smallest)<0)
							{
								smallest = names[j];
								sub = j;
							}
						temp = names[i];
						names[i] = names[sub];
						names[sub] = temp;
					}
						
				}
		}
		
		private static boolean binarySearch(String names[],String searchName)
		{
			int lowerSub=0,higherSub = names.length-1,middleSub;
			
			while(lowerSub<=higherSub)
			{
				middleSub = (lowerSub+higherSub)/2;
				
				if(names[middleSub]!=null)
					if(names[middleSub].compareTo(searchName)<0)
						lowerSub=middleSub+1;
					else if(names[middleSub].compareTo(searchName)>0)
						higherSub = middleSub-1;
					else
						return true;
				else
					higherSub = middleSub-1;
						
			}
		
			return false;
		}
		
		private class TextFieldEventHandler implements ActionListener{
			public void actionPerformed(ActionEvent e)
			{
				String text = textField.getText();
				
				if(text.equals(""))
				{
					JOptionPane.showMessageDialog(null,"You must enter some text!","Error!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				textField.setText("");
				int lowercase = 0,uppercaseVowels=0;
				
				names[textFieldEventCount] = text;
				
				textFieldEventCount++;
				
				for(int i=0;i<text.length();i++)
				{
					if(Character.isLowerCase(text.charAt(i)))
						lowercase++;
						
					if(text.charAt(i)=='A'||text.charAt(i)=='E'||text.charAt(i)=='I'||
						text.charAt(i)=='O'||text.charAt(i)=='U')
							uppercaseVowels++;
				}
				
				textArea.setText("Total numbers of characters in name: " + text.length()+
					"\nNumber of lower case letters in the name: "+lowercase+
						"\nNumber of uppercase vowels in the name: "+uppercaseVowels);
			}
		}
}