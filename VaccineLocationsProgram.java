// Tom Nguyen
// 11/29/24
// CPSC 39 project

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;

public class VaccineLocationsProgram {
    //arraylist
    // Code from class notes and previous assignment
	public static ArrayList<VaccineProviderInfo> records = new ArrayList<VaccineProviderInfo>();

    // Learned how to use a HashMap data structure from ChatGPT to count how many vaccination locations per city. 
    // *    Author: Chatgpt
    // *    Date: 2024
    // *    Availability: http://www.chatgpt.com
    // private restricts access to this cityProviders variable within this current class, so other classes can't directly access or modify this HashMap. This ensures encapsulation by hiding the data structure from outside classes, and so that we can only access/modify it in this same class. 
    // static makes it a class-level member so it is shared among all instances of the class. There's only one copy of cityProviders for the entire class, no matter how many objects of this class are created. This ensures a single and shared collection since it tracks data.
    // A city can have multiple providers, so the HashMap is storing a list of the VaccineProviderInfoFlu objects.
    // HashMap has the benefit of fast retrieval of all providers of a specific city using the city name as the key. 
    private static HashMap<String, List<VaccineProviderInfoFlu>> cityProviders = new HashMap<>();

	public static void main(String[] args) {
		//read in our data and create this records Arraylist
		//read in our data and put it in an arraylist
		Scanner input = null;
		// Reads in the Vaccines.gov__COVID-19_vaccinating_provider_locations
		try {
			input = new Scanner(new File("Vaccines.gov__COVID-19_vaccinating_provider_locations.csv"));
		} catch (FileNotFoundException e) {
			//file not found. Signals that an attempt to open the file denoted by a specified pathname has failed.
			System.out.println("file not found");
            // printStackTrace() helps the programmer to understand where the actual problem occurred. It helps to trace the exception.
			e.printStackTrace();
		}

		//reading in the header
		input.nextLine();

        // Code to parse through the file 
        // .hasNext Returns true if this scanner has another token in its input.
        while(input.hasNext()) {
            // .nextLine Advances this scanner past the current line and returns the input that was skipped.
            String record = input.nextLine();
            // Splits up with a comma because that is what we do with CSV files. 
            String[] fields = record.split(",");         

            records.add(new VaccineProviderInfo(
                fields[0],   // providerLocationGuid (Field 0)
                fields[1],   // locStoreNo (Field 1)
                fields[2],   // locPhone (Field 2)
                fields[3],   // locName (Field 3)
                fields[4],   // locAdminStreet1 (Field 4)
                fields[5],   // locAdminStreet2 (Field 5)
                fields[6],   // locAdminCity (Field 6)
                fields[7],   // locAdminState (Field 7)
                fields[8],   // locAdminZip (Field 8)
                fields[9],   // sundayHours (Field 9)
                fields[10],  // mondayHours (Field 10)
                fields[11],  // tuesdayHours (Field 11)
                fields[12],  // wednesdayHours (Field 12)
                fields[13],  // thursdayHours (Field 13)
                fields[14],  // fridayHours (Field 14)
                fields[15],  // saturdayHours (Field 15)
                fields[16],  // webAddress (Field 16)
                fields[17],  // preScreen (Field 17)
                fields[18],  // insuranceAccepted (Field 18)
                fields[19],  // walkinsAccepted (Field 19)
                fields[20],  // providerNotes (Field 20)
                fields[21],  // ndc (Field 21)
                fields[22],  // medName (Field 22)
                Boolean.parseBoolean(fields[23]), // inStock (Field 23) - parsed as boolean
                fields[24],  // supplyLevel (Field 24)
                fields[25],  // quantityLastUpdated (Field 25)
                fields[26],  // latitude (Field 26) - comes up with a bug if parsed as double, 
                             // double bug maybe because latitude/longitude at the top of the CSV is not a double
                             // might have to use isValidDouble if we use it as a Double  
                             // per the specification data file, it's probably because the data type is varchar
                fields[27],  // longitude (Field 27) - comes up with a bug if parsed as double
                fields[28],  // category (Field 28)
                fields[29],  // unnamedColumn (Field 29)
                Boolean.parseBoolean(fields[30]), // offersFreeMasks (Field 30) - parsed as boolean
                isValidInteger(fields[31]) ? Integer.parseInt(fields[31]) : 0, // minAgeMonths. 
                // a ternary operator. It works as a concise way to make a decision, similar to an if-else statement. 
                // checks if isValidInteger(fields[31]) is true (can be parsed as integer), if true, then the code after ? is executed. otherwise, if false and cannot be parsed as integer, then it returns a 0
                isValidInteger(fields[32]) ? Integer.parseInt(fields[32]) : 0, // minAgeYears
                Boolean.parseBoolean(fields[33])  // bridgeAccessProgram (Field 33) - parsed as boolean
            ));			
        }// end while loop of scanning in the excel CSV to the fields
        
        // Quicksort algorithm to sort the location store names alphabetically, to group the store chains together (Walgreens, CVS, Rite Aid, etc).
        // Quicksort is a sorting algorithm that repeatedly partitions the input into low and high parts (each part unsorted), and then recursively sorts each part. To partition, quicksort chooses a pivot to divide the data into low and high parts. The pivot can be any value within the array being sorted and is commonly the middle element's value.
        quicksort(records, 0, records.size() - 1);
        
        // Accepting the user's input for filtering locations by city/zip code.
        Scanner userInputScanner = new Scanner(System.in);
        System.out.println("This is a dataset of COVID vaccination locations. Please enter whether you want to filter by city/zip code(enter 'city' or 'zip')"); 
        String userInput = userInputScanner.nextLine();
        System.out.println("You entered: " + userInput);

        // Asks the user if they want to see all the COVID vaccine brands per location. 
        System.out.println("Would you like to see all the COVID vaccine brands offered? (Recommended only if filtering by zip, otherwise it will list too many locations.)");        
        System.out.println("The program will stop after the results, if you type in 'y' for yes. Otherwise, if you type 'n' (or any letter besides 'y'), it will ask if you want to how many flu vaccination locations/providers there are in Californian cities.");
        System.out.println("enter 'y' for yes, or 'n' for no");
        String userInputBrand = userInputScanner.nextLine();
        // Closes the scanner after we're done using it and accepting user input. 
        // userInputScanner.close();

        // If yes, the user does want to see all the vaccine brands shown, then proceed with this code (because below this if statement, we remove the duplicates by converting to hash set)
        if (userInputBrand.equals("y")) {
            if (userInput.equals("zip")) {
                System.out.println("Please enter your zip code.");
                String userInputZip = userInputScanner.nextLine();
                System.out.println("This program will now start filtering vaccination locations in your Zip code: " + userInputZip);
                printLocationsByZip(userInputZip);
                userInputScanner.close();
                return;
                // We return here, so it doesn't repeat the loops below. We could also fix it by entering another else statement to cover the whole code below.
    
                // Prints out the number of the number of vaccination locations in zip
                // System.out.print("The number of vaccination locations in " + userInputZip + " is: ");
                // System.out.println(countCityVaccinationLocationsZip(userInputZip));                
            } else if (userInput.equals("city")) {
                System.out.println("Please enter your city.");
                String userInputCity = userInputScanner.nextLine();
                System.out.println("This program will now start filtering vaccination locations in your City: " + userInputCity);

                printLocationsByCity(userInputCity);
                userInputScanner.close();
                return;
            }
        } 
     

        // *    Title: Converting Arraylist into HashSet data structure to remove duplicates (because of multiple brands offered).
        // This is because a hashset only allows unique elements. Adding an object to the Hashset automatically checks for duplicates based on the equals and hashCode methods that I put in the VaccineProviderInfo.java file.
        // The original ArrayList data structure is still useful because the duplicates in the csv file are for different COVID vaccine brands, which can be used later for something else if we need to (as long as we do it before converting to HashSet).
        // *    Author: Chatgpt
        // *    Date: 2024
        // *    Availability: http://www.chatgpt.com
        // Convert the ArrayList to a HashSet to remove duplicates
        // I used ChatGPT for these 2 lines of code, as well as the equals and hashNode overrides in VaccineProvider info. We did not learn hashSets in class, so the AI was helpful for me to learn how to use it to remove duplicates.
        Set<VaccineProviderInfo> uniqueRecords = new HashSet<>(records);
        // Convert the HashSet back to an ArrayList
        records = new ArrayList<>(uniqueRecords);

        
        // Quicksort algorithm to sort the location store names alphabetically, to group the store chains together (Walgreens, CVS, Rite Aid, etc). Repeated again because we converted back to an arraylist. Otherwise the output will not be sorted if we hit 'n' for "Would you like to see all COVID vaccine brands offered?". Probably because pressing 'y' goes to the if statement above, and it returns early so it doesn't convert to a hash set and back to array list. 
        quicksort(records, 0, records.size() - 1);

      
        // Code below I wrote using what I learned.
        // If the user inputted zip, it will prompt the user to enter their zip, and it will filter vaccination locations by zip code. 
        if (userInput.equals("zip")) {
            System.out.println("Please enter your zip code.");
            String userInputZip = userInputScanner.nextLine();
            System.out.println("This program will now start filtering vaccination locations in your Zip code: " + userInputZip);
            printLocationsByZip(userInputZip);

            // Prints out the number of the number of vaccination locations in zip
            System.out.print("The number of vaccination locations in " + userInputZip + " is: ");
            System.out.println(countCityVaccinationLocationsZip(userInputZip));   
            }       

        // If the user entered city, it will prompt the user to enter their city and will filter locations by their city. 
        if (userInput.equals("city")) {
            System.out.println("Please enter your city.");
            String userInputCity = userInputScanner.nextLine();
            System.out.println("This program will now start filtering vaccination locations in your City: " + userInputCity);
            printLocationsByCity(userInputCity);

        // This can sometimes have extras count because cities might be in other states, like stockton has 2 extra counts for the state of IL. This would require the user to also enter their State, but it's extra input that's not too necessary right now for this project. 
        // Prints out the number of the number of vaccination locations in city (i.e. Stockton)
        System.out.print("The number of vaccination locations is in " + userInputCity + " is: ");
        // System.out.println(countCityVaccinationLocations("Stockton", "CA"));
        System.out.println(countCityVaccinationLocations(userInputCity));
        }

        // Prints out the number of the number of vaccination locations
        System.out.print("The number of total vaccination locations in America is: ");
        System.out.println(countCityVaccinationLocations());

        System.out.println("Would you like to see how many Flu shot providers there are in each city in California?");
        System.out.println("enter 'y' for yes, or 'n' for no");
        String userInputFluCount = userInputScanner.nextLine();

        if (userInputFluCount.equals("y")) {
            // Flu vaccination location dataset. This is in addition to the COVID vaccination location dataset above. 
            String fileNameFlu = "Vaccines.gov__Flu_vaccinating_provider_locations.csv";
            readFluVaccinationLocationsAndCityCount(fileNameFlu);
            printCityDetails();
        }

        //input.close();
        userInputScanner.close();

    }// end main 


