package main;

import java.util.*;
import java.io.*;

public class Main {
	
	static ArrayList<Product> products = new ArrayList<Product>();
	static ArrayList<MenuFunction> mainMenu = new ArrayList<MenuFunction>();
	static ArrayList<MenuFunction> customerMenu = new ArrayList<MenuFunction>();
	static ArrayList<MenuFunction> productMenu = new ArrayList<MenuFunction>();
	static ArrayList<MenuFunction> orderMenu = new ArrayList<MenuFunction>();
	static ArrayList<MenuFunction> productSearchOptions = new ArrayList<MenuFunction>();
	static ArrayList<MenuFunction> customerUpdateOptions = new ArrayList<MenuFunction>();
	static ArrayList<MenuFunction> orderUpdateOptions = new ArrayList<MenuFunction>();
	static ArrayList<MenuFunction> productStockOptions = new ArrayList<MenuFunction>();
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	static ArrayList<Order> orders = new ArrayList<Order>();
	static String lineBreaker = "------------------";
	static Scanner in;
	static String searchByOption = "\nPlease enter your choice: ";
	static String enterSKU = "Please enter the SKU \n";
	static String enterDesc = "Please enter the product description \n";
	static String confirmProduct = "Is this the correct product?";
	static String confirmCustomer = "Is this the correct customer?";
	static String confirmOrder = "Is this the correct order?";
	static int loopCount;
	static String returnToMainMenu = "Would you like to return to the Main Menu? (y/n)";
	static boolean stringIsBlank;
	static String inputString;
	static String stringBlankTest;
	static String priceEntry;
	static String inputIntTest;
	static boolean priceIsInt;
	static int priceEntryAsInt;
	static char confirm;
	static char confirm2;
	static String existingTest;
	static double orderSum;
	static String choice;
	
	 
	
	public static void main(String[] args){
		String menuChoice;
		String secondaryMenuChoice;
		String tertiaryMenuChoice;
		
		String anyKey = "Press any key to return to the main menu";
		String carryOnSearching = "Would you like to continue searching? (y/n)";
		String addMoreProducts = "Would you like to continue adding products? (y/n)";
		String addMoreCustomers = "Would you like to continue adding customers? (y/n)";
		String addMoreOrders = "Would you like to continue adding orders? (y/n)";
		String changeMoreProductPrices = "Would you like to continue changing product prices? (y/n)";
		String changeMoreProductDescriptions = "Would you like to change the description of any more products? (y/n)";
		String editCustomerDetails = "Would you like to edit any more customer details? (y/n)";
		String deleteMoreProducts = "Would you like to delete any more products? (y/n)";
		String deleteMoreCustomers = "Would you like to delete any more customers? (y/n)";
		String editOrderStatus = "Would you like to change the completion status of any more orders? (y/n)";
		
	//addDummyData(); //un-note this to add items from the very beginning
	addMenuData();
	readFromProductsFile(); //
	readFromCustomerFile(); // note out these read files to start the system from
	readFromOrdersFile();  // dummy data

		do {
			char repeatCase= 'Y';
			menuChoice =  getMenuSelection(mainMenu);
			switch (menuChoice) {
				case "1":
					do {
						repeatCase= 'Y';
          secondaryMenuChoice =  getMenuSelection(customerMenu);
						switch (secondaryMenuChoice) {
							case "1":
								clearScreen();
              System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nThe Everything Store's complete list of Customers!\n" + lineBreaker + lineBreaker + lineBreaker);
              customers.forEach(System.out::println);
              System.out.println("\n" + anyKey); 
              in.nextLine();
								break;
								
							case "2":
								while(Character.toUpperCase(repeatCase) != 'N') { 
                printFromStringInput("Customer ID" , "Customer");
                System.out.println(carryOnSearching);
                repeatCase = getYesNoChoice();
              } break;
							
							case "3":
								  while(Character.toUpperCase(repeatCase) != 'N') { 
                  addNewListEntryFromUser("Customer", "ID", "First name", "Surname", "Address", "Telephone number");
                  System.out.println("\n" + addMoreCustomers);
                  repeatCase = getYesNoChoice();
					        }break;

							case "4":
								do {
									repeatCase= 'Y';
                tertiaryMenuChoice =  getMenuSelection(customerUpdateOptions);
									switch (tertiaryMenuChoice){ 					
										case "1":
											editListEntry("Customer", "Customer ID", "Name", "name" );
											System.out.println(editCustomerDetails);
											repeatCase = getYesNoChoice();
											if (Character.toUpperCase(repeatCase) == 'N') {
												choice = "4";
											} break;
										case "2":
											editListEntry("Customer", "Customer ID", "Address", "address" );
											System.out.println(editCustomerDetails);
											repeatCase = getYesNoChoice();
											if (Character.toUpperCase(repeatCase) == 'N') {
												choice = "4";
											} break;
										case "3":
											editListEntry("Customer", "Customer ID", "Telephone number", "telephone number" );
											System.out.println(editCustomerDetails);
											repeatCase = getYesNoChoice();
											if (Character.toUpperCase(repeatCase) == 'N') {
												choice = "4";
											} break;
									} 
								} while (!tertiaryMenuChoice.equals("99"));
								secondaryMenuChoice = "99";
								break;
								
							case "5": 
								 while(Character.toUpperCase(repeatCase) != 'N') {	
									 deleteListEntry("Customer ID", "Customer");
									 System.out.println(deleteMoreCustomers);
									 repeatCase = getYesNoChoice(); 
								 }break;
						}break;
					}while (!secondaryMenuChoice.equals("99"));
					break;
						
				case "2":
					do {
						repeatCase= 'Y';
          secondaryMenuChoice =  getMenuSelection(productMenu);
          switch (secondaryMenuChoice) {
							case "1":
              clearScreen();
              System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nThe Everything Store's complete list of Everything!\n" + lineBreaker + lineBreaker + lineBreaker);
              products.forEach(System.out::println);
              System.out.println("\n" + anyKey); 
              in.nextLine();
            break;
								
								case "2":			
                  do {
                    repeatCase= 'Y';
                    tertiaryMenuChoice = getMenuSelection(productSearchOptions);
                    switch (tertiaryMenuChoice){
                                            
                      case "1":
                        printFromStringInput("SKU code" , "Product");
                        System.out.println(carryOnSearching);
                        repeatCase = getYesNoChoice();
                        if (Character.toUpperCase(repeatCase) == 'N') {
                          tertiaryMenuChoice = "99";
                        } break;
                      case "2":
                        printFromStringInput("Product description", "Product");
                        System.out.println(carryOnSearching);
                        repeatCase = getYesNoChoice();
                        if (Character.toUpperCase(repeatCase) == 'N') {
                          tertiaryMenuChoice = "99";
                        } break;
                    }
                  } while (!tertiaryMenuChoice.equals("99"));
                  secondaryMenuChoice = "99";
                  break;
								 
              case "3": 
              while(Character.toUpperCase(repeatCase) != 'N') { 
                addNewListEntryFromUser("Product", "SKU Code", "Product description", "price you wish the product to be in pence", "", "");
                System.out.println("\n" + addMoreProducts);
                repeatCase = getYesNoChoice();
              }break;
								 
							case "4": 
								while(Character.toUpperCase(repeatCase) != 'N') {             
                 clearScreen();
                 editListEntry("Product", "SKU Code", "price you wish the product to be in pence", "price" );
									 System.out.println(changeMoreProductPrices);
									 repeatCase = getYesNoChoice();
								}break;
							 
							case "5":
								 while(Character.toUpperCase(repeatCase) != 'N') {
									 clearScreen();
                 editListEntry("Product", "SKU Code", "Product description", "product description");
									 System.out.println(changeMoreProductDescriptions);
									 repeatCase = getYesNoChoice();
								 }break;
								 
							case "6": 
								 while(Character.toUpperCase(repeatCase) != 'N') {	
									clearScreen();
                deleteListEntry("SKU Code", "Product");
									 System.out.println(deleteMoreProducts);
									 repeatCase = getYesNoChoice(); 
								 }break;
								 
							case "7":
								do {
									repeatCase= 'Y';
                tertiaryMenuChoice = getMenuSelection(productStockOptions);
									switch (tertiaryMenuChoice){
										case "1":
											while(Character.toUpperCase(repeatCase) != 'N') {		
												clearScreen();
                      inputString = getExistingStringInLists("SKU Code", "Product");
												Product p = returnProductFromStringExact(inputString);
                      addStockToProduct(p);
												System.out.println("Would you like to add more stock to any other products?");
												repeatCase = getYesNoChoice();
											}break;
										
                  case "2":
											while(Character.toUpperCase(repeatCase) != 'N') {		
												clearScreen();
                      inputString = getExistingStringInLists("SKU Code", "Product");
												Product p = returnProductFromStringExact(inputString);
												removeStockFromProduct(p);
												System.out.println("Would you like to remove stock from any other products?");
												repeatCase = getYesNoChoice();
											}break;
									}
									
								}while(tertiaryMenuChoice != "99");
								secondaryMenuChoice="99";
								break;
						
						}
					}while (!secondaryMenuChoice.equals("99"));
					break;
				
				case "3":
					do {
						repeatCase= 'Y';
          secondaryMenuChoice =  getMenuSelection(orderMenu);
						switch (secondaryMenuChoice) {
							case "1":
									clearScreen();
                System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nThe Everything Store's complete list of Customers!\n" + lineBreaker + lineBreaker + lineBreaker);
                listAllOrders();
                System.out.println("\n" + anyKey); 
                in.nextLine();
                break;
								
							case "2":
								while(Character.toUpperCase(repeatCase) != 'N') { 
					      	printFromStringInput("Order ID" , "Order");
						      System.out.println(carryOnSearching);
					      	repeatCase = getYesNoChoice();
				      	} break;
								
							case "3":
								while(Character.toUpperCase(repeatCase) != 'N') { 	
									editListEntry("Order", "Order ID", "Complete", "completetion status of this order?");
									System.out.println(editOrderStatus);
									repeatCase = getYesNoChoice();
								} break;
								
							case "4":
								while(Character.toUpperCase(repeatCase) != 'N') { 
                addNewListEntryFromUser("Order", "Customer", "Order ID", "Completion Status", "","");
                System.out.println(addMoreOrders);
                repeatCase = getYesNoChoice();
              } break;
								
							case "5":
								do {
									repeatCase= 'Y';
                tertiaryMenuChoice = getMenuSelection(orderUpdateOptions);
									switch (tertiaryMenuChoice){ 					
										case "1":
											addItemToExisitingOrder();
											clearScreen();
                    System.out.println("Would like you like add any more products to any more Orders?");
											repeatCase = getYesNoChoice();
											if (Character.toUpperCase(repeatCase) == 'N') {
												tertiaryMenuChoice = "99";
											} break;
										case "2":
											removeItemFromExisitingOrder();
											clearScreen();
                    System.out.println("Would you like to remove any more products from any more Orders?");
											repeatCase = getYesNoChoice();
											if (Character.toUpperCase(repeatCase) == 'N') {
												tertiaryMenuChoice = "99";
											} break;
									} 
								} while (!tertiaryMenuChoice.equals("99"));
								secondaryMenuChoice = "99";
								break;
								
							case "6":
								clearScreen();
								System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nThe Everything Store's complete list of incomplete orders!\n" + lineBreaker + lineBreaker + lineBreaker);
								printAllIncompleteOrders();
								System.out.println("\n" + anyKey); 
								in.nextLine();
								break;
						}
					}while (!secondaryMenuChoice.equals("99"));	
			}
		} while (!menuChoice.equals("99"));
  printProductsToFile();
  printOrdersToFile();
  printCustomersToFile();
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}	
	
