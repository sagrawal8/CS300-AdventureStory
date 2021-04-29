import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
//Title:           descriptive title of the program making use of this file
//Files:           a list of all source files used by that program
//Course:          course number, term, and year
//
//Author:         Shashank
//Email:           your @wisc.edu email address
//Lecturer's Name: name of your lecturer
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name:    name of your pair programming partner
//Partner Email:   email address of your programming partner
//Lecturer's Name: name of your partner's lecturer
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//___ Write-up states that pair programming is allowed for this assignment.
//___ We have both read and understand the course Pair Programming Policy.
//___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully 
//acknowledge and credit those sources of help here.  Instructors and TAs do 
//not need to be credited here, but tutors, friends, relatives, room mates 
//strangers, etc do.  If you received no outside help from either type of 
//source, then please explicitly indicate NONE.
//
//Persons:         (identify each person and describe their help in detail)
//Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class AdventureStory {

    /**
     * Prompts the user for a value by displaying prompt.
     * Note: This method should not add a new line to the output of prompt. 
     *
     * After prompting the user, the method will consume an entire line of input while reading an 
     * int. 
     * If the value read is between min and max (inclusive), that value is returned.
     * Otherwise, "Invalid value." terminated by a new line is output and the user is prompted 
     * again. 
     *
     * @param sc The Scanner instance to read from System.in.
     * @param prompt The name of the value for which the user is prompted.
     * @param min The minimum acceptable int value (inclusive).
     * @param max The maximum acceptable int value (inclusive).
     * @return Returns the value read from the user.
     */
    public static int promptInt(Scanner sc, String prompt, int min, int max) {
                    
            int num, flag=1;
            
            do       
            {
                System.out.print(prompt);
                try {
                    num=sc.nextInt();
                    sc.nextLine();
                } catch(Exception error) {
                    flag = 0;
                    System.out.println("Invalid value.");
                    sc.nextLine();
                    continue;
                }
                if(num<=max&&num>=min)
                {
                 return num;
                }
                else
                    {
                    System.out.println("Invalid value.");
                    flag=0;
                    }
            } while(flag==0);
            
            
            
            return 0; 
        }
        

    /**
     * Prompts the user for a char value by displaying prompt.
     * Note: This method should not add a new line to the output of prompt. 
     *
     * After prompting the user, the method will read an entire line of input and return the first
     * non-whitespace character converted to lower case.
     *
     * @param sc The Scanner instance to read from System.in
     * @param prompt The user prompt.
     * @return Returns the first non-whitespace character (in lower case) read from the user. If 
     *         there are no non-whitespace characters read, the null character is returned.
     */
    public static char promptChar(Scanner sc, String prompt) {
        
       String inString;
       
       char returnedCharacter='\0';
            
           
     System.out.print(prompt);                
    inString=sc.nextLine();
     if(inString == null && inString.isEmpty())
        return '\0';
                    
                
    else 
    {        
         String userInputTrimmed=inString.trim();
         String userInputLower=userInputTrimmed.toLowerCase();               
         
         for(int i=0; i<userInputTrimmed.length();i++)
         {
             char c = userInputLower.charAt(i);
             if(Character.isLetter(c))
             {
                 returnedCharacter=c;
                 break;
             }
             else
                continue;
         }
         return returnedCharacter;
          
      }
                            
          
    }
                
                
               
               
                    
                    
                    
                    
                    
                    
                    
   
            
                 
        
       


    /**
     * Prompts the user for a string value by displaying prompt.
     * Note: This method should not add a new line to the output of prompt. 
     *
     * After prompting the user, the method will read an entire line of input, removing any leading and 
     * trailing whitespace.
     *
     * @param sc The Scanner instance to read from System.in
     * @param prompt The user prompt.
     * @return Returns the string entered by the user with leading and trailing whitespace removed.
     */    
    public static String promptString(Scanner sc, String prompt) {
        
        String inString;
       
      System.out.print(prompt);                
     inString=sc.nextLine();
     String userInputTrimmed=inString.trim();
                return userInputTrimmed;
      
       
    }

    /**
     * Saves the current position in the story to a file.
     *
     * The format of the bookmark file is as follows:
     * Line 1: The value of Config.MAGIC_BOOKMARK
     * Line 2: The filename of the story file from storyFile
     * Line 3: The current room id from curRoom
     *
     * Note: use PrintWriter to print to the file.
     *
     * @param storyFile The filename containing the cyoa story.
     * @param curRoom The id of the current room.
     * @param bookmarkFile The filename of the bookmark file.
     * @return false on an IOException, and true otherwise.
     */
    public static boolean saveBookmark(String storyFile, String curRoom, String bookmarkFile) {
        
        try{
            PrintWriter printWriter = new PrintWriter (bookmarkFile);               
            printWriter.println(Config.MAGIC_BOOKMARK);                             
            printWriter.println(storyFile);
            printWriter.println(curRoom);
            printWriter.close ();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    /**
     * Loads the story and current location from a file either a story file or a bookmark file. 
     * NOTE: This method is partially implementd in Milestone 2 and then finished in Milestone 3.
     * 
     * The type of the file will be determined by reading the first line of the file. The first
     * line of the file should be trimmed of whitespace.
     *
     * If the first line is Config.MAGIC_STORY, then the file is parsed using the parseStory method.
     * If the first line is Config.MAGIC_BOOKMARK, the the file is parsed using the parseBookmark
     * method.
     * Otherwise, print an error message, terminated by a new line, to System.out, displaying: 
     * "First line: trimmedLineRead does not correspond to known value.", where trimmedLineRead is 
     * the trimmed value of the first line from the file. 
     *
     * If there is an IOException, print an error message, terminated by a new line, to System.out,
     * saying "Error reading file: fName", where fName is the value of the parameter.
     *
     * If there is an error reading the first line, print an error message, terminated by a new 
     * line, to System.out, displaying: "Unable to read first line from file: fName", where fName is
     * the value of the parameter. 
     *
     * This method will be partially implemented in Milestone #2 and completed in Milestone #3 as 
     * described below.
     *
     * Milestone #2: Open the file, handling the IOExceptions as described above. Do not read the
     * the first line: Assume the file is a story file and call the parseStory method.
     *
     * Milestone #3: Complete the implementation of this method by reading the first line from the
     * file and following the rules of the method as described above.
     *
     * @param fName The name of the file to read.
     * @param rooms The ArrayList structure that will contain the room details. A parallel ArrayList
     *              trans.
     * @param trans The ArrayList structure that will contain the transition details. A parallel 
     *              ArrayList to rooms. Since the rooms can have multiple transitions, each room 
     *              will be an ArrayList<String[]> with one String[] per transition with the 
     *              overall structure being an ArrayList of ArrayLists of String[].
     * @param curRoom An array of at least length 1. The current room id will be stored in the cell
     *                at index 0.
     * @return false if there is an IOException or a parsing error. Otherwise, true. 
     */
    public static boolean parseFile(String fName, ArrayList<String[]> rooms,
                                    ArrayList<ArrayList<String[]> > trans,
                                    String[] curRoom) {
        
        boolean flag = true;                    //Checks if IOException occurs
        boolean flag1 = true;
        String str="";
        String strTrimmed="";    
        String parse="";     
        
        try {
            File file = new File(fName);                            
            Scanner sc = new Scanner (file);
            if(sc.hasNextLine())             // check is there's next in the document
                str=sc.nextLine();           // if story is read, parse story is called, if not                                                      
            if(str!=null)
                {
                    strTrimmed=str.trim();
                    parse="";
                    if(strTrimmed.equals(Config.MAGIC_STORY))                   // if story is read, parse story is called
                    {
                        parse="story";
                    }
                    else if(strTrimmed.equals(Config.MAGIC_BOOKMARK))           //if bookmark is read, parse bookmark is called
                    {
                        parse="bookmark";
                    }
                    else
                        parse="error";                                          //if can't be read, error is printed.
                }
            if(parse.equals("story"))
            {
                parseStory(sc, rooms, trans, curRoom); 
            }
               
            else if(parse.equals("bookmark"))
            {
                parseBookmark(sc, rooms, trans, curRoom);
            }
            else if(parse.equals("error"))
            {
                System.out.println("First line: "+strTrimmed+ "does not correspond to known value.");
                flag=false;
            }
                
               
            
        }
        catch(IOException e){                                                       // catches IO Exception
            System.out.println(e.getMessage());
            System.out.println("Error reading file: "+ fName);
            flag=false;
        }
        catch(Exception e) {
            System.out.println("Unable to read first line from file: "+ fName);                      //catches others exceptions
            flag=false;
        }
        
        
        
        
        
            return flag;
    }

    /**
     * Loads the story and the current room from a bookmark file. This method assumes that the first
     * line of the file, containing Config.MAGIC_BOOKMARK, has already been read from the Scanner.
     *
     * The format of a bookmark file is as follows:
     * Line No: Contents
     *       1: Config.MAGIC_BOOKMARK
     *       2: Story filename
     *       3: Current room id
     *
     * As an example, the following contents would load the story Goldilocks.story and set the 
     * current room to id 7.
     *
     * #!BOOKMARK
     * Goldilocks.story
     * 7
     *
     * Your method should not duplicate the code from the parseFile method. It must use the
     * parseFile method to populate the rooms and trans methods based on the contents of the story
     * filename read and trimmed from line 2 of the file. The value of for the cell at index 0 of 
     * curRoom is the trimmed value read on line 3 of the file.
     *
     * @param sc The Scanner object buffering the input file to read.
     * @param rooms The ArrayList structure that will contain the room details. A parallel ArrayList
     *              trans.
     * @param trans The ArrayList structure that will contain the transition details. A parallel 
     *              ArrayList to rooms.
     * @param curRoom An array of at least length 1. The current room id will be stored in the cell
     *                at index 0.
     * @return false if there is a parsing error. Otherwise, true. 
     */
    public static boolean parseBookmark(Scanner sc, ArrayList<String[]> rooms,
                                        ArrayList<ArrayList<String[]> > trans,
                                        String[] curRoom) {
        
        String str="";
        String strTrimmed="";
        boolean flag=true;
        String current="";
        String file="";
        try {
        while(sc.hasNextLine())
        {
            str=sc.nextLine();
            strTrimmed=str.trim();
            
            
            if(strTrimmed.charAt(0)=='#') //reads first line and ignores
            {
                continue;
            }
            
            else if(strTrimmed.contains(".story"))      //reads filename from second line
            {
                file=strTrimmed;
            }
            
            else 
            {
                                              
                    current=strTrimmed;    //sets curRoom to room number read from third line
                
            }
                
        }
        }
        catch(Exception ex)
        {
            
            flag=false;
            return flag;
        }
        
        
        if(!file.equals("")&&flag!=false)
        parseFile(file, rooms, trans, curRoom);
        curRoom[0]=current; //parse story sets curRoom to first room if not null, therefore it is being set here to room read from parseBookmark.
        
        return flag;
    }

    /**
     * This method parses a story adventure file.
     *
     * The method will read the contents from the Scanner, line by line, and populate the parallel 
     * ArrayLists rooms and trans. As such the story files have a specific structure. The order of
     * the rooms in the story file correspond to the order in which they will be stored in the 
     * parallel ArrayLists.
     *
     * When reading the file line-by-line, whitespace at the beginning and end of the line should be
     * trimmed. The file format described below assumes that whitespace has been trimmed.
     *
     * Story file format:
     *
     * - Any line (outside of a room's description) that begins with a '#' is considered a comment 
     *   and should be ignored.
     * - Room details begin with a line starting with 'R' followed by the room id, terminated with 
     *   a ':'. Everything  after the first colon is the room title. The substrings of the room id 
     *   and the room title should be trimmed.
     * - The room description begins on the line immediate following the line prefixed with 'R',
     *   containing the room id, and continues until a line of ";;;" is read.
     *   - The room description may be multi-line. Every line after the first one, should be 
     *     prefixed with a newline character ('\n'), and concatenated to the previous description 
     *     lines read for the current room.
     * - The room transitions begin immediately after the line of ";;;", and continue until a line
     *   beginning with 'R' is encountered. There are 3 types of transition lines:
     *   - 1 -- Terminal Transition: A terminal transition is either Config.SUCCESS or 
     *                               Config.FAIL. This room is the end of the story. 
     *                               This value should be stored as a transition with the String at
     *                               index Config.TRAN_DESC set to the value read. The rest of the 
     *                               Strings in the transition String array should be null.
     *                               A room with a terminal transition can only have one transition 
     *                               associated with it. Any additional transitions should result in
     *                               a parse error.
     *   - 2 -- Normal Transition: The line begins with ':' followed by the transition description, 
     *                             followed by " -> " (note the spaces), followed by the room id to 
     *                             transition to. For normal transitions (those without a transition
     *                             weight), set the value at index Config.TRAN_PROB to null.
     *   - 3 -- Weighted Transition: Similar to a normal transition except that there is a 
     *                               probability weight associated with the transition. After the 
     *                               room id (as described in the normal transition) is a '?' 
     *                               followed by the probability weight. 
     *   - You can assume that room ids do not contain a '?'.
     *   - You can assume that Config.SUCCESS and Config.FAIL do not start with a ':'.
     *
     * In the parallel ArrayLists rooms and trans, the internal structures are as follows:
     *
     * The String array structure for each room has a length of Config.ROOM_DET_LEN. The entries in
     * the array are as follows:
     * Index              | Description
     * --------------------------------------------
     * Config.ROOM_ID     | The room id
     * Config.ROOM_TITLE  | The room's title
     * Config.ROOM_DESC   | The room's description
     *
     * The String array structure for each transition. Note that each room can have multiple 
     * transitions, hence, the ArrayList of ArrayLists of String[]. The length of the String[] is
     * Config.TRAN_DET_LEN. The entries in the String[] are as follows:
     * Index               | Description
     * ------------------------------------------------------------------
     * Config.TRAN_DESC    | The transition description
     * Config.TRAN_ROOM_ID | The transition destination (id of the room) 
     * Config.TRAN_PROB    | The probability weight for the transition
     *
     * If you encounter a line that violates the story file format, the method should print out an 
     * error message, terminated by a new line, to System.out displaying: 
     * "Error parsing file on line: lineNo: lineRead", where lineNo is the number of lines read
     * by the parseStory method (i.e. ignoring the magic number if Milestone #3), and lineRead is 
     * the offending trimmed line read from the Scanner.
     *
     * After parsing the file, if rooms or trans have zero size, or they have different sizes, print
     * out an error message, terminated by a new line, to System.out displaying:
     * "Error parsing file: rooms or transitions not properly parsed."
     *
     * After parsing the file, if curRoom is not null, store the reference of the id of the room at 
     * index 0 of the rooms ArrayList into the cell at index 0 of curRoom. 
     *
     * Hint: This method only needs a single loop, reading the file line-by-line.
     * 
     * Hint: To successfully parse the file, you will need to maintain a state of where you are in 
     *       the file. I.e., are you parsing the description, parsing the transitions; is there an 
             error; etc? One suggestion would be to use an enum to enumerate the different states. 
     *
     * @param sc The Scanner object buffering the input file to read.
     * @param rooms The ArrayList structure that will contain the room details.
     * @param trans The ArrayList structure that will contain the transition details.
     * @param curRoom An array of at least length 1. The current room id will be stored in the cell
     *                at index 0.
     * @return false if there is a parsing error. Otherwise, true. 
     */ 
    public static boolean parseStory(Scanner sc, ArrayList<String[]> rooms,
                                     ArrayList<ArrayList<String[]> > trans,
                                     String[] curRoom) {
        
        
        
        int countID=-1;  //used to assign rooms to corresponding transitions
        
        int lineCount=0;   //counts no. of lines read
        boolean isTransition=false;  //true if transition is next, false if transition isn't being read.
        boolean check=true; //checks if story is parsed
        
        String[] tempRoom = new String [Config.ROOM_DET_LEN];   //temp string array to import room details to rooms
        String [] tempStringTransition = new String [Config.TRAN_DET_LEN];  // temp string array to import to tempListTransition
        ArrayList<String[]> tempListTransition = new ArrayList<String[]>(); // temp list to add to trans
        char[] tempRoomCharArray= null;     //used to store room ID and name
        boolean desc=false; // counter to check if desc is being read
        
        while(sc.hasNextLine())
        {
            lineCount++;
            String str, strTrimmed;      //next line is stored in str, next line trimmed is in strTrimmed
            str=sc.nextLine();
            strTrimmed=str.trim();
            
            
            if(strTrimmed.length()==0&&desc==true)
            {
                tempRoom[Config.ROOM_DESC]=tempRoom[Config.ROOM_DESC]+"\n";             //for blank lines in room description
            }
            
            else if(strTrimmed.length()==0)                            // blank lines in the story file.
                continue;
            
          
            
            else if(strTrimmed.equals(";;;"))                   //marks beginning of transition
            {
                desc=false;
                isTransition = true;
                rooms.add(tempRoom);                                //room details read previously are added to rooms array
//               
                tempRoom = new String [Config.ROOM_DET_LEN];            //temp room array is re-initialized
//                
                continue;
            }
            
            
            else if(desc==true)
            {
                tempRoom[Config.ROOM_DESC]=tempRoom[Config.ROOM_DESC]==null?strTrimmed:tempRoom[Config.ROOM_DESC]+strTrimmed;   //adds null character to room desc after its read.
                
                tempRoom[Config.ROOM_DESC]=tempRoom[Config.ROOM_DESC]+"\n";
             }
            
            else if(strTrimmed.charAt(0)=='R')                                  //Room details are read in here. Transition counter is turned off.
            {
                
                
                countID++;
                isTransition=false;
                tempListTransition = new ArrayList<String[]>();
              
                int i;
                boolean title=false; //counter to check if title is being copied or ID
                
                tempRoomCharArray=strTrimmed.toCharArray();     //transition is being read via char Array. ':' marks end of  room number and beginning of room title.
                for(i=1;i<tempRoomCharArray.length;i++)
                {
                    if(tempRoomCharArray[i]==':')
                        {
                            title=true;
                            continue;
                        }
                    
                    if(title==false)
                        tempRoom[Config.ROOM_ID]=tempRoom[Config.ROOM_ID]==null?String.valueOf(tempRoomCharArray[i]):tempRoom[Config.ROOM_ID]+String.valueOf(tempRoomCharArray[i]);
                    
                    else
                        
                        tempRoom[Config.ROOM_TITLE]=tempRoom[Config.ROOM_TITLE]==null?String.valueOf(tempRoomCharArray[i]):tempRoom[Config.ROOM_TITLE]+String.valueOf(tempRoomCharArray[i]);
                }
                
                if(tempRoom[1]!=null)
                tempRoom[Config.ROOM_TITLE]=tempRoom[Config.ROOM_TITLE].trim();    //removes extra spaces from room title.
                 desc=true;
            }
            
            else if(strTrimmed.charAt(0)=='#')          //ignores '#'
                continue;
            
            else if(isTransition==true)
            {
                
                
                if(strTrimmed.equals(Config.SUCCESS)||strTrimmed.equals(Config.FAIL))       //set trans title to =) or =( and probability and trans room ID to null.
                {
                    tempStringTransition[Config.TRAN_DESC]=strTrimmed;
                    tempStringTransition[Config.TRAN_ROOM_ID]=tempStringTransition[Config.TRAN_PROB]=null;
                    isTransition=false;
                    tempListTransition.add(tempStringTransition);
                    trans.add(countID,tempListTransition);
                    
                    tempStringTransition = new String [Config.TRAN_DET_LEN];
//                    System.out.println(countID);
                    
                }
                else if(strTrimmed.charAt(0)==':')                  //splits trans desc and room no/probability using whitespace. 
                {
                    
                    String[] split = strTrimmed.split(" ");
                    

                    boolean transRoom = false;        //counter for whether its transition desc or room no.
                    boolean transProbab=false;
                    for(int i=1;i<split.length;i++)
                    {
                        if(split[i].equals("->"))
                        {
                            transRoom=true;
                            continue;
                        }
                        if(transRoom==true)
                        {
                           if(split[i].equals("?"))
                           {
                               transProbab=true;             //used to check if trans room ID is being stored or trans Probab by use of '?'.
                               continue;
                               
                           }
                           if(transProbab==true)
                           {
                               tempStringTransition[Config.TRAN_PROB]=split[i];  //adds probability to temp string transition
                               transProbab=false;
                           }
                            
                                                     
                           else 
                                
                             tempStringTransition[Config.TRAN_ROOM_ID]=split[i];   //adds room ID to temp string transtion is transProbab is false.
                          }
                                
                         else                                                       //adds trans description to temp string transition
                         {
                             if(tempStringTransition[Config.TRAN_DESC]==null)
                             {
                                 tempStringTransition[Config.TRAN_DESC]=split[i] + " ";
                             }
                             else
                             {
                             tempStringTransition[Config.TRAN_DESC]=tempStringTransition[Config.TRAN_DESC]+split[i]+ " ";
                            
                             }
                             
                             tempStringTransition[Config.TRAN_PROB]=null;
                           }
                             
                    }
                    
                    if(tempStringTransition[Config.TRAN_DESC]!=null) 
                    tempStringTransition[Config.TRAN_DESC]=tempStringTransition[Config.TRAN_DESC].trim();           //trims trans desc of white spaces.
                    
                    tempListTransition.add(tempStringTransition);
                    
                    
                    if(trans.size()!=0)                                     //trans values were being added twice. this removes them.
                        {
                        if(trans.size() < countID)
                            {
                                trans.remove(countID);
                            }
                        }
                        trans.add(countID,tempListTransition);
                        
                        
                        tempStringTransition = new String [Config.TRAN_DET_LEN];            //transition string array is re-initialized.
                } 
            }
               
          else
                {
                    System.out.println("Error parsing file on line: "+ lineCount+": "+strTrimmed);
                    check=false;
                }
                
            }
        
        while(rooms.size()<trans.size())
        {
            trans.remove(rooms.size());                                 //trans values were being added twice. this removes them.
        }
        
        if(curRoom!=null)
        {
            curRoom[0]=rooms.get(0)[Config.ROOM_ID];
        }
        if(rooms.size()==0||trans.size()==0)                                //checks if file was properly parsed.
        {
           check=false;
            System.out.print("Error parsing file: rooms or transition not properly parsed");
        }
        
            
        return check;
    }

    /**
     * Returns the index of the given room id in an ArrayList of rooms. 
     *
     * Each entry in the ArrayList contain a String array, containing the details of a room. The 
     * String array structure, which has a length of Config.ROOM_DET_LEN, and has the following 
     * entries:
     * Index              | Description
     * --------------------------------------------
     * Config.ROOM_ID     | The room id
     * Config.ROOM_TITLE  | The room's title
     * Config.ROOM_DESC   | The room's description
     *
     * @param id The room id to search for.
     * @param rooms The ArrayList of rooms.
     * @return The index of the room with the given id if found in rooms. Otherwise, -1.
     */
    public static int getRoomIndex(String id, ArrayList<String[]> rooms) {
       
        int found=0;
        int index=0;
        String[] innerList = new String[Config.ROOM_DET_LEN];
        
        for(int i=0;i<rooms.size();i++)
        {
            innerList=rooms.get(i);
            if(innerList[Config.ROOM_ID].equals(id))
            {
                found=1;
                index=i;
                break;                
            }
            
            if(found==1)
                break;
            
        }
        
        if(found==0)
            return -1;
        else 
            return index;
        
        
        
       
    }
    
    /**
     * Returns the room String array of the given room id in an ArrayList of rooms. 
     *
     * Remember to avoid code duplication!
     *
     * @param id The room id to search for.
     * @param rooms The ArrayList of rooms.
     * @return The reference to the String array in rooms with the room id of id. Otherwise, null.
     */
    public static String[] getRoomDetails(String id, ArrayList<String[]> rooms) {
        
        int index=getRoomIndex(id,rooms);
        if(index==-1)
            return null;
        else
        {
            String[] innerList = new String[Config.ROOM_DET_LEN];
            innerList=rooms.get(index);
            return innerList;           
        }      
        
        
    }

    /**
     * Prints out a line of characters to System.out. The line should be terminated by a new line.
     *
     * @param len The number of times to print out c. 
     * @param c The character to print out.
     */
    public static void printLine(int len, char c) {
        for(int i=0;i<len;i++)
        {
            System.out.print(c);
        }
        System.out.println();
    }

    /**
     * Prints out a String to System.out, formatting it into lines of length no more than len 
     * characters.
     * 
     * This method will need to print the string out character-by-character, counting the number of
     * characters printed per line. 
     * If the character to output is a newline, print it out and reset your counter.
     * If it reaches the maximum number of characters per line, len, and the next character is:
     *   - whitespace (as defined by the Character.isWhitespace method): print a new line 
     *     character, and move onto the next character.
     *   - NOT a letter or digit (as defined by the Character.isLetterOrDigit method): print out the
     *     character, a new line, and move onto the next character.
     *   - Otherwise:
     *       - If the previous character is whitespace, print a new line then the character.
     *       - Otherwise, print a '-', a new line, and then the character. 
     * Remember to reset the counter when starting a new line. 
     *
     * After printing out the characters in the string, a new line is output.
     *
     * @param len The maximum number of characters to print out.
     * @param val The string to print out.
     */
    public static void printString(int len, String val) {
        
        int countTotal=-1;
        int countPerLine=-1;
        len=len-1;
        
        while(countTotal<val.length()-1)
        {
            countTotal++;
            countPerLine++;
            if(val.charAt(countTotal)=='\n')
                {
                countPerLine=0;
                System.out.print(val.charAt(countTotal));
                continue;
                }
            if(countPerLine==len)
            {
                
                if(Character.isWhitespace(val.charAt(countTotal)))              //checks for whitespace
                {
                    
                    System.out.println();  
                    countPerLine=0;
                    continue;
                }
                else if(!Character.isLetterOrDigit(val.charAt(countTotal)))     //checks for not a letter or digit
                {
                    System.out.println(val.charAt(countTotal)); 
                    countPerLine=0;
                    continue;
                }
                else
                {
                    if(Character.isWhitespace(val.charAt(countTotal-1)))                //checks if previous character was whitesapce
                    {
                        System.out.println();
                        System.out.print(val.charAt(countTotal));
                        countPerLine=1;
                    }
                    else
                    {
                        System.out.println("-");
                        System.out.print(val.charAt(countTotal));
                        countPerLine=1;
                    }
                    
                }
                    
            }
            else
                {
                    System.out.print(val.charAt(countTotal));
                                   
                }
            
        }
        
        
        
        
    }

    /**
     * This method prints out the room title and description to System.out. Specifically, it first
     * loads the room details, using the getRoomDetails method. If no room is found, the method
     * should return, avoiding any runtime errors.
     *
     * If the room is found, first a line of Config.LINE_CHAR of length Config.DISPLAY_WIDTH is 
     * output. Followed by the room's title, a new line, and the room's description. Both the title
     * and the description should be printed using the printString method with a maximum length of
     * Config.DISPLAY_WIDTH. Finally, a line of Config.LINE_CHAR of length Config.DISPLAY_WIDTH is 
     * output.
     *
     * @param id Room ID to display
     * @param rooms ArrayList containing the room details.
     */
    public static void displayRoom(String id, ArrayList<String[]> rooms) {
        
        String[] innerList= new String[Config.ROOM_DET_LEN];
        
        if(getRoomDetails(id,rooms)!=null||getRoomDetails(id,rooms).length!=0)
        {
            for(int i=0;i<Config.DISPLAY_WIDTH;i++)
            {
                System.out.print(Config.LINE_CHAR);
                
            }
            System.out.println();
            
            innerList=getRoomDetails(id, rooms);
            if(innerList[1]!=null)
            System.out.printf(innerList[1]);
            
            System.out.println();
            System.out.println();
            
            try {
                printString(Config.DISPLAY_WIDTH,innerList[2]);        //tries if room desc is not null        
            }
            catch(Exception e)
            {
            }
                       
            
            printLine(Config.DISPLAY_WIDTH, Config.LINE_CHAR);
            
                     
            return;    
            
        }
        else
            return;
        
    }

    /**
     * Prints out and returns the transitions for a given room. 
     *
     * If the room ID of id cannot be found, nothing should be output to System.out and null should
     * be returned.
     *
     * If the room is a terminal room, i.e., the transition list is consists of only a single 
     * transition with the value at index Config.TRAN_DESC being either Config.SUCCESS or 
     * Config.FAIL, nothing should be printed out.
     *
     * The transitions should be output in the same order in which they are in the ArrayList, and 
     * only if the transition probability (String at index TRAN_PROB) is null. Each transition 
     * should be output on its own line with the following format:
     * idx) transDesc
     * where idx is the index in the transition ArrayList and transDesc is the String at index 
     * Config.TRAN_DESC in the transition String array.
     *
     * See parseStory method for the details of the transition String array.
     *
     * @param id The room id of the transitions to output and return.
     * @param rooms The ArrayList structure that contains the room details.
     * @param trans The ArrayList structure that contains the transition details.
     * @return null if the id cannot be found in rooms. Otherwise, the reference to the ArrayList of
     *         transitions for the given room.
     */
    public static ArrayList<String[]> displayTransitions(String id, ArrayList<String[]> rooms,
                                                         ArrayList<ArrayList<String[]> > trans) {
        
        int reference=0;
        boolean flag=false;
        
        for(int i=0;i<rooms.size();i++)
        {
            String[] room = rooms.get(i);
            if(room[Config.ROOM_ID].equals(id))
            {
                reference=i;
                flag=true;
                ArrayList<String[]> innerArrayList = trans.get(i);
                if(innerArrayList.size()==1&&(innerArrayList.get(0)[Config.TRAN_DESC].equals(Config.SUCCESS)||innerArrayList.get(0)[Config.TRAN_DESC].equals(Config.FAIL)))
                    {
                      break;               //breaks if transition is =) or =(
                    }
                else 
                {
                    
                    for(int j=0;j<innerArrayList.size();j++)
                        {
                            if(innerArrayList.get(j)[Config.TRAN_PROB]==null)
                                 {
                                    System.out.println(j+") "+innerArrayList.get(j)[Config.TRAN_DESC]);
                                 }
                        }
                        

                }

            }
            
        }
        
        
        
        if(flag)
            return trans.get(reference);
        else 
            return null;
    }

    /**
     * Returns the next room id, selected randomly based on the transition probability weights.
     *
     * If curTrans is null or the total sum of all the probability weights is 0, then return null. 
     * Use Integer.parseInt to convert the Strings at index Config.TRAN_PROB of the transition
     * String array to integers. If there is a NumberFormatException, return null.
     *
     * It is important to follow the specifications of the random process exactly. Any deviation may
     * result in failed tests. The random transition work as follows:
     *   - Let totalWeight be the sum of the all the transition probability weights in curTrans.
     *   - Draw a random integer between 0 and totalWeight - 1 (inclusive) from rand.
     *   - From the beginning of the ArrayList curTrans, start summing up the transition probability 
     *     weights.
     *   - Return the String at index Config.TRAN_ROOM_ID of the first transition that causes the 
     *     running sum of probability weights to exceed the random integer.   
     *
     * See parseStory method for the details of the transition String array.
     *
     * @param rand The Random class from which to draw random values.
     * @param curTrans The ArrayList structure that contains the transition details.
     * @return The room id that was randomly selected if the sum of probabilities is greater than 0.
     *         Otherwise, return null. Also, return null if there is a NumberFormatException. 
     */
    public static String probTrans(Random rand, ArrayList<String[]> curTrans) {
        
       String s="";
       
              
        if(curTrans==null)                  //checks if curTrans is null
           return null;
        try{
            
            int totalWeight=0;
            
            
            for(int i=0;i<curTrans.size();i++)          //checks if total weight is 0
            {
                
                totalWeight=totalWeight+Integer.parseInt(curTrans.get(i)[Config.TRAN_PROB]);
                               
            }
            
           if(totalWeight==0)
           {
               return null;
               
           }
             
           
           int random=rand.nextInt(totalWeight);                            //picks random number
           
           
           int index=0;
           totalWeight=0;
           for(int i=0;i<curTrans.size();i++)
           {               
               if(totalWeight>random)
               {
                   s=curTrans.get(i)[Config.TRAN_ROOM_ID];            
                   
                   break;
               }
               index=i;
               totalWeight=totalWeight+Integer.parseInt(curTrans.get(i)[Config.TRAN_PROB]);                     //maintains rolling sum of probabilities
                              
           }
           
           
           if(totalWeight>random)
           {
               s=curTrans.get(index)[Config.TRAN_ROOM_ID];           //if total weight exceeded probability of last index isnt check in loop and checked here.
           }
           
           return s;
           
        }
           catch(NumberFormatException e)
           {
               
               return null;
           }
       
               
    }

    /**
     * This is the main method for the Story Adventure game. It consists of the main game loop and
     * play again loop with calls to the various supporting methods. This method will evolve over 
     * the 3 milestones.
     * 
     * The Scanner object to read from System.in and the Random object with a seed of Config.SEED 
     * will be created in the main method and used as arguments for the supporting methods as 
     * required.
     *
     * Milestone #1:
     *   - Print out the welcome message: "Welcome to this choose your own adventure system!"
     *   - Begin the play again loop:
     *       - Prompt for a filename using the promptString method with the prompt:
     *         "Please enter the story filename: "
     *       - Prompt for a char using the promptChar method with the prompt:
     *         "Do you want to try again? "
     *   - Repeat until the character returned by promptChar is an 'n'
     *   - Print out "Thank you for playing!", terminated by a newline.
     *
     * Milestone #2:
     *   - Print out the welcome message: "Welcome to this choose your own adventure system!"
     *   - Begin the play again loop:
     *       - Prompt for a filename using the promptString method with the prompt:
     *         "Please enter the story filename: "
     *       - If the file is successfully parsed using the parseFile method:
     *            - Begin the game loop with the current room ID being that in the 0 index of the 
     *              String array passed into the parseFile method as the 4th parameter
     *                 - Output the room details via the displayRoom method
     *                 - Output the transitions via the displayTransitions method
     *                 - If the current transition is not terminal:
     *                   - Prompt the user for a number between -1 and the number of transitions 
     *                     minus 1, using the promptInt method with a prompt of "Choose: "
     *                   - If the returned value is -1:
     *                      - read a char using promptChar with a prompt of
     *                        "Are you sure you want to quit the adventure? "
     *                      - Set the current room ID to Config.FAIL if that character returned is 'y'
     *                   - Otherwise: Set the current room ID to the room ID at index 
     *                                Config.TRAN_ROOM_ID of the selected transition.
     *                 - Otherwise, the current transition is terminal: Set the current room ID to 
     *                   the terminal state in the transition String array.
     *            - Continue the game loop until the current room ID is Config.SUCCESS or
     *              Config.FAIL
     *            - If the current room ID is Config.FAIL, print out the message (terminated by a 
     *              line): "You failed to complete the adventure. Better luck next time!"
     *            - Otherwise: print out the message (terminated by a line): 
     *              "Congratulations! You successfully completed the adventure!"
     *       - Prompt for a char using the promptChar method with the prompt:
     *         "Do you want to try again? "
     *   - Repeat until the character returned by promptChar is an 'n'
     *   - Print out "Thank you for playing!", terminated by a newline.
     *
     * Milestone #3:
     *   - Print out the welcome message: "Welcome to this choose your own adventure system!"
     *   - Begin the play again loop:
     *       - Prompt for a filename using the promptString method with the prompt:
     *         "Please enter the story filename: "
     *       - If the file is successfully parsed using the parseFile method:
     *            - Begin the game loop with the current room ID being that in the 0 index of the 
     *              String array passed into the parseFile method as the 4th parameter
     *                 - Output the room details via the displayRoom method
     *                 - Output the transitions via the displayTransitions method
     *                 - If the current transition is not terminal:
     *                   - If the value returnd by the probTrans method is null:
     *                     - Prompt the user for a number between -1 and the number of transitions 
     *                       minus 1, using the promptInt method with a prompt of "Choose: "
     *                     - If the returned value is -1:
     *                        - read a char using promptChar with a prompt of
     *                          "Are you sure you want to quit the adventure? "
     *                        - Set the current room ID to Config.FAIL if that character returned is 
     *                          'y'
     *                     - If the returned value is -2:
     *                        - read a String using the promptString method with a prompt of:
     *                          "Bookmarking current location: curRoom. Enter bookmark filename: ", 
     *                          where curRoom is the current room ID.
     *                        - Call the saveBookmark method and output (terminated by a new line):
     *                           - if successful: "Bookmark saved in fSave"
     *                           - if unsuccessful: "Error saving bookmark in fSave"
     *                       where fSave is the String returned by promptString.
     *                     - Otherwise: Set the current room ID to the room id at index 
     *                                  Config.TRAN_ROOM_ID of the selected transition.
     *                   - Otherwise, the value returned by probTrans is not null: make this value
     *                     the current room ID.
     *            - Continue the game loop until the current room ID is Config.SUCCESS or
     *              Config.FAIL.
     *            - If the current room ID is Config.FAIL, print out the message (terminated by a 
     *              line): "You failed to complete the adventure. Better luck next time!"
     *            - Otherwise: print out the message (terminated by a line): 
     *              "Congratulations! You successfully completed the adventure!"
     *       - Prompt for a char using the promptChar method with the prompt:
     *         "Do you want to try again? "
     *   - Repeat until the character returned by promptChar is an 'n'
     *   - Print out "Thank you for playing!", terminated by a newline.
     *
     * @param args Unused
     */
    public static void main(String[] args) {
        
           
        int count=0;
        char ch;
        Scanner sc = new Scanner(System.in); 
        Random rand = new Random(Config.SEED);
        String prompt2="Do you want to try again? ";
        String prompt3="Choose: ";
        String filename;
        ArrayList<String[]>rooms=new ArrayList<String[]>();
        ArrayList<ArrayList<String[]>> trans= new ArrayList<ArrayList<String[]>>();
        String[] curRoom = new String[20];
        String current;
        String transProb;
        System.out.println("Welcome to this choose your own adventure system!");
        
//        String prompt="Please enter the story filename: ";
//        filename = promptString(sc,prompt);
//        if(parseFile(filename, rooms, trans, curRoom))
//        {
//            System.out.println("trans");
//            for(ArrayList<String[]> array:trans)
//              {
//                  System.out.println("index");
//                  for(String[] array2:array)
//                  {
//                      System.out.println(Arrays.toString(array2));
//                  }
//                  
//              }
//            
//            System.out.println("rooms");
//            for(String[] array2:rooms)
//            {
//                System.out.print("index");
//                System.out.println(Arrays.toString(array2));
//            }
//        }
        
    
        do
        {
            
            trans= new ArrayList<ArrayList<String[]>>();
            rooms=new ArrayList<String[]>();
            String prompt="Please enter the story filename: ";
            filename = promptString(sc,prompt);            
            if(parseFile(filename, rooms, trans, curRoom))
            {
//                
                while(rooms.size()<trans.size())
                {
                    trans.remove(rooms.size());
                }
//                
               
                current=curRoom[0];
                               
                while(trans.get(Integer.parseInt(current)-1).get(0)[Config.TRAN_PROB]!=null||(!trans.get(Integer.parseInt(current)-1).get(0)[Config.TRAN_DESC].equals(Config.SUCCESS)&&!trans.get(Integer.parseInt(current)-1).get(0)[Config.TRAN_DESC].equals(Config.FAIL)))
                {
                    displayRoom(current,rooms);
                    displayTransitions(current, rooms, trans);
                    
                                      
                    if(trans.get(Integer.parseInt(current)).get(0)[Config.TRAN_DESC]!=Config.SUCCESS||trans.get(Integer.parseInt(current)).get(0)[Config.TRAN_DESC]!=Config.FAIL)
                    {
                        
                        transProb=probTrans(rand, trans.get(Integer.parseInt(current)-1));
                        if(transProb==null)
                        {
                            
                            int x;
                            
                            x=promptInt(sc, prompt3, -2, trans.get(Integer.parseInt(current)).size());
                            
                            if(x==-1)
                            {
                                char c;
                                c=promptChar(sc,"Are you sure you want to quit the adventure? ");
                                if (c=='y')
                                {
                                    current=Config.FAIL;
                                    break;
                                }
                            }
                            
                            else if(x==-2)
                            {
                                String str;
                                str = promptString(sc, "Bookmarking current location: "+ curRoom[0] +". Enter bookmark fileName: ");
                                if(saveBookmark(filename,current,str))
                                {
                                    System.out.println("Bookmark saved in "+ str);
                                }
                                else
                                    System.out.print("Error saving bookmark in "+str);
                            }
                            
                            else
                                {
                                current=trans.get(Integer.parseInt(current)-1).get(x)[Config.TRAN_ROOM_ID];                                
                                }
                        }                        
                        else    
                        {                           
                            current=transProb;
                            
                        }
                      }
                                      
                                
                    }
                    
                System.out.println();
                if(!current.equals(Config.FAIL))
                    
                    displayRoom(current,rooms);
                    
                    
                if(current==Config.FAIL)
                {
                    System.out.println("You failed to complete the adventure. Better luck next time!");
                                            
                }
                else
                    System.out.println("Congratulations! You successfully completed the adventure!");
            
            }
            ch=promptChar(sc,prompt2);
            if(ch=='n')
                {
                System.out.println("Thank you for playing!");
                count=1;
                }            
            
        } while(count==0);            
        
    }
}
        
        
    

