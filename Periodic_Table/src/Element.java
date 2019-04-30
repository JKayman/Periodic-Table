import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This class is to hold information about each chemical element in the
 * periodic table and handles the formatting of the icon shown
 * 
 * @author Kirill Proshakov
 *
 */
public class Element
{	
	public String name, fulln, electronAffinity, valency, mass, ionizationEnergy,
	atomRad, electronegativity;
	int atomNum;
	Color color;
	static Font f1 = new Font("Tahoma", Font.BOLD, 12);
	JFrame element;
	/**
	 * Creates the Element object based on the properties passed.
	 * 
	 * @param 	n - A String array holding the information about character
	 * 			representation of the element, full name, electron affinity, valency, 
	 * 			the group of the elements that the element belongs to, mass, ionization 
	 * 			energy, and the radius of the atom electronegativity.
	 * */
	public Element(String... n)
	{
		name = n[0];
		fulln = n[1];
		electronAffinity = n[2] + " kJ/mol";
		valency = n[3];
		atomNum = Integer.parseInt(n[4]);
		mass = n[5] + " g.mol";
		ionizationEnergy = n[6] + " kJ.mol";
		atomRad = n[7] + " pm";
		electronegativity = n[8];
		switch (atomNum)
		{
			case 1:
				color = Color.BLUE;
				break;
			case 3:
				color = Color.PINK;
				break;
			case 11:
				color = Color.PINK;
				break;
			case 19:
				color = Color.PINK;
				break;
			case 37:
				color = Color.PINK;
				break;
			case 55:
				color = Color.PINK;
				break;
			case 87:
				color = Color.PINK;
				break;
			case 4:
				color = Color.ORANGE;
				break;
			case 12:
				color = Color.ORANGE;
				break;
			case 20:
				color = Color.ORANGE;
				break;
			case 38:
				color = Color.ORANGE;
				break;
			case 56:
				color = Color.ORANGE;
				break;
			case 88:
				color = Color.ORANGE;
				break;
			case 5:
				color = Color.CYAN;
				break;
			case 14:
				color = Color.CYAN;
				break;
			case 32:
				color = Color.CYAN;
				break;
			case 33:
				color = Color.CYAN;
				break;
			case 51:
				color = Color.CYAN;
				break;
			case 52:
				color = Color.CYAN;
				break;
			case 84:
				color = Color.CYAN;
				break;
			case 9:
				color = Color.LIGHT_GRAY;
				break;
			case 17:
				color = Color.LIGHT_GRAY;
				break;
			case 35:
				color = Color.LIGHT_GRAY;
				break;
			case 53:
				color = Color.LIGHT_GRAY;
				break;
			case 85:
				color = Color.LIGHT_GRAY;
				break;
			case 117:
				color = Color.LIGHT_GRAY;
				break;
			case 2:
				color = Color.MAGENTA;
				break;
			case 10:
				color = Color.MAGENTA;
				break;
			case 18:
				color = Color.MAGENTA;
				break;
			case 36:
				color = Color.MAGENTA;
				break;
			case 54:
				color = Color.MAGENTA;
				break;
			case 86:
				color = Color.MAGENTA;
				break;
			case 118:
				color = Color.MAGENTA;
				break;
			case 6:
				color = Color.BLUE;
				break;
			case 7:
				color = Color.BLUE;
				break;
			case 8:
				color = Color.BLUE;
				break;
			case 15:
				color = Color.BLUE;
				break;
			case 16:
				color = Color.BLUE;
				break;
			case 34:
				color = Color.BLUE;
				break;
			case 13:
				color = Color.GREEN;
				break;
			case 31:
				color = Color.GREEN;
				break;
			case 49:
				color = Color.GREEN;
				break;
			case 50:
				color = Color.GREEN;
				break;
			case 81:
				color = Color.GREEN;
				break;
			case 82:
				color = Color.GREEN;
				break;
			case 83:
				color = Color.GREEN;
				break;
			case 114:
				color = Color.GREEN;
				break;
			case 116:
				color = Color.GREEN;
				break;
			case 113:
				color = Color.GREEN;
				break;
			case 115:
				color = Color.GREEN;
				break;

		}

		if (atomNum > 20 && atomNum < 31)
		{
			color = Color.YELLOW;
		}
		else if (atomNum > 38 && atomNum < 49)
		{
			color = Color.YELLOW;
		}
		else if (atomNum > 71 && atomNum < 81)
		{
			color = Color.YELLOW;
		}
		else if (atomNum > 103 && atomNum < 113)
		{
			color = Color.YELLOW;
		}
		else if (atomNum >= 57 && atomNum < 72)
		{
			color = Color.WHITE;
		}
		else if (atomNum >= 89 && atomNum < 104)
		{
			color = Color.GRAY;
		}
	}
	
	
	/**
	 * Creates a visual summary of the properties of the element.
	 * */
	public void frame()
	{

		Font f1 = new Font("Tahoma", Font.ITALIC, 14);

		String period = "-";
		JTextArea panel = new JTextArea(750, 675);
		panel.setLayout(new GridBagLayout());
		panel.setEditable(false);
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridheight = 1;
		gc.gridwidth = 1;
		gc.weightx = 100;
		gc.weighty = 100;
		// gc.insets = new Insets(5, 5, 5, 5);
		gc.anchor = GridBagConstraints.CENTER;
		gc.fill = GridBagConstraints.NONE;

		if (color.equals(Color.BLUE))
		{
			period = "Nonmetal";
		}
		else if (color.equals(Color.PINK))
		{
			period = "Alkali Metals";
		}
		else if (color.equals(Color.ORANGE))
		{
			period = "Alkaline Earth";
		}
		else if (color.equals(Color.CYAN))
		{
			period = "Semimetal";
		}
		else if (color.equals(Color.LIGHT_GRAY))
		{
			period = "Halogen";
		}
		else if (color.equals(Color.MAGENTA))
		{
			period = "Nobel Gas";
		}
		else if (color.equals(Color.GREEN))
		{
			period = "Basic Metal";
		}
		else if (color.equals(Color.YELLOW))
		{
			period = "Transititon Metal";
		}
		else if (color.equals(Color.RED))
		{
			period = "Lanthanide";
		}
		else if (color.equals(Color.GRAY))
		{
			period = "Actinide";
		}

		JButton j = new JButton();

		mini(j);
		panel.add(j, gc);
		gc.gridx++;
		gc.gridwidth = 2;

		JTextArea l = new JTextArea(300, 125);

		l.setEditable(false);
		l.setFont(f1);
		l.setText(String.format("%s\t%s\n%s\n", fulln, valency, period));

		l.append(String.format("%s", "Mass: " + mass));
		gc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(l, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 3;
		gc.fill = GridBagConstraints.NONE;
		JTextArea f = new JTextArea(50, 75);

		f.setEditable(false);
		f.setText(String.format("%s\n%s\n%s\n%s", "Electron Affinity: " + 
		electronAffinity, "Ionization Energy: " + ionizationEnergy, 
		"Electronegativity: " + electronegativity, "Atomic Radious: " +
		atomRad));

		panel.add(f, gc);

		//Table.Tablem tm = t.new Tablem(atomNum);
		//tm.add(panel);
		element = new JFrame();
		element.setTitle(fulln);
		element.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		element.addWindowListener(new CloseListener());
		element.setSize(300, 200);
		element.setLocationRelativeTo(null);
		element.setResizable(true);
		element.add(panel);
		element.setVisible(true);
	}

	/**
	 * Creates a visual representation of the element cell within a periodic
	 * table.
	 * 
	 * @param	b - JButton that represents the cell.
	 * */
	public void mini(JButton b)
	{

		b.setPreferredSize(new Dimension(100, 100));

		b.setLayout(new BoxLayout(b, BoxLayout.Y_AXIS));

		b.setBackground(color);
		b.add(new JLabel(getName()));
		b.add(Box.createVerticalStrut(5));
		b.add(getatomNum());
		

	}
	
	/**
	 * Returns the character representation of the element
	 * @return	The character representation of the element
	 * */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Composes a JLabel with the atomic number of the element
	 * @return	JLablel that holds atomic number of the element
	 */
	public JLabel getatomNum()
	{
		JLabel l = new JLabel("" + atomNum);
		l.setFont(new Font("Tahoma", Font.BOLD, 10));
		return l;

	}
	
	/**
	 * Returns atomic number of the element
	 * @return	Integer representing atomic number of the element.
	 */
	public int num()
	{
		return atomNum;
	}
	
	class CloseListener extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			element.setVisible(false);
			element.dispose();
		}
	}

}
