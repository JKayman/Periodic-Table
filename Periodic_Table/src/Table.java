
import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
 * @author Kirill Proshakov
 *
 */
public class Table extends JPanel
{
    /**
     * 
     * @author Kirill Proshakov
     *
     */
    // class Tablem extends JFrame
    // {

    Timer tmr = new Timer(1000, new Listener()), mistake = new Timer(1000, new Listener()),
	    pressed = new Timer(1, new pressed_Listener());
    JFrame periodic_table;
    JButton[] field = new JButton[90];
    JButton properties, memory_game;
    Element[] table = new Element[90];
    JLabel board = new JLabel();
    boolean game = false, started = false, wrong = false;
    Random rnd = new Random();
    int score, index, time, windex;
    String name;
    JLabel find = new JLabel();

    /**
     * 
     * @param type
     */
    public Table()
    {
	table[0] = new Element("H", "Hydrogen", "72.8", "I", "1", "1.00794", "1311", "53", "2.1");
	table[1] = new Element("He", "Helium", "0", "0", "2", "4.002602", "2372.3", "31", "N/A");
	table[2] = new Element("Li", "Lithium", "59.6", "I", "3", "6.941", "520.1", "167", "0.98");
	table[3] = new Element("Be", "Beryllium", "0", "II", "4", "9.012182", "899.5", "112", "1.57");
	table[4] = new Element("B", "Boron", "26.7", "III", "5", "10.811", "800.6", "87", "2.04");
	table[5] = new Element("C", "Carbon", "153.9", "IV", "6", "12.0107", "1086.5", "67", "2.55");
	table[6] = new Element("N", "Nitrogen", "7", "III", "7", "14.0067", "1402.3", "56", "3.04");
	table[7] = new Element("O", "Oxygen", "141", "II", "8", "15.9994", "1313.9", "48", "3.44");
	table[8] = new Element("F", "Fluorine", "328", "I", "9", "18.9984032", "1681", "42", "3.98");
	table[9] = new Element("Ne", "Neon", "0", "0", "10", "20.1797", "2080.7", "38", "N/A");

	table[10] = new Element("Na", "Sodium", "52.8", "I", "11", "22.98977", "495.8", "190", "0.93");
	table[11] = new Element("Mg", "Magnesium", "0", "II", "12", "24.305", "737.7", "145", "1.31");
	table[12] = new Element("Al", "Alluminum", "42.5", "III", "13", "26.981538", "577.5", "118", "1.61");
	table[13] = new Element("Si", "Silicon", "133.6", "IV", "14", "28.0855", "786.5", "111", "1.9");
	table[14] = new Element("P", "Phosphorus", "72", "V", "15", "30.973761", "1011.8", "98", "2.19");
	table[15] = new Element("S", "Sulfur", "200", "VI", "16", "32.065", "999.6", "88", "2.58");
	table[16] = new Element("Cl", "Chlorine", "349", "V", "17", "35.453", "1251.2", "79", "3.16");
	table[17] = new Element("Ar", "Argon", "0", "0", "18", "39.948", "1520.6", "71", "N/A");

	table[18] = new Element("K", "Potassium", "48.4", "I", "19", "39.0983", "418.8", "243", "0.82");
	table[19] = new Element("Ca", "Calcium", "2.37", "II", "20", "40.078", "589.8", "194", "1");
	table[20] = new Element("Sc", "Scandium", "18.1", "III", "21", "44.95591", "633.1", "184", "1.36");
	table[21] = new Element("Ti", "Titanium", "7.6", "IV", "22", "47.867", "658.8", "176", "1.54");
	table[22] = new Element("V", "Vanadium", "50.6", "V", "23", "50.9415", "650.9", "171", "1.63");
	table[23] = new Element("Cr", "Chromium", "64.3", "VI", "24", "51.9961", "652.9", "166", "1.66");
	table[24] = new Element("Mn", "Manganese", "0", "IV", "25", "54.938049", "54.938049", "161", "1.55");
	table[25] = new Element("Fe", "Iron", "15.7", "III", "26", "55.845", "762.5", "156", "1.83");
	table[26] = new Element("Co", "Cobalt", "63.7", "IV", "27", "58.9332", "760.4", "152", "1.88");
	table[27] = new Element("Ni", "Nickel", "112", "II", "28", "58.6934", "737.1", "149", "1.91");
	table[28] = new Element("Cu", "Copper", "118.4", "II", "29", "63.546", "745.5", "145", "1.9");
	table[29] = new Element("Zn", "Zinc", "0", "II", "30", "65.409", "906.4", "142", "1.65");
	table[30] = new Element("Ga", "Gallium", "28.9", "III", "31", "69.723", "578.8", "136", "1.81");
	table[31] = new Element("Ge", "Germanium", "119", "IV", "32", "72.64", "762", "125", "2.01");
	table[32] = new Element("As", "Arsenic", "78", "V", "33", "74.9216", "947", "114", "2.18");
	table[33] = new Element("Se", "Selenium", "195", "VI", "34", "78.96", "941", "103", "2.55");
	table[34] = new Element("Br", "Bromine", "324.6", "V", "35", "79.904", "1139.9", "94", "2.96");
	table[35] = new Element("Kr", "Krypton", "0", "II", "36", "83.798", "1350.8", "88", "3");

	table[36] = new Element("Rb", "Rubidium", "46.9", "I", "37", "85.4678", "403", "265", "0.82");
	table[37] = new Element("Sr", "Strontium", "5.03", "II", "38", "87.62", "549.5", "219", "0.95");
	table[38] = new Element("Y", "Yttrium", "29.6", "III", "39", "88.90585", "600", "212", "1.22");
	table[39] = new Element("Zr", "Zirconium", "41.1", "IV", "40", "91.224", "640.1", "206", "1.33");
	table[40] = new Element("Nb", "Niobium", "86.1", "V", "41", "92.90638", "652.1", "198", "1.6");
	table[41] = new Element("Mo", "Molybdenum", "71.9", "VI", "42", "95.94", "684.3", "190", "2.16");
	table[42] = new Element("Tc", "Technetium", "53", "VI", "43", "98", "702", "183", "1.9");
	table[43] = new Element("Ru", "Ruthenium", "101.3", "VI", "44", "101.07", "710.2", "178", "2.2");
	table[44] = new Element("Rh", "Rhodium", "109.7", "VI", "45", "102.9055", "719.7", "173", "2.28");
	table[45] = new Element("Pd", "Palladium", "53.7", "IV", "46", "106.42", "804.4", "169", "2.2");
	table[46] = new Element("Ag", "Silver", "125.6", "I", "47", "107.8682", "731", "165", "1.93");
	table[47] = new Element("Cd", "Cadmium", "0", "II", "48", "112.411", "867.8", "161", "1.69");
	table[48] = new Element("In", "Indium", "28.9", "III", "49", "114.818", "558.3", "156", "1.78");
	table[49] = new Element("Sn", "Tin", "107.3", "IV", "50", "118.71", "708.6", "145", "1.96");
	table[50] = new Element("Sb", "Antimony", "103.2", "V", "51", "121.76", "834", "166", "2.05");
	table[51] = new Element("Te", "Tellurium", "190.2", "VI", "52", "127.6", "869.3", "123", "2.1");
	table[52] = new Element("I", "Iodine", "295.2", "VII", "53", "126.90447", "1008.4", "115", "2.66");
	table[53] = new Element("Xe", "Xenon", "0", "VI", "54", "131.293", "1170.4", "108", "2.6");

	table[54] = new Element("Cs", "Cesium", "45.5", "I", "55", "132.90545", "375.7", "298", "0.79");
	table[55] = new Element("Ba", "Barium", "13.95", "II", "56", "137.327", "502.9", "253", "0.89");
	table[56] = new Element("La", "Lanthanum", "48", "III", "57", "138.9055", "538.1", "N/A", "1.27");
	table[57] = new Element("Hf", "Hafnium", "0", "IV", "72", "178.49", "658.5", "208", "1.3");
	table[58] = new Element("Ta", "Tantalum", "31", "V", "73", "180.9479", "761", "200", "1.5");
	table[59] = new Element("W", "Tungsten", "78.6", "VI", "74", "183.84", "770", "193", "2.36");
	table[60] = new Element("Re", "Rhenium", "14.5", "VII", "75", "186.207", "760", "188", "1.9");
	table[61] = new Element("Os", "Osmium", "106.1", "VI", "76", "190.23", "840", "185", "2.2");
	table[62] = new Element("Ir", "Iridium", "151", "VI", "77", "192.217", "880", "180", "2.2");
	table[63] = new Element("Pt", "Platinum", "205.3", "VI", "78", "195.078", "870", "177", "2.28");
	table[64] = new Element("Au", "Gold", "222.8", "V", "79", "196.96655", "890.1", "174", "2.54");
	table[65] = new Element("Hg", "Mercury", "0", "II", "80", "200.59", "1007.1", "171", "2");
	table[66] = new Element("Tl", "Thallium", "19.2", "III", "81", "204.3833", "589.4", "156", "1.62");
	table[67] = new Element("Pb", "Lead", "35.1", "IV", "82", "207.2", "715.6", "154", "2.33");
	table[68] = new Element("Bi", "Bismuth", "91.2", "V", "83", "208.98038", "703", "143", "2.02");
	table[69] = new Element("Po", "Polonium", "183.3", "VI", "84", "209", "812.1", "135", "2");
	table[70] = new Element("At", "Astatine", "270.1", "VII", "85", "210", "920", "127", "2.2");
	table[71] = new Element("Rn", "Radon", "0", "VI", "86", "222", "1037", "120", "N/A");
	// = new Element("", "", "", "", "", "", "", "", "");

	table[72] = new Element("Fr", "Francium", "N/A", "III", "87", "223", "380", "N/A", "0.7");
	table[73] = new Element("Ra", "Radium", "N/A", "II", "88", "226", "509.3", "N/A", "0.9");
	table[74] = new Element("Ac", "Actinium", "N/A", "III", "89", "227", "499", "N/A", "1.1");
	table[75] = new Element("Rf", "Rutherfordium", "N/A", "IV", "104", "261", "N/A", "N/A", "N/A");
	table[76] = new Element("Db", "Dubnium", "N/A", "V", "105", "262", "N/A", "N/A", "N/A");
	table[77] = new Element("Sg", "Seaborgium", "N/A", "VI", "106", "266", "N/A", "N/A", "N/A");
	table[78] = new Element("Bh", "Bohrium", "N/A", "VII", "107", "264", "N/A", "N/A", "N/A");
	table[79] = new Element("Hs", "Hassium", "N/A", "N/A", "108", "269", "N/A", "N/A", "N/A");
	table[80] = new Element("Mt", "Meitnerium", "N/A", "N/A", "109", "268", "N/A", "N/A", "N/A");
	table[81] = new Element("Ds", "Darmstadtium", "N/A", "N/A", "110", "269", "N/A", "N/A", "N/A");
	table[82] = new Element("Rg", "Roentgenium", "N/A", "N/A", "111", "272", "N/A", "N/A", "N/A");
	table[83] = new Element("Uub", "Ununbium", "N/A", "N/A", "112", "285", "N/A", "N/A", "N/A");
	table[84] = new Element("Uut", "Ununtrium", "N/A", "N/A", "113", "284", "N/A", "N/A", "N/A");
	table[85] = new Element("Uuq", "Ununquadium", "N/A", "N/A", "114", "289", "N/A", "N/A", "N/A");
	table[86] = new Element("Uup", "Ununpentium", "N/A", "N/A", "115", "288", "N/A", "N/A", "N/A");
	table[87] = new Element("Uuh", "Ununhexium", "N/A", "N/A", "116", "292", "N/A", "N/A", "N/A");
	table[88] = new Element("Uus", "Ununseptium", "N/A", "N/A", "117", "N/A", "N/A", "N/A", "N/A");
	table[89] = new Element("Uuo", "Ununoctium", "N/A", "N/A", "118", "294", "N/A", "N/A", "N/A");

	buildTable();
	periodic_table.setTitle("Periodic Table Trends");
	periodic_table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	periodic_table.setSize(1000, 600);
	periodic_table.setResizable(true);
	periodic_table.setVisible(true);
    }

