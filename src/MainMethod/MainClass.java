package MainMethod;

import java.awt.EventQueue;

import DataAccessObjectPattern.CountryDAOPattern;

public class MainClass {

	// Start the application

	public static void main(String[] args) { // main method
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Calling CountryDAOPattern
					CountryDAOPattern DAO = new CountryDAOPattern();
					DAO.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} // end catch
			}
		});
	}

}
