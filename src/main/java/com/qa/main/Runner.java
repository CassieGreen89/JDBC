package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {

		DBConnector dbQuery = new DBConnector();

		String action = "";
		action = getAction();

		switch (action) {
		
		case "create table":
			System.out.println("Please enter the table name");
			String tableName = scanner.nextLine();
//			System.out.println("Please enter a column name");
//			String custID = scanner.nextLine();
//			System.out.println("Please enter a data type");
//			String dataType0 = scanner.nextLine();
//			System.out.println("Please enter a column name");
//			String column1 = scanner.nextLine();
//			System.out.println("Please enter a data type");
//			String dataType1 = scanner.nextLine();
//			System.out.println("Please enter a column name");
//			String column2 = scanner.nextLine();			
//			System.out.println("Please enter a data type");
//			String dataType2 = scanner.nextLine();			
			dbQuery.createTable(tableName);
//			, custID, dataType0, 
//					column1, dataType1, column2, dataType2);
			break;		
			
		case "drop table":
			System.out.println("What table do you want to drop");
			String tableToDrop = scanner.nextLine();
			dbQuery.deleteTable(tableToDrop);
			break;

		case "create row":
			System.out.println("Please enter your first name");
			String fName = scanner.nextLine();
			System.out.println("Please enter your last name");
			String lName = scanner.nextLine();
			dbQuery.createPerson(fName, lName);
			break;

		case "read":
			System.out.println("Showing data:");
			dbQuery.readPeople();
			break;

		case "update":
			System.out.println("Please enter an id");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Please enter a new first name");
			String fname = scanner.nextLine();
			System.out.println("Please enter a new last name");
			String lname = scanner.nextLine();
			dbQuery.updatePerson(id, fname, lname);
			break;

		case "delete":
			System.out.println("Please enter an id");
			int id2 = scanner.nextInt();
			scanner.nextLine(); // Capture enter key
			dbQuery.deletePerson(id2);
			break;
			
		default:
			System.out.println("No matches found!");
			break;
		}

	}

	private static String getAction() {
		System.out.println("What do you want to do next? create table, drop table "
				+ "create row, read, update, delete");
		return scanner.nextLine().toLowerCase();
	}

}