//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           TestAdventureStory
// Files:           AdventureStory.java TestAdventureStory.java
// Course:          CS 200 Spring 2019
//
// Author:          Marc Renault
// Email:           mrenault@cs.wisc.edu
// Lecturer's Name: self
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/**
 * This class contains a few methods for testing methods in the AdventureStory
 * class as they are developed. These methods are private since they are only
 * intended for use within this class.
 * 
 * @author Marc Renault
 * @author Shashank Agrawal 
 *
 */
public class TestAdventureStory {
    
    /**
     * This is the main method that runs the various tests. 
     * 
     * @param args  (unused)
     */
    public static void main(String[] args) {
        //Milestone 1 Tests
       // testPromptInt();
      //testPromptChar();
       // testPromptString();
       // testGetRoomIndex();
       // testGetRoomDetails();
        testprintString();
        //testprintLine();

        //Milestone 2 Tests
       //testParseStory();
        
        
        //Milestone 3 Tests
       // testprobTrans();
      //testparseBookmark();
    }
    
    
    
    
    /*PrintLine test method
     */

    private static void testprintString() {
       
        String s = "The door to the cottage opens easily. Inside, she finds a lovely sitting room, bathed in a warm Summer's mid-morning light, containing three rocking chairs of different sizes.";
        
        AdventureStory.printString(Config.DISPLAY_WIDTH, s);
        
        
    }
    
    
    
    private static void testprintLine() {
        AdventureStory.printLine(Config.DISPLAY_WIDTH, Config.LINE_CHAR);
        System.out.println("Expected output is:");
        for(int i=0;i<Config.DISPLAY_WIDTH;i++)
        {
            System.out.print(Config.LINE_CHAR);
        }
        
    }
    
    /**
     * This runs some tests on the promptInt method.
     */ 
    private static void testPromptInt() {
        boolean error = false;
        
        { 
            Scanner in = new Scanner("8\n");
            int expected = 8;
            int result = AdventureStory.promptInt(in, "Enter integer: ", 5, 15);
            if(expected != result) {
                System.out.println("1) testPromptInt expected: " + expected + " result: " + result);
                error = true;
            }
        }
        { 
            Scanner in = new Scanner("15\n");
            int expected = 15;
            int result = AdventureStory.promptInt(in, "Enter integer: ", 5, 15);
            if(expected != result) {
                System.out.println("1) testPromptInt expected: " + expected + " result: " + result);
                error = true;
            }
        }
        
        
        if(error) {
            System.out.println("testPromptInt failed");
        } else {
            System.out.println("testPromptInt passed");
        }        
    }
    
    /**
     * This runs some tests on the promptString method.
     */ 
    private static void testPromptString() {
        boolean error = false;
        
        { 
            Scanner in = new Scanner("foobar\n");
            String expected = "foobar";
            String result = AdventureStory.promptString(in, "Enter: ");
            if(!expected.equals(result)) {
                System.out.println("1) testPromptString expected: " + expected + " result: " + result);
                error = true;
            }
        }
        
        Scanner in = new Scanner("  rrree 334\n");
        String expected = "rrree 334";
        String result = AdventureStory.promptString(in, "Enter: ");
        if(!expected.equals(result)) {
            System.out.println("1) testPromptString expected: " + expected + " result: " + result);
            error = true;
        }
            
        if(error) {
            System.out.println("testPromptString failed");
        } else {
            System.out.println("testPromptString passed");
        }        
    }

    /**
     * This runs some tests on the promptChar method.
     */ 
    private static void testPromptChar() {
        boolean error = false;
        
        { 
            Scanner in = new Scanner("  foobar\n");
            char expected = 'f';
            char result = AdventureStory.promptChar(in, "Enter: ");
            if(expected != result) {
                System.out.println("1) testPromptChar expected: " + expected + " result: " + result);
                error = true;
            }
        }
        { 
            Scanner in = new Scanner("corv eettte\n");
            char expected = 'c';
            char result = AdventureStory.promptChar(in, "Enter: ");
            if(expected != result) {
                System.out.println("1) testPromptChar expected: " + expected + " result: " + result);
                error = true;
            }
        }
        
        if(error) {
            System.out.println("testPromptChar failed");
        } else {
            System.out.println("testPromptChar passed");
        }        
    }
    

