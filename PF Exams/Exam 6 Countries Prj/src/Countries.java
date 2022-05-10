import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import java.sql.*;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Countries {

	protected Shell shlCountries;
	private Text textArea;
	private Text textPopulation;
	private Text textCapital;
	private Combo comboCountry;
	private Connection con;
	private Statement st;
	private ResultSet rs;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Countries window = new Countries();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlCountries.open();
		shlCountries.layout();
		while (!shlCountries.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		shlCountries = new Shell();
		shlCountries.setSize(627, 358);
		shlCountries.setText("Countries");

		Label label = new Label(shlCountries, SWT.NONE);
		label.setBounds(50, 21, 129, 15);
		label.setText("\u0418\u0437\u0431\u0435\u0440\u0435\u0442\u0435 \u0434\u044A\u0440\u0436\u0430\u0432\u0430:");

		comboCountry = new Combo(shlCountries, SWT.NONE);
		comboCountry.setBounds(209, 18, 178, 23);

		textArea = new Text(shlCountries, SWT.BORDER);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setBounds(50, 91, 76, 21);

		textPopulation = new Text(shlCountries, SWT.BORDER);
		textPopulation.setEnabled(false);
		textPopulation.setEditable(false);
		textPopulation.setBounds(144, 91, 76, 21);

		textCapital = new Text(shlCountries, SWT.BORDER);
		textCapital.setEnabled(false);
		textCapital.setEditable(false);
		textCapital.setBounds(241, 91, 76, 21);

		Label lblNewLabel = new Label(shlCountries, SWT.NONE);
		lblNewLabel.setBounds(59, 70, 55, 15);
		lblNewLabel.setText("\u041F\u043B\u043E\u0449");

		Label label_1 = new Label(shlCountries, SWT.NONE);
		label_1.setBounds(144, 70, 65, 15);
		label_1.setText("\u041D\u0430\u0441\u0435\u043B\u0435\u043D\u0438\u0435");

		Label label_2 = new Label(shlCountries, SWT.NONE);
		label_2.setBounds(249, 70, 55, 15);
		label_2.setText("\u0421\u0442\u043E\u043B\u0438\u0446\u0430");
		
		Button btnSearch = new Button(shlCountries, SWT.NONE);
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String country = comboCountry.getText();

				try {
					
					String SQL = "SELECT countries.country, countries.area, countries.population, capitals.capital from countries "
							+ "join capitals on countries.id = capitals.country where countries.country='" + country + "';";
					
					//System.out.println(SQL);

					st = con.createStatement();
					rs = st.executeQuery(SQL);
					while (rs.next()) {
						textArea.setText(rs.getString(2));
						textPopulation.setText(rs.getString(3));
						textCapital.setText(rs.getString(4));
					}

				} catch (SQLException r) {
					// TODO Auto-generated catch block
					r.printStackTrace();
				}
				
			}
		});
		btnSearch.setBounds(408, 91, 75, 25);
		btnSearch.setText("Search");

		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/countries", "root", "");
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM countries;");

			while (rs.next()) {
				comboCountry.add(rs.getString(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
