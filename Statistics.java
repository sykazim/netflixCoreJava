package netflix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entity.NetflixData;

public class Statistics {

	private static List<NetflixData> netflixDataList = new ArrayList<>();

	public static void main(String[] args) throws IOException, ParseException {

		extractCSVData();

		System.out.println("Press 1 to list records on the basis of Type ");
		System.out.println("Press 2 to list records on the basis of Type and Date Filter ");
		System.out.println("Press 3 to list records on the basis of Listed_in ");
		System.out.println("Press 4 to list records on the basis of Listed_in and Date Filter ");
		System.out.println("Press 5 to list records on the basis of Type and Country ");
		System.out.println("Press 6 to list records on the basis of Type and Country and date Filter");
		System.out.println("7: Program termination");

		Scanner in = new Scanner(System.in);

		lp: while (true) {

			System.out.print("Make your choice: ");
			int choice = Integer.parseInt(in.nextLine());
			int n;
			String type;
			String listedIn;
			String startDate;
			String endDate;
			String country;
			switch (choice) {
			case 1:
				System.out.print("Enter number of items");
				n = Integer.parseInt(in.nextLine());
				System.out.print("Enter type");
				type = in.nextLine();
				listRecordsByType(type, n);
				break;
			case 2:
				System.out.print("Enter number of items");
				n = Integer.parseInt(in.nextLine());
				System.out.print("Enter type");
				type = in.nextLine();
				System.out.print("Enter start date");
				startDate = in.nextLine();
				System.out.print("Enter end date");
				endDate = in.nextLine();
				// Date startDate = new SimpleDateFormat("dd-MMM-yy").parse("10-Aug-10");
				// Date endDate = new SimpleDateFormat("dd-MMM-yy").parse("10-Aug-25");
				listRecordsByType(type, n, new SimpleDateFormat("dd-MMM-yy").parse(startDate),
						new SimpleDateFormat("dd-MMM-yy").parse(endDate));
				break;
			case 3:
				System.out.print("Enter number of items");
				n = Integer.parseInt(in.nextLine());
				System.out.print("Enter listedin");
				listedIn = in.nextLine();
				listRecordsByListedIn(listedIn, n);
				break;
			case 4:
				System.out.print("Enter number of items");
				n = Integer.parseInt(in.nextLine());
				System.out.print("Enter listedin");
				listedIn = in.nextLine();
				System.out.print("Enter start date");
				startDate = in.nextLine();
				System.out.print("Enter end date");
				endDate = in.nextLine();
				listRecordsByListedIn(listedIn, n,new SimpleDateFormat("dd-MMM-yy").parse(startDate),
						new SimpleDateFormat("dd-MMM-yy").parse(endDate));
				break;
			case 5:
				System.out.print("Enter number of items");
				n = Integer.parseInt(in.nextLine());
				System.out.print("Enter type");
				type = in.nextLine();
				System.out.print("Enter country");
				country = in.nextLine();
				listRecordsByTypeAndCountry(type,country,n);
				break;
			case 6:
				System.out.print("Enter number of items");
				n = Integer.parseInt(in.nextLine());
				System.out.print("Enter type");
				type = in.nextLine();
				System.out.print("Enter country");
				country = in.nextLine();
				System.out.print("Enter start date");
				startDate = in.nextLine();
				System.out.print("Enter end date");
				endDate = in.nextLine();
				listRecordsByTypeAndCountry(type,country,n,new SimpleDateFormat("dd-MMM-yy").parse(startDate),
						new SimpleDateFormat("dd-MMM-yy").parse(endDate));
				break;
			case 7:
				break lp;

			default:
				System.out.println("inavlid choice try again");
			}

		}
		in.close();

		// System.out.println(empList);
		// System.out.println(empList.size());

	}

	public static void listRecordsByTypeAndCountry(String type, String country, int n) {
		System.out.println("type and country=================");
		int counter = 0;
		for (NetflixData data : netflixDataList) {
			if (data.getType().equalsIgnoreCase(type) && data.getCountry().equalsIgnoreCase(country)) {
				System.out.println(data);
				counter++;
			}
			if (counter >= n) {
				break;
			}
		}
	}