    /**
     * This runs some tests on the getRoomIndex method.
     */ 
    private static void testGetRoomIndex() {
        boolean error = false;
        
        {
            // Assuming normal Config.java
            ArrayList<String[]> in
                = new ArrayList<>(Arrays.asList(new String[][]{{"id1","",""},{"id2","",""}}));
            int expected = -1;
            int result = AdventureStory.getRoomIndex(new String("id3"),in);
            if(expected != result) {
                System.out.println("1) testGetRoomIndex expected: " + expected + " result: " + result);
                error = true;
            }
        }
        {
            // Assuming normal Config.java
            ArrayList<String[]> in
                = new ArrayList<>(Arrays.asList(new String[][]{{"id1","",""},{"id2","",""}}));
            int expected = 1;
            int result = AdventureStory.getRoomIndex(new String("id2"),in);
            if(expected != result) {
                System.out.println("1) testGetRoomIndex expected: " + expected + " result: " + result);
                error = true;
            }
        }
        
        if(error) {
            System.out.println("testGetRoomIndex failed");
        } else {
            System.out.println("testGetRoomIndex passed");
        }        
    }

    /**
     * This runs some tests on the getRoomIndex method.
     */ 
    private static void testGetRoomDetails() {
        boolean error = false;
        
        {
            //Assuming normal Config.java
            ArrayList<String[]> in
                = new ArrayList<>(Arrays.asList(new String[][]{{"id1","",""},{"id2","",""}}));
            String[] expected = in.get(0);
            String[] result = AdventureStory.getRoomDetails(new String("id1"),in);
            if(!Arrays.equals(expected,result)) {
                System.out.println("1) testGetRoomDetails expected: " + Arrays.toString(expected)
                                   + " result: " + Arrays.toString(result));
                error = true;
            }
        }
        
        {
            //Assuming normal Config.java
            ArrayList<String[]> in
                = new ArrayList<>(Arrays.asList(new String[][]{{"id1","",""},{"id2","",""}}));
            String[] expected = null;
            String[] result = AdventureStory.getRoomDetails(new String("id3"),in);
            if(!Arrays.equals(expected,result)) {
                System.out.println("1) testGetRoomDetails expected: " + Arrays.toString(expected)
                                   + " result: " + Arrays.toString(result));
                error = true;
            }
        }
        
        if(error) {
            System.out.println("testGetRoomDetails failed");
        } else {
            System.out.println("testGetRoomDetails passed");
        }        
    }

    private static void testParseStory() {
        boolean error = false;

        {
            Scanner testSc
                = new Scanner("#!STORY\n" +
                              "R1: Room 1\nRoom 1 description\n;;;\n: Transition 1 -> 1\n: Transition 2 -> 2\n" +
                              "R2: Room 2 \n Room 2 description \n;;;\n =) \n");
            ArrayList<String[]> arrRooms = new ArrayList<String[]>();
            ArrayList<ArrayList<String[]> >  arrTrans = new ArrayList<ArrayList<String[]> >();
            String[] curRoom = new String[1];
            boolean passed = true;
            if(!AdventureStory.parseStory(testSc, arrRooms, arrTrans, curRoom)) {
                System.out.println("parseStory 1: returned false instead of true.");
                passed = false;
            }
            //Assuming normal Config.java
            //Expected ArrayList of room detaisitls:
            ArrayList<String[]> expRooms =
                new ArrayList<String[]>(Arrays.asList(new String[][]{{"1",
                                                                      "Room 1",
                                                                      "Room 1 description"},
                                                                     {"2",
                                                                      "Room 2",
                                                                      "Room 2 description"}}));
            if(!compareArrayListsArrays(arrRooms, expRooms)) {
                System.out.println("parseStory 1: \nrooms ArrayList returned: \n" +
                                   Arrays.deepToString(arrRooms.toArray()) +
                                   "\nExpected: \n" +
                                   Arrays.deepToString(expRooms.toArray()) + "\n");
                passed = false;
            }
            //Expected ArrayList of ArrayList of transition details:
            ArrayList<String[]> room1Trans =
                new ArrayList<String[]>(Arrays.asList(new String[][]{{"Transition 1",
                                                                      "1",
                                                                      null},
                                                                     {"Transition 2",
                                                                      "2",
                                                                      null}}));
            ArrayList<String[]> room2Trans =
                new ArrayList<String[]>(Arrays.asList(new String[][]{{"=)", null, null}}));
            ArrayList<ArrayList<String[]> > expTrans = new ArrayList<ArrayList<String[]> >();
            expTrans.add(room1Trans);
            expTrans.add(room2Trans);
            if(!compare2dArrayLists(arrTrans, expTrans)) {
                System.out.println("parseStory 1: \ntransition ArrayList returned: \n" +
                                   toString2dArrayLists(arrTrans) +
                                   "\nExpected: \n" +
                                   toString2dArrayLists(expTrans) + "\n");
                passed = false;
            }
            if(passed) System.out.println("parseStory 1: passed"); 
            
        }
        
        {
            Scanner testSc
                = new Scanner("#!STORY\n" +
                              "R1: # Room 1 \n Room 1 description\n;;;\n: Transition 1 -> 1\n: Transition 2 -> 2\n" +
                              "R2:  # Room 2 \n Room 2 description \n;;;\n =) \n");
            ArrayList<String[]> arrRooms = new ArrayList<String[]>();
            ArrayList<ArrayList<String[]> >  arrTrans = new ArrayList<ArrayList<String[]> >();
            String[] curRoom = new String[1];
            boolean passed = true;
            if(!AdventureStory.parseStory(testSc, arrRooms, arrTrans, curRoom)) {
                System.out.println("parseStory 1: returned false instead of true.");
                passed = false;
            }
            //Assuming normal Config.java
            //Expected ArrayList of room detaisitls:
            ArrayList<String[]> expRooms =
                new ArrayList<String[]>(Arrays.asList(new String[][]{{"1",
                                                                      "# Room 1",
                                                                      "Room 1 description"},
                                                                     {"2",
                                                                      "# Room 2",
                                                                      "Room 2 description"}}));
            if(!compareArrayListsArrays(arrRooms, expRooms)) {
                System.out.println("parseStory 1: \nrooms ArrayList returned: \n" +
                                   Arrays.deepToString(arrRooms.toArray()) +
                                   "\nExpected: \n" +
                                   Arrays.deepToString(expRooms.toArray()) + "\n");
                passed = false;
            }
            //Expected ArrayList of ArrayList of transition details:
            ArrayList<String[]> room1Trans =
                new ArrayList<String[]>(Arrays.asList(new String[][]{{"Transition 1",
                                                                      "1",
                                                                      null},
                                                                     {"Transition 2",
                                                                      "2",
                                                                      null}}));
            ArrayList<String[]> room2Trans =
                new ArrayList<String[]>(Arrays.asList(new String[][]{{"=)", null, null}}));
            ArrayList<ArrayList<String[]> > expTrans = new ArrayList<ArrayList<String[]> >();
            expTrans.add(room1Trans);
            expTrans.add(room2Trans);
            if(!compare2dArrayLists(arrTrans, expTrans)) {
                System.out.println("parseStory 1: \ntransition ArrayList returned: \n" +
                                   toString2dArrayLists(arrTrans) +
                                   "\nExpected: \n" +
                                   toString2dArrayLists(expTrans) + "\n");
                passed = false;
            }
            if(passed) System.out.println("parseStory 1: passed"); 
            
        }
        
    }

