	import static org.junit.Assert.*;
	
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	
	import org.junit.BeforeClass;
	import org.junit.Test;
	
	
	public class JUnitTextBuddy {
	
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
		}
		
		@Test
		public void testSearch(){

			String line1 = "1 : This is a test file";
			String line2 = "2 : This is a test file last";
			
			ArrayList<Integer> expectedResponseFalse = new ArrayList<Integer>();
			ArrayList<Integer> expectedResponseOne = new ArrayList<Integer>();
			ArrayList<Integer> expectedResponseTwo = new ArrayList<Integer>();
			
			ArrayList<Integer> responseFalse;
			ArrayList<Integer> responseOne;
			ArrayList<Integer> responseTwo;
			
			expectedResponseOne.add(2);
			expectedResponseTwo.add(1);
			expectedResponseTwo.add(2);
			
			String falseInput = "false";
			String oneInput = "last";
			String twoInput = "test";
			
			TextBuddy testSoftware = new TextBuddy("text.txt");
			
			testSoftware.addContent(line1);
			testSoftware.addContent(line2);
			
			responseFalse = testSoftware.getSearchResults(falseInput);
			responseOne = testSoftware.getSearchResults(oneInput);
			responseTwo = testSoftware.getSearchResults(twoInput);
			
			assertEquals(expectedResponseFalse,responseFalse);
			assertEquals(expectedResponseOne,responseOne);
			assertEquals(expectedResponseTwo,responseTwo);
			
			testSoftware.clearContent();
			
		}
		
		@Test
		public void testSort(){

			ArrayList<String> expectedArray = new ArrayList<String>();
			
			String firstLine = "A first";
			String lastLine = "Z Last";
			String middleLine = "M middle";
			
			expectedArray.add(firstLine);
			expectedArray.add(middleLine);
			expectedArray.add(lastLine);
			
			TextBuddy testSoftware = new TextBuddy("test.txt");
			
			testSoftware.addContent(lastLine);
			testSoftware.addContent(firstLine);
			testSoftware.addContent(middleLine);
			
			assertFalse(expectedArray.equals(testSoftware.content));
			
			testSoftware.sortContent();
			
			assertEquals(expectedArray,testSoftware.content);
			
			testSoftware.clearContent();
		}
		
	
}