    // It seems it counts 253136 locations, which matches up with the excel file 
    // returns the number of vaccination locations in the data set 
    public static int countCityVaccinationLocations()  {
        int count = 0;        
        // goes through the whole record to find vaccination locations
        for(int i = 0; i < records.size(); i++) {
            count++;
        }        
        return count;
    }

    // returns the number of vaccination locations in a specified city (file is currently set for COVID vaccination location datasets)
    // Adding the state accounts for if there's cities in other states (for example, there were 2 cities of Stockton in IL), we could account for this by doing another && records.get(i).getLocAdminState().equalsIgnoreCase(state)
    // Counts 105 locations before including the state, and 102 locations after specifying the state, which matches up. However, the count is still off a bit, I checked the csv file to make sure that there were no empty spaces or anything. Not sure why, or maybe I'm misreading the csv file. Should be maybe 138 count? I made sure to set it to equalsIgnoreCase... 
    // .trim to remove any whitespace that the creators might have accidentally added in the csv, that might intefere with our data collection 
    public static int countCityVaccinationLocations(String city, String state)  {
        int count = 0;        
        // goes through the whole record to find vaccination locations in a given city
        for(int i = 0; i < records.size(); i++) {
            // can also use equalsIgnoreCase(city) or set both to toLowerCase
            // .get Returns the element at the specified position in this list.
            if(records.get(i).getLocAdminCity().trim().equalsIgnoreCase(city) && records.get(i).getLocAdminState().equalsIgnoreCase(state))
                count++;
            // String normalizedCity = records.get(i).getLocAdminCity().replaceAll("\\s+", " ").trim();
            // if (normalizedCity.equalsIgnoreCase(city)) 
            // debugging, this doesn't help the count either, which says that there might not be any special or hidden characters 
            // also doesnt take into account the states 
        }        
        return count;
    }

