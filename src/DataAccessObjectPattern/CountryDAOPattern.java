package DataAccessObjectPattern;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import DAOImpl.CountryDAOImpl;
import DataTransferObjectPattern.Country;

public class CountryDAOPattern {

	private JTable table; // table
	private DefaultTableModel DTmodel; // Default table model
	public JFrame frame; // frame
	private JTextField Code;
	private JTextField Name;
	private JComboBox<?> Continent;
	private JTextField SurfaceArea;
	private JTextField HeadOfState;

	CountryDAO countryDAO = new CountryDAOImpl();

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
		
		//create JComboBox
		String options[] = {"Asia", "Europe", "North America", "Africa", "Oceania", "Antarctica", "South America"};
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

		// Specifying where each text field to be
		Code.setBounds(250, 500, 150, 50);
		Name.setBounds(410, 500, 200, 50);
		Continent.setBounds(620, 500, 200, 50);
		SurfaceArea.setBounds(830, 500, 200, 50);
		HeadOfState.setBounds(1040, 500, 200, 50);

		// Specifying where each JLabel to be
		LCode.setBounds(310, 470, 100, 40);
		LName.setBounds(500, 470, 100, 40);
		LContinent.setBounds(700, 470, 100, 40);
		LSurfaceArea.setBounds(900, 470, 100, 40);
		LHeadOfState.setBounds(1100, 470, 100, 40);

		// Specifying where each button to be
		btnRetrieveAllRecords.setBounds(20, 20, 210, 50);
		btnListAllCountries.setBounds(20, 80, 210, 50);
		btnFindCountryByCountryCode.setBounds(20, 140, 210, 50);
		btnFindCountryByName.setBounds(20, 200, 210, 50);
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

				PopulateData(); // calling method

			}
		});
		
		btnSaveNewCountry.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				addCountry();
			}
		});

		frame.setSize(1250, 600);// frame size
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit on close
		frame.setVisible(true);

	}

	// Populate data from database
	public void PopulateData() {

		for (Country country : countryDAO.ListAllCountry()) {

			String surfaceArea = String.valueOf(country.getSurfaceArea()); // converting float to String

			// adding data to table
			String[] data = { country.getCode(), country.getName(), country.getContinent(), surfaceArea,
					country.getHeadOfState() };
			((DefaultTableModel) table.getModel()).addRow(data);

		}
	}
	
	public void addCountry() {
		
		float fSurfaceArea = Float.parseFloat(SurfaceArea.getText()); // converting String to float
		
		Country NewCountry = new Country();
		NewCountry.setCode (Code.getText());
		NewCountry.setName (Name.getText());
		NewCountry.setContinent(Continent.getSelectedItem().toString());
		NewCountry.setSurfaceArea(fSurfaceArea);
		NewCountry.setHeadOfState(HeadOfState.getText());
		
		countryDAO.addCountry(NewCountry);
		
	}

}
