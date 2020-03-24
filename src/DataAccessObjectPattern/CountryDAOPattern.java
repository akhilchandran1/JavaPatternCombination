package DataAccessObjectPattern;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import BuilderDesignPattern.country;
import DAOImpl.CountryDAOImpl;
import DataTransferObjectPattern.Country;
import DataTransferObjectPattern.continent;

public class CountryDAOPattern {

	private JTable table; // table
	private DefaultTableModel DTmodel; // Default table model
	public JFrame frame; // frame
	private JTextField Code;
	private JTextField Name;
	private JComboBox<?> Continent;
	private JTextField SurfaceArea;
	private JTextField HeadOfState;
	private JTextField FindByCode;
	private JTextField FindByName;

	CountryDAO countryDAO = new CountryDAOImpl(); // calling method

	public CountryDAOPattern() {

		CountryTable();
	}

	public void CountryTable() {

		// create JFrame and JTable
		frame = new JFrame("Country Table");
		table = new JTable();

		// create a table model and set a Column Identifiers to this model
		final Object[] columns = { "Code", "Name", "Continent", "SurfaceArea", "HeadOfState" }; // column title
		DTmodel = new DefaultTableModel();
		DTmodel.setColumnIdentifiers(columns);

		// set the model to the table
		table.setModel(DTmodel);

		// Create and install the table's row sorter.

		final TableRowSorter<DefaultTableModel> sort;
		sort = new TableRowSorter<DefaultTableModel>(DTmodel);
		table.setRowSorter(sort);

		// add the Table to the scrollPane
		JScrollPane scrollpane = new JScrollPane(table);
		frame.add(scrollpane);

		// Change A JTable Font Size, Row Height
		Font font = new Font("Tahoma", 1, 12);
		table.setFont(font);
		table.setRowHeight(40);

		// create JTextFields
		Code = new JTextField();
		Name = new JTextField();
		SurfaceArea = new JTextField();
		HeadOfState = new JTextField();
		FindByCode = new JTextField();
		FindByName = new JTextField();

		// create JComboBox
		String options[] = { "Asia", "Europe", "North America", "Africa", "Oceania", "Antarctica", "South America",
				"Wrong Continent to try enum" };
		Continent = new JComboBox<Object>(options);

		// Create JLabel
		JLabel LCode = new JLabel("Code");
		JLabel LName = new JLabel("Name");
		JLabel LContinent = new JLabel("Continent");
		JLabel LSurfaceArea = new JLabel("Surface Area");
		JLabel LHeadOfState = new JLabel("Head Of State");

		// create JButtons
		JButton btnSaveNewCountry = new JButton("Save a new country in the database");
		JButton btnRetrieveAllRecords = new JButton("Retrieve all records");
		JButton btnListAllCountries = new JButton("List all countries in the database");
		JButton btnFindCountryByCountryCode = new JButton("Find a country by country code");
		JButton btnFindCountryByName = new JButton("Find a country by name");

		btnSaveNewCountry.setBackground(Color.RED);// add color in button

		/*
		 * //giving border color for textField FindByCode.setBorder(new
		 * LineBorder(Color.green,1)); FindByName.setBorder(new
		 * LineBorder(Color.green,1));
		 */

		// Specifying where each text field to be
		Code.setBounds(250, 500, 150, 50);
		Name.setBounds(410, 500, 200, 50);
		Continent.setBounds(620, 500, 200, 50);
		SurfaceArea.setBounds(830, 500, 200, 50);
		HeadOfState.setBounds(1040, 500, 200, 50);
		FindByCode.setBounds(20, 160, 210, 50);
		FindByName.setBounds(20, 300, 210, 50);

		// Specifying where each JLabel to be
		LCode.setBounds(310, 470, 100, 40);
		LName.setBounds(500, 470, 100, 40);
		LContinent.setBounds(700, 470, 100, 40);
		LSurfaceArea.setBounds(900, 470, 100, 40);
		LHeadOfState.setBounds(1100, 470, 100, 40);

		// Specifying where each button to be
		btnRetrieveAllRecords.setBounds(20, 20, 210, 50);
		btnListAllCountries.setBounds(20, 80, 210, 50);
		btnFindCountryByCountryCode.setBounds(20, 220, 210, 50);
		btnFindCountryByName.setBounds(20, 360, 210, 50);
		btnSaveNewCountry.setBounds(20, 500, 210, 50);

		// create JScrollPane
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(250, 20, 980, 440);

		frame.setLayout(null);

		frame.add(pane); // add JScrollPane to JFrame

		// add JTextFields to the JFrame
		frame.add(Code);
		frame.add(Name);
		frame.add(Continent);
		frame.add(SurfaceArea);
		frame.add(HeadOfState);
		frame.add(FindByCode);
		frame.add(FindByName);

		// add JLabels to the JFrame
		frame.add(LCode);
		frame.add(LName);
		frame.add(LContinent);
		frame.add(LSurfaceArea);
		frame.add(LHeadOfState);

		// add JButtons to the JFrame
		frame.add(btnRetrieveAllRecords);
		frame.add(btnListAllCountries);
		frame.add(btnFindCountryByCountryCode);
		frame.add(btnFindCountryByName);
		frame.add(btnSaveNewCountry);

		// adding actionListoner to button
		btnRetrieveAllRecords.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				PopulateData(); // calling PopulateData

			}
		});

		btnSaveNewCountry.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				conditions(); // calling conditions

			}
		});

		btnFindCountryByCountryCode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				FindCountryByCode(); // calling FindCountryByCode

			}
		});

		btnFindCountryByName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				FindCountryByCountryName(); // calling FindCountryByCountryName
			}
		});

		btnListAllCountries.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				ListAllCountries(); // calling ListAllCountries

			}
		});

		frame.setSize(1250, 600);// frame size
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit on close
		frame.setVisible(true);

	} // end CountryTable

	// Populate data from database
	public void PopulateData() {

		RefreshTable(); // calling RefreshTable
		// getting all the data from country table
		for (Country country : countryDAO.ListAllCountry()) {

			String surfaceArea = String.valueOf(country.getSurfaceArea()); // converting float to String

			// adding data to table
			String[] data = { country.getCode(), country.getName(), country.getContinent(), surfaceArea,
					country.getHeadOfState() };
			((DefaultTableModel) table.getModel()).addRow(data);

		}
	}// end PopulateData

	// ListAllCountries
	public void ListAllCountries() {

		RefreshTable(); // calling RefreshTable

		// getting all the data from country table
		for (Country country : countryDAO.ListAllCountry()) {

			String surfaceArea = String.valueOf(country.getSurfaceArea()); // converting float to String

			// adding data to table
			String[] data = { "", country.getName(), "", "", "" };
			((DefaultTableModel) table.getModel()).addRow(data);

		}

	}// ListAllCountries

	// add new country
	public void addCountry() {

		float fSurfaceArea = Float.parseFloat(SurfaceArea.getText()); // converting String to float

		// Adding new country
		country NewCountry = new country.CountryBuilder().setCode(Code.getText()).setName(Name.getText())
				.setContinent(Continent.getSelectedItem().toString()).setSurfaceArea(fSurfaceArea)
				.setHeadOfState(HeadOfState.getText()).getCountry();

		countryDAO.addCountry(NewCountry); // countryDAOImpl method

		Refresh(); // calling refresh
		RefreshTable(); // calling refreshTable

	}// end addCountry

	// enumCheck
	public void enumCheck() {

		// getting enum constants and associated values
		continent asia = continent.ASIA;
		String asi = asia.getCont();
		continent europ = continent.EUROPE;
		String eur = europ.getCont();
		continent northAmerica = continent.NORTHAMERICA;
		String northAm = northAmerica.getCont();
		continent africa = continent.AFRICA;
		String afri = africa.getCont();
		continent oceania = continent.OCEANIA;
		String ocea = oceania.getCont();
		continent antarctica = continent.ANTARCTICA;
		String anta = antarctica.getCont();
		continent southAmerica = continent.SOUTHAMERICA;
		String southAme = southAmerica.getCont();

		// checking, is user input matching to enum
		if (asi == Continent.getSelectedItem() || eur == Continent.getSelectedItem()
				|| northAm == Continent.getSelectedItem() || afri == Continent.getSelectedItem()
				|| ocea == Continent.getSelectedItem() || anta == Continent.getSelectedItem()
				|| southAme == Continent.getSelectedItem()) {

			addCountry(); // calling addCountry

		} else {

			// show message dialog
			JOptionPane.showMessageDialog(null, Continent.getSelectedItem() + "-" + "is not a valid Continent");
		}
	} // end enumCheck

	// conditions
	public void conditions() {

		// Float.parseFloat(SurfaceArea.getText());

		try {

			// checking the length
			if (Code.getText().length() > 3) {

				// show message dialog
				JOptionPane.showMessageDialog(null, "code not allowed. Maximum length allowed is 3 ");

				// if its empty will print
			} else if (Code.getText().equals("")) {

				// show message dialog
				JOptionPane.showMessageDialog(null, " Please enter a Code ");

				// if its empty will print
			} else if (Name.getText().equals("")) {

				// show message dialog
				JOptionPane.showMessageDialog(null, "Please enter the Country Name");

				// if its empty will print
			} else if (SurfaceArea.getText().equals("")) {

				// show message dialog
				JOptionPane.showMessageDialog(null, "Please enter valid Surface Area");

				// if its empty will print
			} else if (HeadOfState.getText().equals("")) {

				// show message dialog
				JOptionPane.showMessageDialog(null, "Please enter Head Of State");

				// else call addCountry
			} else {

				floatNumberValidation(); // calling floatNumberValidation

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	} // end conditions

	public void floatNumberValidation() {

		// checking user input is a integer or float
		if (SurfaceArea.getText().matches("[-+]?[0-9]*\\.?[0-9]+")) {
			enumCheck(); // calling enumCheck
		} else {
			// show message dialog
			JOptionPane.showMessageDialog(null, "Please enter a valid Surface Area");
		}
	}

	// refresh
	public void Refresh() {

		// clearing text field
		Code.setText("");
		Name.setText("");
		SurfaceArea.setText("");
		HeadOfState.setText("");

	} // refresh

	// Refresh JTable
	public void RefreshTable() {

		// refreshing table
		DefaultTableModel Tablemodel = (DefaultTableModel) table.getModel();
		while (Tablemodel.getRowCount() > 0) {
			Tablemodel.setRowCount(0);
		}
	} // end Refresh JTable

	// FindCountryByCode
	public void FindCountryByCode() {

		RefreshTable(); // calling RefreshTable

		Country country = countryDAO.FindCountryByCode(FindByCode.getText());
		String surfaceArea = String.valueOf(country.getSurfaceArea()); // converting float to String

		// adding data to table
		String[] data = { country.getCode(), country.getName(), country.getContinent(), surfaceArea,
				country.getHeadOfState() };
		((DefaultTableModel) table.getModel()).addRow(data);

	}// end FindCountryByCode

	// FindCountryByCountryName
	public void FindCountryByCountryName() {

		RefreshTable(); // calling RefreshTable

		Country count = countryDAO.FindCountryByName(FindByName.getText());
		String surfaceArea = String.valueOf(count.getSurfaceArea()); // converting float to String

		// adding data to table
		String[] data = { count.getCode(), count.getName(), count.getContinent(), surfaceArea, count.getHeadOfState() };
		((DefaultTableModel) table.getModel()).addRow(data);

	}// end FindCountryByCountryName

}
