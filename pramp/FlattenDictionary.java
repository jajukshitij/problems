/*
    Problem: Flatten a Dictionary
    A dictionary is a type of data structure that is supported natively in all major interpreted languages such as JavaScript, Python, Ruby and PHP, where it’s known as an Object, Dictionary, Hash and Array, respectively.
    In simple terms, a dictionary is a collection of unique keys and their values.
    The values can typically be of any primitive type (i.e an integer, boolean, double, string etc) or other dictionaries (dictionaries can be nested).
    However, for this exercise assume that values are either an integer, a string or another dictionary.
    Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it .

    If you’re using a compiled language such Java, C++, C#, Swift and Go, you may want to use a Map/Dictionary/Hash Table 
    that maps strings (keys) to a generic type (e.g. Object in Java, AnyObject in Swift etc.) to allow nested dictionaries.
    If a certain key is empty, it should be excluded from the output (see e in the example below).

    Example:
    input:  dict = {
                "Key1" : "1",
                "Key2" : {
                    "a" : "2",
                    "b" : "3",
                    "c" : {
                        "d" : "3",
                        "e" : {
                            "" : "1"
                        }
                    }
                }
            }
    output: {
                "Key1" : "1",
                "Key2.a" : "2",
                "Key2.b" : "3",
                "Key2.c.d" : "3",
                "Key2.c.e" : "1"
            }
    Important: when you concatenate keys, make sure to add the dot character between them.
    For instance concatenating Key2, c and d the result key would be Key2.c.d
    ------------------------------------------------------------------------------------------------------------------------------------
    ----------------------------------------------------- Time Complexity: O(N) --------------------------------------------------------
                                                                           N = number of keys in the dictionary
*/

import java.util.HashMap;
import java.util.Map;

public class FlattenDictionary {

        public static Map<String,String> flattenDictionary(Map<String,Object> dictionary){

            Map<String,String> result = new HashMap<>();
            helper("",dictionary,result);

            return result;
        }

        public static void helper(String prev_key, Map<String,Object> dictionary, Map<String,String> result){

            for(String key: dictionary.keySet()){

                Object value = dictionary.get(key);

                if(value instanceof String) {
                    if (prev_key == null || prev_key.equals("")) {
                        result.put(key, String.valueOf(value));
                    } else {
                        if(key == null || key.equals("")) {
                            result.put(prev_key, String.valueOf(value));
                        }else{
                            result.put(prev_key + "." + key, String.valueOf(value));
                        }
                    }
                } else{
                    if (prev_key == null || prev_key.equals("")) {
                        helper(key,(HashMap<String, Object>) value,result);
                    } else {
                        helper(prev_key + "." + key,(HashMap<String, Object>) value,result);
                    }
                }
            }
        }
        
        public static void main(String[] args){
            Map<String, Object> dictionary = new HashMap<>();
            dictionary.put("key1", "1");
            dictionary.put("key2", new HashMap<>());
            ((Map) dictionary.get("key2")).put("a", "2");
            ((Map) dictionary.get("key2")).put("b", "3");
            ((Map) dictionary.get("key2")).put("c", new HashMap<>());
            ((Map) ((Map) dictionary.get("key2")).get("c")).put("d", "3");
            ((Map) ((Map) dictionary.get("key2")).get("c")).put("e",new HashMap<>());
            ((Map) ((Map) ((Map) dictionary.get("key2")).get("c")).get("e")).put("","1");

            for(String key : dictionary.keySet()) {
                System.out.println(key + " : " + dictionary.get(key));
            }

            Map<String, String> result = flattenDictionary(dictionary);

            System.out.println("----------------Flattened------------------");
            for(String key : result.keySet()) {
                System.out.println(key + " : " + result.get(key));
            }
        }
}