    /**
     * Composes a JFrame that holds all the components of the periodic table
     */
    public void buildTable()
    {
	periodic_table = new JFrame();
	setLayout(new GridBagLayout());

	GridBagConstraints gc = new GridBagConstraints();

	gc.gridx = 0;
	gc.gridy = 0;
	gc.gridheight = 1;
	gc.gridwidth = 1;
	gc.weightx = 1;
	gc.weighty = 1;
	gc.anchor = GridBagConstraints.NORTHEAST;
	gc.fill = GridBagConstraints.HORIZONTAL;

	ButtonListener bl = new ButtonListener();
	for (int i = 0; i < field.length; i++)
	{
	    field[i] = new JButton();
	    field[i].addActionListener(bl);
	}

	table[0].mini(field[0]);
	this.add(field[0], gc);
	gc.gridx += 17;

	table[1].mini(field[1]);
	this.add(field[1], gc);
	gc.gridx -= 17;
	gc.gridy++;

	table[2].mini(field[2]);
	this.add(field[2], gc);
	gc.gridx++;
	table[3].mini(field[3]);
	this.add(field[3], gc);
	gc.gridx += 3;
	gc.gridwidth = 5;
	gc.gridheight = 2;
	gc.fill = GridBagConstraints.NONE;
	
	board.setFont(new Font("Tahoma", Font.BOLD, 15));
	
	this.add(board, gc);
	
	gc.gridwidth = 1;
	gc.gridheight = 1;
	
	gc.fill = GridBagConstraints.HORIZONTAL;
	gc.gridx += 8;

	for (int i = 4; i < 10; i++)
	{
	    table[i].mini(field[i]);
	    this.add(field[i], gc);
	    gc.gridx++;
	}

	gc.gridx = 0;
	gc.gridy++;
	table[10].mini(field[10]);
	this.add(field[10], gc);
	gc.gridx++;

	table[11].mini(field[11]);
	this.add(field[11], gc);

	gc.gridx += 3;

	gc.gridwidth = 6;
	find.setFont(new Font("Tahoma", Font.BOLD, 32));
	this.add(find, gc);

	gc.gridx += 8;
	gc.gridwidth = 1;

	for (int i = 12; i < 18; i++)
	{
	    table[i].mini(field[i]);
	    this.add(field[i], gc);
	    gc.gridx++;
	}
	gc.gridx = 0;
	gc.gridy++;

	for (int i = 18; i < 36; i++)
	{
	    table[i].mini(field[i]);
	    this.add(field[i], gc);
	    gc.gridx++;
	}

	gc.gridx = 0;
	gc.gridy++;

	for (int i = 36; i < 54; i++)
	{
	    table[i].mini(field[i]);
	    this.add(field[i], gc);
	    gc.gridx++;
	}

	gc.gridx = 0;
	gc.gridy++;

	for (int i = 54; i < 72; i++)
	{
	    table[i].mini(field[i]);
	    this.add(field[i], gc);
	    gc.gridx++;
	}

	gc.gridx = 0;
	gc.gridy++;

	for (int i = 72; i < 90; i++)
	{
	    table[i].mini(field[i]);
	    this.add(field[i], gc);
	    gc.gridx++;
	}

	properties = new JButton("Properties");

	gc.gridwidth = 2;
	gc.gridx = 0;
	gc.gridy++;

	pressed.start();

	this.add(properties, gc);

	memory_game = new JButton("Start the game");
	memory_game.addActionListener(bl);
	gc.gridx += 16;
	this.add(memory_game, gc);

	periodic_table.add(this);

    }