	public static void addDummyData(){
		products.add(new Product("MS123","Xbox Series X 1TB",44999, 18));
		products.add(new Product("MS124","Xbox Series X 500GB",39999, 95));
		products.add(new Product("MS125","Xbox Series S 1TB",24999, 12));
		products.add(new Product("PSX125","Playstation 5",4499, 43));
		products.add(new Product("PSX126","Playstation 5 Digital Edition",4499, 37));
		products.add(new Product("VAL128","Steam Deck", 35900, 2));
		products.add(new Product("NIN128","Nintendo Switch OLED", 40000, 9));
		products.add(new Product("NIN129","Nintendo Switch Deluxe", 50000, 6)); 
		customers.add(new Customer("1","Darren","Dancey", new Address("5","Chester Street","Manchester","Greater Manchester","M1 5GD"),"555-1212"));
		customers.add(new Customer("2","Jane","Bloggs", new Address("52","Bond Street","Manchester","Greater Manchester","M1 7DD"),"555-14312"));
		customers.add(new Customer("3","Rachel","Greene",	new Address("10","Manhatten Street","Manhatten","New York","NY 221"),"555-1231"));
		customers.add(new Customer("4","Daniel","Smith", new Address("42","Albion Street","Sale","Greater Manchester","M33 7TA"),"555-1212"));
		customers.add(new Customer("5","Wesley","Willis", new Address("52","McDonalds Street","Manchester","Greater Manchester","M1 7RP"),"555-14312"));
		customers.add(new Customer("6","Henry","Caville",	new Address("10","Witcher Row","Nilfgaard","The Conntinent","NL4 221"),"555-1231"));
		orders.add(new Order(customers.get(0), 1000, true));
		orders.add(new Order(customers.get(1), 1001, false));
		orders.add(new Order(customers.get(2), 1002, false));
		orders.add(new Order(customers.get(0), 1003, false));
		orders.add(new Order(customers.get(3), 1004, false));
		orders.add(new Order(customers.get(4), 1005, true));
		orders.add(new Order(customers.get(5), 1006, false));
		orders.add(new Order(customers.get(4), 1007, false));
		orders.get(0).addItems(products.get(4));
		orders.get(0).addItems(products.get(2));
		orders.get(1).addItems(products.get(1));
		orders.get(2).addItems(products.get(5));
		orders.get(3).addItems(products.get(0));
		orders.get(3).addItems(products.get(3));
		orders.get(4).addItems(products.get(7));
		orders.get(6).addItems(products.get(6));
		orders.get(7).addItems(products.get(6));
		orders.get(7).addItems(products.get(3));
		orders.get(7).addItems(products.get(1));
		orders.get(7).addItems(products.get(4));  
}

public static void addMenuData(){
		mainMenu.add(new MenuFunction("1", "Customer Options"));
		mainMenu.add(new MenuFunction("2", "Product Options"));
		mainMenu.add(new MenuFunction("3", "Order Options"));
		mainMenu.add(new MenuFunction("99", "Exit"));
		customerMenu.add(new MenuFunction("1", "List all Customers"));
		customerMenu.add(new MenuFunction("2", "Search for a Customer by ID"));
		customerMenu.add(new MenuFunction("3", "Add a new Customer"));
		customerMenu.add(new MenuFunction("4", "Update a Customer's Details"));
		customerMenu.add(new MenuFunction("5", "Delete a Customer"));
		customerMenu.add(new MenuFunction("99", "Exit"));
		productMenu.add(new MenuFunction("1", "List all Products"));
		productMenu.add(new MenuFunction("2", "Search for Products"));
		productMenu.add(new MenuFunction("3", "Add a new Product"));
		productMenu.add(new MenuFunction("4", "Update a Product's Price"));
		productMenu.add(new MenuFunction("5", "Change a Product's Description"));
		productMenu.add(new MenuFunction("6", "Delete a Product"));
		productMenu.add(new MenuFunction("7", "Stock options"));
		productMenu.add(new MenuFunction("99", "Exit"));
		orderMenu.add(new MenuFunction("1", "List all Orders"));
		orderMenu.add(new MenuFunction("2", "Display Order by ID"));
		orderMenu.add(new MenuFunction("3", "Mark an Order Complete"));
		orderMenu.add(new MenuFunction("4", "Create an Order"));
		orderMenu.add(new MenuFunction("5", "Update an Order"));
		orderMenu.add(new MenuFunction("6", "Show all incomplete orders"));
		orderMenu.add(new MenuFunction("99", "Exit"));
		productSearchOptions.add(new MenuFunction("1", "Search by SKU"));
		productSearchOptions.add(new MenuFunction("2", "Search by product description"));
		productSearchOptions.add(new MenuFunction("99", "Return to Main Menu"));
		productStockOptions.add(new MenuFunction("1", "Add stock for a product"));
		productStockOptions.add(new MenuFunction("2", "Remove stock for a product"));
		productStockOptions.add(new MenuFunction("99", "Return to Main Menu"));
		customerUpdateOptions.add(new MenuFunction("1", "Change Customer Name"));
		customerUpdateOptions.add(new MenuFunction("2", "Change Customer Address"));
		customerUpdateOptions.add(new MenuFunction("3", "Change Customer Telephone Number"));
		customerUpdateOptions.add(new MenuFunction("99", "Return to Main Menu"));
		orderUpdateOptions.add(new MenuFunction("1", "Add products to an order"));
		orderUpdateOptions.add(new MenuFunction("2", "Remove products from an order"));
		orderUpdateOptions.add(new MenuFunction("99", "Return to Main Menu"));
	}
	
