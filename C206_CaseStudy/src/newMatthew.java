import java.util.ArrayList;

//help check please thank you <3

public class newMatthew {
	private static final int OPTION_QUIT = 4;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;

	public static void itemTypeMenu() {
		C206_CaseStudy.setHeader("users");
		System.out.println("1. Parent");
		System.out.println("2. Student");
		System.out.println("3. Teacher");
		System.out.println("4. CCA");
		System.out.println("5. CCA Categories");
	}

//test
	
	//Adding a CCA category
	 public static CCA AddCCACategory() {
		 String category_title = Helper.readString("Enter category Title: ");
			int category_id = Helper.readInt("Enter category ID: ");
			
			CCA ccaCat = new CCA (category_title,category_id);
			return ccaCat;
		 
	 }
	 public static void addCCACategory(ArrayList<CCACategory>categorylist,CCA ccaCat) {
			categorylist.add(ccaCat);
		}
	//View all CCA category 
	public static String retrieveAllCCACategory(ArrayList<CCACategory>categorylist) {
		String output="";
		for (int i =0;i<categorylist.size();i++) {
		output += String.format("%-84s\n", categorylist.get(i).toString());
}
		return output;
			}
			
	public static String viewAllCCACategory(ArrayList<CCACategory> categorylist) {
		C206_CaseStudy.setHeader("CCA Categories");
		String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s\n", "CCA Category", "CCA id");
		output +=retrieveAllCCACategory(categorylist);
		System.out.println(output);
		return output;
				
				
			}
	//Delete CCA category
	public static void deleteCCACategory(ArrayList<CCACategory>categorylist,CCA ccaCat) {
		categorylist.remove(ccaCat);
	}
	
	 
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//// ADD CCA CATEGORY
//@Test
//public void testAddCCACategory() {
//// CCA category list is not null, so that can add a new CCA category
//assertNotNull("Test if there is valid CCA arraylist to add to", categorylist);
//
////Given an empty list, after adding 1 CCA Category, the size of the list is 1
//C206_CaseStudy.addCCACategory(categorylist, ccaCat1);		
//assertEquals("Test if that CCA Category arraylist size is 1?", 1, categorylist.size());
//
////The CCA category just added is as same as the first item of the list
//assertSame("Test that CCA category is added same as 1st item of the list?", ccaCat1, categorylist.get(0));
//
////Add another CCA. test The size of the list is 2?
//C206_CaseStudy.addCCACategory(categorylist, ccaCat2);
//assertEquals("Test that CCA category arraylist size is 2?", 2, categorylist.size());
//
//}
//
//
//
//
////VIEW CCA CATEGORY
//@Test
//public void testRetrieveAllCCACategory() {
//// Test if CCA category list is not null but empty, so that can add a new item
//assertNotNull("Test if there is valid CCA category arraylist to add to", categorylist);
//
////test if the list of CCA category retrieved  is empty
//String allCCA= C206_CaseStudy.retrieveAllCCACategory(categorylist);
//String testOutput = "";
//assertEquals("Check that ViewAllcategorylist", testOutput, allCCACategory);
//
////Given an empty list, after adding 2 items, test if the size of the list is 2
//C206_CaseStudy.addCCACategory(categorylist, ccaCat1);
//C206_CaseStudy.addCCACategory(categorylist, ccaCat2);
//assertEquals("Test if that Chromebook arraylist size is 2?", 2, categorylist.size());
//
////test if the expected output string same as the list of CCA retrieved from the SourceCentre
//allCCACategory = C206_CaseStudy.retrieveAllCCACategory(categorylist);
//
//testOutput = String.format("%-10s %-10s %-10s %-10s %-10s %-10s\n","Sports", "1");
//testOutput += String.format("%-10s %-10s %-10s %-10s %-10s %-10s\n","Drama", "2");
//
//
//assertEquals("Check that ViewAllCCACategory", testOutput, allCCACategory);
//
//
//}
//
//
//
////Delete CCA Category
//@Test
//public void testDeleteCCACategory() {
//assertNotNull("Test if there is valid CCA category arraylist to add to", categorylist);
//
//String CCA= C206_CaseStudy.viewAllCCACategory(categorylist);
//String testOutput = "";
//assertEquals("Check that ViewAllCCACategory", testOutput,CCA );
//
//C206_CaseStudy.deleteCCACategory(categorylist, ccaCat2);
//assertEquals("Test if that CCA category arraylist size is 1?", 1,categorylist.size());
//
//
//}
// 