    // goes through the whole record to find vaccination locations in a given zip
    public static int countCityVaccinationLocationsZip(String zip)  {
        int count = 0;        

        // Enhanced for loop iterates through the arraylist. Here, provider is just a local variable that represents each VaccineProviderInfo object in the records list during the loop.
        for (VaccineProviderInfo provider : records) {
            
            String providerZip = provider.getLocAdminZip(); 

            // The substring() method returns a substring from the string, since some of the zip codes in the CSV use the 9 digit zip code.
            // If we do it without null and length, then it will give us error code like: Exception in thread "main" java.lang.StringIndexOutOfBoundsException: Range [0, 5) out of bounds for length 2
            if (providerZip != null && providerZip.length() >= 5 && 
                providerZip.substring(0, 5).equals(zip)) {
                count++;
            }
        }
        return count;
    }
    

    public static int countCityVaccinationLocations(String city)  {
        int count = 0;        
        // goes through the whole record to find vaccination locations in a given city
        for(int i = 0; i < records.size(); i++) {
            // can also use equalsIgnoreCase(city) or set both to toLowerCase
            // .get Returns the element at the specified position in this list.
            if(records.get(i).getLocAdminCity().trim().equalsIgnoreCase(city))
                count++;
        }        
        return count;
    }

    
    public static void printLocationsByCity(String city) {
        System.out.println("Locations in " + city + ":");
    
        // Convert the city name to lowercase for case-insensitive matching
        // Enhanced for loop, similar to a for loop 
        for (VaccineProviderInfo record : records) {
            if (record.getLocAdminCity().equalsIgnoreCase(city)) {
                System.out.println(record); // Print the provider details
            }
        }
    }