    /**
     * Adds the periodic trendlines onto the table
     */
    public void paint(Graphics g)
    {
	super.paint(g);
	Graphics2D g2 = (Graphics2D) g;

	if (properties.getModel().isPressed())
	{
	    Polygon head_1 = new Polygon(), head_2 = new Polygon();

	    head_1.addPoint(820, 411);
	    head_1.addPoint(920, 451);
	    head_1.addPoint(820, 491);

	    g2.setColor(new Color(110, 210, 255));
	    g2.fillPolygon(head_1);

	    g2.fillRect(70, 431, 750, 40);

	    head_2.addPoint(826, 150);
	    head_2.addPoint(926, 150);
	    head_2.addPoint(876, 100);

	    g2.fillPolygon(head_2);

	    g2.fillRect(841, 150, 70, 250);

	    g2.setColor(new Color(51, 102, 102));
	    g2.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 20));

	    g2.drawString("Ionization Energy & Electron Affinity increase. Atomic radius decreases", 80, 456);

	    g2.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 15));
	    g2.drawString("Ionization", 846, 159);
	    g2.drawString("Energy &", 846, 179);
	    g2.drawString("Electron", 846, 199);
	    g2.drawString("Affinity", 846, 219);
	    g2.drawString("increase.", 846, 239);
	    g2.drawString("Atomic", 846, 259);
	    g2.drawString("radius", 846, 279);
	    g2.drawString("decreases", 845, 299);
	}

    }

    class ButtonListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e)
	{
	    if (e.getSource() == memory_game)
	    {
		start_game();
	    } else
	    {
		for (int i = 0; i < 90; i++)
		{
		    if (e.getSource() == field[i])
		    {

			if (!game)
			{
			    table[i].frame();

			} else
			{
			    if (!started)
			    {
				tmr.start();
			    }
			    if (i == index)
			    {
				score++;

				index = rnd.nextInt(89);
				name = "Find " + table[index].fulln;
				find.setText(name);
				board.setText("Score: " + score + " Time Left: " + time + "s");

			    } else
			    {
				if (score != 0)
				{
				    score--;
				}
				field[index].setBackground(Color.RED);
				mistake.start();
				board.setText("Score: " + score + " Time Left: " + time + "s");

				windex = index;
				index = rnd.nextInt(89);
				name = "Find " + table[index].fulln;
				find.setText(name);
			    }

			}
		    }

		}
	    }
	}
    }

    class pressed_Listener implements ActionListener
    {
	boolean press;

	public void actionPerformed(ActionEvent e)
	{
	    if (e.getSource() == pressed)
	    {

		if (properties.getModel().isPressed())
		{
		    if (!press)
		    {
			open_Properties();
			repaint();
			press = true;
		    }

		} else
		{
		    if (press)
		    {
			press = false;
			close_Properties();
			repaint();
		    }

		}
	    }
	}
    }

    class Listener implements ActionListener
    {
	public void actionPerformed(ActionEvent e)
	{
	    if (e.getSource() == tmr)
	    {

		time--;
		board.setText("Score: " + score + " Time Left: " + time + "s");
		if (time == 0)
		{
		    game = false;
		    find.setText("");
		    JOptionPane.showMessageDialog(null,
			    "The game is over! \nYour score is " + score);
		    board.setVisible(false);
		    tmr.stop();
		}

	    } else if (e.getSource() == mistake)
	    {
		field[windex].setBackground(table[windex].color);
		mistake.stop();
	    }

	}
    }

    class CloseListener extends WindowAdapter
    {
	public void windowClosing(WindowEvent e)
	{
	    periodic_table.setVisible(false);
	    periodic_table.dispose();

	}
    }

    public void open_Properties()
    {
	for (int i = 0; i < field.length; i++)
	{

	    field[i].setBackground(new Color(51, 51, 102));
	}

    }

    public void close_Properties()
    {
	for (int i = 0; i < field.length; i++)
	{
	    field[i].setBackground(table[i].color);
	}
    }

    public void start_game()
    {
	JOptionPane.showMessageDialog(null,
		"Click on the elements names of which will be shown."
		+ "\nYou will have 30 seconds to find as many elements as you can."
			+ "\n1 Point will be granted for each found element and deducted for each wrong guess.");
	score = 0;
	time = 30;
	game = true;
	index = rnd.nextInt(89);
	name = "Find " + table[index].fulln;
	find.setText(name);
	board.setVisible(true);
	board.setText("Score: " + score + "  Time Left: " + time + " s.");

    }
    // }

    public static void main(String[] args)
    {
	new Table();

    }

}
