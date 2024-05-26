/*
Imagine you are shopping on Amazon.com for some good weight lifting equipment.The equipment you want has blocks of many different weights that you can combine to lift.
The listing on Amazon gives you an array, blocks, that consists of n different weighted blocks, in kilograms.
There are no two blocks with the same weight. The element blocks[i] denotes the weight of the ith block from the top of the stack.
You consider weight lifting equipment to be good if the block at the top is the lightest, and the block at the bottom is the heaviest.
More formally, the equipment with array blocks will be called good weight lifting equipment if it satisfies the following conditions 
(assuming the index of the array starts from 1): blocks[1] < blocks[i] for all (2 ≤ i ≤ n) blocks[i] < blocks[n] for all (1 ≤ i ≤ n-1) 
In one move, you can swap the order of adjacent blocks. Find out the minimum number of moves required to form good weight lifting equipment. 
Example Let the blocks be in the order: blocks = [3, 2, 1] In the first move, we swap the first and the second blocks. 
After swapping, the order becomes: blocks = [2, 3, 1] In the second move, we swap the second and the third blocks. 
After swapping, the order becomes: blocks = [2, 1, 3] In the third move, we swap the first and the second blocks. 
After swapping, the order becomes: blocks = [1, 2, 3] Now, the array satisfies the condition after 3 moves. 
Function Description Complete the function getMinNumMoves in the editor below. 
getMinNumMoves has the following parameter: int blocks[n]: the distinct weights Returns int : 
the minimum number of operations required Constraints 2 ≤ n ≤ 105 1 ≤ blocks[i] ≤ 109 for all (1 ≤ i ≤ n) blocks consists of distinct integers. 
*/

public class AmazonOAMinSwaps{
  
}