	public static void printMenu(List<MenuFunction> inputList) {
		String mainMenuHeaderText = (lineBreaker + lineBreaker + "\nThe Everything Store\n" + "Choose from the following options options\n" + lineBreaker + lineBreaker); 
		clearScreen();
		System.out.println(mainMenuHeaderText);
		for(int i=0;i<inputList.size();i++) {
			MenuFunction m = inputList.get(i);
			System.out.println(m.toString());
		}
		System.out.print(searchByOption);
	}	
	
	static String getMenuSelection(List<MenuFunction> inputList) {
		String menuSelectionDoesNotExist = "\nInvalid menu choice, please try again:";
		boolean inputMenuSelectionExists = false;
		loopCount = 0;
		String mainMenuSelection;
		MenuFunction existingOption = null;		
		while(!inputMenuSelectionExists){
			 if (loopCount >= 1) {
				 System.out.println(menuSelectionDoesNotExist);
			 } else { 
				 printMenu(inputList); 
			 }
			 mainMenuSelection = getInputStringFromUser();
			 for (int i = 0;i<inputList.size();i++) { 
			 	MenuFunction m = inputList.get(i);
			 	if(mainMenuSelection.equals(inputList.get(i).getMenuNum())) {
			 	inputMenuSelectionExists = true;
				existingOption = m;
			 	}
			 } loopCount ++; 	
		} return(existingOption.getMenuNum());
	}
	
	static char getYesNoChoice() {
		char yesNo;
		String yesNoError = "Please enter y or n";
		yesNo = in.nextLine().charAt(0);
		while (Character.toUpperCase(yesNo) != 'Y' && Character.toUpperCase(yesNo) != 'N') {
			clearScreen();
			System.out.println(yesNoError);
			yesNo = in.nextLine().charAt(0);
		} return yesNo;
	}
		
	
	static String getInputStringFromUser() {
		in = new Scanner(System.in);
		inputString = in.nextLine();
		return inputString;
	} 
	
	static Product returnProductFromStringExact(String inputString) {		
		Product toReturn = null;	 
		for (int i = 0;i<products.size();i++) {
				 Product p = products.get(i);
				 if(p.getSKU().toUpperCase().equals(inputString.toUpperCase()) || p.getDescription().toUpperCase().equals(inputString.toUpperCase())) {
					 toReturn = p;
				 } 
		}return(toReturn);
	}
	
	static Customer returnCustomerFromStringExact(String inputString) {		
		Customer toReturn = null;	 
		for (int i = 0;i<customers.size();i++) {
				 Customer c = customers.get(i);
				 if(c.getCID().toUpperCase().equals(inputString.toUpperCase())) {
					 toReturn = c;
				 } 
		}return(toReturn);
	}
	
	static Order returnOrderFromStringExact(String inputString) {		
		Order toReturn = null;	 
		for (int i = 0;i<orders.size();i++) {
				 Order o = orders.get(i);
				 if(o.getOrderID() == Integer.parseInt(inputString)) {
					 toReturn = o;
				 } 
		}return(toReturn);
	} 
	
		
	static String getExistingStringInLists(String inputType, String inputList) {
		String errorMessage = (lineBreaker + lineBreaker + lineBreaker + "\n" + inputType + " does not exist, please try again\n");
		loopCount = 0;
		inputString = null;
		boolean stopLooping = false;
		boolean stringExists = false;
		outerloop:		 
		while(stopLooping == false){
			if (loopCount >= 1 && loopCount <=2) {
				 clearScreen();
       System.out.print(errorMessage);
			 }else if (loopCount >= 3) {
				 stopLooping = true;
				 break outerloop;
			 }switch(inputList) {
         case "Product":
          switch (inputType){
            case "SKU Code":
              inputString = getNoBlankString(inputType);
              if (returnProductFromStringExact(inputString) != null) {
                stringExists = true;
                stopLooping = true;
                break outerloop;
              } else {
                break;
              }
            case "Product Description":
              inputString = getNoBlankString(inputType);
              if(returnProductFromStringPartial(inputString) != null){
                stringExists = true;
                stopLooping = true;
                break outerloop;
              }else {
                break;
              }
           }break;
					 case "Customer":
						 System.out.println(lineBreaker + lineBreaker + "\n" +  "Please enter the " + inputType + "\n" + lineBreaker + lineBreaker + "\n");
						 inputString = getInputStringFromUser();
						 if (returnCustomerFromStringExact(inputString) != null) {
							 stringExists = true;
							 stopLooping = true;
							 break outerloop;
						 } else {
							 break;
						 }
					 case "Order":
						 inputString = testStringToInt("Order ID", "Order", "NoBlank");
						 if (returnOrderFromStringExact(inputString) != null) {
							 stringExists = true;
							 stopLooping = true;
							 break outerloop;
						 } else {
							 break;
						 }
				 } loopCount ++;
		}if(stringExists == false) {
			return "Error";
		}else {
			return inputString;
		}
	}
	
