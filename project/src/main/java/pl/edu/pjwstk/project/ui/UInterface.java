package pl.edu.pjwstk.project.ui;

import java.io.IOException;
import java.sql.SQLException;

public interface UInterface {
	
	void selector() throws IOException, SQLException;
	void status() throws IOException, SQLException;
	void continueWork() throws IOException, SQLException;
	void goBack() throws IOException, SQLException;
}
