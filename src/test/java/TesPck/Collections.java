package TesPck;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yaml.snakeyaml.emitter.ScalarAnalysis;

public class Collections {

	public static void main(String[] args) {
		//		ArrayList<String> as= new ArrayList<String>();
		//		as.add("hi");
		//		as.add("hi");
		//		System.out.println(as);
		//		System.out.println(as.get(0));
		//		System.out.println(as.size());
		//		for(int a = 0;a<=as.size()-1;a++) {
		//			System.out.println(as.get(a));
		//		}

		List<String> L= new LinkedList<String>();
		System.out.println(L.add("a"));
		//		System.out.println(L.add("a"));
		//		System.out.println(L.contains("A"));

		Map<String, Integer> val =new HashedMap<String, Integer>();

		//		fib(5);
		//		sumofDigitInString("Bangalire1212");
		//		numberOfDigitInNumber(23456);
		//		countDigitOccuranceInNumber(0,0);;)

		//		toogleString("Aa");
		//		reverseString("Bangalore");
		//		printUnique("BBaangoalore");  //still need to work
		//		stringImmutable();
		//		System.out.println(checkPalindrome("ABAN"));
		//		divideByZeroException();
		//      displayRowwiseColmwise();
		//        reverseAllWordsInString("Automation Test");
		//        secondLargestWordInString();
		//         sortArrayAsc();
		//        sortArrayDecsOrder();
//		         duplicateString(String ss);
		//			uniqueValues();
		//			revfirstThreeChar();
		//			revLastThreeChar(); Need to implenent
		//			wordStartWithChar();
		//			longestString(); // Need to check the logic
					trimSpaceTrailingLeading("  asdf  ");
					checkNumberPresent(1225678,9);
	}

	public static void fib(int n) {  //adde
		int first =0,second =1,count=2,temp=0;
		System.out.print(first +" "+second+" ");
		while(count<=n) {
			temp=first+second;
			first =second;
			second = temp;
			System.out.print(temp +" ");
			count++;
		}
	}

	public static int sumofDigitInString(String s) {
		int sum=0; 
		int count=0;
		char[] ch = s.toCharArray();
		for(char c: ch) {
			if(Character.isDigit(c)) {
				sum =sum+Character.getNumericValue(c);
				count++;
			}

		}

		System.out.println("sumofDigitInString "+sum);
		return sum;
	}

	public static int numberOfDigitInNumber(int num) {

		int count=0;int temp=0; int sum=0;
		if(num ==0) {
			return 0;	
		}
		else if(num<0) {
			return -1;
		}
		else {
			while(num!=0) {
				temp=num;
				num=num/10;
				sum = sum + (temp % 10);
				count++;
			}
		}
		System.out.println("count "+ count);
		System.out.println("sum "+ sum);	
		return count;
	}

	public static int countDigitOccuranceInNumber(int num,int checkNumber) {
		int count=0; int temp =0;

		if(num ==0 && checkNumber ==0)
		{
			return 1;
		}
		if(num <0) {
			return -1;
		}
		while(num!=0) {
			temp = num % 10 ;
			if(temp ==checkNumber) {
				count++;
			}
			num =num/10;
		}
		System.out.println("countDigitOccuranceInNumber "+count);
		return count;
	}

	public static void toogleString(String str) {
		String toogle ="";
		StringBuilder sb = new StringBuilder();
		char[] ch= str.toCharArray();
		for(char c: ch) {
			if(Character.isLowerCase(c)) {
				toogle =toogle+ Character.toUpperCase(c);
				sb.append(Character.toUpperCase(c));
			}
			else if(Character.isUpperCase(c)) {
				toogle = toogle + Character.toLowerCase(c);
				sb.append(Character.toLowerCase(c));
			}
			else {
				toogle =toogle + c;
				sb.append(c);
			}
		}
		System.out.println("toogleString : "+toogle);
		System.out.println("String Builder : "+sb.toString());
	}

	public static String reverseString(String in) {
		StringBuilder sb = new StringBuilder();
		int l = in.length()-1;
		for(int a=l;a>=0;a--){
			sb.append(in.charAt(a));
		}
		System.out.println(sb); // or sb..toString();
		return sb.toString();
	}

	public static void printUnique(String str) {
		Map<Character, Integer> val =new HashedMap<Character, Integer>();
		String unique ="";
		int l =str.length()-1;
		for(int q=0;q<=l;q++) {
			if(val.containsKey(str.charAt(q))) {
				int c= val.get(str.charAt(q)) + 1;
				val.put(str.charAt(q),c);
			}
			else {
				val.put(str.charAt(q), 1);
			}
		}
		System.out.println(val);
		// Need to iterate through the Map to find unique
	}