	static String getNonDuplicateStringFromUser(String inputType, String inputList) {
		String errorMessage = (lineBreaker + lineBreaker + "--------\n>> DUPLICATE " + inputType + ", please try again <<\n");
		loopCount = 0;
		inputString = null;
		boolean stopLooping = false;
		boolean stringExists = true;
		outerloop:		 
		while(stopLooping == false){
			clearScreen(); 
			if (loopCount >= 1 && loopCount <=2) {
				 System.out.print(errorMessage);
			}else if (loopCount >= 3) {
				 stopLooping = true;
				 break outerloop;
			}switch (inputList) {
			    	case "Product":
			    		inputString = getNoBlankString(inputType);
			    		if (returnProductFromStringExact(inputString) == null) {
							 stringExists = false;
							 stopLooping = true;
							 break outerloop;
						} break;
			    	case "Customer":
			    		inputString = getNoBlankString(inputType);
			    		if (returnCustomerFromStringExact(inputString) == null) {
							 stringExists = false;
							 stopLooping = true;
							 break outerloop;
						} break;
			    	case "Order":
			    		inputString = testStringToInt(inputType, inputList, "NoBlank");
			    		if (returnOrderFromStringExact(inputString) == null) {
							 stringExists = false;
							 stopLooping = true;
							 break outerloop;
						} break;
			}loopCount ++; 
		}if(stringExists == true) {
			return "Error";
		}else {
			return inputString;
		}
		
}	
	
	static Product returnProductFromStringPartial(String inputString) {		
		Product toReturn = null;	 
		for (int i = 0;i<products.size();i++) {
				 Product p = products.get(i);
				 if(p.getDescription().toUpperCase().contains(inputString.toUpperCase())) {
					 toReturn = p;
				 } 
		}return(toReturn);
	}
	
	static void listAllOrders() {
		
		for (int i = 0;i<orders.size();i++) {
			orderSum = 0;
			Order o = orders.get(i);
			System.out.println(o.toString());
			for (int j=0;j<orders.get(i).items.size();j++) {
				Product p = orders.get(i).items.get(j);
				System.out.println(p.toString());
				orderSum += p.getPrice();
			} if ((orderSum/100) % 1 != 0) {
				System.out.println(">>>>>>> TOTAL ORDER VALUE = £" + orderSum/100 + " <<<<<<<<\n");
			} else {
				System.out.println(">>>>>>> TOTAL ORDER VALUE = £" + orderSum/100 + "0 <<<<<<<<\n");
			}
		} 
	}
	
	static void printFromStringInput(String inputType, String inputList) {
		clearScreen();
		String excessiveErrors = (lineBreaker + lineBreaker + lineBreaker + "\nIt looks like you don't have the right " + inputType + "\n" + lineBreaker + lineBreaker + lineBreaker);
		existingTest = getExistingStringInLists(inputType, inputList);
		if (existingTest != "Error") {
			clearScreen();
			System.out.println(lineBreaker + lineBreaker + "\n>>>>>>>>> " + inputList + " found <<<<<<<<\n" + lineBreaker + lineBreaker);
			switch(inputList) {
				case "Product": 
					switch(inputType) {
						case "SKU code":
							System.out.println(returnProductFromStringExact(existingTest).toString() + "\n");
							break;
						case "Product description":
							for (int i = 0;i<products.size();i++) {
								 Product p = products.get(i);
								 if(p.getDescription().toUpperCase().contains(inputString.toUpperCase())) {
									 System.out.println(p.toString());
								 }
							 } System.out.println();
							 break;
					} break;
				case "Customer":
					System.out.println(returnCustomerFromStringExact(existingTest).toString() + "\n");
					break;
				case "Order":
					double orderSum;
					for (int i = 0;i<orders.size();i++) {
						orderSum = 0;
						Order o = orders.get(i);
						if (o.getOrderID() == Integer.parseInt(existingTest)) {	
							System.out.println(o.toString());
							for (int j=0;j<orders.get(i).items.size();j++) {
								Product p = orders.get(i).items.get(j);
								System.out.println(p.toString());
								orderSum += p.getPrice();
							} if ((orderSum/100) % 1 != 0) {
								System.out.println(">>>>>>> TOTAL ORDER VALUE = £" + orderSum/100 + " <<<<<<<<\n");
							} else {
								System.out.println(">>>>>>> TOTAL ORDER VALUE = £" + orderSum/100 + "0 <<<<<<<<\n");
							}
						}
					} break;
			}
		} else { 
			System.out.println(excessiveErrors + "\n");
		}
	}
	
	static void printItemsfromOrder (Order inputOrder) {
		for (int j=0;j<inputOrder.items.size();j++) {
			Product p = inputOrder.items.get(j);
			System.out.println( "[" + (j+1) + "] " + p.toString());
		}
	}
	
	static boolean testBlankString(String stringBlankTest) {
		if(!stringBlankTest.equals("") && !stringBlankTest.equals(" ")) {
			stringIsBlank = false; 
		} else {
			stringIsBlank = true;
		} return stringIsBlank; 
	}
		
