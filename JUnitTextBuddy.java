import static org.junit.Assert.*;
	
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	
	import org.junit.BeforeClass;
	import org.junit.Test;
	
	//Antony K
	public class JUnitTextBuddy {
	
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
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