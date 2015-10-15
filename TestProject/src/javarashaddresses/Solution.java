package javarashaddresses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		Map<String, ArrayList<String>> addresses = new HashMap<String, ArrayList<String>>();

		while (true) {
			System.out.print("city : ");
			String city = reader.readLine();
			if (city.isEmpty())
				break;

			System.out.print("name : ");
			if (!addresses.containsKey(city)) {
				addresses.put(city, new ArrayList<String>());
				addresses.get(city).add(reader.readLine());

			} else
				addresses.get(city).add(reader.readLine());
			
		}

		System.out.print("See in city: ");
		String cityName = reader.readLine();

		if (addresses.containsKey(cityName)) {
			System.out.println(addresses.get(cityName).toString());
		}
		addresses = null;
		
		

	}

}