	static String getNoBlankString(String inputType) {
		String blankError = "This field requires an input, it cannot be left blank, please try again:";
		String newFieldEntry = "Please enter the " + inputType + ": \n";
		stringBlankTest = null;
		System.out.println(lineBreaker + lineBreaker + "--------\n "+ newFieldEntry + lineBreaker + lineBreaker + "--------\n");
		boolean newEntryIsBlank = true;
		while(newEntryIsBlank){
			stringBlankTest = getInputStringFromUser();
				if(testBlankString(stringBlankTest) == false) {
					inputString = stringBlankTest;
					newEntryIsBlank = false;
				 } else {
					 clearScreen();
         System.out.println(lineBreaker + lineBreaker + lineBreaker + "\n" + blankError + "\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
				 }
		 } return inputString;
	}
	
	static String testStringToInt(String inputType, String inputList, String testType) {
		String notIntError = ">> ERROR DO NOT INSER SYMBOLS OR LETTERS <<\n";
		inputIntTest = null;
		loopCount = 0;
		boolean stopLooping = false;
		outerloop:
		while (stopLooping == false) {
			if (loopCount >= 3) {
				 stopLooping = true;
				 break outerloop;
			}
			switch(testType) {
				case "NoBlank":
					inputIntTest = getNoBlankString(inputType);
					break;
				case "NoDuplicate":
					inputIntTest = getNonDuplicateStringFromUser(inputType, inputList);
					break;
				case "Existing":
					inputIntTest = getExistingStringInLists(inputType, inputList);
			}
			try { 
				priceEntryAsInt = Integer.parseInt(inputIntTest);
		     } catch (NumberFormatException e) {
		    	 if(loopCount < 3 ) {
		    		 clearScreen();
		    		 System.err.println(lineBreaker + lineBreaker + lineBreaker + "\n" + notIntError + lineBreaker + lineBreaker + lineBreaker) ;
		    		 loopCount++;
		    		 continue;
		    	 }
		     }  if (priceEntryAsInt >= 0) {
		         stopLooping = true;
		     }  
		} if(loopCount >= 3) {
			System.out.println(lineBreaker + lineBreaker + "\nValue was not entered as a number\n" + lineBreaker + lineBreaker);
			return "Error";
		} else {
			return inputIntTest;
		}
	}

	static void deleteListEntry(String inputType, String inputList){
		confirm = 'N';
		String confirmDelete = "Are you sure you want to delete ";
		String oldProduct;
		String oldCustomer;
		Product pToDelete = null;
		Customer cToDelete = null;
		String excessiveErrors = "It looks like you don't have the right";
		existingTest = getExistingStringInLists(inputType, inputList);
		if (existingTest.equals("Error")) {
			System.out.println(excessiveErrors + inputType);
		} else { 
			clearScreen();
    System.out.println(lineBreaker + lineBreaker + lineBreaker);
    switch (inputList) {
				case "Product":
					pToDelete = returnProductFromStringExact(existingTest);
					System.out.println(pToDelete.toString() + "\n "+ lineBreaker + lineBreaker + lineBreaker + "\n\n" +  confirmProduct);
					break;
				case "Customer":
					cToDelete = returnCustomerFromStringExact(existingTest);
					System.out.println(cToDelete.toString() + "\n "+ lineBreaker + lineBreaker + lineBreaker + "\n\n" + confirmCustomer);
					break;
			}confirm = getYesNoChoice();
			if (Character.toUpperCase(confirm) == 'Y') {
				confirm = 'N';
				clearScreen();
      switch (inputList) {
				case "Product":
					System.out.println(confirmDelete + pToDelete.getDescription() + " ?");
					break;
				case "Customer":
					System.out.println(confirmDelete + cToDelete.getFirstName() + " " + cToDelete.getSecondName() + " ?");
					break;
			}confirm = getYesNoChoice();
			if (Character.toUpperCase(confirm) == 'Y') {
				clearScreen();
      switch (inputList) {
				case "Product":
					oldProduct = pToDelete.getDescription();
					products.remove(pToDelete);
					System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\n" + oldProduct + " has been deleted!\n" + "\n "+ lineBreaker + lineBreaker + lineBreaker);	
        printProductsToFile();
					break;
				case "Customer":
					oldCustomer = cToDelete.getFirstName() + " " + cToDelete.getSecondName();
					customers.remove(cToDelete);
					System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\n" + oldCustomer + " has been deleted!\n" + lineBreaker + lineBreaker + lineBreaker);	
        printCustomersToFile();
					break;
				}
			}
			}
		}
	}

	static Address addNewListEntryFromUser(String inputList, String val1, String val2, String val3, String val4, String val5){
		String excessiveErrors = "It looks like you don't have the right SKU Code";
		String input1 = "";
		String input2 = "";
		String input3 = "";
		String input4 = "";
		String input5 = "";
		Address input4Address = null;
		char confirmAdd = 'N';
		switch(inputList) {
			case "Product":
				input1 = getNonDuplicateStringFromUser(val1, inputList);
				break;
			case "Customer":
				input1 = testStringToInt(val1 , inputList , "NoDuplicate");
				break;
			case "Address":
				input1 = getNoBlankString(val1);
				break;
			case "Order":
				input1 = testStringToInt("Customer ID" , "Customer" , "Existing");
				break;
		}if(input1 != "Error") {
    clearScreen();
			switch(inputList) {
      case "Product":
        input2 = getNoBlankString(val2);
        break;
      case "Customer":
        input2 = getNoBlankString(val2);
        break;
      case "Address":
        input2 = getNoBlankString(val2);
        break;
      case "Order":
        input2 = testStringToInt(val2 , "Order" , "NoDuplicate");
        break;
			}if(input2 != "Error") {
      clearScreen();
				switch(inputList) {
					case "Product":
						input3 = testStringToInt(val3, "Product", "NoBlank");
						break;
					case "Customer":
						input3 = getNoBlankString(val3);
						break;
					case "Address":
						input3 = getNoBlankString(val3);
						break;	
					case "Order":
						input3 = "Y";
						break;
				}if(input3 != "Error") {
					clearScreen();
        switch(inputList) {
						case "Customer":
							input4Address = addNewListEntryFromUser("Address", "House number", "Street name", "Town or city", "County", "Postal Code");
							break;
						case "Address":
							input4 = getNoBlankString(val4);
						break;
					}if(input4 != "Error" || input4Address != null) {
						clearScreen();
          switch(inputList) {
							case "Customer":
								input5 = getNoBlankString(val5);
								break;
							case "Address":
								input5 = getNoBlankString(val5);
								break;
						} if(input5 != "Error") {
							switch(inputList) {
								case "Product":
									clearScreen();
                int newPriceEntryAsInt = Integer.parseInt(input3);
									double newPriceEntry = newPriceEntryAsInt;
                if ((newPriceEntry/100) % 1 != 0) {
										System.out.println(">>> SKU: " + input1 + ", " + input2 + ", price = £" + (newPriceEntry/100) + " <<<");
									} else {
										System.out.println(">>> SKU: " + input1 + ", " + input2 + ", price = £" + (newPriceEntry/100) + "0 <<<");
									} System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nAre you sure you want to add this " + inputList + "? (y/n)\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
									confirmAdd = getYesNoChoice();
									if (Character.toUpperCase(confirmAdd) == 'Y') {
										products.add(new Product(input1, input2, newPriceEntry));
                  clearScreen();
                  System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nYour " + inputList + " \"" + input2 + "\" has been added!\n" + lineBreaker + lineBreaker + lineBreaker);
                  printProductsToFile();
									}return input4Address;
								case "Customer":
									clearScreen();
									System.out.println("ID: " + input1 + ", " + input2 + " " + input3 + "\nAddresss: " + input4Address.toString() + "\nTel no. " + input5 + " ");
                System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nAre you sure you want to add this " + inputList + " ?\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
									confirmAdd = getYesNoChoice();
									if (Character.toUpperCase(confirmAdd) == 'Y') {
										customers.add(new Customer(input1, input2, input3, new Address(input4Address.getHouse(),input4Address.getAddressLine1(), input4Address.getAddressLine2(), input4Address.getCounty(), input4Address.getPostCode()), input5));
										clearScreen();
                  System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nYour " + inputList + "\" " + input2 + " " + input3 + "\" has been added!\n" + lineBreaker + lineBreaker + lineBreaker);
                  printCustomersToFile();
									} return input4Address;	
								case "Address":
									input4Address = new Address(input1, input2, input3, input4, input5);
									return input4Address;
								case "Order":
									clearScreen();
									Customer c = returnCustomerFromStringExact(input1);
									System.out.println("------------ ORDER ID - " + input2 + " ------------\nCustomer name: " + c.getFirstName() + " " + c.getSecondName() + ". Order complete: false");
                System.out.println(lineBreaker + lineBreaker + lineBreaker + "-------\nAre you sure you want to add this " + inputList + " ?\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
									confirmAdd = getYesNoChoice();
									if (Character.toUpperCase(confirmAdd) == 'Y') {
										orders.add(new Order(c, Integer.parseInt(input2), false));
										clearScreen();
                  System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nYour " + inputList + " has been added!\n" + lineBreaker + lineBreaker + lineBreaker +"\n\n Would you like to add some items to this Order? (y/n)?");
										printOrdersToFile();
                  confirm = getYesNoChoice();
										if (Character.toUpperCase(confirm) == 'Y') {
											char continueLooping = 'Y';
											while(Character.toUpperCase(continueLooping) != 'N') {	
												inputString = getExistingStringInLists("SKU Code", "Product");
												if(inputString != "Error") {
													Product p = returnProductFromStringExact(inputString);
													System.out.println("Add " + p.toString() + " to Order number " + input2 + " ?");
													confirm = getYesNoChoice();
													if (Character.toUpperCase(confirm) == 'Y') {
														if(checkStockLevelOnRemoval(p,1) == false){
                          Order o = returnOrderFromStringExact(input2);
														o.addItems(p);
                          printOrdersToFile();
														clearScreen();
                          System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\n" + p.toString() + " has been added to Order number: " + input2 + "!\n" + lineBreaker + lineBreaker + lineBreaker +    "\n\nWould you like to add any more items to this Order? (y/n)?");
														continueLooping = getYesNoChoice();
                          }else {System.out.println("Error! Stock cannot be reduced below zero.\nWould you like to continue adding items to this Order?");
                          continueLooping = getYesNoChoice();
                          }
													}
												} else {
													System.out.println(excessiveErrors + "\nWould you like to continue adding items to this Order?");
													continueLooping = getYesNoChoice();
												}
											}
										}
									} return input4Address;	
							}
						}
					}
				}
			}
		}
		return input4Address;
	}
	
