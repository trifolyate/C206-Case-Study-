import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;

import org.junit.Test;

public class zhouhong {

//	public static void inputParentForSuperUser(ArrayList<parent> parentlist) {
//		String parentName = Helper.readString("Enter Parent Name: ");
//		String email = Helper.readString("Enter Parent Email: ");
//		int contactNo = Helper.readInt("Enter Contact No: ");
//		int familyid = parentlist.size() + 1;
//
//		parent p = new parent(parentName, email, contactNo, familyid);
//		addParent(parentlist, p);
//	}
//
//	public static void inputParentForRegistration(ArrayList<parent> parentlist, String parentName, String email,
//			int contactNo, int familyid) {
//		parent p = new parent(parentName, email, contactNo, familyid);
//		addParent(parentlist, p);
//	}
//
//	public static void addParent(ArrayList<parent> parentList, parent p) {
//
//		parentList.add(p);
//
//	}
//	
//	public static String deleteParent(ArrayList<parent> parentList, parent p) {
//		String output = "";
//		for (int i = 0; i < parentList.size(); i++) {
//
//			output += String.format("%-84s\n", parentList.get(i).toString());
//		}
//		return output;
//	}
//
//	public static String viewAllParent(ArrayList<parent> parentList) {
//		C206_CaseStudy.setHeader("PARENT LIST");
//		String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "CHILD ID", "CHILD NAME",
//				"CHILD GRADE", "CHILD CLASS", "CHILD TEACHER", "NAME", "CCA ID", "EMAIL", "CONTACT NO");
//		output += retrieveAllParent(parentList);
//		System.out.println(output);
//		return output;
//	}
//	
//	@Test
//	public void testAddParent() {
//		// Item list is not null, so that can add a new parent
//		assertNotNull("Test if there is valid parent arraylist to add to", parentList);
//
//		// Given an empty list, after adding 1 parent, the size of the list is 1
//		C206_CaseStudy.addParent(parentList, p1);
//		assertEquals("Test if that parent arraylist size is 1?", 1, parentList.size());
//
//		// The parent just added is as same as the first item of the list
//		assertSame("Test that parent is added same as 1st item of the list?", p1, parentList.get(0));
//
//		// Add another parent. test The size of the list is 2?
//		C206_CaseStudy.addParent(parentList, p2);
//		assertEquals("Test that parent arraylist size is 2?", 2, parentList.size());
//	}
//	
//	@Test
//	public void testViewAllParent() {
//		assertNotNull("Test if there is valid parent arraylist to view from", parentList);
//
//		String registeredParent = C206_CaseStudy.viewAllParent(parentList);
//		String testOutput = "";
//		assertEquals("Check that ViewAllParentlist", testOutput, registeredParent);
//
//		assertEquals("Test if that parent arraylist size is 2?", 2, parentList.size());
//
//	}
//	
//	@Test
//	public void testDeleteParent() {
//		// Item list is not null, so that can delete a parent
//		assertNotNull("Test if there is valid parent arraylist to delete from", parentList);
//
//		String registeredParent = C206_CaseStudy.viewAllParent(parentList);
//		String testOutput = "";
//		assertEquals("Check that ViewAllParentlist", testOutput, registeredParent);
//
//		C206_CaseStudy.deleteParent(parentList, p2);
//		assertEquals("Test if that parent arraylist size is 1?", 1, parentList.size());
//	}
	
}