    public static void printLocationsByZip(String zip) {
        System.out.println("Locations in " + zip + ":");
    
        // Convert the city name to lowercase for case-insensitive matching
        // Enhanced for loop, similar to a for loop 
        for (VaccineProviderInfo provider : records) {
            
            // if (provider.getLocAdminZip().equalsIgnoreCase(zip)) {

            String providerZip = provider.getLocAdminZip(); 

            // The substring() method returns a substring from the string.
            if (providerZip != null && providerZip.length() >= 5 && 
                providerZip.substring(0, 5).equals(zip)) {
                System.out.println(provider); // Print the provider details
            }
        }
    }


    public static void readFluVaccinationLocationsAndCityCount(String filename) {
        Scanner input = null; 
        
        try {
			input = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			//file not found. Signals that an attempt to open the file denoted by a specified pathname has failed.
			System.out.println("file not found");
            // printStackTrace() helps the programmer to understand where the actual problem occurred. It helps to trace the exception.
			e.printStackTrace();
		}

        //reading in the header
		input.nextLine();

        while(input.hasNext()) {
            // .nextLine Advances this scanner past the current line and returns the input that was skipped.
            String record = input.nextLine();
            // Splits up with a comma because that is what we do with CSV files. 
            String[] fields = record.split(",");   
            
            // Some of the cities are in all capital letters, while some are lower case. This .toLowerCase helps make sure they are all consistent. Trim also removes any accidental whitespace that may have come up (it would interfere with equals comparisons later).
            String city = fields[6].trim().toLowerCase(); 

            VaccineProviderInfoFlu provider = new VaccineProviderInfoFlu(
                fields[0],   // provider_location_guid
                fields[1],   // loc_store_no
                fields[2],   // loc_phone
                fields[3],   // loc_name
                fields[4],   // loc_admin_street1
                fields[5],   // loc_admin_street2
                fields[6],   // loc_admin_city
                fields[7],   // loc_admin_state
                fields[8],   // loc_admin_zip
                fields[9],   // sunday_hours
                fields[10],  // monday_hours
                fields[11],  // tuesday_hours
                fields[12],  // wednesday_hours
                fields[13],  // thursday_hours
                fields[14],  // friday_hours
                fields[15],  // saturday_hours
                fields[16],  // web_address
                fields[17],  // pre_screen
                fields[18],  // insurance_accepted
                fields[19],  // walkins_accepted
                fields[20],  // provider_notes
                fields[21],  // searchable_name
                Boolean.parseBoolean(fields[22]), // in_stock (convert to boolean)
                fields[23],  // supply_level
                fields[24],  // quantity_last_updated
                fields[25],  // latitude
                fields[26],  // longitude
                fields[27]  // category
            );

            // *    Author: Chatgpt
            // *    Date: 2024
            // *    Availability: http://www.chatgpt.com

            // .put Associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced.
            // Checks if the city exists in the Hashmap, if it's not then proceed
            if (!cityProviders.containsKey(city)) {
                // Inserts the city into the hashmap and associates it with an empty ArrayList
                cityProviders.put(city, new ArrayList<>());
            }
            // Grabs the list of providers that are in the city and adds those providers to the city's list
            cityProviders.get(city).add(provider);
        }

        // Close the scanner
        input.close();
    }