	static void editListEntry(String inputList, String inputSearchType, String inputType, String inputMessage) {
		String excessiveErrorsSearch = "It looks like you don't have the right " + inputSearchType;
		String confirmToChange = ("Are you sure you want to change the " + inputMessage + "?");
		String excessiveErrorsInput = "It looks like you arent inputting the right thing";
		String oldEntry = "";
		String newEntry = "";
		String newEntry2 = "";
		Double oldPrice = 0.0;
		Double newPrice = 0.0;
		Address aToChange = null;
		Product pToChange = null;
		Customer cToChange = null;
		Order oToChange = null;
		existingTest = getExistingStringInLists(inputSearchType,inputList);
		if (existingTest.equals("Error")) {
			System.out.println(excessiveErrorsSearch);	
		} else {
			clearScreen();
    switch(inputList) {
				case "Product":
					pToChange = returnProductFromStringExact(existingTest);
					System.out.println(lineBreaker + lineBreaker + lineBreaker + "\n" + pToChange.toString() + "\n"+ lineBreaker + lineBreaker + lineBreaker + "\n\n" + confirmProduct);
					break;
				case "Customer":
					cToChange = returnCustomerFromStringExact(existingTest);
					System.out.println(lineBreaker + lineBreaker + lineBreaker + "\n" + cToChange.toString() + "\n"+ lineBreaker + lineBreaker + lineBreaker + "\n\n" + confirmCustomer);
					break;
				case "Order":
					orderSum = 0;
					oToChange = returnOrderFromStringExact(existingTest);
					System.out.println(oToChange.toString());
					for (int j=0;j<oToChange.items.size();j++) {
						Product p = oToChange.items.get(j);
						System.out.println(p.toString());
						orderSum += p.getPrice();
					}  
					if ((orderSum/100) % 1 != 0) {
						System.out.println("    >>>>>>> TOTAL ORDER VALUE = £" + orderSum/100 + " <<<<<<<<\n");
					} else {
						System.out.println("    >>>>>>> TOTAL ORDER VALUE = £" + orderSum/100 + "0 <<<<<<<<\n");
					} System.out.println(confirmOrder);
					break;
			}
			confirm = getYesNoChoice();
			if (Character.toUpperCase(confirm) == 'Y') {
				
      confirm = 'N';
				System.out.println("\n" + confirmToChange);
				confirm = getYesNoChoice();
			}if (Character.toUpperCase(confirm) == 'Y') {
				confirm = 'N';
				loopCount = 0;
				outerloop:
				while(Character.toUpperCase(confirm) == 'N') {
					if(loopCount >= 3) {
						confirm = 'Y';
						break outerloop;
					}clearScreen();
        switch(inputType) {
						case "Product description":
							oldEntry = pToChange.getDescription();
							newEntry = getNonDuplicateStringFromUser(inputType, inputList);
							break;
						case "price you wish the product to be in pence":
							oldPrice = pToChange.getPrice();
							newEntry = testStringToInt("price you wish the product to be in pence", "Product", "NoBlank");
            if(newEntry == "Error"){
              confirm = 'Y';
              loopCount = 4;
              break outerloop;
            } int newPriceAsInt = Integer.parseInt(newEntry);
							newPrice = (double)newPriceAsInt;
							break;
						case "Name":
							oldEntry = cToChange.getFirstName() + " " + cToChange.getSecondName(); 
							newEntry = getNoBlankString("First name");
							newEntry2 = getNoBlankString("Surname");
							break;
						case "Telephone number":
							oldEntry = cToChange.getTelephoneNumber();
							newEntry = getNoBlankString("Telephone Number");
							break;
						case "Address":
							oldEntry = cToChange.getAddress().toString();
							aToChange = addNewListEntryFromUser("Address", "House number", "Street name", "Town or city", "County", "Postal Code");
							break;
						case "Complete":
							oldEntry = Boolean.toString(oToChange.isComplete());
							switch (oldEntry) {
								case "true":
									System.out.println("Do you want to re-open this order? (y/n)");
									confirm2 = getYesNoChoice();
									if(confirm2 == 'Y') {
										newEntry = "true";
									} else if (confirm2 == 'N') {
										newEntry = "Error";
                  confirm = 'N';
									} break;
								case "false":
									System.out.println("Do you want to close this order? (y/n)");
									confirm2 = getYesNoChoice();
									if(confirm2 == 'Y') {
										newEntry = "false";
									} else if (confirm2 == 'N') {
										newEntry = "Error";
                  confirm = 'N';
									} break;
							} break;
					}if((newEntry != "Error" && newEntry2 !="Error") || aToChange != null) {
						clearScreen();
          switch(inputType) {
						case "Product description":
							System.out.println("Are you sure you want to change the " + inputMessage + "to \"" + newEntry + "\"?");
							confirm = getYesNoChoice();
							break;
						case "price you wish the product to be in pence":
							if ((newPrice/100) % 1 != 0) {
								System.out.println("Are you sure you want to change the " + inputList + " " + inputMessage + " to \" £" + (newPrice/100) + " \"?");
							} else {
								System.out.println("Are you sure you want to change the " + inputList + " " + inputMessage + " to \"£" + (newPrice/100) + "0 \"?");
							}confirm = getYesNoChoice();
							break;
						case "Name":
							System.out.println("Are you sure you want to change the " + inputList + " " + inputMessage + " to \"" + newEntry + " " + newEntry2 + "\"?");
							confirm = getYesNoChoice();
							break;
						case "Telephone number":
							System.out.println("Are you sure you want to change the " + inputList + " " + inputMessage + " to \"" + newEntry + "\"?");
							confirm = getYesNoChoice();
							break;
						case "Address":
							System.out.println("Are you sure you want to change the customer " + inputMessage + " to \"" + aToChange.toString() + "\"?");
							confirm = getYesNoChoice();
							break;
						case "Complete":
							confirm = 'Y';
							break;
						} 
					} 
				} if (Character.toUpperCase(confirm) == 'Y') {
					if (loopCount < 3) {
						clearScreen();
          switch(inputType) {
							case "Product description":
								pToChange.setDescription(newEntry);
								System.out.println("SUCCESS!\nThe description of the product has been change from \"" + oldEntry + "\" to \"" + newEntry + "\"!");
              printProductsToFile();
								break;
							case "price you wish the product to be in pence":
								pToChange.setPrice(newPrice);
              printProductsToFile();
								if ((newPrice/100) % 1 == 0 && (oldPrice/100) % 1 == 0) {
									System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nThe price of \"" + pToChange.getDescription() + "\" has changed from £" + (oldPrice/100) + "0 to £" + (pToChange.getPrice()/100) + "0 !\n"+ lineBreaker + lineBreaker + lineBreaker + "\n");
								} else if((newPrice/100) % 1 == 0 && (oldPrice/100) % 1 != 0){
									System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nThe price of \"" + pToChange.getDescription() + "\" has changed from £" + (oldPrice/100) + " to £" + (pToChange.getPrice()/100) + "0 !\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
								} else if((newPrice/100) % 1 != 0 && (oldPrice/100) % 1 == 0) {
									System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nThe price of \"" + pToChange.getDescription() + "\" has changed from £" + (oldPrice/100) + "0 to £" + (pToChange.getPrice()/100) + "!\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
								} else if ((newPrice/100) % 1 != 0 && (oldPrice/100) % 1 != 0){
									System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nnSUCCESS!\nThe price of \"" + pToChange.getDescription() + "\" has changed from £" + (oldPrice/100) + " to £" + (pToChange.getPrice()/100) + "!\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
								} else {
									return;
								} break;
							case "Name":
								cToChange.setFirstName(newEntry);
								cToChange.setSecondName(newEntry2);
              printCustomersToFile();
								System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nThe customers name has been changed from \"" + oldEntry + "\" to \"" + cToChange.getFirstName() + " " + cToChange.getSecondName() + "\"!\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
								break;
							case "Telephone number":
								cToChange.setTelephoneNumber(newEntry);
								System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nThe telephone number of the customer has been changed from \"" + oldEntry + "\" to \"" + newEntry + "\"!\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
              printCustomersToFile();
								break;
							case "Address":
								cToChange.setAddress(aToChange);
								System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nThe address of the customer has been changed from \"" + oldEntry + "\" to \"" + aToChange + "\"!\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
              printCustomersToFile();
								break;
							case "Complete":
								if(oldEntry == "true") {
									System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nOrder number " + existingTest +  " has been re-opened!\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
                oToChange.setComplete(false);
                printOrdersToFile();
								} else if(oldEntry == "false") {
									System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nOrder number " + existingTest +  " has been closed!\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
                oToChange.setComplete(true);
                printOrdersToFile();
								} break;
						}
					} else {
						System.out.println(excessiveErrorsInput);
					}
				}
			}
		}
	}
	
	static void addItemToExisitingOrder() {
		String excessiveErrors = (lineBreaker + lineBreaker + lineBreaker + "\nIt looks like you don't have the right Order ID\n" + lineBreaker + lineBreaker + lineBreaker);
		Order o;
  clearScreen();
		existingTest = getExistingStringInLists("Order ID", "Order");
		if(existingTest != "Error") {
			o= returnOrderFromStringExact(existingTest);
    clearScreen();
    System.out.println(o.toString()+ "\n        >>>>>>>> ITEMS <<<<<<<<");
    printItemsfromOrder (o);
			char continueLooping = 'Y';
			while(Character.toUpperCase(continueLooping) != 'N') {	
				inputString = getExistingStringInLists("SKU Code", "Product");
				if(inputString != "Error") {
          Product p = returnProductFromStringExact(inputString);
          if(checkStockLevelOnRemoval(p,1) == true){
            clearScreen();
            System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nAre you sure you want to add " + p.getDescription() + " to Order number " + o.getOrderID() + " ?\n" + lineBreaker + lineBreaker + lineBreaker);
            confirm = getYesNoChoice();
            if (Character.toUpperCase(confirm) == 'Y') {
              o.addItems(p);
              p.removeStock(1);
              printOrdersToFile();
              printProductsToFile();
              clearScreen();
              System.out.println(lineBreaker + lineBreaker + lineBreaker + "\n            >>>>>>>>SUCCESS!<<<<<<<<\n" + p.getDescription() + " has been added to Order number: " +  o.getOrderID() + "!\n" + lineBreaker + lineBreaker + lineBreaker + "\n\nWould you like to add any more items to this Order? (y/n)?");
              continueLooping = getYesNoChoice();
            }
          } else {
            	System.out.println("        >>>>>>>>> OUT OF STOCK <<<<<<<<<. \nWould you like to continue adding items to this Order?");
					      continueLooping = getYesNoChoice();
          }

				} else {
					System.out.println(excessiveErrors + "\nWould you like to continue adding items to this Order?");
					continueLooping = getYesNoChoice();
				}
			}
			
			} else {
				System.out.println(excessiveErrors);
			}
	}

	static void removeItemFromExisitingOrder() {
		String excessiveErrors = (lineBreaker + lineBreaker + lineBreaker + "\nIt looks like you don't have the right Order ID\n" + lineBreaker + lineBreaker + lineBreaker);
		Order o;
		clearScreen();
  existingTest = getExistingStringInLists("Order ID", "Order");
		if(existingTest != "Error") {
			o= returnOrderFromStringExact(existingTest);
			clearScreen();
    System.out.println(o.toString()+ "\n        >>>>>>>> ITEMS <<<<<<<<");
			printItemsfromOrder (o);
			char continueLooping = 'Y';
			while(Character.toUpperCase(continueLooping) != 'N') {	
				boolean itemExists = false;
				loopCount = 0;
				int intToDelete = 0;
				System.out.println("Please select the number of the Item you wish to remove");
				while(itemExists == false) {
					String stringToDelete = testStringToInt("item number you wish to remove", "Order", "NoBlank");
					Product p = null;
					int testIntToDelete = (Integer.parseInt(stringToDelete) - 1 );
					try { 
						p = o.items.get(testIntToDelete);
				     } catch (IndexOutOfBoundsException e) {
				    	 if(loopCount < 3 ) {
				    		 clearScreen();
				    		 System.err.print(lineBreaker + lineBreaker + lineBreaker + "\n >>>>> Item does not exist, Please try again <<<<<<\n"  + lineBreaker + lineBreaker + lineBreaker) ;
				    		 loopCount++;
				    		 continue;
				    	 }
				     }  if (p != null) {
				         itemExists = true;
				     } 
				}
				clearScreen();
        System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nAre you sure you want to remove " + o.items.get(intToDelete).getDescription() + " from Order number " + o.getOrderID() + " ?\n" + lineBreaker + lineBreaker + lineBreaker);
				confirm = getYesNoChoice();
				if (Character.toUpperCase(confirm) == 'Y') {
					o.removeItems(o.items.get(intToDelete));
        printOrdersToFile();
					clearScreen();
        System.out.println(lineBreaker + lineBreaker + lineBreaker + "\n              >>>>>>>>SUCCESS!<<<<<<<<\nThe item has been removed from Order number: " +  o.getOrderID() + "!\n" + lineBreaker + lineBreaker + lineBreaker + "\n\nWould you like to remove any more items from this Order? (y/n)?");
					continueLooping = getYesNoChoice();
				}
			}
		}else {
			System.out.println(excessiveErrors);
		}
	} 

	static void addStockToProduct(Product p) {
		String excessiveErrors = (lineBreaker + lineBreaker + lineBreaker + "\nIt looks like you aren't inputting a number\n" + lineBreaker + lineBreaker + lineBreaker);
		clearScreen();
  inputIntTest = testStringToInt("amount of stock to add", "", "NoBlank");
		if(inputIntTest != "Error") {
			int oldStock = p.getStockCount();
			System.out.println(lineBreaker + lineBreaker + lineBreaker +  "\nCurrent stock is " + oldStock + ". The new stock count will be " + (oldStock + Integer.parseInt(inputIntTest)) + ".\n" +lineBreaker + lineBreaker + lineBreaker + "\n");
			System.out.println("Are you sure you want to make this change? (y/n)");
			confirm = getYesNoChoice();
			if (Character.toUpperCase(confirm) == 'Y') {
				p.addStock(Integer.parseInt(inputIntTest));
      printProductsToFile();
				System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nThe stock for " +  p.getDescription() + " has been updated to " + p.getStockCount() + "!\n" + lineBreaker + lineBreaker + lineBreaker); 
			}
		} else {
			System.out.println(excessiveErrors);
		}
	}
	
	static void removeStockFromProduct(Product p) {
		String excessiveErrors = (lineBreaker + lineBreaker + lineBreaker + "\nIt looks like you aren't inputting a number\n" + lineBreaker + lineBreaker + lineBreaker);
		clearScreen();
  inputIntTest = testStringToInt("amount of stock to remove", "", "NoBlank");
		if(inputIntTest != "Error") {
			int oldStock = p.getStockCount();
			int stockToRemove = Integer.parseInt(inputIntTest);
    if (checkStockLevelOnRemoval(p,stockToRemove) == true){
        System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nCurrent stock is " + oldStock + ". The new stock count will be " + (oldStock - stockToRemove) + ".\n" + lineBreaker + lineBreaker + lineBreaker + "\n");
        System.out.println("Are you sure you want to make this change? (y/n)");
        confirm = getYesNoChoice();
        if (Character.toUpperCase(confirm) == 'Y') {
          p.removeStock(Integer.parseInt(inputIntTest));
          printProductsToFile();
          System.out.println(lineBreaker + lineBreaker + lineBreaker + "\nSUCCESS!\nThe stock for " + p.getDescription() + " has been updated to " + p.getStockCount() + "!\n" + lineBreaker + lineBreaker + lineBreaker); 
        }
    }else {
      System.out.println("Stock levels cant be reducued below zero. Please press any key to continue");
      in.nextLine();
    }
		} else {
			System.out.println(excessiveErrors);
		}
	}