	public static void listRecordsByTypeAndCountry(String type, String country, int n, Date startDate, Date endDate) {
		System.out.println("type and country================= dates");
		int counter = 0;
		for (NetflixData data : netflixDataList) {
			if (data.getType().equalsIgnoreCase(type) && data.getCountry().equalsIgnoreCase(country)
					&& data.getDateAdded().after(startDate) && data.getDateAdded().before(endDate)) {
				System.out.println(data);
				counter++;
			}
			if (counter >= n) {
				break;
			}
		}
	}

	public static void listRecordsByListedIn(String listedIn, int n) {
		System.out.println("listed in ===================");
		int counter = 0;
		for (NetflixData data : netflixDataList) {
			if (data.getListedIn().equalsIgnoreCase(listedIn)) {
				System.out.println(data);
				counter++;
			}
			if (counter >= n) {
				break;
			}
		}
	}

	public static void listRecordsByListedIn(String listedIn, int n, Date startDate, Date endDate) {
		System.out.println("listed in =================== dates");
		int counter = 0;
		
		for (NetflixData data : netflixDataList) {
			if (data.getListedIn().equalsIgnoreCase(listedIn) && data.getDateAdded().after(startDate)
					&& data.getDateAdded().before(endDate)) {
				System.out.println(data);
				counter++;
			}
			if (counter >= n) {
				break;
			}
		}
	}

	public static void listRecordsByType(String type, int n) {
		System.out.println("type=====================");
		int counter = 0;
		for (NetflixData data : netflixDataList) {
			if (data.getType().equalsIgnoreCase(type)) {
				System.out.println(data);
				counter++;
			}
			if (counter >= n) {
				break;
			}
		}
	}

	public static void listRecordsByType(String type, int n, Date startDate, Date endDate) {
		int counter = 0;
		for (NetflixData data : netflixDataList) {
			if (data.getType().equalsIgnoreCase(type) && data.getDateAdded().after(startDate)
					&& data.getDateAdded().before(endDate)) {
				System.out.println(data);
				counter++;
			}
			if (counter >= n) {
				break;
			}
		}
	}

	private static void extractCSVData() throws NumberFormatException, IOException, ParseException {
		BufferedReader reader = new BufferedReader(new FileReader("./csvf/netflix_titles1.csv"));

		// read file line by line
		String line = null;
		boolean header = true;
		Scanner scanner = null;
		int index = 0;
		netflixDataList = new ArrayList<>();

		while ((line = reader.readLine()) != null) {
			NetflixData netflixData = new NetflixData();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			String[] splitted = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
			// System.out.println(Arrays.toString(splitted));
			// Arrays.stream(splitted).forEach(num -> System.out.println(num));
			// System.out.println("hello1");
			int length = 0;
			while (length < splitted.length && !header) {
				String data = splitted[length++];

				if (index == 0) {

					netflixData.setShowId(data);
				} else if (index == 1) {

					netflixData.setType(data);
				} else if (index == 2) {

					netflixData.setTitle(data);
				} else if (index == 3) {
					netflixData.setDirector(data);
				} else if (index == 4) {
					netflixData.setCast(data);
				} else if (index == 5) {
					// System.out.println(data);
					netflixData.setCountry(data);
				} else if (index == 6 && data != null && data.length() != 0) {
					// System.out.println(data);
					netflixData.setDateAdded(new SimpleDateFormat("dd-MMM-yy").parse(data));
					// netflixData.setDateAdded(data);
				} else if (index == 7) {
					netflixData.setReleaseYear(Integer.parseInt(data));
				} else if (index == 8) {
					netflixData.setRating(data);
				} else if (index == 9) {
					netflixData.setDuration(data);
				} else if (index == 10) {
					netflixData.setListedIn(data);
				} else if (index == 11) {
					netflixData.setDescription(data);
				} else if (index == 12) {
					break;
				}

				index++;
				// System.out.println("hello2");
			}
			index = 0;
			if (!header) {
				netflixDataList.add(netflixData);
			}
			header = false;
		}

		// close reader
		reader.close();

	}

}