    private static String toString2dArrayLists(ArrayList<ArrayList<String[]> > arrL1) {
        String toRet = "[\n";
        for(int i = 0; i < arrL1.size(); ++i) {
            toRet += "\t" + Arrays.deepToString(arrL1.get(i).toArray());
            if(i < arrL1.size() - 1) toRet += ",";
            toRet += "\n";
        }
        toRet += "]";
        return toRet;
    }

    private static boolean compareArrayListsArrays(ArrayList<String[]> arrL1, ArrayList<String[]> arrL2) {
        if(arrL1.size() != arrL2.size()) return false;
        for(int i = 0; i < arrL1.size(); ++i) {
            if(!Arrays.deepEquals(arrL1.get(i), arrL2.get(i))) return false;
        }
        return true;
    }
    
    private static boolean compare2dArrayLists(ArrayList<ArrayList<String[]> > arrL1,
                                                       ArrayList<ArrayList<String[]> > arrL2) {
        if(arrL1.size() != arrL2.size()) return false;
        for(int i = 0; i < arrL1.size(); ++i) {
            if(!compareArrayListsArrays(arrL1.get(i), arrL2.get(i))) return false;
        }
        return true;
    }



/* test for probTrans */

private static void testprobTrans() {
    boolean error = false;
    
    {
        // Assuming normal Config.java
        ArrayList<String[]> in
            = new ArrayList<>(Arrays.asList(new String[][]{{"id1","2","0"},{"id2","3","0"}}));
        String expected = null;
        Random rand= new Random();
        
        
        String result = AdventureStory.probTrans(rand,in);
        if(result!=expected) {
            System.out.println("1) testprobTrans expected: " + expected + " result: " + result);
            error = true;
        }
    }
    {
        // Assuming normal Config.java
        ArrayList<String[]> in
            = new ArrayList<>(Arrays.asList(new String[][]{{null,null,null},{null,null,null}}));
        String expected = null;
        Random rand= new Random(Config.SEED);
        String result = AdventureStory.probTrans(rand,in);
        if(expected!=result) {
            System.out.println("1) testGetRoomIndex expected: " + expected + " result: " + result);
            error = true;
        }
    }
    
    {
        // Assuming normal Config.java
        ArrayList<String[]> in
            = new ArrayList<>(Arrays.asList(new String[][]{{"21","34","4"},{"12","4","1"}}));
        String expected = "34" ;
        Random rand= new Random(Config.SEED);
        String result = AdventureStory.probTrans(rand,in);
        if(!expected.equals(result)) {
            System.out.println("1) testGetRoomIndex expected: " + expected + " result: " + result);
            error = true;
        }
    }
    {
        // Assuming normal Config.java
        ArrayList<String[]> in
            = new ArrayList<>(Arrays.asList(new String[][]{{null,"34","6"},{null,"4","3"},{null,"2","7"},{null,"1","4"}}));
        String expected = "2" ;
        Random rand= new Random(Config.SEED);
        String result = AdventureStory.probTrans(rand,in);
        if(!expected.equals(result)) {
            System.out.println("1) testGetRoomIndex expected: " + expected + " result: " + result);
            error = true;
        }
    }
    
    if(error) {
        System.out.println("testprobTrans failed");
    } else {
        System.out.println("testprobTrans passed");
    }        
}


private static void testparseBookmark() {
    boolean error = false;

    {
        Scanner sc = new Scanner("#!BOOKMARK\n"+"Goldilocks.story\n"+"7");
        Scanner testSc
            = new Scanner("#!STORY\n" +
                          "R1: Room 1\nRoom 1 description\n;;;\n: Transition 1 -> 1\n: Transition 2 -> 2\n" +
                          "R2: Room 2 \n Room 2 description \n;;;\n =) \n");
        ArrayList<String[]> arrRooms = new ArrayList<String[]>();
        ArrayList<ArrayList<String[]> >  arrTrans = new ArrayList<ArrayList<String[]> >();
        String[] curRoom = new String[1];
        boolean passed = true;
        if(!AdventureStory.parseBookmark(sc, arrRooms, arrTrans, curRoom)) {
            System.out.println("parseStory 1: returned false instead of true.");
            passed = false;
        }
                
        if(!curRoom[0].equals("7"))
            passed=false;
        if(passed) System.out.println("parseStory 1: Test 1 passed"); 
        
    }
    
    {
        Scanner testSc
            = new Scanner("#!STORY\n" +
                          "R1: # Room 1 description\n;;;\n: Transition 1 -> 1\n: Transition 2 -> 2\n" +
                          "R2:  # Room 2 \n Room 2 description \n;;;\n =) \n");
        ArrayList<String[]> arrRooms = new ArrayList<String[]>();
        ArrayList<ArrayList<String[]> >  arrTrans = new ArrayList<ArrayList<String[]> >();
        String[] curRoom = new String[1];
        boolean passed = true;
        if(!AdventureStory.parseStory(testSc, arrRooms, arrTrans, curRoom)) {
            System.out.println("parseStory 1: returned false instead of true.");
            passed = false;
        }
        //Assuming normal Config.java
        //Expected ArrayList of room details:
        ArrayList<String[]> expRooms =
            new ArrayList<String[]>(Arrays.asList(new String[][]{{"1",
                                                                  "Room 1",
                                                                  "Room 1 description"},
                                                                 {"2",
                                                                  "Room 2",
                                                                  "Room 2 description"}}));
        if(!compareArrayListsArrays(arrRooms, expRooms)) {
            System.out.println("parseStory 1: \nrooms ArrayList returned: \n" +
                               Arrays.deepToString(arrRooms.toArray()) +
                               "\nExpected: \n" +
                               Arrays.deepToString(expRooms.toArray()) + "\n");
            passed = false;
        }
        //Expected ArrayList of ArrayList of transition details:
        ArrayList<String[]> room1Trans =
            new ArrayList<String[]>(Arrays.asList(new String[][]{{"Transition 1",
                                                                  "1",
                                                                  null},
                                                                 {"Transition 2",
                                                                  "2",
                                                                  null}}));
        ArrayList<String[]> room2Trans =
            new ArrayList<String[]>(Arrays.asList(new String[][]{{"=)", null, null}}));
        ArrayList<ArrayList<String[]> > expTrans = new ArrayList<ArrayList<String[]> >();
        expTrans.add(room1Trans);
        expTrans.add(room2Trans);
        if(!compare2dArrayLists(arrTrans, expTrans)) {
            System.out.println("parseStory 1: \ntransition ArrayList returned: \n" +
                               toString2dArrayLists(arrTrans) +
                               "\nExpected: \n" +
                               toString2dArrayLists(expTrans) + "\n");
            passed = false;
        }
        if(passed) System.out.println("parseStory 1: passed"); 
        
    }
    
}






}