static boolean checkStockLevelOnRemoval(Product p, int i) { //cant understand why this is returning the opposite of what I expect
    boolean stockCountAboveZero;
    int stockCountForProduct = p.getStockCount();
    int amountToRemove = i;
    int amountRemaining = stockCountForProduct - amountToRemove;
    if(0 > amountRemaining) {
      stockCountAboveZero = false;
    } else{
      stockCountAboveZero = true;
    } return stockCountAboveZero;
}

static void printAllIncompleteOrders() {
		for (int i = 0;i<orders.size();i++) {
			orderSum = 0;
			Order o = orders.get(i);
			if(o.isComplete() == false) {
				System.out.println(o.toString()+ "+\n        >>>>>>>> ITEMS <<<<<<<<");
				o.printOrderCost(o);
			}
		} 
	}	

static void printProductsToFile(){
  try {
      FileOutputStream fos = new FileOutputStream("productList.txt");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(products);
        oos.flush();
      oos.close();
      } catch (IOException ex) {
      ex.printStackTrace();
      }
}

static void printCustomersToFile(){
  try {
      FileOutputStream fos = new FileOutputStream("customerList.txt");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(customers);
        oos.flush();
      oos.close();
      } catch (IOException ex) {
      ex.printStackTrace();
      }
}

 static void printOrdersToFile(){
  try {
      FileOutputStream fos = new FileOutputStream("ordersList.txt");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(orders);
        oos.flush();
      oos.close();
      } catch (IOException ex) {
      ex.printStackTrace();
      }
}


static void readFromProductsFile(){
  try {
      FileInputStream fis = new FileInputStream("productList.txt");
      ObjectInputStream ois = new ObjectInputStream(fis);
      products = (ArrayList<Product>) ois.readObject();
      ois.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      catch(ClassNotFoundException c){
           System.out.println("Class not found");
           c.printStackTrace();
           return;
        }
}

static void readFromOrdersFile(){
  try {
      FileInputStream fis = new FileInputStream("ordersList.txt");
      ObjectInputStream ois = new ObjectInputStream(fis);
      orders = (ArrayList<Order>) ois.readObject();
      ois.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      catch(ClassNotFoundException c){
           System.out.println("Class not found");
           c.printStackTrace();
           return;
        }
}


static void readFromCustomerFile(){
  try {
      FileInputStream fis = new FileInputStream("customerList.txt");
      ObjectInputStream ois = new ObjectInputStream(fis);
      customers = (ArrayList<Customer>) ois.readObject();
      ois.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      catch(ClassNotFoundException c){
           System.out.println("Class not found");
           c.printStackTrace();
           return;
        }
}

}	
