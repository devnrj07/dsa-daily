# Binary Search             

99% of binary search problems that you see online will fall into 1 of these 3 templates. Some problems can be implemented using multiple templates, but as you practice more, you will notice that some templates are more suited for certain problems than others.

<b>Note</b>: The templates and their differences have been colored coded below.

![template](Template_Diagram.png)

Template 1 and 3 are the most commonly used and almost all binary search problems can be easily implemented in one of them. Template 2 is a bit more advanced and used for certain types of problems.

Each of these 3 provided templates provide a specific use case:

# usecase
- Template 1 (unbiased search)
  - (left <= right)
    - Most basic and elementary form of Binary Search
    - Search Condition can be determined without comparing to the element's neighbors 
    - No post-processing required because at each step, you are checking to see if the element has been found. If you reach the end, then you know the element is not found

- Template 2 (left biased)
  - (left < right)
    - An advanced way to implement Binary Search.
    - Search Condition needs to access element's immediate right neighbor
    - Use element's right neighbor to determine if condition is met and decide whether to go left or right
    - Gurantees Search Space is at least 2 in size at each step
    - Post-processing required. Loop/Recursion ends when you have 1 element left. Need to assess if the remaining element meets the condition.

- Template 3 (right biased)
  - (left + 1 < right)
    - An alternative way to implement Binary Search
    - Search Condition needs to access element's immediate left and right neighbors
    - Use element's neighbors to determine if condition is met and decide whether to go left or right
    - Gurantees Search Space is at least 3 in size at each step
    - Post-processing required. Loop/Recursion ends when you have 2 elements left. Need to assess if the remaining elements meet the condition.


 # Time and Space Complexity
 - Time 

    Runtime: O(log n) -- Logorithmic Time

Because Binary Search operates by applying a condition to the value in the middle of our search space and thus cutting the search space in half, in the worse case, we will have to make O(log n) comparisons, where n is the number of elements in our collection.

    Why log n?

        Binary search is performed by dividing the existing array in half.
        So every time you a call the subroutine ( or complete one iteration ) the size reduced to half of the existing part.
        First N become N/2, then it become N/4 and go on till it find the element or size become 1.
        The maximum no of iterations is log N (base 2).



- Space 

    Space: O(1) -- Constant Space

Although, Binary Search does require keeping track of 3 indicies, the iterative solution does not typically require any other additional space and can be applied directly on the collection itself, therefore warrants O(1) or constant space.


<b>common strategy</b> is to compare the mid with mid+1 or mid-1 to find the slope.
- is it ascending ? that means we need to search between mid(left+1) & right
- is it descending ? well, lets focus on left subarray left, mid(right = mid)