    public static void printCityDetails() {
        System.out.println("City details for California:");
    
        // Loop through each city in the cityProviders map
        // .keySet Returns a Set view of the keys contained in this map. 
        for (String city : cityProviders.keySet()) {
 
            // Get the list of providers for the city
            List<VaccineProviderInfoFlu> providers = cityProviders.get(city);

            // We're going to check for providers located in California, overwise it will just list the count of providers of cities all across the USA
            boolean isCalifornia = false; 
            for (VaccineProviderInfoFlu provider : providers) {
                // Check the state for each provider and if it's "CA" for California, we will print the count for this city
                if (provider.getLocAdminState().equalsIgnoreCase("CA")) {
                    isCalifornia = true;
                    break; // If we found a provider in California, stop checking further in this for loop, so we can go back and continue through the rest of the CSV and find another city that is in California
                }
            }

            // Checks if isCalifornia is true, meaning the city is in California
            if (isCalifornia) {
            // Print the city's name
            System.out.println("Californian City: " + city);
    
            // Print the number of providers in this city
            System.out.println("Number of Flu vaccine providers in this Californian city: " + providers.size());

            }
                


            // Loop through the list of providers and print their details
            // for (VaccineProviderInfoFlu provider : providers) {
            //     System.out.println(provider);
            // }
        }
    }

    // helper method to check if a string is a valid integer
    private static boolean isValidInteger(String value) {
        // checking if the value is null or empty, to return false 
        if (value == null || value.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(value);
            return true;           
        } catch (NumberFormatException e) {
            return false;
            // Thrown to indicate that the application has attempted to convert a string to one of the numeric types, but that the string does not have the appropriate format.
        }
    }


    // Quicksort Algorithm that I created using what we learned from Zybooks. This will sort the locations by their store name alphabetically.
    public static int partition(ArrayList<VaccineProviderInfo> list, int lowIndex, int highIndex) {
            // Pick middle element as the pivot
            int midpoint = lowIndex + (highIndex - lowIndex) / 2;
            VaccineProviderInfo pivot = list.get(midpoint);
         
            boolean done = false;
            // Increments the low index when the location name is less than the pivot location name
            while (!done) {
                // .compareToIgnoreCase Compares two strings lexicographically, ignoring case differences. This method returns an integer. 0 means strings are equal, negative value means the string is lexicographically less than the other string.
               while (list.get(lowIndex).getLocName().compareToIgnoreCase(pivot.getLocName()) < 0) {
                  lowIndex++;
               }
               // Greater than 0 means it's greater than the other string (lexicographically)
               while (list.get(highIndex).getLocName().compareToIgnoreCase(pivot.getLocName()) > 0){
                  highIndex--;
               }
          
               // If lowIndex and highIndex have met or crossed each other, then partitioning is done
               if (lowIndex >= highIndex) {
                  done = true;
               }
               else {
                  // Swap numbers[lowIndex] and numbers[highIndex]
    
                  //int temp = list.get[lowIndex];
                  VaccineProviderInfo temp = list.get(lowIndex);
    
                  // list.get[lowIndex] = list.get[highIndex];
                  // .set Replaces the element at the specified position in this list with the specified element.
                  list.set(lowIndex, list.get(highIndex));             
    
                  // list.get[highIndex] = temp;
                  list.set(highIndex, temp);
                
                  // Update lowIndex and highIndex to move both of the index closer to each other
                  lowIndex++;
                  highIndex--;
               }
            }
            return highIndex;
         }
    
         // Quicksort using what I learned from zybooks. This will be used to later sort the store names alphabetically, or it can be used for any of the fields in the CSV if I later choose to do so, but currently the partition is set to store names.
         private static void quicksort(ArrayList<VaccineProviderInfo> list, int lowIndex, int highIndex) {
            // Only sort if at least 2 elements exist
            if (highIndex <= lowIndex) {
               return;
            }
                   
            // Partition the array
            int lowEndIndex = partition(list, lowIndex, highIndex);
     
            // Recursively sort the left partition
            quicksort(list, lowIndex, lowEndIndex);
        
            // Recursively sort the right partition
            quicksort(list, lowEndIndex + 1, highIndex);
         }

}