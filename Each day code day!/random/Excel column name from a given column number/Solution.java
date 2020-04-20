public class Solution{
    public static void main(String[] args) {
        
        findColumnName(26);
        findColumnName(51);
        findColumnName(52);
        findColumnName(80);
        findColumnName(676);
        findColumnName(702);
        findColumnName(705);
        printString(704);
    }

    static void findColumnName(int columnNumber){
        //just like decimal system convert it into 26 base system
        // for case of subtraction when need to 500 - 9, we borrow 26 and reduce one i.e 25 26 YZ

        int[] base26Values = new int[1000];
        int i=0;
        // Step 1: Converting to number assuming 0 in number system 
        while(columnNumber >0 ){
            base26Values[i] = columnNumber % 26;
            columnNumber/=26;
            i++;
        }

        // Step 2: Getting rid of 0, as 0 is not part of number system 
        for(int j=0; j<i-1;j++ ){
            if(base26Values[j] == 0){
                base26Values[j] = 26;
                base26Values[j+1] -=1;
            }
        }

        //now print in reverse order 
        for(int j=i;j >=0; j--){
           if (base26Values[j] >0){
                System.out.print((char) (base26Values[j]+'A'-1));
            }
           
        }
        System.out.println(" ");
    }
 /* If remainder with 26 comes out to be 0 (meaning 26, 52 and so on) then we put ‘Z’ in the output string and new n becomes n/26 -1 because here we are considering 26 to be ‘Z’ while in actual it’s 25th with respect to ‘A’.

Similarly if the remainder comes out to be non zero. (like 1, 2, 3 and so on) then we need to just insert the char accordingly in the string and do n = n/26.

Finally we reverse the string and print.  */
    private static void printString(int columnNumber) 
    { 
        // To store result (Excel column name) 
        StringBuilder columnName = new StringBuilder(); 
  
        while (columnNumber > 0) { 
            // Find remainder 
            int rem = columnNumber % 26; 
  
            // If remainder is 0, then a 
            // 'Z' must be there in output 
            if (rem == 0) { 
                columnName.append("Z"); 
                columnNumber = (columnNumber / 26) - 1; 
            } 
            else // If remainder is non-zero 
            { 
                columnName.append((char)((rem - 1) + 'A')); 
                columnNumber = columnNumber / 26; 
            } 
        } 
  
        // Reverse the string and print result 
        System.out.println(columnName.reverse()); 
    } 
}