	public static void stringImmutable() {
		String s1= "Hi";
		String s2=s1;
		s1= s1+"Bangalore";
		if(s1==s2) {
			System.out.println("Mutable.");
		}else {
			System.out.println("Immutable..");
		}
	}

	public static boolean checkPalindrome(String str) {
		int a=0;
		int b=str.length()-1;
		while(a<=b) {
			if(str.charAt(a)!= str.charAt(b)) {
				return false;
			}
			a++;
			b--;
		}
		return true;
	}
	String removeWhiteSpaces(String input) {
		StringBuilder output = new StringBuilder();

		char[] charArray = input.toCharArray();

		for (char c : charArray) {
			if (!Character.isWhitespace(c))
				output.append(c);
		}

		return output.toString();
	}

	public static void divideByZeroException() {
		try {
			int result = 1/0;
		}catch(ArithmeticException e) {
			System.out.println("ArithmeticException");
		}catch(Exception e) {
			System.out.println("ArithmeticException");
		}
	}


	//	public static void wavePattern(int row, int col) {
	//		for(){
	//	}

	public static void displayRowwiseColmwise() {
		int row=3,col=3,val=0;
		int[][] arr =new int[row][col];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enyer..");
		for(int a=0;a<row;a++) {
			for(int b=0;b<col;b++) {
				arr[a][b] = val;
				val++;
				//				arr[a][b] = sc.nextInt();
			}
			if( a==8) {
				break;
			}
		}
		//System.out.print("Row [0] :");
		for(int r=0;r<row;r++) {
			System.out.print("Row["+r+"]: ");
			for(int c=0;c<col;c++) {
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}
		//Display column wise
		for(int c=0;c<row;c++) {
			System.out.print("Column["+c+"]: ");
			for(int r=0;r<col;r++) {
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}

	}

	public static void reverseAllWordsInString(String str) {
//		String str = "Hi Bangalore";
		String rev="";
		StringBuilder sb = new StringBuilder();
		String[] strArray = str.split(" ");
		for(int a=0; a<strArray.length;a++) {
			String st=  strArray[a];
			for(int b=st.length()-1;b>=0;b--) {
//				rev = rev + st.charAt(b);
				sb = sb.append(st.charAt(b));
			}
//			rev = rev+" ";
			sb.append(" ");
		}
		
//		System.out.println("Reversed :"+ rev);
		System.out.println("Reversed :"+ sb.toString());
	}

	
	//--- First Longest and Second longest word in string;
	public static void secondLargestWordInString() {
		String s = "WodJJJJ kjkkkttttttyuiiutjkkjhghjkkOne jjjjjjjjjjjjhss kkkkjjjjjjsssssssssssssssssssssssss";
		int max = 0;
		int second_Max=0;
		String firstMax = "";
		String secondMax="";
		String[] s1 = s.split(" ");
		for(String s2:s1) {
			int l = s2.length();
			if(l>=max ) {
				second_Max= max;
				max = l;
				secondMax = firstMax;
				firstMax = s2; //Largest word in String
				//				 secondMax = firstMax;
			}else if(l>secondMax.length()){
				secondMax= s2;

			}
			
//				System.out.println("Second :"+secondMax);

				//Second Approach;;
/*				Map<String,Integer> map = new HashedMap<String,Integer>();
				for(String ss:s1) {
					if(map.containsKey(ss)) {
						map.put(ss, map.get(ss)+1);
					}else {
						map.put(ss, 1);
					}
				}  */

			}
		System.out.println("First :"+firstMax);
		System.out.println("Second :"+secondMax);
		}
	
	public static int[] sortArrayAsc() {
		int[] arr = {3,7,3,7,3,6,7,7};
		int l = arr.length;
		int temp = 0;
		for(int a=0;a<l;a++) {
			for(int b=a+1;b<l;b++) {
				if(arr[a]>arr[b]) {
					temp=arr[a];
					arr[a]=arr[b];
					arr[b]=temp;
				}
			}
		} 
		for(int a=0;a<l;a++) {
			{
				System.out.println("hi :" +a + " "+arr[a]);
			}
		}
		return arr;
	}
	
	public static void sortArrayDecsOrder() {
		int[] arr = {0,3,7,3,7,3,6,7,7,-2};
		int l = arr.length;
		int temp = 0;
		for(int a=0;a<l;a++) {
			for(int b=a+1;b<l;b++) {
				if(arr[a]<arr[b]) {
					temp=arr[a];
					arr[a]=arr[b];
					arr[b]=temp;
				}
			}
		}
		System.out.println("Printing Array in Desc Order:");
		for(int a=0;a<l;a++) {
			{
				System.out.println("arr[" + a +"] "+ arr[a]);
			}
		}
	}
	
	public static boolean duplicateString(String input) {
//		String input = "JAVA C# Python SQL";   // "H H Hi Hi Hello";
		String[] s = input.split(" ");
		List<String> list = new ArrayList<String>();
		List<String> duplicateValues = new ArrayList<String>();
		List<String> uniqueValues = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		boolean flag =false;
		for(String ss:s) {
			list.add(ss);
		}
//		System.out.println(list.size());
		for(int a=0;a<list.size();a++) {
			if(!set.add(list.get(a))) {
				duplicateValues.add(list.get(a));
			}		
		}
		System.out.println("Duplicate Values in List :"+duplicateValues + ": Size "+duplicateValues.size());
		
		if(duplicateValues.size()==0) {
			return flag =true; // Return true if no duplicates else false
		}
		else {
			return flag;
		}
	}
	
	public static void /*List<String> */ uniqueValues() {  
		String input = "H H Hi Hi Hello One Two one oNe onE ONE";
		List<String> uniqueStringValues = new ArrayList<String>();
		String[] s = input.split(" ");
		Map<String,Integer> unique =new HashedMap<String,Integer>();
		StringBuilder str = new StringBuilder();
		for(int a = 0; a<=s.length-1;a++) {
			s[a]= s[a].toLowerCase(); // To Compare String value, string is converted to lower case.
			if(unique.containsKey(s[a])) {
				unique.put(s[a], unique.get(s[a])+1);
			}else {
				unique.put(s[a], 1);
//				uniqueStringValues.add(s[a]);
			}
		}
		for(int b=1;b<=unique.size()+1;b++) {
			if(unique.get(s[b])==1) {
				uniqueStringValues.add(s[b]);
			}
		}
		System.out.println("Unique String Value :"+uniqueStringValues);
//		return uniqueStringValues;
	}
	
	public static void revfirstThreeChar() {
		String str ="Bangalore";
		StringBuilder s =new StringBuilder();
		String out= "";
		int c =8;
		for(int a=c;a>=0;a--) {
			s.append(str.charAt(a));
		}
//		System.out.println(s);
		System.out.println(s.append(str.substring(c+1, str.length())));
		
	}
	
/*	public static void revLastThreeChar() {
		String str ="Bangalore";
		StringBuilder s = new StringBuilder();
		String out= "";
		int c =3;
		s.append(str.substring(0, c));
		System.out.println(s);
		for(int a=str.length()-1;a>=0;a--) {
//			if(c<0) {
//				break;
//			}
			s.append(str.charAt(a)); 
			c--;
		}
		System.out.println(s);
		
	} */
	
	public static void wordStartWithChar() {
		String s= "hi Bangalore Welcome to To bangalore";
		String[] arr = s.split(" ");
		List<String> list  =  new LinkedList<String>();
		Set<String> set = new HashSet<String>();  // Set Not Allow Duplicate.
		for(String ss:arr) { 
			char check= ss.charAt(0);
			ss= ss.replace(check, Character.toUpperCase(check));
			if( check == 'B' || check == 'b') {
				list.add(ss);
				set.add(ss);
			}
		}
		System.out.println("list : "+list);
		System.out.println("Set :"+set);
		
	}
	
	public static void longestString() {
		String s= "hi Bangalore Welcome to To bangalore sdfghgfsdfghhfdsdfgh";
		String[] arr = s.split(" ");
		String longestString="";
		String secondLongestString="";
		for(String ss:arr) {
			if(ss.length()>= longestString.length()) {
				longestString=ss;
			}
			else {
				secondLongestString= ss;
			}
		}
		System.out.println("longestString :"+longestString);
		System.out.println("secondLongestString :"+secondLongestString);
		
	}
	
	public static void sortList() {
		String s = "hi Bangalore Welcome to To bangalore sdfghgfsdfghhfdsdfgh";
		String[] arr = s.split(" ");
		List list = new ArrayList<String>();
		for(String ss:arr) {
			list.add(ss);
		}
		
		Col  // Need to check
	}
	
	public static void trimSpaceTrailingLeading(String s) {
//		String s ="  ACACA      ";
		System.out.println("Before Trim ;"+s);
		System.out.println("Before Trim ;"+s.trim());
	}
	
	public static void scrollToElement(WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("fruit-selects")));
	}
	
	public static void inputTextJSE(WebDriver driver, String locator) {  // need to work
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("fruit-selects")));
	}
	
	public static void checkNumberPresent(int number, int checkNumber) { 
		int isPresent=0;
		int sum=0;
		if(checkNumber < 10 && checkNumber >= 0) {
			while(number>0 && checkNumber >= 0) {
				int temp = number % 10;
				if(temp==checkNumber) {
						isPresent++;
						sum = sum+temp;
				}
				number= number/10;
			}
		} else {
			System.out.println("Enter the number between 0 to 9");
		}
		System.out.println("isPresent :"+ isPresent);
		System.out.println("Sum of All : "+sum);
	}
}