/*
    Problem: Leetcode.1570 Dot Product of Two Sparse Vectors (Easy)
    Given two sparse vectors, compute their dot product.
    Implement class SparseVector:    
    SparseVector(nums) Initializes the object with the vector nums
    dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
    A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.
    
    Follow up: What if only one of the vectors is sparse?     
    
    Example 1:    
    Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
    Output: 8
    Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
    v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
    
    Example 2:    
    Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
    Output: 0
    Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
    v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
    
    Example 3:    
    Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
    Output: 6
    --------------------------------------------------------------------------------------------------------------------------------
    
    ------------------------------------------------------ Time Complexity: O(n) ---------------------------------------------------
    ------------------------------------------------------ Space Complexity: O(n) ---------------------------------------------------
*/

public class DotProductSparseVectors {
    int[] nums;
    
    DotProductSparseVectors(int[] nums) {
      this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec)
    {
      int result=0;
        for(int i=0; i< this.nums.length; i++)
        {
            result +=(this.nums[i]* vec.nums[i]);
        }
        return result;
    }
  }

// ------------------------------------------------------ Approach 2: Two pointers -------------------------------------------------
// ------------------------------------------------------ Time Complexity: O(n) ---------------------------------------------------
// ------------------------------------------------------ Space Complexity: O(L) L = no. of non zero elements------------------------

public class DotProductSparseVectors{
    List<int[]> pairs;
    
    DotProductSparseVectors(int[] nums){
      this.pairs = new ArrayList<>();

        for(int i =0; i<nums.length; i++)
        {
            if(nums[i] != 0)
            {
                pairs.add(new int[]{i,nums[i]});
            }
        }      
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec)
    {
      int result =0;
        int p =0,q=0;

        while(p<this.pairs.size() && q<vec.pairs.size())
        {
            if(this.pairs.get(p)[0]== vec.pairs.get(q)[0])
            {
                result += this.pairs.get(p)[1] * vec.pairs.get(q)[1];
                p++;
                q++;
            }
            else if(this.pairs.get(p)[0] < vec.pairs.get(q)[0])
            {
                p++;
            }
            else
            {
                q++;
            }
        }

        return result;
    }
  }













