import java.util.ArrayList;

public class sruthi {
		public static String retrieveAllCCA(ArrayList<CCA>CCAList) {
			String output="";
			for (int i =0;i<CCAList.size();i++) {
				output += String.format("%-84s\n", CCAList.get(i).toString());
			}
			return output;
		}
		public static String viewAllCCA(ArrayList<CCA> CCAList) {
			C206_CaseStudy.setHeader("CCA LIST");
			String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s\n", "CCA TITLE", "DESCRIPTION",
					"CLASS SIZE", "DAY OF WEEK","TIME","NAME","VENUE");
			output +=retrieveAllCCA(CCAList);
			System.out.println(output);
			return output;
			
			
		}
		//does this work?
		//check CCA size
		
		public static int checkCCAsize(ArrayList<CCA> CCAList) {
			int position = 0;
			boolean i = true;
			while (i ==true) {
				String cca_Title=" ";
				String cca_class_size= " ";
				cca_Title = Helper.readString("Enter CCA title >: ");
				cca_class_size = Helper.readString("Enter CCA class size >: ");
				
				for (int c =0;c < CCAList.size();c++) {
					if(CCAList.get(c).getCca_title().equals(cca_Title)) { //check if there input is inside CCAList
						if(CCAList.get(c).getCca_class_size()>=50);
						position = c;
						i= false;
						break;
					}else {
						System.out.println("Incorrect CCA class size,please try again");
						break;
					}
				}
				
			}
			return position;
			
		}
		
	
		//================================= Option 2 Add an user (CRUD - Create) =================================
//		public static parent inputParent() {
//			int childID = Helper.readInt("Enter child's ID > ");
//			String childName = Helper.readString("Enter child's name > ");
//			char grade = Helper.readChar("Enter child's grade > ");
//			String classroom = Helper.readString("Enter child's class > ");
//			String teacher = Helper.readString("Enter child's teacher > ");
//			String parentName = Helper.readString("Enter parent's name > ");
//			String CCAID = Helper.readString("Enter CCA ID > ");
//			String email = Helper.readString("Enter email > ");
//			int contactNo = Helper.readInt("Enter contact number > ");
//
//			//parent p = new parent(childID, childName, grade, classroom, teacher, parentName, CCAID, email, contactNo);
//			//return p;
//			
//		}
		//
		public static void addParent(ArrayList<parent> parentList, parent p) {
			
			parentList.add(p);
			
		}
		
		// FOR ADD CCA DETIALS
		
		public static CCA inputCCA() {
			String category_title = Helper.readString("Enter category Title> ");
			int category_id = Helper.readInt("Enter category ID> ");
			String ccaTitle = Helper.readString("Enter CCA title > ");
			String ccaDescription = Helper.readString("Enter CCA description > ");
			int ccaClassSize = Helper.readInt("Enter CCA class size > ");
			String ccaDay = Helper.readString("Enter CCA day of week> ");
			int ccaTime = Helper.readInt("Enter CCA time > ");
			String ccaVenue = Helper.readString("Enter CCA venue > ");
			
			CCA cca = new CCA (category_title,category_id ,ccaTitle, ccaDescription, ccaClassSize, ccaDay, ccaTime, ccaVenue);
			return cca;
			
		}
		
		public static void addCCA(ArrayList<CCA>CCAList,CCA cca) {
			CCAList.add(cca);
		}
		
		
		//================================= Option 3 Delete an user (CRUD - Delete) =================================
		
		public static void deleteParent(ArrayList<parent> parentList, parent p) {

			parentList.remove(p);
			
		}
		public static void deleteCCA(ArrayList<CCA>CCAList,CCA cca) {
			CCAList.remove(cca);
		}
		
		//test cases
		
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//	// ADD CCA details
//	@Test
//	public void testAddCCA() {
//		// CCA list is not null, so that can add a new CCA
//				assertNotNull("Test if there is valid CCA arraylist to add to", CCAList);
//				
//				//Given an empty list, after adding 1 CCA, the size of the list is 1
//				C206_CaseStudy.addCCA(CCAList, cca1);		
//				assertEquals("Test if that CCA arraylist size is 1?", 1, CCAList.size());
//				
//				//The CCA just added is as same as the first item of the list
//				assertSame("Test that CCA is added same as 1st item of the list?", cca1, CCAList.get(0));
//				
//				//Add another CCA. test The size of the list is 2?
//				C206_CaseStudy.addCCA(CCAList, cca2);
//				assertEquals("Test that CCA arraylist size is 2?", 2, CCAList.size());
//		
//	}
//
//
//
//
//	//VIEWCCA
//	@Test
//	public void testRetrieveAllCCA() {
//		// Test if CCA list is not null but empty, so that can add a new item
//		assertNotNull("Test if there is valid CCA arraylist to add to", CCAList);
//					
//		//test if the list of CCA retrieved  is empty
//		String allCCA= C206_CaseStudy.retrieveAllCCA(CCAList);
//		String testOutput = "";
//		assertEquals("Check that ViewAllCCAlist", testOutput, allCCA);
//							
//		//Given an empty list, after adding 2 items, test if the size of the list is 2
//		C206_CaseStudy.addCCA(CCAList, cca1);
//		C206_CaseStudy.addCCA(CCAList, cca2);
//		assertEquals("Test if that Chromebook arraylist size is 2?", 2, CCAList.size());
//					
//		//test if the expected output string same as the list of CCA retrieved from the SourceCentre
//		allCCA= C206_CaseStudy.retrieveAllCCA(CCAList);
//
//	    testOutput = String.format("%-10s %-10s %-10s %-10s %-10s %-10s\n","Music", "All songs", "20", "Monday", "9","Hall1");
//		testOutput += String.format("%-10s %-10s %-10s %-10s %-10s %-10s\n","Dance", "All dance", "25", "Tuesday", "10","hall12");
//	   
//		
//		assertEquals("Check that ViewAllCCA", testOutput, allCCA);
//					
//			
//		}
//
//	
//
//	//Delete CCA
//	@Test
//	public void testDeleteCCA() {
//             assertNotNull("Test if there is valid CCA arraylist to add to", CCAList);
//		
//		String CCA= C206_CaseStudy.viewAllCCA(CCAList);
//		String testOutput = "";
//		assertEquals("Check that ViewAllCAAList", testOutput,CCA );
//		
//		C206_CaseStudy.deleteCCA(CCAList, cca2);
//		assertEquals("Test if that student arraylist size is 1?", 1,CCAList.size());
//
//
//	}
//	
//
//	@After
//	public void tearDown() throws Exception {
//		
//		cca1= null;
//		cca2=null;
//		CCAList = null;
//
//		CCAList = null;
//		categoryList = null;
//>>>>>>> branch 'master' of https://github.com/trifolyate/C206-Case-Study-.git
//	}
//
//}
